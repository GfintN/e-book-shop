package by.it.academy.example.persistence.dao.impl.mongodb;

import by.it.academy.example.persistence.dao.base.mongo.BaseMongoCollection;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UsersDAOImpl extends BaseMongoCollection {

    public String getSeqName() {
        return "users_seq";
    }

    public String getSeqIdName() {
        return "default_id_seq";
    }

    public String getCollectionName() {
        return "users";
    }

    @Override
    public void add(String collectionName, String seqIdName, String seqName, BasicDBObject document) {
        super.add(collectionName, seqIdName, seqName, document);
    }

    @Override
    public void update(Document oldDocument, Document newDocument) {
        super.update(oldDocument, newDocument);
    }

    @Override
    public Document get(Document document) {
        return super.get(document);
    }

    @Override
    public List<DBObject> getAll(String collectionName, BasicDBObject document) {
        return super.getAll(collectionName, document);
    }

    @Override
    public void delete(String columnName, String columnValue) {
        super.delete(columnName, columnValue);
    }

    @Override
    public MongoClient getUserBeanMc(String beanName) {
        return super.getUserBeanMc(beanName);
    }

    @Override
    public MongoClient getMongoClient() {
        return super.getMongoClient();
    }

    @Override
    public void setMongoClient(MongoClient mongoClient) {
        super.setMongoClient(mongoClient);
    }

    @Override
    public MongoDatabase getMongoDatabase() {
        return super.getMongoDatabase();
    }

    @Override
    public void setMongoDatabase(MongoDatabase mongoDatabase) {
        super.setMongoDatabase(mongoDatabase);
    }

    @Override
    public void setDefaultMongoDatabase() {
        super.setDefaultMongoDatabase();
    }

    @Override
    public MongoCollection<Document> getMongoCollection() {
        return super.getMongoCollection();
    }

    @Override
    public void setMongoCollection(MongoCollection<Document> mongoCollection) {
        super.setMongoCollection(mongoCollection);
    }

    @Override
    public List<DBObject> getWareId(Long whereIdMin, Long whereIdMax, String colName) {
        return super.getWareId(whereIdMin, whereIdMax, colName);
    }

    @Override
    public List<DBObject> getAllCollection(String collectionName) {
        return super.getAllCollection(collectionName);
    }
}
