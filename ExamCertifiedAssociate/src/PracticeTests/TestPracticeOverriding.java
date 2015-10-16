package PracticeTests;

import java.util.ArrayList;
import java.util.List;


class SomeSeriousShit{
	
	public int val1 = 3;
	public static int loop = 8;
	public static final String s25 ="123";
	
	
	public SomeSeriousShit(){
		
	}
	
	
	{
		val1=9;
		loop =1;
		
	}
	
	
	
}

public class TestPracticeOverriding {
	public static void main(String args[]){
		 OverridingAndHiding ref = new OverridingAndHidingChild();
		 System.out.println(ref.doSomething());
		 
		 //OverridingAndHiding ref2 = new OverridingAndHiding();
		 //OverridingAndHidingChild child = (OverridingAndHidingChild)ref2;
		 
		 OverridingAndHidingChild ref2 = new OverridingAndHidingChild();
		 OverridingAndHiding ref3= (OverridingAndHiding)ref2;
		 
		 SomeSeriousShit sh1 = new SomeSeriousShit();
		 System.out.println(sh1.val1+ " static loop = "+sh1.loop);
		 List<String> list1 = new ArrayList<String>();
		 list1.add("test");
		 list1.add("test2");
		 
		 System.out.println(list1);
		 
		 String[] arr1 = {"arr1","arr2","arr3"};
		 
		 System.out.println(arr1);
		 
		 StringBuilder sb1 = new StringBuilder("tograpse?");
		 System.out.println(sb1);
		 
		
	}
	
}


