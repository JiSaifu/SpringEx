package benjamin.spring.ex.app.aop;

class MethodPerformance {
    private long begin;
    private String serviceMethod;

    MethodPerformance(String serviceMethod) {
        this.serviceMethod = serviceMethod;
        this.begin = System.currentTimeMillis();
    }

    void printPerformance() {
        long elapse = System.currentTimeMillis() - begin;
        System.out.println(serviceMethod + "花费" + elapse + "毫秒");
    }
}
