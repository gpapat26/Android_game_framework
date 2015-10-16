package PracticeTests;

public class OverridingAndHiding {
	
	String val ="parent";
	
	public String doSomething(){
		
		return "parent method returns "+ getValue();
	}
	
	public String getValue(){
		return val;
	}
	


}

 class OverridingAndHidingChild extends OverridingAndHiding{
	
	 
		String val ="child";
		
		public String doSomething(){
			
			return "child method returns "+ getValue();
		}
		
		public String getValue(){
			return val;
		}

}
 
 interface CheckCaller{
	 
	  String str1 ="hello;";
	 
	 static String doStuff(){
		 return str1;
	 }
	 
	 default String doAnotherThing(){
		 
		 return str1;
	 }
	 
	 public abstract String doSomeAbstract();
 }
 
 class Implementor implements CheckCaller{

	@Override
	public String doSomeAbstract() {
		// TODO Auto-generated method stub
		return null;
	}
	
	String instBar = str1;
	CheckCaller interf = this;
	
	 
 }
 
 

