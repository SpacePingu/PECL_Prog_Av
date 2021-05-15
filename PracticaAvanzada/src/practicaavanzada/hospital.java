/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicaavanzada;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Semaphore;
import interfaz.*;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author fersa
 */
public class hospital {

    private Recepcion r;
    private SalaObservacion o;
    private SalaDescanso d;
    private SalaVacunacion v;
    private Semaphore salaVacunacionSemaforo = new Semaphore(10);
    private Semaphore salaObservacionSemaforo = new Semaphore(20);
    private ConcurrentLinkedQueue<Paciente> recepcion = new ConcurrentLinkedQueue<Paciente>();
    private BlockingQueue<Paciente> comprobarDatos = new LinkedBlockingQueue<Paciente>(1);
    private BlockingQueue mesaAsiganada = new LinkedBlockingQueue(1);
    private AtomicInteger vacunas = new AtomicInteger(0);

    public hospital(Recepcion r, SalaObservacion o, SalaDescanso d, SalaVacunacion v) {
        this.r = r;
        this.o = o;
        this.d = d;
        this.v = v;
    }

    public AtomicInteger getVacunas() {
        return vacunas;
    }

    public SalaObservacion getO() {
        return o;
    }

    public SalaDescanso getD() {
        return d;
    }

    public SalaVacunacion getV() {
        return v;
    }

    public AtomicInteger añadirVacunas() {
        vacunas.addAndGet(1);
        return vacunas;
    }

    public AtomicInteger vacunar() {
        vacunas.decrementAndGet();
        return vacunas;
    }

    public BlockingQueue<Paciente> getComprobarDatos() {
        return comprobarDatos;
    }

    public BlockingQueue getMesaAsiganada() {
        return mesaAsiganada;
    }

    public Semaphore getSalaVacunacionSemaforo() {
        return salaVacunacionSemaforo;
    }

    public Semaphore getSalaObservacionSemaforo() {
        return salaObservacionSemaforo;
    }

    public ConcurrentLinkedQueue<Paciente> getRecepcion() {
        return recepcion;
    }

    public hospital(Recepcion r) {
        this.r = r;
    }

    public Recepcion getR() {
        return r;
    }

    public String recorrerCola(ConcurrentLinkedQueue<Paciente> cola) {
        String s = "";
        Paciente p;
        Iterator<Paciente> it = cola.iterator();
        ConcurrentLinkedQueue<Paciente> c2 = new ConcurrentLinkedQueue<Paciente>();
        while (it.hasNext()) {
            p = it.next();
            c2.add(p);

            s += p.getNumero() + ", ";
        }
        return s;
    }

}
