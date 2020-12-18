package Restart;

import java.util.Scanner;

public class StudentUse {

	public static void main(String[] args) {

		
		Student s1= new Student("Sumit",65);
		
//		System.out.println(s1.name);
//		System.out.println(s1.getRollNumber());
	    s1.print(); //Output: Sumit 65

	    
	    Student s2= new Student("Santape",65);
	    s2.print(); //Output: Santape 65
	    
	    //multiple constructor
	 // jab maine multiple constructor banaye means muje student(s1) banane keliye ya to name and roll No dedo (pointing constructur with name and rollNo argument)	ya fir sirf nam dedo, nam to dena hi padega

	    Student s3= new Student("Amit");
		s3.print(); //Output: Amit 0

	}

}
