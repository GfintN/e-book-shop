package by.it.academy.example.persistence.dao.impl.postgresql;

import by.it.academy.enterprise.entity.postgresql.BookPublicationRequest;
import by.it.academy.example.persistence.dao.base.postgres.BaseDAO;
import by.it.academy.example.persistence.dao.base.postgres.DAODelAndFindByColumn;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.List;

@Repository
public class BookPublicationRequestDAOImpl extends BaseDAO<BookPublicationRequest> implements DAODelAndFindByColumn<BookPublicationRequest> {
    @Override
    public List<BookPublicationRequest> getByColumn(String columnName, String whereColumnIs, int limit) {
        return super.getByColumn(columnName, whereColumnIs, limit);
    }

    @Override
    public void deleteByColumn(String columnName, String whereColumnIs) {
        super.deleteByColumn(columnName, whereColumnIs);
    }

    @Override
    public BookPublicationRequest add(BookPublicationRequest bookPublicationRequest) {
        return super.add(bookPublicationRequest);
    }

    @Override
    public List<BookPublicationRequest> addAll(List<BookPublicationRequest> t) {
        return super.addAll(t);
    }

    @Override
    public BookPublicationRequest getById(Serializable id) {
        return super.getById(id);
    }

    @Override
    public BookPublicationRequest update(BookPublicationRequest bookPublicationRequest) {
        return super.update(bookPublicationRequest);
    }

    @Override
    public List<BookPublicationRequest> updateAll(List<BookPublicationRequest> t) {
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
    public List<BookPublicationRequest> getWhereId(Long whereIdMin, Long whereIdMax) {
        return super.getWhereId(whereIdMin, whereIdMax);
    }

    @Override
    public void deleteWhereId(Long whereIdMin, Long whereIdMax) {
        super.deleteWhereId(whereIdMin, whereIdMax);
    }
}
