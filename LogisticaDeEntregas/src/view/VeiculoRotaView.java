/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.RotaController;
import controller.VeiculoController;
import controller.VeiculoRotaController;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import model.VeiculoRotaModel;
import javax.swing.JOptionPane;
import utils.GeradorDeRelatorio;

/**
 *
 * @author licin
 */
public class VeiculoRotaView extends javax.swing.JInternalFrame {

    private ArrayList<String> rotas;
    private ArrayList<String> veiculos;

    /**
     * Creates new form VeiculoRotaView
     */
    public VeiculoRotaView() {
        initComponents();
        preencherTabela();
        RotaController controle = new RotaController();
        rotas = controle.selecionaRotas();
        VeiculoController controller = new VeiculoController();
        veiculos = controller.selecionaVeiculosTodos();
        preencherJComboBox();
    }

    public void preencherJComboBox() {
        for (int linha = 0; linha < getRotas().size(); linha++) {
            getJcbRota().addItem(getRotas().get(linha));
        }
        for (int linha = 0; linha < getVeiculos().size(); linha++) {
            getJcbVeiculo().addItem(getVeiculos().get(linha));
        }
    }

    public void preencherTabela() {
        VeiculoRotaController controle = new VeiculoRotaController();
        ArrayList<VeiculoRotaModel> lista = controle.selecionaView();
        DefaultTableModel modelo = (DefaultTableModel) getJtVeiculoRota().getModel();
        modelo.setRowCount(0);
        for (VeiculoRotaModel f : lista) {
            modelo.addRow(new Object[]{
                f.getIdVeiculoRota(),
                f.getVeiculo().getPlaca(),
                f.getRota().getDescricao()
            });
        }
    }

    public void limparCampos() {
        getJtxIdVeiculoRota().setText("");
        getJcbRota().setSelectedIndex(-1);
        getJcbVeiculo().setSelectedIndex(-1);
        getJbEditar().setEnabled(false);
        getJbExcluir().setEnabled(false);
    }

    public boolean verificarCampos() {
        if (getJtxIdVeiculoRota().getText().equals("")) {
            return true;
        } else if (getJcbRota().getSelectedItem().equals("")) {
            return true;
        } else if (getJcbVeiculo().getSelectedItem().equals("")) {
            return true;
        } else {
            return false;
        }
    }

    public boolean verifica() {
        if (getJcbRota().getSelectedIndex() == -1) {
            return true;
        } else if (getJcbVeiculo().getSelectedIndex() == -1) {
            return true;
        } else {
            return false;
        }
    }

    public void requisitaFoco() {
        if (getJtxIdVeiculoRota().getText().equals("")) {
            getJtxIdVeiculoRota().requestFocus();
        } else if (getJcbRota().getSelectedItem().equals("")) {
            getJcbRota().requestFocus();
        } else {
            getJcbVeiculo().requestFocus();
        }
    }

    public boolean verificaId(String idVeiculo) {
        if (getJtxIdVeiculoRota().getText().equals("")) {
            return false;
        } else {
            VeiculoRotaController controle = new VeiculoRotaController();
            ArrayList<VeiculoRotaModel> lista = controle.selecionarTodos();
            for (VeiculoRotaModel veiculoRota : lista) {
                if (veiculoRota.getIdVeiculoRota() == Integer.parseInt(idVeiculo)) {
                    return true;
                }
            }
        }

        return false;
    }

    public int retornaIdRota(String descricao) {
        RotaController controle = new RotaController();
        ArrayList<Integer> idRotas = controle.selecionaIdRotas();
        for (int i = 0; i < idRotas.size(); i++) {
            if (descricao.equals(getRotas().get(i))) {
                return idRotas.get(i);
            }
        }
        return 0;
    }

    public String retornaDescricaoRota(int idRotaVeiculo) {
        for (int i = 0; i < getJtVeiculoRota().getRowCount(); i++) {
            if (idRotaVeiculo == Integer.parseInt(String.valueOf(getJtVeiculoRota().getValueAt(i, 0)))) {
                return String.valueOf(getJtVeiculoRota().getValueAt(i, 2));
            }
        }
        return "";
    }

    public int retornaIdVeiculo(String placa) {
        VeiculoController controle = new VeiculoController();
        ArrayList<Integer> idVeiculos = controle.selecionaIdVeiculos();
        for (int i = 0; i < idVeiculos.size(); i++) {
            if (placa.equals(getVeiculos().get(i))) {
                return idVeiculos.get(i);
            }
        }
        return 0;
    }

    public String retornaPlacaVeiculo(int idRotaVeiculo) {
        for (int i = 0; i < getJtVeiculoRota().getRowCount(); i++) {
            if (idRotaVeiculo == Integer.parseInt(String.valueOf(getJtVeiculoRota().getValueAt(i, 0)))) {
                return String.valueOf(getJtVeiculoRota().getValueAt(i, 1));
            }
        }
        return "";
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
        jlIdVeiculoRota = new javax.swing.JLabel();
        jlRota = new javax.swing.JLabel();
        jlVeiculo = new javax.swing.JLabel();
        jtxIdVeiculoRota = new javax.swing.JTextField();
        jbInserir = new javax.swing.JButton();
        jbEditar = new javax.swing.JButton();
        jbExcluir = new javax.swing.JButton();
        jbSelecionar = new javax.swing.JButton();
        jbRelatorio = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtVeiculoRota = new javax.swing.JTable();
        jbLimpar = new javax.swing.JButton();
        jcbVeiculo = new javax.swing.JComboBox<>();
        jcbRota = new javax.swing.JComboBox<>();
        jbSair = new javax.swing.JButton();

        setIconifiable(true);

        jPanel1.setForeground(new java.awt.Color(204, 204, 255));

        jlIdVeiculoRota.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jlIdVeiculoRota.setText("Id Veículo-Rota:");

        jlRota.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jlRota.setText("Rota:");

        jlVeiculo.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jlVeiculo.setText("Veículo:");

        jtxIdVeiculoRota.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        jbInserir.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jbInserir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/inserirP.png"))); // NOI18N
        jbInserir.setText("Inserir");
        jbInserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbInserirActionPerformed(evt);
            }
        });

        jbEditar.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jbEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/editarP.png"))); // NOI18N
        jbEditar.setText("Editar");
        jbEditar.setEnabled(false);
        jbEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEditarActionPerformed(evt);
            }
        });

        jbExcluir.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jbExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cancelar.png"))); // NOI18N
        jbExcluir.setText("Excluir");
        jbExcluir.setEnabled(false);
        jbExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbExcluirActionPerformed(evt);
            }
        });

        jbSelecionar.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jbSelecionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/zoom.png"))); // NOI18N
        jbSelecionar.setText("Selecionar");
        jbSelecionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSelecionarActionPerformed(evt);
            }
        });

        jbRelatorio.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jbRelatorio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/arquivos.png"))); // NOI18N
        jbRelatorio.setText("Relatorio");
        jbRelatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbRelatorioActionPerformed(evt);
            }
        });

        jtVeiculoRota.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jtVeiculoRota.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id Veículo-Rota", "Veiculo", "Rota"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtVeiculoRota.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtVeiculoRotaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtVeiculoRota);

        jbLimpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/limpar-limpo.png"))); // NOI18N
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
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jbInserir, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(jbEditar)
                        .addGap(30, 30, 30)
                        .addComponent(jbExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jbRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jbLimpar, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlRota, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlIdVeiculoRota, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jcbVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jtxIdVeiculoRota, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addComponent(jbSelecionar, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jcbRota, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(30, 30, 30))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlIdVeiculoRota)
                    .addComponent(jtxIdVeiculoRota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbSelecionar))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlRota)
                    .addComponent(jcbRota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlVeiculo)
                    .addComponent(jcbVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(65, 65, 65)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbInserir)
                    .addComponent(jbEditar)
                    .addComponent(jbExcluir)
                    .addComponent(jbRelatorio)
                    .addComponent(jbLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE))
        );

        jbSair.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jbSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/sair.png"))); // NOI18N
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
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbSair, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbSair)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbInserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbInserirActionPerformed
        if (verifica()) {
            JOptionPane.showMessageDialog(this, "Favor preencher todos os campos para inserir!");
            requisitaFoco();
        } else {
            if (verificaId(getJtxIdVeiculoRota().getText())) {
                JOptionPane.showMessageDialog(this, "Já existe veiculo cadastrado com esse ID!");
            } else {
                VeiculoRotaModel veiculoRota = new VeiculoRotaModel();
                if (!getJtxIdVeiculoRota().getText().equals("")) {
                    veiculoRota.setIdVeiculoRota(Integer.parseInt(getJtxIdVeiculoRota().getText()));
                }

                veiculoRota.getRota().setIdRota(retornaIdRota(getJcbRota().getSelectedItem().toString()));
                veiculoRota.getVeiculo().setIdVeiculo(retornaIdVeiculo(getJcbVeiculo().getSelectedItem().toString()));

                VeiculoRotaController controle = new VeiculoRotaController();
                if (getJtxIdVeiculoRota().getText().equals("")) {
                    if (controle.inserirComProcedure(veiculoRota)) {
                        JOptionPane.showMessageDialog(this, "Inserido com sucesso!");
                    } else {
                        JOptionPane.showMessageDialog(this, "Erro ao inserir!");
                    }
                } else {
                    if (controle.inserir(veiculoRota)) {
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
            JOptionPane.showMessageDialog(this, "Selecione um veiculo para poder editar.");
            requisitaFoco();
        } else {
            VeiculoRotaModel veiculoRota = new VeiculoRotaModel();
            veiculoRota.setIdVeiculoRota(Integer.parseInt(getJtxIdVeiculoRota().getText()));

            veiculoRota.getRota().setIdRota(retornaIdRota(getJcbRota().getSelectedItem().toString()));
            veiculoRota.getVeiculo().setIdVeiculo(retornaIdVeiculo(getJcbVeiculo().getSelectedItem().toString()));

            VeiculoRotaController controle = new VeiculoRotaController();
            if (controle.editarComProcedure(veiculoRota)) {
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
            getJtxIdVeiculoRota().setEnabled(true);
            getJbSelecionar().setEnabled(true);
        }
    }//GEN-LAST:event_jbEditarActionPerformed

    private void jbExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbExcluirActionPerformed
        if (verificarCampos()) {
            JOptionPane.showMessageDialog(this, "Selecione um veiculo para poder excluir.");
            requisitaFoco();
        } else {
            VeiculoRotaModel veiculoRota = new VeiculoRotaModel();
            veiculoRota.setIdVeiculoRota(Integer.parseInt(getJtxIdVeiculoRota().getText()));

            VeiculoRotaController controle = new VeiculoRotaController();
            if (controle.excluir(veiculoRota)) {
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
            getJtxIdVeiculoRota().setEnabled(true);
            getJbSelecionar().setEnabled(true);
        }
    }//GEN-LAST:event_jbExcluirActionPerformed

    private void jbSelecionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSelecionarActionPerformed
        if (getJtxIdVeiculoRota().getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Campo vazio, informe um campo válido!");
            getJtxIdVeiculoRota().requestFocus();
        } else {
            VeiculoRotaModel veiculoRota = new VeiculoRotaModel();
            veiculoRota.setIdVeiculoRota(Integer.parseInt(getJtxIdVeiculoRota().getText()));

            VeiculoRotaController controle = new VeiculoRotaController();
            veiculoRota = controle.selecionar(veiculoRota);
            if (veiculoRota != null) {
                getJtxIdVeiculoRota().setText(String.valueOf(veiculoRota.getIdVeiculoRota()));                
                getJcbRota().setSelectedItem(retornaDescricaoRota(veiculoRota.getIdVeiculoRota()));
                getJcbVeiculo().setSelectedItem(retornaPlacaVeiculo(veiculoRota.getIdVeiculoRota()));
                getJbEditar().setEnabled(true);
                getJbExcluir().setEnabled(true);
            } else {
                JOptionPane.showMessageDialog(this, "ID Não encontrado!");
            }

        }
    }//GEN-LAST:event_jbSelecionarActionPerformed

    private void jbRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbRelatorioActionPerformed
        GeradorDeRelatorio r = new GeradorDeRelatorio();
        r.relatorio("src\\relatorios\\RelatorioVeiculosRotas", "", "");
    }//GEN-LAST:event_jbRelatorioActionPerformed

    private void jtVeiculoRotaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtVeiculoRotaMouseClicked
        getJbEditar().setEnabled(true);
        getJbExcluir().setEnabled(true);
        getJbInserir().setEnabled(false);
        getJbRelatorio().setEnabled(false);
        getJbLimpar().setEnabled(false);
        getJtxIdVeiculoRota().setEnabled(false);
        getJbSelecionar().setEnabled(false);
        int linha = getJtVeiculoRota().getSelectedRow();
        getJtxIdVeiculoRota().setText(String.valueOf(getJtVeiculoRota().getValueAt(linha, 0)));
        getJcbVeiculo().setSelectedItem(String.valueOf(getJtVeiculoRota().getValueAt(linha, 1)));
        getJcbRota().setSelectedItem(String.valueOf(getJtVeiculoRota().getValueAt(linha, 2)));
    }//GEN-LAST:event_jtVeiculoRotaMouseClicked

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
    private javax.swing.JComboBox<String> jcbRota;
    private javax.swing.JComboBox<String> jcbVeiculo;
    private javax.swing.JLabel jlIdVeiculoRota;
    private javax.swing.JLabel jlRota;
    private javax.swing.JLabel jlVeiculo;
    private javax.swing.JTable jtVeiculoRota;
    private javax.swing.JTextField jtxIdVeiculoRota;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the rotas
     */
    public ArrayList<String> getRotas() {
        return rotas;
    }

    /**
     * @param rotas the rotas to set
     */
    public void setRotas(ArrayList<String> rotas) {
        this.rotas = rotas;
    }

    /**
     * @return the veiculos
     */
    public ArrayList<String> getVeiculos() {
        return veiculos;
    }

    /**
     * @param veiculos the veiculos to set
     */
    public void setVeiculos(ArrayList<String> veiculos) {
        this.veiculos = veiculos;
    }

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
     * @return the jcbRota
     */
    public javax.swing.JComboBox<String> getJcbRota() {
        return jcbRota;
    }

    /**
     * @param jcbRota the jcbRota to set
     */
    public void setJcbRota(javax.swing.JComboBox<String> jcbRota) {
        this.jcbRota = jcbRota;
    }

    /**
     * @return the jcbVeiculo
     */
    public javax.swing.JComboBox<String> getJcbVeiculo() {
        return jcbVeiculo;
    }

    /**
     * @param jcbVeiculo the jcbVeiculo to set
     */
    public void setJcbVeiculo(javax.swing.JComboBox<String> jcbVeiculo) {
        this.jcbVeiculo = jcbVeiculo;
    }

    /**
     * @return the jlIdVeiculoRota
     */
    public javax.swing.JLabel getJlIdVeiculoRota() {
        return jlIdVeiculoRota;
    }

    /**
     * @param jlIdVeiculoRota the jlIdVeiculoRota to set
     */
    public void setJlIdVeiculoRota(javax.swing.JLabel jlIdVeiculoRota) {
        this.jlIdVeiculoRota = jlIdVeiculoRota;
    }

    /**
     * @return the jlRota
     */
    public javax.swing.JLabel getJlRota() {
        return jlRota;
    }

    /**
     * @param jlRota the jlRota to set
     */
    public void setJlRota(javax.swing.JLabel jlRota) {
        this.jlRota = jlRota;
    }

    /**
     * @return the jlVeiculo
     */
    public javax.swing.JLabel getJlVeiculo() {
        return jlVeiculo;
    }

    /**
     * @param jlVeiculo the jlVeiculo to set
     */
    public void setJlVeiculo(javax.swing.JLabel jlVeiculo) {
        this.jlVeiculo = jlVeiculo;
    }

    /**
     * @return the jtVeiculo
     */
    public javax.swing.JTable getJtVeiculo() {
        return getJtVeiculoRota();
    }

    /**
     * @param jtVeiculo the jtVeiculo to set
     */
    public void setJtVeiculo(javax.swing.JTable jtVeiculo) {
        this.setJtVeiculoRota(jtVeiculo);
    }

    /**
     * @return the jtxIdVeiculoRota
     */
    public javax.swing.JTextField getJtxIdVeiculoRota() {
        return jtxIdVeiculoRota;
    }

    /**
     * @param jtxIdVeiculoRota the jtxIdVeiculoRota to set
     */
    public void setJtxIdVeiculoRota(javax.swing.JTextField jtxIdVeiculoRota) {
        this.jtxIdVeiculoRota = jtxIdVeiculoRota;
    }

    /**
     * @return the jtVeiculoRota
     */
    public javax.swing.JTable getJtVeiculoRota() {
        return jtVeiculoRota;
    }

    /**
     * @param jtVeiculoRota the jtVeiculoRota to set
     */
    public void setJtVeiculoRota(javax.swing.JTable jtVeiculoRota) {
        this.jtVeiculoRota = jtVeiculoRota;
    }
}
