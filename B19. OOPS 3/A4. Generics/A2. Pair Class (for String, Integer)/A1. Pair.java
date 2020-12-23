package Generics;
   
  //Integer, Integer ka pair hona jaruri nhi hai, Piar Integer,String bhi ho skta hai
  //first and Second need not to be the same, manlo muje first mai String chahiye second mai Integer chahiye
  //So I want first kisi aur type ka rakh pau and second kisi aur type ka, pehle generic T pe tha, mai comma laga ke bol skta hu ki V bhi ek parameter hai
public class Pair<T,V> { 
	
     private T first;  
     private V second;  //second V type ka hai, so tumhe ab sab jagah change karna padega
    
     public Pair(T first,V second) {
    	 this.first= first;
    	 this.second= second;
     }
     
     public T getFirst() {
    	 return first;
     }
     
     public void setFirst(T first) {
    	 this.first= first;
     }
     
     public void setSecond(V second) {
    	 this.second= second;
     }
     
     public V getSecond() {
    	 return second;
     }
}
