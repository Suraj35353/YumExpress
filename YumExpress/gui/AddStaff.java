/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package YumExpress.gui;

import YumExpress.dao.CompaniesDao;
import YumExpress.dao.StaffDao;
import YumExpress.pojo.StaffPojo;
import YumExpress.util.Mailer;
import YumExpress.util.OwnerProfile;
import YumExpress.util.PasswordEncryption;
import YumExpress.util.Validator;
import java.sql.SQLException;
import java.util.Map;
import javax.mail.MessagingException;
import javax.swing.JOptionPane;

/**
 *
 * @author ashmi
 */
public class AddStaff extends javax.swing.JFrame {

    /**
     * Creates new form AddStaff
     */
    public AddStaff() {
        initComponents();
        setLocationRelativeTo(null);
        this.lblOwnerName.setText("Hello " + OwnerProfile.getOwnerName());
        txtCompanyName.setText(OwnerProfile.getCompanyName());
        setTitle("Add Staff");
    }

    public boolean validateInputs() {
        char[] pwd = this.txtPassword.getPassword();
        if (pwd.length == 0 || this.txtStaffName.getText().trim().isEmpty() || this.txtEmail.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please fill all the details");
            return false;
        }
        if (Validator.isValidEmail(this.txtEmail.getText().trim()) == false) {
            JOptionPane.showMessageDialog(null, "Please input a valid email id");
            return false;
        }
        return true;
    }

    private void clearAll() {
        txtStaffName.setText("");
        txtEmail.setText("");
        txtPassword.setText("");
        txtEmail.requestFocus();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        lblOwnerName = new javax.swing.JLabel();
        btnAddFood = new javax.swing.JButton();
        btnViewStaff = new javax.swing.JButton();
        btnViewFood = new javax.swing.JButton();
        btnOrderList = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtCompanyName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        txtStaffName = new javax.swing.JTextField();
        btnAddStaff = new javax.swing.JButton();
        txtPassword = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));

        jLabel7.setIcon(new javax.swing.ImageIcon("D:\\NetBeans Workspace\\Icons\\icons\\user.png")); // NOI18N

        btnAddFood.setBackground(new java.awt.Color(255, 255, 255));
        btnAddFood.setText("Add Food");
        btnAddFood.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddFoodActionPerformed(evt);
            }
        });

        btnViewStaff.setBackground(new java.awt.Color(255, 255, 255));
        btnViewStaff.setText("View Staff");

        btnViewFood.setBackground(new java.awt.Color(255, 255, 255));
        btnViewFood.setText(" View Food");
        btnViewFood.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewFoodActionPerformed(evt);
            }
        });

        btnOrderList.setBackground(new java.awt.Color(255, 255, 255));
        btnOrderList.setText("Order List");
        btnOrderList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrderListActionPerformed(evt);
            }
        });

        btnBack.setBackground(new java.awt.Color(255, 255, 255));
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(126, 126, 126)
                        .addComponent(btnBack))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnOrderList, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addGap(104, 104, 104)
                                .addComponent(btnViewFood))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnAddFood, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnViewStaff, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblOwnerName, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblOwnerName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62)
                .addComponent(btnAddFood)
                .addGap(33, 33, 33)
                .addComponent(btnViewStaff)
                .addGap(35, 35, 35)
                .addComponent(btnViewFood)
                .addGap(31, 31, 31)
                .addComponent(btnOrderList)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnBack)
                .addContainerGap())
        );

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 153, 255));
        jLabel1.setText("Add Staff");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(153, 153, 255));
        jLabel2.setText("Company Name");

        txtCompanyName.setEditable(false);
        txtCompanyName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCompanyNameActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(153, 153, 255));
        jLabel3.setText("Enter Email");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(153, 153, 255));
        jLabel4.setText("Enter Name");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(153, 153, 255));
        jLabel6.setText("Password");

        btnAddStaff.setBackground(new java.awt.Color(255, 255, 255));
        btnAddStaff.setText("Add Staff");
        btnAddStaff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddStaffActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(177, 177, 177)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6)
                            .addComponent(jLabel2))
                        .addGap(98, 98, 98)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnAddStaff)
                            .addComponent(txtCompanyName)
                            .addComponent(txtEmail)
                            .addComponent(txtStaffName)
                            .addComponent(txtPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE))))
                .addGap(0, 43, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(76, 76, 76)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCompanyName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtStaffName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(138, 138, 138)
                .addComponent(btnAddStaff)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCompanyNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCompanyNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCompanyNameActionPerformed

    private void btnOrderListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrderListActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnOrderListActionPerformed

    private void btnAddStaffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddStaffActionPerformed
        if (!validateInputs()) {
            return;
        }
        try {
            StaffPojo staff = new StaffPojo();
            staff.setCompanyId(OwnerProfile.getCompanyId());
            staff.setEmailId(txtEmail.getText().trim());
            staff.setStaffName(txtStaffName.getText());
            char[] pwd = txtPassword.getPassword();
            String pwdStr = String.valueOf(pwd);
            pwdStr = PasswordEncryption.getEncryptedPassword(pwdStr);
            staff.setPassword(pwdStr);
            String staffId = StaffDao.addStaff(staff);
            if (staffId == null) {
                JOptionPane.showMessageDialog(null, "Cannot Add Staff..!");
                return;
            }
            JOptionPane.showMessageDialog(null, "Staff Member Added Successfully..!");
            Map<String, String> emailCredentials = CompaniesDao.getEmailCredentialsByCompanyId(OwnerProfile.getCompanyId());
            Mailer.sendMail(emailCredentials, staff);
            JOptionPane.showMessageDialog(null, "Mail sent successfully..! to " + staff.getEmailId());
            clearAll();
        } catch (SQLException sq) {
            JOptionPane.showMessageDialog(null, "DB ERROR IN AddDeliveryStaffFrame");
            sq.printStackTrace();
        } catch (MessagingException ex) {
            JOptionPane.showMessageDialog(null, "MAIL ERROR IN AddDeliveryStaffFrame");
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btnAddStaffActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        SellerOption so = new SellerOption();
        so.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnAddFoodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddFoodActionPerformed
        AddFood af = new AddFood();
        af.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnAddFoodActionPerformed

    private void btnViewFoodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewFoodActionPerformed
        ViewFood vf = new ViewFood();
        vf.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnViewFoodActionPerformed

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
            java.util.logging.Logger.getLogger(AddStaff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddStaff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddStaff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddStaff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddStaff().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddFood;
    private javax.swing.JButton btnAddStaff;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnOrderList;
    private javax.swing.JButton btnViewFood;
    private javax.swing.JButton btnViewStaff;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblOwnerName;
    private javax.swing.JTextField txtCompanyName;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtStaffName;
    // End of variables declaration//GEN-END:variables
}
