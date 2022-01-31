package by.it.academy.enterprise.service.services.dao.mongo;

import by.it.academy.enterprise.entity.mongodb.Code;
import by.it.academy.enterprise.service.services.dao.base.BaseServiceCreationMc;
import by.it.academy.example.persistence.dao.impl.mongodb.CodeDAOImpl;
import by.it.academy.example.persistence.dao.util.MongoDropCreateCollection;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CodeService implements BaseServiceCreationMc {
    @Autowired
    CodeDAOImpl codeDAO;
    @Autowired
    Code code;

    @Override
    public void add(String collectionName, String idName, String seqName, BasicDBObject document) {
        codeDAO.add(collectionName,idName,seqName,document);
    }

    @Override
    public void update(Document oldDocument, Document newDocument) {
        codeDAO.update(oldDocument,newDocument);
    }

    @Override
    public Document get(Document document) {
        return codeDAO.get(document);
    }

    @Override
    public List<DBObject> getAll(String collectionName, BasicDBObject document) {
        return codeDAO.getAll(collectionName,document);
    }

    @Override
    public List<DBObject> getAllCollection(String collectionName) {
        return codeDAO.getAllCollection(collectionName);
    }

    @Override
    public void delete(String columnName, String columnValue) {
         codeDAO.delete(columnName, columnValue);
    }

    @Override
    public void createCollection(String collectionName) {
        MongoDropCreateCollection mongoDropCreateCollection = new MongoDropCreateCollection();
        mongoDropCreateCollection.createCollection(collectionName, codeDAO.getMongoDatabase());
    }

    @Override
    public void dropCollection(String collectionName) {
        MongoDropCreateCollection mongoDropCreateCollection = new MongoDropCreateCollection();
        mongoDropCreateCollection.delCollection(collectionName, codeDAO.getMongoDatabase());
    }

    @Override
    public void setUserMc(String userName) {
        codeDAO.setMongoClient(codeDAO.getUserBeanMc(userName));
    }

    @Override
    public void setCollectionNameMc(String collectionName) {
        codeDAO.setDefaultMongoDatabase();
        codeDAO.setMongoCollection(codeDAO.getMongoDatabase().getCollection(collectionName));
    }
    @Override
    public List<DBObject> getWareId(Long whereIdMin, Long whereIdMax, String colName) {
        return codeDAO.getWareId(whereIdMin, whereIdMax, colName);
    }
    public Document setAllParamDoc(String codeName, String username){
        Document document = new Document();
        document.append(code.getCode(),codeName)
                .append(code.getOwner(), username);
        return document;
    }
    public BasicDBObject setAllParamBasicM(String codeName, String username){
        BasicDBObject document = new BasicDBObject();
        document.append(code.getCode(),codeName)
                .append(code.getOwner(), username);
        return document;
    }
}
