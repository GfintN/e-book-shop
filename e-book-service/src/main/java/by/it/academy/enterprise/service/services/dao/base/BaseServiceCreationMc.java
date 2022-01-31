package by.it.academy.enterprise.service.services.dao.base;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import org.bson.Document;

import java.util.List;

public interface BaseServiceCreationMc {
    void add(String collectionName, String idName, String seqName, BasicDBObject document);
    void update(Document oldDocument, Document newDocument);
    Document get(Document document);
    List<DBObject> getWareId(Long whereIdMin, Long whereIdMax, String colName);
    List<DBObject> getAll(String collectionName, BasicDBObject document);
    List<DBObject> getAllCollection(String collectionName);
    void delete(String columnName, String columnValue);
    void createCollection(String collectionName);
    void dropCollection(String collectionName);
    void setUserMc(String userName);
    void setCollectionNameMc(String collectionName);
}
