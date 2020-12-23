package final_keyword;
     
    // isme boht saare erros aye hue hai
    // meri Vehicle class final hai so uss Vehicle class ko iss Car class mai inherit nhi kr skte.
public class Car extends Vehicle{
	int numGears;
	boolean isConvertible;
	
	public Car(int numGears, int maxSpeed) {
		super(maxSpeed);
		this.numGears = numGears;
		System.out.println("Car Constructor");
	}
	
	public boolean isConvertible() {
		return isConvertible;
	}
	
	//vehicle class ne print() function bahaya hai and car class ne bhi print() function banaya hai so effectively car class ne vehicle ke iss function ko override kardiya.
	//car was able to override this function but jaisehi vehicle ke print() ko final kardiya, car class k print() mai error aagya.
	//error ayega Cannot override the final method from Vehicle

	public void print() { //but agar iss fucntion ko run karana hi hai to we can change it's name to printCar(), then there will not be any error.
		super.print();
		System.out.println("Car numGears : " + numGears);
		System.out.println("Car isConvertible : " + isConvertible);
	}
}
