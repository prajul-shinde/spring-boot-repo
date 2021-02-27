package com.example.jdbc4.jdbc4.DAOs;

public class Person {
//mapping java object to table
	private int id;
	private String name;
	private int age;
	private String address;

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", age=" + age + ", address=" + address + "]";
	}

	public Person(int id, String name, int age, String address) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.address = address;

	}

	public Person(String name2, int age2, String address2) {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
