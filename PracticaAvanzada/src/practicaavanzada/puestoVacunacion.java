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
    private boolean huecoPaciente=true;
    private boolean huecoSanitario=true;
    private int id;
    private String s="";
    private JTextField texto;
    
    public puestoVacunacion(JTextField texto, int id){
        this.texto=texto;
        this.id=id;
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
    
    public synchronized void meterPaciente(Paciente p){
        this.s += p.getNumero();
        this.texto.setText(s);
        
        }
    
    public synchronized void meterSanitario(Sanitario S){
        this.s += S.getNumero();
        this.texto.setText(s);
        this.huecoSanitario=false;
        }
    
    public void limpiar(){
        s = "";
        }
    
    
    
}
