package by.it.academy.enterprise.service.services.dao.mongo;

import by.it.academy.enterprise.entity.mongodb.AuthorActivities;
import by.it.academy.enterprise.service.services.dao.base.BaseServiceMc;
import by.it.academy.example.persistence.dao.impl.mongodb.AuthorActivitiesDAOImpl;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AuthorActivitiesService implements BaseServiceMc {
    @Autowired
    AuthorActivitiesDAOImpl authorActivitiesDAO;
    @Autowired
    AuthorActivities authorActivities;

    @Override
    public void add(BasicDBObject document) {
        authorActivitiesDAO.add(authorActivitiesDAO.getCollectionName(),
                authorActivitiesDAO.getSeqIdName(), authorActivitiesDAO.getSeqName(), document);
    }

    @Override
    public void update(Document oldDocument, Document newDocument) {
        authorActivitiesDAO.update(oldDocument, newDocument);
    }

    @Override
    public Document get(Document document) {
        return authorActivitiesDAO.get(document);
    }

    @Override
    public List<DBObject> getWareId(Long whereIdMin, Long whereIdMax) {
        return authorActivitiesDAO.getWareId(whereIdMin, whereIdMax, authorActivitiesDAO.getCollectionName());
    }

    @Override
    public List<DBObject> getAll(BasicDBObject document) {
        return authorActivitiesDAO.getAll(authorActivitiesDAO.getCollectionName(), document);
    }

    @Override
    public List<DBObject> getAllCollection() {
        return authorActivitiesDAO.getAllCollection(authorActivitiesDAO.getCollectionName());
    }

    @Override
    public void delete(String columnName, String columnValue) {
        authorActivitiesDAO.delete(columnName, columnValue);
    }

    @Override
    public void setUserMc(String userName) {
       authorActivitiesDAO.setMongoClient(authorActivitiesDAO.getUserBeanMc(userName));
    }

    @Override
    public void setCollectionNameMc(String collectionName) {
        authorActivitiesDAO.setDefaultMongoDatabase();
        authorActivitiesDAO.setMongoCollection(authorActivitiesDAO.getMongoDatabase().getCollection(collectionName));
    }

    public Document setAllParamDoc(String authorId, String address, LocalDateTime dateStart, LocalDateTime dateEnd){
        Document document = new Document();
        document.append(authorActivities.getAuthorId(),authorId)
                .append(authorActivities.getAddress(), address)
                .append(authorActivities.getDateOfEnd(), dateEnd)
                .append(authorActivities.getDateOfStart(), dateStart);
        return document;
    }
    public BasicDBObject setAllParamBasicM(String authorId, String address, LocalDateTime dateStart, LocalDateTime dateEnd){
        BasicDBObject document = new BasicDBObject();
        document.append(authorActivities.getAuthorId(),authorId)
                .append(authorActivities.getAddress(), address)
                .append(authorActivities.getDateOfEnd(), dateEnd)
                .append(authorActivities.getDateOfStart(), dateStart);
        return document;
    }
}
