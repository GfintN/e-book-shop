package by.it.academy.enterprise.service.services.dao.base;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import org.bson.Document;

import java.util.List;

public interface BaseServiceMc {
    void add(BasicDBObject document);
    void update(Document oldDocument, Document newDocument);
    Document get(Document document);
    List<DBObject> getWareId(Long whereIdMin, Long whereIdMax);
    List<DBObject> getAll(BasicDBObject document);
    List<DBObject> getAllCollection();
    void delete(String columnName, String columnValue);
    void setUserMc(String userName);
    void setCollectionNameMc(String collectionName);
}
