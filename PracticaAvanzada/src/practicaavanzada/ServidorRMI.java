/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicaavanzada;

import interfaz.interfazCliente;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author fersa
 */
public class ServidorRMI extends UnicastRemoteObject implements interfazCliente{
    private Hospital h;
    public ServidorRMI(Hospital h) throws RemoteException {
        this.h=h;
    }

    public Hospital getH() throws RemoteException {
// Implementación del método remoto
        return h;
    }

}
