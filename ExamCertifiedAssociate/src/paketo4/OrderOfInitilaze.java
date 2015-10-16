package paketo4;
import java.*;


public class OrderOfInitilaze {
	
	public int num = 2;
	
	public static final int var;
	double va = 1;
	
	{
		System.out.println(num + " initial");
		num++;
	}
	
	void OrderOfInitilaze(){
		int x =5;
		int y = (x=8);
		
		
	}
	
	static{		
		var =2;
		System.out.println(var + " initial static");
	}
	
	public OrderOfInitilaze(){
		System.out.println(num + " constr");
		num++;
	}
	
	public static void main(String [] params){
		new OrderOfInitilaze();
		
		int x = 5;
		
		String y="line";
		int fr= 10;
		
		long r= fr*4;

		double ssd = 4;
		
		if(11<10) 
			System.out.println("Too Low");
		
		else System.out.println("Just right");
	
		
		System.out.println(x > 2 ? x < 4 ? 10 : 8 : 7);
		
		switch(y){
			
		}
		int z = 0;
		for (int k= 0,l=0;(k+l)<5;z++,k++,l++){
			
		}
		System.out.println(z);
		
	}

}
