package com.luoxc.pojo;

import java.util.Date;

public class Commodity {
	private int Id;
    private String Name;
    private double Price;
    private int inventory;
    private Date date;


	public Commodity(int id, String name, double price, int inventory, Date date) {
		super();
		Id = id;
		Name = name;
		Price = price;
		this.inventory = inventory;
		this.date = date;
	}

	


	public Commodity() {
		super();
		// TODO Auto-generated constructor stub
	}




	public  Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}

	
	@Override
	public String toString() {
		return "Commodity [Id=" + Id + ", Name=" + Name + ", Price=" + Price + ", inventory=" + inventory + ", date="
				+ date + "]";
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
	public double getPrice() {
		return Price;
	}
	public void setPrice(double price) {
		Price = price;
	}
	public int getInventory() {
		return inventory;
	}
	public void setInventory(int inventory) {
		this.inventory = inventory;
	}
	public Commodity equalsGoods(int nextInt) {
		// TODO Auto-generated method stub
		return null;
	}
}



