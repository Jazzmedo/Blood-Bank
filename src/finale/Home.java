package finale;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Home extends Frame implements ActionListener {
    Frame Main = new Frame();
    Button DonorsB = new Button("Donors");
    Button NursesB = new Button("Nurses");
    Button DoctorsB = new Button("Doctors");
    Button ExitB = new Button("Exit");
    public Button G_SBack = new Button();

    Home()
    {
        setTitle("Home Page");
        setLayout(null);
        setBounds(450,150,500,500);
        //setVisible(true);
        NursesB.setBounds(50,50,137,53);
        DonorsB.setBounds(315,50,137,53);
        DoctorsB.setBounds(181,160,137,53);
        ExitB.setBounds(181,397,137,53);
        ExitB.setBackground(Color.RED);
        DonorsB.setBackground(Color.GREEN);
        NursesB.setBackground(Color.GREEN);
        DoctorsB.setBackground(Color.GREEN);
        add(NursesB);
        add(DonorsB);
        add(DoctorsB);
        add(ExitB);
        ExitB.addActionListener(this);
        DonorsB.addActionListener(this);
        NursesB.addActionListener(this);
        DoctorsB.addActionListener(this);
        Main.setBounds(450,150,500,500);
        setVisible(true);
        

    }
    public static void main(String[] args) {
        // TODO code application logic here
        Home FMain = new Home();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==ExitB)
            System.exit(0);
        if(e.getSource()==NursesB)
        {
            Nurses pj1 = new Nurses();
            dispose();
            pj1.show();
        }
        if(e.getSource()==DonorsB)
        {
            Donors pf1 = new Donors();
            dispose();
            pf1.show();
        }
        if(e.getSource()==DoctorsB)
        {
            Doctors gs1 = new Doctors();
            dispose();
            gs1.show();
        }
    }
    
}
