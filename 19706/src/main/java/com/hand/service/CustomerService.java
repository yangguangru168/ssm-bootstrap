package com.hand.service;

import com.hand.entity.Customer;

import java.util.List;

public interface CustomerService {

    /*查询用户名*/
    Customer userSelcte(String name);

    /*获取customer表的信息*/
    List<Customer> getCustomerAll();

    /*插入数据*/
    void insertCustomer(Customer customer);

    /*根据Id查询数据*/
    Customer getCustomerById(Integer id);

    /*更新数据*/
    void updateCustomer(Customer customer);

    /*删除数据*/
    void deleteCustomer(String id);

    /*批量删除*/
    void deletesCustomer(List<String> id);
}
