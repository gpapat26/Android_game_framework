package paketo3;

import java.io.FileNotFoundException;
import java.io.IOException;

public class TestingExceptions {
	
//	public static final int numer;
//	static {
//		int a = 0;
//		try{
//			
//		a=Integer.parseInt("a");
//		
//		}catch(ExceptionInInitializerError b){
//			
//		}
//		finally{
//			numer = a;
//		}
//	}
	
	public static void main(String args[]) {
		System.out.println("Inside main");

		//doSomething();
		
		dodo();
		
//		try {
//			System.out.println("work real hard");
//			} catch (FileNotFoundException e) {
//			} catch (RuntimeException e) {
//			}
		 


	}
	
	public static void test() throws Exception{
		throw new Exception();
	}
	
	public static Exception doSomething() {
         int i = 0;
		try {
			System.out.println("Inside try "+ ++i);
			
			 throw new RuntimeException();
			 } catch (RuntimeException e) {
				 
				 System.out.println("Inside Runtime catch"+ ++i);
				 return new Exception();
				 
				 
			 } finally {
			System.out.println("Inside finally"+i);
			}
		
	}
	
	public static void dodo(){
		//throw new NullPointerException();
	}
	
	

}
