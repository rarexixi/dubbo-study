package org.xi.dsbstudy.consumer.filter;

import com.alibaba.dubbo.common.Constants;
import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.extension.Activate;
import com.alibaba.dubbo.rpc.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Activate(group = Constants.CONSUMER, before = "future")
public class DubboFilter implements Filter {

    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {

        URL url = invoker.getUrl();
        String methodName = invocation.getMethodName();
        String interfaceName = invoker.getInterface().getName();

        Logger logger = LoggerFactory.getLogger(interfaceName);

        logger.info(url.toString());
        logger.info(methodName);

        return invoker.invoke(invocation);
    }
}
