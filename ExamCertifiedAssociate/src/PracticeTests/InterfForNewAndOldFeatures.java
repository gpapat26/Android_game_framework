package PracticeTests;

public interface InterfForNewAndOldFeatures {
	  String str1 ="hello;";
		 
	 static String doStuff(){
		 return str1;
	 }
	 
	 default String doAnotherThing(){
		 
		 return str1;
	 }
	 
	 public abstract String doSomeAbstract();
	 
	 public  String doSomeAbstract2();
}


class ImplementThings implements InterfForNewAndOldFeatures{

	@Override
	public String doSomeAbstract() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static void main(String args[]){
		ImplementThings v1 = new ImplementThings();
		String s2 = v1.str1; 
		InterfForNewAndOldFeatures.doStuff();
	}

	@Override
	public String doSomeAbstract2() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
	
	
}
