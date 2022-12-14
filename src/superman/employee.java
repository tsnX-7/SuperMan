/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package superman;

import com.mysql.jdbc.Statement;
import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author User
 */
public class employee extends javax.swing.JPanel {

    /**
     * Creates new form customer
     */
    public employee() {
        initComponents();
        tb_load();
    }
    
    java.util.Date date;
    java.sql.Date sqlDate;
            
    public void tb_load() {
        try {
            DefaultTableModel dt = (DefaultTableModel) e_table.getModel();
            dt.setRowCount(0);
            
            DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
            centerRenderer.setHorizontalAlignment( JLabel.CENTER );
            e_table.setDefaultRenderer(String.class, centerRenderer);
            
            //DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
            centerRenderer.setHorizontalAlignment( JLabel.CENTER );
            int numCol = dt.getColumnCount();
            for(int i=0; i<numCol; i++)
            e_table.getColumnModel().getColumn(i).setCellRenderer( centerRenderer );
            
            ((DefaultTableCellRenderer)e_table.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
            
            Statement s = (Statement) db.mycon().createStatement();
            ResultSet rs = s.executeQuery(" SELECT * FROM employee");
            
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
                v.add(rs.getString(9));
                //v.add(rs.getString(10));
                
                dt.addRow(v);
                
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
     public void allset() {
         tb_load();
         
        e_id.setText("");
        e_fn.setText("");
        e_ln.setText("");
        e_gn.setSelectedItem(null);
        e_ag.setText("");
        e_cn.setText("");
        e_ds.setSelectedItem(null);
        e_ad.setText("");
        e_jn.setDate(null);
        //e_pw.setText("");
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
        jPanel2 = new javax.swing.JPanel();
        e_fn = new javax.swing.JTextField();
        e_ln = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        e_ag = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        e_cn = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        e_ds = new javax.swing.JComboBox<>();
        e_id = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        e_ad = new javax.swing.JTextArea();
        jLabel14 = new javax.swing.JLabel();
        e_gn = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        e_jn = new com.toedter.calendar.JDateChooser();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        e_table = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        e_search = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1360, 690));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        e_fn.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        e_fn.setAlignmentX(0.0F);
        e_fn.setAlignmentY(0.0F);
        e_fn.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 153)));
        e_fn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                e_fnActionPerformed(evt);
            }
        });
        jPanel2.add(e_fn, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 80, 300, 30));

        e_ln.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        e_ln.setAlignmentX(0.0F);
        e_ln.setAlignmentY(0.0F);
        e_ln.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 153)));
        e_ln.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                e_lnActionPerformed(evt);
            }
        });
        jPanel2.add(e_ln, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 120, 300, 30));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 2, 16)); // NOI18N
        jLabel2.setText("First name:");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, 30));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 2, 16)); // NOI18N
        jLabel9.setText("Last name:");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, 20));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 2, 16)); // NOI18N
        jLabel10.setText("Age:");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 160, 40, 30));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 2, 16)); // NOI18N
        jLabel12.setText("Employee ID:");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, 30));

        e_ag.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        e_ag.setAlignmentX(0.0F);
        e_ag.setAlignmentY(0.0F);
        e_ag.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 153)));
        e_ag.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                e_agActionPerformed(evt);
            }
        });
        jPanel2.add(e_ag, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 160, 80, 30));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 2, 16)); // NOI18N
        jLabel13.setText("Joining date:");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, 120, 40));

        e_cn.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        e_cn.setAlignmentX(0.0F);
        e_cn.setAlignmentY(0.0F);
        e_cn.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 153)));
        e_cn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                e_cnActionPerformed(evt);
            }
        });
        jPanel2.add(e_cn, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 200, 300, 30));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 2, 16)); // NOI18N
        jLabel15.setText("Address:");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 80, 30));

        e_ds.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        e_ds.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Manager", "Cashier", "Sales stuff", "Store keeper", "Worker", " " }));
        e_ds.setSelectedIndex(-1);
        e_ds.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 153)));
        e_ds.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                e_dsActionPerformed(evt);
            }
        });
        jPanel2.add(e_ds, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 340, 130, 30));

        e_id.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        e_id.setAlignmentX(0.0F);
        e_id.setAlignmentY(0.0F);
        e_id.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 153)));
        e_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                e_idActionPerformed(evt);
            }
        });
        jPanel2.add(e_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 40, 300, 30));

        e_ad.setColumns(20);
        e_ad.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        e_ad.setRows(4);
        e_ad.setTabSize(4);
        e_ad.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 153)));
        jScrollPane3.setViewportView(e_ad);

        jPanel2.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 240, 300, 90));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 2, 16)); // NOI18N
        jLabel14.setText("Gender:");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 120, 30));

        e_gn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        e_gn.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female", " ", " " }));
        e_gn.setSelectedIndex(-1);
        e_gn.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 153)));
        e_gn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                e_gnActionPerformed(evt);
            }
        });
        jPanel2.add(e_gn, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 160, 80, 30));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 2, 16)); // NOI18N
        jLabel16.setText("Designation:");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 120, 30));

        e_jn.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 153)));
        e_jn.setDateFormatString("yyyy-MM-dd");
        jPanel2.add(e_jn, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 380, 160, 30));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 2, 16)); // NOI18N
        jLabel17.setText("Contact no:");
        jPanel2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, -1, 30));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 490, 450));

        e_table.setFont(new java.awt.Font("Segoe UI Emoji", 0, 12)); // NOI18N
        e_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "First name", "Last name", "Gender", "Age", "Contact no", "Address", "Designation", "Joining date"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Byte.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        e_table.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(e_table);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 80, 770, 580));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-employee-40.png"))); // NOI18N

        jLabel6.setFont(new java.awt.Font("Verdana", 1, 28)); // NOI18N
        jLabel6.setText("Employee");

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
        jPanel1.add(jTextField7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 490, 10));

        e_search.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        e_search.setForeground(new java.awt.Color(153, 153, 153));
        e_search.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        e_search.setText("     Search via ID");
        e_search.setToolTipText("");
        e_search.setAlignmentX(0.0F);
        e_search.setAlignmentY(0.0F);
        e_search.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 153)));
        e_search.setDoubleBuffered(true);
        e_search.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                e_searchFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                e_searchFocusLost(evt);
            }
        });
        e_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                e_searchActionPerformed(evt);
            }
        });
        e_search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                e_searchKeyTyped(evt);
            }
        });
        jPanel1.add(e_search, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 20, 200, 30));

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setText("Update");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 630, 90, 30));

        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton2.setText("Delete");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 630, 90, 30));

        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton4.setText("Save");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 630, 90, 30));

        jTextField1.setBackground(new java.awt.Color(77, 100, 89));
        jTextField1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(255, 255, 255));
        jTextField1.setText("Add new employee");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 100, 180, 30));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-search-25.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 20, 30, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1372, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 712, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void e_lnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_e_lnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_e_lnActionPerformed

    private void e_fnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_e_fnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_e_fnActionPerformed

    private void e_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_e_searchActionPerformed
        // search employee id:
        String sr = e_search.getText();
        try{
            Statement s = (Statement) db.mycon().createStatement();
            
            ResultSet rs = s.executeQuery(" SELECT * FROM employee WHERE eid = '"+sr+"'");
            
            if(rs.next()) {
                  e_id.setText(rs.getString("eid"));
                  e_fn.setText(rs.getString("efname"));
                  e_ln.setText(rs.getString("elname"));
                  e_gn.setSelectedItem(rs.getString("egen"));
                  e_ag.setText(rs.getString("eage"));
                  e_cn.setText(rs.getString("econ"));
                  e_ad.setText(rs.getString("eadd"));
                  e_ds.setSelectedItem(rs.getString("edes"));
                  //e_pw.setText(rs.getString("epw"));
            }
        } catch (SQLException ex) {
            //Logger.getLogger(customer.class.getName()).log(Level.SEVERE, null, ex);
            System.out.print(ex);
        }
    }//GEN-LAST:event_e_searchActionPerformed

    private void e_agActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_e_agActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_e_agActionPerformed

    private void e_cnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_e_cnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_e_cnActionPerformed

    private void e_dsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_e_dsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_e_dsActionPerformed

    private void jTextField7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField7ActionPerformed

    private void e_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_e_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_e_idActionPerformed

    private void e_searchFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_e_searchFocusGained
        // TODO add your handling code here:
        e_search.setText("");
    }//GEN-LAST:event_e_searchFocusGained

    private void e_searchFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_e_searchFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_e_searchFocusLost

    private void e_searchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_e_searchKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_e_searchKeyTyped

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // save btn for employee:
        
        String id = e_id.getText();
        String fname = e_fn.getText();
        String lname = e_ln.getText();
        String gen = e_gn.getSelectedItem().toString();
        String age = e_ag.getText();
        String con = e_cn.getText();
        String des = e_ds.getSelectedItem().toString();
        String add = e_ad.getText();

        Date date = e_jn.getDate();
        String jdate = DateFormat.getDateInstance().format(date);

        //System.out.println(jdate);
        //String pw = e_pw.getText();
        
        try{
            Statement s = (Statement) db.mycon().createStatement();
            s.executeUpdate(" INSERT INTO employee(eid, efname, elname, egen, eage, econ, eadd, edes, ejoin) VALUES('"+id+"', '"+fname+"','"+lname+"','"+gen+"','"+age+"','"+con+"','"+add+"','"+des+"','"+jdate+"') ");
            
        }catch(SQLException e) {
            System.out.println(e);
        }
        allset();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void e_gnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_e_gnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_e_gnActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // Update employee info:
        String id = e_id.getText();
        String fname = e_fn.getText();
        String lname = e_ln.getText();
        String gen = e_gn.getSelectedItem().toString();
        String age = e_ag.getText();
        String con = e_cn.getText();
        String des = e_ds.getSelectedItem().toString();
        String add = e_ad.getText();

        //Date date = e_jn.getDate();
        //String jdate = DateFormat.getDateInstance().format(date);

        //System.out.println(jdate);
        //String pw = e_pw.getText();
        
        try{
            Statement s = (Statement) db.mycon().createStatement();
            s.executeUpdate(" UPDATE employee SET eid = '"+id+"', efname = '"+fname+"', elname = '"+lname+"', egen = '"+gen+"', eage = '"+age+"', econ = '"+con+"', eadd = '"+add+"', edes = '"+des+"' WHERE eid = '"+id+"'");
            
        }catch(SQLException e) {
            System.out.println(e);
        }
        allset();
    
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // search button on employee (mouse click)
        String sr = e_search.getText();
        try{
            Statement s = (Statement) db.mycon().createStatement();
            
            ResultSet rs = s.executeQuery(" SELECT * FROM employee WHERE eid = '"+sr+"'");
            
            if(rs.next()) {
                  e_id.setText(rs.getString("eid"));
                  e_fn.setText(rs.getString("efname"));
                  e_ln.setText(rs.getString("elname"));
                  e_gn.setSelectedItem(rs.getString("egen"));
                  e_ag.setText(rs.getString("eage"));
                  e_cn.setText(rs.getString("econ"));
                  e_ad.setText(rs.getString("eadd"));
                  e_ds.setSelectedItem(rs.getString("edes"));
                  //e_pw.setText(rs.getString("epw"));
            }
        } catch (SQLException ex) {
            //Logger.getLogger(customer.class.getName()).log(Level.SEVERE, null, ex);
            System.out.print(ex);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // Delete employee from table:
        DefaultTableModel dt = (DefaultTableModel) e_table.getModel();
        int rw = e_table.getSelectedRow();
        String id =  e_table.getValueAt(e_table.getSelectedRow(), 0).toString();

        dt.removeRow(rw);
        
         try{
            Statement s = (Statement) db.mycon().createStatement();
            
            int rs = s.executeUpdate(" DELETE FROM employee WHERE eid = '"+id+"'");
            
            
        }catch(SQLException e) {
            System.out.println(e);
        }
        allset();
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea e_ad;
    private javax.swing.JTextField e_ag;
    private javax.swing.JTextField e_cn;
    private javax.swing.JComboBox<String> e_ds;
    private javax.swing.JTextField e_fn;
    private javax.swing.JComboBox<String> e_gn;
    private javax.swing.JTextField e_id;
    private com.toedter.calendar.JDateChooser e_jn;
    private javax.swing.JTextField e_ln;
    private javax.swing.JTextField e_search;
    private javax.swing.JTable e_table;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField7;
    // End of variables declaration//GEN-END:variables
}
