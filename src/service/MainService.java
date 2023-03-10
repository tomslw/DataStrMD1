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
		intStack.push(1);
		intStack.push(2);
		intStack.push(3);
		intStack.print();
		System.out.println();

		// Students type
		System.out.println("Student type Stack:");
		studStack.push(new Student("Janis", "Berzins", Faculty.EPF));
		studStack.push(new Student("Kristaps", "Miezitis", Faculty.ITF));
		studStack.push(new Student("Maigonis", "Baigais", Faculty.TSF));
		studStack.print();
	}

}
