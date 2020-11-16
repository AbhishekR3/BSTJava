/*
* Main testing class for BST
* @author: Abhishek Ramesh
*/

public class BSTtest{

	public static void main(String[] args){
		//Binary Search Tree Values
		int[] treeLength = {8, 26, 9, 6, 10, 1, 39, 84, 3, 30};

		// Created tree
		BST<Integer> tree = new BST<Integer>();

		//Inserted BST values into Tree
		for(int i=0; i < treeLength.length; i++){
			tree.insert(treeLength[i]);
		}

		int value = 6;

		//Find value
		System.out.println();
		System.out.println("Does " + value +  " exist: ");
		System.out.println(tree.find(value));

		//Delete value
		System.out.println();
		System.out.println("Delete: " + value);
		tree.delete(value);

		//Check if value still exists
		System.out.println();
		System.out.println("Does " + value +  " exist: ");
		System.out.println(tree.find(value));
		System.out.println();

		//Print out tree
		System.out.println("Binary Search Tree");
		tree.print();

		//Sum of Range
		System.out.println();
		int low = 5;
		int high = 30;
		System.out.println("Range: (" + low + "," + high + ")");
		System.out.println("Sum of Range Sum: " + tree.rangeSum(low, high));
		System.out.println();
	}
}
