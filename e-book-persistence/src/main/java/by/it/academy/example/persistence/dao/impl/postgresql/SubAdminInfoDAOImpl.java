package by.it.academy.example.persistence.dao.impl.postgresql;

import by.it.academy.enterprise.entity.postgresql.SubAdminInfo;
import by.it.academy.example.persistence.dao.base.postgres.BaseDAO;
import by.it.academy.example.persistence.dao.base.postgres.DAODelAndFindByColumn;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.List;

@Repository
public class SubAdminInfoDAOImpl extends BaseDAO<SubAdminInfo> implements DAODelAndFindByColumn<SubAdminInfo> {
    @Override
    public List<SubAdminInfo> getByColumn(String columnName, String whereColumnIs, int limit) {
        return super.getByColumn(columnName, whereColumnIs, limit);
    }

    @Override
    public void deleteByColumn(String columnName, String whereColumnIs) {
        super.deleteByColumn(columnName, whereColumnIs);
    }

    @Override
    public SubAdminInfo add(SubAdminInfo subAdminInfo) {
        return super.add(subAdminInfo);
    }

    @Override
    public List<SubAdminInfo> addAll(List<SubAdminInfo> t) {
        return super.addAll(t);
    }

    @Override
    public SubAdminInfo getById(Serializable id) {
        return super.getById(id);
    }

    @Override
    public SubAdminInfo update(SubAdminInfo subAdminInfo) {
        return super.update(subAdminInfo);
    }

    @Override
    public List<SubAdminInfo> updateAll(List<SubAdminInfo> t) {
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
    public List<SubAdminInfo> getWhereId(Long whereIdMin, Long whereIdMax) {
        return super.getWhereId(whereIdMin, whereIdMax);
    }

    @Override
    public void deleteWhereId(Long whereIdMin, Long whereIdMax) {
        super.deleteWhereId(whereIdMin, whereIdMax);
    }
}
