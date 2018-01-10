package br.com.studiotrek.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation para model
 * Obs.: O atributo line corresponde ao numero da linha que a entidade se encontra (Retorna linha na exception)
 * @author kleber
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AnnotationModel {
	
	enum TypeSQL {
		TINYINT, SMALLINT, INT, BIGINT, BIT, DECIMAL, NUMERIC, SMALLMONEY, MONEY, CHAR, VARCHAR, TEXT,
		NVARCHAR, NTEXT, REAL, DOUBLE, DATETIME, SMALLDATETIME, NOTHING
	}
	
	int maxSize() default 0;
	TypeSQL typeSQL() default TypeSQL.NOTHING;
	String error() default "Tamanho de caracters maior que o permitido";
	int line() default 0;
}