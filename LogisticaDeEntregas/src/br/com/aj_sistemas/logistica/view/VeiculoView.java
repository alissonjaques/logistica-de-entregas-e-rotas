package br.com.aj_sistemas.logistica.view;

import br.com.aj_sistemas.logistica.controller.MotoristaController;
import br.com.aj_sistemas.logistica.controller.VeiculoController;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import br.com.aj_sistemas.logistica.model.VeiculoModel;
import br.com.aj_sistemas.logistica.utils.GeradorDeRelatorio;
import javax.swing.ImageIcon;

/**
 *
 * @author Alisson Jaques
 */
public class VeiculoView extends javax.swing.JInternalFrame {

    private ArrayList<String> motoristas;

    /**
     * Creates new form VeiculoView
     */
    public VeiculoView() {
        this.setFrameIcon(new ImageIcon("src\\br\\com\\aj_sistemas\\logistica\\img\\truck-icon.png"));
        initComponents();
        preencherTabela();
        MotoristaController controle = new MotoristaController();
        motoristas = controle.selecionaMotoristas();
        preencherJComboBox();
    }

    private void preencherJComboBox() {
        for (int linha = 0; linha < getMotoristas().size(); linha++) {
            //adicionando a categoria no combo
            getJcbMotorista().addItem(getMotoristas().get(linha));
        }
    }

    private void preencherTabela() {
        VeiculoController controle = new VeiculoController();
        ArrayList<VeiculoModel> lista = controle.selecionaView();
        DefaultTableModel modelo = (DefaultTableModel) getJtVeiculo().getModel();
        modelo.setRowCount(0);
        lista.forEach((f) -> {
            modelo.addRow(new Object[]{
                f.getIdVeiculo(),
                f.getModelo(),
                f.getPlaca(),
                f.getMotorista().getNome()
            });
        });
    }

    public void limparCampos() {
        getJtxIdVeiculo().setText("");
        getJtxIdVeiculo1().setText("");
        getJtxModelo().setText("");
        getJtxPlaca().setText("");
        getJcbMotorista().setSelectedIndex(-1);
        getJbEditar().setEnabled(false);
        getJbExcluir().setEnabled(false);
        getJbInserir().setEnabled(true);
    }

    public boolean verificarCampos() {
        if (getJtxIdVeiculo().getText().equals("")) {
            return true;
        } else if (getJtxModelo().getText().equals("")) {
            return true;
        } else if (getJtxPlaca().getText().equals("")) {
            return true;
        } else {
            return getJcbMotorista().getSelectedItem().equals("");
        }
    }

    public boolean verifica() {
        if (getJtxModelo().getText().equals("")) {
            return true;
        } else if (getJtxPlaca().getText().equals("")) {
            return true;
        } else {
            return getJcbMotorista().getSelectedIndex() == -1;
        }
    }

    public void requisitaFoco() {
        if (getJtxIdVeiculo().getText().equals("")) {
            getJtxIdVeiculo().requestFocus();
        } else if (getJtxModelo().getText().equals("")) {
            getJtxModelo().requestFocus();
        } else if (getJtxPlaca().getText().equals("")) {
            getJtxPlaca().requestFocus();
        } else {
            getJcbMotorista().requestFocus();
        }
    }

    public boolean verificaId(String idVeiculo) {
        if (getJtxIdVeiculo().getText().equals("")) {
            return false;
        } else {
            VeiculoController controle = new VeiculoController();
            ArrayList<VeiculoModel> lista = controle.selecionarTodos();
            if (lista.stream().anyMatch((veiculo) -> (veiculo.getIdVeiculo() == Integer.parseInt(idVeiculo)))) {
                return true;
            }
        }

        return false;
    }

    public int retornaIdMotorista(String nome) {
        MotoristaController controle = new MotoristaController();
        ArrayList<Integer> idMotoristas = controle.selecionaIdMotoristas();
        for (int i = 0; i < idMotoristas.size(); i++) {
            if (nome.equals(getMotoristas().get(i))) {
                return idMotoristas.get(i);
            }
        }
        return 0;
    }

    public String retornaNomeMotorista(int idveiculo) {
        for (int i = 0; i < getJtVeiculo().getRowCount(); i++) {
            if (idveiculo == Integer.parseInt(String.valueOf(getJtVeiculo().getValueAt(i, 0)))) {
                return String.valueOf(getJtVeiculo().getValueAt(i, 3));
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
        jlIdVeiculo = new javax.swing.JLabel();
        jlModelo = new javax.swing.JLabel();
        jlPlaca = new javax.swing.JLabel();
        jlMotorista = new javax.swing.JLabel();
        jtxIdVeiculo = new javax.swing.JTextField();
        jtxModelo = new javax.swing.JTextField();
        jtxPlaca = new javax.swing.JTextField();
        jbInserir = new javax.swing.JButton();
        jbEditar = new javax.swing.JButton();
        jbExcluir = new javax.swing.JButton();
        jbSelecionar = new javax.swing.JButton();
        jbRelatorio = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtVeiculo = new javax.swing.JTable();
        jbLimpar = new javax.swing.JButton();
        jcbMotorista = new javax.swing.JComboBox<>();
        jtxIdVeiculo1 = new javax.swing.JTextField();
        jlSelecionar = new javax.swing.JLabel();
        jbSair = new javax.swing.JButton();

        setIconifiable(true);
        setTitle("Cadastro de Ve�culos");

        jPanel1.setForeground(new java.awt.Color(204, 204, 255));

        jlIdVeiculo.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jlIdVeiculo.setText("Id Ve�culo:");

        jlModelo.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jlModelo.setText("Modelo:");

        jlPlaca.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jlPlaca.setText("Placa:");

        jlMotorista.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jlMotorista.setText("Motorista:");

        jtxIdVeiculo.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        jtxModelo.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jtxModelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxModeloActionPerformed(evt);
            }
        });

        jtxPlaca.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

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

        jtVeiculo.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jtVeiculo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id Ve�culo", "Modelo", "Placa", "Motorista"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
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

        jbLimpar.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jbLimpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/aj_sistemas/logistica/img/limpar-limpo.png"))); // NOI18N
        jbLimpar.setText("Limpar Campos");
        jbLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbLimparActionPerformed(evt);
            }
        });

        jtxIdVeiculo1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jtxIdVeiculo1.setEnabled(false);

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
                        .addComponent(jbInserir, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(jbEditar)
                        .addGap(30, 30, 30)
                        .addComponent(jbExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jbRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jbLimpar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlIdVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlMotorista, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jcbMotorista, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jtxIdVeiculo1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jlSelecionar))
                                    .addComponent(jtxModelo))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtxIdVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jlPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jbSelecionar, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                                    .addComponent(jtxPlaca))))))
                .addGap(30, 30, 30))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlIdVeiculo)
                    .addComponent(jtxIdVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbSelecionar)
                    .addComponent(jtxIdVeiculo1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlSelecionar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlModelo)
                    .addComponent(jtxModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlPlaca)
                    .addComponent(jtxPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbMotorista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlMotorista))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbInserir)
                    .addComponent(jbEditar)
                    .addComponent(jbExcluir)
                    .addComponent(jbRelatorio)
                    .addComponent(jbLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
                .addGap(20, 20, 20))
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
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbSair, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void jtxModeloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxModeloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxModeloActionPerformed

    private void jbInserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbInserirActionPerformed
        if (verifica()) {
            JOptionPane.showMessageDialog(this, "Favor preencher todos os campos para inserir!");
            requisitaFoco();
        } else {
            if (verificaId(getJtxIdVeiculo().getText())) {
                JOptionPane.showMessageDialog(this, "J� existe veiculo cadastrado com esse ID!");
            } else {
                VeiculoModel veiculo = new VeiculoModel();
                if (!getJtxIdVeiculo().getText().equals("")) {
                    veiculo.setIdVeiculo(Integer.parseInt(getJtxIdVeiculo().getText()));
                }
                veiculo.setModelo(getJtxModelo().getText());
                veiculo.setPlaca(getJtxPlaca().getText());
                veiculo.getMotorista().setNome(getJcbMotorista().getSelectedItem().toString());
                veiculo.getMotorista().setIdMotorista(retornaIdMotorista(veiculo.getMotorista().getNome()));

                VeiculoController controle = new VeiculoController();
                if (controle.inserirComProcedure(veiculo)) {
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
            JOptionPane.showMessageDialog(this, "Selecione um veiculo para poder editar.");
            requisitaFoco();
        } else {
            VeiculoModel veiculo = new VeiculoModel();
            veiculo.setIdVeiculo(Integer.parseInt(getJtxIdVeiculo().getText()));
            veiculo.setModelo(getJtxModelo().getText());
            veiculo.setPlaca(getJtxPlaca().getText());
            veiculo.getMotorista().setNome(getJcbMotorista().getSelectedItem().toString());
            veiculo.getMotorista().setIdMotorista(retornaIdMotorista(veiculo.getMotorista().getNome()));

            VeiculoController controle = new VeiculoController();
            if (controle.editarComProcedure(veiculo)) {
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
            getJtxIdVeiculo().setEnabled(true);
            getJbSelecionar().setEnabled(true);
        }
    }//GEN-LAST:event_jbEditarActionPerformed

    private void jbExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbExcluirActionPerformed
        if (verificarCampos()) {
            JOptionPane.showMessageDialog(this, "Selecione um veiculo para poder excluir.");
            requisitaFoco();
        } else {
            VeiculoModel veiculo = new VeiculoModel();
            veiculo.setIdVeiculo(Integer.parseInt(getJtxIdVeiculo().getText()));

            VeiculoController controle = new VeiculoController();
            if (controle.excluir(veiculo)) {
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
            getJtxIdVeiculo().setEnabled(true);
            getJbSelecionar().setEnabled(true);
        }
    }//GEN-LAST:event_jbExcluirActionPerformed

    private void jbSelecionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSelecionarActionPerformed
        if (getJtxIdVeiculo().getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Campo vazio, informe um campo v�lido!");
            getJtxIdVeiculo().requestFocus();
        } else {
            VeiculoModel veiculo = new VeiculoModel();
            veiculo.setIdVeiculo(Integer.parseInt(getJtxIdVeiculo().getText()));

            VeiculoController controle = new VeiculoController();
            veiculo = controle.selecionar(veiculo);
            if (veiculo != null) {
                getJtxIdVeiculo().setText(String.valueOf(veiculo.getIdVeiculo()));
                getJtxIdVeiculo1().setText(String.valueOf(veiculo.getIdVeiculo()));
                getJtxPlaca().setText(veiculo.getPlaca());
                getJtxModelo().setText(veiculo.getModelo());
                getJcbMotorista().setSelectedItem(retornaNomeMotorista(veiculo.getIdVeiculo()));
                getJbInserir().setEnabled(false);
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
            r.relatorio("RelatorioVeiculos", "", "");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Alerta", 2);
        }
    }//GEN-LAST:event_jbRelatorioActionPerformed

    private void jtVeiculoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtVeiculoMouseClicked
        if (evt.getClickCount() == 2) {

            getJbEditar().setEnabled(true);
            getJbExcluir().setEnabled(true);
            getJbInserir().setEnabled(false);
            getJbRelatorio().setEnabled(false);
            getJbLimpar().setEnabled(false);
            getJtxIdVeiculo().setEnabled(false);
            getJbSelecionar().setEnabled(false);
            int linha = getJtVeiculo().getSelectedRow();
            getJtxIdVeiculo().setText(String.valueOf(getJtVeiculo().getValueAt(linha, 0)));
            getJtxIdVeiculo1().setText(String.valueOf(getJtVeiculo().getValueAt(linha, 0)));
            getJtxPlaca().setText(String.valueOf(getJtVeiculo().getValueAt(linha, 2)));
            getJtxModelo().setText(String.valueOf(getJtVeiculo().getValueAt(linha, 1)));
            getJcbMotorista().setSelectedItem(String.valueOf(getJtVeiculo().getValueAt(linha, 3)));
        }
    }//GEN-LAST:event_jtVeiculoMouseClicked

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
    private javax.swing.JComboBox<String> jcbMotorista;
    private javax.swing.JLabel jlIdVeiculo;
    private javax.swing.JLabel jlModelo;
    private javax.swing.JLabel jlMotorista;
    private javax.swing.JLabel jlPlaca;
    private javax.swing.JLabel jlSelecionar;
    private javax.swing.JTable jtVeiculo;
    private javax.swing.JTextField jtxIdVeiculo;
    private javax.swing.JTextField jtxIdVeiculo1;
    private javax.swing.JTextField jtxModelo;
    private javax.swing.JTextField jtxPlaca;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the motoristas
     */
    public ArrayList<String> getMotoristas() {
        return motoristas;
    }

    /**
     * @param motoristas the motoristas to set
     */
    public void setMotoristas(ArrayList<String> motoristas) {
        this.motoristas = motoristas;
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
     * @return the jcbMotorista
     */
    public javax.swing.JComboBox<String> getJcbMotorista() {
        return jcbMotorista;
    }

    /**
     * @param jcbMotorista the jcbMotorista to set
     */
    public void setJcbMotorista(javax.swing.JComboBox<String> jcbMotorista) {
        this.jcbMotorista = jcbMotorista;
    }

    /**
     * @return the jlIdVeiculo
     */
    public javax.swing.JLabel getJlIdVeiculo() {
        return jlIdVeiculo;
    }

    /**
     * @param jlIdVeiculo the jlIdVeiculo to set
     */
    public void setJlIdVeiculo(javax.swing.JLabel jlIdVeiculo) {
        this.jlIdVeiculo = jlIdVeiculo;
    }

    /**
     * @return the jlModelo
     */
    public javax.swing.JLabel getJlModelo() {
        return jlModelo;
    }

    /**
     * @param jlModelo the jlModelo to set
     */
    public void setJlModelo(javax.swing.JLabel jlModelo) {
        this.jlModelo = jlModelo;
    }

    /**
     * @return the jlMotorista
     */
    public javax.swing.JLabel getJlMotorista() {
        return jlMotorista;
    }

    /**
     * @param jlMotorista the jlMotorista to set
     */
    public void setJlMotorista(javax.swing.JLabel jlMotorista) {
        this.jlMotorista = jlMotorista;
    }

    /**
     * @return the jlPlaca
     */
    public javax.swing.JLabel getJlPlaca() {
        return jlPlaca;
    }

    /**
     * @param jlPlaca the jlPlaca to set
     */
    public void setJlPlaca(javax.swing.JLabel jlPlaca) {
        this.jlPlaca = jlPlaca;
    }

    /**
     * @return the jtVeiculo
     */
    public javax.swing.JTable getJtVeiculo() {
        return jtVeiculo;
    }

    /**
     * @param jtVeiculo the jtVeiculo to set
     */
    public void setJtVeiculo(javax.swing.JTable jtVeiculo) {
        this.jtVeiculo = jtVeiculo;
    }

    /**
     * @return the jtxIdVeiculo
     */
    public javax.swing.JTextField getJtxIdVeiculo() {
        return jtxIdVeiculo;
    }

    /**
     * @param jtxIdVeiculo the jtxIdVeiculo to set
     */
    public void setJtxIdVeiculo(javax.swing.JTextField jtxIdVeiculo) {
        this.jtxIdVeiculo = jtxIdVeiculo;
    }

    /**
     * @return the jtxModelo
     */
    public javax.swing.JTextField getJtxModelo() {
        return jtxModelo;
    }

    /**
     * @param jtxModelo the jtxModelo to set
     */
    public void setJtxModelo(javax.swing.JTextField jtxModelo) {
        this.jtxModelo = jtxModelo;
    }

    /**
     * @return the jtxPlaca
     */
    public javax.swing.JTextField getJtxPlaca() {
        return jtxPlaca;
    }

    /**
     * @param jtxPlaca the jtxPlaca to set
     */
    public void setJtxPlaca(javax.swing.JTextField jtxPlaca) {
        this.jtxPlaca = jtxPlaca;
    }

    /**
     * @return the jtxIdVeiculo1
     */
    public javax.swing.JTextField getJtxIdVeiculo1() {
        return jtxIdVeiculo1;
    }

    /**
     * @param jtxIdVeiculo1 the jtxIdVeiculo1 to set
     */
    public void setJtxIdVeiculo1(javax.swing.JTextField jtxIdVeiculo1) {
        this.jtxIdVeiculo1 = jtxIdVeiculo1;
    }
}
