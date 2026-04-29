package pousadaapp;

import Model.ListaUsuario;
import Model.Usuario;
import java.awt.event.KeyEvent;
import java.util.Arrays;

import javax.swing.JOptionPane;

/**
 *
 * @author FilipeLuizCouto
 */
public class Login extends javax.swing.JFrame {

    public void acessibilidade() {
        btnCadastrarUsuario.setMnemonic(KeyEvent.VK_N);
        btbSalvar.setMnemonic(KeyEvent.VK_S);
        btnEntrar.setMnemonic(KeyEvent.VK_E);
        btnLogin.setMnemonic(KeyEvent.VK_L);
        btnSair.setMnemonic(KeyEvent.VK_Q);
    }

    public Login() {
        initComponents();
        acessibilidade();
        lblNovoUsuario.setVisible(false);
        txtNovoUsuario.setVisible(false);
        lblNovaSenha.setVisible(false);
        txtNovaSenha.setVisible(false);
        lblConfirmaSenha.setVisible(false);
        txtConfirmaSenha.setVisible(false);
        btbSalvar.setVisible(false);

        lblUsuario.setVisible(false);
        txtUsuario.setVisible(false);
        lblSenha.setVisible(false);
        txtSenha.setVisible(false);
        btnEntrar.setVisible(false);
        btnLogin.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PainelMenu = new javax.swing.JPanel();
        btnCadastrarUsuario = new javax.swing.JButton();
        btnLogin = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        PainelTitulo = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        PainelDisplay = new javax.swing.JPanel();
        lblUsuario = new javax.swing.JLabel();
        lblSenha = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        btnEntrar = new javax.swing.JButton();
        lblNovoUsuario = new javax.swing.JLabel();
        txtNovoUsuario = new javax.swing.JTextField();
        lblNovaSenha = new javax.swing.JLabel();
        lblConfirmaSenha = new javax.swing.JLabel();
        btbSalvar = new javax.swing.JButton();
        txtNovaSenha = new javax.swing.JPasswordField();
        txtConfirmaSenha = new javax.swing.JPasswordField();
        txtSenha = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        PainelFundo = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("PousadaApp1.0");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PainelMenu.setBackground(new java.awt.Color(153, 153, 255));
        PainelMenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnCadastrarUsuario.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCadastrarUsuario.setText("Novo");
        btnCadastrarUsuario.setToolTipText("Alt+C");
        btnCadastrarUsuario.setPreferredSize(new java.awt.Dimension(91, 23));
        btnCadastrarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarUsuarioActionPerformed(evt);
            }
        });
        PainelMenu.add(btnCadastrarUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 170, 100, 66));

        btnLogin.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnLogin.setText("Login");
        btnLogin.setToolTipText("Alt+L");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        PainelMenu.add(btnLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 300, 100, 66));

        btnSair.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSair.setText("Sair");
        btnSair.setToolTipText("Alt+Q");
        btnSair.setAutoscrolls(true);
        btnSair.setPreferredSize(new java.awt.Dimension(91, 23));
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });
        PainelMenu.add(btnSair, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 520, 70, 50));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Login");
        PainelMenu.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 40, 126, 45));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("USUÁRIO");
        PainelMenu.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 130, -1, -1));

        getContentPane().add(PainelMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 168, 270, 660));

        PainelTitulo.setBackground(new java.awt.Color(0, 102, 153));
        PainelTitulo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Constantia", 0, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Pousada da Dulci");
        jLabel1.setAlignmentY(0.0F);
        PainelTitulo.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1502, 156));

        getContentPane().add(PainelTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 2840, -1));

        PainelDisplay.setBackground(new java.awt.Color(255, 255, 255));
        PainelDisplay.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblUsuario.setFont(new java.awt.Font("Constantia", 1, 14)); // NOI18N
        lblUsuario.setForeground(new java.awt.Color(0, 102, 153));
        lblUsuario.setText("Usuario:");
        PainelDisplay.add(lblUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, -1, -1));

        lblSenha.setFont(new java.awt.Font("Constantia", 1, 14)); // NOI18N
        lblSenha.setForeground(new java.awt.Color(0, 102, 153));
        lblSenha.setText("Senha");
        PainelDisplay.add(lblSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, -1, -1));

        txtUsuario.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        txtUsuario.setToolTipText("Entre com o Nome de Usuario");
        PainelDisplay.add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 160, 30));

        btnEntrar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnEntrar.setText("Entrar");
        btnEntrar.setToolTipText("Alt+E");
        btnEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntrarActionPerformed(evt);
            }
        });
        PainelDisplay.add(btnEntrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 360, -1, -1));

        lblNovoUsuario.setFont(new java.awt.Font("Constantia", 1, 14)); // NOI18N
        lblNovoUsuario.setForeground(new java.awt.Color(0, 102, 153));
        lblNovoUsuario.setText("Nome de Usuario");
        PainelDisplay.add(lblNovoUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 160, -1));

        txtNovoUsuario.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        txtNovoUsuario.setToolTipText("Digite um Nome para Cadastrar");
        txtNovoUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNovoUsuarioActionPerformed(evt);
            }
        });
        PainelDisplay.add(txtNovoUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 160, 30));

        lblNovaSenha.setFont(new java.awt.Font("Constantia", 1, 14)); // NOI18N
        lblNovaSenha.setForeground(new java.awt.Color(0, 102, 153));
        lblNovaSenha.setText("Senha:");
        PainelDisplay.add(lblNovaSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));

        lblConfirmaSenha.setFont(new java.awt.Font("Constantia", 1, 14)); // NOI18N
        lblConfirmaSenha.setForeground(new java.awt.Color(0, 102, 153));
        lblConfirmaSenha.setText("Confirme a Senha");
        PainelDisplay.add(lblConfirmaSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 160, -1));

        btbSalvar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btbSalvar.setText("Salvar");
        btbSalvar.setToolTipText("Alt+S");
        btbSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btbSalvarActionPerformed(evt);
            }
        });
        PainelDisplay.add(btbSalvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 230, -1, -1));

        txtNovaSenha.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        txtNovaSenha.setToolTipText("Informe uma Senha de 6 Digitos");
        PainelDisplay.add(txtNovaSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 160, 30));

        txtConfirmaSenha.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        txtConfirmaSenha.setToolTipText("Repita a Senha");
        PainelDisplay.add(txtConfirmaSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 160, 30));

        txtSenha.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        txtSenha.setToolTipText("Entre com a Senha do Usuário");
        PainelDisplay.add(txtSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 160, 30));

        getContentPane().add(PainelDisplay, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 170, 280, 660));
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(3264, 168, 1006, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pousadaapp/Pousada3.png"))); // NOI18N

        javax.swing.GroupLayout PainelFundoLayout = new javax.swing.GroupLayout(PainelFundo);
        PainelFundo.setLayout(PainelFundoLayout);
        PainelFundoLayout.setHorizontalGroup(
            PainelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelFundoLayout.createSequentialGroup()
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 974, Short.MAX_VALUE)
                .addContainerGap())
        );
        PainelFundoLayout.setVerticalGroup(
            PainelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelFundoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        getContentPane().add(PainelFundo, new org.netbeans.lib.awtextra.AbsoluteConstraints(558, 160, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadastrarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarUsuarioActionPerformed

        lblUsuario.setVisible(false);
        txtUsuario.setVisible(false);
        lblSenha.setVisible(false);
        txtSenha.setVisible(false);
        btnEntrar.setVisible(false);

        lblNovoUsuario.setVisible(true);
        txtNovoUsuario.setVisible(true);
        lblNovaSenha.setVisible(true);
        txtNovaSenha.setVisible(true);
        lblConfirmaSenha.setVisible(true);
        txtConfirmaSenha.setVisible(true);
        btbSalvar.setVisible(true);


    }//GEN-LAST:event_btnCadastrarUsuarioActionPerformed

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        lblNovoUsuario.setVisible(false);
        txtNovoUsuario.setVisible(false);
        lblNovaSenha.setVisible(false);
        txtNovaSenha.setVisible(false);
        lblConfirmaSenha.setVisible(false);
        txtConfirmaSenha.setVisible(false);
        btbSalvar.setVisible(false);

        lblUsuario.setVisible(true);
        txtUsuario.setVisible(true);
        txtUsuario.setColumns(15);
        lblSenha.setVisible(true);
        txtSenha.setVisible(true);
        txtSenha.setColumns(15);
        btnEntrar.setVisible(true);
    }//GEN-LAST:event_btnLoginActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed

        System.exit(0);
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntrarActionPerformed

        ListaUsuario listaUsuario = new ListaUsuario();

        String NomeUsuario;
        NomeUsuario = txtUsuario.getText();
        String SenhaUsuario;
        SenhaUsuario = txtSenha.getText();
        if (listaUsuario.validar(NomeUsuario, SenhaUsuario)) {
            TelaInicio inicio = new TelaInicio();
            inicio.setVisible(true);
            txtUsuario.setText("");
            txtSenha.setText("");
        } else {
            JOptionPane.showMessageDialog(null, "Usuário e/ou Senha Inválidos");
        }

    }//GEN-LAST:event_btnEntrarActionPerformed

    private void btbSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btbSalvarActionPerformed
    Usuario usuario = new Usuario();
    ListaUsuario listaUsuario = new ListaUsuario();

    char[] senha = txtNovaSenha.getPassword();
    char[] confirmaSenha = txtConfirmaSenha.getPassword();

    if (!Arrays.equals(senha, confirmaSenha)) {
        JOptionPane.showMessageDialog(null, "Senha e Confirmação não conferem\nDigite novamente");
        txtNovaSenha.setText("");
        txtConfirmaSenha.setText("");
    } else if (txtNovoUsuario.getText().isEmpty() || senha.length == 0 || confirmaSenha.length == 0) {
        JOptionPane.showMessageDialog(null, "Todos os Campos devem ser Preenchidos");
    } else if (senha.length < 6) {
        JOptionPane.showMessageDialog(null, "A senha deve ter no mínimo 6 caracteres");
    } else {
        usuario.setNome(txtNovoUsuario.getText());
        usuario.setSenha(new String(senha)); // cuidado com segurança ao armazenar senhas como String
        listaUsuario.adicionar(usuario);

        btnLogin.setVisible(true);
        txtNovoUsuario.setText("");
        txtNovaSenha.setText("");
        txtConfirmaSenha.setText("");
    }
       
    }//GEN-LAST:event_btbSalvarActionPerformed

    private void txtNovoUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNovoUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNovoUsuarioActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PainelDisplay;
    private javax.swing.JPanel PainelFundo;
    private javax.swing.JPanel PainelMenu;
    private javax.swing.JPanel PainelTitulo;
    private javax.swing.JButton btbSalvar;
    private javax.swing.JButton btnCadastrarUsuario;
    private javax.swing.JButton btnEntrar;
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnSair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel lblConfirmaSenha;
    private javax.swing.JLabel lblNovaSenha;
    private javax.swing.JLabel lblNovoUsuario;
    private javax.swing.JLabel lblSenha;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JPasswordField txtConfirmaSenha;
    private javax.swing.JPasswordField txtNovaSenha;
    private javax.swing.JTextField txtNovoUsuario;
    private javax.swing.JPasswordField txtSenha;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
