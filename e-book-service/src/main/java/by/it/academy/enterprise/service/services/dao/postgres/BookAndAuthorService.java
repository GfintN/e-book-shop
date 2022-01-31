package by.it.academy.enterprise.service.services.dao.postgres;

import by.it.academy.enterprise.entity.postgresql.BookAndAuthor;
import by.it.academy.enterprise.service.services.dao.base.BaseServiceEm;
import by.it.academy.example.persistence.dao.impl.mongodb.BookBuyListDAOImpl;
import by.it.academy.example.persistence.dao.impl.postgresql.BookAndAuthorDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

@Service
public class BookAndAuthorService implements BaseServiceEm<BookAndAuthor> {
    @Autowired
    BookAndAuthorDAOImpl bookAndAuthorDAO;

    @Override
    public BookAndAuthor add(BookAndAuthor bookAndAuthor) {
        return bookAndAuthorDAO.add(bookAndAuthor);
    }

    @Override
    public List<BookAndAuthor> addAll(List<BookAndAuthor> t) {
        return bookAndAuthorDAO.addAll(t);
    }

    @Override
    public BookAndAuthor update(BookAndAuthor bookAndAuthor) {
        return bookAndAuthorDAO.update(bookAndAuthor);
    }

    @Override
    public List<BookAndAuthor> updateAll(List<BookAndAuthor> t) {
        return bookAndAuthorDAO.updateAll(t);
    }

    @Override
    public List<BookAndAuthor> getByColumn(String columnName, String whereColumnIs, int limit) {
        return bookAndAuthorDAO.getByColumn(columnName, whereColumnIs, limit);
    }

    @Override
    public void deleteByColumn(String columnName, String whereColumnIs) {
        bookAndAuthorDAO.deleteByColumn(columnName,whereColumnIs);
    }

    @Override
    public BookAndAuthor getById(Serializable id) {
        return bookAndAuthorDAO.getById(id);
    }

    @Override
    public void deleteById(Serializable id) {
      bookAndAuthorDAO.deleteById(id);
    }

    @Override
    public List<BookAndAuthor> getWhereId(Long whereIdMin, Long whereIdMax) {
        return bookAndAuthorDAO.getWhereId(whereIdMin, whereIdMax);
    }

    @Override
    public void deleteWhereId(Long whereIdMin, Long whereIdMax) {
        bookAndAuthorDAO.deleteWhereId(whereIdMin, whereIdMax);
    }

    @Override
    public void setUserEm(String userName) {
        bookAndAuthorDAO.getUserBeanEm(userName);
    }
}
