package homework7.task3;

public class Cat {
    public int a;
    private String s ="";
    long l;

    public Cat(int a) {
        this.a = a;
    }

    protected Cat(int a, String s) {
        this.a = a;
        this.s = s;
    }

    private Cat(int a, String s, long l) {
        this.a = a;
        this.s = s;
        this.l = l;
    }

    public int getA() {
        return a;
    }

    private void setA(int a) {
        this.a = a;
    }

    public String getS() {
        return s;
    }

    private void setS(String s) {
        this.s = s;
    }

    public long getL() {
        return l;
    }

    private void setL(long l) {
        this.l = l;
    }
}
