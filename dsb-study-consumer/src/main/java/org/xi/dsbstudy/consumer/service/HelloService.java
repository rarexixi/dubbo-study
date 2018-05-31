package org.xi.dsbstudy.consumer.service;

import org.xi.dsbstudy.entity.User;

public interface HelloService {

    String hello();

    String hello(String name);

    String hello(String name, String sessionId);

    String hello(User user);
}
