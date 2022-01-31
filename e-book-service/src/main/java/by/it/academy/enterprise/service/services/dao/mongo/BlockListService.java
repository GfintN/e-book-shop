package by.it.academy.enterprise.service.services.dao.mongo;

import by.it.academy.enterprise.entity.mongodb.BlockList;
import by.it.academy.enterprise.service.services.dao.base.BaseServiceMc;
import by.it.academy.example.persistence.dao.impl.mongodb.BlockListDAOImpl;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BlockListService implements BaseServiceMc {
    @Autowired
    BlockListDAOImpl blockListDAO;
    @Autowired
    BlockList blockList;

    @Override
    public void add(BasicDBObject document) {
        blockListDAO.add(blockListDAO.getCollectionName(),
                blockListDAO.getSeqIdName(), blockListDAO.getSeqName(), document);
    }

    @Override
    public void update(Document oldDocument, Document newDocument) {
        blockListDAO.update(oldDocument, newDocument);
    }

    @Override
    public Document get(Document document) {
        return blockListDAO.get(document);
    }

    @Override
    public List<DBObject> getAll(BasicDBObject document) {
        return blockListDAO.getAll(blockListDAO.getCollectionName(), document);
    }

    @Override
    public List<DBObject> getAllCollection() {
        return blockListDAO.getAllCollection(blockListDAO.getCollectionName());
    }

    @Override
    public void delete(String columnName, String columnValue) {
        blockListDAO.delete(columnName, columnValue);
    }

    @Override
    public void setUserMc(String userName) {
        blockListDAO.setMongoClient(blockListDAO.getUserBeanMc(userName));
    }

    @Override
    public void setCollectionNameMc(String collectionName) {
        blockListDAO.setDefaultMongoDatabase();
        blockListDAO.setMongoCollection(blockListDAO.getMongoDatabase().getCollection(collectionName));
    }
    @Override
    public List<DBObject> getWareId(Long whereIdMin, Long whereIdMax) {
        return blockListDAO.getWareId(whereIdMin, whereIdMax, blockListDAO.getCollectionName());
    }
    public Document setAllParamDoc(String userName, String reason, LocalDateTime dateStartBlock, LocalDateTime dateEndBlock){
        Document document = new Document();
        document.append(blockList.getUserName(),userName)
                .append(blockList.getDateEndBlock(),dateEndBlock)
                .append(blockList.getDateStartBlock(),dateStartBlock)
                .append(blockList.getReasonForBlocking(),reason);
        return document;
    }

    public BasicDBObject setAllParamBasicM(String userName, String reason, LocalDateTime dateStartBlock, LocalDateTime dateEndBlock){
        BasicDBObject document = new BasicDBObject();
        document.append(blockList.getUserName(),userName)
                .append(blockList.getDateEndBlock(),dateEndBlock)
                .append(blockList.getDateStartBlock(),dateStartBlock)
                .append(blockList.getReasonForBlocking(),reason);
        return document;
    }
}
