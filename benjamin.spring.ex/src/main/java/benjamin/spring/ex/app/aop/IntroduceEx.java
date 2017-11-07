package benjamin.spring.ex.app.aop;

import benjamin.spring.ex.app.AbstractEx;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IntroduceEx extends AbstractEx {
    public void doEx() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext(new String[] {
                "c6_beans.xml"
        });
        ForumService forumService = (ForumService)ctx.getBean("forumService");
        forumService.removeForum(1);
        forumService.removeTopic(2);

        Monitorable monitorable = (Monitorable)forumService;
        monitorable.setMonitorActive(true);

        forumService.removeForum(1);
        forumService.removeTopic(2);
    }
}
