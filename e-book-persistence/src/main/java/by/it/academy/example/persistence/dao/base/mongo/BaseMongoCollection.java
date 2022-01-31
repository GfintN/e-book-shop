package by.it.academy.example.persistence.dao.base.mongo;

import by.it.academy.example.persistence.configure.PersistenceContext;
import by.it.academy.example.persistence.dao.util.SequenceMongo;
import com.mongodb.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class BaseMongoCollection implements DAOMongoClient {

    private MongoClient mongoClient;
    private MongoDatabase mongoDatabase;
    private MongoCollection<Document> mongoCollection;

    @Override
    public void add(String collectionName, String seqIdName, String seqName, BasicDBObject document) {
        DB db = getMongoClient().getDB("e-shop-users");
        DBCollection coll = db.getCollection(collectionName);
        document.append("_id", new SequenceMongo().getNextSequence(seqIdName, seqName, getMongoClient()));
        coll.insert(document);
    }

    @Override
    public void update(Document oldDocument, Document newDocument) {
    getMongoCollection().updateOne(oldDocument, newDocument);
    }

    @Override
    public Document get(Document document) {
        return getMongoCollection().find(document).first();
    }

    @Override
    public List<DBObject> getWareId(Long whereIdMin, Long whereIdMax, String colName) {
        DB db = getMongoClient().getDB("e-shop-users");
        DBCollection coll = db.getCollection(colName);
        BasicDBObject gtQuery = new BasicDBObject();
        if ( whereIdMin != null && whereIdMax != null){
            gtQuery.put("_id", new BasicDBObject("$gt", whereIdMin).append("$lt", whereIdMax));
            DBCursor cursor = coll.find(gtQuery);
            return cursor.toArray();
        }else if(whereIdMin == null){
            gtQuery.put("_id", new BasicDBObject("$lt", whereIdMax));
            DBCursor cursor = coll.find(gtQuery);
            return cursor.toArray();
        }
        else if(whereIdMax == null){
            gtQuery.put("_id", new BasicDBObject("$gt", whereIdMin));
            DBCursor cursor = coll.find(gtQuery);
            return cursor.toArray();
        }
        else {
            return null;
        }
    }

    @Override
    public List<DBObject> getAllCollection(String collectionName) {
        DB db = getMongoClient().getDB("e-shop-users");
        DBCollection coll = db.getCollection(collectionName);
        return coll.find().toArray();
    }

    @Override
    public List<DBObject> getAll(String collectionName, BasicDBObject document) {
        DB db = getMongoClient().getDB("e-shop-users");
        DBCollection coll = db.getCollection(collectionName);
        return coll.find(document).toArray();
    }

    @Override
    public void delete(String columnName, String columnValue) {
        getMongoCollection().deleteOne(Filters.eq(columnName, columnValue));
    }

    public MongoClient getUserBeanMc(String beanName){
        switch (beanName) {
            case ("admin"):
                ApplicationContext applicationContextAdmin = new AnnotationConfigApplicationContext(PersistenceContext.class);
                 return applicationContextAdmin.getBean("mongoClientAdmin", MongoClient.class);

            case ("sub_admin"):
                ApplicationContext applicationContextSubAdmin = new AnnotationConfigApplicationContext(PersistenceContext.class);
                return applicationContextSubAdmin.getBean("mongoClientSubAdmin", MongoClient.class);

            case ("users"):
                ApplicationContext applicationContextUsers = new AnnotationConfigApplicationContext(PersistenceContext.class);
                return applicationContextUsers.getBean("mongoClientUsers", MongoClient.class);

            case ("system"):
                ApplicationContext applicationContextSystem = new AnnotationConfigApplicationContext(PersistenceContext.class);
                return applicationContextSystem.getBean("mongoClientSystem", MongoClient.class);
            default:
                return null;
        }
    }


    public MongoClient getMongoClient() {
        return mongoClient;
    }

    public void setMongoClient(MongoClient mongoClient) {
        this.mongoClient = mongoClient;
    }

    public MongoDatabase getMongoDatabase() {
        return mongoDatabase;
    }

    public void setMongoDatabase(MongoDatabase mongoDatabase) {
        this.mongoDatabase = mongoDatabase;
    }

    public void setDefaultMongoDatabase() {
        this.mongoDatabase = getMongoClient().getDatabase("e-shop-users");
    }

    public MongoCollection<Document> getMongoCollection() {
        return mongoCollection;
    }

    public void setMongoCollection(MongoCollection<Document> mongoCollection) {
        this.mongoCollection = mongoCollection;
    }

}
