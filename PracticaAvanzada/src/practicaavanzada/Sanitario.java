/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicaavanzada;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fersa
 */
public class Sanitario extends Thread {

    private int id;
    private String numero;
    private hospital h;
    private Lock cerrojo = new ReentrantLock();

    public String getNumero() {
        return numero;
    }

    public Sanitario(int id,hospital h) {
        this.id = id;
        this.h=h;

// ESTO ES PARA QUE SE VEA EL 0 DE P03 POR EJEMPLO        
       
        if (id < 10) {
            this.numero = "S0" + id;
        }
        if (id >= 10) {
            this.numero = "S" + id;
        }
    }

    public void run() {
        try {
            //CODIGO DE HILO
            
            //Descanso de 1 a 3 segundos
            h.getDescansoSan().add(this);
            h.getSalaDescanso().setText(h.recorrerColaDescanso(h));
            System.out.println("Sanitario "+this.numero+" descansando");
            Thread.sleep(1000+ (int) Math.random()*2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Sanitario.class.getName()).log(Level.SEVERE, null, ex);
        }
            h.getDescansoSan().remove(this);
            h.getSalaDescanso().setText(h.recorrerColaDescanso(h));
            //Asignar mesa libre           
            h.libreSanitario().meterSanitario(this);
           
    }

}

