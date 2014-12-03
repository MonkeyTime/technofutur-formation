package be.reference;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;

@Retention(value=RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Annot1 {
	String value() default "toto";
	int intValue() default 50;
	boolean boolValue() default true;
}
