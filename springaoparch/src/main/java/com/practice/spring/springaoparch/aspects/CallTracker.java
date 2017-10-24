package com.practice.spring.springaoparch.aspects;

public class CallTracker {
	
	private boolean call;
	
	public boolean called() {
		return call;
	}
	
	public void resetCall() {
		call = false;
	}
	
	protected void trackCall() {
		call = true;
	}
}
