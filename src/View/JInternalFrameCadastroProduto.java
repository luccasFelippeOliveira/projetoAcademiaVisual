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
public class JInternalFrameCadastroProduto extends javax.swing.JInternalFrame {

    /**
     * Creates new form JInternalFrameCadastroProduto
     */
    public JInternalFrameCadastroProduto() {
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

        jButtonExcluirAluno = new javax.swing.JButton();
        jButtonFecharAluno = new javax.swing.JButton();
        jTabbedPaneAluno = new javax.swing.JTabbedPane();
        jPanelConsultaAluno = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableAluno = new javax.swing.JTable();
        jLabelProcurarAluno = new javax.swing.JLabel();
        jTextFieldProcurarAluno = new javax.swing.JTextField();
        jComboBoxProcurarAluno = new javax.swing.JComboBox();
        jButtonProcurarAluno = new javax.swing.JButton();
        jPanelAlterarAluno = new javax.swing.JPanel();
        jLabelNomeAluno = new javax.swing.JLabel();
        jLabelCpfAluno = new javax.swing.JLabel();
        jLabelDataNascimentoAluno = new javax.swing.JLabel();
        jLabelPesoAluno = new javax.swing.JLabel();
        jLabelAlturaAluno = new javax.swing.JLabel();
        jLabelEnderecoAluno = new javax.swing.JLabel();
        jLabelLoginAluno = new javax.swing.JLabel();
        jLabelSenhaAluno = new javax.swing.JLabel();
        jLabelEmailAluno = new javax.swing.JLabel();
        jLabelValidadeAluno = new javax.swing.JLabel();
        jTextFieldNomeAluno = new javax.swing.JTextField();
        jTextFieldCpfAluno = new javax.swing.JTextField();
        jTextFieldDataNascimentoAluno = new javax.swing.JTextField();
        jTextFieldPesoAluno = new javax.swing.JTextField();
        jTextFieldAlturaAluno = new javax.swing.JTextField();
        jTextFieldEnderecoAluno = new javax.swing.JTextField();
        jTextFieldLoginAluno = new javax.swing.JTextField();
        jTextFieldEmailAluno = new javax.swing.JTextField();
        jTextFieldValidadeAluno = new javax.swing.JTextField();
        jButtonBuscarDataAluno = new javax.swing.JButton();
        jPasswordFieldSenhaAluno = new javax.swing.JPasswordField();
        jButtonCancelarAluno = new javax.swing.JButton();
        jButtonConfirmarAluno = new javax.swing.JButton();
        jButtonInserirAluno = new javax.swing.JButton();
        jButtonAlterarAluno = new javax.swing.JButton();

        setTitle("Cadastro Produto");

        jButtonExcluirAluno.setText("Excluir");

        jButtonFecharAluno.setText("Fechar");
        jButtonFecharAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFecharAlunoActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(jTableAluno);

        jLabelProcurarAluno.setText("Opção De Busca");

        jTextFieldProcurarAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldProcurarAlunoActionPerformed(evt);
            }
        });

        jComboBoxProcurarAluno.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Id", "Nome", "CPF", "Validade" }));

        jButtonProcurarAluno.setText("Buscar");
        jButtonProcurarAluno.setMaximumSize(new java.awt.Dimension(75, 23));
        jButtonProcurarAluno.setMinimumSize(new java.awt.Dimension(75, 23));
        jButtonProcurarAluno.setPreferredSize(new java.awt.Dimension(75, 23));

        javax.swing.GroupLayout jPanelConsultaAlunoLayout = new javax.swing.GroupLayout(jPanelConsultaAluno);
        jPanelConsultaAluno.setLayout(jPanelConsultaAlunoLayout);
        jPanelConsultaAlunoLayout.setHorizontalGroup(
            jPanelConsultaAlunoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 593, Short.MAX_VALUE)
            .addGroup(jPanelConsultaAlunoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelProcurarAluno)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jComboBoxProcurarAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextFieldProcurarAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonProcurarAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelConsultaAlunoLayout.setVerticalGroup(
            jPanelConsultaAlunoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelConsultaAlunoLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanelConsultaAlunoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelProcurarAluno)
                    .addComponent(jTextFieldProcurarAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonProcurarAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxProcurarAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jTabbedPaneAluno.addTab("Consulta", jPanelConsultaAluno);

        jLabelNomeAluno.setText("Nome:");

        jLabelCpfAluno.setText("CPF:");

        jLabelDataNascimentoAluno.setText("Data Nascimento:");

        jLabelPesoAluno.setText("Peso:");

        jLabelAlturaAluno.setText("Altura:");

        jLabelEnderecoAluno.setText("Endereco:");

        jLabelLoginAluno.setText("Login:");

        jLabelSenhaAluno.setText("Senha:");

        jLabelEmailAluno.setText("Email:");

        jLabelValidadeAluno.setText("Validade:");

        jButtonBuscarDataAluno.setText("...");

        javax.swing.GroupLayout jPanelAlterarAlunoLayout = new javax.swing.GroupLayout(jPanelAlterarAluno);
        jPanelAlterarAluno.setLayout(jPanelAlterarAlunoLayout);
        jPanelAlterarAlunoLayout.setHorizontalGroup(
            jPanelAlterarAlunoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAlterarAlunoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelAlterarAlunoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelSenhaAluno)
                    .addComponent(jLabelLoginAluno)
                    .addComponent(jLabelEnderecoAluno)
                    .addComponent(jLabelAlturaAluno)
                    .addComponent(jLabelPesoAluno)
                    .addComponent(jLabelDataNascimentoAluno)
                    .addComponent(jLabelCpfAluno)
                    .addComponent(jLabelEmailAluno)
                    .addComponent(jLabelValidadeAluno)
                    .addComponent(jLabelNomeAluno))
                .addGap(97, 97, 97)
                .addGroup(jPanelAlterarAlunoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPasswordFieldSenhaAluno, javax.swing.GroupLayout.DEFAULT_SIZE, 321, Short.MAX_VALUE)
                    .addComponent(jTextFieldNomeAluno)
                    .addComponent(jTextFieldCpfAluno)
                    .addComponent(jTextFieldDataNascimentoAluno, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextFieldPesoAluno, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextFieldAlturaAluno, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextFieldEnderecoAluno, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextFieldLoginAluno, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextFieldEmailAluno, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 321, Short.MAX_VALUE)
                    .addComponent(jTextFieldValidadeAluno, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonBuscarDataAluno)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelAlterarAlunoLayout.setVerticalGroup(
            jPanelAlterarAlunoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAlterarAlunoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelAlterarAlunoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNomeAluno)
                    .addComponent(jTextFieldNomeAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelAlterarAlunoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelCpfAluno)
                    .addComponent(jTextFieldCpfAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelAlterarAlunoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelDataNascimentoAluno)
                    .addComponent(jTextFieldDataNascimentoAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelAlterarAlunoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelPesoAluno)
                    .addComponent(jTextFieldPesoAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelAlterarAlunoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelAlturaAluno)
                    .addComponent(jTextFieldAlturaAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelAlterarAlunoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelEnderecoAluno)
                    .addComponent(jTextFieldEnderecoAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelAlterarAlunoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelLoginAluno)
                    .addComponent(jTextFieldLoginAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelAlterarAlunoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelSenhaAluno)
                    .addComponent(jPasswordFieldSenhaAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelAlterarAlunoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelEmailAluno)
                    .addComponent(jTextFieldEmailAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelAlterarAlunoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelValidadeAluno)
                    .addComponent(jTextFieldValidadeAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonBuscarDataAluno))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPaneAluno.addTab("Alterar", jPanelAlterarAluno);

        jButtonCancelarAluno.setText("Cancelar");

        jButtonConfirmarAluno.setText("Confirmar");

        jButtonInserirAluno.setText("Inserir");
        jButtonInserirAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonInserirAlunoActionPerformed(evt);
            }
        });

        jButtonAlterarAluno.setText("Alterar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPaneAluno)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonInserirAluno)
                .addGap(18, 18, 18)
                .addComponent(jButtonAlterarAluno)
                .addGap(18, 18, 18)
                .addComponent(jButtonExcluirAluno)
                .addGap(18, 18, 18)
                .addComponent(jButtonConfirmarAluno)
                .addGap(18, 18, 18)
                .addComponent(jButtonCancelarAluno)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonFecharAluno)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPaneAluno)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonInserirAluno)
                    .addComponent(jButtonAlterarAluno)
                    .addComponent(jButtonExcluirAluno)
                    .addComponent(jButtonFecharAluno)
                    .addComponent(jButtonCancelarAluno)
                    .addComponent(jButtonConfirmarAluno))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonFecharAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFecharAlunoActionPerformed
        dispose();
    }//GEN-LAST:event_jButtonFecharAlunoActionPerformed

    private void jTextFieldProcurarAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldProcurarAlunoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldProcurarAlunoActionPerformed

    private void jButtonInserirAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonInserirAlunoActionPerformed
        jTabbedPaneAluno.setSelectedIndex(1);
        jTabbedPaneAluno.setEnabledAt(0, false);
        jButtonFecharAluno.setEnabled(false);
        jButtonConfirmarAluno.setEnabled(true);
        jButtonCancelarAluno.setEnabled(true);
    }//GEN-LAST:event_jButtonInserirAlunoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAlterarAluno;
    private javax.swing.JButton jButtonBuscarDataAluno;
    private javax.swing.JButton jButtonCancelarAluno;
    private javax.swing.JButton jButtonConfirmarAluno;
    private javax.swing.JButton jButtonExcluirAluno;
    private javax.swing.JButton jButtonFecharAluno;
    private javax.swing.JButton jButtonInserirAluno;
    private javax.swing.JButton jButtonProcurarAluno;
    private javax.swing.JComboBox jComboBoxProcurarAluno;
    private javax.swing.JLabel jLabelAlturaAluno;
    private javax.swing.JLabel jLabelCpfAluno;
    private javax.swing.JLabel jLabelDataNascimentoAluno;
    private javax.swing.JLabel jLabelEmailAluno;
    private javax.swing.JLabel jLabelEnderecoAluno;
    private javax.swing.JLabel jLabelLoginAluno;
    private javax.swing.JLabel jLabelNomeAluno;
    private javax.swing.JLabel jLabelPesoAluno;
    private javax.swing.JLabel jLabelProcurarAluno;
    private javax.swing.JLabel jLabelSenhaAluno;
    private javax.swing.JLabel jLabelValidadeAluno;
    private javax.swing.JPanel jPanelAlterarAluno;
    private javax.swing.JPanel jPanelConsultaAluno;
    private javax.swing.JPasswordField jPasswordFieldSenhaAluno;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPaneAluno;
    private javax.swing.JTable jTableAluno;
    private javax.swing.JTextField jTextFieldAlturaAluno;
    private javax.swing.JTextField jTextFieldCpfAluno;
    private javax.swing.JTextField jTextFieldDataNascimentoAluno;
    private javax.swing.JTextField jTextFieldEmailAluno;
    private javax.swing.JTextField jTextFieldEnderecoAluno;
    private javax.swing.JTextField jTextFieldLoginAluno;
    private javax.swing.JTextField jTextFieldNomeAluno;
    private javax.swing.JTextField jTextFieldPesoAluno;
    private javax.swing.JTextField jTextFieldProcurarAluno;
    private javax.swing.JTextField jTextFieldValidadeAluno;
    // End of variables declaration//GEN-END:variables
}
