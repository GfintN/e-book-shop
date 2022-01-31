package by.it.academy.enterprise.service.services.dao.mongo;

import by.it.academy.enterprise.entity.mongodb.UserBuying;
import by.it.academy.enterprise.service.services.dao.base.BaseServiceMc;
import by.it.academy.example.persistence.dao.impl.mongodb.UserBuyingDAOImpl;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserBuyingService implements BaseServiceMc {
    @Autowired
    UserBuyingDAOImpl userBuyingDAO;
    @Autowired
    UserBuying userBuying;

    @Override
    public void add(BasicDBObject document) {
        userBuyingDAO.add(userBuyingDAO.getCollectionName(),
                userBuyingDAO.getSeqIdName(), userBuyingDAO.getSeqName(), document);
    }

    @Override
    public void update(Document oldDocument, Document newDocument) {
        userBuyingDAO.update(oldDocument, newDocument);
    }

    @Override
    public Document get(Document document) {
        return userBuyingDAO.get(document);
    }

    @Override
    public List<DBObject> getAll(BasicDBObject document) {
        return userBuyingDAO.getAll(userBuyingDAO.getCollectionName(), document);
    }

    @Override
    public List<DBObject> getAllCollection() {
        return userBuyingDAO.getAllCollection(userBuyingDAO.getCollectionName());
    }

    @Override
    public void delete(String columnName, String columnValue) {
        userBuyingDAO.delete(columnName, columnValue);
    }

    @Override
    public void setUserMc(String userName) {
        userBuyingDAO.setMongoClient(userBuyingDAO.getUserBeanMc(userName));
    }

    @Override
    public void setCollectionNameMc(String collectionName) {
        userBuyingDAO.setDefaultMongoDatabase();
        userBuyingDAO.setMongoCollection(userBuyingDAO.getMongoDatabase().getCollection(collectionName));
    }
    @Override
    public List<DBObject> getWareId(Long whereIdMin, Long whereIdMax) {
        return userBuyingDAO.getWareId(whereIdMin, whereIdMax, userBuyingDAO.getCollectionName());
    }
    public Document setAllParamDoc(String username, List<String> booksList){
        Document document = new Document();
        document.append(userBuying.getUser(),username)
                .append(userBuying.getBooksList(),booksList.toArray());
        return document;
    }
    public BasicDBObject setAllParamBasicM(String username, List<String> booksList){
        BasicDBObject document = new BasicDBObject();
        document.append(userBuying.getUser(),username)
                .append(userBuying.getBooksList(),booksList.toArray());
        return document;
    }
}
