package homework8.task3;


import java.lang.annotation.Inherited;


@FirstA
public class First {
    int a;

    @SecondB("Second_B")
    public void sout(String str) {
        System.out.println(str);
    }

    @SecondB("Second_C")
    public void sout1(String str) {
        System.out.println(str);
    }

    @ThirdC
    public void sout2(String str) {
        System.out.println(str);
    }

}
