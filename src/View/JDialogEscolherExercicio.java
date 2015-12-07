/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import DataBase.Exercicios;

/**
 *
 * @author afnsoo
 */
public class JDialogEscolherExercicio extends javax.swing.JDialog {

    /**
     * Creates new form JDialogEscolherExercicio
     */
    public JDialogEscolherExercicio(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        jButton3 = new javax.swing.JButton();
        AcademiaVisualPUEntityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("AcademiaVisualPU").createEntityManager();
        exerciciosQuery = java.beans.Beans.isDesignTime() ? null : AcademiaVisualPUEntityManager.createQuery("SELECT e FROM Exercicios e");
        exerciciosList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : exerciciosQuery.getResultList();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableEscolherExercicio = new javax.swing.JTable();
        jButtonFecharEscolherExercicio = new javax.swing.JButton();
        jButtonConfirmarExercicio = new javax.swing.JButton();

        jButton3.setText("jButton3");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Escolher Exercicio");

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, exerciciosList, jTableEscolherExercicio);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${id}"));
        columnBinding.setColumnName("Id");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${nome}"));
        columnBinding.setColumnName("Nome");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${descricao}"));
        columnBinding.setColumnName("Descricao");
        columnBinding.setColumnClass(String.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jScrollPane1.setViewportView(jTableEscolherExercicio);

        jButtonFecharEscolherExercicio.setText("Cancelar");
        jButtonFecharEscolherExercicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFecharEscolherExercicioActionPerformed(evt);
            }
        });

        jButtonConfirmarExercicio.setText("Confirmar");
        jButtonConfirmarExercicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConfirmarExercicioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 596, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonConfirmarExercicio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonFecharEscolherExercicio)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonFecharEscolherExercicio)
                    .addComponent(jButtonConfirmarExercicio))
                .addGap(0, 12, Short.MAX_VALUE))
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonConfirmarExercicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConfirmarExercicioActionPerformed
        Exercicios exercicio = exerciciosList.get(jTableEscolherExercicio.getSelectedRow());
        this.setExercicio(exercicio);
        this.SELECIONADO = true;
        this.setVisible(false);
    }//GEN-LAST:event_jButtonConfirmarExercicioActionPerformed

    private void jButtonFecharEscolherExercicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFecharEscolherExercicioActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jButtonFecharEscolherExercicioActionPerformed

    public Exercicios exercicioSelecionado = new Exercicios();
    public boolean SELECIONADO = false;
    
     public void setExercicio(Exercicios exercicio)
    {
        exercicioSelecionado = exercicio;
    }
    
    public Exercicios getExercicio()
    {
        return exercicioSelecionado;
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
            java.util.logging.Logger.getLogger(JDialogEscolherExercicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDialogEscolherExercicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDialogEscolherExercicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDialogEscolherExercicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDialogEscolherExercicio dialog = new JDialogEscolherExercicio(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.persistence.EntityManager AcademiaVisualPUEntityManager;
    private java.util.List<DataBase.Exercicios> exerciciosList;
    private javax.persistence.Query exerciciosQuery;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButtonConfirmarExercicio;
    private javax.swing.JButton jButtonFecharEscolherExercicio;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableEscolherExercicio;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}