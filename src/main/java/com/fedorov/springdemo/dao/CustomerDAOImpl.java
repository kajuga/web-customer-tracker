package com.fedorov.springdemo.dao;

import com.fedorov.springdemo.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

    //need to inject the session factory
    @Autowired
    private SessionFactory sessionFactory;

    @Override
//    @Transactional
    public List<Customer> getCustomers() {

        //get the hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        //create a query...
//        Query<Customer> theQuery = currentSession.createQuery("from Customer", Customer.class);
        //create a query... SORTED
        Query<Customer> theQuery = currentSession.createQuery("from Customer order by lastName", Customer.class);

        //execute query and get result list
        List<Customer> customers = theQuery.getResultList();

        //return the result
        return customers;
    }

    @Override
    @Transactional
    public void saveCustomer(Customer theCustomer) {
        Session currentSession = sessionFactory.getCurrentSession();
//        IMPORTANT!! If i have 'id' in param - i can use 'saveOrUpdate()..' as this case, else - 'update'
        currentSession.saveOrUpdate(theCustomer);
    }

    @Override
    public Customer getCustomers(int theId) {

//        get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

//        now retrieve/read from databasr using the primary key
        Customer theCustomer = currentSession.get(Customer.class, theId);
        return theCustomer;
    }

    @Override
    public void deleteCustomer(int theId) {
        Session currentSession = sessionFactory.getCurrentSession();

        Query theQuery = currentSession.createQuery("delete from Customer where id=:customerId");
        theQuery.setParameter("customerId", theId);
        theQuery.executeUpdate();
    }
}





















