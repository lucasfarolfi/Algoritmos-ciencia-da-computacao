package org.example.spoletto.fluent.model;

import java.util.List;

public class Pasta {
	protected List<String> toppings;
	protected List<String> sauces;
	protected Size size;
	protected boolean cheese;
	protected boolean pepper;
	
	public Pasta(List<String> toppings, List<String> sauces, Size size, boolean cheese, boolean pepper) {
		this.toppings = toppings;
		this.sauces = sauces;
		this.size = size;
		this.cheese = cheese;
		this.pepper = pepper;
	}

	public List<String> getToppings() {
		return toppings;
	}

	public void setToppings(List<String> toppings) {
		this.toppings = toppings;
	}

	public List<String> getSauces() {
		return sauces;
	}

	public void setSauces(List<String> sauces) {
		this.sauces = sauces;
	}

	public Size getSize() {
		return size;
	}

	public void setSize(Size size) {
		this.size = size;
	}

	public boolean isCheese() {
		return cheese;
	}

	public void setCheese(boolean cheese) {
		this.cheese = cheese;
	}

	public boolean isPepper() {
		return pepper;
	}

	public void setPepper(boolean pepper) {
		this.pepper = pepper;
	}

	@Override
	public String toString() {
		return "Pasta [toppings=" + toppings + ", sauces=" + sauces + ", size=" + size + ", cheese=" + cheese
				+ ", pepper=" + pepper + "]";
	}
}
