/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicaavanzada;

import interfaz.MenuPrincipal;
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;
import interfaz.Recepcion;
import interfaz.SalaVacunacion;

/**
 *
 * @author fersa
 */
public class PracticaAvanzada {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //Inicio el menu ppal de la aplicación
    
    //    MenuPrincipal m = new MenuPrincipal();
    //    m.setVisible(true);

        //Inicio recepcion
        Recepcion r = new Recepcion();
        SalaVacunacion v = new SalaVacunacion();
        r.setVisible(true);
        v.setVisible(true);
        
        //Creo el hospital  
        hospital hospital = new hospital(r);

        //Creo a los sanitarios
        for (int i = 1; i <= 10; i++) {
            Sanitario s = new Sanitario(i);
            s.start();
        }

        //Creo a los auxiliar
        Auxiliar A1 = new Auxiliar(1, hospital);
        Auxiliar A2 = new Auxiliar(2, hospital);
        A1.start();
        A2.start();

        //Creo a los pacientes
        for (int i = 1; i <= 2000; i++) {
            Paciente p = new Paciente(i, hospital);
            p.start();

            try {
                sleep(1000 + (int) (Math.random() * 2000));
            } catch (InterruptedException ex) {
                Logger.getLogger(PracticaAvanzada.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
