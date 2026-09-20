package util;

public class Passenger_Dbutils {
    public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    public static final String DB_BASE = "jdbc:mysql://localhost:3306";
    public static final String DB_URL = "jdbc:mysql://localhost:3306/Munmun";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "1234";

    public static final String CREATE_SCHEMA = "CREATE SCHEMA IF NOT EXISTS Munmun";
    public static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS passenger ("
            + "id INT NOT NULL AUTO_INCREMENT, "
            + "name VARCHAR(30) NOT NULL, "
            + "contact INT NOT NULL, "
            + "email_id VARCHAR(100) NOT NULL, "
            + "password VARCHAR(100) NOT NULL, "
            + "PRIMARY KEY (id))";

    public static final String INSERT_PASSENGER = "INSERT INTO passenger (name, contact, email_id, password) VALUES (?, ?, ?, ?)";
    public static final String UPDATE_PASSENGER = "UPDATE passenger SET name = ?, contact = ?, email_id = ?, password = ? WHERE id = ?";
    public static final String DELETE_PASSENGER = "DELETE FROM passenger WHERE id = ?";
    public static final String GET_PASSENGER = "SELECT * FROM passenger WHERE id = ?";
    public static final String GET_ALL_PASSENGERS = "SELECT * FROM passenger";
    public static final String AUTHENTICATE = "SELECT * FROM passenger WHERE username = ? AND password = ?";
}
