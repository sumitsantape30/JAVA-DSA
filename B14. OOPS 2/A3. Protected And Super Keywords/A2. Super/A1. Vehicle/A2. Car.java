package Vehicle;

public class Car extends Vehicle { 

	int numGears;
	int isConvertible;
	
	public void print() { 
		//jo data memebers parent class mai hai woh mai super keyword se access kr skta hu instead of printing one by one
		super.print();//jo print function parent class mai hai woh run hoga
		//System.out.println("Car Color : "+color); 
		//System.out.println("Car maxSpeed : "+getmaxSpeed()); 
		System.out.println("numGears : "+numGears);
		System.out.println("isConvertible : "+isConvertible);

	}

}
