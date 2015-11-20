/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

/**
 *
 * @author afnsoo
 */
public class JInternalFrameCadastroTreinador extends javax.swing.JInternalFrame {

    /**
     * Creates new form JInternalFrameCadastroTreinador
     */
    public JInternalFrameCadastroTreinador() {
        initComponents();
        jTabbedPaneTreinador.setEnabledAt(1, false);
        
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

        AcademiaVisualPUEntityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("AcademiaVisualPU").createEntityManager();
        treinadorQuery = java.beans.Beans.isDesignTime() ? null : AcademiaVisualPUEntityManager.createQuery("SELECT t FROM Treinador t");
        treinadorList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : treinadorQuery.getResultList();
        treinadorQuery1 = java.beans.Beans.isDesignTime() ? null : AcademiaVisualPUEntityManager.createQuery("SELECT t FROM Treinador t");
        treinadorList1 = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : treinadorQuery1.getResultList();
        treinadorQuery2 = java.beans.Beans.isDesignTime() ? null : AcademiaVisualPUEntityManager.createQuery("SELECT t FROM Treinador t");
        treinadorList2 = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : treinadorQuery2.getResultList();
        jButtonExcluirTreinador = new javax.swing.JButton();
        jButtonFecharTreinador = new javax.swing.JButton();
        jTabbedPaneTreinador = new javax.swing.JTabbedPane();
        jPanelConsultaTreinador = new javax.swing.JPanel();
        jScrollPaneTreinador = new javax.swing.JScrollPane();
        jTableTreinador = new javax.swing.JTable();
        jLabelProcurarTreinador = new javax.swing.JLabel();
        jTextFieldProcurarTreinador = new javax.swing.JTextField();
        jComboBoxProcurarTreinador = new javax.swing.JComboBox();
        jButtonProcurarTreinador = new javax.swing.JButton();
        jPanelAlterarTreinador = new javax.swing.JPanel();
        jLabelNomeTreinador = new javax.swing.JLabel();
        jLabelCpfTreinador = new javax.swing.JLabel();
        jLabelDataNascimentoTreinador = new javax.swing.JLabel();
        jLabelEnderecoTreinador = new javax.swing.JLabel();
        jLabelLoginTreinador = new javax.swing.JLabel();
        jLabelSenhaTreinador = new javax.swing.JLabel();
        jLabelEmailTreinador = new javax.swing.JLabel();
        jTextFieldNomeTreinador = new javax.swing.JTextField();
        jTextFieldCpfTreinador = new javax.swing.JTextField();
        jTextFieldDataNascimentoTreinador = new javax.swing.JTextField();
        jTextFieldEnderecoTreinador = new javax.swing.JTextField();
        jTextFieldLoginTreinador = new javax.swing.JTextField();
        jTextFieldEmailTreinador = new javax.swing.JTextField();
        jPasswordFieldSenhaTreinador = new javax.swing.JPasswordField();
        jLabelAdministradorTreinador = new javax.swing.JLabel();
        jCheckBoxAdministradorTreinador = new javax.swing.JCheckBox();
        jButtonCancelarTreinador = new javax.swing.JButton();
        jButtonConfirmarTreinador = new javax.swing.JButton();
        jButtonInserirTreinador = new javax.swing.JButton();
        jButtonAlterarTreinador = new javax.swing.JButton();

        setTitle("Cadastro Treinador");

        jButtonExcluirTreinador.setText("Excluir");

        jButtonFecharTreinador.setText("Fechar");
        jButtonFecharTreinador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFecharTreinadorActionPerformed(evt);
            }
        });

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, treinadorList2, jTableTreinador);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${id}"));
        columnBinding.setColumnName("Id");
        columnBinding.setColumnClass(Integer.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${nome}"));
        columnBinding.setColumnName("Nome");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${cpf}"));
        columnBinding.setColumnName("CPF");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${dataNascimento}"));
        columnBinding.setColumnName("Data Nascimento");
        columnBinding.setColumnClass(java.util.Date.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${email}"));
        columnBinding.setColumnName("E-Mail");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${endereco}"));
        columnBinding.setColumnName("Endereço");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${login}"));
        columnBinding.setColumnName("Login");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jScrollPaneTreinador.setViewportView(jTableTreinador);

        jLabelProcurarTreinador.setText("Opção De Busca");

        jTextFieldProcurarTreinador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldProcurarTreinadorActionPerformed(evt);
            }
        });

        jComboBoxProcurarTreinador.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Id", "Nome", "CPF", "Validade" }));

        jButtonProcurarTreinador.setText("Buscar");
        jButtonProcurarTreinador.setMaximumSize(new java.awt.Dimension(75, 23));
        jButtonProcurarTreinador.setMinimumSize(new java.awt.Dimension(75, 23));
        jButtonProcurarTreinador.setPreferredSize(new java.awt.Dimension(75, 23));

        javax.swing.GroupLayout jPanelConsultaTreinadorLayout = new javax.swing.GroupLayout(jPanelConsultaTreinador);
        jPanelConsultaTreinador.setLayout(jPanelConsultaTreinadorLayout);
        jPanelConsultaTreinadorLayout.setHorizontalGroup(
            jPanelConsultaTreinadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPaneTreinador, javax.swing.GroupLayout.DEFAULT_SIZE, 574, Short.MAX_VALUE)
            .addGroup(jPanelConsultaTreinadorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelProcurarTreinador)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jComboBoxProcurarTreinador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextFieldProcurarTreinador, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonProcurarTreinador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelConsultaTreinadorLayout.setVerticalGroup(
            jPanelConsultaTreinadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelConsultaTreinadorLayout.createSequentialGroup()
                .addComponent(jScrollPaneTreinador, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanelConsultaTreinadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelProcurarTreinador)
                    .addComponent(jTextFieldProcurarTreinador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonProcurarTreinador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxProcurarTreinador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jTabbedPaneTreinador.addTab("Consulta", jPanelConsultaTreinador);

        jLabelNomeTreinador.setText("Nome:");

        jLabelCpfTreinador.setText("CPF:");

        jLabelDataNascimentoTreinador.setText("Data Nascimento:");

        jLabelEnderecoTreinador.setText("Endereco:");

        jLabelLoginTreinador.setText("Login:");

        jLabelSenhaTreinador.setText("Senha:");

        jLabelEmailTreinador.setText("Email:");

        jLabelAdministradorTreinador.setText("É Administrador:");

        jCheckBoxAdministradorTreinador.setText("Administrador");

        javax.swing.GroupLayout jPanelAlterarTreinadorLayout = new javax.swing.GroupLayout(jPanelAlterarTreinador);
        jPanelAlterarTreinador.setLayout(jPanelAlterarTreinadorLayout);
        jPanelAlterarTreinadorLayout.setHorizontalGroup(
            jPanelAlterarTreinadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAlterarTreinadorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelAlterarTreinadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelAlterarTreinadorLayout.createSequentialGroup()
                        .addGroup(jPanelAlterarTreinadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelDataNascimentoTreinador)
                            .addComponent(jLabelCpfTreinador)
                            .addComponent(jLabelNomeTreinador)
                            .addComponent(jLabelAdministradorTreinador))
                        .addGap(97, 97, 97)
                        .addGroup(jPanelAlterarTreinadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBoxAdministradorTreinador)
                            .addGroup(jPanelAlterarTreinadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanelAlterarTreinadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jPasswordFieldSenhaTreinador)
                                    .addComponent(jTextFieldEnderecoTreinador, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jTextFieldLoginTreinador, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jTextFieldEmailTreinador, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanelAlterarTreinadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextFieldNomeTreinador, javax.swing.GroupLayout.DEFAULT_SIZE, 321, Short.MAX_VALUE)
                                    .addComponent(jTextFieldCpfTreinador)
                                    .addComponent(jTextFieldDataNascimentoTreinador, javax.swing.GroupLayout.Alignment.TRAILING)))))
                    .addComponent(jLabelSenhaTreinador)
                    .addComponent(jLabelLoginTreinador)
                    .addComponent(jLabelEnderecoTreinador)
                    .addComponent(jLabelEmailTreinador))
                .addContainerGap(61, Short.MAX_VALUE))
        );
        jPanelAlterarTreinadorLayout.setVerticalGroup(
            jPanelAlterarTreinadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAlterarTreinadorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelAlterarTreinadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNomeTreinador)
                    .addComponent(jTextFieldNomeTreinador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelAlterarTreinadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelCpfTreinador)
                    .addComponent(jTextFieldCpfTreinador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelAlterarTreinadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelDataNascimentoTreinador)
                    .addComponent(jTextFieldDataNascimentoTreinador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelAlterarTreinadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelEnderecoTreinador)
                    .addComponent(jTextFieldEnderecoTreinador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelAlterarTreinadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelLoginTreinador)
                    .addComponent(jTextFieldLoginTreinador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelAlterarTreinadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelSenhaTreinador)
                    .addComponent(jPasswordFieldSenhaTreinador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelAlterarTreinadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelEmailTreinador)
                    .addComponent(jTextFieldEmailTreinador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(jPanelAlterarTreinadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelAdministradorTreinador)
                    .addComponent(jCheckBoxAdministradorTreinador))
                .addContainerGap(74, Short.MAX_VALUE))
        );

        jTabbedPaneTreinador.addTab("Alterar", jPanelAlterarTreinador);

        jButtonCancelarTreinador.setText("Cancelar");

        jButtonConfirmarTreinador.setText("Confirmar");

        jButtonInserirTreinador.setText("Inserir");
        jButtonInserirTreinador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonInserirTreinadorActionPerformed(evt);
            }
        });

        jButtonAlterarTreinador.setText("Alterar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPaneTreinador)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonInserirTreinador)
                .addGap(18, 18, 18)
                .addComponent(jButtonAlterarTreinador)
                .addGap(18, 18, 18)
                .addComponent(jButtonExcluirTreinador)
                .addGap(18, 18, 18)
                .addComponent(jButtonConfirmarTreinador)
                .addGap(18, 18, 18)
                .addComponent(jButtonCancelarTreinador)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonFecharTreinador)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPaneTreinador)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonInserirTreinador)
                    .addComponent(jButtonAlterarTreinador)
                    .addComponent(jButtonExcluirTreinador)
                    .addComponent(jButtonFecharTreinador)
                    .addComponent(jButtonCancelarTreinador)
                    .addComponent(jButtonConfirmarTreinador))
                .addContainerGap())
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonFecharTreinadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFecharTreinadorActionPerformed
        dispose();
    }//GEN-LAST:event_jButtonFecharTreinadorActionPerformed

    private void jTextFieldProcurarTreinadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldProcurarTreinadorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldProcurarTreinadorActionPerformed

    private void jButtonInserirTreinadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonInserirTreinadorActionPerformed
        jTabbedPaneTreinador.setSelectedIndex(1);
        jTabbedPaneTreinador.setEnabledAt(0, false);
        jButtonFecharTreinador.setEnabled(false);
        jButtonConfirmarTreinador.setEnabled(true);
        jButtonCancelarTreinador.setEnabled(true);
    }//GEN-LAST:event_jButtonInserirTreinadorActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.persistence.EntityManager AcademiaVisualPUEntityManager;
    private javax.swing.JButton jButtonAlterarTreinador;
    private javax.swing.JButton jButtonCancelarTreinador;
    private javax.swing.JButton jButtonConfirmarTreinador;
    private javax.swing.JButton jButtonExcluirTreinador;
    private javax.swing.JButton jButtonFecharTreinador;
    private javax.swing.JButton jButtonInserirTreinador;
    private javax.swing.JButton jButtonProcurarTreinador;
    private javax.swing.JCheckBox jCheckBoxAdministradorTreinador;
    private javax.swing.JComboBox jComboBoxProcurarTreinador;
    private javax.swing.JLabel jLabelAdministradorTreinador;
    private javax.swing.JLabel jLabelCpfTreinador;
    private javax.swing.JLabel jLabelDataNascimentoTreinador;
    private javax.swing.JLabel jLabelEmailTreinador;
    private javax.swing.JLabel jLabelEnderecoTreinador;
    private javax.swing.JLabel jLabelLoginTreinador;
    private javax.swing.JLabel jLabelNomeTreinador;
    private javax.swing.JLabel jLabelProcurarTreinador;
    private javax.swing.JLabel jLabelSenhaTreinador;
    private javax.swing.JPanel jPanelAlterarTreinador;
    private javax.swing.JPanel jPanelConsultaTreinador;
    private javax.swing.JPasswordField jPasswordFieldSenhaTreinador;
    private javax.swing.JScrollPane jScrollPaneTreinador;
    private javax.swing.JTabbedPane jTabbedPaneTreinador;
    private javax.swing.JTable jTableTreinador;
    private javax.swing.JTextField jTextFieldCpfTreinador;
    private javax.swing.JTextField jTextFieldDataNascimentoTreinador;
    private javax.swing.JTextField jTextFieldEmailTreinador;
    private javax.swing.JTextField jTextFieldEnderecoTreinador;
    private javax.swing.JTextField jTextFieldLoginTreinador;
    private javax.swing.JTextField jTextFieldNomeTreinador;
    private javax.swing.JTextField jTextFieldProcurarTreinador;
    private java.util.List<DataBase.Treinador> treinadorList;
    private java.util.List<DataBase.Treinador> treinadorList1;
    private java.util.List<DataBase.Treinador> treinadorList2;
    private javax.persistence.Query treinadorQuery;
    private javax.persistence.Query treinadorQuery1;
    private javax.persistence.Query treinadorQuery2;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
