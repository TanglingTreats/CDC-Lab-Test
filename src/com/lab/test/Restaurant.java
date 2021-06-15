package com.lab.test;

import java.util.ArrayList;

public class Restaurant {
	private String name;
	private ArrayList<String> reviews;
	
	public Restaurant(String name) {
		this.name = name;
		reviews = new ArrayList<String>();
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return this.name;
	}
	
	public void setReview(String review) {
		if(reviews != null) {
			reviews.add(review);
		}
	}

	public ArrayList<String> getReview() {
		return this.reviews;
	}
}
