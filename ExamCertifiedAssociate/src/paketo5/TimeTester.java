package paketo5;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class TimeTester {
	
	public static void main(String args[]){
		LocalTime time1 = LocalTime.of(6, 15);
		LocalTime time2 = LocalTime.of(12, 20, 33,200);
		LocalTime time3 = LocalTime.of(6, 15,33);
		
		System.out.println(time1);
		System.out.println(time2);
		
		LocalDateTime ldt1 = LocalDateTime.of(2015, Month.DECEMBER,14,10,20,30,2000);
		
		System.out.println(ldt1);
		
		LocalDate ld = LocalDate.of(2015, Month.AUGUST, 3);
		
		LocalDateTime ldt2 = LocalDateTime.of(ld,time1);
		
		System.out.println(ldt2);
		
		LocalDateTime ldt3  = LocalDateTime.of(ld, time2);
		
		System.out.println(ldt3);
		
		LocalDateTime ldt4 = LocalDateTime.of(ld,time3);
		
		System.out.println(ldt4);
		
		LocalDateTime ldt5 = ldt4.plusYears(2l);
		
		System.out.println(ldt5);
		
		LocalDateTime ldt6 = ldt4.minusYears(2);
		
		System.out.println(ldt6);
		
		LocalDateTime ldt7 = ldt6.plusDays(1).plusHours(1).plusYears(1).plusSeconds(1).plusMinutes(1).plusMonths(1);
		
		System.out.println(ldt7);
		//Periods
		Period period1 = Period.ofDays(10);
		Period period2 = Period.ofYears(10);
		Period period3 = Period.ofMonths(10);
		Period period4 = Period.ofWeeks(10);
		Period period5 = Period.of(10, 1, 5);
		
		
		Period period6= Period.ofYears(2).ofMonths(2).ofWeeks(2);
		
		ldt6 = ldt6.plus(period1);
		
		System.out.println(ldt6);
		//Formatting
		System.out.println(ldt6.getYear());
		System.out.println(ldt6.getMonth());
		System.out.println(ldt6.getDayOfMonth());
		System.out.println(ldt6.getDayOfYear());
		System.out.println(ldt6.getHour());
		System.out.println(ldt6.getSecond());
		System.out.println(ldt6.getMinute());
		System.out.println(ldt6);
		
		System.out.println(ldt6.format(DateTimeFormatter.ISO_LOCAL_DATE));
		System.out.println(ldt6.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
		System.out.println(ldt6.format(DateTimeFormatter.ISO_LOCAL_TIME));
		
		DateTimeFormatter dtf1 = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
		DateTimeFormatter dtf2 = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);
		System.out.println(ldt6.format(dtf1));
		System.out.println(dtf1.format(ldt6));
		System.out.println(dtf2.format(ldt6));
		
		DateTimeFormatter dtf3 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
		System.out.println(ldt6.format(dtf3));
		System.out.println(dtf3.format(ldt6));
		
		//DateTimeFormatter dtf4 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
		//System.out.println(dtf4.format(ld));
		
		
		DateTimeFormatter f1 = DateTimeFormatter.ofPattern("h:mm");
		System.out.println(f1.format(ldt6));
		
		DateTimeFormatter f2 = DateTimeFormatter.ofPattern("MM dd yyyy");
		LocalDate ld3 = LocalDate.parse("01 02 2015",f2);
		System.out.println(ld3);
		
		LocalTime lt4 = LocalTime.parse("11:22");	
		System.out.println(lt4);
				
	}

}
