package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import Entitites.Search_entites;
import util.Flight_Dbutils;


public class Search_daoimpl implements Search_dao {

    private Connection getConnection() throws Exception {
        Class.forName(Flight_Dbutils.DRIVER);
        return DriverManager.getConnection(Flight_Dbutils.DB_URL, Flight_Dbutils.USERNAME, Flight_Dbutils.PASSWORD);
    }

    @Override
    public void createSchema() throws Exception {
        try (Connection con = getConnection(); Statement stmt = con.createStatement()) {
            String createSchemaSQL = "CREATE SCHEMA IF NOT EXISTS flight_schema";
            stmt.executeUpdate(createSchemaSQL);
            System.out.println("Schema created successfully.");
        }
    }

    @Override
    public void createTable() throws Exception {
        try (Connection con = getConnection(); Statement stmt = con.createStatement()) {
            String createTableSQL = "CREATE TABLE IF NOT EXISTS flight_schema.flight (" +
                    "Flight_id INT NOT NULL AUTO_INCREMENT," +
                    "Flight_name VARCHAR(50) NOT NULL," +
                    "Departure_date DATE NOT NULL," +
                    "Departure_time TIME NOT NULL," +
                    "Arrival_time TIME NOT NULL," +
                    "origin VARCHAR(50) NOT NULL," +
                    "Destination VARCHAR(50) NOT NULL," +
                    "Seats_available INT NOT NULL," +
                    "Seat_price INT NOT NULL," +
                    "PRIMARY KEY (Flight_id))";
            stmt.executeUpdate(createTableSQL);
            System.out.println("Table created successfully.");
        }
    }

    @Override
    public int addFlight(Search_entites flight) throws Exception {
        String query = "INSERT INTO flight_schema.flight (Flight_name, Departure_date, Departure_time, Arrival_time, origin, Destination, Seats_available, Seat_price) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection con = getConnection(); PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setString(1, flight.getFlight_name());
            pstmt.setDate(2, flight.getDeparture_date());
            pstmt.setTime(3, flight.getDeparture_time());
            pstmt.setTime(4, flight.getArrival_time());
            pstmt.setString(5, flight.getOrigin());
            pstmt.setString(6, flight.getDestination());
            pstmt.setInt(7, flight.getSeats_available());
            pstmt.setInt(8, flight.getSeat_price());
            return pstmt.executeUpdate();
        }
    }

    @Override
    public int updateFlight(Search_entites flight) throws Exception {
        String query = "UPDATE flight_schema.flight SET Flight_name = ?, Departure_date = ?, Departure_time = ?, Arrival_time = ?, origin = ?, Destination = ?, Seats_available = ?, Seat_price = ? WHERE Flight_id = ?";
        try (Connection con = getConnection(); PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setString(1, flight.getFlight_name());
            pstmt.setDate(2, flight.getDeparture_date());
            pstmt.setTime(3, flight.getDeparture_time());
            pstmt.setTime(4, flight.getArrival_time());
            pstmt.setString(5, flight.getOrigin());
            pstmt.setString(6, flight.getDestination());
            pstmt.setInt(7, flight.getSeats_available());
            pstmt.setInt(8, flight.getSeat_price());
            pstmt.setInt(9, flight.getFlight_id());
            return pstmt.executeUpdate();
        }
    }

    @Override
    public int removeFlight(int flightId) throws Exception {
        String query = "DELETE FROM flight_schema.flight WHERE Flight_id = ?";
        try (Connection con = getConnection(); PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setInt(1, flightId);
            return pstmt.executeUpdate();
        }
    }

    @Override
    public Search_entites fetchFlightDetails(int flightId) throws Exception {
        String query = "SELECT * FROM flight_schema.flight WHERE Flight_id = ?";
        try (Connection con = getConnection(); PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setInt(1, flightId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                String flight_name = rs.getString("Flight_name");
                Date departure_date = rs.getDate("Departure_date");
                Time departure_time = rs.getTime("Departure_time");
                Time arrival_time = rs.getTime("Arrival_time");
                String origin = rs.getString("origin");
                String destination = rs.getString("Destination");
                int seats_available = rs.getInt("Seats_available");
                int seat_price = rs.getInt("Seat_price");
                return new Search_entites(flightId, flight_name, departure_date, departure_time, arrival_time, origin, destination, seats_available, seat_price);
            }
            return null;
        }
    }

    @Override
    public List<Search_entites> getAllFlights() throws Exception {
        String query = "SELECT * FROM flight_schema.flight";
        try (Connection con = getConnection(); Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            List<Search_entites> flights = new ArrayList<>();
            while (rs.next()) {
                int flight_id = rs.getInt("Flight_id");
                String flight_name = rs.getString("Flight_name");
                Date departure_date = rs.getDate("Departure_date");
                Time departure_time = rs.getTime("Departure_time");
                Time arrival_time = rs.getTime("Arrival_time");
                String origin = rs.getString("origin");
                String destination = rs.getString("Destination");
                int seats_available = rs.getInt("Seats_available");
                int seat_price = rs.getInt("Seat_price");
                flights.add(new Search_entites(flight_id, flight_name, departure_date, departure_time, arrival_time, origin, destination, seats_available, seat_price));
            }
            return flights;
        }
    }
}
