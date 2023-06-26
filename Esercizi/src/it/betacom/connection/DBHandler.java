package it.betacom.connection;


	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.SQLException;

	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.SQLException;

	public class DBHandler {
	    private static DBHandler instance;
	    private Connection connection;

	    private String connectionString;
	    private String username;
	    private String password;

	    private DBHandler() {
	        this.connectionString = "jdbc:mysql://localhost:3306/test";
	        this.username = "root";
	        this.password = "puffo2000";

	        try {
	            connection = DriverManager.getConnection(connectionString, username, password);
	            System.out.println("connessione avvenuta correttamente");
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    public static synchronized DBHandler getInstance() {
	        if (instance == null) {
	            instance = new DBHandler();
	        }
	        return instance;
	    }

	    public Connection getConnection() {
	        return connection;
	    }
	}



