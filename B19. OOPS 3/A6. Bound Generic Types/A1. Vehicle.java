package Bound_Generics_Types;

public class Vehicle implements PrintInterface {
    protected String color;
     private int maxSpeed;
     

     public Vehicle(int maxSpeed) {
    	 this.maxSpeed=maxSpeed;
     }
     
     public int getmaxSpeed() {
    	 return maxSpeed;
     }
     
     public void setmaxSpeed(int maxSpeed) {
    	 this.maxSpeed=maxSpeed;
     }
     

     public final void print() {
    	 System.out.println("Color : "+color);
    	 System.out.println("maxSpeed : "+maxSpeed);
     }  
}
