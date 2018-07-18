package rmi.servidor;

import rmi.interfaces.Part;
import rmi.interfaces.PartRepository;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

public class ServerMain {
    
    public static void main(String [] args) throws RemoteException {
    	
    	System.out.println("Digite o nome desejado para o servidor: ");
        Scanner input =  new Scanner(System.in);
        
        String nomeServidor = input.nextLine();
    	
        //IMPLEMENTANDO PART
        Registry registryPart = LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
        PartImpl partImpl = new PartImpl();
        Part Part = (Part) UnicastRemoteObject.exportObject(partImpl, 0);
        registryPart.rebind(nomeServidor, Part);
        
        //IMPLEMENTANDO PART REPOSITORY
        Registry registryPartRepository = LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
        PartRepositoryImpl partRepositoryImpl = new PartRepositoryImpl();
        PartRepository PartRepository = (PartRepository) UnicastRemoteObject.exportObject(partRepositoryImpl, 0);
        registryPartRepository.rebind(nomeServidor, PartRepository);
        
        System.out.println("Servidor "+nomeServidor+" iniciado.");
        
    }
}
