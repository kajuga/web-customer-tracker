package com.fedorov.springdemo.dao;

import com.fedorov.springdemo.entity.Customer;
import java.util.List;

public interface CustomerDAO {

    public List<Customer> getCustomers();


    void saveCustomer(Customer theCustomer);

    Customer getCustomers(int theId);

    void deleteCustomer(int theId);
}
