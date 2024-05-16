package annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD) // 이 어노테이션은 메서드를 타겟으로 적용된다!!
public @interface PrintAnnotation {
    String value() default "*";

    int number() default 5;
}
