package by.it.academy.enterprise.service.services.dao.postgres;

import by.it.academy.enterprise.entity.postgresql.BookAndAuthor;
import by.it.academy.enterprise.entity.postgresql.UsersDataChangeTransaction;
import by.it.academy.enterprise.service.services.dao.base.BaseServiceEm;
import by.it.academy.example.persistence.dao.impl.postgresql.UsersDataChangeTransactionDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

@Service
public class UsersDataChangeTransactionService implements BaseServiceEm<UsersDataChangeTransaction> {
    @Autowired
    UsersDataChangeTransactionDAOImpl usersDataChangeTransactionDAO;

    @Override
    public UsersDataChangeTransaction add(UsersDataChangeTransaction usersDataChangeTransaction) {
        return usersDataChangeTransactionDAO.add(usersDataChangeTransaction);
    }

    @Override
    public List<UsersDataChangeTransaction> addAll(List<UsersDataChangeTransaction> t) {
        return usersDataChangeTransactionDAO.addAll(t);
    }

    @Override
    public UsersDataChangeTransaction update(UsersDataChangeTransaction usersDataChangeTransaction) {
        return usersDataChangeTransactionDAO.update(usersDataChangeTransaction);
    }

    @Override
    public List<UsersDataChangeTransaction> updateAll(List<UsersDataChangeTransaction> t) {
        return usersDataChangeTransactionDAO.updateAll(t);
    }

    @Override
    public List<UsersDataChangeTransaction> getByColumn(String columnName, String whereColumnIs, int limit) {
        return usersDataChangeTransactionDAO.getByColumn(columnName, whereColumnIs, limit);
    }

    @Override
    public void deleteByColumn(String columnName, String whereColumnIs) {
        usersDataChangeTransactionDAO.deleteByColumn(columnName,whereColumnIs);
    }

    @Override
    public UsersDataChangeTransaction getById(Serializable id) {
        return usersDataChangeTransactionDAO.getById(id);
    }

    @Override
    public void deleteById(Serializable id) {
        usersDataChangeTransactionDAO.deleteById(id);
    }
    @Override
    public List<UsersDataChangeTransaction> getWhereId(Long whereIdMin, Long whereIdMax) {
        return usersDataChangeTransactionDAO.getWhereId(whereIdMin, whereIdMax);
    }

    @Override
    public void deleteWhereId(Long whereIdMin, Long whereIdMax) {
        usersDataChangeTransactionDAO.deleteWhereId(whereIdMin, whereIdMax);
    }
    @Override
    public void setUserEm(String userName) {
        usersDataChangeTransactionDAO.getUserBeanEm(userName);
    }
}
