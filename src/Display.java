import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Display {

	public static ResultSet voters() throws ClassNotFoundException, SQLException {
		
		Connection con=Connect.getcon();
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("Select * from voters");
		return rs;
	}

	public static ResultSet candidates() throws ClassNotFoundException, SQLException {
	
		Connection con=Connect.getcon();
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("Select * from candidates");
		return rs;
	}


	public static ResultSet result() throws SQLException, ClassNotFoundException {
		
		Connection con=Connect.getcon();
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("select * from candidates order by count desc");
		return rs;
	}

	public static ResultSet voter(String a) throws ClassNotFoundException, SQLException {
		
		Connection con=Connect.getcon();
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("Select * from voters where Aadhar='"+a);
		return rs;
	}

	public static boolean voted(int v_id) throws ClassNotFoundException, SQLException {
		boolean status=false;
		Connection con=Connect.getcon();
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("select * from voters where v_id="+v_id);
		rs.next();
		if(rs.getString("v_status").equals("yes")) {
			status=true;
		}
		return status;
	}

	public static int getcount(String c) throws ClassNotFoundException, SQLException {

		Connection con=Connect.getcon();
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("select * from candidates where symbol='"+c+"'");
		if(rs.next())
			return rs.getInt("count");
		return 0; 
	}
}
