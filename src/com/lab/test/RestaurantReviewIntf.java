package com.lab.test;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface RestaurantReviewIntf extends Remote {

	public void submitReview(ReviewClientIntf client, String restaurantName, String review) throws RemoteException;
	public ArrayList<String> queryReview() throws RemoteException;
}
