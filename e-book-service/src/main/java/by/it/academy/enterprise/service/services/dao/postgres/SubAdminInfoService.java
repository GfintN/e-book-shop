package by.it.academy.enterprise.service.services.dao.postgres;

import by.it.academy.enterprise.entity.postgresql.BookAndAuthor;
import by.it.academy.enterprise.entity.postgresql.SubAdminInfo;
import by.it.academy.enterprise.service.services.dao.base.BaseServiceEm;
import by.it.academy.example.persistence.dao.impl.postgresql.SubAdminInfoDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

@Service
public class SubAdminInfoService implements BaseServiceEm<SubAdminInfo> {
    @Autowired
    SubAdminInfoDAOImpl subAdminInfoDAO;

    @Override
    public SubAdminInfo add(SubAdminInfo subAdminInfo) {
        return subAdminInfoDAO.add(subAdminInfo);
    }

    @Override
    public List<SubAdminInfo> addAll(List<SubAdminInfo> t) {
        return subAdminInfoDAO.addAll(t);
    }

    @Override
    public SubAdminInfo update(SubAdminInfo subAdminInfo) {
        return subAdminInfoDAO.update(subAdminInfo);
    }

    @Override
    public List<SubAdminInfo> updateAll(List<SubAdminInfo> t) {
        return subAdminInfoDAO.updateAll(t);
    }

    @Override
    public List<SubAdminInfo> getByColumn(String columnName, String whereColumnIs, int limit) {
        return subAdminInfoDAO.getByColumn(columnName, whereColumnIs, limit);
    }

    @Override
    public void deleteByColumn(String columnName, String whereColumnIs) {
        subAdminInfoDAO.deleteByColumn(columnName,whereColumnIs);
    }

    @Override
    public SubAdminInfo getById(Serializable id) {
        return subAdminInfoDAO.getById(id);
    }

    @Override
    public void deleteById(Serializable id) {
        subAdminInfoDAO.deleteById(id);
    }
    @Override
    public List<SubAdminInfo> getWhereId(Long whereIdMin, Long whereIdMax) {
        return subAdminInfoDAO.getWhereId(whereIdMin, whereIdMax);
    }

    @Override
    public void deleteWhereId(Long whereIdMin, Long whereIdMax) {
        subAdminInfoDAO.deleteWhereId(whereIdMin, whereIdMax);
    }
    @Override
    public void setUserEm(String userName) {
        subAdminInfoDAO.getUserBeanEm(userName);
    }
}
