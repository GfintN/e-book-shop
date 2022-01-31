package by.it.academy.example.persistence.dao.util;

import com.mongodb.*;
import org.springframework.stereotype.Component;

@Component
public class SequenceMongo {

    public Object getNextSequence(String seqIdName, String seqName, MongoClient mongoClient) {
        DB database = mongoClient.getDB("e-shop-users");
        DBCollection countersCollection = database.getCollection("counters");
        BasicDBObject searchQuery = new BasicDBObject("_id", seqIdName);
        BasicDBObject increase = new BasicDBObject(seqName, 1);
        BasicDBObject updateQuery = new BasicDBObject("$inc", increase);
        DBObject result = countersCollection.findAndModify(searchQuery, null, null,
                false, updateQuery, true, false);
        return result.get(seqName);
    }

}
