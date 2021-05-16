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
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;

/**
 *
 * @author fersa
 */
public class hospital {

    //Recepcion
    private JTextArea colaEspera;
    private JTextField aux1, pacienteAtendiendo;
    private ConcurrentLinkedQueue<Paciente> recepcion = new ConcurrentLinkedQueue<Paciente>();
    private BlockingQueue<Paciente> comprobarDatos = new LinkedBlockingQueue<Paciente>(1);
    private BlockingQueue mesaAsiganada = new LinkedBlockingQueue(1);
    
    //Sala de Vacunas
    private Semaphore salaVacunacionSemaforo = new Semaphore(10);
    private AtomicInteger vacunas = new AtomicInteger(0);
    private JTextField aux2, vacunasDisp;
    
    //Sala de descanso
     private ConcurrentLinkedQueue descansoAux = new ConcurrentLinkedQueue();
     private ConcurrentLinkedQueue descansoSan = new ConcurrentLinkedQueue();

    
    
     private JTextPane salaDescanso;
    
    //Sala de observacion
      private Semaphore salaObservacionSemaforo = new Semaphore(20);

    public hospital(JTextArea colaEspera,JTextField aux1,JTextField pacienteAtendiendo,JTextField aux2,JTextField vacunasDisp, JTextPane salaDescanso) {
        //Recepcion
        this.colaEspera=colaEspera;
        this.aux1=aux1;
        this.pacienteAtendiendo=pacienteAtendiendo;
        // Sala de Vacunas
        this.aux2=aux2;
        this.vacunasDisp=vacunasDisp;
        //Sala de descanso
        this.salaDescanso=salaDescanso;
    }

    public ConcurrentLinkedQueue getDescansoAux() {
        return descansoAux;
    }

    public JTextPane getSalaDescanso() {
        return salaDescanso;
    }

    public ConcurrentLinkedQueue getDescansoSan() {
        return descansoSan;
    }
    
    public JTextArea getColaEspera() {
        return colaEspera;
    }

    public JTextField getAux2() {
        return aux2;
    }

    
    public JTextField getVacunasDisp() {
        return vacunasDisp;
    }
    
    public JTextField getAux1() {
        return aux1;
    }

    public JTextField getPacienteAtendiendo() {
        return pacienteAtendiendo;
    }

    public AtomicInteger getVacunas() {
        return vacunas;
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

   

    

    public String recorrerColaEspera(ConcurrentLinkedQueue<Paciente> cola) {
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
    
    
    public String recorrerColaDescanso(hospital h) {
       String s = "";
        Sanitario san;
        Auxiliar aux;
        Iterator<Auxiliar> itAux = descansoAux.iterator();
        Iterator<Sanitario> itSan = descansoSan.iterator();
        ConcurrentLinkedQueue<Sanitario> cSan = new ConcurrentLinkedQueue<Sanitario>();
        ConcurrentLinkedQueue<Auxiliar> cAux = new ConcurrentLinkedQueue<Auxiliar>();
        while (itSan.hasNext()) {
            san = itSan.next();
            cSan.add(san);

            s += san.getNumero() + ", ";
        }
        while (itAux.hasNext()) {
            aux = itAux.next();
            cAux.add(aux);

            s += aux.getNumero() + ", ";
        }
        return s;
    }

}
