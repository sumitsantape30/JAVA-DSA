Student=============

package Restart;

public class Student {

	
	String name;
	private final int rollNo;

	
	public Student(String name, int rollNo) {
		System.out.println(this); //this contains the address of the object--> iska address wahi rahega jo student object ka hai, this is also the way throught which we can access the object when you are inside any function. 
		
		this.name = name;
		this.rollNo = rollNo;
	}

	public int getRollNumber() {
		return rollNo;
	}

	public void print() {
		System.out.println(name + " " + rollNo);
	}
		
}

StudentUse==========

package Restart;

import java.util.Scanner;

public class StudentUse {

	public static void main(String[] args) {

		
		Student s1= new Student("Sumit",65); // contructor mai jo prit("this") karre uska output:Restart.Student@15db9742
		System.out.println(s1); //Output: Restart.Student@15db9742
		s1.print(); //Output: Sumit 65
	
	    Student s2= new Student("Santape",65); //Output: Restart.Student@6d06d69c
	    System.out.println(s2); //Output: Restart.Student@6d06d69c
	    s2.print();  //Output: Santape 65
	    
	}

}

Output:

Restart.Student@15db9742
Restart.Student@15db9742
Sumit 65
Restart.Student@6d06d69c
Restart.Student@6d06d69c
Santape 65
