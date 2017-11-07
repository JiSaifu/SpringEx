package benjamin.spring.ex.app.aop;

import benjamin.spring.ex.app.AbstractEx;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AdvisorEx extends AbstractEx {
    public void doEx() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext(new String[]{
                "c6_beans.xml"
        });
        Waiter proxy = (Waiter)ctx.getBean("waiter2");

        proxy.greetTo("Dawei");
        proxy.serveTo("Xiaomaoyu");

    }
}
