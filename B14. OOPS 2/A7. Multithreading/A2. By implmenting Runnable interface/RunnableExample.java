package Codes;

class myThreadRunnable1 implements Runnable{
	
	public void run() {
		int i=0;
		while( i < 100) {
			System.out.println("Thread1");
			i++;
		}
	}
	
}

class myThreadRunnable2 implements Runnable{
	
	public void run() {
		int i=0;

		while( i < 100) {
			System.out.println("Thread2");
			i++;
		}
	}
}

public class RunnableExample {

	public static void main(String[] args) {
		
		myThreadRunnable1 bullet1 = new myThreadRunnable1();//myThreadRunnable1 is a class that implements the Runnable interface, which means it can be used to create threads that can be run concurrently with other threads. 
		Thread gun1 = new Thread(bullet1);//this say defines the code that will be executed in the thread
		//yeh bullet gun ke bina nhi chal skti. gun ke andar bullet lagani pdegi
		
		myThreadRunnable2 bullet2 = new myThreadRunnable2();
		Thread gun2 = new Thread(bullet2);
		
		gun1.start();
		gun2.start();
		
	}

}
