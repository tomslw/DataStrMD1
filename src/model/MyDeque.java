package model;

public class MyDeque<T> {
	MyNodeD<T> frontNode;
	MyNodeD<T> rearNode;
	int length;
	
	public MyDeque() {
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
	
	public void enqueueAtFront(T value) {
		// TODO: check if full if that is possible
		MyNodeD<T> newNode = new MyNodeD<T>(value, null, frontNode);
		
		if (frontNode != null)
			frontNode.prev = newNode;
		else
			rearNode = newNode;
		
		frontNode = newNode;
		
		length++;
	}
	
	public T dequeueFromFront() {
		if (isEmpty())
			throw new NullPointerException("Deck is empty!");
		
		T returnVal = frontNode.value;
		
		frontNode = frontNode.next;
		
		if (frontNode != null)
			frontNode.prev = null;
			
		length--;
		return returnVal;
	}
	
	public void enqueueAtEnd(T value) {
		// TODO: check if full if that is possible
		MyNodeD<T> newNode = new MyNodeD<T>(value, rearNode, null);
		
		if (rearNode != null)
			rearNode.next = newNode;
		else
			frontNode = newNode;
		
		rearNode = newNode;
		
		length++;
	}
	
	public T dequeueFromEnd() {
		if (isEmpty())
			throw new NullPointerException("Deck is empty!");
		
		T returnVal = rearNode.value;
		
		rearNode = rearNode.prev;
		
		if (rearNode != null)
			rearNode.next = null;
			
		length--;
		return returnVal;
	}
	
	public void print() {
		MyNodeD<T> curr = rearNode;
		int locLength = length;
		
		while (curr != null) {
			System.out.println(String.format("%d: %s", locLength--, curr.toString()));
			curr = curr.prev;
		}
	}
	
	public void empty() {
		length = 0;
		frontNode = null;
		rearNode = null;
	}
	
}
