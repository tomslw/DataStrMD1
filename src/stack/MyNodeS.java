package stack;

public class MyNodeS<T> {
	T value;
	MyNodeS<T> next;
	MyNodeS<T> prev;
	
	MyNodeS(T value, MyNodeS<T> prev, MyNodeS<T> next){
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

	public MyNodeS<T> getNext() {
		return next;
	}

	public void setNext(MyNodeS<T> next) {
		this.next = next;
	}

	public MyNodeS<T> getPrev() {
		return prev;
	}

	public void setPrev(MyNodeS<T> prev) {
		this.prev = prev;
	}

	@Override // this might get interesting; TODO: check if printing one prints them all
	public String toString() {
		return "MyNodeS [value=" + value + ", next=" + next + ", prev=" + prev + "]";
	}
	
	
}
