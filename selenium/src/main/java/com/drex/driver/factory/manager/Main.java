package com.drex.driver.factory.manager;

class Foo {
	static {
		System.out.println("Foo initializing");
	}
}

public class Main {
	public static void main(String[] args) throws Exception {
		Class.forName("Foo");
	}
}