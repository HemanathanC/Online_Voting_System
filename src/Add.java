import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JOptionPane;

public class Add {

	public static void vote_status(String c,int v_id) {
		try {
			Connection con=Connect.getcon();
			PreparedStatement ps=con.prepareStatement("update voters set v_status='yes' where v_id='"+v_id+"'");
			int i=ps.executeUpdate();
			if(i>0) 
				addcount(c);
		}
		catch(Exception e3) {e3.printStackTrace();}
	}

	public static void voter(int id, String name, String sex, int age, String status, String city, String v_s,String a_no, int phone,String uname,String pass) {

		try {
			Connection con=Connect.getcon();
			PreparedStatement ps=con.prepareStatement("insert into voters values("+id+",'"+name+"','"+sex+"','"+age+"','"+status+"','"+city+"','"+v_s+"','"+a_no+"',"+phone+",'"+uname+"','"+pass+"')");
			int rs=ps.executeUpdate();
			if(rs>0) 
				JOptionPane.showMessageDialog(null, "Voter Added Sucessfully");			    
		}
		catch(Exception e3) {e3.printStackTrace();}
	}

	public static void candidate(String name, String symbol, String sex, int age, String city, int count) {
		
		try {
			Connection con=Connect.getcon();
			PreparedStatement ps=con.prepareStatement("insert into candidates values('"+name+"','"+symbol+"','"+sex+"',"+age+",'"+city+"',"+count+")");
			int rs=ps.executeUpdate();
			if(rs>0) 
				JOptionPane.showMessageDialog(null, "Candidate Added Sucessfully");			    
		}
		catch(Exception e3) {e3.printStackTrace();}		
	}

	public static void addcount(String c) {
		
		try {
			Connection con=Connect.getcon();
			PreparedStatement ps=con.prepareStatement("update candidates set count="+Display.getcount(c)+1+" where symbol='"+c+"'");
			int i=ps.executeUpdate();
			if(i>0) 
				JOptionPane.showMessageDialog(null, "Voted Sucessfully");
		}
		catch(Exception e3) {e3.printStackTrace();}
	}
}
