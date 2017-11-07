package benjamin.spring.ex.app.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class GreetingInterceptor implements MethodInterceptor {
    public Object invoke(MethodInvocation invocation) throws Throwable {
        Object[] args = invocation.getArguments();
        String clientName = (String)args[0];
        System.out.println("[Method interceptor]How are you! Mr." + clientName);
        // 通过反射机制调用目标方法
        Object obj = invocation.proceed();
        System.out.println("[Method interceptor]Please enjoy yourself!");
        return obj;
    }
}
