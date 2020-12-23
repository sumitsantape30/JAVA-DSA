package Interface;

 //1. Interface is an class with all  its functions abstract.
 // yaha class ki jagah interface likha hai
public interface VehicleInterface {

	//2. Below functions are by default abstract, we don't need to put 'abstract' before function coz by default its abstract
	
	//if we have to keep data member inside interface, hum iss type ke rakh rhe honge. final static banake rakhenge sirf constant store karna rhe tabhi rakhenge,
	public final static double PI = 3.14;//Interfaces ke andar hum koi bhi data member nhi rakhte hai agar koi data member rakhte hai to hum isi type ke rakh rhe honge.


	public int getMaxSpeed();

	public void print();

}
