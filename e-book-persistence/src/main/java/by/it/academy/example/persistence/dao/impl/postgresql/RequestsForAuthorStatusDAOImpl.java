package by.it.academy.example.persistence.dao.impl.postgresql;

import by.it.academy.enterprise.entity.postgresql.RequestsForAuthorStatus;
import by.it.academy.example.persistence.dao.base.postgres.BaseDAO;
import by.it.academy.example.persistence.dao.base.postgres.DAODelAndFindByColumn;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.List;

@Repository
public class RequestsForAuthorStatusDAOImpl extends BaseDAO<RequestsForAuthorStatus> implements DAODelAndFindByColumn<RequestsForAuthorStatus> {
    @Override
    public List<RequestsForAuthorStatus> getByColumn(String columnName, String whereColumnIs, int limit) {
        return super.getByColumn(columnName, whereColumnIs, limit);
    }

    @Override
    public void deleteByColumn(String columnName, String whereColumnIs) {
        super.deleteByColumn(columnName, whereColumnIs);
    }

    @Override
    public RequestsForAuthorStatus add(RequestsForAuthorStatus requestsForAuthorStatus) {
        return super.add(requestsForAuthorStatus);
    }

    @Override
    public List<RequestsForAuthorStatus> addAll(List<RequestsForAuthorStatus> t) {
        return super.addAll(t);
    }

    @Override
    public RequestsForAuthorStatus getById(Serializable id) {
        return super.getById(id);
    }

    @Override
    public RequestsForAuthorStatus update(RequestsForAuthorStatus requestsForAuthorStatus) {
        return super.update(requestsForAuthorStatus);
    }

    @Override
    public List<RequestsForAuthorStatus> updateAll(List<RequestsForAuthorStatus> t) {
        return super.updateAll(t);
    }

    @Override
    public void deleteById(Serializable id) {
        super.deleteById(id);
    }

    @Override
    public void setEm(EntityManager em) {
        super.setEm(em);
    }

    @Override
    public EntityManager getEm() {
        return super.getEm();
    }

    @Override
    public void getUserBeanEm(String beanName) {
         super.getUserBeanEm(beanName);
    }

    @Override
    public List<RequestsForAuthorStatus> getWhereId(Long whereIdMin, Long whereIdMax) {
        return super.getWhereId(whereIdMin, whereIdMax);
    }

    @Override
    public void deleteWhereId(Long whereIdMin, Long whereIdMax) {
        super.deleteWhereId(whereIdMin, whereIdMax);
    }
}
