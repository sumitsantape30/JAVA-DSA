package vehicle;

public class Vehicle {
	protected String color;
	private int maxSpeed;

	public Vehicle(int maxSpeed) {
		this.maxSpeed = maxSpeed;
		System.out.println("Vehicle Constructor");
	}

	public int getmaxSpeed() {
		return maxSpeed;
	}

	public void setmaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}

	public void print() {
		System.out.println("Color : " + color);
		System.out.println("maxSpeed : " + maxSpeed);
	}
}
