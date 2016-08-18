package test;

import java.util.HashMap;

import java.util.Map;

public class ItemsCart {
	Map<Integer,ItemsCart> products=new HashMap<Integer,ItemsCart>(); 
	public String pname;
	public int pid;
	public int cost;
	public String color;
	public ItemsCart(String pname,int pid, int cost, String color) {
		super();
		this.pname = pname;
		this.pid=pid;
		this.cost = cost;
		this.color = color;
	}
	
	public void addP(Integer n,ItemsCart ic){
	products.put(n, ic);
	}

	public ItemsCart() {
		super();
	}
	
}
