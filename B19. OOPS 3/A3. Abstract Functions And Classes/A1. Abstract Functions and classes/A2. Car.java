package final_keyword;
     
 //1. Car ne bola mai vehicle ko extend karna chahta hu jo incomplete hai, Car ne Vehicle ko extend karne ke bad Car mai woh incomplete function bhi aagya
 //2. ab car mai bhi incomplete function aagye ab Car ke pas do options hai- Car ya to delcare krde ki mai incomplete class hu or Car iss incompleteness ko khatam karde means Car khudko complete karle.
 //3. but agar Car ne khudko abstract kiya to VehicleUse mai Car class ka object nhi bana skte so getting rid of the incompleteness is only option.
public abstract class Car extends Vehicle{
	int numGears;
	boolean isConvertible;
	
	//4. jo function incomplete tha usko complete karre, ab hum VehicleUse mai c.isMotorized kr skte hai woh error nhi dega.
	@Override
	public boolean isMotorized() {
		return false;
	}
	
	//5. Vehicle mai humne ek aur incomplete function banaya getCompany() but car ko nhi pta yeh, car ke pas woh function nhi hai. So hume Car class ko abstract banana padega. and new BMW class banake usme Car ko inherit karna padega.
	
	public Car() { //Car ke andar default constructor bana diya taki BMW ko constructor banana na pde.
		super(100);
	}
	
	
	public void print() { 
		super.print();
		System.out.println("Car numGears : " + numGears);
		System.out.println("Car isConvertible : " + isConvertible);
	}
}
