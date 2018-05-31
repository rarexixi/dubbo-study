package org.xi.dsbstudy.api;

import org.xi.common.annotation.ParamName;
import org.xi.dsbstudy.entity.User;

public interface HelloApi {

    String hello();

    String hello(String name);

    String hello(String name, @ParamName("sessionId") String sessionId);

    String hello(User user);
}
