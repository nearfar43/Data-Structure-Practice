package binarySearchTree;

public class BinarySearchTree {

	Node root;


	public BinarySearchTree() {

		this.root = null;
	}

	class Node {

		int key;

		Node left;

		Node right;

		public Node(int value) {

			this.key = value;
			this.left = null;
			this.right = null;
		}

	}
	//search in tree
	public Node searchNode(Node root, int value) {

		//root is what looking for....
		if (root == null || root.key == value) {

			return root;
		}

		// if value bigger than root, search right part with recursion
		if (root.key < value) {

			return searchNode(root.right, value);

		}

		//if value smaller than root, search left part with recursion
		else {


			return searchNode(root.left, value);
		}

	}
	
	
	public void insert(int value) {
		
		root = insertNode(root, value);
	}
	
	//insert in tree
	public Node insertNode(Node node, int value) {
		
		//if no any value inside the node....
		
		if (node == null) {
			
			node = new Node(value);
			
			return node;
		}
		
		//check to see the value should be inputed in left or right...
		
		if (node.key < value) {
			
			node.right = insertNode(node.right, value);	
			
		}
		else {
			
			node.left = insertNode(node.left, value);
			
		}
		
		return node;
	}
	
	
	
	public void inorder() {
		
		printInorder(root);
	}
	
	//in order 
	public void printInorder(Node node) {
		
		if (node != null) {
			
			//left
			printInorder(node.left);
			//root
			System.out.println(node.key);
			//right
			printInorder(node.right);
			
		}
	}
	
	//post order
	public void printPostorder(Node node) {
		
		if (node != null) {
			
			//left
			printPostorder(node.left);
			//right
			printPostorder(node.right);
			//root
			System.out.println(node.key);
			
		}
	}
	
	//pre order
	public void printPreorder(Node node) {
		
		if (node != null) {
			
			//root
			System.out.println(node.key);
			//left
			printPreorder(node.left);
			//right
			printPreorder(node.right);
			
		}
		
		
		
	}
	
	public void delete(int value) {
		
		deleteNode(root, value);
	}
	
	public Node deleteNode(Node root, int value) {
		
		//if the tree is null...		
		if(root == null) {
			
			return root;
		}
		
		//search for the node deleted
		
		/// search right if value is bigger than root value
		if (value > root.key) {
			
			root.right = deleteNode(root.right, value);
			
		}
		
		//// search left if value is smaller than root value
		else if (value < root.key) {
			
			root.left = deleteNode(root.left, value);
		}
		
		
		/// the node is just what you are looking for....
		else {
			
			if (root.right == null) {
				return root.left;
			}
			
			else {
				
				Node node = root.right;
				
				//finding inorder the smallest value....
				while(node.left != null) {
							
					node = node.left;
					
				}
				
				//replace.... with the root.value and the smallest value....
				root.key = node.key;
				
				//delete.....the smallest node...				
				root.right = deleteNode(root.right, root.key);			
				
			}
			
					
		}
		
		return root;
				
	}
	
	
	public static void main(String[] args) {
		
		BinarySearchTree bt = new BinarySearchTree();
		bt.insert(30);
		bt.insert(25);
		bt.insert(40);
		bt.insert(37);
		bt.insert(39);
		bt.insert(38);
		bt.insert(36);


		bt.delete(30);
		
		bt.inorder();
		
		
	}
	
	
	


}
