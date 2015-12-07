
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import academiavisual.FormPrincipal;
import javax.swing.JOptionPane;
import Autenticacao.Permissao;
import DAO.AlunoJpaController;
import DAO.TreinadorJpaController;
import DataBase.Aluno;
import DataBase.Treinador;
import java.beans.PropertyVetoException;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author afnsoo
 */
public class TelaInicial extends javax.swing.JFrame {

    /**
     * Creates new form TelaInicial
     */
    public TelaInicial(Permissao p) {
        permissao = p;
        initComponents();
        this.setLocationRelativeTo(null);
        try {
            if (FormPrincipal.TREINADORID != 0) {
                EntityManagerFactory emf = Persistence.createEntityManagerFactory("AcademiaVisualPU");
                TreinadorJpaController treinadorJpaController = new TreinadorJpaController(emf);
                Treinador treinadorLogin = (Treinador) treinadorJpaController.findTreinador(FormPrincipal.TREINADORID);
                if (treinadorLogin != null) {
                    this.setTitle("projetoAcademiaVisual  Usuario: " + treinadorLogin.getNome());
                }
            } else {
                if (FormPrincipal.ALUNOID != 0) {
                    EntityManagerFactory emf = Persistence.createEntityManagerFactory("AcademiaVisualPU");
                    AlunoJpaController alunoJpaController = new AlunoJpaController(emf);
                    Aluno alunoLogin = (Aluno) alunoJpaController.findAluno(FormPrincipal.ALUNOID);
                    if (alunoLogin != null) {
                        this.setTitle("projetoAcademiaVisual  Usuario: " + alunoLogin.getNome());
                    }
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        if (permissao.isUsuario()) {
            /*Desabilita as opções de cadastro -- que involvem a inserção de dados no DB*/
            jMenuCadastros.setEnabled(false);
            jMenuTreinos.setEnabled(false);
        } else {
            if (permissao.isTreinador()) {
                /*Desabilita as opções de aluno*/
                jMenuAluno.setEnabled(false);
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")

    private JInternalFrameCadastroAluno cadastroAluno = null;
    private JInternalFrameCadastroTreinador cadastroTreinador = null;
    private JInternalFrameCadastroModalidade cadastroModalidade = null;
    private JInternalFrameCadastroProduto cadastroProduto = null;
    private JInternalFrameCadastroAluno2 cadastroAluno2 = null;
    private JInternalFrameReportar reportar = null;
    private JInternalFrameAdicionarTreino addTreino = null;
    private JInternalFrameConsultaProdutos consultaProdutos = null;
    private JInternalFrameConsultaTreino consultaTreinos = null;
    private JInternalFrameCadastroExercicio cadastroExercicio = null;

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPaneInicial = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuArquivo = new javax.swing.JMenu();
        jMenuItemLogout = new javax.swing.JMenuItem();
        jMenuItemFechar = new javax.swing.JMenuItem();
        jMenuCadastros = new javax.swing.JMenu();
        jMenuItemCadastroAluno = new javax.swing.JMenuItem();
        jMenuItemCadastroTreinador = new javax.swing.JMenuItem();
        jMenuItemCadastroExercicio = new javax.swing.JMenuItem();
        jMenuItemCadastroModalidade = new javax.swing.JMenuItem();
        jMenuItemCadastroProduto = new javax.swing.JMenuItem();
        jMenuTreinos = new javax.swing.JMenu();
        jMenuItemAdicionarTreino = new javax.swing.JMenuItem();
        jMenuProdutos = new javax.swing.JMenu();
        jMenuItemConsultaProdutos = new javax.swing.JMenuItem();
        jMenuAluno = new javax.swing.JMenu();
        jMenuItemConsultaTreino = new javax.swing.JMenuItem();
        jMenuItemConsultaEvolucao = new javax.swing.JMenuItem();
        jMenuItemAdicionarModalidade = new javax.swing.JMenuItem();
        jMenuAjuda = new javax.swing.JMenu();
        jMenuItemReportar = new javax.swing.JMenuItem();
        jMenuItemInfo = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("projetoAcademiaVisual");
        setName("telaInicial"); // NOI18N
        setPreferredSize(new java.awt.Dimension(800, 600));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        javax.swing.GroupLayout jDesktopPaneInicialLayout = new javax.swing.GroupLayout(jDesktopPaneInicial);
        jDesktopPaneInicial.setLayout(jDesktopPaneInicialLayout);
        jDesktopPaneInicialLayout.setHorizontalGroup(
            jDesktopPaneInicialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 488, Short.MAX_VALUE)
        );
        jDesktopPaneInicialLayout.setVerticalGroup(
            jDesktopPaneInicialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 311, Short.MAX_VALUE)
        );

        jMenuArquivo.setText("Arquivo");
        jMenuArquivo.setName("arquivoMenu"); // NOI18N

        jMenuItemLogout.setText("Log out");
        jMenuItemLogout.setName("logoutMenu"); // NOI18N
        jMenuItemLogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuItemLogoutMouseClicked(evt);
            }
        });
        jMenuItemLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemLogoutActionPerformed(evt);
            }
        });
        jMenuArquivo.add(jMenuItemLogout);

        jMenuItemFechar.setText("Fechar");
        jMenuItemFechar.setName("sairMenu"); // NOI18N
        jMenuItemFechar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuItemFecharMouseClicked(evt);
            }
        });
        jMenuItemFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemFecharActionPerformed(evt);
            }
        });
        jMenuArquivo.add(jMenuItemFechar);

        jMenuBar1.add(jMenuArquivo);

        jMenuCadastros.setText("Cadastros");
        jMenuCadastros.setName("cadastroMenu"); // NOI18N

        jMenuItemCadastroAluno.setText("Cadastro Aluno");
        jMenuItemCadastroAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCadastroAlunoActionPerformed(evt);
            }
        });
        jMenuCadastros.add(jMenuItemCadastroAluno);

        jMenuItemCadastroTreinador.setText("Cadastro Treinador");
        jMenuItemCadastroTreinador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCadastroTreinadorActionPerformed(evt);
            }
        });
        jMenuCadastros.add(jMenuItemCadastroTreinador);

        jMenuItemCadastroExercicio.setText("Cadastro Exercicio");
        jMenuItemCadastroExercicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCadastroExercicioActionPerformed(evt);
            }
        });
        jMenuCadastros.add(jMenuItemCadastroExercicio);

        jMenuItemCadastroModalidade.setText("Cadastro Modalidade");
        jMenuItemCadastroModalidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCadastroModalidadeActionPerformed(evt);
            }
        });
        jMenuCadastros.add(jMenuItemCadastroModalidade);

        jMenuItemCadastroProduto.setText("Cadastro Produto");
        jMenuItemCadastroProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCadastroProdutoActionPerformed(evt);
            }
        });
        jMenuCadastros.add(jMenuItemCadastroProduto);

        jMenuBar1.add(jMenuCadastros);

        jMenuTreinos.setText("Treinos");
        jMenuTreinos.setName("treinosMenu"); // NOI18N

        jMenuItemAdicionarTreino.setText("Adicionar Treino");
        jMenuItemAdicionarTreino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAdicionarTreinoActionPerformed(evt);
            }
        });
        jMenuTreinos.add(jMenuItemAdicionarTreino);

        jMenuBar1.add(jMenuTreinos);

        jMenuProdutos.setText("Produtos");

        jMenuItemConsultaProdutos.setText("Consulta Produtos");
        jMenuItemConsultaProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemConsultaProdutosActionPerformed(evt);
            }
        });
        jMenuProdutos.add(jMenuItemConsultaProdutos);

        jMenuBar1.add(jMenuProdutos);

        jMenuAluno.setText("Aluno");

        jMenuItemConsultaTreino.setText("Consulta Treino");
        jMenuItemConsultaTreino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemConsultaTreinoActionPerformed(evt);
            }
        });
        jMenuAluno.add(jMenuItemConsultaTreino);

        jMenuItemConsultaEvolucao.setText("Grafico Evolucao");
        jMenuAluno.add(jMenuItemConsultaEvolucao);

        jMenuItemAdicionarModalidade.setText("Adicionar Modalidade");
        jMenuAluno.add(jMenuItemAdicionarModalidade);

        jMenuBar1.add(jMenuAluno);

        jMenuAjuda.setText("Ajuda");

        jMenuItemReportar.setText("Reportar");
        jMenuItemReportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemReportarActionPerformed(evt);
            }
        });
        jMenuAjuda.add(jMenuItemReportar);

        jMenuItemInfo.setText("Info");
        jMenuItemInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemInfoActionPerformed(evt);
            }
        });
        jMenuAjuda.add(jMenuItemInfo);

        jMenuBar1.add(jMenuAjuda);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPaneInicial)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPaneInicial)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItemLogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItemLogoutMouseClicked
        dispose();
        new FormPrincipal().setVisible(true);
    }//GEN-LAST:event_jMenuItemLogoutMouseClicked

    private void jMenuItemFecharMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItemFecharMouseClicked
        System.exit(0);
    }//GEN-LAST:event_jMenuItemFecharMouseClicked

    private void jMenuItemLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemLogoutActionPerformed
        dispose();
        new FormPrincipal().setVisible(true);
    }//GEN-LAST:event_jMenuItemLogoutActionPerformed

    private void jMenuItemFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemFecharActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuItemFecharActionPerformed

    private void jMenuItemInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemInfoActionPerformed
        JOptionPane.showMessageDialog(rootPane, "Em caso de duvida entre em contato:\n email: projetoacademiavisual@gmail.com\n telefone: (34) 9999-9999");
    }//GEN-LAST:event_jMenuItemInfoActionPerformed

    private void jMenuItemCadastroTreinadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCadastroTreinadorActionPerformed
        if ((cadastroTreinador == null) || (cadastroTreinador.isClosed())) {
            /*Apenas abre o jInternalFrame, se o mesmo não tiver sido criado, ou estiver fechado*/
            cadastroTreinador = new JInternalFrameCadastroTreinador();
            jDesktopPaneInicial.add(cadastroTreinador);
        }
        try {
            cadastroTreinador.setMaximum(rootPaneCheckingEnabled);
        } catch (PropertyVetoException e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }
        /*Aparece JInternalFrame */
        cadastroTreinador.setVisible(true);
    }//GEN-LAST:event_jMenuItemCadastroTreinadorActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

    }//GEN-LAST:event_formWindowOpened

    private void jMenuItemCadastroAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCadastroAlunoActionPerformed
        if ((cadastroAluno2 == null) || (cadastroAluno2.isClosed())) {
            cadastroAluno2 = new JInternalFrameCadastroAluno2();
            jDesktopPaneInicial.add(cadastroAluno2);
        }
        try {
            cadastroAluno2.setMaximum(rootPaneCheckingEnabled);
        } catch (PropertyVetoException e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }
        cadastroAluno2.setVisible(true);
    }//GEN-LAST:event_jMenuItemCadastroAlunoActionPerformed

    private void jMenuItemCadastroModalidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCadastroModalidadeActionPerformed
        if ((cadastroModalidade == null) || (cadastroModalidade.isClosed())) {
            cadastroModalidade = new JInternalFrameCadastroModalidade();
            jDesktopPaneInicial.add(cadastroModalidade);
        }
        try {
            cadastroModalidade.setMaximum(rootPaneCheckingEnabled);
        } catch (PropertyVetoException e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }
        cadastroModalidade.setVisible(true);
    }//GEN-LAST:event_jMenuItemCadastroModalidadeActionPerformed

    private void jMenuItemCadastroProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCadastroProdutoActionPerformed
        if ((cadastroProduto == null) || (cadastroProduto.isClosed())) {
            cadastroProduto = new JInternalFrameCadastroProduto();
            jDesktopPaneInicial.add(cadastroProduto);
        }
        try {
            cadastroProduto.setMaximum(rootPaneCheckingEnabled);
        } catch (PropertyVetoException e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }
        cadastroProduto.setVisible(true);
    }//GEN-LAST:event_jMenuItemCadastroProdutoActionPerformed

    private void jMenuItemReportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemReportarActionPerformed
        if ((reportar == null) || (reportar.isClosed())) {
            reportar = new JInternalFrameReportar();
            jDesktopPaneInicial.add(reportar);
        }
        try {
            reportar.setMaximum(rootPaneCheckingEnabled);
        } catch (PropertyVetoException e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }
        reportar.setVisible(true);
    }//GEN-LAST:event_jMenuItemReportarActionPerformed

    private void jMenuItemAdicionarTreinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemAdicionarTreinoActionPerformed
        if ((addTreino == null) || (addTreino.isClosed())) {
            addTreino = new JInternalFrameAdicionarTreino();
            jDesktopPaneInicial.add(addTreino);
        }
        try {
            addTreino.setMaximum(rootPaneCheckingEnabled);
        } catch (PropertyVetoException e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }
        addTreino.setVisible(true);
    }//GEN-LAST:event_jMenuItemAdicionarTreinoActionPerformed

    private void jMenuItemConsultaProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemConsultaProdutosActionPerformed
        if ((consultaProdutos == null) || (consultaProdutos.isClosed())) {
            consultaProdutos = new JInternalFrameConsultaProdutos();
            jDesktopPaneInicial.add(consultaProdutos);
        }
        try {
            consultaProdutos.setMaximum(rootPaneCheckingEnabled);
        } catch (PropertyVetoException e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }
        consultaProdutos.setVisible(true);
    }//GEN-LAST:event_jMenuItemConsultaProdutosActionPerformed

    private void jMenuItemConsultaTreinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemConsultaTreinoActionPerformed
        if ((consultaTreinos == null) || (consultaTreinos.isClosed())) {
            consultaTreinos = new JInternalFrameConsultaTreino();
            jDesktopPaneInicial.add(consultaTreinos);
        }
        try {
            consultaTreinos.setMaximum(rootPaneCheckingEnabled);
        } catch (PropertyVetoException e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }
        consultaTreinos.setVisible(true);
    }//GEN-LAST:event_jMenuItemConsultaTreinoActionPerformed

    private void jMenuItemCadastroExercicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCadastroExercicioActionPerformed
        if ((cadastroExercicio == null) || (cadastroExercicio.isClosed())) {
            cadastroExercicio = new JInternalFrameCadastroExercicio();
            jDesktopPaneInicial.add(cadastroExercicio);
        }
        try {
            cadastroExercicio.setMaximum(rootPaneCheckingEnabled);
        } catch (PropertyVetoException e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }
        cadastroExercicio.setVisible(true);
    }//GEN-LAST:event_jMenuItemCadastroExercicioActionPerformed

//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new TelaInicial().setVisible(true);
//            }
//        });
//    }
    //Para o sistema de permissão
    Autenticacao.Permissao permissao;

    //funcao para verificacao de treinador administrador
    public static boolean verificarAdministrador() {
        boolean administrador = true;        
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("AcademiaVisualPU");
            TreinadorJpaController treinadorJpaController = new TreinadorJpaController(emf);
            Treinador treinadorLogin = (Treinador) treinadorJpaController.findTreinador(FormPrincipal.TREINADORID);
            if (treinadorLogin != null) {
                if (treinadorLogin.getAdministrador() == 1) {
                    administrador = false;
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }        
        return administrador;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane jDesktopPaneInicial;
    private javax.swing.JMenu jMenuAjuda;
    private javax.swing.JMenu jMenuAluno;
    private javax.swing.JMenu jMenuArquivo;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuCadastros;
    private javax.swing.JMenuItem jMenuItemAdicionarModalidade;
    private javax.swing.JMenuItem jMenuItemAdicionarTreino;
    private javax.swing.JMenuItem jMenuItemCadastroAluno;
    private javax.swing.JMenuItem jMenuItemCadastroExercicio;
    private javax.swing.JMenuItem jMenuItemCadastroModalidade;
    private javax.swing.JMenuItem jMenuItemCadastroProduto;
    private javax.swing.JMenuItem jMenuItemCadastroTreinador;
    private javax.swing.JMenuItem jMenuItemConsultaEvolucao;
    private javax.swing.JMenuItem jMenuItemConsultaProdutos;
    private javax.swing.JMenuItem jMenuItemConsultaTreino;
    private javax.swing.JMenuItem jMenuItemFechar;
    private javax.swing.JMenuItem jMenuItemInfo;
    private javax.swing.JMenuItem jMenuItemLogout;
    private javax.swing.JMenuItem jMenuItemReportar;
    private javax.swing.JMenu jMenuProdutos;
    private javax.swing.JMenu jMenuTreinos;
    // End of variables declaration//GEN-END:variables
}
