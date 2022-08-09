/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package superman;

import com.mysql.jdbc.Statement;
import java.sql.SQLException;
import java.sql.*;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class customer extends javax.swing.JPanel {

    /**
     * Creates new form customer
     */
    public customer() {
        initComponents();
        tb_load();
    }
    
    public void tb_load() {
        
        try {
            DefaultTableModel dt = (DefaultTableModel) jTable1.getModel();
            dt.setRowCount(0);
            
            Statement s = (Statement) db.mycon().createStatement();
            ResultSet rs = s.executeQuery(" SELECT * FROM customer");
            
            while(rs.next()) {
                Vector v = new Vector();
                v.add(rs.getString(1));
                v.add(rs.getString(2));
                v.add(rs.getString(3));
                v.add(rs.getString(4));
                v.add(rs.getString(5));
                v.add(rs.getString(6));
                v.add(rs.getString(7));
                v.add(rs.getString(8));
                
                dt.addRow(v);
                
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        c_fn = new javax.swing.JTextField();
        c_ln = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        c_st = new javax.swing.JComboBox<>();
        c_ag = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        c_cn = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        c_gn = new javax.swing.JComboBox<>();
        c_id = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        c_ad = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        c_search = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1360, 690));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        c_fn.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        c_fn.setAlignmentX(0.0F);
        c_fn.setAlignmentY(0.0F);
        c_fn.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 153)));
        c_fn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c_fnActionPerformed(evt);
            }
        });
        jPanel2.add(c_fn, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 80, 290, 30));

        c_ln.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        c_ln.setAlignmentX(0.0F);
        c_ln.setAlignmentY(0.0F);
        c_ln.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 153)));
        c_ln.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c_lnActionPerformed(evt);
            }
        });
        jPanel2.add(c_ln, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 120, 290, 30));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 2, 16)); // NOI18N
        jLabel2.setText("First name:");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, 20));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 2, 16)); // NOI18N
        jLabel9.setText("Last name:");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, 20));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 2, 16)); // NOI18N
        jLabel10.setText("Age:");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 160, 40, 30));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 2, 16)); // NOI18N
        jLabel11.setText("Contact no:");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, -1, 30));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 2, 16)); // NOI18N
        jLabel12.setText("Customer ID :");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, 20));

        c_st.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "VIP", "Elite", "Active", "General", "Student" }));
        c_st.setSelectedIndex(-1);
        c_st.setToolTipText("");
        c_st.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 153)));
        c_st.setName(""); // NOI18N
        c_st.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c_stActionPerformed(evt);
            }
        });
        jPanel2.add(c_st, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 360, 80, 30));

        c_ag.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        c_ag.setAlignmentX(0.0F);
        c_ag.setAlignmentY(0.0F);
        c_ag.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 153)));
        c_ag.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c_agActionPerformed(evt);
            }
        });
        jPanel2.add(c_ag, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 160, 80, 30));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 2, 16)); // NOI18N
        jLabel13.setText("Gender:");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 60, 30));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 2, 16)); // NOI18N
        jLabel14.setText("Membership status:");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 360, 150, 30));

        c_cn.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        c_cn.setAlignmentX(0.0F);
        c_cn.setAlignmentY(0.0F);
        c_cn.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 153)));
        c_cn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c_cnActionPerformed(evt);
            }
        });
        jPanel2.add(c_cn, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 200, 290, 30));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 2, 16)); // NOI18N
        jLabel15.setText("Address:");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 80, 30));

        c_gn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        c_gn.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male ", "Female" }));
        c_gn.setSelectedIndex(-1);
        c_gn.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 153)));
        c_gn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c_gnActionPerformed(evt);
            }
        });
        jPanel2.add(c_gn, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 160, 80, 30));

        c_id.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        c_id.setAlignmentX(0.0F);
        c_id.setAlignmentY(0.0F);
        c_id.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 153)));
        c_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c_idActionPerformed(evt);
            }
        });
        jPanel2.add(c_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, 290, 30));

        c_ad.setColumns(20);
        c_ad.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        c_ad.setRows(4);
        c_ad.setTabSize(4);
        c_ad.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 153)));
        jScrollPane3.setViewportView(c_ad);

        jPanel2.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 240, 290, 90));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 420, 420));

        jTable1.setFont(new java.awt.Font("Segoe UI Emoji", 0, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "First name", "Last name", "Gender", "Age", "Contact no", "Address", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 70, 740, 570));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-customer-40 blue.png"))); // NOI18N

        jLabel6.setFont(new java.awt.Font("Verdana", 1, 28)); // NOI18N
        jLabel6.setText("Customers");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 350, 50));

        jTextField7.setBackground(new java.awt.Color(0, 51, 51));
        jTextField7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField7ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 530, 10));

        c_search.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        c_search.setForeground(new java.awt.Color(153, 153, 153));
        c_search.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        c_search.setText("     Search via ID");
        c_search.setAlignmentX(0.0F);
        c_search.setAlignmentY(0.0F);
        c_search.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 153)));
        c_search.setDoubleBuffered(true);
        c_search.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                c_searchFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                c_searchFocusLost(evt);
            }
        });
        c_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c_searchActionPerformed(evt);
            }
        });
        c_search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                c_searchKeyTyped(evt);
            }
        });
        jPanel1.add(c_search, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 30, 200, 20));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-search-25.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 30, 30, 20));

        jButton7.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jButton7.setText("Add Customer");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 580, -1, -1));

        jButton6.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jButton6.setText("Update");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 580, -1, -1));

        jButton4.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jButton4.setText("Delete");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 580, -1, -1));

        jTextField1.setBackground(new java.awt.Color(77, 100, 89));
        jTextField1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(255, 255, 255));
        jTextField1.setText("Add new cutomer");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 100, 180, 50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1330, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 726, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void c_lnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c_lnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_c_lnActionPerformed

    private void c_fnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c_fnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_c_fnActionPerformed

    private void c_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c_searchActionPerformed
        // search via id text box
        
    }//GEN-LAST:event_c_searchActionPerformed

    private void c_stActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c_stActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_c_stActionPerformed

    private void c_agActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c_agActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_c_agActionPerformed

    private void c_cnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c_cnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_c_cnActionPerformed

    private void c_gnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c_gnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_c_gnActionPerformed

    private void jTextField7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField7ActionPerformed

    private void c_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_c_idActionPerformed

    private void c_searchFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_c_searchFocusGained
        // TODO add your handling code here:
       c_search.setText(""); 

    }//GEN-LAST:event_c_searchFocusGained

    private void c_searchFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_c_searchFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_c_searchFocusLost

    private void c_searchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_c_searchKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_c_searchKeyTyped

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // search button on customer
        String sr = c_search.getText();
        try{
            Statement s = (Statement) db.mycon().createStatement();
            
            ResultSet rs = s.executeQuery(" SELECT * FROM customer WHERE cid = '"+sr+"'");
            
            if(rs.next()) {
                  c_id.setText(rs.getString("cid"));
                  c_fn.setText(rs.getString("first_name"));
                  c_ln.setText(rs.getString("last_name"));
                  c_gn.setSelectedItem(rs.getString("gender"));
                  c_ag.setText(rs.getString("age"));
                  c_cn.setText(rs.getString("contact"));
                  c_ad.setText(rs.getString("address"));
                  c_st.setSelectedItem(rs.getString("status"));

            }
        } catch (SQLException ex) {
            //Logger.getLogger(customer.class.getName()).log(Level.SEVERE, null, ex);
            System.out.print(ex);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // "Add cutomer" button
        //String id = c_id.getText();
        String fname = c_fn.getText();
        String lname = c_ln.getText();
        String gender = (String)c_gn.getSelectedItem().toString();
        String age = c_ag.getText();
        String contact = c_cn.getText();
        String address = c_ad.getText();
        String type = (String)c_st.getSelectedItem().toString();
        
        try{
            Statement s = (Statement) db.mycon().createStatement();
            s.executeUpdate(" INSERT INTO customer(first_name, last_name, gender, age, contact, address, status) VALUES('"+fname+"','"+lname+"','"+gender+"','"+age+"','"+contact+"','"+address+"','"+type+"') ");
            
        }catch(SQLException e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // update customer info
        String id = c_search.getText();
        String fname = c_fn.getText();
        String lname = c_ln.getText();
        String gender = (String)c_gn.getSelectedItem().toString();
        String age = c_ag.getText();
        String contact = c_cn.getText();
        String address = c_ad.getText();
        String type = (String)c_st.getSelectedItem().toString();
        
        try{
            Statement s = (Statement) db.mycon().createStatement();
            s.executeUpdate(" UPDATE customer SET first_name = '"+fname+"' ,last_name = '"+lname+"' , gender = '"+gender+"' , age = '"+age+"' , contact = '"+contact+"' , address = '"+address+"' , status = '"+type+"' WHERE cid = '"+id+"' ");
            
        }catch(SQLException e) {
            System.out.println(e);
        }

        
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // delete button on customer
        String id = c_search.getText();
        try {
            Statement s = (Statement) db.mycon().createStatement();
            s.executeUpdate(" DELETE from customer WHERE cid = '"+id+"' ");
        } catch(SQLException e) {
            System.out.print(e);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea c_ad;
    private javax.swing.JTextField c_ag;
    private javax.swing.JTextField c_cn;
    private javax.swing.JTextField c_fn;
    private javax.swing.JComboBox<String> c_gn;
    private javax.swing.JTextField c_id;
    private javax.swing.JTextField c_ln;
    private javax.swing.JTextField c_search;
    private javax.swing.JComboBox<String> c_st;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField7;
    // End of variables declaration//GEN-END:variables
}
