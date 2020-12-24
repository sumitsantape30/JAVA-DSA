package Bound_Generics_Types;


public class Print {
   
	//4. yeh wala print function bas inbuild types like Integer,String hai unke liye will work fine. But baki jo meri koi bhi class hogi uske liye agar mai yeh wala print karne ki koshish karunga to woh address print krdega
	//8. Actually we can bound, what kind of T will be accepted here (hum yeh bol skte ki bas yeh type ke T liyo baki mat liyo)
	//9. I can say please take only those T's which extends Vehicle class. (it's saying ki bas woh T liyo jo Vehicle ko extend krte hai this doesn't mean ki Vehice ki direct subclass hogi, you can say Vehicle ke niche Car hai,BMW hai to that is also okay, MBW car ko extend krti hai, Car Vehicle ko extend krti hai to usme koi issue nhi hai tum BMW bhi pass kr skte ho
	//10. but aurbhi classes hongi jinke pas print function ho skta hai, woh vehicle ki subclass nhi hai but unke pas print function hai to unko kyu print nhi kr pa rhe, maine Vehicle mai PrintInterface implment kiye
	//11. Now I will not say extends Vehicle, I'll say extends extends PrintInterface. (extend hi ayega (not implment) yeh generic bound krne keliye interface ho ya class ho hum extends hi likhte hai
	//12. humne extends PrintInterface likha means we're saying sirf aise T ayenge joki PrintInterface ko implement krte hai, that means tumhare print function hogahi
	public static <T extends PrintInterface> void PrintArray(T arr[]) {
		for (int i = 0; i < arr.length; i++) {
			//5. muje class ka print fucntion call karna hai so .(dot) lagake call karna padega.
			//arr[i].print();//6. this is giving error coz not T functions are going to have print() fucntion, if user passed a T which does not have print function it'll stuck.
         
			// System.out.print(arr[i]); //isse vehicles ke addresses print honge.

			//7. But we have the way where you can guarantee this function(<T>) ki jo bhi T ayega uske pas print() fucntion hoga. 
			System.out.print(" ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		
		Integer arr[] = new Integer[10];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i + 1;
		}

		String str[] = new String[10];
		for (int i = 0; i < str.length; i++) {
			str[i] = "abc";
		}

		//13. String, Integer array print nhi kr skte coz they won't implement the interface we want.
		//PrintArray(arr);
		//PrintArray(str);

		//1. Vehicle ek object ki subclass hai coz Vehicle object class se inherited hai kahi na kahi
		Vehicle v[] = new Vehicle[10];//yahape Vehicle banaye nhi hai, abhi sirf array banaya hai, aisa array jiske andar in vehicles ka address ayega, but woh by default null honge.
		for (int i = 0; i < 10; i++) {
			v[i] = new Vehicle(10);
		}
		//PrintArray(v); //2. ek vehicle print hoga to actually us vehicle ka address print ho rha hai, tum jab array ki ith entry ko print kr rhe ho, woh ith entry uss vehicle ka address hai so bas address print hoga.
	
		//3. but hume address print nhi karna hai we want ki Vehcle class ke andar wala print() function call hona chahiye.
		
		
		//14. Creating student array
		Student s1[]= new Student[10];
		for( int i=0; i< 10; i++) {
			s1[i]= new Student();
		}
		PrintArray(s1); //15. although Student class has print function but hum use directly nhi kr skte we need to implement PrintInterface in Student class
	//16. jaisehi student class mai implements PrintInterface likha ab hum student array ko PrintArray function mai bhej skte hai, coz PrintArray ko bol rha hai mai unhiko allow karunga jo printInterface implement krte hai, student ne woh contract sign kiya(implementing PrintInterface) ab woh PrintArray ke pass ja skta hai
	}
}
