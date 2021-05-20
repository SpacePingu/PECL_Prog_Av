/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicaavanzada;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fersa
 */
public class Sanitario extends Thread {

    private int id;
    private String numero;
    private Hospital h;
    private AtomicInteger contador = new AtomicInteger(0);
    private PuestoVacunacion pv;

    public String getNumero() {
        return numero;
    }

    public Sanitario(int id, Hospital h) {
        this.id = id;
        this.h = h;

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
            this.pv = null;
            h.getDescansoSan().add(this);
            h.getSalaDescanso().setText(h.recorrerColaDescanso(h));
            System.out.println("Sanitario " + this.numero + " descansando");
            Thread.sleep(1000 + (int) Math.random() * 2000);

        } catch (InterruptedException ex) {
            Logger.getLogger(Sanitario.class.getName()).log(Level.SEVERE, null, ex);
        }
        h.getDescansoSan().remove(this);
        h.getSalaDescanso().setText(h.recorrerColaDescanso(h));
        //Asignar mesa libre           
        pv = h.libreSanitario();
        pv.meterSanitario(this);
        
        while (!Thread.currentThread().isInterrupted()) {

            //Poner Vacuna
            try {
                pv.ponerVacuna(this);                
                
            } catch (InterruptedException ex) {
                Logger.getLogger(Sanitario.class.getName()).log(Level.SEVERE, null, ex);
            }
            contador.incrementAndGet();
//          pv.getTexto().setText(numero);

            //Descanso
            if (contador.get() == 15) {
                System.out.println("Sanitario "+this.id+" descansa");
                pv.limpiar();
                pv.setHuecoSanitario(true);
                this.pv = null;
                h.getDescansoSan().add(this);
                h.getSalaDescanso().setText(h.recorrerColaDescanso(h));

                try {
                    Thread.sleep(5000 + (int) Math.random() * 3000);
                    h.getDescansoSan().remove(this);
                    h.getSalaDescanso().setText(h.recorrerColaDescanso(h));
                   
                } catch (InterruptedException ex) {
                    Logger.getLogger(Sanitario.class.getName()).log(Level.SEVERE, null, ex);
                }
                //Asignar mesa libre           
                pv = h.libreSanitario();
                pv.meterSanitario(this);
                contador.set(0);
                
            }

        }

    }
}
