package by.it.academy.example.persistence.dao.base.postgres;

import java.io.Serializable;
import java.util.List;

public interface DAODelAndFindByColumn<T> {
    public List<T> getByColumn(String columnName, String whereColumnIs, int limit);
    public void deleteByColumn(String columnName, String whereColumnIs);
}
