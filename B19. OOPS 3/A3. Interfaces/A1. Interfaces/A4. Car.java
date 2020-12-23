package Interface;

   //1. Car Vehicle ko inherit kar rha h 
  //2. Agar tum ek class ko inherit karna chahte ho to tum likhte ho extends that class, aur agar tum ek interface ko inherit karna chahte ho to hume likhne hoga implements.
  //3. Car Vehicle ko extend krti hai to effectively Car ke andar bhi woh functions aa chuke hai, Car bhi woh function use kr skti hai
  //4. agar muje Car mai Vehicle and Vehicle2 donoko extend karna hai to ,(comma) deke extend kiye to error ayega, hum ek hi class ko extend kr skte hai. Car Vehicle ko extend karri hai but along with extending vehicle car chahe to implement kr skti hai VehicleInterface.
  //5. that means you cannot extend more than one class but you can extend one class and Interface as well. (You can implement multiple interfaces as well, actually it can implement infinite number of interfaces)
public class Car extends Vehicle implements CarInterface { // car can implement both VehicleInterface, CarInterface. (aisa karne ka bad car ko saare functions implement karne padenge)
	   //CarInterface is exdenting VehicleInterface, 
	   //if you are extending CarInterface you need to have getCompany function (the function which is in CarInterface) and all the functions which are defined in VehicleInterface

	  
	  @Override
	public void print() {
		  
	  }
 
	  @Override
	public int getMaxSpeed() {
		  return 0;
	  }
	  
	  @Override
	  public String getCompany() {
		  return null;
	  }
	  
}
