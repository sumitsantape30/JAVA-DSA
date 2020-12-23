package Generics;

//just one class which is generic jiske andar hum kisibhi type ka data store kar payenge.
public class Pair<T> { //hume iss class keliye likhna hoga ki yeh generic hai, iske bad Pair class assume karlegi T hum badme batayenge
	//Jab muje Pair chahiye hoga integer type ka, to mai T ki jagah Integer dunga, object banate time i'll decide muje class ke andar exact kis type ka data chahiye
	
	//jab muje actually pair banana hoga mai us time bataunge T integer hai ya string hai, abhi class ban rhi hai, jab class ban rhi hoti hai tab actual object nhi bante hai, jab mai new keyword use krke kuch banaunga tab actual object bante hai, jab actual objects ban rhe honge mai us time T kya hai bataunga.
     private T first; //feeling is, 'first' jo h yeh T type ka hai kuch 
     private T second; //Second jo h yeh T type ka h kuch
    
     public Pair(T first,T second) {
    	 this.first= first;
    	 this.second= second;
     }
     
     public T getFirst() {
    	 return first;
     }
     
     public void setFirst(T first) {
    	 this.first= first;
     }
     
     public void setSecond(T second) {
    	 this.second= second;
     }
     
     public T getSecond() {
    	 return second;
     }
}
