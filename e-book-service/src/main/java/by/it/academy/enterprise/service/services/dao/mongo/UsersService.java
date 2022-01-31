package by.it.academy.enterprise.service.services.dao.mongo;

import by.it.academy.enterprise.entity.mongodb.Users;
import by.it.academy.enterprise.service.services.dao.base.BaseServiceMc;
import by.it.academy.example.persistence.dao.impl.mongodb.UsersDAOImpl;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService implements BaseServiceMc {
    @Autowired
    UsersDAOImpl usersDAO;
    @Autowired
    Users users;

    @Override
    public void add(BasicDBObject document) {
        usersDAO.add(usersDAO.getCollectionName(),
                usersDAO.getSeqIdName(), usersDAO.getSeqName(), document);
    }

    @Override
    public void update(Document oldDocument, Document newDocument) {
        usersDAO.update(oldDocument, newDocument);
    }

    @Override
    public Document get(Document document) {
        return usersDAO.get(document);
    }

    @Override
    public List<DBObject> getAll(BasicDBObject document) {
        return usersDAO.getAll(usersDAO.getCollectionName(), document);
    }

    @Override
    public List<DBObject> getAllCollection() {
        return usersDAO.getAllCollection(usersDAO.getCollectionName());
    }

    @Override
    public void delete(String columnName, String columnValue) {
        usersDAO.delete(columnName, columnValue);
    }

    @Override
    public void setUserMc(String userName) {
        usersDAO.setMongoClient(usersDAO.getUserBeanMc(userName));
    }

    @Override
    public void setCollectionNameMc(String collectionName) {
        usersDAO.setDefaultMongoDatabase();
        usersDAO.setMongoCollection(usersDAO.getMongoDatabase().getCollection(collectionName));
    }
    @Override
    public List<DBObject> getWareId(Long whereIdMin, Long whereIdMax) {
        return usersDAO.getWareId(whereIdMin, whereIdMax, usersDAO.getCollectionName());
    }
    public Document setAllParamDoc(String mail, String username, String password, String status){
        Document document = new Document();
        document.append(users.getMail(),mail)
                .append(users.getUsername(),username)
                .append(users.getPassword(),password)
                .append(users.getStatus(),status);
        return document;
    }
    public BasicDBObject setAllParamBasicM(String mail, String username, String password, String status){
        BasicDBObject document = new BasicDBObject();
        document.append(users.getMail(),mail)
                .append(users.getUsername(),username)
                .append(users.getPassword(),password)
                .append(users.getStatus(),status);
        return document;
    }
}
