package com.hand.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hand.entity.Address;
import com.hand.entity.Customer;
import com.hand.entity.Msg;
import com.hand.service.AddressService;
import com.hand.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;
    @Autowired
    private AddressService addressService;

    /*登陆验证*/
    @ResponseBody
    @RequestMapping(value = "/user/userCheck" ,method = RequestMethod.GET)
    public Msg loginCheck(Customer cus, HttpServletRequest request){
        String firstName = cus.getFirstName();
        String lastName = cus.getLastName();

        Customer customer = customerService.userSelcte(firstName);
        if (customer!=null){
            if(customer.getLastName().equals(lastName)){
                HttpSession session = request.getSession();
                session.setAttribute("username",firstName);
                return Msg.success();
            }else {
                return Msg.fail().add("pwd","密码错误");
            }
        }else {
            return Msg.fail().add("user","用户名不存在");
        }

    }

    /*获取Customer表的信息,然后进行分页查询*/
    @ResponseBody
    @RequestMapping(value = "/cust/find",method = RequestMethod.GET)
    public Msg getCustomerList(@RequestParam Integer pn){
        PageHelper.startPage(pn,5);
        List<Customer> customer = customerService.getCustomerAll();
        PageInfo page = new PageInfo(customer,5);
        return Msg.success().add("customer",page);
    }

    /*查询Address表的信息*/
    @ResponseBody
    @RequestMapping(value = "/cust/findAdderss",method = RequestMethod.GET)
    public Msg getAddressList(){
        List<Address> addresses = addressService.getAddressAll();
        return Msg.success().add("addr",addresses);
    }

    /*数据插入*/
    @ResponseBody
    @RequestMapping(value = "/cust/add",method = RequestMethod.POST)
    public Msg insert(Customer customer){
        customerService.insertCustomer(customer);
        return Msg.success();
    }

    /*根据id获取Customer的数据*/
    @ResponseBody
    @RequestMapping(value = "/cust/findId/{id}",method = RequestMethod.GET)
    public Msg getFilm(@PathVariable(value = "id") Integer id){
        Customer customer = customerService.getCustomerById(id);
        return Msg.success().add("selectCust",customer);
    }
    /*数据更新*/
    @ResponseBody
    @RequestMapping(value = "/cust/edit/{customerId}",method = RequestMethod.PUT)
    public Msg update(Customer customer){
        System.out.println(customer);
        customerService.updateCustomer(customer);
        return Msg.success();
    }

    /*删除数据*/
    @ResponseBody
    @RequestMapping(value = "/cust/delete/{id}",method = RequestMethod.DELETE)
    public Msg delete(@PathVariable("id") String id){
        List<String> list = new ArrayList<String>();
        if(id.contains("-")){
            String[] strings = id.split("-");
            for (String ids: strings) {
                list.add(ids);
            }
            customerService.deletesCustomer(list);
            return Msg.success();
        }else {
            customerService.deleteCustomer(id);
            return Msg.success();
        }
    }
    /*退出登陆*/
    @ResponseBody
    @RequestMapping(value = "/cust/exit")
    public Msg doExit(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.getSession().removeAttribute("username");
        return Msg.success();
    }
}
