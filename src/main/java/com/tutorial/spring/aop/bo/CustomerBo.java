package com.tutorial.spring.aop.bo;

/**
 * Created by kishore on 21/1/17.
 */
public interface CustomerBo {

    void addCustomer();

    String addCustomerReturnValue();

    void addCustomerThrowException() throws Exception;

    void addCustomerAround(String name);
}
