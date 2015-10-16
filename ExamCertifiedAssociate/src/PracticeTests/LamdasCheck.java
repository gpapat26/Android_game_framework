package PracticeTests;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class LamdasCheck {
	
	
	public static boolean checkList(List list, Predicate<List> p){
		return p.test(list);
		}
	
	
	public static void main(String [] args){
		boolean b = checkList(new ArrayList(), (List a)-> a.isEmpty());
	}

}


interface T1{
	public default String getId(){
		return "123";
	}
}

interface T2{
	
}
//interface T3 extends T1,T2{
////	public static String getId(){
////		return "123";
//	}
//}
