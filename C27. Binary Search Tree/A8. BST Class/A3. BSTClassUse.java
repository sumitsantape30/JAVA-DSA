package BinarySearchTree;

public class BSTClassUse {

	public static void main(String[] args) {

		BinarySearchTreeClass bst= new BinarySearchTreeClass(); //maine apni BinarySearchTreeClass ka object banaya 
		bst.insertData(10);
		bst.insertData(20);
		bst.insertData(5);
		bst.insertData(15);
		bst.insertData(7);
		bst.insertData(3);
		bst.print();
		System.out.println();
		bst.deleteData(10); //root ko delete karre
		bst.print();

//Sabse pehle 10 jayega to 1 root ban jayega then hum bolenge 10 ke right mai jao then 20 wahape attach hojayega
//fir hum bolenge 5, then 10 ke left mai jao and 5 left mai attach ho jayeha 10 ke. Fir hum bolenge 15, then 10 bolega right jao, 20 bolega left jao, to 15 left mai attach hojayega 20 ke
//fir hum bolenge 3, 10 bolega left jao, 5 bolega bolega left jao, 3 left mai attach hojayega 5 ke, then 7 attach hogayega 5 ke right mai

	
	}

}
