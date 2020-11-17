package com.example.demo.dbapi.MyUser;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Myuser {
	
	@Id
	private int id;
	private String username;
	public int getId() {
		return id;
	}
	@Override
	public String toString() {
		return "Myuser [id=" + id + ", username=" + username + "]";
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public Myuser() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Myuser(int id, String username) {
		super();
		this.id = id;
		this.username = username;
	}

}
