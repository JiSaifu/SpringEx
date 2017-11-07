package benjamin.spring.ex.app.aop;

import benjamin.spring.ex.app.AbstractEx;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeforeAdviceEx extends AbstractEx {
    public void doEx() {
        Waiter waiter = new NaiveWaiter();
        GreetingBeforeAdvice beforeAdvice = new GreetingBeforeAdvice();

        // 1.Spring提供的代理工厂
        ProxyFactory pf = new ProxyFactory();

        // 2.设置代理目标
        pf.setTarget(waiter);

        // 指定针对接口进行代理的话，将启动JdkDynamicAopProxy
        // 但如果setOptimize为True的话，将使用Cglib2AopProxy
        pf.setInterfaces(waiter.getClass().getInterfaces());
        pf.setOptimize(true);

        // 3.为代理目标添加增强
        pf.addAdvice(beforeAdvice);

        // 4.生成代理实例
        // ↓采用普通方式生成代理类
        // Waiter proxy = (Waiter)pf.getProxy();

        // 采用Spring配置文件方式生成代理类
        ApplicationContext ctx = new ClassPathXmlApplicationContext(new String[]{
                "c6_beans.xml"
        });
        Waiter proxy = (Waiter)ctx.getBean("waiter");

        proxy.greetTo("Dawei");
        proxy.serveTo("Xiaomaoyu");

    }
}
