package com.example.albertodoc.retrofitexample.Model;

public class User {
	private String name;
	private String username;
	private String email;

	public User(String name, String username, String email) {
		this.name = name;
		this.username = username;
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public String getBio() {
		return username;
	}

	public String getLocation() {
		return email;
	}

	@Override
	public String toString(){
		return "nome: " + this.name +
				"\nusuário: " + this.username +
				"\nemail: " + this.email;
	}
}
