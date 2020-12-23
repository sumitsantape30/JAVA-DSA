package Interface;

  //1. Agar tum ek class ko inherit karna chahte ho to tum likhte ho extends that class, aur agar tum ek interface ko inherit karna chahte ho to hume likhne hoga- implements, ki mai us interface ko implment krta hu
public class Vehicle implements VehicleInterface { //2.inteface mai bohot sare functions incomplete hai so Vehicle is saying thik hai woh saare functions mai implement karunga which you want me to define.
	//3.vehicle is incomplete class now, it supposed to have those functions (jo functions VehicleInterface mai hai) which it doesnt have right now, so do options hai ya to hum apni class ko abstract declare krde yafir woh functions hum implement karde.
	
	//4. Vehicle is implementing VehicleInterface.
	public int getMaxSpeed() {
		return 10;
	}
	
	public void print() {
		
	}
	
}
