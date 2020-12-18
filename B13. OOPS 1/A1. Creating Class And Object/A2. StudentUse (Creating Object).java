package Restart;

import java.util.Scanner;

public class StudentUse {

	public static void main(String[] args) {

		//Scanner s= new Scanner(System.in);
		// jis tarah se scanner bana rhe the waisehi student object banate hai
		
		Student s1= new Student(); //we have created our first student(s1)== 'new Student' ek address pe 'Student' template/class ki copy( matlab object banayega) banayega and uss copy(object ka) ka address s1 mai rahega so, s1 is reference to that copy of 'Student' template.
		
		System.out.println(s1);// s1 ke pas address rahega uske 'new student' object ka(matlab usne jahape object create kiye)
	    //Output: Restart.Student@15db9742 == this is actually saying, hey this is a student present at this memory address. (iss memory address pe ek student rakha hua hai)
		
		//muje yeh student ka nam and roll no set karna hai
		s1.name= "Sumit";
		s1.rollNo= 43;
		
		
		Student s2= new Student();
		
		System.out.println(s2); // 'new student' ne ek object create kiya and uska address s2 mai stored hai
        //Output: Restart.Student@6d06d69c
		
		s2.name= "Santape";
		s2.rollNo= 56;
		System.out.println(s2.name);
		System.out.println(s2.rollNo);
	}

}
