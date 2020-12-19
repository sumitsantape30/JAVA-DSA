package Oops2;

public class Car extends Vehicle { 
	// car ke andar vehicle ke private data memebr bhi inherit honge but directly access nhi kr skti
	//yaha mai car specific chize dal dunga
	int numGears;
	int isConvertible;
	
	public void print() { //printCar() se print() kiya hua h
		System.out.println("Car Color : "+color); //hum color and maxSpeed ko access kr pa rhe h
		System.out.println("Car maxSpeed : "+getmaxSpeed()); //car bhi getmaxSpeed access kr skti hai coz woh function public h and then getmaxSpeed function maxspeed ko access kr skta h
		System.out.println("numGears : "+numGears);
		System.out.println("isConvertible : "+isConvertible);

	}

}
