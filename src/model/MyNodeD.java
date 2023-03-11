package model;

public class MyNodeD<T> {
	T value;
	MyNodeD<T> next;
	MyNodeD<T> prev;
	
	MyNodeD(T value, MyNodeD<T> prev, MyNodeD<T> next){
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

	public MyNodeD<T> getNext() {
		return next;
	}

	public void setNext(MyNodeD<T> next) {
		this.next = next;
	}

	public MyNodeD<T> getPrev() {
		return prev;
	}

	public void setPrev(MyNodeD<T> prev) {
		this.prev = prev;
	}

	@Override
	public String toString() {
		return "MyNodeD [value=" + value + "]";
	}
	
	
}