package stack;

public class MyStack<T> {
	MyNodeS<T> topNode;
	int length;
	
	MyStack() {
		topNode = null;
		length = 0;
	}
	
	boolean isEmpty() {
		return length == 0;
	}
	
	int getLength() {
		return length;
	}
	
	void push(T data) {
		// TODO: check if full, 
		// the only way to do this is to check allocated memory to the program i guess? won't bother for now
		length++;
		
		MyNodeS<T> newNode = new MyNodeS<T>(data, topNode, null);
		
		if (topNode != null)
			topNode.setNext(newNode);
		
		topNode = newNode;
	}
	
	void pop() {
		if (isEmpty())
			throw new NullPointerException("Stack is empty!"); // or do i just return?
		
		topNode = topNode.prev;
		topNode.next = null;
		length--;
	}
	
	MyNodeS<T> top() {
		if (isEmpty())
			throw new NullPointerException("Stack is empty!"); // or do i just return null?
		
		return topNode;
	}
	
	void print() {
		System.out.println(topNode);
	}
	
	void empty() {
		length = 0;
		topNode = null;
	}
	
}
