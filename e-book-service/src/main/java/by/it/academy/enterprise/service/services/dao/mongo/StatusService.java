package by.it.academy.enterprise.service.services.dao.mongo;

import by.it.academy.enterprise.entity.mongodb.Status;
import by.it.academy.enterprise.service.services.dao.base.BaseServiceMc;
import by.it.academy.example.persistence.dao.impl.mongodb.StatusDAOImpl;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatusService implements BaseServiceMc {
    @Autowired
    StatusDAOImpl statusDAO;
    @Autowired
    Status status;

    @Override
    public void add(BasicDBObject document) {
        statusDAO.add(statusDAO.getCollectionName(),
                statusDAO.getSeqIdName(), statusDAO.getSeqName(), document);
    }

    @Override
    public void update(Document oldDocument, Document newDocument) {
        statusDAO.update(oldDocument, newDocument);
    }

    @Override
    public Document get(Document document) {
        return statusDAO.get(document);
    }

    @Override
    public List<DBObject> getAll(BasicDBObject document) {
        return statusDAO.getAll(statusDAO.getCollectionName(), document);
    }

    @Override
    public List<DBObject> getAllCollection() {
        return statusDAO.getAllCollection(statusDAO.getCollectionName());
    }

    @Override
    public void delete(String columnName, String columnValue) {
        statusDAO.delete(columnName, columnValue);
    }

    @Override
    public void setUserMc(String userName) {
        statusDAO.setMongoClient(statusDAO.getUserBeanMc(userName));
    }

    @Override
    public void setCollectionNameMc(String collectionName) {
       statusDAO.setDefaultMongoDatabase();
       statusDAO.setMongoCollection(statusDAO.getMongoDatabase().getCollection(collectionName));
    }
    @Override
    public List<DBObject> getWareId(Long whereIdMin, Long whereIdMax) {
        return statusDAO.getWareId(whereIdMin, whereIdMax, statusDAO.getCollectionName());
    }
    public Document setAllParamDoc(String statusName){
        Document document = new Document();
        document.append(status.getStatus(), statusName);
        return document;
    }
    public BasicDBObject setAllParamBasicM(String statusName){
        BasicDBObject document = new BasicDBObject();
        document.append(status.getStatus(), statusName);
        return document;
    }
}
