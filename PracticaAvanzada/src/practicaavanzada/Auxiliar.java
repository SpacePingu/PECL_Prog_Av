/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicaavanzada;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fersa
 */
public class Auxiliar extends Thread {

    private int id;
    private String numero;
    private hospital h;
    private int contadorPacientes = 0;
    private Paciente p;
    private AtomicInteger contador = new AtomicInteger(0);
    private AtomicInteger contadorVacunas = new AtomicInteger(0);

    public String getNumero() {
        return numero;
    }

    public Auxiliar(int id, hospital h) {
        this.id = id;
        this.numero = "A" + id;
        this.h = h;
    }

    public void run() {
        //CODIGO DE HILO
        while (true) {
            //Auxiliar 1
            if (this.id == 1) {

                try {

                    p = this.h.getComprobarDatos().take();
                    Thread.sleep(3000 + (int) Math.random() * 2000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Auxiliar.class.getName()).log(Level.SEVERE, null, ex);
                }
                //if (p == null) { System.out.println("paciente nulo"); }
                h.getR().getjTextAuxiliarCola().setText(this.numero);
                System.out.println("Auxiliar " + this.numero + " comprueba datos de " + p.getNumero());
                contador.getAndIncrement();

                try {
                    Thread.sleep(500 + (int) (Math.random() * 500));
                    h.getMesaAsiganada().put(1);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Auxiliar.class.getName()).log(Level.SEVERE, null, ex);
                }

                //Descaso cada 10 pacientes
                if (contador.get() == 10) {
                    h.getR().getjTextAuxiliarCola().setText("");
                    try {
                        System.out.println("Descanso de A1");
                        Thread.sleep(3000 + (int) Math.random() * 2000);

                        contador.set(0);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Auxiliar.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            } //Auxiliar 2
            else {
                try {

                    h.getV().getjTextAuxiliarVacunacion().setText(this.numero);
                    h.añadirVacunas();
                    contadorVacunas.incrementAndGet();
                    System.out.println("Vacuna añadida");
                    h.getV().getjTextVaunasDisp().setText(h.getVacunas().toString());
                    Thread.sleep(500 + (int) Math.random() * 500);

                    if (contadorVacunas.get() == 20) {
                        h.getV().getjTextAuxiliarVacunacion().setText("");                       
                        System.out.println("Auxiliar 2 descansa");
                        Thread.sleep(1000 + (int) Math.random() * 4000);
                        contadorVacunas.set(0);
                    }
                    
                } catch (InterruptedException ex) {
                    Logger.getLogger(Auxiliar.class.getName()).log(Level.SEVERE, null, ex);
                }
                //System.out.println("prueba de A2");
            }
        }
    }

}
