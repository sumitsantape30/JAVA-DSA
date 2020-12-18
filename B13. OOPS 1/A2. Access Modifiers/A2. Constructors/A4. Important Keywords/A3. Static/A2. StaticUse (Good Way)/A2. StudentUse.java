package Restart;

import java.util.Scanner;

public class StudentUse {

	public static void main(String[] args) {

		
		Student s1= new Student("Sumit",65); 
		s1.print(); 
	
	    Student s2= new Student("Santape",65); 
	    s2.print();  
	    

		//static functions woh hote hai jo object pe depend nhi krte (mai s1 pe call karu ya s2 pe use koi farak nhi padta)
	    System.out.println(Student.getnumStudents()); //directly class pe call karna is good way than calling on any particular object.
	    System.out.println(s1.getnumStudents()); //not good way to access by calling on object.
	    
	  
	}
 
}
