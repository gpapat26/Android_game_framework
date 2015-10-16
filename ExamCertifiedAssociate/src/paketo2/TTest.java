package paketo2;


public class TTest {
	
	
	public boolean isBiped() {		
	return false;
	
	}
	public void getMarsupialDescription() {
	System.out.println("Marsupial walks on two legs: "+isBiped());
	}
	}

	class Kangaroo extends TTest {
	public boolean isBiped() {
	return true;
	}
	
	public void getKangarooDescription() {
	System.out.println("Kangaroo hops on two legs: "+isBiped());
	}
	
	public static void main(String[] args) {
		
	Kangaroo joey = new Kangaroo();
	joey.getMarsupialDescription();
	joey.getKangarooDescription();
	
	}
	}
	
	 abstract class NothingToDO2{
		 
	 }

