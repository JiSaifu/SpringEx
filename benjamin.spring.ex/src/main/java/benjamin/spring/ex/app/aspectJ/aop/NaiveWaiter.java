package benjamin.spring.ex.app.aspectJ.aop;

import benjamin.spring.ex.app.aop.Waiter;

public class NaiveWaiter implements Waiter {
    public void greetTo(String name) {
        System.out.println("greet to " + name);
    }
    public void serveTo(String name) {
        System.out.println("serving to " + name);
    }
    public void smileTo(String name1, String name2, int times1, int times2) {
        System.out.println("Smile to " + name1 + " " + times1 + " time(s)");
        System.out.println("Smile to " + name2 + " " + times2 + " time(s)");
    }
}
