/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicaavanzada;

import java.util.concurrent.CountDownLatch;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fersa
 */
public class Paciente extends Thread {

    private int id;
    private String numero;
    private Hospital h;
    private PuestoVacunacion pv;
    private PuestoObservacion po;
    private CountDownLatch ocupado = new CountDownLatch(1);

    public Hospital getHospital() {
        return h;
    }

    public String getNumero() {
        return numero;
    }

    public CountDownLatch getOcupado() {
        return ocupado;
    }

    public Paciente(int id, Hospital h) {
        this.id = id;
        this.h = h;

// ESTO ES PARA QUE SE VEA EL 0 DE P003 POR EJEMPLO        
        if (id < 1000) {
            this.numero = "P0" + id;
        }
        if (id < 100) {
            this.numero = "P00" + id;
        }
        if (id < 10) {
            this.numero = "P000" + id;
        }
        if (id > 1000) {
            this.numero = "P" + id;
        }
    }

    public void run() {
        //CODIGO DE HILO

        //Paciente ingresa en la recepcion del Hospital
        h.getRecepcion().add(this);

        System.out.println("Paciente " + this.numero + " entra en el hospital");

        //Introduce visualmente la cola de espera en la interfaz
        h.getColaEspera().setText(h.recorrerColaEspera(h.getRecepcion()));

        //Espera a que el auxiliar le tome los datos
        try {
            //Le da los datos al auxiliar
            h.getComprobarDatos().put(this);
        } catch (InterruptedException ex) {
            Logger.getLogger(Paciente.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        //1% los paciente no estan citados
        if (Math.random() * 100 <= 1) {
            
            System.out.println("Paciente " + this.getNumero() + " no estaba citado");
            h.getRecepcion().remove(this);
            h.getColaEspera().setText(h.recorrerColaEspera(h.getRecepcion()));
        }

        //Esperan a que se le asigne puesto de vacunacion
        try {

            pv = h.getMesaAsiganada().take();
            h.getRecepcion().remove(this);
            h.getColaEspera().setText(h.recorrerColaEspera(h.getRecepcion()));
            //entra en la sala de vacunación   
            pv.meterPaciente(this);
//            ocupado.await();

            //System.out.println("Paciente " + this.getNumero() + " se le asigna el puesto: "+ h.getSalaVacunacion() );
        } catch (InterruptedException ex) {
            Logger.getLogger(Paciente.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {

            po = h.getPuestoObservacionAsignado().take();
            po.meterPaciente(this);
            System.out.println("Paciente " + this.numero + " va a la sala de observación: " + po.getId());
            Thread.sleep(10000);

            if (Math.random() * 100 <= 5) {
                System.out.println("Paciente " + this.getNumero() + " Tiene una reacción a la vacuna");
                
            }
            
            h.puestoObsConHuecoPaciente(po);
            

        } catch (InterruptedException ex) {
            Logger.getLogger(Paciente.class.getName()).log(Level.SEVERE, null, ex);

        }

        //Demomento los mando fuera del Hospital
        System.out.println("Paciente " + this.numero + " marcha del hospital");

    }

}
