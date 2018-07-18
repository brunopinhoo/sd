package rmi.servidor;

import rmi.interfaces.Part;
import java.rmi.RemoteException;

public class PartImpl implements Part {

    private final int part = 35;
    public int codigo = 0;
/*
    @Override
    public String process(String value) throws RemoteException {
        int num;
        String strRetorno = "O código gerado é: ";
        
        try {
            num = Integer.parseInt(value);
            strRetorno += String.valueOf(codigoPeca(codigo));
        } catch (Exception c) {
            return "Digite o nome da peça:";
        }
        return strRetorno;
    }*/

	public int codigoPeca(int value) throws RemoteException {
		codigo++;
		return codigo;
	}

	public String nomePeca(String value) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public Long descricaoPeca(Long value) throws RemoteException {
		return null;
	}

	public String[] listaComponentesPeca(String[] value) throws RemoteException {
		return null;
	}

}