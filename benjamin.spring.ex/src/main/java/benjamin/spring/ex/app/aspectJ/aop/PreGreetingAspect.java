package benjamin.spring.ex.app.aspectJ.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class PreGreetingAspect {
    // @Before：增强类型
    // executing...：目标切点表达式
    @Before("execution(* greetTo(..)) && args(Double)")
    public void beforeGreeting() {
        System.out.println("How are you!");
    }
}
