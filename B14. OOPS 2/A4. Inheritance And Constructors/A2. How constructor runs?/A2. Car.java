package Maps;

public class Car extends Vehicle { 

	int numGears;
	int isConvertible;
	
	public Car( int numGears) {
		// vehicle ka default constructor gayab kardiya tha so super comes to rescue, humne specifically vehical ke constructor ko call kiya.
		super(100); //humne specifically vehicle ke constructor ko call kiya coz mere parent class ke pas default constructor nhi tha
		this.numGears= numGears;
		System.out.println("Car Constructor");
	}
	
	public void print() { 
		super.print(); 
		System.out.println("numGears : "+numGears);
		System.out.println("isConvertible : "+isConvertible);

	}

}
