/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.MotoristaController;
import controller.PacoteController;
import controller.VeiculoController;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.PacoteModel;
import utils.GeradorDeRelatorio;

/**
 *
 * @author licin
 */
public class PacoteView extends javax.swing.JInternalFrame {

    private ArrayList<String> veiculos;

    /**
     * Creates new form PacoteView
     */
    public PacoteView() {
        initComponents();
        preencherTabela();
        VeiculoController controle = new VeiculoController();
        veiculos = controle.selecionaVeiculosTodos();
        preencherJComboBox();
    }

    public void preencherJComboBox() {
        for (int linha = 0; linha < getVeiculos().size(); linha++) {
            //adicionando a categoria no combo
            getJcbVeiculo().addItem(getVeiculos().get(linha));
        }
    }

    public void preencherTabela() {
        PacoteController controle = new PacoteController();
        ArrayList<PacoteModel> lista = controle.selecionaView();
        DefaultTableModel placa = (DefaultTableModel) getJtPacote().getModel();
        placa.setRowCount(0);
        for (PacoteModel f : lista) {
            placa.addRow(new Object[]{
                f.getIdPacote(),
                f.getDescricao(),
                f.getPeso(),
                f.getVolume(),
                f.getDestinatario(),
                f.getVeiculo().getPlaca()
            });
        }
    }

    public void limparCampos() {
        getJtxIdPacote().setText("");
        getJtxIdPacote1().setText("");
        getJtxDescricao().setText("");
        getJtxPeso().setText("");
        getJtxVolume().setText("");
        getJtxDestinatario().setText("");
        getJcbVeiculo().setSelectedIndex(-1);
        getJbEditar().setEnabled(false);
        getJbExcluir().setEnabled(false);
        getJbInserir().setEnabled(true);
    }

    public boolean verificarCampos() {
        if (getJtxIdPacote().getText().equals("")) {
            return true;
        } else if (getJtxDescricao().getText().equals("")) {
            return true;
        } else if (getJtxPeso().getText().equals("")) {
            return true;
        } else if (getJtxVolume().getText().equals("")) {
            return true;
        } else if (getJtxDestinatario().getText().equals("")) {
            return true;
        } else if (getJcbVeiculo().getSelectedItem().equals("")) {
            return true;
        } else {
            return false;
        }
    }

    public boolean verifica() {
        if (getJtxDescricao().getText().equals("")) {
            return true;
        } else if (getJtxPeso().getText().equals("")) {
            return true;
        } else if (getJtxVolume().getText().equals("")) {
            return true;
        } else if (getJtxDestinatario().getText().equals("")) {
            return true;
        } else if (getJcbVeiculo().getSelectedIndex() == -1) {
            return true;
        } else {
            return false;
        }
    }

    public void requisitaFoco() {
        if (getJtxIdPacote().getText().equals("")) {
            getJtxIdPacote().requestFocus();
        } else if (getJtxDescricao().getText().equals("")) {
            getJtxDescricao().requestFocus();
        } else if (getJtxPeso().getText().equals("")) {
            getJtxPeso().requestFocus();
        } else if (getJtxVolume().getText().equals("")) {
            getJtxVolume().requestFocus();
        } else if (getJtxDestinatario().getText().equals("")) {
            getJtxDestinatario().requestFocus();
        } else {
            getJcbVeiculo().requestFocus();
        }
    }

    public boolean verificaId(String idPacote) {
        if (getJtxIdPacote().getText().equals("")) {
            return false;
        } else {
            PacoteController controle = new PacoteController();
            ArrayList<PacoteModel> lista = controle.selecionarTodos();
            for (PacoteModel pacote : lista) {
                if (pacote.getIdPacote() == Integer.parseInt(idPacote)) {
                    return true;
                }
            }
        }

        return false;
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

    public String retornaPlacaVeiculo(int idpacote) {
        for (int i = 0; i < getJtPacote().getRowCount(); i++) {
            if (idpacote == Integer.parseInt(String.valueOf(getJtPacote().getValueAt(i, 0)))) {
                return String.valueOf(getJtPacote().getValueAt(i, 5));
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

        jbSair = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jlIdPacote = new javax.swing.JLabel();
        jlDescricao = new javax.swing.JLabel();
        jlPeso = new javax.swing.JLabel();
        jlVeiculo = new javax.swing.JLabel();
        jtxIdPacote = new javax.swing.JTextField();
        jtxDescricao = new javax.swing.JTextField();
        jtxPeso = new javax.swing.JTextField();
        jbInserir = new javax.swing.JButton();
        jbEditar = new javax.swing.JButton();
        jbExcluir = new javax.swing.JButton();
        jbSelecionar = new javax.swing.JButton();
        jbRelatorio = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtVeiculo = new javax.swing.JTable();
        jbLimpar = new javax.swing.JButton();
        jcbVeiculo = new javax.swing.JComboBox<>();
        jlVolume = new javax.swing.JLabel();
        jtxVolume = new javax.swing.JTextField();
        jlDestinatario = new javax.swing.JLabel();
        jtxDestinatario = new javax.swing.JTextField();
        jtxIdPacote1 = new javax.swing.JTextField();
        jlSelecionar = new javax.swing.JLabel();

        setIconifiable(true);
        setTitle("Cadastro de Pacotes");

        jbSair.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jbSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/sair.png"))); // NOI18N
        jbSair.setText("Sair");
        jbSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSairActionPerformed(evt);
            }
        });

        jPanel1.setForeground(new java.awt.Color(204, 204, 255));

        jlIdPacote.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jlIdPacote.setText("Id Pacote:");

        jlDescricao.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jlDescricao.setText("Descrição:");

        jlPeso.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jlPeso.setText("Peso:");

        jlVeiculo.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jlVeiculo.setText("Veiculo:");

        jtxIdPacote.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        jtxDescricao.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jtxDescricao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxDescricaoActionPerformed(evt);
            }
        });

        jtxPeso.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

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

        jtVeiculo.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jtVeiculo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id Pacote", "Descrição", "Peso", "Volume", "Destinatario", "Veiculo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtVeiculo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtVeiculoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtVeiculo);

        jbLimpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/limpar-limpo.png"))); // NOI18N
        jbLimpar.setText("Limpar Campos");
        jbLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbLimparActionPerformed(evt);
            }
        });

        jlVolume.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jlVolume.setText("Volume:");

        jtxVolume.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        jlDestinatario.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jlDestinatario.setText("Destinatário:");

        jtxDestinatario.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        jtxIdPacote1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jtxIdPacote1.setEnabled(false);

        jlSelecionar.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jlSelecionar.setText("Selecionar pelo ID:");

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
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jlPeso, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jbInserir, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(11, 11, 11))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jlVeiculo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(26, 26, 26)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(jbEditar)
                                .addGap(30, 30, 30)
                                .addComponent(jbExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(jbRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(jbLimpar, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jcbVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jtxPeso, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jlVolume)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jtxVolume, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jlDestinatario)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtxDestinatario))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlIdPacote, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jtxIdPacote1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jlSelecionar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jtxIdPacote, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(jbSelecionar, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jtxDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlIdPacote)
                    .addComponent(jbSelecionar)
                    .addComponent(jtxIdPacote1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlSelecionar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtxIdPacote, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlDescricao)
                    .addComponent(jtxDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlPeso)
                    .addComponent(jtxPeso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlVolume)
                    .addComponent(jtxVolume, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlDestinatario)
                    .addComponent(jtxDestinatario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlVeiculo)
                    .addComponent(jcbVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbInserir)
                    .addComponent(jbEditar)
                    .addComponent(jbExcluir)
                    .addComponent(jbRelatorio)
                    .addComponent(jbLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(52, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbSair, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbSair)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSairActionPerformed
        int op = JOptionPane.showConfirmDialog(this, "Deseja mesmo sair?", "Sair", JOptionPane.OK_CANCEL_OPTION);

        if (op == 0) {
            dispose();
        }
    }//GEN-LAST:event_jbSairActionPerformed

    private void jtxDescricaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxDescricaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxDescricaoActionPerformed

    private void jbInserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbInserirActionPerformed
        if (verifica()) {
            JOptionPane.showMessageDialog(this, "Favor preencher todos os campos para inserir!");
            requisitaFoco();
        } else {
            if (verificaId(getJtxIdPacote().getText())) {
                JOptionPane.showMessageDialog(this, "Já existe pacote cadastrado com esse ID!");
            } else {
                PacoteModel pacote = new PacoteModel();
                if (!getJtxIdPacote().getText().equals("")) {
                    pacote.setIdPacote(Integer.parseInt(getJtxIdPacote().getText()));
                }
                pacote.setDescricao(getJtxDescricao().getText());
                pacote.setPeso(Double.parseDouble(getJtxPeso().getText()));
                pacote.setVolume(Double.parseDouble(getJtxVolume().getText()));
                pacote.setDestinatario(getJtxDestinatario().getText());
                pacote.getVeiculo().setPlaca(getJcbVeiculo().getSelectedItem().toString());
                pacote.getVeiculo().setIdVeiculo(retornaIdVeiculo(pacote.getVeiculo().getPlaca()));

                PacoteController controle = new PacoteController();
                if (controle.inserirComProcedure(pacote)) {
                    JOptionPane.showMessageDialog(this, "Inserido com sucesso!");
                } else {
                    JOptionPane.showMessageDialog(this, "Erro ao inserir!");
                }

                preencherTabela();
                limparCampos();
            }
        }
    }//GEN-LAST:event_jbInserirActionPerformed

    private void jbEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEditarActionPerformed
        if (verificarCampos()) {
            JOptionPane.showMessageDialog(this, "Selecione um pacote para poder editar.");
            requisitaFoco();
        } else {
            PacoteModel pacote = new PacoteModel();
            pacote.setIdPacote(Integer.parseInt(getJtxIdPacote().getText()));
            pacote.setDescricao(getJtxDescricao().getText());
            pacote.setPeso(Double.parseDouble(getJtxPeso().getText()));
            pacote.setVolume(Double.parseDouble(getJtxVolume().getText()));
            pacote.setDestinatario(getJtxDestinatario().getText());
            pacote.getVeiculo().setPlaca(getJcbVeiculo().getSelectedItem().toString());
            pacote.getVeiculo().setIdVeiculo(retornaIdVeiculo(pacote.getVeiculo().getPlaca()));

            PacoteController controle = new PacoteController();
            if (controle.editarComProcedure(pacote)) {
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
            getJtxIdPacote().setEnabled(true);
            getJbSelecionar().setEnabled(true);
        }
    }//GEN-LAST:event_jbEditarActionPerformed

    private void jbExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbExcluirActionPerformed
        if (verificarCampos()) {
            JOptionPane.showMessageDialog(this, "Selecione um pacote para poder excluir.");
            requisitaFoco();
        } else {
            PacoteModel pacote = new PacoteModel();
            pacote.setIdPacote(Integer.parseInt(getJtxIdPacote().getText()));

            PacoteController controle = new PacoteController();
            if (controle.excluir(pacote)) {
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
            getJtxIdPacote().setEnabled(true);
            getJbSelecionar().setEnabled(true);
        }
    }//GEN-LAST:event_jbExcluirActionPerformed

    private void jbSelecionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSelecionarActionPerformed
        if (getJtxIdPacote().getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Campo vazio, informe um campo válido!");
            getJtxIdPacote().requestFocus();
        } else {
            PacoteModel pacote = new PacoteModel();
            pacote.setIdPacote(Integer.parseInt(getJtxIdPacote().getText()));

            PacoteController controle = new PacoteController();
            pacote = controle.selecionar(pacote);
            if (pacote != null) {
                getJtxIdPacote().setText(String.valueOf(pacote.getIdPacote()));
                getJtxIdPacote1().setText(String.valueOf(pacote.getIdPacote()));
                getJtxPeso().setText(String.valueOf(pacote.getPeso()));
                getJtxDescricao().setText(pacote.getDescricao());
                getJtxVolume().setText(String.valueOf(pacote.getVolume()));
                getJtxDestinatario().setText(pacote.getDestinatario());
                getJcbVeiculo().setSelectedItem(retornaPlacaVeiculo(pacote.getIdPacote()));
                getJbInserir().setEnabled(false);
                getJbEditar().setEnabled(true);
                getJbExcluir().setEnabled(true);
            } else {
                JOptionPane.showMessageDialog(this, "ID Não encontrado!");
            }

        }
    }//GEN-LAST:event_jbSelecionarActionPerformed

    private void jbRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbRelatorioActionPerformed
        GeradorDeRelatorio r = new GeradorDeRelatorio();
        r.relatorio("src\\relatorios\\RelatorioPacotes", "", "");
    }//GEN-LAST:event_jbRelatorioActionPerformed

    private void jtVeiculoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtVeiculoMouseClicked
        if (evt.getClickCount() == 2) {
            getJbEditar().setEnabled(true);
            getJbExcluir().setEnabled(true);
            getJbInserir().setEnabled(false);
            getJbRelatorio().setEnabled(false);
            getJbLimpar().setEnabled(false);
            getJtxIdPacote().setEnabled(false);
            getJbSelecionar().setEnabled(false);
            int linha = getJtPacote().getSelectedRow();
            getJtxIdPacote().setText(String.valueOf(getJtPacote().getValueAt(linha, 0)));
            getJtxIdPacote1().setText(String.valueOf(getJtPacote().getValueAt(linha, 0)));
            getJtxPeso().setText(String.valueOf(getJtPacote().getValueAt(linha, 2)));
            getJtxDescricao().setText(String.valueOf(getJtPacote().getValueAt(linha, 1)));
            getJtxVolume().setText(String.valueOf(getJtPacote().getValueAt(linha, 3)));
            getJtxDestinatario().setText(String.valueOf(getJtPacote().getValueAt(linha, 4)));
            getJcbVeiculo().setSelectedItem(String.valueOf(getJtPacote().getValueAt(linha, 5)));
        }
    }//GEN-LAST:event_jtVeiculoMouseClicked

    private void jbLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbLimparActionPerformed
        limparCampos();
    }//GEN-LAST:event_jbLimparActionPerformed


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
    private javax.swing.JComboBox<String> jcbVeiculo;
    private javax.swing.JLabel jlDescricao;
    private javax.swing.JLabel jlDestinatario;
    private javax.swing.JLabel jlIdPacote;
    private javax.swing.JLabel jlPeso;
    private javax.swing.JLabel jlSelecionar;
    private javax.swing.JLabel jlVeiculo;
    private javax.swing.JLabel jlVolume;
    private javax.swing.JTable jtVeiculo;
    private javax.swing.JTextField jtxDescricao;
    private javax.swing.JTextField jtxDestinatario;
    private javax.swing.JTextField jtxIdPacote;
    private javax.swing.JTextField jtxIdPacote1;
    private javax.swing.JTextField jtxPeso;
    private javax.swing.JTextField jtxVolume;
    // End of variables declaration//GEN-END:variables
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
     * @return the jlDestinatario
     */
    public javax.swing.JLabel getJlDestinatario() {
        return jlDestinatario;
    }

    /**
     * @param jlDestinatario the jlDestinatario to set
     */
    public void setJlDestinatario(javax.swing.JLabel jlDestinatario) {
        this.jlDestinatario = jlDestinatario;
    }

    /**
     * @return the jlIdPacote
     */
    public javax.swing.JLabel getJlIdPacote() {
        return jlIdPacote;
    }

    /**
     * @param jlIdPacote the jlIdPacote to set
     */
    public void setJlIdPacote(javax.swing.JLabel jlIdPacote) {
        this.jlIdPacote = jlIdPacote;
    }

    /**
     * @return the jlPeso
     */
    public javax.swing.JLabel getJlPeso() {
        return jlPeso;
    }

    /**
     * @param jlPeso the jlPeso to set
     */
    public void setJlPeso(javax.swing.JLabel jlPeso) {
        this.jlPeso = jlPeso;
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
     * @return the jlVolume
     */
    public javax.swing.JLabel getJlVolume() {
        return jlVolume;
    }

    /**
     * @param jlVolume the jlVolume to set
     */
    public void setJlVolume(javax.swing.JLabel jlVolume) {
        this.jlVolume = jlVolume;
    }

    /**
     * @return the jtVeiculo
     */
    public javax.swing.JTable getJtPacote() {
        return getJtVeiculo();
    }

    /**
     * @param jtVeiculo the jtVeiculo to set
     */
    public void setJtVeiculo(javax.swing.JTable jtVeiculo) {
        this.jtVeiculo = jtVeiculo;
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
     * @return the jtxDestinatario
     */
    public javax.swing.JTextField getJtxDestinatario() {
        return jtxDestinatario;
    }

    /**
     * @param jtxDestinatario the jtxDestinatario to set
     */
    public void setJtxDestinatario(javax.swing.JTextField jtxDestinatario) {
        this.jtxDestinatario = jtxDestinatario;
    }

    /**
     * @return the jtxIdPacote
     */
    public javax.swing.JTextField getJtxIdPacote() {
        return jtxIdPacote;
    }

    /**
     * @param jtxIdPacote the jtxIdPacote to set
     */
    public void setJtxIdPacote(javax.swing.JTextField jtxIdPacote) {
        this.jtxIdPacote = jtxIdPacote;
    }

    /**
     * @return the jtxPeso
     */
    public javax.swing.JTextField getJtxPeso() {
        return jtxPeso;
    }

    /**
     * @param jtxPeso the jtxPeso to set
     */
    public void setJtxPeso(javax.swing.JTextField jtxPeso) {
        this.jtxPeso = jtxPeso;
    }

    /**
     * @return the jtxVolume
     */
    public javax.swing.JTextField getJtxVolume() {
        return jtxVolume;
    }

    /**
     * @param jtxVolume the jtxVolume to set
     */
    public void setJtxVolume(javax.swing.JTextField jtxVolume) {
        this.jtxVolume = jtxVolume;
    }

    /**
     * @return the jLabel1
     */
    public javax.swing.JLabel getjLabel1() {
        return jlSelecionar;
    }

    /**
     * @param jLabel1 the jLabel1 to set
     */
    public void setjLabel1(javax.swing.JLabel jLabel1) {
        this.jlSelecionar = jLabel1;
    }

    /**
     * @return the jtVeiculo
     */
    public javax.swing.JTable getJtVeiculo() {
        return jtVeiculo;
    }

    /**
     * @return the jtxIdPacote1
     */
    public javax.swing.JTextField getJtxIdPacote1() {
        return jtxIdPacote1;
    }

    /**
     * @param jtxIdPacote1 the jtxIdPacote1 to set
     */
    public void setJtxIdPacote1(javax.swing.JTextField jtxIdPacote1) {
        this.jtxIdPacote1 = jtxIdPacote1;
    }
}
