package rmi.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Part extends Remote {
	
    int codigoPeca (int value) throws RemoteException;
    
    String nomePeca (String value) throws RemoteException;
    
    Long descricaoPeca (Long value) throws RemoteException;
    
    String[] listaComponentesPeca (String[] value) throws RemoteException;
    
}