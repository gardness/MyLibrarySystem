package com.ascending.training.service;

import com.ascending.training.model.Customer;
import com.ascending.training.repository.BookDao;
import com.ascending.training.repository.CustomerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerDao customerDao;

    public long save(Customer customer) {
        return customerDao.save(customer);
    }

    public boolean update(Customer customer) {
        return customerDao.update(customer);
    }

    public boolean delete(String customerName) {
        return customerDao.delete(customerName);
    }

    public List<Customer> getCustomers() {
        return customerDao.getCustomers();
    }

    public Customer getCustomerByName(String customerName) {
        List<Customer> customers = customerDao.getCustomers();
        int i = 0;

        while (!customerName.equals(customers.get(i).getName())) {
            ++i;
        }

        if (customerName.equals(customers.get(i).getName())) {
            return customers.get(i);
        }

        return null;
    }

    public Customer getCustomerById(long customerId) { return customerDao.getCustomerById(customerId); }
}
