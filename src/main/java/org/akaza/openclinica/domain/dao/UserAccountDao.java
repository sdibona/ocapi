package org.akaza.openclinica.domain.dao;

import org.akaza.openclinica.domain.datamap.UserAccount;
import org.hibernate.engine.spi.SessionImplementor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.sql.Connection;
import java.sql.DatabaseMetaData;

@Repository
public class UserAccountDao /*extends AbstractDomainDao<UserAccount>*/ {

    @PersistenceContext
    private EntityManager entityManager;

    //@Override
    //public Class<UserAccount> domainClass() {
    //    return UserAccount.class;
   // }

    public UserAccount findByUserName(String userName) {
        String query = "from " + UserAccount.class.getName() + " do  where do.userName = :user_name";
        Query q = entityManager.createQuery(query);
        q.setParameter("user_name", userName);
        return (UserAccount) q.getSingleResult();
    }

    public UserAccount findByUserId(Integer userId) throws Exception {
        SessionImplementor sessionImp = (SessionImplementor) entityManager.getDelegate();
        Connection conn = sessionImp.connection();
        DatabaseMetaData metadata = conn.getMetaData();
        System.out.println("UserAccountDao connection schema is: " + conn.getSchema());

        String query = "from " + UserAccount.class.getName() + " do  where do.userId = :user_id";
        Query q = entityManager.createQuery(query);
        q.setParameter("user_id", userId);


        return (UserAccount) q.getSingleResult();
    }

    public UserAccount findById(Integer id) {
        String query = "from " + UserAccount.class.getName() + " do  where do.id = :id";
        Query q = entityManager.createQuery(query);
        q.setParameter("id", id);
        return (UserAccount) q.getSingleResult();
    }

/*
    public UserAccount findByUserName(String userName) {
        getSessionFactory().getStatistics().logSummary();
        String query = "from " + getDomainClassName() + " do  where do.userName = :user_name";
        org.hibernate.Query q = getCurrentSession().createQuery(query);
        q.setString("user_name", userName);
        return (UserAccount) q.uniqueResult();
    }

    public UserAccount findByUserId(Integer userId) {
        //getSessionFactory().getStatistics().logSummary();
        String query = "from " + getDomainClassName() + " do  where do.userId = :user_id";
        org.hibernate.Query q = getCurrentSession().createQuery(query);
        q.setInteger("user_id", userId);
        return (UserAccount) q.uniqueResult();
    }
*/
}
