package rmi.servidor;

import rmi.interfaces.Part;
import rmi.interfaces.PartRepository;
import java.rmi.RemoteException;

public class PartRepositoryImpl implements PartRepository {

    public int codigo = 0;

	public int codigoPeca(int value) throws RemoteException {
		
		codigo++;
		return codigo;
	}

	public String nomePeca(String value) throws RemoteException {
		
		return null;
	}

	public Long descricaoPeca(Long value) throws RemoteException {
		
		return null;
	}

	public String[] listaComponentesPeca(String[] value) throws RemoteException {
		
		return null;
	}

	@Override
	public Part[] pecas(Part[] value) throws RemoteException {
		return null;
	}

}
