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
public class D_Q extends javax.swing.JFrame implements ActionListener {

    DefaultTableModel Smodel;
    Connection Scon;
    Statement Sstmt;
    ResultSet Srs;
    Button S_IB = new Button("Insert");
    Button S_UB = new Button("Back");
    Button S_SB = new Button("Search");
    Button S_DB = new Button("Delete");
    TextField D_QualF = new TextField();
    TextField D_EFN2F = new TextField();
    Label label1 = new Label("Qualification");
    Label label3 = new Label("Electronic File Number");

    public D_Q() {
        setTitle("Supervision");
        initComponents();
        GcontoSQL();
        //  B u t t o n s 
        S_IB.addActionListener(this);
        S_UB.addActionListener(this);
        S_DB.addActionListener(this);
        S_SB.addActionListener(this);
        S_IB.setBackground(Color.YELLOW);
        S_UB.setBackground(Color.RED);
        S_DB.setBackground(Color.YELLOW);
        S_SB.setBackground(Color.YELLOW);
        S_IB.setBounds(700, 415, 73, 29);
        add(S_IB);
        S_UB.setBounds(800, 415, 73, 29);
        add(S_UB);
        S_DB.setBounds(700, 450, 73, 29);
        add(S_DB);
        S_SB.setBounds(800, 450, 73, 29);
        add(S_SB);
        //End
        //Text Field
        D_QualF.setBounds(40, 440, 90, 40);
        add(D_QualF);
        D_EFN2F.setBounds(260, 440, 90, 40);
        add(D_EFN2F);
        //End
        label1.setBounds(40, 410, 110, 40);
        add(label1);
        label3.setBounds(240, 410, 140, 40);
        add(label3);
        //END

    }

    public void GcontoSQL() {
        Smodel = new DefaultTableModel();
        Smodel.addColumn("Qualification");
        Smodel.addColumn("Electronic File Number");
        S_T.setModel(Smodel);

        String path = "jdbc:sqlserver://localhost:1433;databaseName=bb;encrypt=true;trustServerCertificate=true;";
        String user = "jazz";
        String pass = "123";

        try {
            Scon = DriverManager.getConnection(path, user, pass);
            Sstmt = Scon.createStatement();
            Srs = Sstmt.executeQuery("select * from D_Q");

            while (Srs.next()) {
                Smodel.addRow(new Object[]{Srs.getString("D_Qual"), Srs.getInt("D_EFN2")});
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
        S_T = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        S_T.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(S_T);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 124, Short.MAX_VALUE))
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
            java.util.logging.Logger.getLogger(D_Q.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(D_Q.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(D_Q.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(D_Q.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new D_Q().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable S_T;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == S_IB) {
            String D_Qual = D_QualF.getText();
            int D_EFN2 = Integer.parseInt(D_EFN2F.getText());

            String ISQuery = "insert into D_Q values('" + D_Qual + "'," + D_EFN2 + ")";

            try {
                Sstmt.executeUpdate(ISQuery);
            } catch (SQLException ea) {
                JOptionPane.showMessageDialog(this, ea.getMessage());
            }
            GcontoSQL();

        }
        if (e.getSource() == S_UB) {
            Doctors gs1 = new Doctors();
            dispose();
            gs1.show();

        }
        if (e.getSource() == S_DB) {
            String D_Qual = D_QualF.getText();
            String DSQuery = "delete from D_Q where D_Qual = '" + D_Qual + "'";

            try {
                Sstmt.executeUpdate(DSQuery);
            } catch (SQLException ea) {
                JOptionPane.showMessageDialog(this, ea.getMessage());
            }
            GcontoSQL();
        }
        if (e.getSource() == S_SB) {
            Smodel = new DefaultTableModel();
            Smodel.addColumn("Qualification");
            Smodel.addColumn("Electronic File Number");
            S_T.setModel(Smodel);

            String path = "jdbc:sqlserver://localhost:1433;databaseName=bb;encrypt=true;trustServerCertificate=true;";
            String user = "jazz";
            String pass = "123";

            try {
                String D_Qual = D_QualF.getText();
                Scon = DriverManager.getConnection(path, user, pass);
                Sstmt = Scon.createStatement();
                Srs = Sstmt.executeQuery("select * from D_Q where D_Qual = '"+D_Qual+"'");

                while (Srs.next()) {
                    Smodel.addRow(new Object[]{Srs.getString("D_Qual"), Srs.getInt("D_EFN2")});
                }
            } catch (SQLException ae) {
                JOptionPane.showMessageDialog(this, ae.getMessage());
            }

        }

    }
}
