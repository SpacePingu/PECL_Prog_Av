/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicaavanzada;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Semaphore;

/**
 *
 * @author fersa
 */
public class hospital {
    Semaphore salaVacunacion = new Semaphore (10);
    Semaphore salaObservacion = new Semaphore (20);
    Queue<Paciente> recepcion = new ConcurrentLinkedQueue<Paciente>();

    public hospital(){}


}
