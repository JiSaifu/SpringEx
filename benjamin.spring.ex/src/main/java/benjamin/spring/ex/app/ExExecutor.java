package benjamin.spring.ex.app;

import benjamin.spring.ex.app.aspectJ.aop.AnnotationEx;
import benjamin.spring.ex.app.aspectJ.aop.AspectJProxyEx;

public class ExExecutor {
    public static void main(String[] args) {
        AbstractEx ex =
                new AspectJProxyEx();
//                new AnnotationEx();
//                new ForumServiceImpl();
//                new BeforeAdviceEx();
//                new IntroduceEx();
//                new AdvisorEx();
        ex.doEx();
    }
}
