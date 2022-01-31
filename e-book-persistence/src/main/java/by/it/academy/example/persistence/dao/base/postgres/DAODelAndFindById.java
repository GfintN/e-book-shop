package by.it.academy.example.persistence.dao.base.postgres;

import java.io.Serializable;
import java.util.List;

public interface DAODelAndFindById<T> {
    public T getById(Serializable id);
    public List<T> getWhereId(Long whereIdMin, Long whereIdMax);
    public void deleteById(Serializable id);
    public void deleteWhereId(Long whereIdMin, Long whereIdMax);
}
