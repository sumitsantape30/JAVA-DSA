import java.util.ArrayList;

//jaise ek linkedlist banane keliye ek node define ki thi humne, taki hum inn node ko connect kar krke apni linked list bana ske
// Similarly hume ek tree banane keliye we need to define a basic structure called TreeNode
// har treenode mai khudka data store kara hoga, Linkedlist ke case mai hum khudka data aur ek aur node ka data uske next mai store krte the, but treenode ki case mai, woh khudka data store karega and uske jitne childrens hai unka address store karega.
// so multiple children ka adress karna hai, humare pas multiple chize store karne keliye three options hai array, linkedlist aur arraylist. Arraylist ki case mai agar 4 ke three childrens hai aur muje first nhi second child chahiye to muje traverse karna padega and wahi array ke case mai direct index se direct access kr skta hu but array ki problem yeh hai ki muje array ki size btani padti hai so we'll use arrayList to store the address of multiple childrens inside a treeNode
// so humare TeeNode mai data hoga and ArrayList hogi.
//Muje ek arraylist chahiye jisme mai TreeNode(chidren) store kar saku aur us TreeNode ke andar T type ka data hoga
// mere root node ke data ke type T hai to mere children ke data kabhi type T ho.
// We'll make this class a generic which can store any kind of data
public class TreeNode<T> {
	//hum data memeber ko aisehi public rakh rha hai
     public T data;
     public  ArrayList<TreeNode<T>> children; //Muje ek arraylist chahiye jisme mai TreeNode(chidren) store kar saku aur us TreeNode ke andar T type ka data hoga  
     
      public TreeNode(T data) { //jab bhi muje ek Tree Node banana hoga to mai yeh constructor call karunga, aur mai bina data ke constructor call karne nhi dunga
    	  this.data= data; //data memeber wale data ke sath input wale data ko assign kardiya
    	//by default children datamember mai null hoga, so by default humari children arraylist null hai abhitak bani nhi hai, so usko banayenge
    	  children = new ArrayList<>(); //so humari new ArrayList ban chuki hai children nam ki, woh pehle null thi isliye humne abhi banayi  
      }
      // so ab humara TreeNode bangya jiske andar data ajayega and humare TreeNode(root) ke pas capability aagyi hai multiple data store karneki
}
