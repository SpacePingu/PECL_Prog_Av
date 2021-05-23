/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicaavanzada;

import interfaz.interfazCliente;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;


/**
 *
 * @author fersa
 */
public class ServidorSockets extends Thread{

    private ServerSocket servidor;
    private Socket conexion;
    private ObjectOutputStream salida;
    private DataInputStream entrada;
    private Hospital h;

    public ServidorSockets(Hospital h) throws RemoteException  {
        this.h = h;

    }

    public void run() {
        try {
            servidor = new ServerSocket(5000); //Creamos un ServerSocket en el Puerto 5000
            System.out.println("Servidor Arrancado....");
            ArrayList<String> s = new ArrayList<String>();

            while (true) {

                conexion = servidor.accept(); //Esperamos una conexión
                s.clear();
                System.out.println("Conexion establecida");
                //Abrimos los canales de E/S
                entrada = new DataInputStream(conexion.getInputStream());

                salida = new ObjectOutputStream(conexion.getOutputStream());
                //Paquete a enviar
                s.add(h.getColaEspera().getText()); //0
                s.add(h.getAux1().getText());       //1
                s.add(h.getAux2().getText());       //2
                s.add(h.getSalaDescanso().getText());//3
                System.out.println(s);
                salida.writeObject(s);
                

                System.out.println("Mandando datos");

                int a = entrada.readInt();

                switch (a) {
//                    case 0:
//
//                        //textos a exportar
//                        break;
                    case 1:

                        System.out.println("Sala de vacunacion cerrada: " + a);
                        h.getPuestosVacunaciones().get(0).setAbierto(false);
                        h.getPuestosVacunaciones().get(0).despertar();
                        h.meterLog("Sala Vacunacion " + a + " cerrada");

                        break;
                    case 2:

                        System.out.println("Sala de vacunacion cerrada: " + a);
                        h.getPuestosVacunaciones().get(1).setAbierto(false);
                        h.getPuestosVacunaciones().get(1).despertar();
                        h.meterLog("Sala Vacunacion " + a + " cerrada");
                        break;
                    case 3:

                        System.out.println("Sala de vacunacion cerrada: " + a);
                        h.getPuestosVacunaciones().get(2).setAbierto(false);
                        h.getPuestosVacunaciones().get(2).despertar();
                        h.meterLog("Sala Vacunacion " + a + " cerrada");
                        break;
                    case 4:

                        System.out.println("Sala de vacunacion cerrada: " + a);
                        h.getPuestosVacunaciones().get(3).setAbierto(false);
                        h.getPuestosVacunaciones().get(3).despertar();
                        h.meterLog("Sala Vacunacion " + a + " cerrada");
                        break;
                    case 5:

                        System.out.println("Sala de vacunacion cerrada: " + a);
                        h.getPuestosVacunaciones().get(4).setAbierto(false);
                        h.getPuestosVacunaciones().get(4).despertar();
                        break;
                    case 6:

                        System.out.println("Sala de vacunacion cerrada: " + a);
                        h.getPuestosVacunaciones().get(5).setAbierto(false);
                        h.getPuestosVacunaciones().get(5).despertar();
                        h.meterLog("Sala Vacunacion " + a + " cerrada");
                        break;
                    case 7:

                        System.out.println("Sala de vacunacion cerrada: " + a);
                        h.getPuestosVacunaciones().get(6).setAbierto(false);
                        h.getPuestosVacunaciones().get(6).despertar();
                        h.meterLog("Sala Vacunacion " + a + " cerrada");
                        break;
                    case 8:

                        System.out.println("Sala de vacunacion cerrada: " + a);
                        h.getPuestosVacunaciones().get(7).setAbierto(false);
                        h.getPuestosVacunaciones().get(7).despertar();
                        h.meterLog("Sala Vacunacion " + a + " cerrada");
                        break;
                    case 9:

                        System.out.println("Sala de vacunacion cerrada: " + a);
                        h.getPuestosVacunaciones().get(8).setAbierto(false);
                        h.getPuestosVacunaciones().get(8).despertar();
                        h.meterLog("Sala Vacunacion " + a + " cerrada");
                        
                        break;
                    case 10:

                        System.out.println("Sala de vacunacion cerrada: " + a);
                        h.getPuestosVacunaciones().get(9).setAbierto(false);
                        h.getPuestosVacunaciones().get(9).despertar();
                        h.meterLog("Sala Vacunacion " + a + " cerrada");
                        break;

                }

                entrada.close();
                conexion.close();
                salida.close();

            }
        } catch (IOException e) {
        }
    }
    
    
    public Hospital getH(){
        return this.h;
    }

    

}
