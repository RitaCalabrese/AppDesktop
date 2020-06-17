/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appdesktop;

import appdesktop.MODEL.UserModel;
import java.util.EventListener;
import javax.swing.DefaultListModel;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTextArea;
import javax.swing.JTextField;



/**
 *
 * @author luisa
 */
public interface UserInfoView {
    


    
    public String getSelectedUser();
    public String getSelectedValue();
    
    public JLabel getJLabel();
    public JTextField getJTextField();
    public JPanel getJPanel();
    public JPopupMenu getjPopupMenu();
    public JList<String> getjList();
    public JCheckBox getCheckBox1();
    public JCheckBox getCheckBox2();
    public JCheckBox getCheckBox3();
    
    public void setListByFlag(DefaultListModel model,boolean approvedOrDeleted);
    public void setList(DefaultListModel model);
    public void setObjBySelectedValue(Object value);
    public void setRefresh(DefaultListModel model);
    public void setSelectedUser(UserModel u);
    
    public void showMsgSuccess();
    public void showMsgError();

    public JTextArea getJTextArea();
}
