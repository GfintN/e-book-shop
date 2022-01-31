package by.it.academy.enterprise.service.services.dao.postgres;

import by.it.academy.enterprise.entity.postgresql.BookAndAuthor;
import by.it.academy.enterprise.entity.postgresql.SubAdminDeleteRequests;
import by.it.academy.enterprise.service.services.dao.base.BaseServiceEm;
import by.it.academy.example.persistence.dao.impl.postgresql.SubAdminDeleteRequestsDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

@Service
public class SubAdminDeleteRequestsService implements BaseServiceEm<SubAdminDeleteRequests> {
    @Autowired
    SubAdminDeleteRequestsDAOImpl subAdminDeleteRequestsDAO;

    @Override
    public SubAdminDeleteRequests add(SubAdminDeleteRequests subAdminDeleteRequests) {
        return subAdminDeleteRequestsDAO.add(subAdminDeleteRequests);
    }

    @Override
    public List<SubAdminDeleteRequests> addAll(List<SubAdminDeleteRequests> t) {
        return subAdminDeleteRequestsDAO.addAll(t);
    }

    @Override
    public SubAdminDeleteRequests update(SubAdminDeleteRequests subAdminDeleteRequests) {
        return subAdminDeleteRequestsDAO.update(subAdminDeleteRequests);
    }

    @Override
    public List<SubAdminDeleteRequests> updateAll(List<SubAdminDeleteRequests> t) {
        return subAdminDeleteRequestsDAO.updateAll(t);
    }

    @Override
    public List<SubAdminDeleteRequests> getByColumn(String columnName, String whereColumnIs, int limit) {
        return subAdminDeleteRequestsDAO.getByColumn(columnName, whereColumnIs, limit);
    }

    @Override
    public void deleteByColumn(String columnName, String whereColumnIs) {
        subAdminDeleteRequestsDAO.deleteByColumn(columnName,whereColumnIs);
    }

    @Override
    public SubAdminDeleteRequests getById(Serializable id) {
        return subAdminDeleteRequestsDAO.getById(id);
    }

    @Override
    public void deleteById(Serializable id) {
        subAdminDeleteRequestsDAO.deleteById(id);
    }
    @Override
    public List<SubAdminDeleteRequests> getWhereId(Long whereIdMin, Long whereIdMax) {
        return subAdminDeleteRequestsDAO.getWhereId(whereIdMin, whereIdMax);
    }

    @Override
    public void deleteWhereId(Long whereIdMin, Long whereIdMax) {
        subAdminDeleteRequestsDAO.deleteWhereId(whereIdMin, whereIdMax);
    }
    @Override
    public void setUserEm(String userName) {
        subAdminDeleteRequestsDAO.getUserBeanEm(userName);
    }
}
