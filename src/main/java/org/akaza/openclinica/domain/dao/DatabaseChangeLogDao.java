package org.akaza.openclinica.domain.dao;

import org.akaza.openclinica.domain.datamap.DatabaseChangeLogBean;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class DatabaseChangeLogDao {

    private SessionFactory sessionFactory;

    public String getDomainClassName() {
        return domainClass().getName();
    }

    public Class<DatabaseChangeLogBean> domainClass() {
        return DatabaseChangeLogBean.class;
    }

    @SuppressWarnings("unchecked")
    public ArrayList<DatabaseChangeLogBean> findAll() {
        String query = "from " + getDomainClassName() + " dcl order by dcl.id desc ";
        org.hibernate.Query q = getCurrentSession().createQuery(query);
        return (ArrayList<DatabaseChangeLogBean>) q.list();
    }

    public DatabaseChangeLogBean findById(String id, String author, String fileName) {
        String query = "from " + getDomainClassName() + " do  where do.id = :id and do.author = :author and do.fileName = :fileName ";
        org.hibernate.Query q = getCurrentSession().createQuery(query);
        q.setString("id", id);
        q.setString("author", author);
        q.setString("fileName", fileName);
        return (DatabaseChangeLogBean) q.uniqueResult();
    }

    public Long count() {
        return (Long) getCurrentSession().createQuery("select count(*) from " + domainClass().getName()).uniqueResult();
    }

    /**
     * @return the sessionFactory
     */
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    /**
     * @param sessionFactory
     *            the sessionFactory to set
     */
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    /**
     * @return Session Object
     */
    protected Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
}
