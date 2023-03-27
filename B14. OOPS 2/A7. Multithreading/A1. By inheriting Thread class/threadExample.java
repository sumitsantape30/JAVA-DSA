package Codes;

class myThread1 extends Thread{
	
	@Override
	public void run() { //overriding horhi hai yaha
		int i=0;
		while(i<10000) {
			System.out.println("Thread1");
			i++;
		}
		
	}
	
}

class myThread2 extends Thread{
	
	@Override
	public void run() { //overriding horhi hai yaha
		int i=0;
		while(i< 10000) {
			System.out.println("Thread2");
			i++;
		}
		
	}
	
}//so maine 2 classes banayi hai unmne run method ko override kiya hua hai

//1. multithreading: Multithreading is a programming concept that allows multiple 
//threads (smaller units of execution) to execute concurrently within a single process. 
//In other words, a single program can run multiple threads of execution at the same time, 
//allowing for parallelism and increased efficiency.

public class threadExample {

	public static void main(String[] args) {

		myThread1 t1 = new myThread1();
		myThread2 t2 = new myThread2();
		
		t1.start();//thread ko start krne keliye start method hota hai. yeh start method internally apne hisab se upar ke run method ko call krleta hai
		t2.start();
		//print krte time yeh kuch time t1 ko dega kuch time t2 ko dega but dono methods chal rhi hogi
		//ek hi program mai dono tasks horhe hai
		
		
		
	}

}
