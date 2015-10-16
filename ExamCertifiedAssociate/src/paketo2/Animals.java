package paketo2;

public class Animals {
    private String animalAge ="father";
    protected String prot;
   
    String def = "father";
    
	public Animals(String animalAge){
		this.animalAge = animalAge;
	}
	
	public String getAge(){
		return animalAge + " and def is " +def;
	}
	
	public Number getAge(int val) throws Exception{
		return 8;
	}
	
	private void thisIsPrivate(){
		System.out.println("This is the father speaking "+ def);
	}
	


	
	
}


class Lion extends Animals{
	
	public int animalAge =14;
	
	String def = "child";
	
	public Lion(){
		super("16 years old");
		
	}
	
	private void thisIsPrivate(){
		System.out.println("This is the child speaking "+ def);
	}
	
	public int getAge(String anotherAge){
		return 5;
	}
	
	public String getAge(){		
		return "child" + super.getAge();
	}
	
//	public int getAge(int val) throws Exception{
//		return 9;
//	}
	
	public Integer getAge(int val) throws NullPointerException{
		return 8;
	}
	
	public void doImportantThings(){
		System.out.println(new Lion().getAge());
		System.out.println(this.getAge());
		System.out.println(super.getAge());
		
	}
	
}

class ClassTester {
	public static void main(String args[]){
		Lion lion = new Lion();
		String def = lion.def;
		String prot = lion.prot;
		
		lion.doImportantThings();
	}

}