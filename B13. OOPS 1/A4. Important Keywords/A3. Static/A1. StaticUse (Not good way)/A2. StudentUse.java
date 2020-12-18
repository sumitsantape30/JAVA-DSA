package Restart;

import java.util.Scanner;

public class StudentUse {

	public static void main(String[] args) {

		
		Student s1= new Student("Sumit",65); 
		s1.print(); 
	
	    Student s2= new Student("Santape",65); 
	    s2.print();  
	    
	    //when we want to access a static data member, hum usko kisi bhi student ke through access karle value same ayegi.
	    System.out.println(s1.numStudents);
	    System.out.println(s2.numStudents);
	   
	    // mera static function (numStudents) object pe depend nhi krta puri class ka hai so, hum class ke through numStudents access kr skte hai
	    System.out.println(Student.numStudents); // this is much better way of accessing this value-- numStudents sabka hai so hume class ke through access karna chahiye.
	
	    //class ke through bas static data member access kr skte hai agar maine no static suppose name access kiya to error ayega coz every object has a different name.
	    //System.out.println(Student.name);
	
	    //mera numStudents default(Visible and have access in same package) hai so mai usko yaha change kr skta hu so, this is not a good way
	    Student.numStudents= 10; //mere 2 hi objects banae the but isne value 10 kardi, so this is not good, we should not allow anyone to change this value
	}
 
}
