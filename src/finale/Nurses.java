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
import java.sql.Date;

/**
 *
 * @author Mohamed
 */
public class Nurses extends javax.swing.JFrame implements ActionListener {

    /**
     * Creates new form Projects
     */
    DefaultTableModel PRmodel;
    Connection PRcon;
    Statement PRstmt;
    ResultSet PRrs;
    Button PR_IB = new Button("Insert");
    Button PR_UB = new Button("Update");
    Button PR_SB = new Button("Search");
    Button PR_DB = new Button("Delete");
    Button FBack = new Button("Back");
    Button WorkB = new Button("Phones");
    Button RB = new Button("Refresh");
    TextField N_EFNF = new TextField();
    TextField N_FNameF = new TextField();
    TextField N_LNameF = new TextField();
    TextField N_NIDF = new TextField();
    TextField N_SalaryF = new TextField();
    TextField D_EFN3F = new TextField();
    Label label1 = new Label("Electronic File No.");
    Label label2 = new Label("First Name");
    Label label3 = new Label("Last Name");
    Label label4 = new Label("National ID");
    Label label5 = new Label("Salary");
    Label label6 = new Label("Doctor's Electronic File No.");

    public Nurses() {
        setTitle("Nurses");
        initComponents();
        PRcontoSQL();
        //  B u t t o n s 
        PR_IB.addActionListener(this);
        PR_UB.addActionListener(this);
        PR_DB.addActionListener(this);
        PR_SB.addActionListener(this);
        FBack.addActionListener(this);
        WorkB.addActionListener(this);
        RB.addActionListener(this);
        WorkB.setBackground(Color.GREEN);
        PR_IB.setBackground(Color.YELLOW);
        PR_UB.setBackground(Color.YELLOW);
        PR_DB.setBackground(Color.YELLOW);
        PR_SB.setBackground(Color.YELLOW);
        RB.setBackground(Color.YELLOW);
        FBack.setBackground(Color.RED);
        PR_IB.setBounds(700, 415, 73, 29);
        add(PR_IB);
        PR_UB.setBounds(800, 415, 73, 29);
        add(PR_UB);
        PR_DB.setBounds(700, 450, 73, 29);
        add(PR_DB);
        PR_SB.setBounds(800, 450, 73, 29);
        add(PR_SB);
        FBack.setBounds(900, 450, 73, 29);
        add(FBack);
        WorkB.setBounds(900, 415, 73, 29);
        add(WorkB);
        RB.setBounds(800, 380, 73, 29);
        add(RB);

        //End
        //Text Field
        N_EFNF.setBounds(40, 440, 90, 40);
        add(N_EFNF);
        N_FNameF.setBounds(150, 440, 90, 40);
        add(N_FNameF);
        N_LNameF.setBounds(260, 440, 90, 40);
        add(N_LNameF);
        N_NIDF.setBounds(370, 440, 90, 40);
        add(N_NIDF);
        N_SalaryF.setBounds(480, 440, 90, 40);
        add(N_SalaryF);
        D_EFN3F.setBounds(590, 440, 90, 40);
        add(D_EFN3F);
        //End
        //Label
        label1.setBounds(30, 410, 120, 40);
        add(label1);
        label2.setBounds(150, 410, 90, 40);
        add(label2);
        label3.setBounds(260, 410, 90, 40);
        add(label3);
        label4.setBounds(370, 410, 120, 40);
        add(label4);
        label5.setBounds(500, 410, 50, 40);
        add(label5);
        label6.setBounds(560, 410, 130, 40);
        add(label6);
        //END
    }

    public void PRcontoSQL() {
        PRmodel = new DefaultTableModel();
        PRmodel.addColumn("Electronic File Number");
        PRmodel.addColumn("First Name");
        PRmodel.addColumn("Last Name");
        PRmodel.addColumn("National ID");
        PRmodel.addColumn("Salary");
        PRmodel.addColumn("Doctor's Electronic File No.");
        PR_T.setModel(PRmodel);

        String path = "jdbc:sqlserver://localhost:1433;databaseName=bb;encrypt=true;trustServerCertificate=true;";
        String user = "jazz";
        String pass = "123";

        try {
            PRcon = DriverManager.getConnection(path, user, pass);
            PRstmt = PRcon.createStatement();
            PRrs = PRstmt.executeQuery("select * from Nurses");

            while (PRrs.next()) {
                PRmodel.addRow(new Object[]{PRrs.getInt("N_EFN"), PRrs.getString("N_FName"), PRrs.getString("N_LName"), PRrs.getInt("N_NID"), PRrs.getInt("N_Salary"), PRrs.getInt("D_EFN3")});
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
        PR_T = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        PR_T.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(PR_T);

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
                .addGap(0, 130, Short.MAX_VALUE))
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
            java.util.logging.Logger.getLogger(Nurses.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Nurses.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Nurses.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Nurses.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Nurses().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable PR_T;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == FBack) {
            Home m = new Home();
            m.show();
            dispose();
        }
        if (e.getSource() == PR_IB) {
            int N_EFN = Integer.parseInt(N_EFNF.getText());
            String N_FName = N_FNameF.getText();
            String N_LName = N_LNameF.getText();
            int N_NID = Integer.parseInt(N_NIDF.getText());
            int N_Salary = Integer.parseInt(N_SalaryF.getText());
            int D_EFN3 = Integer.parseInt(D_EFN3F.getText());

            String IPRQuery = "insert into Nurses values(" + N_EFN + ",'" + N_FName + "','" + N_LName + "'," + N_NID + "," + N_Salary + "," + D_EFN3 + ")";

            try {
                PRstmt.executeUpdate(IPRQuery);
            } catch (SQLException ea) {
                JOptionPane.showMessageDialog(this, ea.getMessage());
            }
            PRcontoSQL();

        }
        if (e.getSource() == PR_UB) {
            int N_EFN = Integer.parseInt(N_EFNF.getText());
            String N_FName = N_FNameF.getText();
            String N_LName = N_LNameF.getText();
            int N_NID = Integer.parseInt(N_NIDF.getText());
            int N_Salary = Integer.parseInt(N_SalaryF.getText());
            int D_EFN3 = Integer.parseInt(D_EFN3F.getText());

            String UPRQuery = "update Nurses set N_FName ='" + N_FName + "', N_LName='" + N_LName + "', N_NID=" + N_NID + ", N_Salary=" + N_Salary + ",D_EFN3=" + D_EFN3 + " where N_EFN = " + N_EFN;

            try {
                PRstmt.executeUpdate(UPRQuery);
            } catch (SQLException ea) {
                JOptionPane.showMessageDialog(this, ea.getMessage());
            }
            PRcontoSQL();
        }
        if (e.getSource() == RB) {
            PRcontoSQL();
        }

        if (e.getSource() == PR_DB) {
            int N_EFN = Integer.parseInt(N_EFNF.getText());
            String DPRQuery = "delete from N_Phone where N_EFN1 = " + N_EFN;
            String DPRQuery2 = "update Donors set N_EFN2=NULL where N_EFN2 =" + N_EFN;
            String DPRQuery3 = "delete from Nurses where N_EFN = " + N_EFN;
            try {
                PRstmt.executeUpdate(DPRQuery);
                PRstmt.executeUpdate(DPRQuery2);
                PRstmt.executeUpdate(DPRQuery3);
            } catch (SQLException ea) {
                JOptionPane.showMessageDialog(this, ea.getMessage());
            }
            PRcontoSQL();
        }
        if (e.getSource() == WorkB) {
            N_Phone m = new N_Phone();
            m.show();
            dispose();
        }

        if (e.getSource() == PR_SB) {
            PRmodel = new DefaultTableModel();
            PRmodel.addColumn("Electronic File Number");
            PRmodel.addColumn("First Name");
            PRmodel.addColumn("Last Name");
            PRmodel.addColumn("National ID");
            PRmodel.addColumn("Salary");
            PRmodel.addColumn("Doctor's Electronic File No.");
            PR_T.setModel(PRmodel);

            String path = "jdbc:sqlserver://localhost:1433;databaseName=bb;encrypt=true;trustServerCertificate=true;";
            String user = "jazz";
            String pass = "123";

            try {
                int N_EFN = Integer.parseInt(N_EFNF.getText());
                PRcon = DriverManager.getConnection(path, user, pass);
                PRstmt = PRcon.createStatement();
                PRrs = PRstmt.executeQuery("select * from Nurses where N_EFN = " + N_EFN);

                while (PRrs.next()) {
                    PRmodel.addRow(new Object[]{PRrs.getInt("N_EFN"), PRrs.getString("N_FName"), PRrs.getString("N_LName"), PRrs.getInt("N_NID"), PRrs.getInt("N_Salary"), PRrs.getInt("D_EFN3")});
                }
            } catch (SQLException ae) {
                JOptionPane.showMessageDialog(this, ae.getMessage());
            }
        }

    }
}
