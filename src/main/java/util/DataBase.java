package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBase {
	public static void main(String[] args) throws SQLException {
		Connection con=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/bugtracker","root","sierra");
			int user=56;
			String query="DELETE FROM `bugtracker`.`mantis_bug_tag_table` WHERE `mantis_bug_tag_table`.`bug_id` ="+ user; 
			PreparedStatement stmt=con.prepareStatement(query);
			
			stmt.execute();
			
		} catch (Exception ex) {

		}
		finally
		{
			con.close();
		}
	}
}
