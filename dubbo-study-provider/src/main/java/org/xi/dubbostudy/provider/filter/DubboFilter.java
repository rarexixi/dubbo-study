package org.xi.dubbostudy.provider.filter;

import com.alibaba.dubbo.common.Constants;
import com.alibaba.dubbo.common.extension.Activate;
import com.alibaba.dubbo.rpc.*;
import org.xi.dubbostudy.annotation.ParamName;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

@Activate(group = Constants.PROVIDER)
public class DubboFilter implements Filter {

    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) {
        String re = "Error";
        Result result = null;

        Object name = "";
        try {
            long sessionid = System.currentTimeMillis();
            result = invoker.invoke(invocation);
            Object sessionId = getSessionId(invoker.getInterface(), invocation.getMethodName(),
                    invocation.getParameterTypes(), invocation.getArguments());
        } catch (RuntimeException e) {
            StringBuffer sb = new StringBuffer("");
            sb.append("DUBBO-CATCH-EXCEPTION：");
            sb.append(RpcContext.getContext().getRemoteHost());
            sb.append(". SERVICE： ");
            sb.append(invoker.getInterface().getName());
            sb.append("， METHOD： ");
            sb.append(invocation.getMethodName());
            sb.append("， EXCEPTION： ");
            sb.append(e.getClass().getName());
            sb.append("：");
            sb.append(e.getMessage());
            return new RpcResult(re);
        }
        return result;
    }

    Object getSessionId(Class<?> clazz, String methodName, Class<?>[] parameterTypes, Object[] args) {

        try {
            Method method = clazz.getMethod(methodName, parameterTypes);
            Parameter[] parameters = method.getParameters();
            for (int i = 0; i < parameters.length; i++) {
                Parameter parameter = parameters[i];
                for (Annotation annotation : parameter.getAnnotations()) {
                    if (annotation instanceof ParamName && ((ParamName) annotation).value().equalsIgnoreCase("sessionId")) {
                        return args[i];
                    }
                }
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return null;
    }
}
