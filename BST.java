/*
* Binary Search Tree Data Structure
* @author : Abhishek Ramesh
*/
import java.util.*;

public class BST<T>
{
	// The root of the BST
	Node<T> root;
	int COUNT = 10; 

	// Node class for a BST
	private class Node<T>{
		int data;
		Node<T> left;
		Node<T> right;

		Node(int item){
			data = item;
		}
	}

	public BST(){
		root = null;
	}

	/*
	* Find function that finds an item in the BST
	* @param item to be found
	* @return boolean if the item was found
	*/
	public boolean find(int item){
		return find(item, root);
	}

	/*
	* Function override of the find function
	* @param item to be found
	* @param node the current node you are at
	* @return boolean if the item was found
	*/
	private boolean find(int item, Node<T> node){
		if (node==null){
			return false;
		}

		if (node.data == item){
			return true;
		}

		else if (item<node.data){
			return find(item, node.left);
		}

		else{
			return find(item, node.right);
		}
	}

	/*
	* Insert an item to the tree
	* @param item to insert
	*/
	public void insert(int item){
		root = insert(item, root);
	}

	/*
	* Helper function for insert
	* @param item to add
	* @param node you are at
	* @return node you traverse to
	*/
	private Node<T> insert(int item, Node<T> node){
		if (node == null){
			node = new Node(item);
			return node;
		}

		else if (item<node.data){
			node.left = insert(item, node.left);
		}

		else if (item>node.data){
			node.right = insert(item, node.right);
		}

		return node;
	}

	/*
	* Function for deletion of a node
	* @param item to delete
	*/
	public void delete(int item){
		root = delete(item, root);
	}

	/*
	* Helper function for deletion of a node
	* @param item to delete
	* @param node you are at
	* @return node you traverse to
	*/
	private Node<T> delete(int item, Node<T> node){
		if (node==null){
			return null;
		}

		if (node.data < item){
			node.right = delete(item, node.right);
			return node;
		}

		else if (node.data > item){
			node.left = delete(item, node.left);
			return node;
		}

		else{
			if (node.left == null){
				return node.right;
			}

			else if (node.right == null){
				return node.left;
			}

			else{
				if (node.right.left == null){
					node.data = node.right.data;
					node.right = node.right.right;
				}

				else{
					node.data = removeSmallest(node.right);
				}

				return node;
			}
		}
	}

	/*
	* Find smallest value at a certain node
	* @param node you are at
	* @return smallest value
	*/
	private int removeSmallest (Node<T> node){
		if (node.left.left == null){
			int smallest = node.left.data;
			node.left = node.left.right;
			return smallest;
		}

		else{
			return removeSmallest(node.left);
		}
	}

	/*
	* Function to find the range sum of the binary tree
	* @param L the left bound
	* @param R the right bound
	* @return The sum of the range in the binary tree
	*/
	public int rangeSum(int L, int R){
		if (root==null){
			return 0;
		}
		
		if (root.data >= L && root.data<=R){
			Node<T> rooty = root; 
			int og = rooty.data;

			root = rooty.left;
			int ogLeft = rangeSum(L, R);

			root = rooty.right;
			int ogRight = rangeSum(L, R);

			return og + ogLeft + ogRight;
		}
		
		else if (root.data < L){
			root = root.right;
			int ogRight = rangeSum(L, R);

			return ogRight;
		}
		
		else{
			root = root.left;
			int ogLeft = rangeSum(L, R);

			return ogLeft;
		}
	}

	/*
	//Print Binary Tree function
	*/
	public void print(){
		print(root, 0);
	}

	/*
	* Helper Function to print the Binary tree
	* @param root the root of the tree
	* @param space the distance to keep to indicate a value in in the next level
	*/
	private void print(Node<T> node, int space){
		if (node == null)
			return;

		space += COUNT;
	
		print(node.right, space);
	
		System.out.print("\n");
		for (int i = COUNT; i < space; i++)
			System.out.print(" ");
		System.out.print(node.data + "\n");
	
		print(node.left, space);
	}
}