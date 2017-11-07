package benjamin.spring.ex.app.aspectJ.aop;

public class SellImpl implements Seller{
    public void sell(String goods, String person) {
        System.out.println("sell " + goods + " to " + person);
    }
}
