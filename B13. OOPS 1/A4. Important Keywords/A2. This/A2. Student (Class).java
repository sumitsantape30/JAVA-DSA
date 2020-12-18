package Restart;

public class Student {

	String name;
	private final int rollNo;

	//Jab data member aur local variable same ho to data memeber ko access karne keliye we use this.
	public Student(String name, int rollNo) {
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
