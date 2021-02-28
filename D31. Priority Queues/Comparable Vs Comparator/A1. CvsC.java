package ComparatorVsComparable;

import java.util.Comparator;
import java.util.PriorityQueue;

public class CVsC {
	
	
	// 4. comparable nam ka interface implement karna padega to compare students *book mai 2nd point se 4th point tak dekho*
static class Student implements Comparable<Student>{
	
	int rno;
	int ht;
	int wt;
	
	public Student(int rno, int ht, int wt) {
		this.rno= rno;
		this.ht= ht;
		this.wt= wt;
	}
	
	@Override
	public int compareTo(Student o) {//5.other student input mai ara. And this.rno pe compare kar rha hu mai, compareTo aisa function hai jo expectation rakhta hai ki mera pas do objects honge ek this and ek other
		return this.rno - o.rno;//7. agar child ka rno number means ka 'this' ka rno chota hai aur others ka rno bada hai means yahase negative value return hogi
		//6. object ka scene? hum implemented priority queue mai parent and child compare karre tha to ab woh grater than sign ke jagah parent kobhi aur child kobhi comparable mai type caste karlega aur child ke upar compareTo function call karke parent ko object ke form mai pass kardega. *Book mai 5th point dekho*
	}
	
	//8. Student object ko directly print karoge to woh kuch print nhi karega unka address print hoga, student object ko print karna hai to toString function ki body deni padegi
	public String toString() {
		return "rno= "+ this.rno + ", ht= "+this.ht+ "ht= "+this.ht+ ", wt= "+this.wt;
	}
	//9. hume ouput mai increasing roll no mai milega coz jab hume comparison karna tha to usne comparable call kiya *Book ka 7th point dekho*
	//10. hume chote value pahle chahiye isliye this- other likhe aur agar badi value pehle chahiye to other- this likh dijiye
}

   //11. jab student ko ek se jada criteria pe compare karna hota hai uske liye ek aur interface hota hai jisse comparator bolte hai
static class StudentHtComparator implements Comparator<Student> {//12. iss function ka yahi purpose hai yeh student ke comparison keliye bani hai unke height ke basis pe comparison karati hai
	
	@Override
	public int compare(Student s1, Student s2) { //comparable mai ek argument pass hota hai aur dusra this hotjata hai yahape dono argument pass hi hote hai
		return  s1.ht - s2.ht;
	} 
}

//12. for comparison based on weight
static class StudentWtComparator implements Comparator<Student>{

	@Override
	public int compare(Student s1, Student s2) {
		return s1.wt - s2.wt;
		//agar muje pehle bada height wala chahiye to mai s2 - s1 karunga
	}
	
}

	public static void main(String[] args) {
		
		int arr[]= {10, 2, 17, 3, 18, 9, 22};
		PriorityQueue<Student> pq1= new PriorityQueue<Student>(); // 1. mai chahta hu ki student type ki priority queue ho, means student class ki priority ho
		//13. agar maine yaha priority queue mai kuch pass nhi krta to woh comparable ke basis pe chalti hai means rollno ke basis pe chal rhi hai aur agar mai usko comparator ka object provide krdu 
		PriorityQueue<Student> pq= new PriorityQueue<Student>(new StudentWtComparator());  //weight comparator ka object provide kiya
		//ab sabse chote weight wala pehle nikalke print hoga
		// aur agar height comparator ka object provide kiya to sabse kam height wala pehle print hoga
		
		//2. ab mai priority queue mai boht saare students dal dunga fir mai chahunga ki woh kabhi roll no pe sorted aajane chahiye kabhi weight pr kbhi height pr
		
		pq.add(new Student(10, 180, 81));
		pq.add(new Student(2, 180, 89));
		pq.add(new Student(12, 180, 78));
		pq.add(new Student(18, 180, 81));
		pq.add(new Student(7, 180, 10));

		//3. yeh program muje class cast exception dega ki main student cannot be cast to comparable, shift up comparable
		//humne jo priority queue implement ki thi usme add karne ke bad upheapify hota tha to usme child and parent ka comparison hota tha  and unmese jo hota hai woh upar jata tha so, integer ki case mai to woh comparsion hojayega
		// soo iss inbuilt priority queue mai bhi upheapify function hoga na jo add ke dauran chlta hoga woh parent aur child ko compare karke chote student ko upar bhejna chahega but waha parent student aur child student kebich mai grater than ka comparison chalega nhi to woh comparison keliye woh chahta hai ki hum jis chiz(Student) ko pass kr rhe hai ek interface implement kare comparable nam ka

		while( ! pq.isEmpty()) {
			System.out.println(pq.remove());
      
		}

	}

}

Output:
