package paketo6;

public class RevisonStrings {
	
	static{
		
		try{
			
		}catch(Exception e){
			try {
				throw new Exception();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	
	}
	
	public static void main(String args[]){
		
		String animals = "animals";
		
		System.out.println(animals.indexOf('a',4));
		
		System.out.println(animals.indexOf('a',5));
		
		System.out.println(animals.substring(0,6 ));
		
		System.out.println(animals.substring(0,1 ));
		
		System.out.println(animals.substring(3,5));
		
		System.out.println(animals.replace('a', 'N'));
		
		System.out.println(animals.replace("an", "AN"));
		
		StringBuilder sb1 = new StringBuilder(animals);
		System.out.println(sb1.length());
		
		

		
		
		
	}
}
