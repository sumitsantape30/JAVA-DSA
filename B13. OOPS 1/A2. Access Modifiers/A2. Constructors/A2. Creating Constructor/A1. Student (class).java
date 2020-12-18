package Restart;

public class Student {

	//by default when you create a student all the properties that you have here gets initialized by zero, string ke case mai null.
	       String name;
	 public int rollNo;
	 
	 // I should not allow anyone to create student(class) without name and rollNo. matlab agar tume object create karna hai to yeh chiz chahiye hi
	 // so, I want my student(class) to take name and rollNo only then allow to create a student(object)
	 public Student( String n, int rn) {
		 name= n; //setting rollNo and Name with whatever the values user is passing 
		 rollNo= rn;
	 }
	 
	 public void setRollNumber( int rn) { //this is the way through which we can change the roll no, yeh function public hai so isko class ke bahar access krke isme input deke roll number change kr skte hai
		 
		 if( rn <= 0) { // rollNo private rakhne ka fayda is, mai yeh control rakh skta hu ki user negtive value na dede, mai yaha aise condition laga skta
			 return;
		 }
		 rollNo= rn;
	 }
	 
	 public int getRollNumber( ) { //yeh function public hai so class ke bahar se accessible hai and yahi function within the class bhi hai so woh(getRollNumber function) rollNo ko access kr skta hai.
		 return rollNo;
	 }
}
