package com.fedorov.springdemo.service;

import com.fedorov.springdemo.entity.Customer;

import java.util.List;

public interface CustomerService {

    public List<Customer> getCustomers();

   public void saveCustomer(Customer theCustomer);

    Customer getCustomers(int theId);

    void deleteCustomer(int theId);
}
