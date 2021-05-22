/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicaavanzada;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fersa
 */
public class Servidor extends Thread {

    private ServerSocket servidor;
    private Socket conexion;
    private ObjectOutputStream salida;
    private DataInputStream entrada;

    private Hospital h;

    public Servidor(Hospital h) {
        this.h = h;

    }

    public void run() {
        try {
            servidor = new ServerSocket(5000); //Creamos un ServerSocket en el Puerto 5000
            System.out.println("Servidor Arrancado....");
            while (true) {
                conexion = servidor.accept(); //Esperamos una conexión
                System.out.println("Conexion establecida");
                entrada = new DataInputStream(conexion.getInputStream()); //Abrimos los canales de E/S
                salida = new ObjectOutputStream(conexion.getOutputStream());
                int a = entrada.readInt();
                System.out.println("Sala de vacunacion cerrada: " + a);
                switch (a) {
                    case 0:
                        salida.writeObject(h);
                        System.out.println("mandando datos");
                        
                    case 1:
                        h.getPuestosVacunaciones().get(0).setAbierto(false);
                        h.getPuestosVacunaciones().get(0).despertar();
                        
                        
                        break;
                    case 2:
                        h.getPuestosVacunaciones().get(1).setAbierto(false);
                        h.getPuestosVacunaciones().get(1).despertar();
                        break;
                    case 3:
                        h.getPuestosVacunaciones().get(2).setAbierto(false);
                        h.getPuestosVacunaciones().get(2).despertar();
                        break;
                    case 4:
                        h.getPuestosVacunaciones().get(3).setAbierto(false);
                        h.getPuestosVacunaciones().get(3).despertar();
                        break;
                    case 5:
                        h.getPuestosVacunaciones().get(4).setAbierto(false);
                        h.getPuestosVacunaciones().get(4).despertar();
                        break;
                    case 6:
                        h.getPuestosVacunaciones().get(5).setAbierto(false);
                        h.getPuestosVacunaciones().get(5).despertar();
                        break;
                    case 7:
                        h.getPuestosVacunaciones().get(6).setAbierto(false);
                        h.getPuestosVacunaciones().get(6).despertar();
                        break;
                    case 8:
                        h.getPuestosVacunaciones().get(7).setAbierto(false);
                        h.getPuestosVacunaciones().get(7).despertar();
                        break;
                    case 9:
                        h.getPuestosVacunaciones().get(8).setAbierto(false);
                        h.getPuestosVacunaciones().get(8).despertar();
                        break;
                    case 10:
                        h.getPuestosVacunaciones().get(9).setAbierto(false);
                        h.getPuestosVacunaciones().get(9).despertar();
                        break;

                }

                entrada.close();
                conexion.close();

            }
        } catch (IOException e) {
        }
    }

    private String getPuesto() {

        return "";
    }

}
