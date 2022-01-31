package by.it.academy.enterprise.service.services.dao.postgres;

import by.it.academy.enterprise.entity.postgresql.BookAndAuthor;
import by.it.academy.enterprise.entity.postgresql.BookPublicationRequest;
import by.it.academy.enterprise.service.services.dao.base.BaseServiceEm;
import by.it.academy.example.persistence.dao.impl.postgresql.BookPublicationRequestDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

@Service
public class BookPublicationRequestService implements BaseServiceEm<BookPublicationRequest> {
    @Autowired
    BookPublicationRequestDAOImpl bookPublicationRequestDAO;

    @Override
    public BookPublicationRequest add(BookPublicationRequest bookPublicationRequest) {
        return bookPublicationRequestDAO.add(bookPublicationRequest);
    }

    @Override
    public List<BookPublicationRequest> addAll(List<BookPublicationRequest> t) {
        return bookPublicationRequestDAO.addAll(t);
    }

    @Override
    public BookPublicationRequest update(BookPublicationRequest bookPublicationRequest) {
        return bookPublicationRequestDAO.update(bookPublicationRequest);
    }

    @Override
    public List<BookPublicationRequest> updateAll(List<BookPublicationRequest> t) {
        return bookPublicationRequestDAO.updateAll(t);
    }

    @Override
    public List<BookPublicationRequest> getByColumn(String columnName, String whereColumnIs, int limit) {
        return bookPublicationRequestDAO.getByColumn(columnName, whereColumnIs, limit);
    }

    @Override
    public void deleteByColumn(String columnName, String whereColumnIs) {
        bookPublicationRequestDAO.deleteByColumn(columnName,whereColumnIs);
    }

    @Override
    public BookPublicationRequest getById(Serializable id) {
        return bookPublicationRequestDAO.getById(id);
    }

    @Override
    public void deleteById(Serializable id) {
        bookPublicationRequestDAO.deleteById(id);
    }

    @Override
    public List<BookPublicationRequest> getWhereId(Long whereIdMin, Long whereIdMax) {
        return bookPublicationRequestDAO.getWhereId(whereIdMin, whereIdMax);
    }

    @Override
    public void deleteWhereId(Long whereIdMin, Long whereIdMax) {
        bookPublicationRequestDAO.deleteWhereId(whereIdMin, whereIdMax);
    }
    @Override
    public void setUserEm(String userName) {
        bookPublicationRequestDAO.getUserBeanEm(userName);
    }
}
