package model;

public class MyNodeQ<T> {
	T value;
	MyNodeQ<T> next;
	MyNodeQ<T> prev;
	
	MyNodeQ(T value, MyNodeQ<T> prev, MyNodeQ<T> next){
		this.value = value;
		this.next = next;
		this.prev = prev;
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	public MyNodeQ<T> getNext() {
		return next;
	}

	public void setNext(MyNodeQ<T> next) {
		this.next = next;
	}

	public MyNodeQ<T> getPrev() {
		return prev;
	}

	public void setPrev(MyNodeQ<T> prev) {
		this.prev = prev;
	}

	@Override 
	public String toString() {
		return "MyNodeQ [value=" + value + "]";
	}
}
