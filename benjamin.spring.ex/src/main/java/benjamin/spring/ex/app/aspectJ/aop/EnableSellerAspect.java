package benjamin.spring.ex.app.aspectJ.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class EnableSellerAspect {
    @DeclareParents(value="benjamin.spring.ex.app.aspectJ.aop.NaiveWaiter",
    defaultImpl = SellImpl.class)
    public Seller seller;

    @Before("this(benjamin.spring.ex.app.aop.Waiter)")
    public void thisTest() {
        System.out.println("thisTest() executed");
    }

    @AfterReturning("target(benjamin.spring.ex.app.aspectJ.aop.NaiveWaiter)")
    public void targetTest() {
        System.out.println("targetTest() executed");
    }

    @Around("execution(* greetTo(..))")
    public void testJoinPoint(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("----- Join Point Access -----");
        if (pjp.getArgs() != null) {
            for (Object arg : pjp.getArgs()) {
                System.out.println("print args:" + arg);
            }
        }
        pjp.proceed(new Object[]{"xiaomaowei"});
        System.out.println(pjp.getSignature());
        System.out.println("----- Join Point Access -----");
    }

    @Pointcut("execution(* smileTo(..))")
    private void inArgBinding(){}

    @Before("inArgBinding() && args(name1, name2, times1, times2)")
    public void testArgsBinding(int times1, String name2, int times2, String name1){
        System.out.println("name1:" + name1);
        System.out.println("name2:" + name2);
        System.out.println("times1:" + times1);
        System.out.println("times2:" + times2);
    }

}
