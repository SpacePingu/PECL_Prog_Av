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
public class ServidorSockets extends Thread {

    private ServerSocket servidor1, servidor2;
    private Socket conexion, conexion2;
    private ObjectOutputStream salida;
    private DataInputStream entrada, entrada1;
    private Hospital h;
    private int id;

    public ServidorSockets(Hospital h, int id) throws RemoteException {
        this.h = h;
        this.id = id;

    }

    public void run() {
        try {
           
        
            System.out.println("Servidor Arrancado....");
       
            if (this.id == 0) {
                 servidor1 = new ServerSocket(5000); //Creamos un ServerSocket en el Puerto 5000
                while (true) {

                    conexion = servidor1.accept(); //Esperamos una conexión
                
                    System.out.println("Conexion establecida");
                    //Abrimos los canales de E/S
                    entrada = new DataInputStream(conexion.getInputStream());

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

                }
            }

            if (this.id == 1) {
                     ArrayList<String> s = new ArrayList<String>();
                     
                    servidor2 = new ServerSocket(5001); //Creamos un ServerSocket en el Puerto 5001
                while (true) {
                    
                        s.clear();
                    conexion2 = servidor2.accept(); //Esperamos una conexión
                   
                    salida = new ObjectOutputStream(conexion2.getOutputStream());
                    //Paquete a enviar
                    //Recepcion
                    s.add(h.getColaEspera().getText()); //0
                    s.add(h.getAux1().getText());       //1
                    s.add(h.getPacienteAtendiendo().getText()); //2
                    //Descanso
                    s.add(h.getSalaDescanso().getText());//3
                    //Vacunacion
                     s.add(h.getAux2().getText());       //4
                     s.add(h.getVacunasDisp().getText()); //5
                     s.add(h.getPuestosVacunaciones().get(0).getTexto().getText()); //6
                     s.add(h.getPuestosVacunaciones().get(1).getTexto().getText()); //7
                     s.add(h.getPuestosVacunaciones().get(2).getTexto().getText()); //8
                     s.add(h.getPuestosVacunaciones().get(3).getTexto().getText()); //9
                     s.add(h.getPuestosVacunaciones().get(4).getTexto().getText()); //10
                     s.add(h.getPuestosVacunaciones().get(5).getTexto().getText()); //11
                     s.add(h.getPuestosVacunaciones().get(6).getTexto().getText()); //12
                     s.add(h.getPuestosVacunaciones().get(7).getTexto().getText()); //13
                     s.add(h.getPuestosVacunaciones().get(8).getTexto().getText()); //14
                     s.add(h.getPuestosVacunaciones().get(9).getTexto().getText()); //15
                    //Observacion
                    s.add(h.getPuestosObservacion().get(0).getTexto().getText()); //16
                    s.add(h.getPuestosObservacion().get(1).getTexto().getText()); //17
                    s.add(h.getPuestosObservacion().get(2).getTexto().getText()); //18
                    s.add(h.getPuestosObservacion().get(3).getTexto().getText()); //19
                    s.add(h.getPuestosObservacion().get(4).getTexto().getText()); //20
                    s.add(h.getPuestosObservacion().get(5).getTexto().getText()); //21
                    s.add(h.getPuestosObservacion().get(6).getTexto().getText()); //22
                    s.add(h.getPuestosObservacion().get(7).getTexto().getText()); //23
                    s.add(h.getPuestosObservacion().get(8).getTexto().getText()); //24
                    s.add(h.getPuestosObservacion().get(9).getTexto().getText()); //25
                    s.add(h.getPuestosObservacion().get(10).getTexto().getText()); //26
                    s.add(h.getPuestosObservacion().get(11).getTexto().getText()); //27
                    s.add(h.getPuestosObservacion().get(12).getTexto().getText()); //28
                    s.add(h.getPuestosObservacion().get(13).getTexto().getText()); //29
                    s.add(h.getPuestosObservacion().get(14).getTexto().getText()); //30
                    s.add(h.getPuestosObservacion().get(15).getTexto().getText()); //31
                    s.add(h.getPuestosObservacion().get(16).getTexto().getText()); //32
                    s.add(h.getPuestosObservacion().get(17).getTexto().getText()); //33
                    s.add(h.getPuestosObservacion().get(18).getTexto().getText()); //34
                    s.add(h.getPuestosObservacion().get(19).getTexto().getText()); //35
                    salida.writeObject(s);

                  
                    
                    
                    salida.close();
                    conexion2.close();

                }

            }
        } catch (IOException e) {
        }
    }

    

}
