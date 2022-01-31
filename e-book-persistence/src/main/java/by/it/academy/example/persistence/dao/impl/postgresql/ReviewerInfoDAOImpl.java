package by.it.academy.example.persistence.dao.impl.postgresql;

import by.it.academy.enterprise.entity.postgresql.ReviewerInfo;
import by.it.academy.example.persistence.dao.base.postgres.BaseDAO;
import by.it.academy.example.persistence.dao.base.postgres.DAODelAndFindByColumn;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.List;

@Repository
public class ReviewerInfoDAOImpl extends BaseDAO<ReviewerInfo> implements DAODelAndFindByColumn<ReviewerInfo> {
    @Override
    public List<ReviewerInfo> getByColumn(String columnName, String whereColumnIs, int limit) {
        return super.getByColumn(columnName, whereColumnIs, limit);
    }

    @Override
    public void deleteByColumn(String columnName, String whereColumnIs) {
        super.deleteByColumn(columnName, whereColumnIs);
    }

    @Override
    public ReviewerInfo add(ReviewerInfo reviewerInfo) {
        return super.add(reviewerInfo);
    }

    @Override
    public List<ReviewerInfo> addAll(List<ReviewerInfo> t) {
        return super.addAll(t);
    }

    @Override
    public ReviewerInfo getById(Serializable id) {
        return super.getById(id);
    }

    @Override
    public ReviewerInfo update(ReviewerInfo reviewerInfo) {
        return super.update(reviewerInfo);
    }

    @Override
    public List<ReviewerInfo> updateAll(List<ReviewerInfo> t) {
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
    public List<ReviewerInfo> getWhereId(Long whereIdMin, Long whereIdMax) {
        return super.getWhereId(whereIdMin, whereIdMax);
    }

    @Override
    public void deleteWhereId(Long whereIdMin, Long whereIdMax) {
        super.deleteWhereId(whereIdMin, whereIdMax);
    }
}
