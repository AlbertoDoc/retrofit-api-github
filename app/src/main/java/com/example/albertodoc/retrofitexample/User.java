package com.example.albertodoc.retrofitexample;

public class User {
	private String name;
	private String bio;
	private String location;

	public User(String name, String description, String location) {
		this.name = name;
		this.bio = description;
		this.location = location;
	}

	public String getName() {
		return name;
	}

	public String getBio() {
		return bio;
	}

	public String getLocation() {
		return location;
	}

	@Override
	public String toString(){
		return "nome: " + this.name +
				"\ndescrição: " + this.bio +
				"\ncidade: " + this.location;
	}
}
