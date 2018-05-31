package org.xi.dsbstudy.provider.api.impl;

import com.alibaba.dubbo.config.annotation.Service;
import org.xi.dsbstudy.api.HelloApi;
import org.xi.dsbstudy.entity.User;

@Service
public class HelloApiImpl implements HelloApi {

    @Override
    public String hello() {
        return "hello ";
    }

    @Override
    public String hello(String name) {
        return "hello " + name;
    }

    @Override
    public String hello(String name, String sessionId) {
        return "hello " + name + ", session id: " + sessionId;
    }

    @Override
    public String hello(User user) {
        return "hello " + user;
    }
}
