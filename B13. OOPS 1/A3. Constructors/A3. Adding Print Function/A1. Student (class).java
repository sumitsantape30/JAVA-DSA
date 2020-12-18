package Restart;

public class Student {

	String name;
	private int rollNo;
	
	public Student( String n, int rn) {
		name= n;
		rollNo= rn;
	}
	
//  let's say merko aisahi constructor chahiye jo kuch input nhi lega and by default rollNo ki value muje kuch aur rakhni hai
//	public student() {
//		rollNo= 45;
//	}
	
// You can also have multiple constructors, sayy 'roll No' important nhi hai muje bas nam bhi mil gya to that is okay.
// jab maine multiple constructor banaye means muje student(s1) banane keliye ya to name and roll No dedo (pointing constructur with name and rollNo argument)	ya fir sirf nam dedo, nam to dena hi padega
  public Student(String n){
	 name= n;
  }
	
	public void setRollNumber(int rn) {
		if( rn <= 0) {
			return;
		}
		rollNo= rn;
	}
	
	public int getRollNumber() {
		return rollNo;
	}
	
	public void print() {
		System.out.println(name+" "+rollNo);
	}
}
