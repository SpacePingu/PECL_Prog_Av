/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

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
import javax.swing.JTextField;

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
    private JTextField Aux1;
    private JTextField pacienteAtendiendo;
    //Descanso
    private JTextArea descanso;
    //Vacunacion
    private JTextField Aux2,vacDisponibles,vac1,vac2,vac3,vac4,vac5,vac6,vac7,vac8,vac9,vac10;
    //Observacion
    private JTextField o1,o2,o3,o4,o5,o6,o7,o8,o9,o10,o11,o12,o13,o14,o15,o16,o17,o18,o19,o20;
    
    
    public Cliente(JTextArea colaEspera,JTextField Aux1, JTextField pacienteAtendiendo,JTextArea descanso,JTextField Aux2,JTextField vacDisponibles,JTextField vac1,JTextField vac2,JTextField vac3,JTextField vac4,JTextField vac5,JTextField vac6,JTextField vac7,JTextField vac8,JTextField vac9,JTextField vac10,JTextField o1,JTextField o2,JTextField o3,JTextField o4,JTextField o5,JTextField o6,JTextField o7,JTextField o8,JTextField o9,JTextField o10,JTextField o11,JTextField o12,JTextField o13,JTextField o14,JTextField o15,JTextField o16,JTextField o17,JTextField o18,JTextField o19,JTextField o20) {
        this.colaEspera = colaEspera;
        this.Aux1=Aux1;
        this.pacienteAtendiendo=pacienteAtendiendo;
        this.descanso=descanso;
        this.Aux2=Aux2;
        this.vacDisponibles=vacDisponibles;
        this.vac1=vac1;
        this.vac2=vac2;
        this.vac3=vac3;
        this.vac4=vac4;
        this.vac5=vac5;
        this.vac6=vac6;
        this.vac7=vac7;
        this.vac8=vac8;
        this.vac9=vac9;
        this.vac10=vac10;
        this.o1=o1;
        this.o2=o2;
        this.o3=o3;
        this.o4=o4;
        this.o5=o5;
        this.o6=o6;
        this.o7=o7;
        this.o8=o8;
        this.o9=o9;
        this.o10=o10;
        this.o11=o11;
        this.o12=o12;
        this.o13=o13;
        this.o14=o14;
        this.o15=o15;
        this.o16=o16;
        this.o17=o17;
        this.o18=o18;
        this.o19=o19;
        this.o20=o20;
    }

    public void run() {
 
        while (true) {
            //Conexion
            try {
                
                Thread.sleep(1000);
                cliente = new Socket(InetAddress.getLocalHost(), 5001); //Creamos el socket para conectarnos
               
              salida = new DataOutputStream(cliente.getOutputStream());
                salida.writeInt(0);

                //Recibir textos
               
                entrada = new ObjectInputStream(cliente.getInputStream());
                s =(ArrayList<String>) entrada.readObject();
                
                //Recepcion
                if (s.get(0)== null){
                    colaEspera.setText("");
                
                }else{
                    colaEspera.setText(s.get(0));
                }
                Aux1.setText(s.get(1));
                pacienteAtendiendo.setText(s.get(2));
                
                //Descanso
                descanso.setText(s.get(3));
                
                //Vacunacion
                Aux2.setText(s.get(4));
                vacDisponibles.setText(s.get(5));
                vac1.setText(s.get(6));
                vac2.setText(s.get(7));
                vac3.setText(s.get(8));
                vac4.setText(s.get(9));
                vac5.setText(s.get(10));
                vac6.setText(s.get(11));
                vac7.setText(s.get(12));
                vac8.setText(s.get(13));
                vac9.setText(s.get(14));
                vac10.setText(s.get(15));
                
                //Observacion
                o1.setText(s.get(16));
                o2.setText(s.get(17));
                o3.setText(s.get(18));
                o4.setText(s.get(19));
                o5.setText(s.get(20));
                o6.setText(s.get(21));
                o7.setText(s.get(22));
                o8.setText(s.get(23));
                o9.setText(s.get(24));
                o10.setText(s.get(25));
                o11.setText(s.get(26));
                o12.setText(s.get(27));
                o13.setText(s.get(28));
                o14.setText(s.get(29));
                o15.setText(s.get(30));
                o16.setText(s.get(31));
                o17.setText(s.get(32));
                o18.setText(s.get(33));
                o19.setText(s.get(34));
                o20.setText(s.get(35));
                
                
                
                
                
                
                cliente.close(); //Cerramos la conexión

            } catch (IOException ex) {
                Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InterruptedException ex) {
                Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
            }

        }


    }

}
