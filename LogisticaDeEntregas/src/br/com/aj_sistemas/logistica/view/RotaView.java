package br.com.aj_sistemas.logistica.view;

import br.com.aj_sistemas.logistica.controller.RotaController;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import br.com.aj_sistemas.logistica.model.RotaModel;
import br.com.aj_sistemas.logistica.utils.GeradorDeRelatorio;
import javax.swing.ImageIcon;

/**
 *
 * @author Alisson Jaques
 */
public class RotaView extends javax.swing.JInternalFrame {

    /**
     * Creates new form RotaView
     */
    public RotaView() {
        this.setFrameIcon(new ImageIcon("src\\br\\com\\aj_sistemas\\logistica\\img\\truck-icon.png"));
        initComponents();
        preencherTabela();
    }

    private void preencherTabela() {
        RotaController controle = new RotaController();
        ArrayList<RotaModel> lista = controle.selecionarTodos();
        DefaultTableModel modelo = (DefaultTableModel) getJtRota().getModel();
        modelo.setRowCount(0);
        lista.forEach((f) -> {
            modelo.addRow(new Object[]{
                f.getIdRota(),
                f.getDescricao()
            });
        });
    }

    public void limparCampos() {
        getJtxIdRota().setText("");
        getJtxDescricao().setText("");
        getJbEditar().setEnabled(false);
        getJbExcluir().setEnabled(false);
    }

    public boolean verificarCampos() {
        if (getJtxIdRota().getText().equals("")) {
            return true;
        } else {
            return getJtxDescricao().getText().equals("");
        }
    }

    public boolean verifica() {
        return getJtxDescricao().getText().equals("");
    }

    public void requisitaFoco() {
        if (getJtxIdRota().getText().equals("")) {
            getJtxIdRota().requestFocus();
        } else {
            getJtxDescricao().requestFocus();
        }
    }

    public boolean verificaId(String idRota) {
        if (getJtxIdRota().getText().equals("")) {
            return false;
        } else {
            RotaController controle = new RotaController();
            ArrayList<RotaModel> lista = controle.selecionarTodos();
            if (lista.stream().anyMatch((rota) -> (rota.getIdRota() == Integer.parseInt(idRota)))) {
                return true;
            }
        }
        return false;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jlIdRota = new javax.swing.JLabel();
        jlDescricao = new javax.swing.JLabel();
        jtxIdRota = new javax.swing.JTextField();
        jtxDescricao = new javax.swing.JTextField();
        jbInserir = new javax.swing.JButton();
        jbEditar = new javax.swing.JButton();
        jbExcluir = new javax.swing.JButton();
        jbSelecionar = new javax.swing.JButton();
        jbRelatorio = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtRota = new javax.swing.JTable();
        jbLimpar = new javax.swing.JButton();
        jbSair = new javax.swing.JButton();

        setIconifiable(true);
        setTitle("Cadastro de Rotas");

        jPanel1.setForeground(new java.awt.Color(204, 204, 255));

        jlIdRota.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jlIdRota.setText("Id Rota:");

        jlDescricao.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jlDescricao.setText("Descri��o:");

        jtxIdRota.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        jtxDescricao.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jtxDescricao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxDescricaoActionPerformed(evt);
            }
        });

        jbInserir.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jbInserir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/aj_sistemas/logistica/img/add_16.png"))); // NOI18N
        jbInserir.setText("Inserir");
        jbInserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbInserirActionPerformed(evt);
            }
        });

        jbEditar.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jbEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/aj_sistemas/logistica/img/edit_16.png"))); // NOI18N
        jbEditar.setText("Editar");
        jbEditar.setEnabled(false);
        jbEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEditarActionPerformed(evt);
            }
        });

        jbExcluir.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jbExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/aj_sistemas/logistica/img/Cancel.png"))); // NOI18N
        jbExcluir.setText("Excluir");
        jbExcluir.setEnabled(false);
        jbExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbExcluirActionPerformed(evt);
            }
        });

        jbSelecionar.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jbSelecionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/aj_sistemas/logistica/img/Search.png"))); // NOI18N
        jbSelecionar.setText("Selecionar");
        jbSelecionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSelecionarActionPerformed(evt);
            }
        });

        jbRelatorio.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jbRelatorio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/aj_sistemas/logistica/img/ico_pdf.png"))); // NOI18N
        jbRelatorio.setText("Relatorio");
        jbRelatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbRelatorioActionPerformed(evt);
            }
        });

        jtRota.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jtRota.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id Rota", "Descri��o:"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtRota.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtRotaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtRota);

        jbLimpar.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jbLimpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/aj_sistemas/logistica/img/limpar-limpo.png"))); // NOI18N
        jbLimpar.setText("Limpar Campos");
        jbLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbLimparActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jlIdRota, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jlDescricao, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jtxIdRota, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jbSelecionar, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jtxDescricao)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jbInserir, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(jbEditar)
                        .addGap(30, 30, 30)
                        .addComponent(jbExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jbRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jbLimpar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlIdRota)
                    .addComponent(jtxIdRota, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbSelecionar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlDescricao)
                    .addComponent(jtxDescricao, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbInserir)
                    .addComponent(jbEditar)
                    .addComponent(jbExcluir)
                    .addComponent(jbRelatorio)
                    .addComponent(jbLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                .addContainerGap())
        );

        jbSair.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jbSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/aj_sistemas/logistica/img/close.png"))); // NOI18N
        jbSair.setText("Sair");
        jbSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbSair)
                .addGap(44, 44, 44))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbSair)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtxDescricaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxDescricaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxDescricaoActionPerformed

    private void jbInserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbInserirActionPerformed
        if (verifica()) {
            JOptionPane.showMessageDialog(this, "Favor preencher todos os campos para inserir!");
            requisitaFoco();
        } else {
            if (verificaId(getJtxIdRota().getText())) {
                JOptionPane.showMessageDialog(this, "J� existe motorista cadastrado com esse ID!");
            } else {
                RotaModel motorista = new RotaModel();
                if (!getJtxIdRota().getText().equals("")) {
                    motorista.setIdRota(Integer.parseInt(getJtxIdRota().getText()));
                }
                motorista.setDescricao(getJtxDescricao().getText());

                RotaController controle = new RotaController();
                if (getJtxIdRota().getText().equals("")) {
                    if (controle.inserirComProcedure(motorista)) {
                        JOptionPane.showMessageDialog(this, "Inserido com sucesso!");
                    } else {
                        JOptionPane.showMessageDialog(this, "Erro ao inserir!");
                    }
                } else {
                    if (controle.inserir(motorista)) {
                        JOptionPane.showMessageDialog(this, "Inserido com sucesso!");
                    } else {
                        JOptionPane.showMessageDialog(this, "Erro ao inserir!");
                    }
                }

                preencherTabela();
                limparCampos();
            }
        }
    }//GEN-LAST:event_jbInserirActionPerformed

    private void jbEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEditarActionPerformed
        if (verificarCampos()) {
            JOptionPane.showMessageDialog(this, "Selecione um motorista para poder editar.");
            requisitaFoco();
        } else {
            RotaModel motorista = new RotaModel();
            motorista.setIdRota(Integer.parseInt(getJtxIdRota().getText()));
            motorista.setDescricao(getJtxDescricao().getText());

            RotaController controle = new RotaController();
            if (controle.editarComProcedure(motorista)) {
                JOptionPane.showMessageDialog(this, "Editado com sucesso!");
            } else {
                JOptionPane.showMessageDialog(this, "Erro ao editar!");
            }
            preencherTabela();
            limparCampos();
            getJbEditar().setEnabled(false);
            getJbExcluir().setEnabled(false);
            getJbInserir().setEnabled(true);
            getJbRelatorio().setEnabled(true);
            getJbLimpar().setEnabled(true);
            getJtxIdRota().setEnabled(true);
            getJbSelecionar().setEnabled(true);
        }
    }//GEN-LAST:event_jbEditarActionPerformed

    private void jbExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbExcluirActionPerformed
        if (verificarCampos()) {
            JOptionPane.showMessageDialog(this, "Selecione um motorista para poder excluir.");
            requisitaFoco();
        } else {
            RotaModel motorista = new RotaModel();
            motorista.setIdRota(Integer.parseInt(getJtxIdRota().getText()));

            RotaController controle = new RotaController();
            if (controle.excluir(motorista)) {
                JOptionPane.showMessageDialog(this, "Excluido com sucesso!");
            } else {
                JOptionPane.showMessageDialog(this, "Erro ao excluir!");
            }
            preencherTabela();
            limparCampos();
            getJbEditar().setEnabled(false);
            getJbExcluir().setEnabled(false);
            getJbInserir().setEnabled(true);
            getJbRelatorio().setEnabled(true);
            getJbLimpar().setEnabled(true);
            getJtxIdRota().setEnabled(true);
            getJbSelecionar().setEnabled(true);
        }
    }//GEN-LAST:event_jbExcluirActionPerformed

    private void jbSelecionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSelecionarActionPerformed
        if (getJtxIdRota().getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Campo vazio, informe um campo v�lido!");
            getJtxIdRota().requestFocus();
        } else {
            RotaModel motorista = new RotaModel();
            motorista.setIdRota(Integer.parseInt(getJtxIdRota().getText()));

            RotaController controle = new RotaController();
            motorista = controle.selecionar(motorista);
            if (motorista != null) {
                getJtxIdRota().setText(String.valueOf(motorista.getIdRota()));
                getJtxDescricao().setText(motorista.getDescricao());
                getJbEditar().setEnabled(true);
                getJbExcluir().setEnabled(true);
            } else {
                JOptionPane.showMessageDialog(this, "ID N�o encontrado!");
            }

        }
    }//GEN-LAST:event_jbSelecionarActionPerformed

    private void jbRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbRelatorioActionPerformed
        GeradorDeRelatorio r = new GeradorDeRelatorio();
        try {
            r.relatorio("RelatorioRotas", "", "");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Alerta", 2);
        }
    }//GEN-LAST:event_jbRelatorioActionPerformed

    private void jtRotaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtRotaMouseClicked
        getJbEditar().setEnabled(true);
        getJbExcluir().setEnabled(true);
        getJbInserir().setEnabled(false);
        getJbRelatorio().setEnabled(false);
        getJbLimpar().setEnabled(false);
        getJtxIdRota().setEnabled(false);
        getJbSelecionar().setEnabled(false);
        int linha = getJtRota().getSelectedRow();
        getJtxIdRota().setText(String.valueOf(getJtRota().getValueAt(linha, 0)));
        getJtxDescricao().setText(String.valueOf(getJtRota().getValueAt(linha, 1)));
    }//GEN-LAST:event_jtRotaMouseClicked

    private void jbLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbLimparActionPerformed
        limparCampos();
    }//GEN-LAST:event_jbLimparActionPerformed

    private void jbSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSairActionPerformed
        int op = JOptionPane.showConfirmDialog(this, "Deseja mesmo sair?", "Sair", JOptionPane.OK_CANCEL_OPTION);

        if (op == 0) {
            dispose();
        }
    }//GEN-LAST:event_jbSairActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbEditar;
    private javax.swing.JButton jbExcluir;
    private javax.swing.JButton jbInserir;
    private javax.swing.JButton jbLimpar;
    private javax.swing.JButton jbRelatorio;
    private javax.swing.JButton jbSair;
    private javax.swing.JButton jbSelecionar;
    private javax.swing.JLabel jlDescricao;
    private javax.swing.JLabel jlIdRota;
    private javax.swing.JTable jtRota;
    private javax.swing.JTextField jtxDescricao;
    private javax.swing.JTextField jtxIdRota;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the jPanel1
     */
    public javax.swing.JPanel getjPanel1() {
        return jPanel1;
    }

    /**
     * @param jPanel1 the jPanel1 to set
     */
    public void setjPanel1(javax.swing.JPanel jPanel1) {
        this.jPanel1 = jPanel1;
    }

    /**
     * @return the jScrollPane1
     */
    public javax.swing.JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    /**
     * @param jScrollPane1 the jScrollPane1 to set
     */
    public void setjScrollPane1(javax.swing.JScrollPane jScrollPane1) {
        this.jScrollPane1 = jScrollPane1;
    }

    /**
     * @return the jbEditar
     */
    public javax.swing.JButton getJbEditar() {
        return jbEditar;
    }

    /**
     * @param jbEditar the jbEditar to set
     */
    public void setJbEditar(javax.swing.JButton jbEditar) {
        this.jbEditar = jbEditar;
    }

    /**
     * @return the jbExcluir
     */
    public javax.swing.JButton getJbExcluir() {
        return jbExcluir;
    }

    /**
     * @param jbExcluir the jbExcluir to set
     */
    public void setJbExcluir(javax.swing.JButton jbExcluir) {
        this.jbExcluir = jbExcluir;
    }

    /**
     * @return the jbInserir
     */
    public javax.swing.JButton getJbInserir() {
        return jbInserir;
    }

    /**
     * @param jbInserir the jbInserir to set
     */
    public void setJbInserir(javax.swing.JButton jbInserir) {
        this.jbInserir = jbInserir;
    }

    /**
     * @return the jbLimpar
     */
    public javax.swing.JButton getJbLimpar() {
        return jbLimpar;
    }

    /**
     * @param jbLimpar the jbLimpar to set
     */
    public void setJbLimpar(javax.swing.JButton jbLimpar) {
        this.jbLimpar = jbLimpar;
    }

    /**
     * @return the jbRelatorio
     */
    public javax.swing.JButton getJbRelatorio() {
        return jbRelatorio;
    }

    /**
     * @param jbRelatorio the jbRelatorio to set
     */
    public void setJbRelatorio(javax.swing.JButton jbRelatorio) {
        this.jbRelatorio = jbRelatorio;
    }

    /**
     * @return the jbSair
     */
    public javax.swing.JButton getJbSair() {
        return jbSair;
    }

    /**
     * @param jbSair the jbSair to set
     */
    public void setJbSair(javax.swing.JButton jbSair) {
        this.jbSair = jbSair;
    }

    /**
     * @return the jbSelecionar
     */
    public javax.swing.JButton getJbSelecionar() {
        return jbSelecionar;
    }

    /**
     * @param jbSelecionar the jbSelecionar to set
     */
    public void setJbSelecionar(javax.swing.JButton jbSelecionar) {
        this.jbSelecionar = jbSelecionar;
    }

    /**
     * @return the jlDescricao
     */
    public javax.swing.JLabel getJlDescricao() {
        return jlDescricao;
    }

    /**
     * @param jlDescricao the jlDescricao to set
     */
    public void setJlDescricao(javax.swing.JLabel jlDescricao) {
        this.jlDescricao = jlDescricao;
    }

    /**
     * @return the jlIdRota
     */
    public javax.swing.JLabel getJlIdRota() {
        return jlIdRota;
    }

    /**
     * @param jlIdRota the jlIdRota to set
     */
    public void setJlIdRota(javax.swing.JLabel jlIdRota) {
        this.jlIdRota = jlIdRota;
    }

    /**
     * @return the jtRota
     */
    public javax.swing.JTable getJtRota() {
        return jtRota;
    }

    /**
     * @param jtRota the jtRota to set
     */
    public void setJtRota(javax.swing.JTable jtRota) {
        this.jtRota = jtRota;
    }

    /**
     * @return the jtxDescricao
     */
    public javax.swing.JTextField getJtxDescricao() {
        return jtxDescricao;
    }

    /**
     * @param jtxDescricao the jtxDescricao to set
     */
    public void setJtxDescricao(javax.swing.JTextField jtxDescricao) {
        this.jtxDescricao = jtxDescricao;
    }

    /**
     * @return the jtxIdRota
     */
    public javax.swing.JTextField getJtxIdRota() {
        return jtxIdRota;
    }

    /**
     * @param jtxIdRota the jtxIdRota to set
     */
    public void setJtxIdRota(javax.swing.JTextField jtxIdRota) {
        this.jtxIdRota = jtxIdRota;
    }
}
