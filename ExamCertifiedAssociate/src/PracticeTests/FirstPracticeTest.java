package PracticeTests;

public class FirstPracticeTest {
	

	
	
	public static void main(String args[]){
		
		String s1 = null;	
		System.out.println(s1);
		
		String s5 = "good";
		String s4 = "";
		String s6 = "goo"+"d";
		char[] c4 = {'g','o','o','d'};
		for (char c : c4) {
			s4 = s4+c4;
		}
		
		if(s6==s5){
			System.out.println("References are  the same");
		}
		else{
			System.out.println("References are not the same");
		}
		if(s6.equals(s5)){
			System.out.println("But values are equals");
		}
		
		System.out.println("---------------test s0-----------------------");
		
		if(s4==s5){
			System.out.println("References are  the same");
		}
		else{
			System.out.println("References are not the same");
		}
		if(s4.equals(s5)){
			System.out.println("But values are equals");
		}
		
		System.out.println("-----------------tests1--------------------");
		
		int a,b,c;		
		a=b=c=100;
		
		int j;
		int k;
		int l;
		
		l=j=k=100;
		
		String s2= "love";
		String s3 = new String("love");
		
		if(s2==s3){
		}
		else{
			System.out.println("References are not the same");
		}
		if(s2.equals(s3)){
			System.out.println("But values are equals");
		}
		
       System.out.println("------------------test0--------------------");
		
		Integer i1 = 4;
		int i2 = 4;
		Integer i3 = new Integer("4");
		Long l1 = 4L;
		Integer i5 = 4;
		Long l2 =new Long(4);
		
		
		if(i1==i5){
			System.out.println("integer References are  the same");
		}
		else{
			System.out.println("integer References are not the same");
		}
		if(i1.equals(i5)){
			System.out.println("But integer values are equal");
		}
		
		System.out.println("------------------test1--------------------");
		

		
		if(i1==i2){
			System.out.println("integer References are  the same");
		}
		else{
			System.out.println("integer References are not the same");
		}
		if(i1.equals(i2)){
			System.out.println("But integer values are equal");
		}
		
		
		
		System.out.println("----------------test2----------------------");
		
		if(i1==i3){
			System.out.println("integer References are  the same");
		}
		else{
			System.out.println("integer References are not the same");
		}
		if(i1.equals(i3)){
			System.out.println("But integer values are equal");
		}
		
		System.out.println("-----------------test3---------------------");
		
		if(i2==i3){
			System.out.println("integer References are  the same");
		}
		else{
			System.out.println("integer References are not the same");
		}
		if(i3.equals(i2)){
			System.out.println("But integer values are equal");
		}
		
		System.out.println("---------------test4-----------------------");
		
//		if(l1==i1){
//			System.out.println("integer References are  the same");
//		}
//		else{
//			System.out.println("integer References are not the same");
//		}
		if(l1.equals(i1)){
			System.out.println("But integer values are equal");
		}
		else{
			System.out.println("But values  are not equal");
		}
		
		System.out.println("---------------test5-----------------------");
		
		if(l2==i2){
			System.out.println("integer References are  the same");
		}
		else{
			System.out.println("integer References are not the same");
		}
		if(l2.equals(i2)){
			System.out.println("But integer values are equal");
		}
		else{
			System.out.println("But values  are not equal");
		}
		
	}

}
