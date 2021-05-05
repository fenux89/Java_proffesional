package homework8.task2;

import java.lang.annotation.*;

/**
 *
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Calc {
    /**
     * a number a
     * @return
     */
    int a() default 5;

    /**
     * b number b
     * @return
     */
    int b() default 2;
}
