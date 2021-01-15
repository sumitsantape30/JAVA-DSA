package Restart;

public class Student {

	//yeh student class/template ki properties hai
	String name;
	 public int rollNo;
	 
	 
	 // humara roll no private hai so usko class ke bahar koi access nhi kr skta neither change kr skta to private krke fayda kya,
	 // hum isme kuch functionalities add karenge, and in functions ke through access denge
	 
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
