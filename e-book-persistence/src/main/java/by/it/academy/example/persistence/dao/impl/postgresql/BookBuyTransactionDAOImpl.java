package by.it.academy.example.persistence.dao.impl.postgresql;

import by.it.academy.enterprise.entity.postgresql.BookBuyTransaction;
import by.it.academy.example.persistence.dao.base.postgres.BaseDAO;
import by.it.academy.example.persistence.dao.base.postgres.DAODelAndFindByColumn;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.List;

@Repository
public class BookBuyTransactionDAOImpl extends BaseDAO<BookBuyTransaction> implements DAODelAndFindByColumn<BookBuyTransaction> {
    @Override
    public List<BookBuyTransaction> getByColumn(String columnName, String whereColumnIs, int limit) {
        return super.getByColumn(columnName, whereColumnIs, limit);
    }

    @Override
    public void deleteByColumn(String columnName, String whereColumnIs) {
        super.deleteByColumn(columnName, whereColumnIs);
    }

    @Override
    public BookBuyTransaction add(BookBuyTransaction bookBuyTransaction) {
        return super.add(bookBuyTransaction);
    }

    @Override
    public List<BookBuyTransaction> addAll(List<BookBuyTransaction> t) {
        return super.addAll(t);
    }

    @Override
    public BookBuyTransaction getById(Serializable id) {
        return super.getById(id);
    }

    @Override
    public BookBuyTransaction update(BookBuyTransaction bookBuyTransaction) {
        return super.update(bookBuyTransaction);
    }

    @Override
    public List<BookBuyTransaction> updateAll(List<BookBuyTransaction> t) {
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
    public List<BookBuyTransaction> getWhereId(Long whereIdMin, Long whereIdMax) {
        return super.getWhereId(whereIdMin, whereIdMax);
    }

    @Override
    public void deleteWhereId(Long whereIdMin, Long whereIdMax) {
        super.deleteWhereId(whereIdMin, whereIdMax);
    }
}
