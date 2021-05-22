/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicaavanzada;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fersa
 */
public class Sanitario extends Thread{

    private int id;
    private String numero;
    private Hospital h;
    private AtomicInteger contador = new AtomicInteger(0);
    private PuestoVacunacion pv;
    private PuestoObservacion po;

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
        //    System.out.println("Sanitario " + this.numero + " descansando");
            Thread.sleep(1000 + (long) (Math.random() * 2000));

        } catch (InterruptedException ex) {
            Logger.getLogger(Sanitario.class.getName()).log(Level.SEVERE, null, ex);
        }
        h.getDescansoSan().remove(this);
        h.getSalaDescanso().setText(h.recorrerColaDescanso(h));
        //Asignar mesa libre           
        pv = h.libreSanitario();
        pv.meterSanitario(this);

        while (true) {

            //Poner Vacuna
            try {
                pv.ponerVacuna(this);

            } catch (InterruptedException ex) {
                Logger.getLogger(Sanitario.class.getName()).log(Level.SEVERE, null, ex);
            }
            contador.incrementAndGet();

            //Busca sitio para observación 
            try {

                h.getPuestoObservacionAsignado().put(h.getPuestosObservacionLibres().take());

            } catch (InterruptedException ex) {
                Logger.getLogger(Auxiliar.class.getName()).log(Level.SEVERE, null, ex);
            }
//          pv.getTexto().setText(numero);

            //Descanso
            if (contador.get() == 15 || !pv.isAbierto()) {
            //    System.out.println("Sanitario " + this.id + " descansa");
                pv.limpiar();
                pv.setHuecoSanitario(true);
                this.pv = null;
                h.getDescansoSan().add(this);
                h.getSalaDescanso().setText(h.recorrerColaDescanso(h));

                try {
                    Thread.sleep(5000 + (long) (Math.random() * 3000));
                    h.getDescansoSan().remove(this);
                    h.getSalaDescanso().setText(h.recorrerColaDescanso(h));

                } catch (InterruptedException ex) {
                    Logger.getLogger(Sanitario.class.getName()).log(Level.SEVERE, null, ex);
                }

                try {
                    
                    int a = buscarEnfermo(h.getPuestosObservacion());
                    
                    if (a != -1){
                        
                        po =  h.getPuestosObservacion().get(a);
                        curarEnfermo(po);
                        
                    } 
                    
                    
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

    public synchronized int buscarEnfermo(ArrayList<PuestoObservacion> puestosObservacion) throws InterruptedException {
        int a = -1;
        PuestoObservacion p;
        Iterator<PuestoObservacion> it = puestosObservacion.iterator();

        while (it.hasNext()) {

            p = it.next();

            if ((p.getP() != null) && ( p.isHuecoSanitario())) {

                if ((p.getP().isReaccion() == true)) {
                    p.setHuecoSanitario(false);    
                    a = p.getId()-1;
                    break;
                }

            }

        }

        return a;

    }

    public void curarEnfermo(PuestoObservacion po) throws InterruptedException {

       
        po.getTexto().setText(po.getP().getNumero() + ", " + this.numero);
        
     //   System.out.println("Paciente: " + po.getP().getNumero() + " es atendido por Sanitario: " + this.getNumero());
        Thread.sleep(2000 + (long) (Math.random() * 3000));
        
        po.limpiar();
        po.getP().setReaccion(false);
        po.getP().getOcupado().countDown();
        po.setHuecoSanitario(true);
        po.setP(null);
       
    }
}
