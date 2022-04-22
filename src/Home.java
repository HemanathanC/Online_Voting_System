import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.GridLayout;
import java.awt.event.*;
public class Home extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	
	JLabel l1;
	JButton b1,b2,b3;
	Home(){
		setTitle("HOME");
		setVisible(true);
		setExtendedState(MAXIMIZED_BOTH);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		ImageIcon img=new ImageIcon("registration.jpg");
		l1=new JLabel(img);
		
		b1=new JButton("VOTER LOGIN");
		b1.setBounds(150,250,250,75);
		b2=new JButton("ADMIN LOGIN");
		b2.setBounds(450,250,250,75);
		l1.add(b1);
		l1.add(b2);
		
		add(l1);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
	}
	public static void main(String[] args) {
		
		Home home=new Home();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==b1) {
			Verify f=new Verify();
		}
		if(e.getSource()==b2) {
			dispose();
			Login l=new Login();
		}
	}

}
