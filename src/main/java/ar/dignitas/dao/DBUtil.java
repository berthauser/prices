package ar.dignitas.dao;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class DBUtil {
	
	public static Connection conn = null;
	// String de conexión

	public static Boolean dbConnect() throws SQLException {
		try {

			Properties props = new Properties();

			props.setProperty("user", "SYSDBA");
//			props.setProperty("password", "24s01een");
			props.setProperty("password", "masterkey");
			props.setProperty("encoding", "UTF8");

			Class.forName("org.firebirdsql.jdbc.FBDriver");
//			String databaseURL = "jdbc:firebirdsql://localhost:3050/G:\\Sistemas\\data\\buldra.fdb";
//			String databaseURL = "jdbc:firebirdsql://localhost:3050/G:\\Sistemas\\visus\\data\\buldra.fdb";
			String databaseURL = "jdbc:firebirdsql://192.168.0.200:3050//opt/db/buldra.fdb";

			conn = DriverManager.getConnection(databaseURL, props);

			DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
			System.out.println("Driver name: " + dm.getDriverName());
			System.out.println("Driver version: " + dm.getDriverVersion());
			System.out.println("Product name: " + dm.getDatabaseProductName());
			System.out.println("Product version: " + dm.getDatabaseProductVersion());
			return true;
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println("Fallo de Conexión! Revisar la consola" + e);
			return false;
		}
	}

	public static void dbDisconnect() throws SQLException {
		try {
			if (conn != null && !conn.isClosed()) {
				conn.close();
			}		
		} catch (Exception e) {
			throw e;
		}
	}

	public static ResultSet dbExecuteQuery(String queryStmt) throws SQLException, ClassNotFoundException {
		Statement stmt = null;
		ResultSet resultSet = null;
		try {
			stmt = conn.createStatement();
			resultSet = stmt.executeQuery(queryStmt);
		} catch (SQLException e) {
			Alert alert2 = new Alert(AlertType.ERROR);
			alert2.setTitle("Error de SQL");
			alert2.setContentText("Problema en la ejecución del Query " + e);
			e.printStackTrace();
			alert2.showAndWait();
			throw e;
		}
		return resultSet;
	}

	public static int dbExecuteSQL(String queryStmt) throws SQLException, ClassNotFoundException {
		Statement stmt = conn.createStatement();
		ResultSet valorRetorno = stmt.executeQuery(queryStmt);
		int count = 0;

		try {
			if(valorRetorno.next()) {
				count = valorRetorno.getInt(1);
			}
		} catch (SQLException e) {
			Alert alert2 = new Alert(AlertType.ERROR);
			alert2.setTitle("Error de SQL");
			alert2.setContentText("Problema en la ejecución del Query " + e);
			e.printStackTrace();
			alert2.showAndWait();
			throw e;
		}
		return count;
	}

	public static Double executeSQL(String queryStmt) throws SQLException, ClassNotFoundException {
		Statement stmt = conn.createStatement();
		ResultSet valorRetorno = stmt.executeQuery(queryStmt);
		Double count = 0.0;

		try {
			if(valorRetorno.next()) {
				count = valorRetorno.getDouble(1);
			}
		} catch (SQLException e) {
			Alert alert2 = new Alert(AlertType.ERROR);
			alert2.setTitle("Error de SQL");
			alert2.setContentText("Problema en la ejecución del Query " + e);
			e.printStackTrace();
			alert2.showAndWait();
			throw e;
		}
		return count;
	}

	public static void dbExecuteUpdate(String sqlStmt) throws SQLException, ClassNotFoundException {
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
			stmt.executeUpdate(sqlStmt);
		} catch (SQLException e) {
			Alert alert2 = new Alert(AlertType.ERROR);
			alert2.setTitle("Error de SQL");
			alert2.setContentText("Problema con operación de Update/Insert/Delete " + e);
			e.printStackTrace();
			alert2.showAndWait();
			throw e;
		}
	}

}
