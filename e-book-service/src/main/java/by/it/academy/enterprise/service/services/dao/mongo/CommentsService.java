package by.it.academy.enterprise.service.services.dao.mongo;

import by.it.academy.enterprise.entity.mongodb.Comments;
import by.it.academy.enterprise.service.services.dao.base.BaseServiceCreationMc;
import by.it.academy.example.persistence.dao.impl.mongodb.CommentsDAOImpl;
import by.it.academy.example.persistence.dao.util.MongoDropCreateCollection;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CommentsService implements BaseServiceCreationMc {
    @Autowired
    CommentsDAOImpl commentsDAO;
    @Autowired
    Comments comments;

    @Override
    public void add(String collectionName, String idName, String seqName, BasicDBObject document) {
        commentsDAO.add(collectionName,idName,seqName,document);
    }

    @Override
    public void update(Document oldDocument, Document newDocument) {
        commentsDAO.update(oldDocument,newDocument);
    }

    @Override
    public Document get(Document document) {
        return commentsDAO.get(document);
    }

    @Override
    public List<DBObject> getAll(String collectionName, BasicDBObject document) {
        return commentsDAO.getAll(collectionName,document);
    }

    @Override
    public List<DBObject> getAllCollection(String collectionName) {
        return commentsDAO.getAllCollection(collectionName);
    }

    @Override
    public void delete(String columnName, String columnValue) {
        commentsDAO.delete(columnName, columnValue);
    }

    @Override
    public void createCollection(String collectionName) {
        MongoDropCreateCollection mongoDropCreateCollection = new MongoDropCreateCollection();
        mongoDropCreateCollection.createCollection(collectionName, commentsDAO.getMongoDatabase());
    }

    @Override
    public void dropCollection(String collectionName) {
        MongoDropCreateCollection mongoDropCreateCollection = new MongoDropCreateCollection();
        mongoDropCreateCollection.delCollection(collectionName, commentsDAO.getMongoDatabase());
    }

    @Override
    public void setUserMc(String userName) {
        commentsDAO.setMongoClient(commentsDAO.getUserBeanMc(userName));
    }

    @Override
    public void setCollectionNameMc(String collectionName) {
        commentsDAO.setDefaultMongoDatabase();
        commentsDAO.setMongoCollection(commentsDAO.getMongoDatabase().getCollection(collectionName));
    }
    @Override
    public List<DBObject> getWareId(Long whereIdMin, Long whereIdMax, String colName) {
        return commentsDAO.getWareId(whereIdMin, whereIdMax, colName);
    }
    public Document setAllParamDoc(String username, LocalDateTime dateCreate, String comment){
        Document document = new Document();
        document.append(comments.getUsername(),username)
                .append(comments.getDateOfComment(),dateCreate)
                .append(comments.getComment(),comment);
        return document;
    }
    public BasicDBObject setAllParamBasicM(String username, LocalDateTime dateCreate, String comment){
        BasicDBObject document = new BasicDBObject();
        document.append(comments.getUsername(),username)
                .append(comments.getDateOfComment(),dateCreate)
                .append(comments.getComment(),comment);
        return document;
    }
}
