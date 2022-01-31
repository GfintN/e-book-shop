package by.it.academy.enterprise.service.services.dao.postgres;

import by.it.academy.enterprise.entity.postgresql.BookAndAuthor;
import by.it.academy.enterprise.entity.postgresql.RequestsForAuthorStatus;
import by.it.academy.enterprise.service.services.dao.base.BaseServiceEm;
import by.it.academy.example.persistence.dao.impl.postgresql.RequestsForAuthorStatusDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

@Service
public class RequestsForAuthorStatusService implements BaseServiceEm<RequestsForAuthorStatus> {
    @Autowired
    RequestsForAuthorStatusDAOImpl requestsForAuthorStatusDAO;

    @Override
    public RequestsForAuthorStatus add(RequestsForAuthorStatus requestsForAuthorStatus) {
        return requestsForAuthorStatusDAO.add(requestsForAuthorStatus);
    }

    @Override
    public List<RequestsForAuthorStatus> addAll(List<RequestsForAuthorStatus> t) {
        return requestsForAuthorStatusDAO.addAll(t);
    }

    @Override
    public RequestsForAuthorStatus update(RequestsForAuthorStatus requestsForAuthorStatus) {
        return requestsForAuthorStatusDAO.update(requestsForAuthorStatus);
    }

    @Override
    public List<RequestsForAuthorStatus> updateAll(List<RequestsForAuthorStatus> t) {
        return requestsForAuthorStatusDAO.updateAll(t);
    }

    @Override
    public List<RequestsForAuthorStatus> getByColumn(String columnName, String whereColumnIs, int limit) {
        return requestsForAuthorStatusDAO.getByColumn(columnName, whereColumnIs, limit);
    }

    @Override
    public void deleteByColumn(String columnName, String whereColumnIs) {
        requestsForAuthorStatusDAO.deleteByColumn(columnName,whereColumnIs);
    }

    @Override
    public RequestsForAuthorStatus getById(Serializable id) {
        return requestsForAuthorStatusDAO.getById(id);
    }

    @Override
    public void deleteById(Serializable id) {
        requestsForAuthorStatusDAO.deleteById(id);
    }
    @Override
    public List<RequestsForAuthorStatus> getWhereId(Long whereIdMin, Long whereIdMax) {
        return requestsForAuthorStatusDAO.getWhereId(whereIdMin, whereIdMax);
    }

    @Override
    public void deleteWhereId(Long whereIdMin, Long whereIdMax) {
        requestsForAuthorStatusDAO.deleteWhereId(whereIdMin, whereIdMax);
    }
    @Override
    public void setUserEm(String userName) {
        requestsForAuthorStatusDAO.getUserBeanEm(userName);
    }
}
