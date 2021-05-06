/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicaavanzada;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.SynchronousQueue;

/**
 *
 * @author fersa
 */
public class hospital {
    private Semaphore salaVacunacion = new Semaphore (10);
    private Semaphore salaObservacion = new Semaphore (20);
    private Queue<Paciente> recepcion = new ConcurrentLinkedQueue<Paciente>();
    private Queue<Paciente> comprobarDatos = new SynchronousQueue<Paciente>();
    

    public Queue<Paciente> getComprobarDatos() {
        return comprobarDatos;
    }
    
    public Semaphore getSalaVacunacion() {
        return salaVacunacion;
    }

    public Semaphore getSalaObservacion() {
        return salaObservacion;
    }

    public Queue<Paciente> getRecepcion() {
        return recepcion;
    }
    
    public hospital(){}


}
