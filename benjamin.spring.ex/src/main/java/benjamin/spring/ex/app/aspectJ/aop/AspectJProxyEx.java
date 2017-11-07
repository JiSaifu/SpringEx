package benjamin.spring.ex.app.aspectJ.aop;

import benjamin.spring.ex.app.AbstractEx;
import benjamin.spring.ex.app.aop.Waiter;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AspectJProxyEx extends AbstractEx {
    public void doEx() {
        Waiter target = new NaiveWaiter();
        AspectJProxyFactory factory = new AspectJProxyFactory();

        factory.setTarget(target);
        factory.addAspect(PreGreetingAspect.class);

        ApplicationContext ctx = new ClassPathXmlApplicationContext(new String[]{
                "c7_beans.xml"
        });

        // 使用AspectJProxyFactory编程配置Proxy方式
        Waiter proxy = factory.getProxy();

        // 使用Spring配置文件配置Proxy方式
        Waiter confProxy = (Waiter)ctx.getBean("waiter");

        //proxy.greetTo("Xinwei");
        //proxy.serveTo("Xiaomaoyu");

        confProxy.greetTo("Damaowei");
        confProxy.serveTo("Damaoyu");

        ((Seller)confProxy).sell("beer", "dasaisai");

        NaiveWaiter confProxy2 = (NaiveWaiter)ctx.getBean("waiter");
        confProxy2.smileTo("maoi", "moana",1,3);
    }
}
