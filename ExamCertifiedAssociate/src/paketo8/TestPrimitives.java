package paketo8;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class TestPrimitives extends TestPrimitParent{
	int i =3;
	
	String  Exception = "String";
	double sq = 1;
	
	//Double sq1 = 1;
	
	static int o = 14;
	
//	public TestPrimitives() {
//		printSomething();
//	}
	
//	public static void printSum(int a, int b){ 
//		System.out.println("In int "+(a+b));
//		}
	
	public static void printSum(Integer a, Integer b){ 
		System.out.println("In Integer "+(a+b));
	}
//	public static void printSum(double a, double b){ 
//		System.out.println("In double "+(a+b));
//	}
	
	public static void printSum(Double a, Double b){ 
		System.out.println("In Double "+(a+b));
	}
	
	static void doSomethingElse() { 
		throw new RuntimeException("Sorry, can't do something else");
	}
	
	
	
	
	public static void printSum(Long a, Long b){ 
		System.out.println("In Long "+(a+b));
	}
	
//	public static void printSum(float a, float b){ 
//		System.out.println("In float "+(a+b));
//	}
	
	public static void printSum(short a, short b){ 
		System.out.println("In short "+(a+b));
	}
	
	public static void printSum( byte a, byte b){ 
		System.out.println("In short "+(a+b));
	}
	
	public void printSomething(){
		StringBuilder t = new StringBuilder("test this is a stringBuilder");
		System.out.println(i+" o="+o + " "+ t );
		
	}
	
	public static float parseFloat( String s ){
	     float f = 0.0f;      // 1
	     try{
	          f = Float.valueOf( s ).floatValue();    // 2
	          throw new NumberFormatException();
	               // 3
	     }
	     catch(NumberFormatException nfe){
	        f = 10 ;    // 4
//	       return f;     // 5
	     }
	     finally {
	    	 f=1;
	         return f;     // 6
	     }
//	     return f ;    // 7
	 }
	
		public static void doSom(){
			
		}
		
		
	
	    public  void doSom(int so){
			
		}
			
	
	public static void main(String args[]) throws Exception, RuntimeException{
		byte a =1;
		byte b = 2;
		printSum(1,2);
		doSomethingElse();
		
		
//		LocalDate d1 = LocalDate.parse("2015-02-05", DateTimeFormatter.ISO_DATE);//T17:13:50");
//		LocalDate d2 = LocalDate.parse("2015-02-05", DateTimeFormatter.ISO_LOCAL_DATE);//T17:13:50");
//	    LocalDate d3 = LocalDate.of(2015, 2, 5);
//		LocalDate d4 = LocalDate.now(); 
//		LocalDateTime d5 = LocalDateTime.now();
//		
//		System.out.println(d1); 
//		System.out.println(d2);
//		System.out.println(d3);
//		System.out.println(d4);
//		System.out.println(d5);
		
		
//		int i=2;
//		int [] a[][] = new int[i][i++][++i];
//		int b[][][] = new int[i][i++][++i];
//		
//		int[][][] c = new int[i][i++][++i];
//		
//		int[][] d[] = new int[i][i++][++i];
//		
//		int[][] e = new int[i][i++];
//		
//		int f[][] = new int[i][i++];
//		
//		System.out.println(a.length);
//		System.out.println(a[0].length);
//		System.out.println(a[0][0].length);
//		
		List<Double> list = new ArrayList<Double>();
	
//		list.add(1.2);
//		list.in
//		
//		double d1 = 1;
		
		
//		System.out.println(parseFloat("12"));
//		TestPrimitParent a = new TestPrimitives();
		
//		test2 : {
//			
//		
//		 test1 :
//		{
//			System.out.println("go fuck!");
//			for(int j=0;j<10;j++){
//				if(j==5)
//					break test1;
//				else 
//					break test2;
//			}
//		}
//		
//	
//		}
	

		
	}
}

class TestPrimitParent{
	
	static int j=8;
	int i =5;
	
	public TestPrimitParent() {
		printSomething();
	}
	
	public void printSomething(){
		System.out.println(i + " j="+j);
	}
}
