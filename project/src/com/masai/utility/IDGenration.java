package com.masai.utility;

public class IDGenration {
	public static int generateId() {
		return (int) (Math.random() * 1000000);
	}
}
