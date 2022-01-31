package by.it.academy.example.persistence.dao.impl.postgresql;

import by.it.academy.enterprise.entity.postgresql.UsersDataChangeTransaction;
import by.it.academy.example.persistence.dao.base.postgres.BaseDAO;
import by.it.academy.example.persistence.dao.base.postgres.DAODelAndFindByColumn;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.List;

@Repository
public class UsersDataChangeTransactionDAOImpl extends BaseDAO<UsersDataChangeTransaction> implements DAODelAndFindByColumn<UsersDataChangeTransaction> {
    @Override
    public List<UsersDataChangeTransaction> getByColumn(String columnName, String whereColumnIs, int limit) {
        return super.getByColumn(columnName, whereColumnIs, limit);
    }

    @Override
    public void deleteByColumn(String columnName, String whereColumnIs) {
        super.deleteByColumn(columnName, whereColumnIs);
    }

    @Override
    public UsersDataChangeTransaction add(UsersDataChangeTransaction usersDataChangeTransaction) {
        return super.add(usersDataChangeTransaction);
    }

    @Override
    public List<UsersDataChangeTransaction> addAll(List<UsersDataChangeTransaction> t) {
        return super.addAll(t);
    }

    @Override
    public UsersDataChangeTransaction getById(Serializable id) {
        return super.getById(id);
    }

    @Override
    public UsersDataChangeTransaction update(UsersDataChangeTransaction usersDataChangeTransaction) {
        return super.update(usersDataChangeTransaction);
    }

    @Override
    public List<UsersDataChangeTransaction> updateAll(List<UsersDataChangeTransaction> t) {
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
    public List<UsersDataChangeTransaction> getWhereId(Long whereIdMin, Long whereIdMax) {
        return super.getWhereId(whereIdMin, whereIdMax);
    }

    @Override
    public void deleteWhereId(Long whereIdMin, Long whereIdMax) {
        super.deleteWhereId(whereIdMin, whereIdMax);
    }
}
