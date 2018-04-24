package org.xi.dubbostudy.provider.service;

import org.xi.dubbostudy.service.TestService;

public class TestServiceImpl implements TestService {

    public String hello(String name, String sessionId) {
        return "hello " + name;
    }
}
