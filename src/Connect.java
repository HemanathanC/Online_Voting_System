import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect{
	
	public static Connection getcon() throws ClassNotFoundException, SQLException {
		
		Connection con=null;
		
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/voting","root","");
		
		return con;
	}
}
