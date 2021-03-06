/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import control.ConnectionFactory;
import control.Endereco;
import control.INI;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.codehaus.jackson.map.ObjectMapper;

/**
 *
 * @author wesley.santos
 */
public class EnderecoCadastraView extends javax.swing.JFrame {

    private Endereco endereco;

    private static Connection connection;
    private static ConnectionFactory fabrica = new ConnectionFactory();
    //pega o caminho da base no arquivo .ini
    public static INI db = new INI("db-config", "local");

    public static INI user = new INI("db-config", "user");
    public static INI password = new INI("db-config", "password");
//
//    db  = new INI(chave, valor);
//    user  = new INI(chave, usuario);
//    password  = new INI(chave, senha);

    /**
     * Creates new form EnderecoCadastraView
     */
    public EnderecoCadastraView() {
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
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        CepField = new javax.swing.JTextField();
        logradouroField = new javax.swing.JTextField();
        numeroField = new javax.swing.JTextField();
        complementoField = new javax.swing.JTextField();
        bairroField = new javax.swing.JTextField();
        localidadeField = new javax.swing.JTextField();
        ufField = new javax.swing.JTextField();
        cadastrarBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Cadastro Endereço");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("CEP:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Logradouro");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Complemento:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Bairro:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Localidade:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("UF:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Número:");

        CepField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                CepFieldFocusLost(evt);
            }
        });

        numeroField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                numeroFieldKeyPressed(evt);
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
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel7))
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(CepField)
                            .addComponent(logradouroField)
                            .addComponent(numeroField, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cadastrarBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                            .addComponent(complementoField)
                            .addComponent(bairroField)
                            .addComponent(localidadeField)
                            .addComponent(ufField))))
                .addContainerGap(140, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(CepField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(logradouroField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(numeroField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(complementoField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(bairroField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(localidadeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(ufField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(cadastrarBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cadastrarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarBtnActionPerformed
        if (!iscadastrado()) {
            cadastra();
            PessoaCadastraView.cadastraEndereco = true;
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "O endereço de CEP  e número já esta cadastrado!\n", "Erro", JOptionPane.ERROR_MESSAGE);

            int output = JOptionPane.showConfirmDialog(null, "Deseja apenas vincular o endereço ao usuario?", "Sair", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (output == 0) {
                cadastra();
                PessoaCadastraView.cadastraEndereco = false;
                this.dispose();
            } else if (output == 1) {

            }

        }

    }//GEN-LAST:event_cadastrarBtnActionPerformed

    private void CepFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_CepFieldFocusLost

        final ObjectMapper mapper = new ObjectMapper();
        try {
            String enderecoFormatado = CepField.getText().trim();
            enderecoFormatado = enderecoFormatado.replaceAll("[^0-9]+", "");

            Endereco e = mapper.readValue(buscarCep(enderecoFormatado), Endereco.class);
            CepField.setText(enderecoFormatado);
            logradouroField.setText(e.getLogradouro());
            bairroField.setText(e.getBairro());
            localidadeField.setText(e.getLocalidade());
            ufField.setText(e.getUf());

            logradouroField.setEditable(false);
            bairroField.setEditable(false);
            localidadeField.setEditable(false);
            ufField.setEditable(false);

            this.endereco = e;
            this.endereco.setCep(enderecoFormatado);

            numeroField.requestFocus();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar CEP!\n" + ex, "Erro", JOptionPane.ERROR_MESSAGE);

            logradouroField.setText("");
            bairroField.setText("");
            localidadeField.setText("");
            ufField.setText("");

            logradouroField.setEditable(true);
            bairroField.setEditable(true);
            localidadeField.setEditable(true);
            ufField.setEditable(true);
        }

    }//GEN-LAST:event_CepFieldFocusLost

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        int output = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja sair?", "Sair", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (output == 0) {
            PessoaCadastraView.cadEnderecoBtn.setEnabled(true);
            this.dispose();
        } else if (output == 1) {

        }
    }//GEN-LAST:event_formWindowClosing

    private void numeroFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_numeroFieldKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (!iscadastrado()) {
                cadastra();
                PessoaCadastraView.cadastraEndereco = true;
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "O endereço de CEP  e número já esta cadastrado!\n", "Erro", JOptionPane.ERROR_MESSAGE);
                
                int output = JOptionPane.showConfirmDialog(null, "Deseja apenas vincular o endereço ao usuario?", "Sair", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (output == 0) {
                    cadastra();
                    PessoaCadastraView.cadastraEndereco = false;
                    this.dispose();
                } else if (output == 1) {

                }
            }

        }

    }//GEN-LAST:event_numeroFieldKeyPressed

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
//            java.util.logging.Logger.getLogger(EnderecoCadastraView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(EnderecoCadastraView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(EnderecoCadastraView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(EnderecoCadastraView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new EnderecoCadastraView().setVisible(true);
//            }
//        });
//    }
    private static String buscarCep(String cep) throws MalformedURLException, IOException {
        String json;
        URL url = new URL("http://viacep.com.br/ws/" + cep + "/json");
        URLConnection urlConnection = url.openConnection();
        InputStream is = urlConnection.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));

        StringBuilder jsonSb = new StringBuilder();

        br.lines().forEach(l -> jsonSb.append(l.trim()));

        json = jsonSb.toString();
        return json;
    }

    private void cadastra() {
        String numeroFormatado = numeroField.getText();
        numeroFormatado = numeroFormatado.replaceAll("[^0-9]+", "");
        try {
            this.endereco.setNumero(Integer.parseInt(numeroFormatado));
            this.endereco.setComplemento(complementoField.getText());

            //se o cep não pegou automaticamente
//            this.endereco.setLogradouro(logradouroField.getText());
//            this.endereco.setBairro(bairroField.getText());
//            this.endereco.setLocalidade(localidadeField.getText());
//            this.endereco.setUf(ufField.getText());
            PessoaCadastraView.setEndereco(this.endereco);
            PessoaCadastraView.cadEnderecoBtn.setEnabled(true);
            PessoaCadastraView.enderecoLabel.setText(PessoaCadastraView.getEndereco().getLogradouro() + ", " + PessoaCadastraView.getEndereco().getNumero());

            PessoaCadastraView.cadEnderecoBtn.setEnabled(false);

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Número incorreto!\n" + e, "Erro", JOptionPane.ERROR_MESSAGE);

        }
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public boolean iscadastrado() {

        String numeroFormatado = numeroField.getText();
        numeroFormatado = numeroFormatado.replaceAll("[^0-9]+", "");

        String enderecoFormatado = CepField.getText().trim();
        enderecoFormatado = enderecoFormatado.replaceAll("[^0-9]+", "");
        try {
            connection = fabrica.getConnection(db.getDir(), user.getDir(), password.getDir());

            PreparedStatement stmt = connection.prepareStatement("select count(e.id) as ende\n"
                    + "from endereco e\n"
                    + "where e.cep= ? and e.numero = ?");

            stmt.setString(1, enderecoFormatado);
            stmt.setInt(2, Integer.parseInt(numeroFormatado));

            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                if (resultSet.getInt("ende") != 0) {
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField CepField;
    private javax.swing.JTextField bairroField;
    private javax.swing.JButton cadastrarBtn;
    private javax.swing.JTextField complementoField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField localidadeField;
    private javax.swing.JTextField logradouroField;
    private javax.swing.JTextField numeroField;
    private javax.swing.JTextField ufField;
    // End of variables declaration//GEN-END:variables
}
