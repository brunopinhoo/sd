package rmi.servidor;

import rmi.interfaces.Part;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class ServerMain {
    
    public static void main(String [] args) throws RemoteException {
        Registry registry = LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
        
        PartImpl partImpl = new PartImpl();
        
        Part Part = (Part) UnicastRemoteObject.exportObject(partImpl, 0);
        
        registry.rebind("part", Part);
        
        System.out.println("Servidor iniciado.");
    }
}
