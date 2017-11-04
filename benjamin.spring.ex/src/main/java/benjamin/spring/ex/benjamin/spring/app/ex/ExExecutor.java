package benjamin.spring.ex.benjamin.spring.app.ex;

import benjamin.spring.ex.benjamin.spring.app.ex.aop.ForumServiceImpl;

public class ExExecutor {
    public static void main(String[] args) {
        AbstractEx ex =
                new ForumServiceImpl();

        ex.doEx();
    }
}
