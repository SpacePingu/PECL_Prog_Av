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
    private boolean abierto = true;
    private int id;
    private Sanitario san;
    private String s = "";
    private JTextField texto;
    private Hospital h;

    public PuestoVacunacion(JTextField texto, int id, Hospital h) {
        this.texto = texto;
        this.id = id;
        this.h = h;

    }

    public boolean isHuecoPaciente() {
        return huecoPaciente;
    }

    public boolean isHuecoSanitario() {
        return huecoSanitario;
    }

    public boolean isAbierto() {
        return abierto;
    }

    public int getId() {
        return id;
    }

    public String getS() {
        return s;
    }

    public Sanitario getSan() {
        return san;
    }

    public void setAbierto(boolean abierto) {
        this.abierto = abierto;
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

        while (((h.getVacunas().get() <= 0) || (this.isHuecoPaciente())) && (this.abierto)) {
            wait();
        }
        if (this.abierto) {
            try {
                //    System.out.println("Sanitario " + S.getNumero() + " inyecta vacuna a:" );
                Thread.sleep(3000 + (long) (Math.random() * 2000));
                h.getVacunas().decrementAndGet();
                h.getSalaVacunacionSemaforo().release();
                this.huecoPaciente = true;
                this.s = S.getNumero() + ",";
                this.texto.setText(s);
                h.puestoConHuecoPaciente(this);

            } catch (InterruptedException ex) {
                //     System.err.println("Fallo en vacunación");
                Logger.getLogger(Paciente.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            h.puestoConHuecoPaciente(this);
        }
    }

    public synchronized void meterPaciente(Paciente p) throws InterruptedException {
//        p.getOcupado().await();
        h.getSalaVacunacionSemaforo().acquire();
        this.s += p.getNumero() + ",";
        this.texto.setText(s);
        this.huecoPaciente = false;
        notifyAll();
    }

    public synchronized void meterSanitario(Sanitario S) {
        this.abierto = true;
        this.san = S;
        this.s += S.getNumero() + ",";
        this.texto.setText(s);
        this.huecoSanitario = false;
        notifyAll();
    }

    public synchronized void despertar() {
        notifyAll();
    }

    public void limpiar() {
        s = "";
        this.texto.setText(s);
        this.san = null;

    }

}
