/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapp;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
/**
 *
 * @author Easy
 */
public class MainMenu extends javax.swing.JFrame {

    Connection conn=new DBConnection().connect();
    /**
     * Creates new form MainMenu
     */
    public MainMenu() {
        initComponents();
        clear_user();
        show_user();
    }
    
    public ArrayList<User> userList(){
    ArrayList<User> userList=new ArrayList<>();
    
     
      try{
          String sql="Select * FROM user";
          Statement st=conn.createStatement();
          ResultSet rs=st.executeQuery(sql);          
          User user;          
        while(rs.next()){
            user=new User(rs.getInt("id"),rs.getString("username"),rs.getString("password"),rs.getString("user_status"));
            userList.add(user);
        }  
         }                  
     
      catch(HeadlessException | SQLException e){
       JOptionPane.showMessageDialog(null,"User Credential invalid" + e);   
      }
      return userList;
}

    public void show_user(){
        ArrayList<User> list=userList();
        
      DefaultTableModel model=(DefaultTableModel) jTable.getModel();
      Object row[]=new Object[4];
      for(int i=0;i<list.size();i++){
          row[0]=list.get(i).getid();
          row[1]=list.get(i).getusername();
          row[2]=list.get(i).getpassword();
          row[3]=list.get(i).getuser_status();
          
          model.addRow(row);
      }
    }

public void clear_user(){  
DefaultTableModel dm = (DefaultTableModel) jTable.getModel();
int rowCount = dm.getRowCount();
//Remove rows one by one from the end of the table
for (int i = rowCount - 1; i >= 0; i--) {
    dm.removeRow(i);
}
}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        txtID = new javax.swing.JTextField();
        txtPass = new javax.swing.JTextField();
        cboStatus = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtUser = new javax.swing.JTextField();
        btnNew = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 153));
        jLabel1.setText("MAIN MENU");

        jButton1.setForeground(new java.awt.Color(255, 51, 51));
        jButton1.setText("EXIT");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(224, 224, 224)
                .addComponent(jButton1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jLabel1))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "User Entry", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 0, 18))); // NOI18N

        txtID.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N

        txtPass.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N

        cboStatus.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        cboStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--", "Active", "Inactive" }));

        jLabel2.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel2.setText("Username");

        jLabel3.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel3.setText("Password");

        jLabel4.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel4.setText("Status");

        btnSave.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnEdit.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnDelete.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel5.setText("User ID");

        txtUser.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N

        btnNew.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btnNew.setText("New");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cboStatus, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnNew)
                                .addGap(2, 2, 2)
                                .addComponent(btnSave)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEdit)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnDelete)))
                        .addGap(18, 18, 18))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cboStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEdit)
                    .addComponent(btnDelete)
                    .addComponent(btnNew))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Username", "Password", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable);
        if (jTable.getColumnModel().getColumnCount() > 0) {
            jTable.getColumnModel().getColumn(0).setMaxWidth(50);
            jTable.getColumnModel().getColumn(1).setMaxWidth(200);
            jTable.getColumnModel().getColumn(2).setMaxWidth(150);
            jTable.getColumnModel().getColumn(3).setMaxWidth(90);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 472, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 438, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(86, 86, 86))
        );

        setSize(new java.awt.Dimension(870, 555));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        System.exit(0);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
      String id=txtID.getText();
      String status1=(String) cboStatus.getSelectedItem();
      String username=txtUser.getText();
      String password=txtPass.getText();
      
      if(!id.equals("")){
          JOptionPane.showMessageDialog(null, "Please Press New to Save");
      }
      
      else if(status1.equals("--")){
          JOptionPane.showMessageDialog(null, "Please Select Status");
      }
      
       else if(username.equals("")){
          JOptionPane.showMessageDialog(null, "Please Put Username");
      }
      
        else if(password.equals("")){
          JOptionPane.showMessageDialog(null, "Please Put Password");
      }
       
      else{    
    

         String sql="INSERT INTO user(username,password,user_status)" 
                 + "VALUES(?,?,?)";
      try{
          PreparedStatement ps=conn.prepareStatement(sql);
          ps.setString(1,txtUser.getText());
          ps.setString(2,txtPass.getText());
          ps.setString(3, (String) cboStatus.getSelectedItem());
          
          ps.executeUpdate();
        txtID.setText(null);
        txtUser.setText(null);
        txtPass.setText(null);
        cboStatus.setSelectedIndex(0);
        txtUser.requestFocus();
          JOptionPane.showMessageDialog(null,"User Created Successfully");
          
          clear_user();
         show_user(); 
         
          
      }
      catch(HeadlessException | SQLException e){
       JOptionPane.showMessageDialog(null,"User Not Created" + e);   
      }
        
     }   
        
        
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        // TODO add your handling code here:
        txtID.setText(null);
        txtUser.setText(null);
        txtPass.setText(null);
        cboStatus.setSelectedIndex(0);
        txtUser.requestFocus();
        
        
        
    }//GEN-LAST:event_btnNewActionPerformed

    private void jTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableMouseClicked
        // TODO add your handling code here:
        
        int i=jTable.getSelectedRow();
        TableModel model=jTable.getModel();
        txtID.setText(model.getValueAt(i,0).toString());
        txtUser.setText(model.getValueAt(i,1).toString());
        txtPass.setText(model.getValueAt(i,2).toString());
        
        String status1=model.getValueAt(i,3).toString();
        switch(status1){
            case "Active":
            cboStatus.setSelectedIndex(1);
            break;
            case "Inactive":
            cboStatus.setSelectedIndex(2);
            break;
            case "":
            cboStatus.setSelectedIndex(0);
        }
        
        //txtUser.setText(model.getValueAt(i,1).toString());
    }//GEN-LAST:event_jTableMouseClicked

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        // TODO add your handling code here:
        
            // TODO add your handling code here:
      String id=txtID.getText();
      String status1=(String) cboStatus.getSelectedItem();
      String username=txtUser.getText();
      String password=txtPass.getText();
      
      if(id.equals("")){
          JOptionPane.showMessageDialog(null, "Please Select User");
      }
      
      else if(status1.equals("--")){
          JOptionPane.showMessageDialog(null, "Please Select Status");
      }
      
       else if(username.equals("")){
          JOptionPane.showMessageDialog(null, "Please Put Username");
      }
      
        else if(password.equals("")){
          JOptionPane.showMessageDialog(null, "Please Put Password");
      }
       
      else{    
    

         String sql="UPDATE user SET username=?,password=?,user_status=? Where id=?";
      try{
          PreparedStatement ps=conn.prepareStatement(sql);
          ps.setString(1,txtUser.getText());
          ps.setString(2,txtPass.getText());
          ps.setString(3, (String) cboStatus.getSelectedItem());
          ps.setString(4, txtID.getText());
          
          ps.executeUpdate();
       
          JOptionPane.showMessageDialog(null,"User Updated Successfully");
          
          clear_user();
         show_user(); 
         
          
      }
      catch(HeadlessException | SQLException e){
       JOptionPane.showMessageDialog(null,"User Not Updated" + e);   
      }
        
     }  
        
        
        
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
          // TODO add your handling code here:
      String id=txtID.getText();
      String status1=(String) cboStatus.getSelectedItem();
      String username=txtUser.getText();
      String password=txtPass.getText();
      
      if(id.equals("")){
          JOptionPane.showMessageDialog(null, "Please Select User");
      }
      
     
      
       else if(username.equals("")){
          JOptionPane.showMessageDialog(null, "Please Put Username");
      }
      
        else if(password.equals("")){
          JOptionPane.showMessageDialog(null, "Please Put Password");
      }
       
      else{  
          int dialogButton = 0;
            
      //// option form//////
int dialogResult = JOptionPane.showConfirmDialog (null, "Would You Like to Delete User?","Warning",dialogButton);
if(dialogResult == JOptionPane.YES_OPTION){      
    

         String sql="DELETE FROM user where id=?";
      try{
          PreparedStatement ps=conn.prepareStatement(sql);
          ps.setString(1,txtID.getText());
                
          ps.executeUpdate();
        txtID.setText(null);
        txtUser.setText(null);
        txtPass.setText(null);
        cboStatus.setSelectedIndex(0);
        txtUser.requestFocus();
          JOptionPane.showMessageDialog(null,"User Deleted Successfully");
       clear_user();
         show_user(); 
         
          
      }
      catch(HeadlessException | SQLException e){
       JOptionPane.showMessageDialog(null,"User Not Deleted" + e);   
      }
        
     }   
    }//GEN-LAST:event_btnDeleteActionPerformed
    }
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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new MainMenu().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<String> cboStatus;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtPass;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}
