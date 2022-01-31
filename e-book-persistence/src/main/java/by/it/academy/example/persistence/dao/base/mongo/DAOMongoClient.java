package by.it.academy.example.persistence.dao.base.mongo;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import org.bson.Document;

import java.util.List;

public interface DAOMongoClient {
    void add(String collectionName, String idName, String seqName, BasicDBObject document);
    void update(Document oldDocument, Document newDocument);
    List<DBObject> getWareId(Long whereIdMin, Long whereIdMax, String colName);
    Document get(Document document);
    List<DBObject> getAll(String collectionName,BasicDBObject document);
    List<DBObject> getAllCollection(String collectionName);
    void delete(String columnName, String columnValue);
}
