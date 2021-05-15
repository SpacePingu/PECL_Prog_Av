/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import static java.lang.Thread.sleep;
import practicaavanzada.*;

/**
 *
 * @author adryh
 */
public class MenuPrincipal extends javax.swing.JFrame {

    //Inicio de interfaces (recepcion, sala de descanso, sala de observacion, sala de vacunación)  
    static MenuPrincipal m = new MenuPrincipal();
    static Recepcion r = new Recepcion();
    static SalaDescanso d = new SalaDescanso();
    static SalaObservacion o = new SalaObservacion();
    static SalaVacunacion v = new SalaVacunacion();

    /**
     * Creates new form MenuPrincipal
     */
    public MenuPrincipal() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jButDescanso = new javax.swing.JButton();
        jButObservacion = new javax.swing.JButton();
        jButVacunacion = new javax.swing.JButton();
        jButRecepcion = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menu principal");
        setLocation(new java.awt.Point(600, 200));
        setResizable(false);

        jLabel1.setText("MENU PRINCIPAL");

        jButDescanso.setText("Sala de descanso");
        jButDescanso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButDescansoActionPerformed(evt);
            }
        });

        jButObservacion.setText("Sala de Observación");
        jButObservacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButObservacionActionPerformed(evt);
            }
        });

        jButVacunacion.setText("Sala de vacunación");
        jButVacunacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButVacunacionActionPerformed(evt);
            }
        });

        jButRecepcion.setText("Recepción");
        jButRecepcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButRecepcionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jButRecepcion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButObservacion, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 116, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButVacunacion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButDescanso, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(55, 55, 55))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButRecepcion, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButVacunacion, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(63, 63, 63)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButObservacion, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButDescanso, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(46, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(54, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(272, 272, 272))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(53, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButRecepcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButRecepcionActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        r.setVisible(true);

    }//GEN-LAST:event_jButRecepcionActionPerformed

    private void jButDescansoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButDescansoActionPerformed
        this.setVisible(false);
        d.setVisible(true);
    }//GEN-LAST:event_jButDescansoActionPerformed

    private void jButObservacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButObservacionActionPerformed
        this.setVisible(false);
        o.setVisible(true);
    }//GEN-LAST:event_jButObservacionActionPerformed

    private void jButVacunacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButVacunacionActionPerformed
        this.setVisible(false);
        v.setVisible(true);
    }//GEN-LAST:event_jButVacunacionActionPerformed

    public static MenuPrincipal getM() {
        return m;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                m.setVisible(true);
            }
        });

        // TODO code application logic here
        //Inicio el menu ppal de la aplicación
        //iniciadas pero ocultas
        r.setVisible(false);
        d.setVisible(false);
        o.setVisible(false);
        v.setVisible(false);

        //Creo el hospital  
        hospital hospital = new hospital(r,o,d,v);

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
        //Creo a los pacientes
        for (int i = 1; i <= 2000; i++) {
            Paciente p = new Paciente(i, hospital);
            p.start();

            try {
                sleep(1000 + (int) (Math.random() * 2000));
            } catch (InterruptedException ex) {
                java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
        }

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButDescanso;
    private javax.swing.JButton jButObservacion;
    private javax.swing.JButton jButRecepcion;
    private javax.swing.JButton jButVacunacion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
