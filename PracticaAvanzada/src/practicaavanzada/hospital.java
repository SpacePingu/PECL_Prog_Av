/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicaavanzada;

import java.util.Queue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.SynchronousQueue;
import interfaz.Recepcion;
import java.util.Iterator;

/**
 *
 * @author fersa
 */
public class hospital {
    private Semaphore salaVacunacion = new Semaphore (10);
    private Semaphore salaObservacion = new Semaphore (20);
    private ConcurrentLinkedQueue<Paciente> recepcion = new ConcurrentLinkedQueue<Paciente>();
    private BlockingQueue<Paciente> comprobarDatos = new LinkedBlockingQueue<Paciente>(1);
    private BlockingQueue mesaAsiganada = new LinkedBlockingQueue(1);
    private Recepcion r;
    

    public BlockingQueue<Paciente> getComprobarDatos() {
        return comprobarDatos;
    }

    public BlockingQueue getMesaAsiganada() {
        return mesaAsiganada;
    }
    
    public Semaphore getSalaVacunacion() {
        return salaVacunacion;
    }

    public Semaphore getSalaObservacion() {
        return salaObservacion;
    }

    public ConcurrentLinkedQueue<Paciente> getRecepcion() {
        return recepcion;
    }
    
    public hospital(Recepcion r){
    this.r = r;
    }

    public Recepcion getR() {
        return r;
    }

    public String recorrerCola(ConcurrentLinkedQueue<Paciente> cola){
        String s = "";
        Paciente p;
        Iterator<Paciente> it = cola.iterator();
        ConcurrentLinkedQueue<Paciente> c2 = new ConcurrentLinkedQueue<Paciente>();
        while(it.hasNext())  {
            p= it.next();
        c2.add(p);

            s+=p.getNumero() + ", ";
        }
        return s;
    }

}
