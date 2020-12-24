package LinkedList;

//Structure of a single Node (ek node ka structure class ke form mai rakh rhe hai)
//ek node mai muje data rakhna hai and reference rakhna hai next node ka
//agar mera data string type ka hai ya student type ka hai to muje un sabke liye separate node class banani padegi so hum iss class ko generics mai krte hai
public class Node<T> {
	
	T data;
	Node<T> next; //jo next node ka reference rahega woh bhi node type kahi rahega (next 'T' hi type ke next node ko point karega). eg. agar linked list ka ek node integer hai to woh next usi node ko point karega jiska data bhi integer type kahi ho
	
	Node(T data){
		this.data= data;
		next= null; //jab mai memroy mai ek hi node banaunga khali to uska next null rahega.
	}

}
