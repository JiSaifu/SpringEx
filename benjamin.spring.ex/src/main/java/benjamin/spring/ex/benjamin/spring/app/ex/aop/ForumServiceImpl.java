package benjamin.spring.ex.benjamin.spring.app.ex.aop;

import benjamin.spring.ex.benjamin.spring.app.ex.AbstractEx;

import java.lang.reflect.Proxy;

import static java.lang.Thread.sleep;

public class ForumServiceImpl extends AbstractEx implements ForumService {

    public void removeTopic(int topicId) {
        // ↓具有横切逻辑特征的代码
        // PerformanceMonitor.begin(this.getClass().getName());
        System.out.println("模拟删除topic记录:" + topicId);
        try {
            sleep(20);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        // ↓具有横切逻辑特征的代码
        // PerformanceMonitor.end();
    }

    public void removeForum(int forumId) {
        // PerformanceMonitor.begin(this.getClass().getName());
        System.out.println("模拟删除forum记录:" + forumId);
        try {
            sleep(40);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        // PerformanceMonitor.end();
    }

    @Override
    public void doEx() {
        // removeTopic(1);
        // removeForum(2);

        ForumService target = new ForumServiceImpl();
        PerformanceHandler handler = new PerformanceHandler(target);

        ForumService proxy = (ForumService) Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                handler);
        proxy.removeForum(1);
        proxy.removeTopic(2);
    }
}
