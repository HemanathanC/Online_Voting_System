import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.*;

public class Login extends JFrame implements ActionListener {
	
	JLabel l1,l2;
	JTextField t1,t2;
	JPanel p1,p2,p3;
	JButton b;

	Login(){
		setTitle("Login");
		setSize(600,300);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLayout(new GridLayout(4,1));		
		
		l1=new JLabel("Username:");
		t1=new JTextField();
		t1.setPreferredSize(new Dimension(250,30));
		p1=new JPanel();
		p1.add(l1);
		p1.add(t1);
		add(p1);
		
		l2=new JLabel("Password:");
		t2=new JTextField();
		t2.setPreferredSize(new Dimension(250,30));
		p2=new JPanel();
		p2.add(l2);
		p2.add(t2);
		add(p2);
		
		b=new JButton("Login");
		b.setFocusable(false);	
		p3=new JPanel();
		p3.add(b);
		add(p3);
		b.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==b) {
			String n=t1.getText();
			String p=t2.getText();
			System.out.println(n+p);
			if(Aadhar.admin(n,p)) {
				dispose();
				Page page=new Page("admin");
			}
			else {
				JOptionPane.showMessageDialog(null, "Sorry Username and Password is Incorrect");
			}
		}
	}

}
