package by.it.academy.example.persistence.dao.util;

import by.it.academy.example.persistence.dao.impl.mongodb.AuthorActivitiesDAOImpl;
import com.mongodb.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.stereotype.Component;

@Component
public class MongoFactory {

    public MongoClient getMongoClient(String username, String password) {
            try {
                MongoClient mongo = new MongoClient(new MongoClientURI("mongodb://"+username+":"+password+"@localhost:27017"));
                return mongo;
            } catch (MongoException ex) {
                return null;
            }
    }

    public MongoDatabase getMongoDB(MongoClient mongoClient, String dbName) {
        try {
            MongoDatabase database = mongoClient.getDatabase(dbName);
            return database;
        } catch (MongoException ex) {
            return null;
        }
    }

    public MongoCollection<Document> getMongoCollectionFromName(MongoDatabase database, String collectionName) {
        try {
            MongoCollection<Document> coll = database.getCollection(collectionName);
            return coll;
        } catch (MongoException ex) {
            return null;
        }
    }
}
