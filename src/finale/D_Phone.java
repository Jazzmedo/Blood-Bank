/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finale;

import java.awt.Button;
import java.awt.Color;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Mohamed
 */
public class D_Phone extends javax.swing.JFrame implements ActionListener {

    /**
     * Creates new form S_Phone
     */
    DefaultTableModel SPmodel;
    Connection SPcon;
    Statement SPstmt;
    ResultSet SPrs;
    Button SP_IB = new Button("Insert");
    Button SP_UB = new Button("Back");
    Button SP_SB = new Button("Search");
    Button SP_DB = new Button("Delete");
    TextField D_PhoneF = new TextField();
    TextField D_EFN1F = new TextField();
    Label label1 = new Label("Phone");
    Label label3 = new Label("Electronic File Number");

    public D_Phone() {
        setTitle("Students' Phones");
        initComponents();
        SPcontoSQL();
        //  B u t t o n s 
        SP_IB.addActionListener(this);
        SP_UB.addActionListener(this);
        SP_DB.addActionListener(this);
        SP_SB.addActionListener(this);
        SP_IB.setBackground(Color.YELLOW);
        SP_UB.setBackground(Color.RED);
        SP_DB.setBackground(Color.YELLOW);
        SP_SB.setBackground(Color.YELLOW);
        SP_IB.setBounds(700, 415, 73, 29);
        add(SP_IB);
        SP_UB.setBounds(800, 415, 73, 29);
        add(SP_UB);
        SP_DB.setBounds(700, 450, 73, 29);
        add(SP_DB);
        SP_SB.setBounds(800, 450, 73, 29);
        add(SP_SB);
        //End
        //Text Field
        D_PhoneF.setBounds(150, 440, 90, 40);
        add(D_PhoneF);
        D_EFN1F.setBounds(370, 440, 90, 40);
        add(D_EFN1F);
        //End
        //Label
        label1.setBounds(150, 410, 90, 40);
        add(label1);
        label3.setBounds(350, 410, 150, 40);
        add(label3);

    }

    public void SPcontoSQL() {
        SPmodel = new DefaultTableModel();
        SPmodel.addColumn("Phone");
        SPmodel.addColumn("Electronic File Number");
        S_P.setModel(SPmodel);

        String path = "jdbc:sqlserver://localhost:1433;databaseName=bb;encrypt=true;trustServerCertificate=true;";
        String user = "jazz";
        String pass = "123";

        try {
            SPcon = DriverManager.getConnection(path, user, pass);
            SPstmt = SPcon.createStatement();
            SPrs = SPstmt.executeQuery("select * from D_Phone");

            while (SPrs.next()) {
                SPmodel.addRow(new Object[]{SPrs.getString("D_Phone"), SPrs.getInt("D_EFN1")});
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
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

        jScrollPane1 = new javax.swing.JScrollPane();
        S_P = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        S_P.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(S_P);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 93, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(D_Phone.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(D_Phone.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(D_Phone.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(D_Phone.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new D_Phone().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable S_P;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == SP_IB) {
            int D_EFN1 = Integer.parseInt(D_EFN1F.getText());
            String D_Phone = D_PhoneF.getText();

            String ISPQuery = "insert into D_Phone values('" + D_Phone + "'," + D_EFN1 + ")";

            try {
                SPstmt.executeUpdate(ISPQuery);
            } catch (SQLException ea) {
                JOptionPane.showMessageDialog(this, ea.getMessage());
            }
            SPcontoSQL();
        }
        if (e.getSource() == SP_UB) {
            Doctors gs1 = new Doctors();
            dispose();
            gs1.show();
        }
        if (e.getSource() == SP_DB) {
            String D_Phone = D_PhoneF.getText();
            String DSPQuery = "delete from D_Phone where D_Phone = '" + D_Phone+"'";

            try {
                SPstmt.executeUpdate(DSPQuery);
            } catch (SQLException ea) {
                JOptionPane.showMessageDialog(this, ea.getMessage());
            }
            SPcontoSQL();
        }
        if (e.getSource() == SP_SB) {
            SPmodel = new DefaultTableModel();
            SPmodel.addColumn("Phone");
            SPmodel.addColumn("Electronic File Number");
            S_P.setModel(SPmodel);
            String path = "jdbc:sqlserver://localhost:1433;databaseName=bb;encrypt=true;trustServerCertificate=true;";
            String user = "jazz";
            String pass = "123";
            String D_Phone = D_PhoneF.getText();
            String SSPQuery = "select * from D_Phone where D_Phone ='" + D_Phone + "'";
            try {
                SPcon = DriverManager.getConnection(path, user, pass);
                SPstmt = SPcon.createStatement();
                SPrs = SPstmt.executeQuery(SSPQuery);

                while (SPrs.next()) {
                SPmodel.addRow(new Object[]{SPrs.getString("D_Phone"), SPrs.getInt("D_EFN1")});
                }
            } catch (SQLException ea) {
                JOptionPane.showMessageDialog(this, ea.getMessage());
            }
        }

    }
}