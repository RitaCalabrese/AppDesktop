/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appdesktop;

import appdesktop.CONTROLLER.ControllerConfig;
import appdesktop.CONTROLLER.ControllerPhoto;
import appdesktop.CONTROLLER.ControllerUsersInfo;

import appdesktop.MODEL.UserModel;
import appdesktop.MODEL.UserPhotoModel;
import static appdesktop.UsersView.home;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import java.util.ArrayList;
import java.util.EventListener;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
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
public class PhotoView extends javax.swing.JFrame implements UserInfoView, EventHandler {
DefaultListModel model;
ControllerConfig ctrlphoto = new ControllerPhoto();
UserPhotoModel photo;
List<UserModel> users = new ArrayList<>();

    /**
     * Creates new form Photo
     */
    public PhotoView() {
      
        initComponents();
        model = ctrlphoto.initControllerUserInfo(this,this);
        this.setLocationRelativeTo(null);
        userPh.setModel(model);
        
    }
    
@Override
    public void addMouseClickListener(EventListener el){
        userPh.addMouseListener((MouseListener) el);
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
    public String getSelectedUser(){return userPh.getSelectedValue();}
   
    @Override
    public void addAnotherMouseClickListener(EventListener el) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getSelectedValue() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    return null;
    }

    @Override
    public JLabel getJLabel() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    return null;
    }

    @Override
    public void setListByFlag(DefaultListModel model, boolean approvedOrDeleted) {
        userPh.setModel(model);
        jLabel1.setIcon(null);
        showMsgSuccess();
    }

    @Override
    public void setObjBySelectedValue(Object value) {
        UserPhotoModel photo = (UserPhotoModel) value;
        ImageIcon icon = new ImageIcon(photo.getFileImage());
                     Image im = icon.getImage();
                     Image myImg = im.getScaledInstance(jLabel1.getWidth(), jLabel1.getHeight(),Image.SCALE_SMOOTH);
                     ImageIcon newImage = new ImageIcon(myImg);
                     jLabel1.setIcon(newImage);    
    }

    @Override
    public void showMsgSuccess() {
        JOptionPane.showMessageDialog(null,"Operazione conclusa con successo");
    }

    @Override
    public void showMsgError() {
        JOptionPane.showMessageDialog(null,"Qualcosa è andato storto. Riprovare");   
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        userPh = new javax.swing.JList<>();
        buttonApproved = new javax.swing.JButton();
        backBtn = new javax.swing.JButton();
        buttonDelete = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        jButton2.setText("jButton2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("FOTO UTENTI");

        jPanel1.setLayout(null);

        userPh.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jScrollPane1.setViewportView(userPh);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(19, 133, 184, 296);

        buttonApproved.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        buttonApproved.setText("APPROVA");
        jPanel1.add(buttonApproved);
        buttonApproved.setBounds(350, 390, 100, 30);

        backBtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        backBtn.setText("Indietro");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });
        jPanel1.add(backBtn);
        backBtn.setBounds(19, 456, 100, 23);

        buttonDelete.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        buttonDelete.setText("ELIMINA");
        jPanel1.add(buttonDelete);
        buttonDelete.setBounds(500, 390, 100, 30);

        labelAdminPhoto.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel1.add(labelAdminPhoto);
        labelAdminPhoto.setBounds(19, 45, 162, 24);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Utenti");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(19, 98, 67, 24);
        jPanel1.add(jLabel1);
        jLabel1.setBounds(370, 150, 193, 193);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Amministratore attuale");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(20, 10, 162, 17);

        jLabel6.setIcon(new javax.swing.ImageIcon("C:\\Users\\Rita\\Desktop\\prog INGSW\\Sfondo-Azzurro .png")); // NOI18N
        jPanel1.add(jLabel6);
        jLabel6.setBounds(0, 0, 700, 510);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 696, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 508, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
      if(home != null){
        home.setVisible(true);
        }
        dispose();    }//GEN-LAST:event_backBtnActionPerformed

    
    public static void main(String args[]) {
      
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PhotoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PhotoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PhotoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PhotoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PhotoView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backBtn;
    private javax.swing.JButton buttonApproved;
    private javax.swing.JButton buttonDelete;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public static final javax.swing.JLabel labelAdminPhoto = new javax.swing.JLabel();
    private javax.swing.JList<String> userPh;
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
    public JTextArea getJTextArea() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
