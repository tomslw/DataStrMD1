package service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import model.Faculty;
import model.MyStack;
import model.Student;
import model.LintObject;

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
		
		System.out.println("Linting file 'Student.java':");
		fileLinter(new File("./DataStrMD1_javaFaili/Student.java"));
		
		System.out.println("Linting file 'UserController.java':");
		fileLinter(new File("./DataStrMD1_javaFaili/UserController.java"));
		
		System.out.println("Linting file 'UserServiceImplTest.java':");
		fileLinter(new File("./DataStrMD1_javaFaili/UserServiceImplTest.java"));
	}
	
	static void fileLinter(File file) {
		BufferedReader reader = null;
		MyStack<LintObject> charStack = new MyStack<LintObject>();
		int line = 0;
		boolean err = false;
		char topVal = '!';

		boolean slash = false;
		
		try {
		    reader = new BufferedReader(new FileReader(file));
		    String text = null;

		    while ((text = reader.readLine()) != null && err == false) {
		        // text is a line
		    	line++;
		    	for (char c : text.toCharArray()) {
		    		// System.out.print(c);
		    		
		    		if (!charStack.isEmpty())
		    			topVal = charStack.top().getValue().c;
		    		
		    		// SPAGETTI :DDDDDDDDDDDDDDDDDDDDDDDD
		    		if (c == '"' || c == '\'')  {// if the current char is ' or "
		    			if (topVal == c) { 	// if the previous stack value is the same
		    				if (!slash) {
		    					charStack.pop();
		    				} else {
		    					slash = false;
		    				}
		    			} else if (topVal != '"' && topVal != '\'') { // checking if not currently in a string or char
		    				charStack.push(new LintObject(c, line));
		    			}
		    		}
		    		
	    			slash = (c == '\\'); // accounting for the \' and \" possibilities
		    		
		    		if (!charStack.isEmpty())
		    			topVal = charStack.top().getValue().c;
		    		
		    		// if currently not inside a string
		    		if (topVal != '"' && topVal != '\'') {
	    				// bracket thing
			    		if (c == '{' || c == '(' || c == '[' || c == '<') {
			    			charStack.push(new LintObject(c, line));
			    		}
			    		else if (c == '}' || c == ')' || c == ']' || c == '>') {
			    			char equivlant = '!'; // random char to initialise it
			    			switch (c) {
			    			case '}':
			    				equivlant = '{';
			    				break;
			    			case ')':
			    				equivlant = '(';
			    				break;
			    			case ']':
			    				equivlant = '[';
			    				break;
			    			case '>':
			    				equivlant = '<';
			    				break;
			    			}
			    			if (topVal == equivlant) {
			    				charStack.pop();
			    			} else {
			    				System.out.println(String.format("Brackets at line %d and %d don't match!", charStack.top().getValue().line, line));
			    				err = true;
			    				break;
			    			}
			    			
			    		}
		    		}
		    	}
		    	// System.out.print('\n');
		    }
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		    try {
		        if (reader != null) {
		            reader.close();
		        }
		    } catch (Exception e) {
		    	e.printStackTrace();
		    }
		}
	}

}
