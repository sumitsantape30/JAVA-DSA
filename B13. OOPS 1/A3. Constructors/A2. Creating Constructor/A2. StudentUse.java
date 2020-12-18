package Restart;

import java.util.Scanner;

public class StudentUse {

	public static void main(String[] args) {

		
		//Student s1= new Student(); == humne ek new constructor banaya hai so yeh default constructor apne aap disable hoajeyga.
		
		Student s1= new Student("Sumit",65);//agar student(object) banana hai to new wala constructor use karna padega and usme value pass kiye bina student nhi bana skte
		
		System.out.println(s1.name); 
		System.out.println(s1.getRollNumber()); 
		
		Student s2= new Student("Santape",65); //jo student s2 hai uska name and rollNo set hora
		System.out.println(s2.name);
		System.out.println(s2.rollNo);
		System.out.println(s2.getRollNumber());
	
	}

}

Output:

Sumit
65
Santape
65
65
