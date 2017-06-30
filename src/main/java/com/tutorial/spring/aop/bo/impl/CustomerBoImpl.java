package com.tutorial.spring.aop.bo.impl;

import org.springframework.aop.framework.AopContext;

import com.tutorial.spring.aop.bo.CustomerBo;

/**
 * Created by kishore on 22/1/17.
 */
public class CustomerBoImpl implements CustomerBo {

    public void addCustomer() {
        AopContext.currentProxy();
        System.out.println("addCustomer() is running...!");
    }

    public String addCustomerReturnValue() {
        System.out.println("addCustomerReturnValue is running...! ");
        return "random";
    }

    public void addCustomerThrowException() throws Exception {
        System.out.println("addCustomerThrowException() is running...! ");
        throw new Exception("Generic Exception");
    }

    public void addCustomerAround(String name) {
        System.out.println("addCustomerAround() is running, args " + name);
    }
}
