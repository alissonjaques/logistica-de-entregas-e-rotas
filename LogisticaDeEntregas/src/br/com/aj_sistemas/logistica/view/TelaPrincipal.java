package br.com.aj_sistemas.logistica.view;

import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Alisson Jaques
 */
public class TelaPrincipal extends javax.swing.JFrame {

    private MotoristaView telaMotorista;
    private VeiculoView telaVeiculo;
    private PacoteView telaPacotes;
    private RotaView telaRota;
    private VeiculoRotaView telaVeiculoRota;

    /**
     * Creates new form TelaPrincipal
     */
    public TelaPrincipal() {
        initComponents();
    }

    private void centralizarJInternalFrame(JInternalFrame frame) {

        int lDesk = getJdpPrincipal().getWidth();
        int aDesk = getJdpPrincipal().getHeight();

        int lFrame = frame.getWidth();
        int aFrame = frame.getHeight();

        frame.setLocation(lDesk / 2 - lFrame / 2, aDesk / 2 - aFrame / 2);

    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jdpPrincipal = new javax.swing.JDesktopPane();
        jlImagemRotaVeiculo = new javax.swing.JLabel();
        jmbMenus = new javax.swing.JMenuBar();
        jmLogin = new javax.swing.JMenu();
        jmiLogin = new javax.swing.JMenuItem();
        jmiSair = new javax.swing.JMenuItem();
        jmICadastro = new javax.swing.JMenu();
        jmiCadastroMotorista = new javax.swing.JMenuItem();
        jmiVeiculo = new javax.swing.JMenuItem();
        jmiPacote = new javax.swing.JMenuItem();
        jmiRota = new javax.swing.JMenuItem();
        jmiVeiculoRota = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Logística de Entregas");
        setSize(new java.awt.Dimension(900, 800));

        jdpPrincipal.setBackground(new java.awt.Color(204, 204, 204));
        jdpPrincipal.setPreferredSize(new java.awt.Dimension(900, 800));

        jlImagemRotaVeiculo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/aj_sistemas/logistica/img/rotas.png"))); // NOI18N

        jdpPrincipal.setLayer(jlImagemRotaVeiculo, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jdpPrincipalLayout = new javax.swing.GroupLayout(jdpPrincipal);
        jdpPrincipal.setLayout(jdpPrincipalLayout);
        jdpPrincipalLayout.setHorizontalGroup(
            jdpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jdpPrincipalLayout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addComponent(jlImagemRotaVeiculo)
                .addContainerGap())
        );
        jdpPrincipalLayout.setVerticalGroup(
            jdpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jdpPrincipalLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jlImagemRotaVeiculo)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        jmLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/aj_sistemas/logistica/img/user32.png"))); // NOI18N
        jmLogin.setText("Login");
        jmLogin.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N

        jmiLogin.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jmiLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/aj_sistemas/logistica/img/PessoaFisica.png"))); // NOI18N
        jmiLogin.setText("Login");
        jmiLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiLoginActionPerformed(evt);
            }
        });
        jmLogin.add(jmiLogin);

        jmiSair.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jmiSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/aj_sistemas/logistica/img/close_32.png"))); // NOI18N
        jmiSair.setText("Sair");
        jmiSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiSairActionPerformed(evt);
            }
        });
        jmLogin.add(jmiSair);

        jmbMenus.add(jmLogin);

        jmICadastro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/aj_sistemas/logistica/img/addbk_32.png"))); // NOI18N
        jmICadastro.setText("Cadastro");
        jmICadastro.setEnabled(false);
        jmICadastro.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jmICadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmICadastroActionPerformed(evt);
            }
        });

        jmiCadastroMotorista.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jmiCadastroMotorista.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/aj_sistemas/logistica/img/PessoaFisica.png"))); // NOI18N
        jmiCadastroMotorista.setText("Motorista");
        jmiCadastroMotorista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiCadastroMotoristaActionPerformed(evt);
            }
        });
        jmICadastro.add(jmiCadastroMotorista);

        jmiVeiculo.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jmiVeiculo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/aj_sistemas/logistica/img/truck-icon.png"))); // NOI18N
        jmiVeiculo.setText("Veículo");
        jmiVeiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiVeiculoActionPerformed(evt);
            }
        });
        jmICadastro.add(jmiVeiculo);

        jmiPacote.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jmiPacote.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/aj_sistemas/logistica/img/hist_32.png"))); // NOI18N
        jmiPacote.setText("Pacote");
        jmiPacote.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiPacoteActionPerformed(evt);
            }
        });
        jmICadastro.add(jmiPacote);

        jmiRota.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jmiRota.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/aj_sistemas/logistica/img/terra32.png"))); // NOI18N
        jmiRota.setText("Rota");
        jmiRota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiRotaActionPerformed(evt);
            }
        });
        jmICadastro.add(jmiRota);

        jmiVeiculoRota.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jmiVeiculoRota.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/aj_sistemas/logistica/img/route-icon.png"))); // NOI18N
        jmiVeiculoRota.setText("Veículo-Rota");
        jmiVeiculoRota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiVeiculoRotaActionPerformed(evt);
            }
        });
        jmICadastro.add(jmiVeiculoRota);

        jmbMenus.add(jmICadastro);

        setJMenuBar(jmbMenus);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jdpPrincipal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jdpPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jmiLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiLoginActionPerformed
        TelaDeLogin tl = new TelaDeLogin(this, true);
        tl.setVisible(true);
    }//GEN-LAST:event_jmiLoginActionPerformed

    private void jmiSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiSairActionPerformed
        int op = JOptionPane.showConfirmDialog(this, "Deseja mesmo sair do sistema?", "Sair", JOptionPane.OK_CANCEL_OPTION);

        if (op == 0) {
            dispose();
        }
    }//GEN-LAST:event_jmiSairActionPerformed

    private void jmiCadastroMotoristaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiCadastroMotoristaActionPerformed
        if (getTelaMotorista() == null) {
            setTelaMotorista(new MotoristaView());
            getJdpPrincipal().add(getTelaMotorista());
            getTelaMotorista().setVisible(true);
            centralizarJInternalFrame(getTelaMotorista());
        } else if (getTelaMotorista() != null) {
            if (getTelaMotorista().isClosed()) {
                setTelaMotorista(new MotoristaView());
                getJdpPrincipal().add(getTelaMotorista());
                getTelaMotorista().setVisible(true);
                centralizarJInternalFrame(getTelaMotorista());
            }
        }
    }//GEN-LAST:event_jmiCadastroMotoristaActionPerformed

    private void jmICadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmICadastroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jmICadastroActionPerformed

    private void jmiVeiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiVeiculoActionPerformed
        if (getTelaVeiculo() == null) {
            setTelaVeiculo(new VeiculoView());
            getJdpPrincipal().add(getTelaVeiculo());
            getTelaVeiculo().setVisible(true);
            centralizarJInternalFrame(getTelaVeiculo());
        } else if (getTelaVeiculo() != null) {
            if (getTelaVeiculo().isClosed()) {
                setTelaVeiculo(new VeiculoView());
                getJdpPrincipal().add(getTelaVeiculo());
                getTelaVeiculo().setVisible(true);
                centralizarJInternalFrame(getTelaVeiculo());
            }
        }
    }//GEN-LAST:event_jmiVeiculoActionPerformed

    private void jmiPacoteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiPacoteActionPerformed
        if (getTelaPacotes() == null) {
            setTelaPacotes(new PacoteView());
            getJdpPrincipal().add(getTelaPacotes());
            getTelaPacotes().setVisible(true);
            centralizarJInternalFrame(getTelaPacotes());
        } else if (getTelaPacotes() != null) {
            if (getTelaPacotes().isClosed()) {
                setTelaPacotes(new PacoteView());
                getJdpPrincipal().add(getTelaPacotes());
                getTelaPacotes().setVisible(true);
                centralizarJInternalFrame(getTelaPacotes());
            }
        }
    }//GEN-LAST:event_jmiPacoteActionPerformed

    private void jmiRotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiRotaActionPerformed
        if (getTelaRota() == null) {
            setTelaRota(new RotaView());
            getJdpPrincipal().add(getTelaRota());
            getTelaRota().setVisible(true);
            centralizarJInternalFrame(getTelaRota());
        } else if (getTelaRota() != null) {
            if (getTelaRota().isClosed()) {
                setTelaRota(new RotaView());
                getJdpPrincipal().add(getTelaRota());
                getTelaRota().setVisible(true);
                centralizarJInternalFrame(getTelaRota());
            }
        }
    }//GEN-LAST:event_jmiRotaActionPerformed

    private void jmiVeiculoRotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiVeiculoRotaActionPerformed
        if (getTelaVeiculoRota() == null) {
            setTelaVeiculoRota(new VeiculoRotaView());
            getJdpPrincipal().add(getTelaVeiculoRota());
            getTelaVeiculoRota().setVisible(true);
            centralizarJInternalFrame(getTelaVeiculoRota());
        } else if (getTelaVeiculoRota() != null) {
            if (getTelaVeiculoRota().isClosed()) {
                setTelaVeiculoRota(new VeiculoRotaView());
                getJdpPrincipal().add(getTelaVeiculoRota());
                getTelaVeiculoRota().setVisible(true);
                centralizarJInternalFrame(getTelaVeiculoRota());
            }
        }
    }//GEN-LAST:event_jmiVeiculoRotaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem jMenuItem1;
    public javax.swing.JDesktopPane jdpPrincipal;
    private javax.swing.JLabel jlImagemRotaVeiculo;
    private javax.swing.JMenu jmICadastro;
    private javax.swing.JMenu jmLogin;
    private javax.swing.JMenuBar jmbMenus;
    private javax.swing.JMenuItem jmiCadastroMotorista;
    private javax.swing.JMenuItem jmiLogin;
    private javax.swing.JMenuItem jmiPacote;
    private javax.swing.JMenuItem jmiRota;
    private javax.swing.JMenuItem jmiSair;
    private javax.swing.JMenuItem jmiVeiculo;
    private javax.swing.JMenuItem jmiVeiculoRota;
    // End of variables declaration//GEN-END:variables
    
    /**
     * @return the telaVeiculoRota
     */
    public VeiculoRotaView getTelaVeiculoRota() {
        return telaVeiculoRota;
    }

    /**
     * @param telaVeiculoRota the telaVeiculoRota to set
     */
    public void setTelaVeiculoRota(VeiculoRotaView telaVeiculoRota) {
        this.telaVeiculoRota = telaVeiculoRota;
    }
    
    /**
     * @return the telaRota
     */
    public RotaView getTelaRota() {
        return telaRota;
    }

    /**
     * @param telaRota the telaRota to set
     */
    public void setTelaRota(RotaView telaRota) {
        this.telaRota = telaRota;
    }

    /**
     * @return the telaPacotes
     */
    public PacoteView getTelaPacotes() {
        return telaPacotes;
    }

    /**
     * @param telaPacotes the telaPacotes to set
     */
    public void setTelaPacotes(PacoteView telaPacotes) {
        this.telaPacotes = telaPacotes;
    }

    /**
     * @return the telaVeiculo
     */
    public VeiculoView getTelaVeiculo() {
        return telaVeiculo;
    }

    /**
     * @param telaVeiculo the telaVeiculo to set
     */
    public void setTelaVeiculo(VeiculoView telaVeiculo) {
        this.telaVeiculo = telaVeiculo;
    }

    /**
     * @return the telaMotorista
     */
    public MotoristaView getTelaMotorista() {
        return telaMotorista;
    }

    /**
     * @param telaMotorista the telaMotorista to set
     */
    public void setTelaMotorista(MotoristaView telaMotorista) {
        this.telaMotorista = telaMotorista;
    }

    /**
     * @return the jdpPrincipal
     */
    public javax.swing.JDesktopPane getJdpPrincipal() {
        return jdpPrincipal;
    }

    /**
     * @param jdpPrincipal the jdpPrincipal to set
     */
    public void setJdpPrincipal(javax.swing.JDesktopPane jdpPrincipal) {
        this.jdpPrincipal = jdpPrincipal;
    }

    /**
     * @return the jmLogin
     */
    public javax.swing.JMenu getJmLogin() {
        return jmLogin;
    }

    /**
     * @param jmLogin the jmLogin to set
     */
    public void setJmLogin(javax.swing.JMenu jmLogin) {
        this.jmLogin = jmLogin;
    }

    /**
     * @return the jmbMenus
     */
    public javax.swing.JMenuBar getJmbMenus() {
        return jmbMenus;
    }

    /**
     * @param jmbMenus the jmbMenus to set
     */
    public void setJmbMenus(javax.swing.JMenuBar jmbMenus) {
        this.jmbMenus = jmbMenus;
    }

    /**
     * @return the jmiCadastroMotorista
     */
    public javax.swing.JMenuItem getJmiCadastroMotorista() {
        return jmiCadastroMotorista;
    }

    /**
     * @param jmiCadastroMotorista the jmiCadastroMotorista to set
     */
    public void setJmiCadastroMotorista(javax.swing.JMenuItem jmiCadastroMotorista) {
        this.jmiCadastroMotorista = jmiCadastroMotorista;
    }

    /**
     * @return the jmiLogin
     */
    public javax.swing.JMenuItem getJmiLogin() {
        return jmiLogin;
    }

    /**
     * @param jmiLogin the jmiLogin to set
     */
    public void setJmiLogin(javax.swing.JMenuItem jmiLogin) {
        this.jmiLogin = jmiLogin;
    }

    /**
     * @return the jmiSair
     */
    public javax.swing.JMenuItem getJmiSair() {
        return jmiSair;
    }

    /**
     * @param jmiSair the jmiSair to set
     */
    public void setJmiSair(javax.swing.JMenuItem jmiSair) {
        this.jmiSair = jmiSair;
    }

    /**
     * @return the jmICadastro
     */
    public javax.swing.JMenu getJmICadastro() {
        return jmICadastro;
    }

    /**
     * @param jmICadastro the jmICadastro to set
     */
    public void setJmICadastro(javax.swing.JMenu jmICadastro) {
        this.jmICadastro = jmICadastro;
    }

    /**
     * @return the jMenuItem1
     */
    public javax.swing.JMenuItem getjMenuItem1() {
        return jMenuItem1;
    }

    /**
     * @param jMenuItem1 the jMenuItem1 to set
     */
    public void setjMenuItem1(javax.swing.JMenuItem jMenuItem1) {
        this.jMenuItem1 = jMenuItem1;
    }

    /**
     * @return the jMenuItem3
     */
    public javax.swing.JMenuItem getjMenuItem3() {
        return getJmiPacote();
    }

    /**
     * @param jMenuItem3 the jMenuItem3 to set
     */
    public void setjMenuItem3(javax.swing.JMenuItem jMenuItem3) {
        this.setJmiPacote(jMenuItem3);
    }

    /**
     * @return the jMenuItem4
     */
    public javax.swing.JMenuItem getjMenuItem4() {
        return jmiRota;
    }

    /**
     * @param jMenuItem4 the jMenuItem4 to set
     */
    public void setjMenuItem4(javax.swing.JMenuItem jMenuItem4) {
        this.jmiRota = jMenuItem4;
    }

    /**
     * @return the jmiVeiculo
     */
    public javax.swing.JMenuItem getJmiVeiculo() {
        return jmiVeiculo;
    }

    /**
     * @param jmiVeiculo the jmiVeiculo to set
     */
    public void setJmiVeiculo(javax.swing.JMenuItem jmiVeiculo) {
        this.jmiVeiculo = jmiVeiculo;
    }

    /**
     * @return the jmiPacote
     */
    public javax.swing.JMenuItem getJmiPacote() {
        return jmiPacote;
    }

    /**
     * @param jmiPacote the jmiPacote to set
     */
    public void setJmiPacote(javax.swing.JMenuItem jmiPacote) {
        this.jmiPacote = jmiPacote;
    }
}
