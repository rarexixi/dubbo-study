package org.xi.dubbostudy.service;

import org.xi.common.annotation.ParamName;

public interface TestService {

    String hello(String name, @ParamName("sessionId") String sessionId) throws Exception;
}
