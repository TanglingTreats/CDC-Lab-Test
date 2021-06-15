package com.lab.test;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ReviewClientIntf extends Remote {
	public void callback(String input) throws RemoteException;

}
