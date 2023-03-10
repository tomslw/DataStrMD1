package model;

public class Student {
	private static long idCounter = 10000;
	
	private long st_ID;
	private String name;
	private String surname;
	private Faculty faculty;
	
	
	public Student() {
		st_ID = 0;
		name = "";
		surname = "";
		faculty = Faculty.EPF;
	}

	public Student(String name, String surname, Faculty faculty) {
		if (!name.matches("[a-zA-Z]+"))
			throw new IllegalArgumentException("Invalid name, only letters!");
		if (!surname.matches("[a-zA-Z]+"))
			throw new IllegalArgumentException("Invalid surname, only letters!");
		
		this.st_ID = idCounter++;
		this.name = name;
		this.surname = surname;
		this.faculty = faculty;
	}

	public long getSt_ID() {
		return st_ID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (!name.matches("[a-zA-Z]+"))
			throw new IllegalArgumentException("Invalid name, only letters!");
		
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		if (!surname.matches("[a-zA-Z]+"))
			throw new IllegalArgumentException("Invalid surname, only letters!");
		
		this.surname = surname;
	}
	
	public Faculty getFaculty() {
		return faculty;
	}

	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}

	@Override
	public String toString() {
		return "Student [st_ID=" + st_ID + ", name=" + name + ", surname=" + surname + ", faculty=" + faculty + "]";
	}
	
	

	
}
