/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicaavanzada;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
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
    PuestoObservacion po;
    private CountDownLatch ocupado = new CountDownLatch(1);
    private boolean Reaccion = false;
    private boolean citado = true;

    public Hospital getHospital() {
        return h;
    }

    public void setReaccion(boolean Reaccion) {
        this.Reaccion = Reaccion;
    }

    public String getNumero() {
        return numero;
    }

    public CountDownLatch getOcupado() {
        return ocupado;
    }

    public boolean isCitado() {
        return citado;
    }

    public boolean isReaccion() {
        return Reaccion;
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
        try {
            //CODIGO DE HILO

            //Paciente ingresa en la recepcion del Hospital
            h.getRecepcion().add(this);

            h.meterLog("Paciente " + this.numero + " entra en el hospital");

            //Introduce visualmente la cola de espera en la interfaz
            h.getColaEspera().setText(h.recorrerColaEspera(h.getRecepcion()));

            //1% los paciente no estan citados
            if ((Math.random() * 100) <= 1) {
                this.citado = false;
                h.meterLog("Paciente " + this.getNumero() + " no estaba citado");
                h.getRecepcion().remove(this);
              
            }

            //Espera a que el auxiliar le tome los datos
            
         
            try {
                //Le da los datos al auxiliar
               
                    h.getComprobarDatos().put(this);
                       h.getColaEspera().setText(h.recorrerColaEspera(h.getRecepcion()));
                }catch (InterruptedException ex) {
                Logger.getLogger(Paciente.class.getName()).log(Level.SEVERE, null, ex);
            }
              if (this.citado) {
                //Esperan a que se le asigne puesto de vacunacion
                try {

                    pv = h.getMesaAsiganada().take();
                    h.getRecepcion().remove(this);
                    h.getColaEspera().setText(h.recorrerColaEspera(h.getRecepcion()));
                    //entra en la sala de vacunación
                    pv.meterPaciente(this);

                    h.meterLog("Paciente " + this.getNumero() + " se le asigna el puesto de vacunacion: " + pv.getId());
                } catch (InterruptedException ex) {
                    Logger.getLogger(Paciente.class.getName()).log(Level.SEVERE, null, ex);
                }

                try {

                    po = h.getPuestoObservacionAsignado().take();
                    po.meterPaciente(this);
                    h.meterLog("Paciente " + this.numero + " va a la sala de observación: " + po.getId());
                    Thread.sleep(10000);

                    if (Math.random() * 100 <= 5) {
                        h.meterLog("Paciente " + this.getNumero() + " Tiene una reacción a la vacuna");
                        this.Reaccion = true;
                        ocupado.await();

                    }

                    h.puestoObsConHuecoPaciente(po);

                } catch (InterruptedException ex) {
                    Logger.getLogger(Paciente.class.getName()).log(Level.SEVERE, null, ex);

                }
            }

            //Los mando fuera del Hospital
            h.meterLog("Paciente " + this.numero + " marcha del hospital");

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Paciente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Paciente.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
