package org.xi.dubbostudy.consumer;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.xi.dubbostudy.service.TestService;

import java.io.IOException;
import java.util.Date;


public class Consumer {
    public static void main(String[] args) throws Exception {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"dubbo-consumer-beans.xml"});
        context.start();

        TestService testService = (TestService) context.getBean("testService");
        System.out.println(new Date());
        for (int i = 0; i < 10000; i++) {
            System.out.println(testService.hello("xi" + i, "session " + i));
        }
        System.out.println(new Date());

    }
}
