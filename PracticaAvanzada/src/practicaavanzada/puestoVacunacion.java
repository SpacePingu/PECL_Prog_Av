/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicaavanzada;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextField;

/**
 *
 * @author fersa
 */
public class PuestoVacunacion {

    private boolean huecoPaciente = true;
    private boolean huecoSanitario = true;
    private int id;
    private String s = "";
    private JTextField texto;
    private Hospital h;

    public PuestoVacunacion(JTextField texto, int id, Hospital h) {
        this.texto = texto;
        this.id = id;
        this.h = h;

    }

    public synchronized boolean isHuecoPaciente() {
        return huecoPaciente;
    }

    public synchronized boolean isHuecoSanitario() {
        return huecoSanitario;
    }

    public int getId() {
        return id;
    }

    public String getS() {
        return s;
    }

    public JTextField getTexto() {
        return texto;
    }

    public void setHuecoPaciente(boolean huecoPaciente) {
        this.huecoPaciente = huecoPaciente;
    }

    public void setHuecoSanitario(boolean huecoSanitario) {
        this.huecoSanitario = huecoSanitario;

    }

    public synchronized void ponerVacuna(Sanitario S) throws InterruptedException {

        while ((h.getVacunas().get() <= 0) || (this.isHuecoPaciente())) {
            wait();
        }

        try {
            Thread.sleep(3000 + (int) Math.random() * 2000);
            h.getVacunas().decrementAndGet();
            h.getSalaVacunacionSemaforo().release();
            this.huecoPaciente = true;
            this.s = S.getNumero() + ",";
            this.texto.setText(s);
            notifyAll();
        } catch (InterruptedException ex) {
            System.err.println("Fallo en vacunación");
            Logger.getLogger(Paciente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public synchronized void meterPaciente(Paciente p) throws InterruptedException {
        h.getSalaVacunacionSemaforo().acquire();
        this.s += p.getNumero() + ",";
        this.texto.setText(s);
        this.huecoPaciente = false;
        notifyAll();
    }

    public synchronized void meterSanitario(Sanitario S) {
        this.s += S.getNumero() + ",";
        this.texto.setText(s);
        this.huecoSanitario = false;
        notifyAll();
    }

    public void limpiar() {
        s = "";
        this.texto.setText(s);

    }

}
