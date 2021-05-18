/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicaavanzada;

import javax.swing.JTextField;

/**
 *
 * @author fersa
 */
public class puestoVacunacion {

    private boolean huecoPaciente = true;
    private boolean huecoSanitario = true;
    private int id;
    private String s = "";
    private JTextField texto;
    private hospital h;

    public puestoVacunacion(JTextField texto, int id, hospital h) {
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

        while ((h.getVacunas().get() <= 0) || (this.isHuecoPaciente()) || (this.isHuecoSanitario())) {
            wait();
        }
        //valor original sleep (3000)
        Thread.sleep(10000 + (int) Math.random() * 2000);
        this.huecoPaciente = true;
        this.s = S.getNumero() + ",";
        this.texto.setText(s);
        h.getVacunas().decrementAndGet();

    }

    public synchronized void meterPaciente(Paciente p) {
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
