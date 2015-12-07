/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import DAO.AlunoJpaController;
import DataBase.Aluno;
import DataBase.Exercicios;
import DataBase.Modalidades;
import DataBase.Treinos;
import com.google.common.base.Charsets;
import com.google.common.hash.Hashing;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.JOptionPane;

/**
 *
 * @author afnsoo
 */
public class JInternalFrameAdicionarTreino extends javax.swing.JInternalFrame {

    /**
     * Creates new form JInternalFrameAdicionarTreino
     */
    public JInternalFrameAdicionarTreino() {
        initComponents();
        abaConsulta();
        System.out.println("TreinosList Class : " + treinosList.getClass().getName());
        System.out.println("Size: " + treinosList.size());
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
        treinosQuery = java.beans.Beans.isDesignTime() ? null : AcademiaVisualPUEntityManager.createQuery("SELECT t FROM Treinos t");
        treinosList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : treinosQuery.getResultList();
        jTabbedPaneAdicionarTreino = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableTreino = new javax.swing.JTable();
        jLabelProcurarTreino = new javax.swing.JLabel();
        jComboBoxProcurarTreino = new javax.swing.JComboBox();
        jTextFieldProcurarTreino = new javax.swing.JTextField();
        jButtonProcurarTreino = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextFieldIdTreino = new javax.swing.JTextField();
        jTextFieldAlunoTreino = new javax.swing.JTextField();
        jTextFieldDiaTreino = new javax.swing.JTextField();
        jTextFieldExercicioTreino = new javax.swing.JTextField();
        jTextFieldSeriesTreino = new javax.swing.JTextField();
        jTextFieldRepeticoesTreino = new javax.swing.JTextField();
        jTextFieldModalidadeTreino = new javax.swing.JTextField();
        jButtonEscolhaAluno = new javax.swing.JButton();
        jButtonEscolhaExercicio = new javax.swing.JButton();
        jButtonEscolhaModalidade = new javax.swing.JButton();
        jButtonInserirTreino = new javax.swing.JButton();
        jButtonAlterarTreino = new javax.swing.JButton();
        jButtonExcluirTreino = new javax.swing.JButton();
        jButtonConfirmarTreino = new javax.swing.JButton();
        jButtonCancelarTreino = new javax.swing.JButton();
        jButtonFecharTreino = new javax.swing.JButton();

        setTitle("Adicionar Treino");
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameOpened(evt);
            }
        });

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, treinosList, jTableTreino);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${id}"));
        columnBinding.setColumnName("Id");
        columnBinding.setColumnClass(Integer.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${alunoId}"));
        columnBinding.setColumnName("Aluno Id");
        columnBinding.setColumnClass(DataBase.Aluno.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${dia}"));
        columnBinding.setColumnName("Dia");
        columnBinding.setColumnClass(Integer.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${exercicioId}"));
        columnBinding.setColumnName("Exercicio Id");
        columnBinding.setColumnClass(DataBase.Exercicios.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${series}"));
        columnBinding.setColumnName("Series");
        columnBinding.setColumnClass(Integer.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${repeticoes}"));
        columnBinding.setColumnName("Repeticoes");
        columnBinding.setColumnClass(Integer.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${modalidadeId}"));
        columnBinding.setColumnName("Modalidade Id");
        columnBinding.setColumnClass(DataBase.Modalidades.class);
        columnBinding.setEditable(false);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jScrollPane1.setViewportView(jTableTreino);

        jLabelProcurarTreino.setText("Opção de busca");

        jComboBoxProcurarTreino.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Id", "Nome" }));

        jButtonProcurarTreino.setText("Buscar");
        jButtonProcurarTreino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonProcurarTreinoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabelProcurarTreino)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jComboBoxProcurarTreino, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldProcurarTreino, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonProcurarTreino)
                .addContainerGap(148, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldProcurarTreino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonProcurarTreino)
                    .addComponent(jComboBoxProcurarTreino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelProcurarTreino))
                .addContainerGap())
        );

        jTabbedPaneAdicionarTreino.addTab("Consultar", jPanel1);

        jLabel1.setText("ID");

        jLabel2.setText("Aluno");

        jLabel3.setText("Dia");

        jLabel4.setText("Exercicio");

        jLabel5.setText("Series");

        jLabel6.setText("Repeticoes");

        jLabel7.setText("Modalidade");

        jButtonEscolhaAluno.setText("...");
        jButtonEscolhaAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEscolhaAlunoActionPerformed(evt);
            }
        });

        jButtonEscolhaExercicio.setText("...");
        jButtonEscolhaExercicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEscolhaExercicioActionPerformed(evt);
            }
        });

        jButtonEscolhaModalidade.setText("...");
        jButtonEscolhaModalidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEscolhaModalidadeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jTextFieldAlunoTreino, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonEscolhaAluno))
                    .addComponent(jTextFieldIdTreino, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldDiaTreino, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jTextFieldExercicioTreino, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonEscolhaExercicio))
                    .addComponent(jTextFieldSeriesTreino, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldRepeticoesTreino, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jTextFieldModalidadeTreino, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonEscolhaModalidade)))
                .addContainerGap(158, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldIdTreino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldAlunoTreino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonEscolhaAluno))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldDiaTreino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextFieldExercicioTreino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonEscolhaExercicio))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextFieldSeriesTreino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextFieldRepeticoesTreino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTextFieldModalidadeTreino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonEscolhaModalidade))
                .addContainerGap(63, Short.MAX_VALUE))
        );

        jTabbedPaneAdicionarTreino.addTab("Alterar", jPanel2);

        jButtonInserirTreino.setText("Inserir");
        jButtonInserirTreino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonInserirTreinoActionPerformed(evt);
            }
        });

        jButtonAlterarTreino.setText("Alterar");
        jButtonAlterarTreino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAlterarTreinoActionPerformed(evt);
            }
        });

        jButtonExcluirTreino.setText("Excluir");
        jButtonExcluirTreino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirTreinoActionPerformed(evt);
            }
        });

        jButtonConfirmarTreino.setText("Confirmar");
        jButtonConfirmarTreino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConfirmarTreinoActionPerformed(evt);
            }
        });

        jButtonCancelarTreino.setText("Cancelar");
        jButtonCancelarTreino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarTreinoActionPerformed(evt);
            }
        });

        jButtonFecharTreino.setText("Fechar");
        jButtonFecharTreino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFecharTreinoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPaneAdicionarTreino)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonInserirTreino)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonAlterarTreino)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonExcluirTreino)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonConfirmarTreino)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonCancelarTreino)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonFecharTreino)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPaneAdicionarTreino, javax.swing.GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonInserirTreino)
                    .addComponent(jButtonAlterarTreino)
                    .addComponent(jButtonExcluirTreino)
                    .addComponent(jButtonConfirmarTreino)
                    .addComponent(jButtonCancelarTreino)
                    .addComponent(jButtonFecharTreino))
                .addContainerGap())
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    Aluno inserirAluno = new Aluno();
    Exercicios inserirExercicio = new Exercicios();
    Modalidades inserirModalidade = new Modalidades();
    
    private void jButtonEscolhaAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEscolhaAlunoActionPerformed
        JDialogEscolherAluno alunoE = new JDialogEscolherAluno(null, closable);
        alunoE.setModal(true);
        alunoE.setVisible(true);
        if (alunoE.SELECIONADO) {
            inserirAluno = alunoE.getAluno();
            jTextFieldAlunoTreino.setText(alunoE.getAluno().getNome());             
        }
        alunoE.dispose();
    }//GEN-LAST:event_jButtonEscolhaAlunoActionPerformed

    private void jButtonInserirTreinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonInserirTreinoActionPerformed
        flagAnterior = INSERIR;
        popularCamposAlterar(null);        
        abaAlterar();
    }//GEN-LAST:event_jButtonInserirTreinoActionPerformed

    private void jButtonAlterarTreinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAlterarTreinoActionPerformed
        if (!treinosList.isEmpty() && jTableTreino.getSelectedRow() != -1) {
            flagAnterior = ALTERAR;
            treinoAlterar = treinosList.get(jTableTreino.getSelectedRow());
            popularCamposAlterar(treinoAlterar);
            abaAlterar();
        } else {
            JOptionPane.showMessageDialog(null, "Exclusão cancelada !");
        }
    }//GEN-LAST:event_jButtonAlterarTreinoActionPerformed

    private void jButtonExcluirTreinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirTreinoActionPerformed
        if (!treinosList.isEmpty() && jTableTreino.getSelectedRow() != -1) {
            int option = JOptionPane.showConfirmDialog(this, "Verifique com atenção os dados que deseja excluir!\n"
                    + "Clique em sim se esse for mesmo o treino que deseja excluir.\n"
                    + "Clique em cancelar para voltar.");
            if (option == JOptionPane.YES_OPTION) {
                try {
                    /*
                     EXCLUIR O USUARIO DE TODOS AS TABELAS QUE UTILIZAM O MESMO !
                     Acho que não é necessário -- Luccas.
                     */
                    treinosList.get(jTableTreino.getSelectedRow()).excluir();
                    treinosList.remove(jTableTreino.getSelectedRow());
                    jTableTreino.updateUI();
                    jTableTreino.repaint();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Exclusão cancelada !");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um aluno !");
        }
    }//GEN-LAST:event_jButtonExcluirTreinoActionPerformed

    private void jButtonConfirmarTreinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConfirmarTreinoActionPerformed
        boolean atualizacaoFeita = false; /*Indica que a atualização/inserção foi feita com sucesso,
         mantendo a aba de alteração focada.
         */

        if (flagAnterior == INSERIR) {
            //Verifica se os campos estão corretos antes de modificá-los.
            if (validacaoDeCampos()) {
                treino = new Treinos(); //Cria um aluno vazio
                popularObjeto(treino); //Popula o objeto
                //Insere o objeto no banco de dados
                treino.incluir();
                /*Coisas do bind: Para adicionar elemento por ultimo na tabela inserir na penultima posição
                 tipo: list.size() - 1 -> Não faz sentido, mas é assim que o bind funciona...
                 */
                treinosList.add(treinosList.size() - 1, treino);
                jTableTreino.repaint();
                atualizacaoFeita = true;
            }
        }
        if (flagAnterior == ALTERAR) {
            //Verifica se os campos estão corretos para atualizá-los
            if (validacaoDeCampos()) {
                popularObjeto(treinoAlterar);
                //altera o aluno no banco de dados
                treinoAlterar.alterar();
                jTableTreino.repaint();
                atualizacaoFeita = true;
            }
        }
        if (atualizacaoFeita) {
            abaConsulta();
        }
    }//GEN-LAST:event_jButtonConfirmarTreinoActionPerformed

    private void jButtonCancelarTreinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarTreinoActionPerformed
       abaConsulta();
    }//GEN-LAST:event_jButtonCancelarTreinoActionPerformed

    private void jButtonFecharTreinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFecharTreinoActionPerformed
        dispose();
    }//GEN-LAST:event_jButtonFecharTreinoActionPerformed

    private void jButtonProcurarTreinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonProcurarTreinoActionPerformed
        String[] sql = {"", "SELECT t FROM Treinos t WHERE t.nome LIKE :nome "};
        try {
            Query query = null;
            if (jTextFieldProcurarTreino.getText().length() > 0) {
                if (jComboBoxProcurarTreino.getSelectedIndex() == 0) {
                    query = AcademiaVisualPUEntityManager.createNamedQuery("Treinos.findById");
                    query.setParameter("id", Long.valueOf(jTextFieldProcurarTreino.getText()));
                }
                if (jComboBoxProcurarTreino.getSelectedIndex() == 1) {
                    query = AcademiaVisualPUEntityManager.createQuery(sql[1]);
                    query.setParameter("nome", '%' + jTextFieldProcurarTreino.getText() + '%');
                }
            } else {
                query = treinosQuery;
            }
            treinosList.clear();
            treinosList.addAll(query.getResultList());
            jTableTreino.updateUI();
            jTableTreino.repaint();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }//GEN-LAST:event_jButtonProcurarTreinoActionPerformed

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        try {
            if (TelaInicial.verificarAdministrador()) {
                jButtonInserirTreino.setEnabled(false);
                jButtonAlterarTreino.setEnabled(false);
                jButtonExcluirTreino.setEnabled(false);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_formInternalFrameOpened

    private void jButtonEscolhaExercicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEscolhaExercicioActionPerformed
        JDialogEscolherExercicio exercicioE = new JDialogEscolherExercicio(null, closable);
        exercicioE.setModal(true);
        exercicioE.setVisible(true);
        if (exercicioE.SELECIONADO) {
            inserirExercicio = exercicioE.getExercicio();
            jTextFieldExercicioTreino.setText(exercicioE.getExercicio().getNome());             
        }
        exercicioE.dispose();
    }//GEN-LAST:event_jButtonEscolhaExercicioActionPerformed

    private void jButtonEscolhaModalidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEscolhaModalidadeActionPerformed
        JDialogEscolherModalidade modalidadeE = new JDialogEscolherModalidade(null, closable);
        modalidadeE.setModal(true);
        modalidadeE.setVisible(true);
        if (modalidadeE.SELECIONADO) {
            inserirModalidade = modalidadeE.getModalidade();
            jTextFieldModalidadeTreino.setText(modalidadeE.getModalidade().getNome());             
        }
        modalidadeE.dispose();
    }//GEN-LAST:event_jButtonEscolhaModalidadeActionPerformed

    //Bind automático não funiona como o esperado. Os métodos abaixo circulam este problema.
    /**
     * Popula os textField da aba Alterar.
     *
     * @param a Fonte dos dados para o textField, caso seja null os campos serão
     * esvaziados.
     */
    private void popularCamposAlterar(Treinos t) {
        if (t == null) {
            jTextFieldAlunoTreino.setText("");
            jTextFieldDiaTreino.setText("");
            jTextFieldExercicioTreino.setText("");
            jTextFieldSeriesTreino.setText("");
            jTextFieldRepeticoesTreino.setText("");
            jTextFieldModalidadeTreino.setText("");
        } else {            
            jTextFieldAlunoTreino.setText(t.getAlunoId().getNome());
            jTextFieldDiaTreino.setText(Integer.toString(t.getDia()));
            jTextFieldExercicioTreino.setText(t.getExercicioId().getNome());
            jTextFieldSeriesTreino.setText(Integer.toString(t.getSeries()));
            jTextFieldRepeticoesTreino.setText(Integer.toString(t.getRepeticoes()));
            jTextFieldModalidadeTreino.setText(t.getModalidadeId().getNome());
        }
    }

    /**
     * Após a edição do objeto pega dados da aba Alterar e coloca no objeto.
     *
     * @param a Objeto a ser populado.
     */
    private void popularObjeto(Treinos t) {
        //TODO: Garantir que @param não é nulo
        /*O campo ID é gerado pelo banco de dados*/
               
        t.setAlunoId(inserirAluno); 
        t.setExercicioId(inserirExercicio);
        t.setModalidadeId(inserirModalidade); 
        t.setDia(Integer.parseInt(jTextFieldDiaTreino.getText()));
        t.setRepeticoes(Integer.parseInt(jTextFieldRepeticoesTreino.getText()));
        t.setSeries(Integer.parseInt(jTextFieldSeriesTreino.getText()));

    }

    /**
     * Entra na Aba de Consulta
     */
    private void abaConsulta() {
        jTabbedPaneAdicionarTreino.setSelectedIndex(0);
        jTabbedPaneAdicionarTreino.setEnabledAt(0, true);
        jTabbedPaneAdicionarTreino.setEnabledAt(1, false);
        jButtonConfirmarTreino.setEnabled(false);
        jButtonCancelarTreino.setEnabled(false);
        jButtonInserirTreino.setEnabled(true);
        jButtonAlterarTreino.setEnabled(true);
        jButtonExcluirTreino.setEnabled(true);
    }

    /**
     * Entra na Aba de Alterar
     */
    private void abaAlterar() {
        jTabbedPaneAdicionarTreino.setSelectedIndex(1);
        jTabbedPaneAdicionarTreino.setEnabledAt(1, true);
        jTabbedPaneAdicionarTreino.setEnabledAt(0, false);
        jButtonInserirTreino.setEnabled(false);
        jButtonAlterarTreino.setEnabled(false);
        jButtonExcluirTreino.setEnabled(false);
        jButtonConfirmarTreino.setEnabled(true);
        jButtonCancelarTreino.setEnabled(true);

    }

    /**
     * Valida os campos de acordo com as normas:
     * <ul>
     * <li> EMAIL: válido, não nulo e menor que 40;
     * <li> NOME: não nulo e menor que 40;
     * <li> CPF: Estar no formato nnn.nnn.nnn-nn -> n = número qualquer TODO:
     * Validação!
     * <li> LOGIN: serm menor que 40 e único(É realizado consulta no banco de
     * dados);
     * <li> PASSWORD: deve ser maior que 6, menor que 15 e não nulo;
     * <li> ENDEREÇO: Campo não dever ser nulo e menor que 40 caracteres.
     * </ul>
     *
     * @return <b>true</b> caso passe na validação, <b>false</b> caso contrário.
     */
    private boolean validacaoDeCampos() {
        boolean valido = true;
        String msgErro = "";
        String campo;
       
        //Checa o campo repeticoes
        campo = jTextFieldRepeticoesTreino.getText();
        if (Integer.parseInt(campo) <= 0) {
            valido = false;
            msgErro += "Repetições invalidas. Devem ser maior que zero\n";
            jTextFieldRepeticoesTreino.setText("");// Limpa o campo de repeticoes
        }

        //Checa o campo series
        campo = jTextFieldSeriesTreino.getText();
        if (Integer.parseInt(campo) <= 0) {
            valido = false;
            msgErro += "Series invalidas. Devem ser maior que zero\n";;
            jTextFieldSeriesTreino.setText("");; //Limpa campo series
        }
        
        if (!valido) {
            JOptionPane.showMessageDialog(null, msgErro, "Campos Errados!", JOptionPane.ERROR_MESSAGE);
        }
        return valido;
    }
    private int flagAnterior; //Define qual botão foi clicado
    private Treinos treino; //Endereça objetos criados

    //Flags para identificar que botão foi clicado anteriormente.
    private final int INSERIR = 1;
    private final int ALTERAR = 2;
    
    private Treinos treinoAlterar;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.persistence.EntityManager AcademiaVisualPUEntityManager;
    private javax.swing.JButton jButtonAlterarTreino;
    private javax.swing.JButton jButtonCancelarTreino;
    private javax.swing.JButton jButtonConfirmarTreino;
    private javax.swing.JButton jButtonEscolhaAluno;
    private javax.swing.JButton jButtonEscolhaExercicio;
    private javax.swing.JButton jButtonEscolhaModalidade;
    private javax.swing.JButton jButtonExcluirTreino;
    private javax.swing.JButton jButtonFecharTreino;
    private javax.swing.JButton jButtonInserirTreino;
    private javax.swing.JButton jButtonProcurarTreino;
    private javax.swing.JComboBox jComboBoxProcurarTreino;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabelProcurarTreino;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPaneAdicionarTreino;
    private javax.swing.JTable jTableTreino;
    private javax.swing.JTextField jTextFieldAlunoTreino;
    private javax.swing.JTextField jTextFieldDiaTreino;
    private javax.swing.JTextField jTextFieldExercicioTreino;
    private javax.swing.JTextField jTextFieldIdTreino;
    private javax.swing.JTextField jTextFieldModalidadeTreino;
    private javax.swing.JTextField jTextFieldProcurarTreino;
    private javax.swing.JTextField jTextFieldRepeticoesTreino;
    private javax.swing.JTextField jTextFieldSeriesTreino;
    private java.util.List<DataBase.Treinos> treinosList;
    private javax.persistence.Query treinosQuery;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
