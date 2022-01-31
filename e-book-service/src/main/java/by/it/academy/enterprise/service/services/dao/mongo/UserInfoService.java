package by.it.academy.enterprise.service.services.dao.mongo;

import by.it.academy.enterprise.entity.mongodb.UserInfo;
import by.it.academy.enterprise.service.services.dao.base.BaseServiceMc;
import by.it.academy.example.persistence.dao.impl.mongodb.UserInfoDAOImpl;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserInfoService implements BaseServiceMc {
    @Autowired
    UserInfoDAOImpl userInfoDAO;
    @Autowired
    UserInfo userInfo;

    @Override
    public void add(BasicDBObject document) {
        userInfoDAO.add(userInfoDAO.getCollectionName(),
                userInfoDAO.getSeqIdName(), userInfoDAO.getSeqName(), document);
    }

    @Override
    public void update(Document oldDocument, Document newDocument) {
        userInfoDAO.update(oldDocument, newDocument);
    }

    @Override
    public Document get(Document document) {
        return userInfoDAO.get(document);
    }

    @Override
    public List<DBObject> getAll(BasicDBObject document) {
        return userInfoDAO.getAll(userInfoDAO.getCollectionName(), document);
    }

    @Override
    public List<DBObject> getAllCollection() {
        return userInfoDAO.getAllCollection(userInfoDAO.getCollectionName());
    }

    @Override
    public void delete(String columnName, String columnValue) {
        userInfoDAO.delete(columnName, columnValue);
    }

    @Override
    public void setUserMc(String userName) {
        userInfoDAO.setMongoClient(userInfoDAO.getUserBeanMc(userName));
    }

    @Override
    public void setCollectionNameMc(String collectionName) {
        userInfoDAO.setDefaultMongoDatabase();
        userInfoDAO.setMongoCollection(userInfoDAO.getMongoDatabase().getCollection(collectionName));
    }
    @Override
    public List<DBObject> getWareId(Long whereIdMin, Long whereIdMax) {
        return userInfoDAO.getWareId(whereIdMin, whereIdMax, userInfoDAO.getCollectionName());
    }
    public Document setAllParamDoc(String username, LocalDateTime dateOfBirth, String firstName, String surName,
                                   String gender, Long money){
        Document document = new Document();
        document.append(userInfo.getUser(),username)
                .append(userInfo.getDateOfBirth(),dateOfBirth)
                .append(userInfo.getFirstName(),firstName)
                .append(userInfo.getSurName(),surName)
                .append(userInfo.getGender(),gender)
                .append(userInfo.getMoney(),money);
        return document;
    }
    public BasicDBObject setAllParamBasicM(String username, LocalDateTime dateOfBirth, String firstName, String surName,
                                   String gender, Long money){
        BasicDBObject document = new BasicDBObject();
        document.append(userInfo.getUser(),username)
                .append(userInfo.getDateOfBirth(),dateOfBirth)
                .append(userInfo.getFirstName(),firstName)
                .append(userInfo.getSurName(),surName)
                .append(userInfo.getGender(),gender)
                .append(userInfo.getMoney(),money);
        return document;
    }

}
