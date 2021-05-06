/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicaavanzada;

/**
 *
 * @author fersa
 */
public class Sanitario extends Thread {

    private int id;
    private String numero;

    public String getNumero() {
        return numero;
    }

    public Sanitario(int id) {
        this.id = id;

// ESTO ES PARA QUE SE VEA EL 0 DE P03 POR EJEMPLO        
       
        if (id < 10) {
            this.numero = "P0" + id;
        }
        if (id > 10) {
            this.numero = "P" + id;
        }
    }

    public void run() {
        //CODIGO DE HILO

    }

}

