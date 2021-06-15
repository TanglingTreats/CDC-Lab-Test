package com.lab.test;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class ReviewServer {

	private static String rmi_base = "rmi://%s:%d%s";
	private static String rmi_endpoint  = "/RestaurantReview";
	private static String reg_host = "localhost";
	private static int reg_port = 1099;
	
	public ReviewServer() {
			try {
				System.out.println("Starting up server");
				
				LocateRegistry.createRegistry(reg_port);
				
				RestaurantReviewIntf intf = new RestaurantReviewImpl();
				Naming.rebind(String.format(rmi_base, reg_host, reg_port, rmi_endpoint), intf);

			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	public static void main(String[] args) {
		
		if (args.length == 1)
			reg_port = Integer.parseInt(args[0]);
		
		new ReviewServer();
	}
}
