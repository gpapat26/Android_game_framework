package paketo9;

import java.util.ArrayList;
import java.util.List;

import paketo10.ImportantClass;

 class AccessOfClass extends ImportantClass{
	
	public int metavliti;
	public static int metavliti2=20;
	
	
//	int b, c;
//	
//	int a=b=c=100;
	
	int b=0, c=0, d=0;
	
	int a=b=c=d=200;
	
	
	
	{
		System.out.println("yes!");
	}
	
	
	public static void doSomething(){
		System.out.println("kid doSomething");
	}
	
	public  void doSomethingElse(){
		
		int a, b, c;
		System.out.println("kid doSomethingElse");
		{
			System.out.println("yes!");
		}
		
		if(11>10){
			a=2;
			b=9;
			c=11;
		}
		
		System.out.println("ts"+null);
	}
	
//	public  int triple(){
//		
//		int a, b, c;
//			
//		if(metavliti>10){
//			a=2;
//			b=9;
//			c=11;
//		}
//		
//		return a*b*c;
//	}
//	
//	
//	public  static int tetrtriple(){
//		
//		int a, b, c;
//			
//		if(metavliti2>10){
//			a=2;
//			b=9;
//			c=11;
//		}
//		
//		return a*b*c;
//	}
	
	
	public static void main(String args[]){
		
//		ImportantClass a1 = new AccessOfClass();
//		AccessOfClass a2 = (AccessOfClass)a1;
//		
//		a1.doSomething();//static
//		a1.doSomethingElse();
//		
//		a2.doSomething();//static
//		a2.doSomethingElse();
//		
//		{
//			System.out.println("yes!");
//		}
		
//		int var = 5;
//		final int val =5;
//		switch (var) {
//		case 1 : System.out.println("test1"); break;
//		case val : System.out.println("test5"); break;
//		}
		
//		int i=0;
//		int[] a = { 1,2,3};
//		
//		a[++i] += (a[--i] = 4) ;
//		
//		for (int j=0 ; j< a.length;j++) {
//			System.out.println(a[j]);
//		}
		
//		lab : System.out.println("test");
//		
//		//int i=0;
//		int[][] ab = { {1,2,3},{1,2,3},{1,2,3}};
//	  //int[][] ab = { {1,2,3},{4,2,7},{1,2,3}};
//		ab[++i][++i] += (ab[--i][--i] = 4)+ab[i][i] ;
//		
//		
//		for (int j=0 ; j< ab.length;j++) {
//			
//			for (int k=0 ; k< ab[j].length ; k++){
//				
//				System.out.println(j+" "+k+" "+ab[j][k]);
//			}
//		}
		
		//System.out.println(getData()+getboolData());
		
//		StringBuilder sb1 = new StringBuilder("test");
//		System.out.println(sb1);
//		sb1.delete(0, 4);
//		System.out.println(sb1);
//		
//		List<String> l2 = new ArrayList<String>();
//		l2.clear();
		
		
	}
	
	public static String caseRevision(){
		return null;
	}
	
	public static String getData(){
		return null;
	}
	
	public static boolean getboolData(){
		return true;
	}
	
	

}
