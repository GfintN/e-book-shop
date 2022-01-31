package by.it.academy.enterprise.service.services.dao.base;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.List;

public interface BaseServiceEm<T> {
    T add(T t);
    List<T> addAll(List<T> t);
    T update(T t);
    List<T> updateAll(List<T> t);
    List<T> getByColumn(String columnName, String whereColumnIs, int limit);
    void deleteByColumn(String columnName, String whereColumnIs);
    T getById(Serializable id);
    void deleteById(Serializable id);
    public List<T> getWhereId(Long whereIdMin, Long whereIdMax);
    public void deleteWhereId(Long whereIdMin, Long whereIdMax);
    void setUserEm(String userName);
}
