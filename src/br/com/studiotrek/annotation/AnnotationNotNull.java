package br.com.studiotrek.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AnnotationNotNull {
	String error() default "Atributo não poder ser nulo";
	int line() default 0;
}
