package by.it.academy.example.persistence.dao.util;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.stereotype.Component;

@Component
public class MongoDropCreateCollection {
    public void delCollection(String collectionName, MongoDatabase database){
        MongoCollection<Document> collection = database.getCollection(collectionName);
        collection.drop();
    }
    public void createCollection(String collectionName, MongoDatabase database){
        database.createCollection(collectionName);
    }
}
