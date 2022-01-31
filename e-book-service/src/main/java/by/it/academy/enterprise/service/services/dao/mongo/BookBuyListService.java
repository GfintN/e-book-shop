package by.it.academy.enterprise.service.services.dao.mongo;

import by.it.academy.enterprise.entity.mongodb.BookBuyList;
import by.it.academy.enterprise.service.services.dao.base.BaseServiceCreationMc;
import by.it.academy.example.persistence.dao.impl.mongodb.BookBuyListDAOImpl;
import by.it.academy.example.persistence.dao.util.MongoDropCreateCollection;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BookBuyListService implements BaseServiceCreationMc {
    @Autowired
    BookBuyListDAOImpl bookBuyListDAO;
    @Autowired
    BookBuyList bookBuyList;

    @Override
    public void add(String collectionName, String idName, String seqName, BasicDBObject document) {
        bookBuyListDAO.add(collectionName,idName,seqName,document);
    }

    @Override
    public void update(Document oldDocument, Document newDocument) {
        bookBuyListDAO.update(oldDocument,newDocument);
    }

    @Override
    public Document get(Document document) {
        return bookBuyListDAO.get(document);
    }

    @Override
    public List<DBObject> getAll(String collectionName, BasicDBObject document) {
        return bookBuyListDAO.getAll(collectionName,document);
    }

    @Override
    public List<DBObject> getAllCollection(String collectionName) {
        return bookBuyListDAO.getAllCollection(collectionName);
    }

    @Override
    public void delete(String columnName, String columnValue) {
        bookBuyListDAO.delete(columnName, columnValue);
    }

    @Override
    public void createCollection(String collectionName) {
        MongoDropCreateCollection mongoDropCreateCollection = new MongoDropCreateCollection();
        mongoDropCreateCollection.createCollection(collectionName, bookBuyListDAO.getMongoDatabase());
    }

    @Override
    public void dropCollection(String collectionName) {
        MongoDropCreateCollection mongoDropCreateCollection = new MongoDropCreateCollection();
        mongoDropCreateCollection.delCollection(collectionName, bookBuyListDAO.getMongoDatabase());
    }

    @Override
    public void setUserMc(String userName) {
        bookBuyListDAO.setMongoClient(bookBuyListDAO.getUserBeanMc(userName));
    }

    @Override
    public void setCollectionNameMc(String collectionName) {
        bookBuyListDAO.setDefaultMongoDatabase();
        bookBuyListDAO.setMongoCollection(bookBuyListDAO.getMongoDatabase().getCollection(collectionName));
    }
    @Override
    public List<DBObject> getWareId(Long whereIdMin, Long whereIdMax, String colName) {
        return bookBuyListDAO.getWareId(whereIdMin, whereIdMax, colName);
    }
    public Document setAllParamDoc(String bookId){
        Document document = new Document();
        document.append(bookBuyList.getBookId(), bookId);
        return document;
    }
    public BasicDBObject setAllParamBasicM(String bookId){
        BasicDBObject document = new BasicDBObject();
        document.append(bookBuyList.getBookId(), bookId);
        return document;
    }


}
