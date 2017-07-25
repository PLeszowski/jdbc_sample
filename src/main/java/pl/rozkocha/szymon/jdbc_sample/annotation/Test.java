package pl.rozkocha.szymon.jdbc_sample.annotation;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RUNTIME)
@Target(METHOD)
public @interface Test {
	public String name() default "";
	
	public enum Level{
		LOW, MEDIUM, HIGH
	}
	
	public Level level() default Level.LOW;
}
