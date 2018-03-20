package stack;

import java.util.Arrays;

public class Stack {
	
	private int[] data;
	/////stack initial is empty so should be -1
	private int top = -1;
	//////////////////////////
	
	public Stack(int length) {
		
		data = new int[length];
	}
	
	public void push(int element) {
		if (top < this.data.length - 1) {
			top++;
			this.data[top] = element;
		}
	}
	////////////////////////////
	public int pop() {
		if (top > 0) {
			
			return data[top];
		}
		else {
			return -1;
		}
		
	}
	
	public int peek() {
		return data[top];
	}
	
	public boolean isEmpty() {
		return top == -1;
	}
	
	public boolean isFull() {
		return top == data.length -1;
	}
	
	public int size() {
		return top + 1;
	}
	
	public static void main(String[] args) {
		
		Stack s = new Stack(3);
		s.push(2);
		s.push(10);
		
		System.out.println(Arrays.toString(s.data));
		System.out.println(s.pop());
		System.out.print(s.peek());
	}

}
