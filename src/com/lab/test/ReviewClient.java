package com.lab.test;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

public class ReviewClient extends UnicastRemoteObject implements ReviewClientIntf {
	private static String rmi_base = "rmi://%s:%d%s";
	private static String rmi_endpoint  = "/RestaurantReview";
	private static String reg_host = "localhost";
	private static int reg_port = 1099;

	private static Scanner scanner = new Scanner(System.in);

	protected ReviewClient() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void callback(String input) throws RemoteException {
		System.out.println(input);
	}
	
	public static void main(String[] args) {

		if (args.length == 1) 
			reg_port = Integer.parseInt(args[0]);
		
		else if (args.length == 2) {
			reg_host = args[0];
			reg_port = Integer.parseInt(args[1]);
		}

		
		try {
			RestaurantReviewIntf intf = (RestaurantReviewIntf) Naming.lookup(String.format(rmi_base, reg_host, reg_port, rmi_endpoint));
			
			ReviewClient client = new ReviewClient();
			client.welcomeMessage();
			
			client.printOptions();
			int option = Integer.parseInt(scanner.nextLine());
			
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void welcomeMessage() {
		System.out.println("~~~ Hi, this is a restaurant review application!~~~");
	}
	
	private void exitSystem() {
		System.exit(0);
	}
	
	private void printOptions() {
		System.out.println("What would you like to do?");
		System.out.println("1) Write a new review");
		System.out.println("2) Retrieve a list of reviews");
	}
}
