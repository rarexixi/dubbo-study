package org.xi.dsbstudy.consumer.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;
import org.xi.dsbstudy.api.HelloApi;
import org.xi.dsbstudy.consumer.service.HelloService;
import org.xi.dsbstudy.entity.User;

@Service("helloService")
public class HelloServiceImpl implements HelloService {

    @Reference
    private HelloApi helloApi;

    @Override
    public String hello() {
        return helloApi.hello();
    }

    @Override
    public String hello(String name) {
        return helloApi.hello(name);
    }

    @Override
    public String hello(String name, String sessionId) {
        return helloApi.hello(name, sessionId);
    }

    @Override
    public String hello(User user) {
        return helloApi.hello(user);
    }
}
