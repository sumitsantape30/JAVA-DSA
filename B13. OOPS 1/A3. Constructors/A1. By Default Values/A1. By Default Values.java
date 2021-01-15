public class Student {

	//by default when you create a student object all the properties that you have here gets initialized by zero, string ke case mai null.
	       String name;
	 public int rollNo;
   
   }
   
   public class StudentUse {

	public static void main(String[] args) {

		
		Student s1= new Student(); 
		
		//by default when you create a object all the properties that you have here gets initialized by zero, string ke case mai null.
		System.out.println(s1.name); //Output: null
		System.out.println(s1.getRollNumber()); //Output: 0
		
	}

}
