package com.hand.mapper;

import com.hand.entity.Customer;

import java.util.List;

public interface CustomerMapper {
    /*用户姓名查询*/
    Customer userNameSelect(String name);

    /*获取Customer表的信息*/
    List<Customer> customerSelectAlls();

    /*数据的插入*/
    void customerInsert(Customer customer);

    /*根据Id查询出数据*/
    Customer getCustById(Integer id);

    /*更新数据*/
    void customerUpdate(Customer customer);

    /*删除数据*/
    void customerDelete(String id);
}
