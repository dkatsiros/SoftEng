package test;

import java.util.Arrays;

public class Messageout {
	private String message;
	
	public String getmessage() {
		return message;
	}
	public Messageout (Message message) {
		this.message = message.getmessage();
	}
}
