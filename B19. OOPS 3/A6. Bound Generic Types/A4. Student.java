package Bound_Generics_Types;

//demo keliye yeh useless class banayi hai
public class Student implements PrintInterface{ //jaisehi implements PrintInterface likha 

	int rollNumber;
	
	public void print() {
		System.out.println(rollNumber);
	}
}
