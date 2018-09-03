package com.skillnet.model;

public class Persona {

	private String name;
	private int age;

	public String getName() {
		return name;
	}

	public void setName(String name) {//gvhgfh
		this.name = name;
	}

	public int getAge() {     
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	// constructor
	public Persona(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public Persona() {
}
}
