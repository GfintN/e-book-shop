package by.it.academy.enterprise.service.services.dao.postgres;

import by.it.academy.enterprise.entity.postgresql.BookAndAuthor;
import by.it.academy.enterprise.entity.postgresql.ReviewerInfo;
import by.it.academy.enterprise.service.services.dao.base.BaseServiceEm;
import by.it.academy.example.persistence.dao.impl.postgresql.ReviewerInfoDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

@Service
public class ReviewerInfoService implements BaseServiceEm<ReviewerInfo> {
    @Autowired
    ReviewerInfoDAOImpl reviewerInfoDAO;

    @Override
    public ReviewerInfo add(ReviewerInfo reviewerInfo) {
        return reviewerInfoDAO.add(reviewerInfo);
    }

    @Override
    public List<ReviewerInfo> addAll(List<ReviewerInfo> t) {
        return reviewerInfoDAO.addAll(t);
    }

    @Override
    public ReviewerInfo update(ReviewerInfo reviewerInfo) {
        return reviewerInfoDAO.update(reviewerInfo);
    }

    @Override
    public List<ReviewerInfo> updateAll(List<ReviewerInfo> t) {
        return reviewerInfoDAO.updateAll(t);
    }

    @Override
    public List<ReviewerInfo> getByColumn(String columnName, String whereColumnIs, int limit) {
        return reviewerInfoDAO.getByColumn(columnName, whereColumnIs, limit);
    }

    @Override
    public void deleteByColumn(String columnName, String whereColumnIs) {
        reviewerInfoDAO.deleteByColumn(columnName,whereColumnIs);
    }

    @Override
    public ReviewerInfo getById(Serializable id) {
        return reviewerInfoDAO.getById(id);
    }

    @Override
    public void deleteById(Serializable id) {
        reviewerInfoDAO.deleteById(id);
    }
    @Override
    public List<ReviewerInfo> getWhereId(Long whereIdMin, Long whereIdMax) {
        return reviewerInfoDAO.getWhereId(whereIdMin, whereIdMax);
    }

    @Override
    public void deleteWhereId(Long whereIdMin, Long whereIdMax) {
        reviewerInfoDAO.deleteWhereId(whereIdMin, whereIdMax);
    }
    @Override
    public void setUserEm(String userName) {
        reviewerInfoDAO.getUserBeanEm(userName);
    }
}
