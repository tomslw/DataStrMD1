package service;

import model.Faculty;
import model.MyStack;
import model.Student;

public class MainService {

	public static void main(String[] args) {
		MyStack<Integer> intStack = new MyStack<Integer>();
		MyStack<Student> studStack = new MyStack<Student>();
		
		// Numeric type
		System.out.println("Numeric type Stack:");
		System.out.println("Executing .push() functions");
		intStack.push(1);
		intStack.push(2);
		intStack.push(3);
		System.out.println("Executing .print() function");
		intStack.print();
		System.out.println("Executing .isEmpty() function");
		System.out.println(intStack.isEmpty());
		System.out.println("Executing .getLength() function");
		System.out.println(intStack.getLength());
		System.out.println("Executing .pop() function, then print()");
		intStack.pop();
		intStack.print();
		System.out.println("Executing .top() function");
		System.out.println(intStack.top());
		System.out.println("Executing .empty() function, then getLength(), then isEmpty(), then print()");
		intStack.empty();
		System.out.println(intStack.getLength());
		System.out.println(intStack.isEmpty());
		intStack.print();
		System.out.println();

		// Students type
		System.out.println("Student type Stack:");
		System.out.println("Executing .push() functions");
		studStack.push(new Student("Janis", "Berzins", Faculty.EPF));
		studStack.push(new Student("Kristaps", "Miezitis", Faculty.ITF));
		studStack.push(new Student("Maigonis", "Baigais", Faculty.TSF));
		System.out.println("Executing .print() function");
		studStack.print();
		System.out.println("Executing .isEmpty() function");
		System.out.println(studStack.isEmpty());
		System.out.println("Executing .getLength() function");
		System.out.println(studStack.getLength());
		System.out.println("Executing .pop() function, then print()");
		studStack.pop();
		studStack.print();
		System.out.println("Executing .top() function");
		System.out.println(studStack.top());
		System.out.println("Executing .empty() function, then getLength(), then isEmpty(), then print()");
		studStack.empty();
		System.out.println(studStack.getLength());
		System.out.println(studStack.isEmpty());
		studStack.print();
		System.out.println();
	}

}
