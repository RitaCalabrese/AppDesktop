/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appdesktop;

import appdesktop.CONTROLLER.ControllerConfig;
import appdesktop.CONTROLLER.ControllerReview;
import appdesktop.CONTROLLER.ControllerUsersInfo;
import appdesktop.MODEL.UserModel;
import static appdesktop.UsersView.home;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.EventListener;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Rita Calabrese
 * @author Luisa Esposito
 * 
 */
public class ReviewsView extends javax.swing.JFrame implements UserInfoView,EventHandler{

    List<UserModel> users = new ArrayList<>();
    DefaultListModel model = new DefaultListModel();
    ControllerConfig ctrlUsers = new ControllerUsersInfo();
    ControllerConfig ctrlRevs = new ControllerReview();
   
   
    public ReviewsView() {
        initComponents();
        this.setLocationRelativeTo(null); 
        commentText.setEditable(false);
        
        updateListUsers();
        ctrlRevs.initController(this,this);
    }

    private void updateListUsers(){
        model.removeAllElements();
        model = ctrlUsers.initControllerUserInfo(this);
        listUserRev.setModel(model);
    }   
    
    
    @Override
    public void addButtonApprovedListener(EventListener el){
        buttonApproved.addActionListener((ActionListener) el);
    }
    
    @Override
    public void addButtonDeleteListener(EventListener el){
        buttonDelete.addActionListener((ActionListener) el);
    }
    
    @Override
    public void addMouseClickListener(EventListener el){
        listUserRev.addMouseListener((MouseListener) el);
    }
    
    @Override
     public JTextArea getJTextArea() {
        return commentText;
     }
    
    @Override
    public void addAnotherMouseClickListener(EventListener el){
          listAcm.addMouseListener((MouseListener) el);
      }
    
    @Override
    public String getSelectedUser(){return listUserRev.getSelectedValue();}

   
    
    @Override
    public void setListByFlag(DefaultListModel model,boolean approvedOrDeleted) {
        listAcm.setModel(model);   
        users = (ArrayList<UserModel>)new ControllerUsersInfo().getUserRev();
        if(users!=null){
            for(UserModel r:users){
               if(r.getEmail().equals(getSelectedUser())){
                   setSelectedUser(r.getName(),r.getSurname(),r.getEmail());
                }
            }
        }
            if(approvedOrDeleted)
                showMsgSuccess();
    }
    
    private void setSelectedUser(String name,String surname,String email){
               labelNome.setText(name);
               labelCognome.setText(surname);
               labelEmail.setText(email);
      }
    
      
    @Override
    public String getSelectedValue(){return listAcm.getSelectedValue();}
      
    @Override
    public void setObjBySelectedValue(Object value){
             
             commentText.setText((String) value);
             commentText.setPreferredSize(new Dimension(80, 80));
            
                    commentText.setLineWrap(true);
                    commentText.setWrapStyleWord(true);
                    commentText.setOpaque(false);
      }
    
    
      
    @Override
    public void showMsgSuccess(){
        
        JOptionPane.showMessageDialog(null,"Operazione conclusa con successo");
          
        updateListUsers();
        if(listUserRev.getSelectedValue() == null){
          labelNome.setText("");
          labelCognome.setText("");
          labelEmail.setText("");
         
        }
       
      }
      
    @Override
    public void showMsgError(){ JOptionPane.showMessageDialog(null,"Qualcosa è andato storto. Riprovare");}
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listAcm = new javax.swing.JList<>();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        labelEmail = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        buttonApproved = new javax.swing.JButton();
        buttonDelete = new javax.swing.JButton();
        labelCognome = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        labelNome = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listUserRev = new javax.swing.JList<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        commentText = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("RECENSIONI");

        jPanel1.setLayout(null);

        listAcm.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jScrollPane2.setViewportView(listAcm);

        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(250, 220, 120, 230);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setText("Indietro");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(20, 530, 100, 23);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Amministratore Attuale");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(10, 10, 161, 17);

        labelEmail.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel1.add(labelEmail);
        labelEmail.setBounds(470, 180, 200, 20);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Email");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(470, 150, 36, 17);

        buttonApproved.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        buttonApproved.setText("APPROVA");
        jPanel1.add(buttonApproved);
        buttonApproved.setBounds(440, 470, 110, 30);

        buttonDelete.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        buttonDelete.setText("ELIMINA");
        jPanel1.add(buttonDelete);
        buttonDelete.setBounds(560, 470, 100, 30);

        labelCognome.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel1.add(labelCognome);
        labelCognome.setBounds(350, 180, 100, 20);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Cognome");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(350, 150, 67, 17);

        labelNome.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel1.add(labelNome);
        labelNome.setBounds(260, 180, 80, 20);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Nome");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(260, 150, 41, 17);

        labelAttuale.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel1.add(labelAttuale);
        labelAttuale.setBounds(10, 40, 160, 20);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Utenti");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(10, 110, 42, 17);

        listUserRev.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jScrollPane1.setViewportView(listUserRev);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(10, 140, 180, 350);

        commentText.setColumns(20);
        commentText.setRows(5);
        jScrollPane3.setViewportView(commentText);

        jPanel1.add(jScrollPane3);
        jScrollPane3.setBounds(380, 220, 320, 230);

        jLabel6.setIcon(new javax.swing.ImageIcon("C:\\Users\\Rita\\Desktop\\prog INGSW\\Sfondo-Azzurro .png")); // NOI18N
        jPanel1.add(jLabel6);
        jLabel6.setBounds(0, 0, 720, 580);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 719, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 582, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      if(home != null){
        home.setVisible(true);
        }
        dispose();      }//GEN-LAST:event_jButton1ActionPerformed

    
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
            java.util.logging.Logger.getLogger(ReviewsView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReviewsView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReviewsView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReviewsView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReviewsView().setVisible(true);
            }
        });
    }
 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonApproved;
    private javax.swing.JButton buttonDelete;
    private javax.swing.JTextArea commentText;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    public static final javax.swing.JLabel labelAttuale = new javax.swing.JLabel();
    private javax.swing.JLabel labelCognome;
    private javax.swing.JLabel labelEmail;
    private javax.swing.JLabel labelNome;
    private javax.swing.JList<String> listAcm;
    private javax.swing.JList<String> listUserRev;
    // End of variables declaration//GEN-END:variables

    @Override
    public JTextField getJTextField() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public JPanel getJPanel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public JPopupMenu getjPopupMenu() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public JList<String> getjList() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public JCheckBox getCheckBox1() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public JCheckBox getCheckBox2() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public JCheckBox getCheckBox3() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   

    @Override
    public void setList(DefaultListModel model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setRefresh(DefaultListModel model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setSelectedUser(UserModel u) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addActionOneListener(EventListener el) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addRefreshListener(EventListener el) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addAscendingOrderListener(EventListener el) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addDescendingOrderListener(EventListener el) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addCheckOrderListener(EventListener el) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addCheckOrderTwoListener(EventListener el) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addCheckOrderThreeListener(EventListener el) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  
    @Override
    public JLabel getJLabel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  
}
