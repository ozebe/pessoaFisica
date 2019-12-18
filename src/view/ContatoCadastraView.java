/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import control.ConnectionFactory;
import control.Contato;
import control.INI;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author wesley.santos
 */
public class ContatoCadastraView extends javax.swing.JFrame {

    private static Connection connection;
    private static ConnectionFactory fabrica = new ConnectionFactory();
    //pega o caminho da base no arquivo .ini
//    public static INI db;
//    public static INI user;
//    public static INI password;
    public static INI db = new INI("db-config", "local");
    public static INI user = new INI("db-config", "user");
    public static INI password = new INI("db-config", "password");

    /**
     * Creates new form ContatoCadastraView
     */
    public ContatoCadastraView() {
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        emailField = new javax.swing.JTextField();
        telefoneField = new javax.swing.JTextField();
        dddField = new javax.swing.JTextField();
        cadastrarBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Cadastrar Contato");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("DDD:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Telefone:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Email:");

        emailField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                emailFieldKeyPressed(evt);
            }
        });

        telefoneField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                telefoneFieldKeyPressed(evt);
            }
        });

        dddField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                dddFieldKeyPressed(evt);
            }
        });

        cadastrarBtn.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cadastrarBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/save.png"))); // NOI18N
        cadastrarBtn.setText("Cadastrar");
        cadastrarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(42, 42, 42)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(telefoneField, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dddField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cadastrarBtn)
                            .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(31, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(dddField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(telefoneField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(cadastrarBtn)
                .addGap(26, 26, 26))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        int output = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja sair?", "Sair", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (output == 0) {
            PessoaCadastraView.cadContatoBtn.setEnabled(true);
            this.dispose();
        } else if (output == 1) {

        }
    }//GEN-LAST:event_formWindowClosing

    private void cadastrarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarBtnActionPerformed
        String telefoneFormatado = telefoneField.getText().trim();
        telefoneFormatado = telefoneFormatado.replaceAll("[^0-9]+", "");

        String dddFormatado = dddField.getText();
        dddFormatado = dddFormatado.replaceAll("[^0-9]+", "");
        if (!iscadastrado()) {

            Contato c = new Contato();
            c.setDdd(dddFormatado);
            c.setTelefone(telefoneFormatado);
            c.setEmail(emailField.getText().toLowerCase());

            PessoaCadastraView.setContato(c);
            
            PessoaCadastraView.cadContatoBtn.setEnabled(false);
            PessoaCadastraView.contatoLabel.setText("(" + PessoaCadastraView.getContato().getDdd() + ") " + PessoaCadastraView.getContato().getTelefone());
            PessoaCadastraView.cadastraContato = true;
            this.dispose();

        } else {
            JOptionPane.showMessageDialog(null, "Já existem cadastros com as informações de contato passadas!\n", "Erro", JOptionPane.ERROR_MESSAGE);

            int output = JOptionPane.showConfirmDialog(null, "Deseja apenas vincular o contato ao usuario?", "Sair", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (output == 0) {
                
                Contato c = new Contato();
                c.setDdd(dddFormatado);
                c.setTelefone(telefoneFormatado);
                c.setEmail(emailField.getText().toLowerCase());

                PessoaCadastraView.setContato(c);

                PessoaCadastraView.cadContatoBtn.setEnabled(false);
                PessoaCadastraView.contatoLabel.setText("(" + PessoaCadastraView.getContato().getDdd() + ") " + PessoaCadastraView.getContato().getTelefone());
                this.dispose();
            } else if (output == 1) {

            }
        }
    }//GEN-LAST:event_cadastrarBtnActionPerformed

    private void dddFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dddFieldKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            telefoneField.requestFocus();
        }
    }//GEN-LAST:event_dddFieldKeyPressed

    private void telefoneFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_telefoneFieldKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            emailField.requestFocus();
        }
    }//GEN-LAST:event_telefoneFieldKeyPressed

    private void emailFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_emailFieldKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            cadastrarBtn.requestFocus();
        }
    }//GEN-LAST:event_emailFieldKeyPressed

    public boolean iscadastrado() {
        try {
            connection = fabrica.getConnection(db.getDir(), user.getDir(), password.getDir());

            PreparedStatement stmt = connection.prepareStatement("select count(id) as res from contato\n"
                    + "where (ddd = ? and telefone = ?);");
            stmt.setString(1, dddField.getText());
            stmt.setString(2, telefoneField.getText());
            ResultSet resultSet = stmt.executeQuery();

            while (resultSet.next()) {
                if (resultSet.getInt("res") != 0) {
                    resultSet.close();
                    stmt.close();
                    connection.close();
                    return true;
                } else {
                    resultSet.close();
                    stmt.close();
                    connection.close();
                    return false;
                }
            }

        } catch (ClassNotFoundException | SQLException | IOException ex) {
            Logger.getLogger(ContatoCadastraView.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro!\n" + ex, "Erro", JOptionPane.ERROR_MESSAGE);

        }
        return false;
    }
    

    /**
     * @param args the command line arguments
     */
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
//            java.util.logging.Logger.getLogger(ContatoCadastraView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(ContatoCadastraView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(ContatoCadastraView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(ContatoCadastraView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new ContatoCadastraView().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cadastrarBtn;
    private javax.swing.JTextField dddField;
    private javax.swing.JTextField emailField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField telefoneField;
    // End of variables declaration//GEN-END:variables
}
