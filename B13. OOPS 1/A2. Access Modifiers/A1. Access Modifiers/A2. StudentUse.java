package Restart;

import java.util.Scanner;

public class StudentUse {

	public static void main(String[] args) {

		
		Student s1= new Student(); 
		
		s1.name= "Sumit";
		s1.rollNo= 43;
		
		//jaise hum .(dot) lagake properties ko access krte the, waisehi .(dot) lagake function access kr skte hai
		s1.setRollNumber(12); //you can set roll number which ever you want.
		System.out.println(s1.getRollNumber()); //output: 12
		
		
		Student s2= new Student();
		
		s2.setRollNumber(45);
		System.out.println(s2.getRollNumber()); //Output: 45
		
	}

}
