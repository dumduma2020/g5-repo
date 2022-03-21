import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.petscare.dao.utilityDB;

public class test_connection {

	public static void main(String[] args) {
		/*String username = "root";
		String password = "Root";
		String connectionString = "jdbc:mysql://localhost:3306/project?useSSL=false&serverTimezone=UTC&useLegacyDatetimeCode=false";
		
		
		
		try (Connection conn = DriverManager.getConnection(connectionString, username, password)){
			Class.forName("com.mysql.jdbc.Driver");
			if (conn != null) {
				System.out.println("Successfully connected");
			}
			else {
				System.out.println("Failed Connection");
			}
			
		} catch (SQLException e) {
			System.err.format("SQL State %s\n%s", e.getSQLState(), e.getMessage());
		}catch (Exception e) {
			e.printStackTrace();
		}
	}*/
		
		utilityDB db = new utilityDB();
		if(db.getConnection() != null) {
			
			System.out.print("connection is success");
			
		}else {
			System.out.print("failed to connect");
		}
		
	}

}
