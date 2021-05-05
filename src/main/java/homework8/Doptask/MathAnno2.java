package homework8.Doptask;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(MathAnno.class)
public @interface MathAnno2 {
    int num1() default 2 ;
    int num2() default 3;
}
