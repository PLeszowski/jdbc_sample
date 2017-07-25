package pl.rozkocha.szymon.jdbc_sample.annotation;

import java.lang.reflect.Method;

public class Tests {
	public void run() {
		Method[] methods = this.getClass().getDeclaredMethods();
		
		for(Method method : methods) {
			if(method.isAnnotationPresent(Test.class)) {
				Test test = method.getAnnotation(Test.class);
				System.out.println("Test: " + test.name());
				System.out.println("Level: " + test.level().toString());
				
				try {
					method.invoke(this);
					System.out.println("OK");
				} catch (Throwable e) {
					System.out.println("Error: " + e.toString());
				}
				
			}
		}
	}
}
