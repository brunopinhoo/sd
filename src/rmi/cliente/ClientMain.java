package rmi.cliente;

import rmi.interfaces.Part;
import rmi.interfaces.PartRepository;
import rmi.servidor.PartImpl;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

public class ClientMain {
	
	private static PartRepository repositorioAtual;
	private static Part pecaAtual;
	private static String listaSubpecasAtual;

	public ClientMain() {
		ClientMain.listaSubpecasAtual = "";
	}
	
    public static void main(String[] args) throws RemoteException, NotBoundException {
        Registry registry = LocateRegistry.getRegistry("localhost", Registry.REGISTRY_PORT);    
        
        Part part = (Part) registry.lookup("part");
        
        Scanner input =  new Scanner(System.in);
        String comando = "";
        String comandoParam = "";
        
        Boolean parar = false;
        
        while (!parar) {
        	/*
        	 * bind: Faz o cliente se conectar a outro servidor e muda o repositório atual. Este comando recebe o nome de um repositório e obtém do serviço de nomes uma referência para esse repositório, que passa a ser o repositório atual.
        	 * listp: Lista as peças do repositório atual.
        	 * getp: Busca uma peça por código. A busca é efetuada no repositório atual. Se encontrada, a peça passa a ser a nova peça atual.
        	 * showp: Mostra atributos da peça atual.
        	 * clearlist: Esvazia a lista de subpeças atual.
        	 * addsubpart: Adiciona à lista de subpeças atual n unidades da peça atual.
        	 * addp: Adiciona uma peça ao repositório atual. A lista de subpeças atual é usada como lista de subcomponentes diretos da nova peça. (É só para isto que existe a lista de subpeças atual.)
        	 * quit: Encerra a execução do cliente
        	 */
        	
            System.out.println("Por favor insira o comando desejado:");
            comando = input.nextLine();
            
            if (comando.contains("bind")) {
                PartImpl partImpl = new PartImpl();
                Part Part = (Part) UnicastRemoteObject.exportObject(partImpl, 0);
            	comandoParam = comando.replace("bind", "").replaceAll("\\s+","");
                registry.rebind("comandoParam", Part);
            } else if (comando.contains("listp")) {
            	listp(repositorioAtual);
            } else if (comando.contains("getp")) {
            	comandoParam = comando.replace("getp", "").replaceAll("\\s+","");
            	getp(comandoParam, repositorioAtual);
            } else if (comando.contains("showp")) {
            	comandoParam = comando.replace("showp", "").replaceAll("\\s+","");
            	showp(comandoParam, pecaAtual);
            } else if (comando.contains("clearlist")) {
            	comandoParam = comando.replace("clearlist", "").replaceAll("\\s+","");
            	clearlist(comandoParam, listaSubpecasAtual);
            } else if (comando.contains("addsubpart")) {
            	comandoParam = comando.replace("addsubpart", "").replaceAll("\\s+","");
            	addsubpart(comandoParam, listaSubpecasAtual, pecaAtual);
            } else if (comando.contains("addp")) {
            	comandoParam = comando.replace("addp", "").replaceAll("\\s+","");
            	addp(comandoParam, repositorioAtual, listaSubpecasAtual);
            } else if (comando.contains("quit")) {
            	parar = true;
            	break;
            } else {
            	System.out.println("Comando inválido!");
            }
            
            /*
            String response = part.process(input.nextLine());
            System.out.println(response);*/
        }
    }

	private static void addp(String comandoParam, PartRepository repositorioAtual2, String listaSubpecasAtual) {
	}

	private static void addsubpart(String comandoParam, String listaSubpecasAtual, Part pecaAtual2) {
	}

	private static void clearlist(String comandoParam, String listaSubpecasAtual) {
	}

	private static void showp(String comandoParam, Part pecaAtual2) {
	}

	private static void getp(String comandoParam, PartRepository repositorioAtual2) {
	}

	private static void listp(PartRepository repositorioAtual2) {
	}

	private static void bind(String comandoParam) {
	}
}