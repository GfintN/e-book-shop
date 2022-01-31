package by.it.academy.enterprise.service.services.dao.postgres;

import by.it.academy.enterprise.entity.postgresql.BookAndAuthor;
import by.it.academy.enterprise.entity.postgresql.BookBuyTransaction;
import by.it.academy.enterprise.service.services.dao.base.BaseServiceEm;
import by.it.academy.example.persistence.dao.impl.postgresql.BookBuyTransactionDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

public class BookBuyTransactionService implements BaseServiceEm<BookBuyTransaction> {
    @Autowired
    BookBuyTransactionDAOImpl bookBuyTransactionDAO;

    @Override
    public BookBuyTransaction add(BookBuyTransaction bookBuyTransaction) {
        return bookBuyTransactionDAO.add(bookBuyTransaction);
    }

    @Override
    public List<BookBuyTransaction> addAll(List<BookBuyTransaction> t) {
        return bookBuyTransactionDAO.addAll(t);
    }

    @Override
    public BookBuyTransaction update(BookBuyTransaction bookBuyTransaction) {
        return bookBuyTransactionDAO.update(bookBuyTransaction);
    }

    @Override
    public List<BookBuyTransaction> updateAll(List<BookBuyTransaction> t) {
        return bookBuyTransactionDAO.updateAll(t);
    }

    @Override
    public List<BookBuyTransaction> getByColumn(String columnName, String whereColumnIs, int limit) {
        return bookBuyTransactionDAO.getByColumn(columnName, whereColumnIs, limit);
    }

    @Override
    public void deleteByColumn(String columnName, String whereColumnIs) {
        bookBuyTransactionDAO.deleteByColumn(columnName,whereColumnIs);
    }

    @Override
    public BookBuyTransaction getById(Serializable id) {
        return bookBuyTransactionDAO.getById(id);
    }

    @Override
    public void deleteById(Serializable id) {
        bookBuyTransactionDAO.deleteById(id);
    }

    @Override
    public List<BookBuyTransaction> getWhereId(Long whereIdMin, Long whereIdMax) {
        return bookBuyTransactionDAO.getWhereId(whereIdMin, whereIdMax);
    }

    @Override
    public void deleteWhereId(Long whereIdMin, Long whereIdMax) {
        bookBuyTransactionDAO.deleteWhereId(whereIdMin, whereIdMax);
    }

    @Override
    public void setUserEm(String userName) {
        bookBuyTransactionDAO.getUserBeanEm(userName);
    }
}
