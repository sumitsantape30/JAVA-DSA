package ArrayList;

import java.util.ArrayList; // remeber sagrs, s: size, a: add, g: get, r:remove, s: set

//1. ArrayList is the class which behaves similar to that Dynamic Array Class, pehle se size batane ki jarurat nhi hai, tum dalte jaoge woh apne aap ko grow krta jayega. apne aap ko uske according adjust krta jayega.
// 2. ArrayList generic hai
// 3. ArrayList ko use karna hoga to arrayList class ko import karna hoga.
public class ArrayList_Demo {

	public static void main(String[] args) {

		//4. muje integers ki arrayList banani hai to generics mai Integer likhna hoga.
		ArrayList<Integer> list1 = new ArrayList<>(); //5.jaisehi humne yeh kiya, woh internally ek fix capacity ka array rakh leta hai apne pas, it's default capacity is 10.
		//6. agar humne ArrayList ke constructor mai kuch input nhi kiya to internally jo array use hota hai uski capacity 10 hoti hai
        //7. ArrayList<Integer> list1 = new ArrayList<>(5); agar hum chahe to size de skte hai, ab jo internal array banega woh 5 size ka hoga, capacity 5 kr dega.
		
		//8. Capacity: Maximum kitne elements dal skte hai, Size: Abhi user ne kitne elements dale hai
		
		System.out.println(list1.size());//9.abhi user ne list mai ek bhi element nhi dala hai so list ki size zero hai, Output: 0

		//Arraylist mai element add karne keliye.
		
		list1.add(15);// yeh add list ke end mai jake krdeta hai, abhito list khali hai so 0th index pe dalega.
		list1.add(20); // yeh list ke end mai add hoga means 12 ke just next mai.
		list1.add(25);
		
		System.out.println(list1.size());// 3 elements dal chuke hai so list mai 3 elements hai so it's size came out to be 3, Output: 3
		
		//ArrayList mai indexing array jaisehi hogi, so 2th index pe kya value hai yeh read karne keliye.
		System.out.println(list1.get(2)); //Output: 76
		
		//agar particular index pe element add karna hai to
		list1.add(2, 50); //index 2th pe 50 ayega and baki sab ek ek se shift honge means pehle 2th index pe pehle 76 tha ab 76 shift hoke 3rd index pe jayega so obviously list ka size badhega
     	System.out.println(list1.get(2)); //Output: 50, maine 2th index ka element update kardiya
        
     	//humne 2th index pe ek element add kiya and baki ek se shift so list1 ka size badha
 		System.out.println(list1.size()); //Output: 4

		
        // agar arrayList ke sare elements ek ek krke print karane hai to hum for loop ka use kr skte hai
		for (int i = 0; i < list1.size(); i++) {
			System.out.print(list1.get(i) + " "); //arraylist mai ith index pe jo element rakha hai woh get karna hai
		}
		
		//koi particular index pe rakha hua element delete karne keliye
		list1.remove(1); //muje index 1 se element remove karna hai
		
		//to place other element on the place of older element, set is not changing the size bas us index pe jake override kr rha hai, and add is adding new element to the list so size will increasing during adding.
		list1.set(1,100 ); // koi index pe set karne se size utti hi raheagi bas 0th index pe 32 aajayega
		
		//jaise array mai while accessing indexes we have to be careful arrayIndexOutOfBound arr skta hai, aaraylist mai bhi you should be careful while accessing indexes
		// so agar mai arraylist ka aisa index access kr rha hu hai hi nhi list mai
		// list1.get(5); -- IndexOutOfBoundsException: Index: 5, Size: 3, 0 se list.size()-1 tak hi valid range of index hai hum inhi indexes ko access kr skte hai
		 
		for(int i=0;i< list1.size();i++) {
			System.out.print(list1.get(i)+" ");
		}
		


	}
}

Output:

0
3
25
50
4
15 20 50 25 15 100 25 
