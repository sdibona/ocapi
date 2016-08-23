package org.akaza.openclinica.domain.dao;

import org.akaza.openclinica.domain.datamap.DomainObject;
import org.hibernate.Session;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.JpaEntityInformationSupport;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;

@Service
public abstract class AbstractDomainDao<T extends DomainObject> {

    @PersistenceContext
    protected EntityManager entityManager;

    //protected JpaEntityInformation<T, ?> entityInformation = JpaEntityInformationSupport.getEntityInformation(domainClass(), entityManager);

    abstract Class<T> domainClass();

    public String getDomainClassName() {
        return domainClass().getName();
    }


    @SuppressWarnings("unchecked")
    @Transactional
    public T findById(Integer id) {
        String query = "from " + getDomainClassName() + " do  where do.id = :id";
        Query q = entityManager.createQuery(query);
        q.setParameter("id", id);
        return (T) q.getSingleResult();
    }

    @SuppressWarnings("unchecked")
    @Transactional
    public ArrayList<T> findAll() {
        String query = "from " + getDomainClassName() + " do";
        Query q = entityManager.createQuery(query);
        return (ArrayList<T>) q.getResultList();
    }
    
    @SuppressWarnings("unchecked")
	public T findByOcOID(String OCOID){
        String query = "from " + getDomainClassName() + " do  where do.oc_oid = :oc_oid";
        Query q = entityManager.createQuery(query);
        q.setParameter("oc_oid", OCOID);
        return (T) q.getSingleResult();
    }

    @Transactional
    public T saveOrUpdate(T domainObject) {
        //entityManager.
        getCurrentSession().saveOrUpdate(domainObject);
        return domainObject;
    }

    @Transactional
    public T save(T domainObject) {
        JpaEntityInformation<T, ?> entityInformation = JpaEntityInformationSupport.getEntityInformation(domainClass(), entityManager);

        if (entityInformation.isNew(domainObject)) {
            entityManager.persist(domainObject);
            return domainObject;
        } else {
            return entityManager.merge(domainObject);
        }
        //entityManager.find
    }

    //@Transactional
    //public Serializable save(T domainObject) {
    //    Serializable id = getCurrentSession().save(domainObject);
    //    return id;
    //}

    

    @Transactional
    public T findByColumnName(Object id,String key) {
    String query = "from " + getDomainClassName() + " do where do."+key +"= ?";
    org.hibernate.Query q = getCurrentSession().createQuery(query);
    q.setParameter(0, id);
    return (T) q.uniqueResult();
    } 
    
    public Long count() {
        return (Long) getCurrentSession().createQuery("select count(*) from " + domainClass().getName()).uniqueResult();
    }

    /**
     * @return Session Object
     */
    public Session getCurrentSession() {
        //return getSessionFactory().getCurrentSession();
        return entityManager.unwrap(Session.class);
    }
}
