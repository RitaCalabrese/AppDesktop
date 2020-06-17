/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appdesktop;

import appdesktop.CONTROLLER.ControllerConfig;
import appdesktop.CONTROLLER.ControllerUsersInfo;


import appdesktop.MODEL.UserModel;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.List;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import java.util.EventListener;

import javax.swing.*;



/**
 *
 * @author Rita Calabrese
 * @author Luisa Esposito
 * 
 */
public class UsersView extends javax.swing.JFrame implements UserInfoView,EventHandler{

   DefaultListModel model;
   ControllerConfig ctrlUsers = new ControllerUsersInfo(); 
   List<UserModel> results = new ArrayList<>();
   List<UserModel> resultsDes = new ArrayList<>();
   static HomePage home;
    
    public UsersView(HomePage home){
        initComponents();
        this.setLocationRelativeTo(null);//centrare la GUI sullo schermo
        jPopupMenu1.add(jScrollPane1);
        jPanel5.setVisible(false);
        jPanel3.setFocusable(true);
        UsersView.home = home;
        
        initView();

    }

    
    private void initView() {
      model = ctrlUsers.initControllerUserInfo(this,this);
        jListUsers.setModel(model);    
    }
    
   @Override
    public void addActionOneListener(EventListener el){
      InsertDestination.addActionListener((ActionListener) el);
    }
    
   @Override
    public JTextField getJTextField() {
        return InsertDestination;
    }

   @Override
    public JPanel getJPanel() {
        return jPanel5;
    }

   @Override
    public JPopupMenu getjPopupMenu() {
        return jPopupMenu1;
    }
  
   @Override
    public void setList(DefaultListModel model){
          jListFiltered.setModel(model);
    }
   
   
   @Override
    public void addMouseClickListener(EventListener el){
        jListUsers.addMouseListener((MouseListener) el);
    }
    
   @Override
    public String getSelectedUser(){return jListUsers.getSelectedValue();}
    
   @Override
    public void setSelectedUser(UserModel u){
            
        jPanel5.setVisible(true);
            jLabel17.setText(u.getName());
            jLabel18.setText(u.getSurname());
            jLabel19.setText(u.getNickname());
            
            if(u.getImage() !=null){
            ImageIcon icon = new ImageIcon(u.getImage());
            Image im = icon.getImage();
            Image myImg = im.getScaledInstance(photo.getWidth(), photo.getHeight(),Image.SCALE_SMOOTH);
            ImageIcon newImage = new ImageIcon(myImg);
            photo.setIcon(newImage);
            }else{
                photo.setIcon(null);
            }
            jLabel6.setText(Integer.toString(u.getAmountWrittenReviews()));
            jLabel7.setText(Float.toString(u.getAverageUserRating()));
             
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            jLabel4.setText(dateFormat.format(u.getBirthday()));  
    }
    
   @Override
    public void addRefreshListener(EventListener el){
        refresh.addActionListener((ActionListener) el);
    }
    
   @Override
    public void setRefresh(DefaultListModel model){
              orderRev.setSelected(false);
              orderRating.setSelected(false);
              orderBDay.setSelected(false);
              jPanel5.setVisible(false);
              jListUsers.setModel(model);
    }

   @Override
    public JList<String> getjList() {
        return jListFiltered;
    }
    
   @Override
    public void addAnotherMouseClickListener(EventListener el){
        jListFiltered.addMouseListener((MouseListener) el);
    }
    
    
    
   @Override
    public void addAscendingOrderListener(EventListener el){
        asc.addActionListener((ActionListener) el);
    }

   @Override
    public JCheckBox getCheckBox3() {
        return orderBDay;
    }

   @Override
    public JCheckBox getCheckBox2() {
        return orderRating;
    }

   @Override
    public JCheckBox getCheckBox1() {
        return orderRev;
    }
    
    
   @Override
    public void setListByFlag(DefaultListModel model,boolean flag){
           jListUsers.setModel(model);
    }
   
    
   @Override
    public void addCheckOrderListener(EventListener el){
        orderRev.addActionListener((ActionListener) el);
    }
    
   @Override
    public void addCheckOrderTwoListener(EventListener el){
        orderRating.addActionListener((ActionListener) el);
    }
    
   @Override
    public void addCheckOrderThreeListener(EventListener el){
        orderBDay.addActionListener((ActionListener) el);
    }
    
   @Override
    public void addDescendingOrderListener(EventListener el){
        desc.addActionListener((ActionListener) el);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListFiltered = new javax.swing.JList<>();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        indietroButton = new javax.swing.JButton();
        refresh = new javax.swing.JButton();
        InsertDestination = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        Name = new javax.swing.JLabel();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        Surname = new javax.swing.JLabel();
        Nick = new javax.swing.JLabel();
        BDay = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        rating = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        orderRev = new javax.swing.JCheckBox();
        orderRating = new javax.swing.JCheckBox();
        orderBDay = new javax.swing.JCheckBox();
        jLabel8 = new javax.swing.JLabel();
        asc = new javax.swing.JButton();
        desc = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jListUsers = new javax.swing.JList<>();
        Admin = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();

        jTextField1.setText("jTextField1");

        jFormattedTextField1.setText("jFormattedTextField1");

        jScrollPane1.setBorder(null);
        jScrollPane1.setPreferredSize(new java.awt.Dimension(147, 128));

        jScrollPane1.setViewportView(jListFiltered);

        jPopupMenu1.setFocusable(false);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("DATI UTENTI");
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setLayout(null);

        indietroButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        indietroButton.setText("Indietro");
        indietroButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                indietroButtonActionPerformed(evt);
            }
        });
        jPanel3.add(indietroButton);
        indietroButton.setBounds(20, 610, 90, 23);

        refresh.setIcon(new javax.swing.ImageIcon("C:\\Users\\Rita\\Desktop\\prog INGSW\\refresh.png")); // NOI18N
        jPanel3.add(refresh);
        refresh.setBounds(790, 20, 30, 30);

        InsertDestination.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        InsertDestination.setForeground(new java.awt.Color(204, 204, 255));
        InsertDestination.setText("Inserisci la destinazione");
        InsertDestination.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                InsertDestinationFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                InsertDestinationFocusLost(evt);
            }
        });
        jPanel3.add(InsertDestination);
        InsertDestination.setBounds(338, 20, 150, 30);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        Name.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Name.setText("Nome");

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 72, Short.MAX_VALUE)
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        Surname.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Surname.setText("Cognome");

        Nick.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Nick.setText("Nickname");

        BDay.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        BDay.setText("Data di Nascita");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setText("Numero recensioni Scritte");

        rating.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        rating.setText("Media Valutazioni ");

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(photo, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Name))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Surname)
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Nick)
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(342, 342, 342)
                        .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BDay)
                    .addComponent(jLabel14)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rating)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Name)
                            .addComponent(Surname)
                            .addComponent(Nick))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(BDay)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rating)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(photo, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.add(jPanel5);
        jPanel5.setBounds(310, 300, 500, 260);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Utenti");
        jPanel3.add(jLabel2);
        jLabel2.setBounds(10, 250, 49, 27);

        orderRev.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        orderRev.setText("Recensioni");
        jPanel3.add(orderRev);
        orderRev.setBounds(10, 130, 110, 25);

        orderRating.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        orderRating.setText("Valutazioni");
        jPanel3.add(orderRating);
        orderRating.setBounds(10, 170, 110, 25);

        orderBDay.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        orderBDay.setText("Data di Nascita");
        jPanel3.add(orderBDay);
        orderBDay.setBounds(10, 210, 120, 25);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Ordina per:");
        jPanel3.add(jLabel8);
        jLabel8.setBounds(10, 100, 90, 17);

        asc.setIcon(new javax.swing.ImageIcon("C:\\Users\\Rita\\Desktop\\prog INGSW\\sort_ascending_icon_138166.png")); // NOI18N
        jPanel3.add(asc);
        asc.setBounds(150, 250, 32, 30);

        desc.setIcon(new javax.swing.ImageIcon("C:\\Users\\Rita\\Desktop\\prog INGSW\\sort_descending_icon_135168 (1).png")); // NOI18N
        jPanel3.add(desc);
        desc.setBounds(190, 250, 30, 30);

        labelAdmin.setBackground(new java.awt.Color(255, 255, 255));
        labelAdmin.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel3.add(labelAdmin);
        labelAdmin.setBounds(10, 50, 142, 25);

        jListUsers.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jListUsers.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jScrollPane2.setViewportView(jListUsers);

        jPanel3.add(jScrollPane2);
        jScrollPane2.setBounds(10, 290, 210, 290);

        Admin.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Admin.setText("Amministratore attuale");
        jPanel3.add(Admin);
        Admin.setBounds(10, 20, 170, 17);

        jLabel9.setIcon(new javax.swing.ImageIcon("C:\\Users\\Rita\\Desktop\\prog INGSW\\Sfondo-Azzurro .png")); // NOI18N
        jPanel3.add(jLabel9);
        jLabel9.setBounds(0, 0, 840, 650);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 220, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 210, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel4);
        jPanel4.setBounds(420, 160, 220, 210);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 841, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 644, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void indietroButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_indietroButtonActionPerformed
        if(home != null){
        home.setVisible(true);
        }
        dispose();
        
    }//GEN-LAST:event_indietroButtonActionPerformed
    
    
    private void InsertDestinationFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_InsertDestinationFocusLost
      
        
       if(InsertDestination.getText().equals("")){
       InsertDestination.setText("Inserisci la destinazione");
       InsertDestination.setForeground(Color.BLACK);
       }
    }//GEN-LAST:event_InsertDestinationFocusLost

    private void InsertDestinationFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_InsertDestinationFocusGained
              
        if(InsertDestination.getText().equals("Inserisci la destinazione")){
       InsertDestination.setText("");
         InsertDestination.setForeground(Color.BLACK);
     }
    
    }//GEN-LAST:event_InsertDestinationFocusGained
    
    
    public static void main(String args[]) {
       
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UsersView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
       //</editor-fold>
       //</editor-fold>
       //</editor-fold>
       //</editor-fold>
       
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new UsersView(home).setVisible(true);
        });
    }
 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Admin;
    private javax.swing.JLabel BDay;
    private javax.swing.JTextField InsertDestination;
    private javax.swing.JLabel Name;
    private javax.swing.JLabel Nick;
    private javax.swing.JLabel Surname;
    private javax.swing.JButton asc;
    private javax.swing.JButton desc;
    private javax.swing.JButton indietroButton;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JList<String> jListFiltered;
    private javax.swing.JList<String> jListUsers;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    public static final javax.swing.JLabel labelAdmin = new javax.swing.JLabel();
    private javax.swing.JCheckBox orderBDay;
    private javax.swing.JCheckBox orderRating;
    private javax.swing.JCheckBox orderRev;
    public static final javax.swing.JLabel photo = new javax.swing.JLabel();
    private javax.swing.JLabel rating;
    private javax.swing.JButton refresh;
    // End of variables declaration//GEN-END:variables

    @Override
    public void addButtonApprovedListener(EventListener el) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addButtonDeleteListener(EventListener el) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getSelectedValue() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public JLabel getJLabel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setObjBySelectedValue(Object value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void showMsgSuccess() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void showMsgError() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public JTextArea getJTextArea() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  

    
}
