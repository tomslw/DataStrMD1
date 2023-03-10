package model;

import java.time.LocalDateTime;

public class CallObject {
	String number;
	LocalDateTime recivedTime;
	
	public CallObject(String number) {
		this.number = number;
		recivedTime = LocalDateTime.now();
	}
	
	public String getNumber() {
		return number;
	}
	public LocalDateTime getRecivedTime() {
		return recivedTime;
	}
	
	
	
}
