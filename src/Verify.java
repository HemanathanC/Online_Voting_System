import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class Verify extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	
	int otp; 
	
	JLabel l1,l2,b_l;
	JTextField t1,t2;
	JButton b1;
	JPanel p1,p2,p3;

	public Verify() {
		
		setTitle("Verification ");
		setSize(600,600);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLayout(new GridLayout(10,1));
		
		p1=new JPanel();
		p2=new JPanel();
		p3=new JPanel();
		
		l1=new JLabel("Enter Username:");
		p1.add(l1);
		
		t1=new JTextField();
		t1.setPreferredSize(new Dimension(250,30));
		t1.setFont(new Font("Consolas",Font.PLAIN,20));
		t1.setBounds(100,100,500,500);
		t1.setVisible(true);
		p1.add(t1);
		
		l2=new JLabel("Enter Password:");
		p2.add(l2);
		
		t2=new JTextField();
		t2.setPreferredSize(new Dimension(250,30));
		t2.setFont(new Font("Consolas",Font.PLAIN,20));
		t2.setBounds(100,100,500,500);
		t2.setVisible(true);
		p2.add(t2);
		
		b1=new JButton("LOGIN");
		b1.setFocusable(false);
		p3.add(b1);
		
		add(p1);
		add(p2);
		add(p3);	
		
		b1.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e)  {

		if(e.getSource()==b1) {
			String a=t1.getText();
			String p=t2.getText();
			
			if(Aadhar.check(a,p)) {
				dispose();
			    Page f=new Page("user");
			}
			else {
				JOptionPane.showMessageDialog(null,"Invalid Username and Password");
			}
		}
		
	}
}