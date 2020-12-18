package Restart;

public class Student {

	
	//I want to have another data member called numStudents jo maintain karega ki mere student class ke kitne objects ban chuke hai,
	// pehle object create hoga to numStudents 1 hoga dusra object create hua to numStudents 2 hoga, aur agar 10 objects create hue to numStudents 10 chahiye.
	// so, I should have only one numStudents integer instead of creating one copy of each object, so we need one numStudent which is shared by everyon.
	// When you want only one data that should be shared by everybody we call it static data.
	
	String name;
	private final int rollNo;
	
	static int numStudents; //static hai so sab share karenge, and numStudents keeps track ki abhitak kitne objects create hue hai

	public Student(String name, int rollNo) {
		this.name = name;
		this.rollNo = rollNo;
		numStudents++; // everytime a object is created we want to increase our numStudents, so jab bhi object create hoga ekbar constructor call hoga
	}

	public int getRollNumber() {
		return rollNo;
	}

	public void print() {
		System.out.println(name + " " + rollNo);
	}

}
