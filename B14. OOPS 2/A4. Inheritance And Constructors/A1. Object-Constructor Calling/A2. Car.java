package Maps;

public class Car extends Vehicle { 

	int numGears;
	int isConvertible;
	
	public Car() {
		System.out.println("Car Constructor");
	}
	
	public void print() { 
		super.print(); 
		System.out.println("numGears : "+numGears);
		System.out.println("isConvertible : "+isConvertible);

	}

}
