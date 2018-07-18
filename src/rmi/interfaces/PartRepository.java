package rmi.interfaces;

import java.rmi.RemoteException;

public interface PartRepository extends Part {

	Part pecas (Part value) throws RemoteException;
}
