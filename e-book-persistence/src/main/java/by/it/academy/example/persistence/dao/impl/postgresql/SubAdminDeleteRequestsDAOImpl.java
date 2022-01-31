package by.it.academy.example.persistence.dao.impl.postgresql;

import by.it.academy.enterprise.entity.postgresql.SubAdminDeleteRequests;
import by.it.academy.example.persistence.dao.base.postgres.BaseDAO;
import by.it.academy.example.persistence.dao.base.postgres.DAODelAndFindByColumn;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.List;

@Repository
public class SubAdminDeleteRequestsDAOImpl extends BaseDAO<SubAdminDeleteRequests> implements DAODelAndFindByColumn<SubAdminDeleteRequests> {
    @Override
    public List<SubAdminDeleteRequests> getByColumn(String columnName, String whereColumnIs, int limit) {
        return super.getByColumn(columnName, whereColumnIs, limit);
    }

    @Override
    public void deleteByColumn(String columnName, String whereColumnIs) {
        super.deleteByColumn(columnName, whereColumnIs);
    }

    @Override
    public SubAdminDeleteRequests add(SubAdminDeleteRequests subAdminDeleteRequests) {
        return super.add(subAdminDeleteRequests);
    }

    @Override
    public List<SubAdminDeleteRequests> addAll(List<SubAdminDeleteRequests> t) {
        return super.addAll(t);
    }

    @Override
    public SubAdminDeleteRequests getById(Serializable id) {
        return super.getById(id);
    }

    @Override
    public SubAdminDeleteRequests update(SubAdminDeleteRequests subAdminDeleteRequests) {
        return super.update(subAdminDeleteRequests);
    }

    @Override
    public List<SubAdminDeleteRequests> updateAll(List<SubAdminDeleteRequests> t) {
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
    public List<SubAdminDeleteRequests> getWhereId(Long whereIdMin, Long whereIdMax) {
        return super.getWhereId(whereIdMin, whereIdMax);
    }

    @Override
    public void deleteWhereId(Long whereIdMin, Long whereIdMax) {
        super.deleteWhereId(whereIdMin, whereIdMax);
    }
}
