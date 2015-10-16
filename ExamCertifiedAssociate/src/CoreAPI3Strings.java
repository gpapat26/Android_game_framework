import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.List;

class TestSomething {
	public void methodTest(){
		
	}
}
public class CoreAPI3Strings {
	
	public static final  void dothis(){
		new TestSomething().methodTest();
	}
	
	public  void doSomethingNonStatic(){
		
	}

	
	public static void main(String args[]){
		System.out.println("Animal".toLowerCase().replace('a', 'A'));
		String a = "tartaros";
		String b = "tartaros ".trim();
		System.out.println(a==b);
		CoreAPI3 api = new CoreAPI3();
		
		//LocalDate date = LocalDate.now();
		
		//date = date.plus(Period.ofDays(2));
		
		//System.out.println(date.minus(Period.ofDays(2)));
		
		System.out.println("test".substring(1,1).length());
		char[]c = new char[2];
		
		int [] integ = {1,2,3,4,5};
		
	
		
		
		
		System.out.println(integ);
		

	    
//	    LocalDate date = LocalDate.of(2020, Month.JANUARY, 20);
//	    LocalTime time = LocalTime.of(11, 12, 34);
//	    LocalDateTime dateTime = LocalDateTime.of(date, time);
//
//		
//	    DateTimeFormatter shortDateTime =DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG);
//	    
//	    System.out.println(shortDateTime.format(dateTime));	    
//	    System.out.println(shortDateTime.format(date));
//	    	    
//	    
//		System.out.println(dateTime.format(shortDateTime));
//		System.out.println(date.format(shortDateTime));
//		
//		System.out.println(time.format(shortDateTime));
		
		
		LocalDate date = LocalDate.of(2020, Month.JANUARY, 20);
		LocalTime time = LocalTime.of(11, 12, 34);
		LocalDateTime dateTime = LocalDateTime.of(date, time);
		
		DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
		
		DateTimeFormatter mediumF = DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT);
		
		System.out.println(formatter.format(dateTime));
		
		System.out.println(dateTime.format(formatter));
		
		System.out.println(dateTime.format(mediumF));
		
		Period p = Period.ofDays(2).ofYears(2);
		 date  = date.plus(p);
		 System.out.println(date);
		
	    
	    
	}

}
