package service.dbInit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseService implements DatabaseServer {
	private static Connection connection;
	private static Statement stmt;
	private static final String URL = "jdbc:sqlite:PassKeep.db";
	
	public static Connection getConnection() {
		return connection;
	}
	
	public static Statement getStatement() {
		return stmt;
	}
	
	@Override
	public boolean connectToDatabase() {
		try {
			Class.forName("org.sqlite.JDBC");
			connection = DriverManager.getConnection(URL);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean createAllTables() {
		try {
			stmt = connection.createStatement();
			stmt.execute(DatabaseSchemaServer.CREATE_USER_TAB_QUERY);
			stmt.execute(DatabaseSchemaServer.CREATE_PASSWORD_TAB_QUERY);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean closeAllConnections() {
		try {
			if (connection != null)
				connection.close();
			if (stmt != null)
				stmt.close();

			System.out.println("Connection closed!");
			return true;
		} catch (Exception e) {
			System.out.println("Failed to close connection!");
			e.printStackTrace();
		}
		return false;
	}

}
