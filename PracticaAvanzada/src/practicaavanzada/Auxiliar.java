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
    private Hospital h;
    private int contadorPacientes = 0;
    private Paciente p;
    private AtomicInteger contador = new AtomicInteger(0);
    private AtomicInteger contadorVacunas = new AtomicInteger(0);
    private PuestoVacunacion pv;

    public String getNumero() {
        return numero;
    }

    public Auxiliar(int id, Hospital h) {
        this.id = id;
        this.numero = "A" + id;
        this.h = h;
    }

    public void run() {
        //CODIGO DE HILO
        while (true) {
            //Auxiliar 1
            if (this.id == 1) {
                //COMPRUEBA DATOS
                try {

                    p = this.h.getComprobarDatos().take();
                    h.getPacienteAtendiendo().setText(p.getNumero());
                    h.getAux1().setText(this.numero);
                    System.out.println("Auxiliar " + this.numero + " comprueba datos de " + p.getNumero());
                    contador.getAndIncrement();
                    Thread.sleep(500 + (int) (Math.random() * 500));
                } catch (InterruptedException ex) {
                    Logger.getLogger(Auxiliar.class.getName()).log(Level.SEVERE, null, ex);
                }

                //Busca sitio libre
//                    pv = h.getPuestosVacunaciones().get(h.huecoPVpaciente());
                try {
                    h.getMesaAsiganada().put(h.getPuestosVacunacionLibres().take());

                } catch (InterruptedException ex) {
                    Logger.getLogger(Auxiliar.class.getName()).log(Level.SEVERE, null, ex);
                }
                //Descaso cada 10 pacientes
                if (contador.get() == 10) {
                    h.getAux1().setText("");
                    try {
                        System.out.println("Descanso de A1");
                        h.getDescansoAux().add(this);
                        h.getSalaDescanso().setText(h.recorrerColaDescanso(h));
                        Thread.sleep(3000 + (int) Math.random() * 2000);
                        h.getDescansoAux().remove(this);
                        h.getSalaDescanso().setText(h.recorrerColaDescanso(h));
                        contador.set(0);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Auxiliar.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            } //Auxiliar 2
            else {
                try {

                    h.getAux2().setText(this.numero);
                    h.añadirVacunas();
                    contadorVacunas.incrementAndGet();

                    //System.out.println("Vacuna añadida");
                    h.getVacunasDisp().setText(h.getVacunas().toString());
                    Thread.sleep(500 + (int) Math.random() * 500);

                    if (contadorVacunas.get() == 20) {
                        h.getAux2().setText("");
                        h.getDescansoAux().add(this);
                        h.getSalaDescanso().setText(h.recorrerColaDescanso(h));
                        System.out.println("Auxiliar 2 descansa");
                        Thread.sleep(1000 + (int) Math.random() * 4000);
                        h.getDescansoAux().remove(this);
                        h.getSalaDescanso().setText(h.recorrerColaDescanso(h));
                        contadorVacunas.set(0);
                    }

                } catch (InterruptedException ex) {
                    Logger.getLogger(Auxiliar.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

}
