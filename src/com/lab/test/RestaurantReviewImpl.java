package com.lab.test;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class RestaurantReviewImpl extends UnicastRemoteObject implements RestaurantReviewIntf {
	
	private ArrayList<Restaurant> restaurants;
	private static Boolean isSubmitting = false;
	
	protected RestaurantReviewImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
		restaurants = new ArrayList<Restaurant>();
	}

	@Override
	public void submitReview(ReviewClientIntf client, String restaurantName, String review) throws RemoteException {

		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				synchronized(isSubmitting) {
					
					while(isSubmitting) {
						try {
							isSubmitting.wait();

						} catch(InterruptedException e ) {
							Thread.currentThread().interrupt();
							System.err.println("Thread interrupted: " + e);
						}
						
					}
				}
				
			}
		});
		thread.start();
		
	}
	
	@Override
	public ArrayList<String> queryReview() throws RemoteException {
		ArrayList<String> reviews = new ArrayList<String>();
		
		return reviews;
	}

}
