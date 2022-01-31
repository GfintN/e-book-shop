package by.it.academy.example.persistence.dao.base.postgres;

import java.util.List;

public interface DAOAddAndUpdate<T> {
        public T add(T t);
        public List<T> addAll(List<T> t);
        public T update(T t);
        public List<T> updateAll(List<T> t);
}

