package paketo2;

  abstract class AbstractStaffToCheck {
	
	protected String val;
	private String anotherVal;
	
	static final String steadyVal;
	

	
		

	
	public AbstractStaffToCheck(){
		this.val = "abstract";
	}
	
	protected AbstractStaffToCheck(String val){
		this();
		this.val = "abstract";				
	}
	
	static{
		steadyVal = "test";		
	}
	
	public final void finalMethod(){
		
	}
	
	private final void privateMethod(){
		
	}
	
	public static void todoooo(){
		
	}
	


}


 class Runner extends AbstractStaffToCheck{
	
	public void invokeSuperMethods(){
		System.out.println(super.val);
		
	}
	public Runner (){
		super("Another val is abstract");
	}
	
	public static void main(String[] args){
		Runner runn = new Runner();
		
		System.out.println(runn.val);
		
		runn.invokeSuperMethods();		
	}
}
 
 
 class Runner2 extends testClassAnother{
		
	public void invokeSuperMethods(){
		System.out.println(super.val);
		
	}
	public Runner2 (){
		
	}
	
	public static void main(String[] args){
		Runner2 runn = new Runner2();
		
		runn.toDo();
		runn.tttt(new Animal());
		String[] animals = new String[0];
		
		String[] animals1 = new String[0];
		System.out.println(animals1[0]);
		
		
		System.out.println(runn.getTemperature());		
	}
	@Override
	public void toDo() {
		checkInterface.workToDo();
		checkInterface interf = this;
		
	}
	@Override
	protected void doFromAbstract() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void tttt(Animal a) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void tttt(String t) {
		// TODO Auto-generated method stub
		
	}
	
//	public  double getTemperature(){
//			return 20;
//		}
}
 
 
 class Animal extends Runner2{}
 
 
 
 
 abstract class testClassAnother implements checkInterface{
	 
	 protected abstract void doFromAbstract();
	 
	 public abstract void tttt(String t);
 }
 
 class Implementor extends testClassAnother{
    
	 
	 
		 
	 
	@Override
	public void toDo() {
		
		checkInterface.workToDo();
		
	}

	@Override
	protected void doFromAbstract() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void tttt(String t) {
		
		
	}

	@Override
	public void tttt(Animal a) {
		// TODO Auto-generated method stub
		
	}
	
	
	 
 }
 
 
  abstract interface checkInterface  {
	 
	  public static final int val=2;
	  
	  public abstract void toDo();
	  
	  void tttt(Animal a);

	public static  void workToDo(){
		  System.out.println("intefrace!!");
	  }
	  
	 
  
  		public default double getTemperature(){
  			return 10;
  		}
  
  }
	  
	 // public abstract final void doSomething();
	  
	 // private abstract void doSomethingElse();
	 // private void doSomethingElseB();
	
  
  abstract interface interf1{
	  public static void method1(){
		  
	  }
	  
//	  public default void method2(){
//		  
//	  }
  }
  
  abstract interface interf2{
	  public static void method1(){
		  
	  }
	  
//	  public default void method2(){
//		  
//	  }
  }
  
  class Implementor1 implements interf1,interf2{
	  
	  
	  public static void main(String args[]){
		  interf1.method1();
	  }
  }
 
