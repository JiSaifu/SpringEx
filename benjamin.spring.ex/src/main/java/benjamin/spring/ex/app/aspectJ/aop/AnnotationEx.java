package benjamin.spring.ex.app.aspectJ.aop;

import benjamin.spring.ex.app.AbstractEx;

import java.lang.reflect.Method;

public class AnnotationEx extends AbstractEx{
    @NeedTest
    public void method1() {
        System.out.println("This is method1.");
    }
    @NeedTest(value = false)
    public void method2() {
        System.out.println("This is method2.");
    }

    public void doEx() {
        Class clazz = AnnotationEx.class;
        Method[] methods = clazz.getDeclaredMethods();
        System.out.println(methods.length);

        for(Method method : methods) {
            NeedTest nt = method.getAnnotation(NeedTest.class);
            if (nt != null) {
                if (nt.value()) {
                    System.out.println(method.getName() + "() Need Test");
                } else {
                    System.out.println(method.getName() + "() Not need Test");
                }
            }
        }
    }
}
