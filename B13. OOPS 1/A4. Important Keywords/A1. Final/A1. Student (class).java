package Restart;

public class Student {

	//I want to get the rollNo as soon as object is created but rollNo should not be changed after that, once student is created with particular rollNo
	//that rollNo is no going to change for that object so we wan't our data memeber to be final.
	// final means you cannot change it, once it has been initialized, so woh bas ekbar initialise kr skta hai uske bad nhi kr skte.
	// you can initialize final only when you are declaring it or inside the constructor uske alawa kahi nhi kr skte.
	
	
	
	String name;
	private final int rollNo;
	//private  final int rollNo = 100; ==> this is one way to intialise rollNo as soon as we declared it but this not good way though, but after using this way, now every object we are going to create will have rollNo 100

	
	//Because ek object pe constructor ek hi bar call kr skte ho tum so constructor ke andar bhi final ko initialzed kr skte ho
	// coz hume pta hai ek hi bar call hoga to wahipe set kr dete.
	public Student(String n, int rn) {
		name = n;
		rollNo = rn;
	}

//	public Student(String n) {// agar humne yeh constructor use karke student(object) ko create kiya to gadbad hojayegi because rollNo set hi nhi hua, woh sirf string input lera.
//		name = n;
//	}

	public int getRollNumber() {
		return rollNo;
	}

	public void print() {
		System.out.println(name + " " + rollNo);
	}
	
	// setRollNumber pe error ayega coz jab  student bana tabhi rollNo assigned hua
//	public void setRollNumber(int rn) {
//		if (rn <= 0) {
//			return;
//		}
//		rollNo = rn;
//	}

	
}
