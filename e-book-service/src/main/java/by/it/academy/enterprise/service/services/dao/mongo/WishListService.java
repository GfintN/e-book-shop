package by.it.academy.enterprise.service.services.dao.mongo;

import by.it.academy.enterprise.entity.mongodb.WIshList;
import by.it.academy.enterprise.service.services.dao.base.BaseServiceMc;
import by.it.academy.example.persistence.dao.impl.mongodb.WishListDAOImpl;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WishListService implements BaseServiceMc {
    @Autowired
    WishListDAOImpl wishListDAO;
    @Autowired
    WIshList wIshList;

    @Override
    public void add(BasicDBObject document) {
        wishListDAO.add(wishListDAO.getCollectionName(),
                wishListDAO.getSeqIdName(), wishListDAO.getSeqName(), document);
    }

    @Override
    public void update(Document oldDocument, Document newDocument) {
        wishListDAO.update(oldDocument, newDocument);
    }

    @Override
    public Document get(Document document) {
        return wishListDAO.get(document);
    }

    @Override
    public List<DBObject> getAll(BasicDBObject document) {
        return wishListDAO.getAll(wishListDAO.getCollectionName(), document);
    }

    @Override
    public List<DBObject> getAllCollection() {
        return wishListDAO.getAllCollection(wishListDAO.getCollectionName());
    }

    @Override
    public void delete(String columnName, String columnValue) {
        wishListDAO.delete(columnName, columnValue);
    }

    @Override
    public void setUserMc(String userName) {
        wishListDAO.setMongoClient(wishListDAO.getUserBeanMc(userName));
    }

    @Override
    public void setCollectionNameMc(String collectionName) {
        wishListDAO.setDefaultMongoDatabase();
        wishListDAO.setMongoCollection(wishListDAO.getMongoDatabase().getCollection(collectionName));
    }

    @Override
    public List<DBObject> getWareId(Long whereIdMin, Long whereIdMax) {
        return wishListDAO.getWareId(whereIdMin, whereIdMax, wishListDAO.getCollectionName());
    }
    public Document setAllParamDoc(String username, List<String> wishList){
        Document document = new Document();
        document.append(wIshList.getUser(),username)
                .append(wIshList.getWishList(),wishList.toArray());
        return document;
    }
    public BasicDBObject setAllParamBasicM(String username, List<String> wishList){
        BasicDBObject document = new BasicDBObject();
        document.append(wIshList.getUser(),username)
                .append(wIshList.getWishList(),wishList.toArray());
        return document;
    }

}
