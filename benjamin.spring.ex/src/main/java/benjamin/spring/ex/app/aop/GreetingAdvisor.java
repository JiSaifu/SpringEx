package benjamin.spring.ex.app.aop;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.StaticMethodMatcherPointcutAdvisor;

import java.lang.reflect.Method;

public class GreetingAdvisor extends StaticMethodMatcherPointcutAdvisor {
    public boolean matches(Method method, Class clazz) {
        System.out.println(clazz.getName() + "." + method.getName());
        return "greetTo".equals(method.getName());
    }

    @Override
    public ClassFilter getClassFilter() {
        return new ClassFilter() {
            public boolean matches(Class clazz) {
                return Waiter.class.isAssignableFrom(clazz);
            }
        };
    }
}
