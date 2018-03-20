package linkedList;

public class LinkedList {
	
	Node head;	
	int numberOfNode = 0;
	
	class Node {
		
		int data;
		Node next;
		
		Node (int data) {
			
			this.data = data;
			this.next = null;
		}
	}
	
	public void insertFront(int newData) {
		
		Node newNode = new Node(newData);
		
		newNode.next = head;
		
		head = newNode;
		numberOfNode++;
	}
	
	
	public void insertAfter(int newData, Node previousNode) {
		
		///check if the given node is null
		if (previousNode == null) {
			
			return;
		}
		
		Node newNode = new Node(newData);
		
		newNode.next = previousNode.next;
		
		previousNode.next = newNode;
		numberOfNode++;
	}
	
	public void insertEnd(int newData) {
		
		Node newNode = new Node(newData);
		
		if (head == null) {
			
			head = newNode;
			
			return;
		}
		
		//find the last node from head....
		Node last = head;
		
		while (last.next != null) {
			
			last = last.next;
		}
		
		last.next = newNode;
		
		newNode.next = null;
		numberOfNode++;
	}
	
	

}
