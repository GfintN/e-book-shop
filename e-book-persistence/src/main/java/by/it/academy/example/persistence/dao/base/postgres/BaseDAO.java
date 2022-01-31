package by.it.academy.example.persistence.dao.base.postgres;

import by.it.academy.example.persistence.configure.PersistenceContext;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;


public class BaseDAO<T> implements DAOAddAndUpdate<T>, DAODelAndFindById<T>,DAODelAndFindByColumn<T>  {
    private Class<T> clazz;
    protected EntityManager em;

    @Override
    public List<T> getByColumn(String columnName, String whereColumnIs, int limit) {
        CriteriaBuilder criteriaBuilder =  getEm().getCriteriaBuilder();
        CriteriaQuery<T> criteria = criteriaBuilder.createQuery(clazz);
        Root<T> root = criteria.from(clazz);
        criteria.select(root).where(root.get(columnName).in(whereColumnIs));
        criteria.from(clazz);
        if(limit > 0){
            return getEm().createQuery(criteria).setMaxResults(limit).getResultList();
        }else {
            return getEm().createQuery(criteria).getResultList();
        }
    }

    @Transactional
    @Override
    public void deleteByColumn(String columnName, String whereColumnIs) {
        CriteriaBuilder criteriaBuilder =  getEm().getCriteriaBuilder();
        CriteriaDelete<T> query = criteriaBuilder.createCriteriaDelete(clazz);
        CriteriaQuery<T> criteria = criteriaBuilder.createQuery(clazz);
        Root<T> root = query.from(clazz);
        query.where(root.get(columnName).in(whereColumnIs));
        criteria.from(clazz);
    }

    @Override
    public List<T> getWhereId(Long whereIdMin, Long whereIdMax) {
        CriteriaBuilder criteriaBuilder =  getEm().getCriteriaBuilder();
        CriteriaQuery<T> criteria = criteriaBuilder.createQuery(clazz);
        Root<T> root = criteria.from(clazz);
        if ( whereIdMin != null && whereIdMax != null){
            criteria.select(root).where(criteriaBuilder.gt(root.get("id"), whereIdMin))
                    .where(criteriaBuilder.lt(root.get("id"), whereIdMax));
            criteria.from(clazz);
            return getEm().createQuery(criteria).getResultList();
        }
        else if(whereIdMin == null){
            criteria.select(root).where(criteriaBuilder.gt(root.get("id"), whereIdMin));
            criteria.from(clazz);
            return getEm().createQuery(criteria).getResultList();
        }
        else if(whereIdMax == null){
            criteria.select(root).where(criteriaBuilder.lt(root.get("itemPrice"), whereIdMax));
            criteria.from(clazz);
            return getEm().createQuery(criteria).getResultList();
        }
        else {
            return null;
        }
    }


    @Override
    public void deleteWhereId(Long whereIdMin, Long whereIdMax) {
        CriteriaBuilder criteriaBuilder =  getEm().getCriteriaBuilder();
        CriteriaDelete<T> query = criteriaBuilder.createCriteriaDelete(clazz);
        CriteriaQuery<T> criteria = criteriaBuilder.createQuery(clazz);
        Root<T> root = query.from(clazz);
        criteria.select(root).where(criteriaBuilder.gt(root.get("id"), 1000));
        criteria.from(clazz);
        if ( whereIdMin != null && whereIdMax != null){

        }else if(whereIdMin == null){

        }
        else if(whereIdMax == null){

        }

    }

    @Transactional
    @Override
    public T add(T t) {
        getEm().persist(t);
        return t;
    }

    @Transactional
    @Override
    public List<T> addAll(List<T> t) {
        t.forEach(tl -> getEm().persist(tl));
        return t;
    }

    @Override
    public T getById(Serializable id) {
        return getEm().find(clazz, id);
    }

    @Transactional
    @Override
    public T update(T t) {
        getEm().merge(t);
        return t;
    }

    @Transactional
    @Override
    public List<T> updateAll(List<T> t) {
        t.forEach(tl -> getEm().merge(tl));
        return t;
    }

    @Transactional
    @Override
    public void deleteById(Serializable id) {
        T t = getEm().find(clazz, id);
        getEm().remove(t);
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public void getUserBeanEm(String userName){
      switch (userName) {
          case ("admin"):
              ApplicationContext applicationContextAdmin = new AnnotationConfigApplicationContext(PersistenceContext.class);
              this.em = applicationContextAdmin.getBean("entityManagerFactoryAdmin", EntityManager.class);
              break;
          case ("sub_admin"):
              ApplicationContext applicationContextSubAdmin = new AnnotationConfigApplicationContext(PersistenceContext.class);
              this.em = applicationContextSubAdmin.getBean("entityManagerFactorySubAdmin", EntityManager.class);
              break;
          case ("author"):
              ApplicationContext applicationContextAuthor = new AnnotationConfigApplicationContext(PersistenceContext.class);
              this.em = applicationContextAuthor.getBean("entityManagerFactoryAuthor", EntityManager.class);
              break;
          case ("reviewer"):
              ApplicationContext applicationContextReviewer = new AnnotationConfigApplicationContext(PersistenceContext.class);
              this.em = applicationContextReviewer.getBean("entityManagerFactoryReviewer", EntityManager.class);
              break;
          case ("users"):
              ApplicationContext applicationContextUsers = new AnnotationConfigApplicationContext(PersistenceContext.class);
              this.em = applicationContextUsers.getBean("entityManagerFactoryUsers", EntityManager.class);
              break;
          case ("system"):
              ApplicationContext applicationContextSystem = new AnnotationConfigApplicationContext(PersistenceContext.class);
              this.em = applicationContextSystem.getBean("entityManagerFactorySystem", EntityManager.class);
      }
    }

    public EntityManager getEm() {
        return em;
    }
}
