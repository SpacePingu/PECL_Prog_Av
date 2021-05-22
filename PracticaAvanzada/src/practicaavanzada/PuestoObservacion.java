/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicaavanzada;

import java.io.Serializable;
import javax.swing.JTextField;

/**
 *
 * @author adryh
 */
public class PuestoObservacion{

    private boolean huecoPaciente = true;
    private boolean huecoSanitario = true;
    private int id;
    private String s = "";
    private JTextField texto;
    private Hospital h;
    private Paciente p;

    public PuestoObservacion(int id, JTextField texto, Hospital h) {
        this.id = id;
        this.texto = texto;
        this.h = h;
    }

    public boolean isHuecoPaciente() {
        return huecoPaciente;
    }

    public void setHuecoPaciente(boolean huecoPaciente) {
        this.huecoPaciente = huecoPaciente;
    }

    public void setP(Paciente p) {
        this.p = p;
    }

    public boolean isHuecoSanitario() {
        return huecoSanitario;
    }

    public void setHuecoSanitario(boolean huecoSanitario) {
        this.huecoSanitario = huecoSanitario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }

    public JTextField getTexto() {
        return texto;
    }

    public void setTexto(JTextField texto) {
        this.texto = texto;
    }

    public Hospital getH() {
        return h;
    }

    public Paciente getP() {
        return p;
    }
    

    public synchronized void meterPaciente(Paciente p) throws InterruptedException {
        
        h.getSalaObservacionSemaforo().acquire();
        this.p = p;
        this.s += p.getNumero() + ",";
        this.texto.setText(s);
        this.huecoPaciente = false;
        notifyAll();
    }

    public void limpiar() {
        s = "";
        this.texto.setText(s);

    }

}
