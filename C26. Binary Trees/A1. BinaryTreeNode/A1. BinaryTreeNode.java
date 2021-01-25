
//yeh ek generic class hogi, mai nhi chahta ki har type ka data store karne keliye bar bar uss datatype keliye separate class banau isliye generic
public class BinaryTreeNode<T> { //humare ek node mai data rahega and do children ke addresses rahenge, ek left wale child ka aur right wale child ka

	//mai inki visibility restrict nhi karna chahta so public rakhgenge taki koi bhi change kar paye
	public T data;
	public BinaryTreeNode<T> left;
	public BinaryTreeNode<T> right;
	
	public BinaryTreeNode(T data) {
		this.data= data;
	} //left and right to waisebhi by default null hi rahenge
}
