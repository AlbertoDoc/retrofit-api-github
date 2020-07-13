package com.example.albertodoc.retrofitexample.Model;

public class User {
	private String name;
	private String bio;
	private String location;

	public User(String name, String username, String location) {
		this.name = name;
		this.bio = username;
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
				"\nbiografia: " + this.bio +
				"\nlocalização: " + this.location;
	}
}
