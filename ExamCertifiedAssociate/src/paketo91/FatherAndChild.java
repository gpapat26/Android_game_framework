package paketo91;

public class FatherAndChild {
  public int father = 8;
  public void print(){
	  System.out.println("inside father");
  }
}

class Child extends FatherAndChild{
	  public int father = 9;
	  public int var1 = 9_1;
	  public char var2 =1_0;
	  public float var3 =10.2_4f;
	  public double var4 =1_2.2;
	  
	  public void print(){
		  System.out.println("inside child");
	  }
	  
	  public static void main(String args[]){
		  FatherAndChild fac =new Child();
		  System.out.println(fac.father);
		  fac.print();
		 
		  Boolean b1 = new Boolean(true);
		  Integer i1 = new Integer(1);
		  Integer i2 = new Integer(Integer.valueOf("12"));
		  System.out.println(i2);
	  }
}
