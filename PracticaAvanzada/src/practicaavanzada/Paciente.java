/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicaavanzada;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

/**
 *
 * @author fersa
 */
public class Paciente extends Thread {

    private int id;
    private String numero;
    private hospital h;

    public hospital getHospital() {
        return h;
    }

    public String getNumero() {
        return numero;
    }

    public Paciente(int id, hospital h) {
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

        //Paciente ingresa en la recepcion del hospital
        h.getRecepcion().add(this);
        h.getR().getjTextFieldPaciente().setText(h.getRecepcion().element().getNumero()); 
        System.out.println("Paciente " + this.numero + " entra en el hospital");
        
        //Introduce visualmente la cola de espera en la interfaz
        h.getR().getjTextColaEspera().setText(h.recorrerCola(h.getRecepcion()));

        //Espera a que el auxiliar le tome los datos
        try {
            //Le da los datos al auxiliar
            h.getComprobarDatos().put(this);
        } catch (InterruptedException ex) {
            Logger.getLogger(Paciente.class.getName()).log(Level.SEVERE, null, ex);
        }

        //1% los paciente no estan citados
        if ((int) Math.random() * 100 == 1) {
            System.out.println("Paciente " + this.getNumero() + " no estaba citado");
            h.getRecepcion().remove(this);
        }

        //Esperan a que se le asigne puesto de
        try {

            h.getMesaAsiganada().take();
        //System.out.println("Paciente " + this.getNumero() + " se le asigna el puesto: "+ h.getSalaVacunacion() );
        } catch (InterruptedException ex) {
            Logger.getLogger(Paciente.class.getName()).log(Level.SEVERE, null, ex);
           
        }
        
        //Demomento los mando fuera del hospital
        h.getRecepcion().remove(this);
        System.out.println("Paciente " + this.numero + " marcha del hospital");

    }

}
