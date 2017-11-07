package benjamin.spring.ex.app.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class PerformanceHandler implements InvocationHandler {
    private Object target;
    PerformanceHandler(Object target) {
        this.target = target;
    }

    public Object invoke(Object proxy, Method method, Object[] args)
            throws InvocationTargetException, IllegalAccessException {
        PerformanceMonitor.begin(target.getClass().getName() + "." +
        method.getName());
        Object obj = method.invoke(target, args);
        PerformanceMonitor.end();
        return obj;
    }
}
