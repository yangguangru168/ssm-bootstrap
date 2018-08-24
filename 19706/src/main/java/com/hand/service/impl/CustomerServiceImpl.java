package com.hand.service.impl;

import com.hand.entity.Customer;
import com.hand.mapper.CustomerMapper;
import com.hand.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerMapper customerMapper;
    @Override
    public Customer userSelcte(String name) {
        Customer customer = customerMapper.userNameSelect(name);
        return customer;
    }

    @Override
    public List<Customer> getCustomerAll() {
        List<Customer> customer = customerMapper.customerSelectAlls();
        return customer;
    }

    @Override
    public void insertCustomer(Customer customer) {
        Date date = new Date();
        customer.setLastUpdate(date);
        customerMapper.customerInsert(customer);
    }

    @Override
    public Customer getCustomerById(Integer id) {
        Customer customer = customerMapper.getCustById(id);
        return customer;
    }

    @Override
    public void updateCustomer(Customer customer) {
        Date date = new Date();
        customer.setLastUpdate(date);
        customerMapper.customerUpdate(customer);
    }

    @Override
    public void deleteCustomer(String id) {
        customerMapper.customerDelete(id);
    }

    @Override
    public void deletesCustomer(List<String> id) {
        for (String lisiId: id) {
            customerMapper.customerDelete(lisiId);
        }
    }
}
