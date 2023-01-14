/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.aj_sistemas.logistica.view;

import javax.swing.JOptionPane;

/**
 *
 * @author licin
 */
public class TelaDeLogin extends javax.swing.JDialog {

    /*
    * Campos da classe
    */
    private TelaPrincipal tp;           // a tela principal
    private String usuarioFix = "admin";// nome de usu�rio padr�o 
    private String senhaFix = "admin";  // senha de acesso padr�o
    
    /**
     * Creates new form TelaDeLogin
     * @param parent
     * @param modal
     */
    public TelaDeLogin(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();        
        tp = (TelaPrincipal) parent;      
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pLogin = new javax.swing.JPanel();
        lTitulo = new javax.swing.JLabel();
        lUsuario = new javax.swing.JLabel();
        lSenha = new javax.swing.JLabel();
        pfSenha = new javax.swing.JPasswordField();
        btnConfirmar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        tfUsuario = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lTitulo.setFont(new java.awt.Font("SansSerif", 1, 30)); // NOI18N
        lTitulo.setText("Login Log�stica");

        lUsuario.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        lUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/aj_sistemas/logistica/img/PessoaFisica.png"))); // NOI18N
        lUsuario.setText("Usu�rio:");

        lSenha.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        lSenha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/aj_sistemas/logistica/img/lock_32.png"))); // NOI18N
        lSenha.setText("Senha:");

        pfSenha.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N

        btnConfirmar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/aj_sistemas/logistica/img/ico_processado.png"))); // NOI18N
        btnConfirmar.setText("Confirmar");
        btnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarActionPerformed(evt);
            }
        });

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/aj_sistemas/logistica/img/cancel_1.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        tfUsuario.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N

        javax.swing.GroupLayout pLoginLayout = new javax.swing.GroupLayout(pLogin);
        pLogin.setLayout(pLoginLayout);
        pLoginLayout.setHorizontalGroup(
            pLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pLoginLayout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(pLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lUsuario)
                    .addComponent(lSenha))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pLoginLayout.createSequentialGroup()
                        .addComponent(btnConfirmar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(tfUsuario)
                    .addComponent(pfSenha))
                .addGap(103, 103, 103))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pLoginLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lTitulo)
                .addGap(114, 114, 114))
        );
        pLoginLayout.setVerticalGroup(
            pLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pLoginLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lUsuario)
                    .addComponent(tfUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lSenha)
                    .addComponent(pfSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addGroup(pLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnConfirmar)
                    .addComponent(btnCancelar))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pLogin, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
        String usuario = getTfUsuario().getText();
        String senha = String.valueOf(getPfSenha().getPassword());
        if(usuario.equals(getUsuarioFix()) && senha.equals(getSenhaFix())){
            getTp().getJmICadastro().setEnabled(true);
            //getTp().getJmconsuta().setEnabled(true);
            getTp().getJmiLogin().setEnabled(false);
            dispose();
        }
        else{
            JOptionPane.showMessageDialog(this, "Usu�rio ou senha inv�lidos!", "Erro ao Logar no sistema", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnConfirmarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JLabel lSenha;
    private javax.swing.JLabel lTitulo;
    private javax.swing.JLabel lUsuario;
    private javax.swing.JPanel pLogin;
    private javax.swing.JPasswordField pfSenha;
    private javax.swing.JTextField tfUsuario;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the btnCancelar
     */
    public javax.swing.JButton getBtnCancelar() {
        return btnCancelar;
    }

    /**
     * @param btnCancelar the btnCancelar to set
     */
    public void setBtnCancelar(javax.swing.JButton btnCancelar) {
        this.btnCancelar = btnCancelar;
    }

    /**
     * @return the btnConfirmar
     */
    public javax.swing.JButton getBtnConfirmar() {
        return btnConfirmar;
    }

    /**
     * @param btnConfirmar the btnConfirmar to set
     */
    public void setBtnConfirmar(javax.swing.JButton btnConfirmar) {
        this.btnConfirmar = btnConfirmar;
    }

    /**
     * @return the lSenha
     */
    public javax.swing.JLabel getlSenha() {
        return lSenha;
    }

    /**
     * @param lSenha the lSenha to set
     */
    public void setlSenha(javax.swing.JLabel lSenha) {
        this.lSenha = lSenha;
    }

    /**
     * @return the lTitulo
     */
    public javax.swing.JLabel getlTitulo() {
        return lTitulo;
    }

    /**
     * @param lTitulo the lTitulo to set
     */
    public void setlTitulo(javax.swing.JLabel lTitulo) {
        this.lTitulo = lTitulo;
    }

    /**
     * @return the lUsuario
     */
    public javax.swing.JLabel getlUsuario() {
        return lUsuario;
    }

    /**
     * @param lUsuario the lUsuario to set
     */
    public void setlUsuario(javax.swing.JLabel lUsuario) {
        this.lUsuario = lUsuario;
    }

    /**
     * @return the pLogin
     */
    public javax.swing.JPanel getpLogin() {
        return pLogin;
    }

    /**
     * @param pLogin the pLogin to set
     */
    public void setpLogin(javax.swing.JPanel pLogin) {
        this.pLogin = pLogin;
    }

    /**
     * @return the pfSenha
     */
    public javax.swing.JPasswordField getPfSenha() {
        return pfSenha;
    }

    /**
     * @param pfSenha the pfSenha to set
     */
    public void setPfSenha(javax.swing.JPasswordField pfSenha) {
        this.pfSenha = pfSenha;
    }

    /**
     * @return the tfUsuario
     */
    public javax.swing.JTextField getTfUsuario() {
        return tfUsuario;
    }

    /**
     * @param tfUsuario the tfUsuario to set
     */
    public void setTfUsuario(javax.swing.JTextField tfUsuario) {
        this.tfUsuario = tfUsuario;
    }

    /**
     * @return the tp
     */
    public TelaPrincipal getTp() {
        return tp;
    }

    /**
     * @param tp the tp to set
     */
    public void setTp(TelaPrincipal tp) {
        this.tp = tp;
    }

    /**
     * @return the usuarioFix
     */
    public String getUsuarioFix() {
        return usuarioFix;
    }

    /**
     * @param usuarioFix the usuarioFix to set
     */
    public void setUsuarioFix(String usuarioFix) {
        this.usuarioFix = usuarioFix;
    }

    /**
     * @return the senhaFix
     */
    public String getSenhaFix() {
        return senhaFix;
    }

    /**
     * @param senhaFix the senhaFix to set
     */
    public void setSenhaFix(String senhaFix) {
        this.senhaFix = senhaFix;
    }
}
