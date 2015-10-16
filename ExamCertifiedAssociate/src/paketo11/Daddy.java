package paketo11;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;



public class Daddy {
	
	public static int q=6;
	
	public Daddy(int a){
		
	}
	
	public Daddy(){
		
	}
	
	public Daddy doWork(){
		return null;
		
	}
	
	public static  void main(String args[]){
		
		//String sb = new StringBuilder("ddd-ddd-dddd").replace(0, 7, "xxx-xxx-").toString();
		//System.out.println(sb);
		
		LocalDateTime greatDay = LocalDateTime.parse("2015-01-01T17:13:50");
		//int x = 5/0;
		
		
		//Byte b = new Byte("12.3");
		//Integer a = new Integer("12.2");
		
		short s = (short)9;
		byte l = 3;
		
	    Integer p = 5;
		int i = 0;
		System.out.println(p==i);
		
		s+=i;
		
		s=(short)(s+i);
		
	}


}

 class Paidi extends Daddy{

	public Paidi(int a) {
		super(a);
	}
	
	public Paidi(int a,int b){
		
	}
	
	public Paidi doWork(){
		return null;
	}
	
	
	
	public static void main(String args[]){
		
		//Daddy zz= 2<5? doSom() : doSom2();
		
//		StringBuilder s = new StringBuilder("test");
//		System.out.println(s);
//		List ase = new ArrayList();
//		ase.add(s);
//		ase.add(s);
//		//ase.add(5, new Object());
//		System.out.println(ase);
//		
//	}
//	
//	int max(int x, int y){
//	
//	if(x > y)
//	{ 
//		return x; 	
//	}
//	else
//	{ 
//	return y;
//	}  
//	
		
//		 char i;
//	        LOOP: for (i=0;i<5;i++){
//	            switch(i++){
//	                case '0': System.out.println("A");
//	                case 1: System.out.println("B"); break LOOP;
//	                case 2: System.out.println("C"); break;
//	                case 3: System.out.println("D"); break;
//	                case 4: System.out.println("E");
//	                case 'E' : System.out.println("F");
//	            }
//	        }
		
		 boolean bo   =Boolean.parseBoolean(" true");
		 Boolean ba	  =Boolean.valueOf("true");
		 Boolean bool =Boolean.valueOf(ba);
		 Integer myInt = Integer.valueOf(3);
		 Integer val=Integer.valueOf(myInt);
		 Float f =Float.parseFloat(" 20.3     ");
		
		 
		 System.out.println(bo+" "+bool+" "+ba+" "+val + " "+f);
		 
		 if(true == ba){
			 System.out.println("its TRUE!");
		 }
	}
	
	
	
public static Paidi doSom(){
	return null;
}

public static Daddy doSom2(){
	return null;
}
	
}
