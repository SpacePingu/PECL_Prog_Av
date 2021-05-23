/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;
import java.rmi.Remote;
import java.rmi.RemoteException;
import practicaavanzada.Hospital;

/**
 *
 * @author fersa
 */
public interface interfazCliente  extends Remote{
    Hospital getH() throws RemoteException;
}
