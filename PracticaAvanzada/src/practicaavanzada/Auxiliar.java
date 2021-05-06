/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicaavanzada;

import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fersa
 */
public class Auxiliar extends Thread{
    private int id;
    private String numero;
    private hospital h;
    private int contadorPacientes=0;
    private Paciente p;
    public String getNumero() {
        return numero;
    }

    public Auxiliar(int id,hospital h) {
        this.id = id;
        this.numero = "A"+id;
        this.h=h;
    }

    public void run() {
        //CODIGO DE HILO
        while (true){
            //Auxiliar 1
            if(this.id==1){
                //Comprobar al paciente
                p=h.getComprobarDatos().poll();
                System.out.println("Auxiliar "+this.numero+" comprueba datos de "+ p.getNumero());
                try {
                    Thread.sleep(500 + (int) (Math.random() * 500));
                } catch (InterruptedException ex) {
                    Logger.getLogger(Auxiliar.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                
                
            }
            //Auxiliar 2
            else{
                
            }
        }
    }


}
