import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;


public class CoreAPI3 {
	
	private String doSomething ="test";
	
	public static void main(String args[]){
		workingWithDatesAndTimes();
	}
	
	
	
	public static void workingWithDatesAndTimes(){
		System.out.println(LocalDate.now());
		System.out.println(LocalTime.now());
		System.out.println(LocalDateTime.now());
		
		LocalDate localDate = LocalDate.of(2015, Month.JANUARY, 20);
		System.out.println(localDate);
		LocalDate localDate2 = LocalDate.of(2015, 1, 20);
		System.out.println(localDate2);
		LocalDateTime localDateTime = LocalDateTime.of(2016, 02, 28, 16, 25);
		System.out.println(localDateTime);
		LocalTime localTime = LocalTime.of(18, 35);
		System.out.println(localTime);
		
		LocalDateTime localDateTime2 =LocalDateTime.of(localDate, localTime);
		System.out.println(localDateTime2);
		
		LocalDateTime newDate = localDateTime2.plusDays(2l);
		System.out.println(newDate);
		
		LocalDateTime newDate2 = newDate.plusWeeks(2l);
		System.out.println(newDate2);
		
		LocalDateTime newDate3 = newDate.minusWeeks(2l);
		System.out.println(newDate3);
		
		LocalDateTime newDate4 = newDate.minusSeconds(2l);
		System.out.println(newDate4);
		
		Period period = Period.ofDays(10);
		LocalDateTime localDateTime5 = newDate4.plus(period);
		System.out.println(localDateTime5);
		
		System.out.println(localDateTime5.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
		
		System.out.println(localDateTime5.format(DateTimeFormatter.ISO_LOCAL_DATE));
		
		System.out.println(localDateTime5.format(DateTimeFormatter.ISO_LOCAL_TIME));
		
		DateTimeFormatter dtf = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
	}

}
