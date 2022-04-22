import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import java.awt.event.*;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.awt.*;

public class Page extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;

	int voter_id;

	JButton b1,b2,b3,b4,b5,b6,b7,b8,b,vb,cb;
	JPanel p1,p2,p3;
	JLabel l1,l2,vl,cl,vl1,vl2,vl3,vl4,vl5,vl6,vl7,vl8,vl9,vl10,vl11,cl1,cl2,cl3,cl4,cl5,cl6;
	JTable t1;
	JComboBox<Object> box;
	JTextField vt,vt1,vt2,vt3,vt4,vt5,vt6,vt7,vt8,vt9,vt10,vt11,ct1,ct2,ct3,ct4,ct5,ct6;
	
	Page(String user) {
		
		setTitle("HOME");
		setVisible(true);
		setExtendedState(MAXIMIZED_BOTH);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBackground(Color.BLUE);
		setLayout(new BorderLayout());
		
		b1=new JButton("Home");
		b2=new JButton("Voter's List");
		b3=new JButton("View Candidates");
		b4=new JButton("View Result");
		b5=new JButton("Cast Vote");
		b6=new JButton("Add Voters");
		b7=new JButton("Add Candidates");
		b8=new JButton("Log Out");

		b1.setPreferredSize(new Dimension(140,40));
		b2.setPreferredSize(new Dimension(140,40));
		b3.setPreferredSize(new Dimension(140,40));
		b4.setPreferredSize(new Dimension(140,40));
		b5.setPreferredSize(new Dimension(140,40));
		b6.setPreferredSize(new Dimension(140,40));
		b7.setPreferredSize(new Dimension(140,40));
		b8.setPreferredSize(new Dimension(140,40));
		
		p1=new JPanel();
		p1.setBackground(Color.BLACK);
		p1.setPreferredSize(new Dimension(180,50));
		p1.setLayout(new FlowLayout(FlowLayout.LEADING,10,40));
		p1.add(b1);
		p1.add(b2);
	    p1.add(b3);
		p1.add(b4);
		p1.add(b5);
		if(user.equals("admin")) {
			p1.add(b6);
			p1.add(b7);
			p1.add(b8);
		}
		p2=new JPanel();
		p2.setPreferredSize(new Dimension(1000,500));
		
		p3=new JPanel();
		p3.setOpaque(false);

		add(p1,BorderLayout.WEST);
		add(p2);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		b7.addActionListener(this);
		b8.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==b1) {
			p3.removeAll();
			p3.repaint();
			p3.revalidate();
		}
		if(e.getSource()==b2) {
			
			p3.removeAll();
			p3.repaint();
			p3.revalidate();
			
			try {
				ResultSet rs = Display.voters();
				
				String data[][]={{"Name","ID","Sex","Status","Age","City","Vote_status"}};
				String col[]={"Name","ID","Sex","Status","Age","City","Vote_Status"};
				
				DefaultTableModel model=new DefaultTableModel(data,col);
				t1=new JTable(model);
				
				while(rs.next()) {
					model.insertRow(t1.getRowCount(),new Object[] {"\""+rs.getString("name")+"\"","\""+rs.getInt("v_id")+"\"","\""+rs.getString("sex")+"\"","\""+rs.getString("status")+"\"","\""+rs.getInt("age")+"\"","\""+rs.getString("city")+"\"","\""+rs.getString("v_status")+"\""});
				} 
				p3.add(t1);
			    p2.add(p3);    
			}
			catch(Exception e1) {e1.printStackTrace();}
		}
		if(e.getSource()==b3) {
			
			p3.removeAll();
			p3.repaint();
			p3.revalidate();
			
			try {
				ResultSet rs1=Display.candidates();
				
				String data[][]={{"Name","Symbol","Age","Sex","Vote_count"}};
				String col[]={"Name","Symbol","Age","Sex","Vote_count"};
				
				DefaultTableModel model=new DefaultTableModel(data,col);
				t1=new JTable(model);
				
				while(rs1.next()) {
					model.insertRow(t1.getRowCount(),new Object[] {"\""+rs1.getString("name")+"\"","\""+rs1.getString("symbol")+"\"","\""+rs1.getString("age")+"\"","\""+rs1.getString("sex")+"\"","\""+rs1.getString("count")+"\""});
				} 
				p3.add(t1);
			    p2.add(p3);  
				}
				catch(Exception e1) {e1.printStackTrace();}
		}
		if(e.getSource()==b4) {
			
			p3.removeAll();
			p3.repaint();
			p3.revalidate();
			
			try {
				ResultSet rs2=Display.result();
				
				String data[][]={{"Name","Symbol","Vote_count"}};
				String col[]={"Name","Symbol","Vote_count"};
				
				DefaultTableModel model=new DefaultTableModel(data,col);
				t1=new JTable(model);
				
				while(rs2.next()) {
					model.insertRow(t1.getRowCount(),new Object[] {"\""+rs2.getString("name")+"\"","\""+rs2.getString("symbol")+"\"","\""+rs2.getInt("count")+"\""});
				} 
				p3.add(t1);
			    p2.add(p3);  
			    
				}
				catch(Exception e1) {e1.printStackTrace();}
		}
		if(e.getSource()==b5) {
		
			p3.removeAll();
			p3.repaint();
			p3.revalidate();
			
			try {
				ResultSet rs3=Display.candidates();
				ArrayList<String> list=new ArrayList<String>();
				while(rs3.next()) 
					list.add(rs3.getString("symbol"));
			   	box=new JComboBox<Object>(list.toArray());
				box.setPreferredSize(new Dimension(30,30));
				b=new JButton("Vote");
				l1=new JLabel("Enter voter id:");
				vt=new JTextField();
				l2=new JLabel("Select the Symbol to vote and Click \'Vote\' button");
				l2.setFont(new Font("Times New Roman",Font.BOLD,20));
				p3.setLayout(new GridLayout(5,1,20,20));
				p3.add(l1);
				p3.add(vt);
				p3.add(l2);
				p3.add(box);
				p3.add(b);
			    p2.add(p3);
			    
			    b.addActionListener(this);
			}catch(Exception e2) {e2.printStackTrace();}
		}
		if(e.getSource()==b6) {
			
			p3.removeAll();
			p3.repaint();
			p3.revalidate();
			
			vl=new JLabel("Add New Voter");
			vl.setFont(new Font("Times New Roman",Font.BOLD,20));
			vl1=new JLabel("Voter ID:");
			vt1=new JTextField();
			vl2=new JLabel("Name:");
			vt2=new JTextField();
			vl3=new JLabel("Sex:");
			vt3=new JTextField();
			vl4=new JLabel("Age:");
			vt4=new JTextField();
			vl5=new JLabel("Status:");
			vt5=new JTextField();
			vl6=new JLabel("City:");
			vt6=new JTextField();
			vl7=new JLabel("Vote Status:");
			vt7=new JTextField();
			vt7.setText("no");
			vt7.setEditable(false);
			vl8=new JLabel("Aadhar Number:");
			vt8=new JTextField();
			vl9=new JLabel("Phone Number:");
			vt9=new JTextField();
			vl10=new JLabel("Username:");
			vt10=new JTextField();
			vl11=new JLabel("Password:");
			vt11=new JTextField();
			vb=new JButton("Add Voter");
			p3.setLayout(new GridLayout(25,1,5,5));
				p3.add(vl);
				p3.add(vl1);
				p3.add(vt1);
				p3.add(vl2);
				p3.add(vt2);
				p3.add(vl3);
				p3.add(vt3);
				p3.add(vl4);
				p3.add(vt4);
				p3.add(vl5);
				p3.add(vt5);
				p3.add(vl6);
				p3.add(vt6);
				p3.add(vl7);
				p3.add(vt7);
				p3.add(vl8);
				p3.add(vt8);
				p3.add(vl9);
				p3.add(vt9);
				p3.add(vl10);
				p3.add(vt10);
				p3.add(vl11);
				p3.add(vt11);
				p3.add(vb);
			    p2.add(p3);
			    
			    vb.addActionListener(this);
		}
		if(e.getSource()==b7) {
			
			p3.removeAll();
			p3.repaint();
			p3.revalidate();
			
			cl=new JLabel("Add New Candidate");
			cl.setFont(new Font("Times New Roman",Font.BOLD,20));
			cl1=new JLabel("Name:");
			ct1=new JTextField();
			cl2=new JLabel("Symbol:");
			ct2=new JTextField();
			cl3=new JLabel("Age:");
			ct3=new JTextField();
			cl4=new JLabel("Sex:");
			ct4=new JTextField();
			cl5=new JLabel("City:");
			ct5=new JTextField();
			cl6=new JLabel("Count:");
			ct6=new JTextField();
			ct6.setText("0");
			ct6.setEditable(false);
			cb=new JButton("Add Candidate");
			p3.setLayout(new GridLayout(14,1,10,10));
			p3.add(cl);
			p3.add(cl1);
			p3.add(ct1);
			p3.add(cl2);
			p3.add(ct2);
			p3.add(cl3);
			p3.add(ct3);
			p3.add(cl4);
			p3.add(ct4);
			p3.add(cl5);
			p3.add(ct5);
			p3.add(cl6);
			p3.add(ct6);
			p3.add(cb);
		    p2.add(p3);
		    
		    cb.addActionListener(this);
		}
		if(e.getSource()==b8) {
			if(JOptionPane.showConfirmDialog(null, "Are you sure you want to logout?")==0) {
				dispose();
				Login l=new Login();
			}
		}
		if(e.getSource()==b) {
			
			voter_id=Integer.parseInt(vt.getText());
			String c=(String)box.getSelectedItem();
			try {
				if(Display.voted(voter_id)){
					JOptionPane.showMessageDialog(null, "You had already Voted");
				}
			else
				Add.vote_status(c,voter_id);
			}
			catch(Exception e1) {e1.printStackTrace();}
		}
		if(e.getSource()==vb) {
			int id=Integer.parseInt(vt1.getText());
			String name=vt2.getText();
			String sex=vt3.getText();
			String status=vt5.getText();
			String city=vt6.getText();
			String v_s=vt7.getText();
			String a_no=vt8.getText();
			String uname=vt10.getText();
			String pass=vt11.getText();
			int age=Integer.parseInt(vt4.getText());
			int phone=Integer.parseInt(vt9.getText());

			Add.voter(id,name,sex,age,status,city,v_s,a_no,phone,uname,pass);
		}
		if(e.getSource()==cb) {
			String name=ct1.getText();
			String symbol=ct2.getText();
			String sex=ct4.getText();
			String city=ct5.getText();
			int age=Integer.parseInt(ct3.getText());
			int count=Integer.parseInt(ct6.getText());

			Add.candidate(name,symbol,sex,age,city,count);
		}
	}
}
