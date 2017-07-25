package pl.rozkocha.szymon.jdbc_sample.annotation;

public class MyTests extends Tests {
	
	@Test(name = "Test1")
	public void test1() {
		
	}
	
	@Test
	public void test2() {
		throw new NullPointerException("Error!");
	}
	
	@Test(name = "Test3", level = Test.Level.HIGH)
	public void test3() {
		
	}
	
	@Test(name = "Test4", level = Test.Level.MEDIUM)
	public void test4() {
		
	}
	
	public static void main( String[] args )
    {
		new MyTests().run();
    }
}
