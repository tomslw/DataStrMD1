package service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Random;

import model.CallObject;
import model.Faculty;
import model.MyStack;
import model.Student;
import model.LintObject;
import model.MyDeque;
import model.MyQueue;

public class MainService {

	public static void main(String[] args) {
		
		// uzdevums1();

		// uzdevums2();
		
		uzdevums3();
		
	}
	
	static void uzdevums1() {
		// Uzdevums 1
		
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
		System.out.println();
		System.out.println();
		
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
	
	static void uzdevums2() {
		MyQueue<Integer> intQueue = new MyQueue<Integer>();
		MyQueue<Student> studQueue = new MyQueue<Student>();
		
		// Numeric type
		System.out.println("Numeric type Queue:");
		System.out.println("Executing .enqueue() functions");
		intQueue.enqueue(1);
		intQueue.enqueue(2);
		intQueue.enqueue(3);
		System.out.println("Executing .print() function");
		intQueue.print();
		System.out.println("Executing .isEmpty() function");
		System.out.println(intQueue.isEmpty());
		System.out.println("Executing .getLength() function");
		System.out.println(intQueue.getLength());
		System.out.println("Executing .dequeue() function, then print()");
		System.out.println(intQueue.dequeue());
		intQueue.print();
		System.out.println("Executing .empty() function, then getLength(), then isEmpty(), then print()");
		intQueue.empty();
		System.out.println(intQueue.getLength());
		System.out.println(intQueue.isEmpty());
		intQueue.print();
		System.out.println();

		// Students type
		System.out.println("Student type Queue:");
		System.out.println("Executing .enqueue() functions");
		studQueue.enqueue(new Student("Janis", "Berzins", Faculty.EPF));
		studQueue.enqueue(new Student("Kristaps", "Miezitis", Faculty.ITF));
		studQueue.enqueue(new Student("Maigonis", "Baigais", Faculty.TSF));
		System.out.println("Executing .print() function");
		studQueue.print();
		System.out.println("Executing .isEmpty() function");
		System.out.println(studQueue.isEmpty());
		System.out.println("Executing .getLength() function");
		System.out.println(studQueue.getLength());
		System.out.println("Executing .dequeue() function, then print()");
		System.out.println(studQueue.dequeue());
		studQueue.print();
		System.out.println("Executing .empty() function, then getLength(), then isEmpty(), then print()");
		studQueue.empty();
		System.out.println(studQueue.getLength());
		System.out.println(studQueue.isEmpty());
		studQueue.print();
		System.out.println();
		
	
		ambulanceBuisness();
		
	}
	
	static int genRandInt(int lower, int upper) {
		Random r = new Random();
		return r.nextInt((upper - lower) + 1) + lower;
	}
	
	static int genPhone() {
		return genRandInt(20000000, 29999999);
	}
	
	private static MyQueue<CallObject> callQueue = new MyQueue<CallObject>();
	
	static void ambulanceBuisness() {
		
		// The simulation will run for ~2 minutes or more precisely 150 seconds
		// i wonder if ill have async problems
		System.out.println("Call center simulation starting!");
		new Thread(() -> {
			generatingCalls(10, 3000, 10000);
		}).start();
		
		new Thread(() -> {
			takingCalls(5000, 15000, 150000);
		}).start();
		
	}
	
	static void generatingCalls(int amount, int minInterval, int maxInterval) {
		for (int i = 0; i < amount; i++) {
			try {
				Thread.sleep(genRandInt(minInterval, maxInterval));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			CallObject newCaller = new CallObject(String.format("+371 %d", genPhone()));
			System.out.println( String.format("Queueing caller (%d): %s", callQueue.getLength()+1, newCaller.toString()));
			callQueue.enqueue(newCaller);
		}
	}
	
	static void takingCalls(int minDurr, int maxDurr, int onlineMillis) {
		Date date = new Date();
		while(new Date().getTime() - date.getTime() < onlineMillis) { // replace with specified time interval
			try {
				Thread.sleep(genRandInt(minDurr, maxDurr));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (!callQueue.isEmpty())
				System.out.println(String.format("Dequeueing call: %s", callQueue.dequeue().toString()));
		}
	}
	
	static void uzdevums3() {
		
		MyDeque<Integer> intQueue = new MyDeque<Integer>();
		MyDeque<Student> studQueue = new MyDeque<Student>();
		
		// Numeric type
		System.out.println("Numeric type Queue:");
		System.out.println("Executing .enqueueAtFront() functions");
		intQueue.enqueueAtFront(1);
		intQueue.enqueueAtFront(2);
		intQueue.enqueueAtFront(3);
		System.out.println("Executing .print() function");
		intQueue.print();
		System.out.println("Executing .enqueueAtEnd() functions");
		intQueue.enqueueAtEnd(1);
		intQueue.enqueueAtEnd(2);
		intQueue.enqueueAtEnd(3);
		System.out.println("Executing .print() function");
		intQueue.print();
		System.out.println("Executing .isEmpty() function");
		System.out.println(intQueue.isEmpty());
		System.out.println("Executing .getLength() function");
		System.out.println(intQueue.getLength());
		System.out.println("Executing .dequeueFromFront() function, then print()");
		System.out.println(intQueue.dequeueFromFront());
		intQueue.print();
		System.out.println("Executing .dequeueFromEnd() function, then print()");
		System.out.println(intQueue.dequeueFromEnd());
		intQueue.print();
		System.out.println("Executing .empty() function, then getLength(), then isEmpty(), then print()");
		intQueue.empty();
		System.out.println(intQueue.getLength());
		System.out.println(intQueue.isEmpty());
		intQueue.print();
		System.out.println();

		// Students type
		System.out.println("Student type Queue:");
		System.out.println("Executing .enqueueAtFront() functions");
		studQueue.enqueueAtFront(new Student("Janis", "Berzins", Faculty.EPF));
		studQueue.enqueueAtFront(new Student("Kristaps", "Miezitis", Faculty.ITF));
		studQueue.enqueueAtFront(new Student("Maigonis", "Baigais", Faculty.TSF));
		System.out.println("Executing .print() function");
		studQueue.print();
		System.out.println("Executing .enqueueAtEnd() functions");
		studQueue.enqueueAtEnd(new Student("Janis", "Berzins", Faculty.EPF));
		studQueue.enqueueAtEnd(new Student("Kristaps", "Miezitis", Faculty.ITF));
		studQueue.enqueueAtEnd(new Student("Maigonis", "Baigais", Faculty.TSF));
		System.out.println("Executing .print() function");
		studQueue.print();
		System.out.println("Executing .isEmpty() function");
		System.out.println(studQueue.isEmpty());
		System.out.println("Executing .getLength() function");
		System.out.println(studQueue.getLength());
		System.out.println("Executing .dequeueFromFront() function, then print()");
		System.out.println(studQueue.dequeueFromFront());
		studQueue.print();
		System.out.println("Executing .dequeueFromEnd() function, then print()");
		System.out.println(studQueue.dequeueFromEnd());
		studQueue.print();
		System.out.println("Executing .empty() function, then getLength(), then isEmpty(), then print()");
		studQueue.empty();
		System.out.println(studQueue.getLength());
		System.out.println(studQueue.isEmpty());
		studQueue.print();
		System.out.println();
		
		browsingHistorySimulation();
		
	}
	
	
	
	static void browsingHistorySimulation() {
		System.out.println("Starting 'Browsing history manager'");
		
		int maxSize = 10;
		
		MyDeque<String> history = new MyDeque<String>();
		
		boolean continueProgram = true;
		
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = "";
		
		while (continueProgram) {
			System.out.println(String.format("Current Browsing history (Max %d):", maxSize));
			if (history.isEmpty())
				System.out.println("No entries found!");
			else
				history.print();
			System.out.println();
			
			System.out.println("Enter URL to add to history or '1' to view and delete the latest entry or '0' to end: ");
			
			try {
				line = reader.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			// https://stackoverflow.com/questions/3809401/what-is-a-good-regular-expression-to-match-a-url
			if (line.matches("[-a-zA-Z0-9@:%._\\+~#=]{1,256}\\.[a-zA-Z0-9()]{1,6}\\b([-a-zA-Z0-9()@:%_\\+.~#?&//=]*)")) {
				if (history.getLength() >= maxSize) {
					System.out.println("History full! Deleting last entry and adding new one.");
					history.dequeueFromEnd();
					history.enqueueAtFront(line);
				} else {
					System.out.println("Adding entry.");
					history.enqueueAtFront(line);
				}
				
			} else if (line.equals("1")) {
				if (history.isEmpty())
					System.out.println("No entries to be deleted!");
				else
					System.out.println("Deleted entry: " + history.dequeueFromFront());
			} else if (line.equals("0")) {
				System.out.println("Ending program!");
				continueProgram = false;
			}
			System.out.println();
		}
		
		
	}

}
