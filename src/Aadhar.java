import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Aadhar {
	
	public static boolean check(String a,String p) {
		boolean status= false;
		try {
			Connection con=Connect.getcon();
			Statement st=con.createStatement();
		    ResultSet rs=st.executeQuery("select * from voters where username='"+a+"' and password='"+p+"'");
		    status=rs.next();
		}
		catch(Exception e) {e.printStackTrace();}
		return status;
	}
	public static Long getno(int no) {
		Long phone=(long) 0;
		try {
			Connection con=Connect.getcon();
			Statement st=con.createStatement();
		    ResultSet rs=st.executeQuery("select * from Vote where adhaar_no="+no);
		    if(rs.next())
		    	phone=rs.getLong("phone");
		}
		catch(Exception e) {e.printStackTrace();}
		return phone;
	}
	public static boolean admin(String n, String p) {
		boolean status= false;
		try {
			Connection con=Connect.getcon();
			Statement st=con.createStatement();
		    ResultSet rs=st.executeQuery("select * from admin where username='"+n+"' and password='"+p+"'");
		    status=rs.next();
		}
		catch(Exception e) {e.printStackTrace();}
		return status;

	}
}
