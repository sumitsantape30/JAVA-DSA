 package Restart;

public class Student {

	
	//I want to have another data member called numStudents jo maintain karega ki mere student class ke kitne objects ban chuke hai,
	// pehle object create hoga to numStudents 1 hoga dusra object create hua to numStudents 2 hoga, aur agar 10 objects create hue to numStudents 10 chahiye.
	// so, I should have only one numStudents integer instead of creating one copy of each object, so we need one numStudent which is shared by everyon.
	// When you want only one data that should be shared by everybody we call it static data.
	
	String name;
	private final int rollNo;
	
	private static int numStudents; //isko private karre taki object mai koi change na kr ske

	public Student(String name, int rollNo) {
		this.name = name;
		this.rollNo = rollNo;
		numStudents++; // everytime a object is created we want to increase our numStudents, so jab bhi object create hoga ekbar constructor call hoga
	}
	
	
	// just like static data members we have static/non static functions
	//static functions woh hote hai jo object pe depend nhi krte (mai s1 pe call karu ya s2 pe use koi farak nhi padta)
	// non static function means, jaise getRollNumber s1 ka and s2 ka alag hai, this is non static function.
	public static int getnumStudents() { //numStudents same hi rahga sabke liye so we need to make this function a static. 
		return numStudents;
	}

	public int getRollNumber() {
		return rollNo;
	}

	public void print() {
		System.out.println(name + " " + rollNo);
	}

}
