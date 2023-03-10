package model;

public class MyStack<T> {
	MyNodeS<T> topNode;
	int length;
	
	public MyStack() {
		topNode = null;
		length = 0;
	}
	
	public boolean isEmpty() {
		return length == 0;
	}
	
	public int getLength() {
		return length;
	}
	
	public void push(T data) {
		// TODO: check if full, 
		// the only way to do this is to check allocated memory to the program i guess? won't bother for now
		length++;
		
		MyNodeS<T> newNode = new MyNodeS<T>(data, topNode, null);
		
		if (topNode != null)
			topNode.setNext(newNode);
		
		topNode = newNode;
	}
	
	public void pop() {
		if (isEmpty())
			throw new NullPointerException("Stack is empty!"); // or do i just return?
		
		topNode = topNode.prev;
		topNode.next = null;
		length--;
	}
	
	public MyNodeS<T> top() {
		if (isEmpty())
			throw new NullPointerException("Stack is empty!"); // or do i just return null?
		
		return topNode;
	}
	
	public void print() {
		MyNodeS<T> curr = topNode;
		int locLength = length;
		
		while (curr != null) {
			System.out.println(String.format("%d: %s", locLength--, curr.toString()));
			curr = curr.prev;
		}
	}
	
	public void empty() {
		length = 0;
		topNode = null;
	}
	
}
