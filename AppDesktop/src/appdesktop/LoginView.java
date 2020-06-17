
package appdesktop;


import appdesktop.CONTROLLER.ControllerAdmin;
import static appdesktop.HomePage.labelCognome;
import static appdesktop.HomePage.labelDataDiNascita;
import static appdesktop.HomePage.labelNome;


import static appdesktop.UsersView.labelAdmin;
import static appdesktop.LoginView.text_username;

import appdesktop.MODEL.AdministratorModel;
import static appdesktop.PhotoView.labelAdminPhoto;
import static appdesktop.ReviewsView.labelAttuale;

import java.awt.Image;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.EventListener;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.Timer;


public class LoginView extends javax.swing.JFrame {
  
 
    public LoginView() {
        
        initComponents();
        scaleImage();
        this.setLocationRelativeTo(null); //centrare la GUI sullo schermo
        new ControllerAdmin().initController(this);
    }
    
     private void scaleImage(){
        ImageIcon icon = new ImageIcon ("C:\\Users\\Rita\\Desktop\\prog INGSW\\logoApp.png");
        //scaling
        Image img = icon.getImage();
        Image imgScale = img.getScaledInstance(jLabel4.getWidth(), jLabel4.getHeight(),Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgScale);
        jLabel4.setIcon(scaledIcon);
     }
    public void Close(){
        WindowEvent wce = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
       Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(wce);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        text_username = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        text_password = new javax.swing.JPasswordField();
        btn_login = new javax.swing.JButton();
        jProgressBar1 = new javax.swing.JProgressBar();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("LOGIN");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );

        jPanel3.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Username");
        jLabel1.setPreferredSize(new java.awt.Dimension(47, 14));
        jPanel3.add(jLabel1);
        jLabel1.setBounds(480, 80, 80, 14);

        text_username.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        text_username.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel3.add(text_username);
        text_username.setBounds(480, 120, 225, 27);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Password");
        jPanel3.add(jLabel2);
        jLabel2.setBounds(480, 190, 80, 17);

        text_password.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        text_password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                text_passwordActionPerformed(evt);
            }
        });
        jPanel3.add(text_password);
        text_password.setBounds(480, 230, 225, 27);

        btn_login.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_login.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/padlock_77917 (1).png"))); // NOI18N
        btn_login.setText("LOGIN");
        jPanel3.add(btn_login);
        btn_login.setBounds(540, 310, 120, 41);
        jPanel3.add(jProgressBar1);
        jProgressBar1.setBounds(10, 470, 840, 38);
        jPanel3.add(jLabel4);
        jLabel4.setBounds(60, 50, 340, 360);

        jLabel5.setIcon(new javax.swing.ImageIcon("C:\\Users\\Rita\\Desktop\\prog INGSW\\Sfondo-Azzurro.png")); // NOI18N
        jPanel3.add(jLabel5);
        jLabel5.setBounds(0, 0, 860, 530);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 858, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 471, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
 
    public void addBtnLoginListener(EventListener el) {
        ActionListener al = (ActionListener) el;
        btn_login.addActionListener(al);
     }
    public void addKeyPressedListener(EventListener el) {
        KeyListener kl = (KeyListener) el;
        text_password.addKeyListener(kl);
     }
    
    public String[] getAdminInput(){ 
        String[] credentials = new String[2]; 
        credentials[0] = text_username.getText().trim();
        credentials[1] = String.valueOf(text_password.getPassword());
    return credentials;
    }
   
    public void signInAdmin(AdministratorModel admin){
    
           if(admin != null){
           
           labelNome.setText(admin.getName());
           labelCognome.setText(admin.getSurname());
           DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
           labelDataDiNascita.setText(dateFormat.format(admin.getBirthday()));
           labelAdmin.setText(admin.getName() + " " + admin.getSurname() );
           labelAttuale.setText(admin.getName()+" "+admin.getSurname());
           labelAdminPhoto.setText(admin.getName()+" "+admin.getSurname());
            timer.start();
            }else {
             
              JOptionPane.showMessageDialog(null, "username/password is not correct");
               
           }
          
       
            }
        
       
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
       timer=new Timer(50, new progressbar());
    }//GEN-LAST:event_formWindowOpened

    private void text_passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_text_passwordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_text_passwordActionPerformed

    public class progressbar implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent evt){
                   
            jProgressBar1.setStringPainted (true);
            int n = jProgressBar1.getValue();
            if(n<100){
                n++;
                jProgressBar1.setValue(n);
            }else{
                timer.stop();
                HomePage adm = new HomePage();
                adm.setVisible(true);
                Close();
            }
    
        }
    }
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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new LoginView().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_login;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JPasswordField text_password;
    public static javax.swing.JTextField text_username;
    // End of variables declaration//GEN-END:variables
    private Timer timer;

}
