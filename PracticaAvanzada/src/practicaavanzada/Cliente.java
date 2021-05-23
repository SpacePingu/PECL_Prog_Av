/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicaavanzada;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;

/**
 *
 * @author fersa
 */
public class Cliente extends Thread {

    //Conexion
    private Socket cliente;
    private ObjectInputStream entrada;
    private DataOutputStream salida;
    private ArrayList<String> s = new ArrayList<String>();
    //Recepcion
    private JTextArea colaEspera;

    public Cliente(JTextArea colaEspera) {
        this.colaEspera = colaEspera;
    }

    public void run() {
        

 
    }

}
