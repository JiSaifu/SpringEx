package benjamin.spring.ex.app.aop;

public class NaiveWaiter implements Waiter {
    public void greetTo(String name) {
        System.out.println("greet to " + name);
    }
    public void serveTo(String name) {
        System.out.println("serving to " + name);
    }
}
