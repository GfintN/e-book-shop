package by.it.academy.example.persistence.dao.impl.postgresql;

import by.it.academy.enterprise.entity.postgresql.BookAndAuthor;
import by.it.academy.example.persistence.dao.base.postgres.BaseDAO;
import by.it.academy.example.persistence.dao.base.postgres.DAODelAndFindByColumn;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.List;

@Repository
public class BookAndAuthorDAOImpl extends BaseDAO<BookAndAuthor> implements DAODelAndFindByColumn<BookAndAuthor> {
    @Override
    public List<BookAndAuthor> getByColumn(String columnName, String whereColumnIs, int limit) {
        return super.getByColumn(columnName, whereColumnIs, limit);
    }

    @Override
    public void deleteByColumn(String columnName, String whereColumnIs) {
        super.deleteByColumn(columnName, whereColumnIs);
    }

    @Override
    public BookAndAuthor add(BookAndAuthor bookAndAuthor) {
        return super.add(bookAndAuthor);
    }

    @Override
    public List<BookAndAuthor> addAll(List<BookAndAuthor> t) {
        return super.addAll(t);
    }

    @Override
    public BookAndAuthor getById(Serializable id) {
        return super.getById(id);
    }

    @Override
    public BookAndAuthor update(BookAndAuthor bookAndAuthor) {
        return super.update(bookAndAuthor);
    }

    @Override
    public List<BookAndAuthor> updateAll(List<BookAndAuthor> t) {
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
    public List<BookAndAuthor> getWhereId(Long whereIdMin, Long whereIdMax) {
        return super.getWhereId(whereIdMin, whereIdMax);
    }

    @Override
    public void deleteWhereId(Long whereIdMin, Long whereIdMax) {
        super.deleteWhereId(whereIdMin, whereIdMax);
    }
}
