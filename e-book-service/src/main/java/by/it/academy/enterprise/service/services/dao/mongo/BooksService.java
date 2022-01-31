package by.it.academy.enterprise.service.services.dao.mongo;

import by.it.academy.enterprise.entity.mongodb.Books;
import by.it.academy.enterprise.service.services.dao.base.BaseServiceMc;
import by.it.academy.example.persistence.dao.impl.mongodb.BooksDAOImpl;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BooksService implements BaseServiceMc {
    @Autowired
    BooksDAOImpl booksDAO;
    @Autowired
    Books books;

    @Override
    public void add(BasicDBObject document) {
        booksDAO.add(booksDAO.getCollectionName(),
                booksDAO.getSeqIdName(), booksDAO.getSeqName(), document);
    }

    @Override
    public void update(Document oldDocument, Document newDocument) {
        booksDAO.update(oldDocument, newDocument);
    }

    @Override
    public Document get(Document document) {
        return booksDAO.get(document);
    }

    @Override
    public List<DBObject> getAll(BasicDBObject document) {
        return booksDAO.getAll(booksDAO.getCollectionName(), document);
    }

    @Override
    public List<DBObject> getAllCollection() {
        return booksDAO.getAllCollection(booksDAO.getCollectionName());
    }

    @Override
    public void delete(String columnName, String columnValue) {
        booksDAO.delete(columnName, columnValue);
    }

    @Override
    public void setUserMc(String userName) {
        booksDAO.setMongoClient(booksDAO.getUserBeanMc(userName));
    }

    @Override
    public void setCollectionNameMc(String collectionName) {
        booksDAO.setDefaultMongoDatabase();
        booksDAO.setMongoCollection(booksDAO.getMongoDatabase().getCollection(collectionName));
    }
    @Override
    public List<DBObject> getWareId(Long whereIdMin, Long whereIdMax) {
        return booksDAO.getWareId(whereIdMin, whereIdMax, booksDAO.getCollectionName());
    }
    public Document setAllParamDoc(String bookName, String bookLoadPath){
        Document document = new Document();
        document.append(books.getBookName(), bookName)
                .append(books.getLoadPath(), bookLoadPath);
        return document;
    }
    public BasicDBObject setAllParamBasicM(String bookName, String bookLoadPath, String bookCost){
        BasicDBObject document = new BasicDBObject();
        document.append(books.getBookName(), bookName)
                .append(books.getLoadPath(), bookLoadPath)
                .append(books.getCost(), bookCost);
        return document;
    }
}
