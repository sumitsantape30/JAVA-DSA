package Interface;

   //One interface can extend another interface
   // CarInterface VehicleInterface ke sare functions extend kar chuki hai
  //and if you are extending CarInterface you need to have getCompany function and all the fuctions which are defined in VehicleInterface
public interface CarInterface extends VehicleInterface {
	public String getCompany();

}
