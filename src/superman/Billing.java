/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package superman;

import com.mysql.jdbc.Statement;
import java.awt.EventQueue;
import java.awt.event.KeyEvent;
import java.util.List;
import java.awt.print.PrinterException;
import java.awt.event.KeyListener;
import java.sql.SQLException;
import java.sql.*;
import java.text.DecimalFormat;
import java.util.Collections;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class Billing extends javax.swing.JPanel {

    /**
     * Creates new form customer
     */
    public Billing() {
        initComponents();
        load_product();
        autoSuggest();
    }
    
    private Vector<String> vp = new Vector<String>();
    private JTextField tf;
    private boolean hide_flag = false;
    
    //loading all existing products into vector "vp"
    private void load_product() {
        try{
            Statement s = (Statement) db.mycon().createStatement(); 
            ResultSet rs = s.executeQuery("SELECT pname FROM product");
            
            while(rs.next()) {
                  String st = rs.getString("pname");
                  vp.addElement(st);
            }
            
        } catch (SQLException ex) {
            //Logger.getLogger(customer.class.getName()).log(Level.SEVERE, null, ex);
            System.out.print(ex);
        }
        Collections.sort(vp);
    }
    
    private void setModel(DefaultComboBoxModel mdl, String str) {
        ps.setModel(mdl);
        ps.setSelectedIndex(-1);
        tf.setText(str);
    }
    
    private static DefaultComboBoxModel getSuggestedModel(List<String> list, String text) {
        DefaultComboBoxModel m = new DefaultComboBoxModel();
        for(String i: list) {
            if(i.startsWith(text)) {
                m.addElement(i);
            }
        }
        return m;
        
    }
    
    public void search_it() {
    String sr = ps.getSelectedItem().toString();
        try{
            Statement s = (Statement) db.mycon().createStatement();
            
            ResultSet rs = s.executeQuery(" SELECT * FROM product WHERE pname = '"+sr+"'");
            
            if(rs.next()) {
                  bp_id.setText(rs.getString("pid"));
                  bp_name.setText(rs.getString("pname"));
                  bp_unit.setText(String.valueOf(rs.getString("price")));
                  unp = Double.parseDouble(String.valueOf(rs.getString("price")));
                  av_qty = Integer.parseInt(String.valueOf(rs.getString("qty")));

            }
        } catch (SQLException ex) {
            //Logger.getLogger(customer.class.getName()).log(Level.SEVERE, null, ex);
            System.out.print(ex);
        }
    }
    
    void autoSuggest() {
        ps.setEditable(true);
        tf = (JTextField) ps.getEditor().getEditorComponent();
        tf.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                EventQueue.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        String text = tf.getText();
                        if(text.length() == 0) {
                            ps.hidePopup();
                            setModel(new DefaultComboBoxModel(vp), text);
                        }
                        else {
                            DefaultComboBoxModel m = getSuggestedModel(vp,text);
                            
                            if(m.getSize()==0 || hide_flag) {
                                ps.hidePopup();
                                hide_flag = false;
                            }
                            else{
                                setModel(m, text);
                                ps.showPopup();
                            }
                        }
                    }
                });
            }

            @Override
            public void keyPressed(KeyEvent e) {
                String text = tf.getText();
                int code = e.getKeyCode();
                if(code==KeyEvent.VK_ENTER) {
                    if(vp.contains(text)) {
                        //vp.addElement(text);
                        Collections.sort(vp);
                        setModel(getSuggestedModel(vp, text), text);
                    }
                    hide_flag = true;
                }
                else if(code==KeyEvent.VK_ESCAPE) {
                    hide_flag = true;
                }
                else if(code==KeyEvent.VK_RIGHT) {
                    for(int i=0; i<vp.size(); i++) {
                       String str = vp.elementAt(i);
                       if(str.startsWith(text)){
                           ps.setSelectedIndex(-1);
                           tf.setText(str);
                           return;
                       }
                    }
                }
            }
            @Override
            public void keyReleased(KeyEvent e) {
                search_it();
            }
        });
    }
    
    
    
    
    
    
    
    
    
    public int av_qty;
    public double unp;
    
    public void addtable(String name, double unit_price, int qty) {
        
        DefaultTableModel dt = (DefaultTableModel) bp_table.getModel();
        
        Vector v = new Vector();
        int numRow = dt.getRowCount();
        v.add(numRow+1);
        v.add(name);
        v.add(unit_price);
        v.add(qty);
        double tot = unit_price*qty;
        v.add(tot);
        
        dt.addRow(v);
        calc();
        payablecalc();
    }
    
    public void calc() {
        int numRow = bp_table.getRowCount();
        double total = 0.0;
        for(int j=0; j<numRow; j++) {
            double val = Double.valueOf(bp_table.getValueAt(j, 4).toString());
            total += val;
        }
        
        DecimalFormat df = new DecimalFormat("00.00");
        subtot.setText(df.format(total));
    }
    
    public void payablecalc() {
        double payable;
        double sub = Double.parseDouble(subtot.getText());
        double d = Double.parseDouble(dis.getText());
        String s = sign.getSelectedItem().toString();
        if(s.equals("%")) {
            payable = sub - sub * d / 100;
        }
        else {
            payable = sub - d;
        }
        DecimalFormat df = new DecimalFormat("00.00");
        totpayable.setText(df.format(payable));
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        bp_unit = new javax.swing.JTextField();
        bp_id = new javax.swing.JTextField();
        bp_name = new javax.swing.JTextField();
        bp_tot = new javax.swing.JTextField();
        bp_qty = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        bp_table = new javax.swing.JTable();
        jButton6 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel12 = new javax.swing.JLabel();
        cng = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        paid = new javax.swing.JTextField();
        totpayable = new javax.swing.JTextField();
        dis = new javax.swing.JTextField();
        subtot = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        bp_search = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        b = new javax.swing.JTextArea();
        sign = new javax.swing.JComboBox<>();
        jButton8 = new javax.swing.JButton();
        ps = new javax.swing.JComboBox<>();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1360, 690));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-add-shopping-cart-40.png"))); // NOI18N

        jLabel6.setFont(new java.awt.Font("Verdana", 1, 28)); // NOI18N
        jLabel6.setText("Billing Point");

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
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
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

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(1360, 690));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-add-shopping-cart-40.png"))); // NOI18N

        jLabel8.setFont(new java.awt.Font("Verdana", 1, 28)); // NOI18N
        jLabel8.setText("Billing Point");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 350, 50));

        jTextField8.setBackground(new java.awt.Color(0, 51, 51));
        jTextField8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField8ActionPerformed(evt);
            }
        });
        jPanel2.add(jTextField8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 530, 10));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-add-shopping-cart-40.png"))); // NOI18N

        jLabel10.setFont(new java.awt.Font("Verdana", 1, 28)); // NOI18N
        jLabel10.setText("Billing Point");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel10)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 350, 50));

        jTextField9.setBackground(new java.awt.Color(0, 51, 51));
        jTextField9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField9ActionPerformed(evt);
            }
        });
        jPanel5.add(jTextField9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 530, 10));

        jPanel2.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 530, 100));

        jPanel7.setBackground(new java.awt.Color(0, 0, 0));
        jPanel7.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Prod. ID");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Unit Price");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Name");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Qty");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Total");

        bp_unit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bp_unitActionPerformed(evt);
            }
        });

        bp_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bp_idActionPerformed(evt);
            }
        });

        bp_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bp_nameActionPerformed(evt);
            }
        });

        bp_tot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bp_totActionPerformed(evt);
            }
        });

        bp_qty.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bp_qty.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        bp_qty.setText("0");

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton1.setText("+");
        jButton1.setToolTipText("");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jButton2.setText("-");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addGap(70, 70, 70)
                        .addComponent(jLabel3))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(bp_id, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bp_name, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(bp_unit)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bp_qty, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(1, 1, 1)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(bp_tot, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(23, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(65, 65, 65))))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(bp_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bp_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bp_unit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(bp_tot, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(bp_qty)
                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 60, 600, 80));

        bp_table.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        bp_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#", "Prod. Name", "Unit Price", "Qty", "Price"
            }
        ));
        jScrollPane1.setViewportView(bp_table);
        if (bp_table.getColumnModel().getColumnCount() > 0) {
            bp_table.getColumnModel().getColumn(0).setMinWidth(40);
            bp_table.getColumnModel().getColumn(0).setPreferredWidth(40);
            bp_table.getColumnModel().getColumn(0).setMaxWidth(40);
            bp_table.getColumnModel().getColumn(1).setMinWidth(200);
            bp_table.getColumnModel().getColumn(1).setMaxWidth(200);
            bp_table.getColumnModel().getColumn(2).setMaxWidth(100);
            bp_table.getColumnModel().getColumn(3).setMaxWidth(80);
            bp_table.getColumnModel().getColumn(4).setMaxWidth(100);
        }

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 520, 490));

        jButton6.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        jButton6.setText("Add to Cart");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 60, 130, 80));
        jPanel2.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 520, -1, -1));

        jLabel12.setBackground(new java.awt.Color(0, 0, 0));
        jLabel12.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("TOTAL PAYABLE");
        jLabel12.setOpaque(true);
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 340, 150, 40));

        cng.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        cng.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        cng.setText("0");
        jPanel2.add(cng, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 570, 150, 40));

        jLabel13.setBackground(new java.awt.Color(0, 0, 0));
        jLabel13.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("SUB-TOTAL");
        jLabel13.setOpaque(true);
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 160, 140, 40));

        jLabel15.setBackground(new java.awt.Color(0, 0, 0));
        jLabel15.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("PAID");
        jLabel15.setOpaque(true);
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 430, 150, 40));

        jLabel16.setBackground(new java.awt.Color(0, 0, 0));
        jLabel16.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("CHANGE");
        jLabel16.setOpaque(true);
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 530, 150, 40));

        jLabel17.setBackground(new java.awt.Color(0, 0, 0));
        jLabel17.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("DISCOUNT");
        jLabel17.setOpaque(true);
        jPanel2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 250, 140, 40));

        paid.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        paid.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        paid.setText("0");
        jPanel2.add(paid, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 470, 150, 40));

        totpayable.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        totpayable.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        totpayable.setText("0");
        jPanel2.add(totpayable, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 380, 150, 40));

        dis.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        dis.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        dis.setText("0");
        dis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                disActionPerformed(evt);
            }
        });
        jPanel2.add(dis, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 290, 80, 40));

        subtot.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        subtot.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        subtot.setText("0");
        jPanel2.add(subtot, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 200, 140, 40));
        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 430, -1, -1));

        bp_search.setFont(new java.awt.Font("Segoe UI", 2, 15)); // NOI18N
        bp_search.setForeground(new java.awt.Color(153, 153, 153));
        bp_search.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        bp_search.setText("     Search Product Name");
        bp_search.setAlignmentX(0.0F);
        bp_search.setAlignmentY(0.0F);
        bp_search.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 153)));
        bp_search.setDoubleBuffered(true);
        bp_search.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                bp_searchFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                bp_searchFocusLost(evt);
            }
        });
        bp_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bp_searchActionPerformed(evt);
            }
        });
        bp_search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                bp_searchKeyTyped(evt);
            }
        });
        jPanel2.add(bp_search, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 20, 220, 30));

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-search-25.png"))); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 20, 40, 30));

        jButton3.setFont(new java.awt.Font("SimSun", 1, 30)); // NOI18N
        jButton3.setText("Pay");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 340, 110, 80));

        jButton5.setFont(new java.awt.Font("SimSun", 1, 18)); // NOI18N
        jButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton5MouseClicked(evt);
            }
        });
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 430, 110, 80));
        jButton5.setText("<html><center>Print<br />Receipt</center></html>");

        jButton7.setFont(new java.awt.Font("SimSun-ExtB", 1, 30)); // NOI18N
        jButton7.setText("DONE");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 530, 110, 80));

        b.setColumns(20);
        b.setRows(5);
        jScrollPane3.setViewportView(b);

        jPanel2.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 150, 440, 460));

        sign.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        sign.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "%", "৳" }));
        jPanel2.add(sign, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 290, 60, 40));

        jButton8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton8.setText("Remove Item");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 620, -1, -1));

        ps.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                psMouseClicked(evt);
            }
        });
        ps.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                psActionPerformed(evt);
            }
        });
        ps.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                psKeyPressed(evt);
            }
        });
        jPanel2.add(ps, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 12, 190, 30));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 920));

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1070, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField7ActionPerformed

    private void jTextField8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField8ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        String sr = ps.getSelectedItem().toString();
        try{
            Statement s = (Statement) db.mycon().createStatement();
            
            ResultSet rs = s.executeQuery(" SELECT * FROM product WHERE pname = '"+sr+"'");
            
            if(rs.next()) {
                  bp_id.setText(rs.getString("pid"));
                  bp_name.setText(rs.getString("pname"));
                  bp_unit.setText(String.valueOf(rs.getString("price")));
                  unp = Double.parseDouble(String.valueOf(rs.getString("price")));
                  av_qty = Integer.parseInt(String.valueOf(rs.getString("qty")));

            }
        } catch (SQLException ex) {
            //Logger.getLogger(customer.class.getName()).log(Level.SEVERE, null, ex);
            System.out.print(ex);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTextField9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField9ActionPerformed

    private void bp_searchFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_bp_searchFocusGained
        // TODO add your handling code here:
        bp_search.setText("");
    }//GEN-LAST:event_bp_searchFocusGained

    private void bp_searchFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_bp_searchFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_bp_searchFocusLost

    private void bp_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bp_searchActionPerformed
        // search on bp(enter):
        String sr = bp_search.getText();
        try{
            Statement s = (Statement) db.mycon().createStatement();
            
            ResultSet rs = s.executeQuery(" SELECT * FROM product WHERE pname = '"+sr+"'");
            
            if(rs.next()) {
                  bp_id.setText(rs.getString("pid"));
                  bp_name.setText(rs.getString("pname"));
                  bp_unit.setText(String.valueOf(rs.getString("price")));
                  unp = Double.parseDouble(String.valueOf(rs.getString("price")));
                  av_qty = Integer.parseInt(String.valueOf(rs.getString("qty")));

            }
        } catch (SQLException ex) {
            //Logger.getLogger(customer.class.getName()).log(Level.SEVERE, null, ex);
            System.out.print(ex);
        }
    }//GEN-LAST:event_bp_searchActionPerformed

    private void bp_searchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bp_searchKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_bp_searchKeyTyped

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // minus btn on qty:
        int i = Integer.parseInt(bp_qty.getText());
        if(i>0) {
            --i;
        }
        bp_qty.setText(String.valueOf(i));
        bp_tot.setText(String.valueOf(i*unp));
    }//GEN-LAST:event_jButton2ActionPerformed

    private void bp_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bp_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bp_idActionPerformed

    private void bp_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bp_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bp_nameActionPerformed

    private void bp_unitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bp_unitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bp_unitActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // add to cart btn:
        ps.setSelectedItem(null);
        String name = bp_name.getText();
        int qty = Integer.parseInt(String.valueOf(bp_qty.getText()));
        if(qty>0) {
            addtable(name, unp, qty);
        }
        else {
            JOptionPane.showMessageDialog(null, "Invalid item quantity!", "ERROR ADDING ITEM", JOptionPane.WARNING_MESSAGE);
        }
        
        ///Updating database of product qty after adding to cart
        try{
            Statement s = (Statement) db.mycon().createStatement();
            av_qty = av_qty - qty;
            System.out.print(av_qty);
            s.executeUpdate(" UPDATE product SET qty = '"+av_qty+"' WHERE pname='"+name+"' ");
            
        }catch(SQLException e) {
            System.out.println(e);
        }
        bp_id.setText("");
        bp_name.setText("");
        bp_unit.setText("");
        bp_qty.setText("0");
        bp_tot.setText("");
        
    }//GEN-LAST:event_jButton6ActionPerformed

    private void bp_totActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bp_totActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bp_totActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // plus btn on qty:
        int i = Integer.parseInt(bp_qty.getText());
        if(i<av_qty) ++i;
        bp_qty.setText(String.valueOf(i));
        bp_tot.setText(String.valueOf(i*unp));
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // generate receipt btn:
        try{
            b.setText("\t\tEnigma Super Store\n");
            b.setText(b.getText()+"\t\tSUST IICT, Sylhet\n");
            b.setText(b.getText()+"-----------------------------------------------------------------------------------------------\n");
            b.setText(b.getText()+"# \tItem \t\tQty \tPrice\n");
            b.setText(b.getText()+"-----------------------------------------------------------------------------------------------\n");
            DefaultTableModel df = (DefaultTableModel) bp_table.getModel();
            int numRow = bp_table.getRowCount();
            for(int i=0; i<numRow; i++) {
                String name = df.getValueAt(i, 1).toString();
                String qty = df.getValueAt(i, 3).toString();
                String price = df.getValueAt(i, 4).toString();
                
                b.setText(b.getText()+(i+1)+"\t"+name+"\t\tx "+qty+"\t"+price+"\n");
            }
            b.setText(b.getText()+"-----------------------------------------------------------------------------------------------\n");
            b.setText(b.getText()+"\t\tSubtotal:\t"+subtot.getText()+"\n");
            b.setText(b.getText()+"\t\tDiscount:\t"+dis.getText()+"\n");
            b.setText(b.getText()+"\t\tTotal Payable:\t"+totpayable.getText()+"\n");
            b.setText(b.getText()+"\t\tPaid:\t"+paid.getText()+"\n");
            b.setText(b.getText()+"\t\tChange:\t"+cng.getText()+"\n\n\n");

            b.setText(b.getText()+"\tThank you for shopping with us!\n");
            b.setText(b.getText()+"\t***************\t");
            b.setText(b.getText()+"Developed by: ");
            

        }catch(Exception e) {
            System.out.println(e);
        }

    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5MouseClicked

    private void disActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_disActionPerformed
        // TODO add your handling code here:
        payablecalc();
    }//GEN-LAST:event_disActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // Entering customer given amount:
        payablecalc();
        String val = JOptionPane.showInputDialog(this, "Please Enter yout amount");
        paid.setText(val);
        double pd = Double.parseDouble(paid.getText());
        double pybl = Double.parseDouble(totpayable.getText());
        double cn = pd - pybl;
        DecimalFormat df = new DecimalFormat("00.00");
        
        if(cn >= 0)
            cng.setText(df.format(cn));
        else {
            JOptionPane.showMessageDialog(null, 
                              "Invalid Amount, Please re-enter your amount!", 
                              "Error", 
                              JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // Delete Some item from added cart:
        DefaultTableModel dt = (DefaultTableModel) bp_table.getModel();
        int rw = bp_table.getSelectedRow();
        String rwname =  bp_table.getValueAt(bp_table.getSelectedRow(), 1).toString();
        int rwqty = (int) bp_table.getValueAt(bp_table.getSelectedRow(), 3);

        dt.removeRow(rw);
        
        try{
            Statement s = (Statement) db.mycon().createStatement();
            
            ResultSet rs = s.executeQuery(" SELECT * FROM product WHERE pname = '"+rwname+"'");
            if(rs.next()) {
                av_qty = Integer.parseInt(String.valueOf(rs.getString("qty")));
            }
            
            
            av_qty = av_qty + rwqty;
            //System.out.print(av_qty);
            s.executeUpdate(" UPDATE product SET qty = '"+av_qty+"' WHERE pname='"+rwname+"' ");
            
        }catch(SQLException e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // Print Bill (download)
        
        try {
            boolean ok = b.print();
            if(ok) {
                JOptionPane.showMessageDialog(null, "Succesfully Printed", "okay", JOptionPane.INFORMATION_MESSAGE);
            }
            else {
                JOptionPane.showMessageDialog(null, "Printing", "NOT okay", JOptionPane.ERROR_MESSAGE);
            }
        }catch(PrinterException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void psActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_psActionPerformed
        // combox Suggestion selection:
    }//GEN-LAST:event_psActionPerformed

    private void psMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_psMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_psMouseClicked

    private void psKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_psKeyPressed
        // TODO add your handling code here:
        String sr = ps.getSelectedItem().toString();
        try{
            Statement s = (Statement) db.mycon().createStatement();
            
            ResultSet rs = s.executeQuery(" SELECT * FROM product WHERE pname = '"+sr+"'");
            
            if(rs.next()) {
                  bp_id.setText(rs.getString("pid"));
                  bp_name.setText(rs.getString("pname"));
                  bp_unit.setText(String.valueOf(rs.getString("price")));
                  unp = Double.parseDouble(String.valueOf(rs.getString("price")));
                  av_qty = Integer.parseInt(String.valueOf(rs.getString("qty")));

            }
        } catch (SQLException ex) {
            //Logger.getLogger(customer.class.getName()).log(Level.SEVERE, null, ex);
            System.out.print(ex);
        }
    }//GEN-LAST:event_psKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea b;
    private javax.swing.JTextField bp_id;
    private javax.swing.JTextField bp_name;
    private javax.swing.JTextField bp_qty;
    private javax.swing.JTextField bp_search;
    private javax.swing.JTable bp_table;
    private javax.swing.JTextField bp_tot;
    private javax.swing.JTextField bp_unit;
    private javax.swing.JTextField cng;
    private javax.swing.JTextField dis;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JTextField paid;
    private javax.swing.JComboBox<String> ps;
    private javax.swing.JComboBox<String> sign;
    private javax.swing.JTextField subtot;
    private javax.swing.JTextField totpayable;
    // End of variables declaration//GEN-END:variables
}
