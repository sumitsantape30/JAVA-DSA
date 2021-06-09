package Restart;

public class Car extends Vehicle {

	int numGears;
	int isConvertible;
	
	public Car(int numGears) { //yaha error ayega coz humne Vehicle ka default constructor delete kardiya hai humne input wala constructor banaya hai so jab car ka constructor call hoga to vehicle banega hi nhi, so hum super use krke vehicle ko maxSpeed input denge 
		super(100); //so yaha specifically vehicle ke constructor ko call kiya hai
		// but agar humne Vehicle class mai agar default constructor de diya to iss super(100) ki koi jarurat nhi hai
		this.numGears= numGears;
		System.out.println("Car Constructor");
	} // hum iss car ke constuctor sebhi maxSpeed ko input le skte hai aur uske super mai pass kr skte hai. Firs iss car class ka object banate time bhi hume maxSpeed number mai pass karni hogi
	
	public void print() { 
		super.print(); 
		System.out.println("numGears : "+numGears);
		System.out.println("isConvertible : "+isConvertible);

	}
	
}
