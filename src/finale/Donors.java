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
public class Donors extends javax.swing.JFrame implements ActionListener {

    /**
     * Creates new form Professors
     */
    DefaultTableModel PFmodel;
    Connection PFcon;
    Statement PFstmt;
    ResultSet PFrs;
    Button PF_IB = new Button("Insert");
    Button PF_UB = new Button("Update");
    Button PF_SB = new Button("Search");
    Button PF_DB = new Button("Delete");
    Button FBack = new Button("Back");
    Button PhonesB = new Button("Phones");
    Button RB = new Button("Refresh");
    TextField DO_NNF = new TextField();
    TextField DO_FNameF = new TextField();
    TextField DO_LNameF = new TextField();
    TextField DO_BTF = new TextField();
    TextField DO_DDateF = new TextField();
    TextField DO_DARF = new TextField();
    TextField D_EFN4F = new TextField();
    TextField N_EFN2F = new TextField();
    Label label1 = new Label("National Number");
    Label label2 = new Label("First Name");
    Label label3 = new Label("Last Name");
    Label label4 = new Label("Blood Type");
    Label label5 = new Label("Donate Date");
    Label label6 = new Label("Anemia Rate");
    Label label7 = new Label("Doctor E. File No.");
    Label label8 = new Label("Nurse E. File No.");

    public Donors() {
        setTitle("Donors");
        initComponents();
        PFcontoSQL();
        //  B u t t o n s 
        PF_IB.addActionListener(this);
        PF_UB.addActionListener(this);
        PF_DB.addActionListener(this);
        PF_SB.addActionListener(this);
        FBack.addActionListener(this);
        PhonesB.addActionListener(this);
        RB.addActionListener(this);
        PF_IB.setBackground(Color.YELLOW);
        PF_UB.setBackground(Color.YELLOW);
        PF_DB.setBackground(Color.YELLOW);
        PF_SB.setBackground(Color.YELLOW);
        RB.setBackground(Color.YELLOW);
        PhonesB.setBackground(Color.GREEN);
        FBack.setBackground(Color.RED);
        PF_IB.setBounds(700, 415, 73, 29);
        add(PF_IB);
        PF_UB.setBounds(800, 415, 73, 29);
        add(PF_UB);
        PF_DB.setBounds(700, 450, 73, 29);
        add(PF_DB);
        PF_SB.setBounds(800, 450, 73, 29);
        add(PF_SB);
        FBack.setBounds(900, 450, 73, 29);
        add(FBack);
        PhonesB.setBounds(900, 415, 73, 29);
        add(PhonesB);
        RB.setBounds(800, 380, 73, 29);
        add(RB);
        //End
        //Text Field
        DO_NNF.setBounds(40, 440, 90, 40);
        add(DO_NNF);
        DO_FNameF.setBounds(150, 440, 90, 40);
        add(DO_FNameF);
        DO_LNameF.setBounds(260, 440, 90, 40);
        add(DO_LNameF);
        DO_BTF.setBounds(370, 440, 90, 40);
        add(DO_BTF);
        DO_DDateF.setBounds(480, 440, 90, 40);
        add(DO_DDateF);
        DO_DARF.setBounds(590, 440, 90, 40);
        add(DO_DARF);
        D_EFN4F.setBounds(150, 530, 90, 40);
        add(D_EFN4F);
        N_EFN2F.setBounds(480, 530, 90, 40);
        add(N_EFN2F);
        //End
        //Label
        label1.setBounds(40, 410, 110, 40);
        add(label1);
        label2.setBounds(150, 410, 90, 40);
        add(label2);
        label3.setBounds(260, 410, 90, 40);
        add(label3);
        label4.setBounds(370, 410, 90, 40);
        add(label4);
        label5.setBounds(480, 410, 90, 40);
        add(label5);
        label6.setBounds(590, 410, 90, 40);
        add(label6);
        label7.setBounds(150, 500, 120, 40);
        add(label7);
        label8.setBounds(480, 500, 120, 40);
        add(label8);

        //END
    }

    public void PFcontoSQL() {
        PFmodel = new DefaultTableModel();
        PFmodel.addColumn("National Number");
        PFmodel.addColumn("First Name");
        PFmodel.addColumn("Last Name");
        PFmodel.addColumn("Blood Type");
        PFmodel.addColumn("Donate Date");
        PFmodel.addColumn("Anemia Rate");
        PFmodel.addColumn("Doctor E. File No.");
        PFmodel.addColumn("Nurse E. File No.");
        PF_T.setModel(PFmodel);

        String path = "jdbc:sqlserver://localhost:1433;databaseName=bb;encrypt=true;trustServerCertificate=true;";
        String user = "jazz";
        String pass = "123";

        try {
            PFcon = DriverManager.getConnection(path, user, pass);
            PFstmt = PFcon.createStatement();
            PFrs = PFstmt.executeQuery("select * from Donors");

            while (PFrs.next()) {
                PFmodel.addRow(new Object[]{PFrs.getInt("DO_NN"), PFrs.getString("DO_FName"), PFrs.getString("DO_LName"), PFrs.getString("DO_BT"), PFrs.getString("DO_DDate"), PFrs.getString("DO_DAR"), PFrs.getInt("D_EFN4"), PFrs.getInt("N_EFN2")});
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
        PF_T = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        PF_T.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(PF_T);

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
                .addGap(0, 230, Short.MAX_VALUE))
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
            java.util.logging.Logger.getLogger(Donors.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Donors.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Donors.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Donors.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Donors().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable PF_T;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == FBack) {
            Home m = new Home();
            m.show();
            dispose();
        }
        if (e.getSource() == PhonesB) {
            DO_Phone m = new DO_Phone();
            m.show();
            dispose();
        }
        if (e.getSource() == PF_IB) {
            int DO_NN = Integer.parseInt(DO_NNF.getText());
            String DO_FName = DO_FNameF.getText();
            String DO_LName = DO_LNameF.getText();
            String DO_BT = DO_BTF.getText();
            String DO_DDate = DO_DDateF.getText();
            String DO_DAR = DO_DARF.getText();
            int D_EFN4 = Integer.parseInt(D_EFN4F.getText());
            int N_EFN2 = Integer.parseInt(N_EFN2F.getText());

            String IPFQuery = "insert into Donors values(" + DO_NN + ",'" + DO_FName + "','" + DO_LName + "','" + DO_BT + "','" + DO_DDate + "','" + DO_DAR + "'," + D_EFN4 + "," + N_EFN2 + ")";

            try {
                PFstmt.executeUpdate(IPFQuery);
            } catch (SQLException ea) {
                JOptionPane.showMessageDialog(this, ea.getMessage());
            }
            PFcontoSQL();//connection Function
        }
        if (e.getSource() == PF_UB) {
            int DO_NN = Integer.parseInt(DO_NNF.getText());
            String DO_FName = DO_FNameF.getText();
            String DO_LName = DO_LNameF.getText();
            String DO_BT = DO_BTF.getText();
            String DO_DDate = DO_DDateF.getText();
            String DO_DAR = DO_DARF.getText();
            int D_EFN4 = Integer.parseInt(D_EFN4F.getText());
            int N_EFN2 = Integer.parseInt(N_EFN2F.getText());

            String UPFQuery = "update Donors set DO_FName ='" + DO_FName + "', DO_LName='" + DO_LName + "', DO_BT='" + DO_BT + "', DO_DDate='" + DO_DDate + "', DO_DAR='" + DO_DAR + "', D_EFN4=" + D_EFN4 + ",N_EFN2=" + N_EFN2 + "  where DO_NN =" + DO_NN;

            try {
                PFstmt.executeUpdate(UPFQuery);
            } catch (SQLException ea) {
                JOptionPane.showMessageDialog(this, ea.getMessage());
            }
            PFcontoSQL();
        }
        if (e.getSource() == PF_DB) {
            int DO_NN = Integer.parseInt(DO_NNF.getText());
            String DPfQuery = "delete from DO_Phone where DO_NN1 = " + DO_NN;
            String DPfQuery3 = "delete from Donors where DO_NN = " + DO_NN;

            try {
                PFstmt.executeUpdate(DPfQuery);
                PFstmt.executeUpdate(DPfQuery3);
            } catch (SQLException ea) {
                JOptionPane.showMessageDialog(this, ea.getMessage());
            }
            PFcontoSQL();
        }
        if (e.getSource() == RB) {
            PFcontoSQL();
        }
        if (e.getSource() == PF_SB) {
            PFmodel = new DefaultTableModel();
            PFmodel.addColumn("National Number");
            PFmodel.addColumn("First Name");
            PFmodel.addColumn("Last Name");
            PFmodel.addColumn("Blood Type");
            PFmodel.addColumn("Donate Date");
            PFmodel.addColumn("Anemia Rate");
            PFmodel.addColumn("Doctor E. File No.");
            PFmodel.addColumn("Nurse E. File No.");

            PF_T.setModel(PFmodel);

            String path = "jdbc:sqlserver://localhost:1433;databaseName=bb;encrypt=true;trustServerCertificate=true;";
            String user = "jazz";
            String pass = "123";

            try {
                int DO_NN = Integer.parseInt(DO_NNF.getText());
                PFcon = DriverManager.getConnection(path, user, pass);
                PFstmt = PFcon.createStatement();
                PFrs = PFstmt.executeQuery("select * from Donors where DO_NN = " + DO_NN);

                while (PFrs.next()) {
                    PFmodel.addRow(new Object[]{PFrs.getInt("DO_NN"), PFrs.getString("DO_FName"), PFrs.getString("DO_LName"), PFrs.getString("DO_BT"), PFrs.getString("DO_DDate"), PFrs.getString("DO_DAR"), PFrs.getInt("D_EFN4"), PFrs.getInt("N_EFN2")});
                }
            } catch (SQLException ae) {
                JOptionPane.showMessageDialog(this, ae.getMessage());
            }

        }

    }
}
