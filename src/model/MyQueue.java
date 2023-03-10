package model;

public class MyQueue <T> {
	MyNodeQ<T> frontNode;
	MyNodeQ<T> rearNode;
	int length;
	
	public MyQueue() {
		frontNode = null;
		rearNode = null;
		length = 0;
	}
	
	public boolean isEmpty() {
		return length == 0;
	}

	public int getLength() {
		return length;
	}
	
	public void enqueue(T value) {
		MyNodeQ<T> newNode = new MyNodeQ<T>(value, null, rearNode);
		
		if (isEmpty())
			frontNode = newNode;
		
		if(rearNode != null)
			rearNode.prev = newNode;
		rearNode = newNode;
		length++;
	}
	
	public T dequeue() {
		if (isEmpty())
			throw new NullPointerException("Stack is empty!");
		
		T value = frontNode.getValue();
		
		frontNode = frontNode.prev;
		
		if (frontNode != null)
			frontNode.next = null;
		
		length--;
		
		return value;
	}
	
	public void print() {
		MyNodeQ<T> curr = rearNode;
		int locLength = length;
		
		while (curr != null) {
			System.out.println(String.format("%d: %s", locLength--, curr.toString()));
			curr = curr.next;
		}
	}
	
	public void empty() {
		length = 0;
		rearNode = null;
		frontNode = null;
	}
	
	
}
