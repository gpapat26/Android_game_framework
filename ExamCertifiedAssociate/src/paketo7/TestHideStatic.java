package paketo7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



public class TestHideStatic {
	
	public static void main(String args[]) throws ClassNotFoundException
	{
		
     //megaloInterf intefa = new Metavliti();	
	//	System.out.println(intefa.var);
//		try{					
//		doWork();
//		}catch(ClassNotFoundException e){
//			System.out.println(e);
//		
//		}catch(MyException e){
//			System.out.println(e);
//		}
//		
//		JJL : while(true)
//		 TERMINATOR: for(int z = 0;z<5;z++){
//			 z++;
//			ACE: System.out.println("YOUTUBE");
//			if(z >8){
//				break JJL;
//			}
//			
//			if(z>3){
//				break TERMINATOR;
//			}
//		}
		int[] a = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
//		List<Integer> arlist = new ArrayList<Integer>();
//		arlist.add(2);
//		arlist.add(3);
//		System.out.println("array "+ a+ " arrayList "+arlist);
		
//		int s= 1;
//		System.out.println(a[s]);
//		s+= s + ++s+mx(s)+a[s++];
//		System.out.println(s);
//		
//		
//		a[++s]= s + ++s+mx(s)+a[s++];
//		
//		System.out.println(s);
//		for (int i : a) {
//			System.out.println(a[i]);
//		}
		
		int y;
		int s =1;
		
		a[s++]=                    y=a[s++]       =a[s--]+a[++s];
		
		//a[1]                      
		//      s=2                  y= a[2]     a[3] + a[3]
		
        boolean b=Boolean.parseBoolean("tr");
        Boolean c =Boolean.valueOf(false);
		for (int i = 0 ; i<a.length ;i++) {
		   System.out.println(a[i]);
		}

		
		System.out.println("y"+y + "s"+s);
		
	}
	
	static int mx(int s){
		for(int i=0;i<3;i++){
			s=s+i;
		}
		return s;
	}

	private static void doWork() throws MyException, ClassNotFoundException {
		
	
	  String[] arr = {"1"};
	  //arr[100]="test";
	  throw new ClassNotFoundException();
	}

}

//class Metavliti implements megaloInterf{
//	int var = 50;
//}
//
//interface megaloInterf{
//	int var = 100;
//}

class MyException extends Exception{
	MyException(String msg){
		super(msg);
	}
}


