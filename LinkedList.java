package linkedList;

import java.util.*;

public class LinkedList {

	private Node head;	
	int numberOfNode = 0;


	public LinkedList() {
		head = null;
	}

	public boolean isEmpty() {

		return head == null;
	}

	/*********************************
	 *
	 *		Node Class
	 *
	 **********************************/
	private static class Node {

		private int data;
		private Node next;

		public Node(int data, Node next) {

			this.data = data;
			this.next = next;
		}
	}

	////////////////////////////////////	

	/**
	 * 
	 * 	Inert a new node at the beginning of the list
	 */
	public void addFirst(int item) {

		head = new Node(item, head);

		numberOfNode++;
	}

	/**
	 * 	
	 * insert a new node at the end of the list
	 */	
	public void addEnd(int item) {

		if (head == null) {

			addFirst(item);

		}
		else {
			Node tmp = head;
			//find the last node
			while (tmp.next != null) {

				tmp = tmp.next;
			}

			//add the node in the end
			tmp.next = new Node(item, null);
			numberOfNode++;

		}

	}

	/**
	 * 
	 * inserts a new node after a node containing the key
	 */
	public void insertAfter(int item, int key) {

		Node tmp = head;

		while (tmp != null && tmp.data != key) {

			tmp = tmp.next;

		}

		if (tmp.next != null) {

			tmp.next = new Node(item, tmp.next);
			numberOfNode++;
		}

	}

	/**
	 * 	
	 * inserts a new node before a node containing the key
	 * 
	 */

	public void insertBefore(int item, int key) {

		if (head == null) {
			return;
		}

		// if the key is equal to the head.data
		if (head.data == key) {

			addFirst(item);
			return;
		}


		//find the node having key and the previous node

		Node pre = null;
		Node cur = head;

		while(cur != null && cur.data != key) {
			pre = cur;
			cur = cur.next;
		}

		//insert between
		if (cur != null) {

			pre.next = new Node (item, cur);
		}
	}


	/**
	 * 	
	 * Returns the first element in the list
	 */

	public int getFirst() {

		if (head == null) {

			throw new NoSuchElementException();
		}

		return head.data;
	}

	/**
	 * 	
	 * Returns the last element in the list
	 */

	public int getLast() {

		if (head == null) {

			throw new NoSuchElementException();
		}

		Node tmp = head;

		while(tmp.next != null) {
			tmp = tmp.next;
		}

		return tmp.data;

	}


	/**
	 *  Returns the data at the specified position in the list.
	 *
	 */

	public int get(int position) {
		
		if (head == null) {
			throw new IndexOutOfBoundsException();
		}
		
		Node tmp = head;
		
		for (int i = 0; i < position; i++) {
			
			tmp = tmp.next;
			
			if (tmp == null) {
				
				throw new IndexOutOfBoundsException();
			}
		}
		
		return tmp.data;
		
	}
	
	/**
	 * 	
	 * Remove the first element in the list
	 * 
	 */

	public int removeFirst() {

		int tmp = getFirst();

		head = head.next;

		return tmp;

	}
	
	
	/**
	 * Remove the node containing the key in the list
	 */
	
	public void remove(int key) {
		
		if (head == null) {
			
			throw new RuntimeException("Can not delete");
		}
		
		
		//if the key is equal to head.data
		if (head.data == key) {
			head = head.next;
			return;
			
		}
		
		Node cur = head;
		Node prev = null;
		
		while (cur != null && cur.data != key) {
			
			prev = cur;
			cur = cur.next;
		}
		
		if (cur == null) {
			throw new RuntimeException("Can not delete");			
		}
		
		//delete cur node
		prev.next = cur.next;
		
	}
	

	/**
	 * 	
	 * Remove all
	 */

	public void clear() {

		head = null;

	}
	
	
	/**
	 * 
	 * Reverses the list
	 */
	
	public LinkedList reverse() {
		
		LinkedList list = new LinkedList();
		Node tmp = head;
		
		while(tmp != null) {
			
			//stack the first element which will be the last element inside the new list
			list.addFirst(tmp.data);
			tmp = tmp.next;
		}
		
		return list;
	}



	public Node mergeTwoLists(Node l1, Node l2) {

		if(l1 == null) {

			return l2;
		}

		if(l2 == null) {

			return l1;
		}
		
		if(l1.data < l2.data)
		{
			l1.next = mergeTwoLists(l1.next, l2);

			return l1;

		} else {

			l2.next = mergeTwoLists(l1, l2.next);

			return l2;
		}

	}

	
	/**
	 * 
	 * Clone the list
	 */
	
	public LinkedList copy() {
		
		LinkedList twin = new LinkedList();
		Node tmp = head;
		
		while(tmp != null) {
			
			twin.addFirst(tmp.data);
			tmp = tmp.next;
		}
		
		return twin.reverse();
		
	}
	
	public LinkedList copy3() {
		
		if (head == null) {
			return null;
		}
		
		LinkedList twin = new LinkedList();
		
		Node tmp = head;
		twin.head = new Node (head.data, null);
		Node tmpTwin = twin.head;
		
		while (tmp.next != null) {
			
			tmp = tmp.next;
			tmpTwin.next = new Node (tmp.data, null);			
			tmpTwin = tmpTwin.next;
		}
		
		return twin;
	}
	
	public static void main(String args[]) {

		LinkedList list1 = new LinkedList();
		LinkedList list2 = new LinkedList();
		
		
		list1.addFirst(1);
		list1.addFirst(3);
		list1.addFirst(5);
		
		list2 = list1.reverse();
		
		Node tmp = list1.head;
		while (tmp != null) {
			System.out.print(tmp.data + " ");
			tmp = tmp.next;
		}
		System.out.println();
		System.out.println(list1.get(1));


	}

}
