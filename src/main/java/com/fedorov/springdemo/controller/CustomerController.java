package com.fedorov.springdemo.controller;

import com.fedorov.springdemo.dao.CustomerDAO;
import com.fedorov.springdemo.entity.Customer;
import com.fedorov.springdemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    //need to inject CustomerService
    @Autowired
    private CustomerService customerService;

    // @RequestMapping("/list")
    //add mapping ONLY for GET requests:
    @GetMapping("/list")
    public String listCustomewrs(Model theModel) {
        //get costomers from the DAO
        List<Customer> theCustomers = customerService.getCustomers();
        //add the customers to the model
        theModel.addAttribute("customers", theCustomers);
        return "list-customers";
    }

    @GetMapping("/showFormAdd")
    public String showFormForAdd(Model theModel) {

        Customer theCustomer = new Customer();
        theModel.addAttribute("customer", theCustomer);
        return "customer-form";
    }

    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {
        customerService.saveCustomer(theCustomer);
        return "redirect:/customer/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormUpdate(@RequestParam("customerId") int theId, Model theModel) {

//        get the customer from the database
        Customer theCustomer =customerService.getCustomers(theId);

//        set customer as a model attribute to pre-populate the form
        theModel.addAttribute("customer", theCustomer);

//        send over to our form
        return "customer-form";
    }

    @GetMapping("/delete")
    public String deleteCustomer(@RequestParam("customerId") int theId) {
        customerService.deleteCustomer(theId);
        return "redirect:/customer/list";
    }
}



















