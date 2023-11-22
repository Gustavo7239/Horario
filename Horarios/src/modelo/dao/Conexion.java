package modelo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

	    private static Connection jdbcConnection=null;
	    private static final String URL="jdbc:mysql://localhost:3306/horarios";
	    private static final String USER= "root";
	    private static final String PWD= "";                   
	    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";	 
	                   
	    public Conexion() {
	    	try {
				Class.forName(DRIVER);
				jdbcConnection = DriverManager.getConnection(URL, USER, PWD);

			} catch (ClassNotFoundException | SQLException e) {				
				e.printStackTrace();
			}	    	
	    }
		public static Connection getJdbcConnection() {
			return jdbcConnection;
		}
		public static void setJdbcConnection(Connection jdbcConnection) {
			Conexion.jdbcConnection = jdbcConnection;
		}
}
