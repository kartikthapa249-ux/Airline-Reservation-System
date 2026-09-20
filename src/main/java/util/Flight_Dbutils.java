package util;

public class Flight_Dbutils {
	 public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	    public static final String DB_BASE = "jdbc:mysql://localhost:3306";
	    public static final String DB_URL = "jdbc:mysql://localhost:3306/munmun";
	    public static final String USERNAME = "root";
	    public static final String PASSWORD = "1234";

	    public static final String CREATE_SCHEMA = "CREATE SCHEMA munmun";
	    public static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS Search ("
	    		+"Flight_id INT NOT NULL AUTO_INCREMENT,"
	    		+"Flight_name VARCHAR(225) NOT NULL,"
	    		+"Departure_date DATE NOT NULL,"
	    		+"Departure_time TIME NOT NULL,"
	    		+"Arrival_time TIME NOT NULL,"
	    		+"origin VARCHAR(30) NOT NULL,"
	    		+"Destination VARCHAR(30) NOT NULL,"
	    		+"Seats_available INT ,"
	    		+"Price_seat INT NOT NULL,"
	    		+"PRIMARY KEY (Flight_id)";
	    
	    public static final String INSERT_Search = "INSERT INTO Search (Flight_name,Departure_date,Departure_time,Arrival_time,origin,Destination,Seats_available,Price_seat)  VALUES (?,?,?,?,?,?)";
	    public static final String UPDATE_Search = "UPDATE Search SET Departure_date = ?, Departure_time = ?, Arrival_time = ?, Seats_available = ?, Price_seat = ?, WHERE Flight_id = ?";
	    public static final String DELETE_Search = "DELETE FROM Search WHERE Flight_id = ?";
	    public static final String GET_Search = "SELECT * FROM Search WHERE Flight_id = ?";
	    public static final String GET_ALL_Search = "SELECT * FROM Search";
//	    public static final String AUTHENTICATE = "SELECT * FROM passenger WHERE username = ? AND password = ?";
		

}
