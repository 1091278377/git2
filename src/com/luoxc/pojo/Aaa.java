package com.luoxc.pojo;

public class Aaa {
	private int Id;
	private String Name;
	private String Password;
	private String type;

	@Override
	public String toString() {
		return "Aaa [Id=" + Id + ", Name=" + Name + ", Password=" + Password + ", type=" + type + "]";
	}

	public Aaa() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Aaa(int id, String name, String password, String type) {
		super();
		Id = id;
		Name = name;
		Password = password;
		this.type = type;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getAaaCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void setAaaCount(int count) {
		// TODO Auto-generated method stub
		
	}

}
