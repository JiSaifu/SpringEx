package benjamin.spring.ex.app.aop;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class GreetingAfterAdvice implements AfterReturningAdvice {
    public void afterReturning(Object returnObj, Method method, Object[] args, Object obj) throws Throwable {
        System.out.println("Please enjoy yourself!");
    }
}
