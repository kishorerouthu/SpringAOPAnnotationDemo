package com.css.spring.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.css.spring.aop.bo.CustomerBo;

/**
 * Hello world!
 */
public class App {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-beans.xml");
        CustomerBo customerBo = applicationContext.getBean(CustomerBo.class);
        customerBo.addCustomer();
        customerBo.addCustomerReturnValue();
        try {
            customerBo.addCustomerThrowException();
        } catch (Exception e) {
            //hide it
        }
        customerBo.addCustomerAround("kishore");
    }
}
