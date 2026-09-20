package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Entitites.Passenger_entites;
import util.Passenger_Dbutils;

public class Passenger_daoimpl implements Passenger_dao {

    private Connection getConnection() throws Exception {
        Class.forName(Passenger_Dbutils.DRIVER);
        return DriverManager.getConnection(Passenger_Dbutils.DB_URL, Passenger_Dbutils.USERNAME, Passenger_Dbutils.PASSWORD);
    }

    @Override
    public void createSchema() throws Exception {
        try (Connection con = getConnection(); Statement stmt = con.createStatement()) {
            int result = stmt.executeUpdate(Passenger_Dbutils.CREATE_SCHEMA);
            System.out.println("\nResult: " + result);
        }
    }

    @Override
    public void createTable() throws Exception {
        try (Connection con = getConnection(); Statement stmt = con.createStatement()) {
            int result = stmt.executeUpdate(Passenger_Dbutils.CREATE_TABLE);
            System.out.println("\nResult: " + result);
        }
    }

    @Override
    public int addPassenger(Passenger_entites passenger) throws Exception {
        String query = Passenger_Dbutils.INSERT_PASSENGER;
        try (Connection con = getConnection(); PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setString(1, passenger.getName());
            pstmt.setInt(2, passenger.getContact());
            pstmt.setString(3, passenger.getEmail_id());
            pstmt.setString(4, passenger.getPassword());
            return pstmt.executeUpdate();
        }
    }

    @Override
    public int updatePassenger(Passenger_entites passenger) throws Exception {
        String query = Passenger_Dbutils.UPDATE_PASSENGER; // Make sure to define this query in Passenger_Dbutils
        try (Connection con = getConnection(); PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setString(1, passenger.getName());
            pstmt.setInt(2, passenger.getContact());
            pstmt.setString(3, passenger.getEmail_id());
            pstmt.setString(4, passenger.getPassword());
            pstmt.setInt(5, passenger.getId());
            return pstmt.executeUpdate();
        }
    }

    @Override
    public int removePassenger(int passengerId) throws Exception {
        String query = Passenger_Dbutils.DELETE_PASSENGER; // Make sure to define this query in Passenger_Dbutils
        try (Connection con = getConnection(); PreparedStatement pStmt = con.prepareStatement(query)) {
            pStmt.setInt(1, passengerId);
            return pStmt.executeUpdate();
        }
    }

    @Override
    public Passenger_entites fetchPassengerDetails(int passengerId) throws Exception {
        String query = Passenger_Dbutils.GET_PASSENGER; // Make sure to define this query in Passenger_Dbutils
        try (Connection con = getConnection(); PreparedStatement pStmt = con.prepareStatement(query)) {
            pStmt.setInt(1, passengerId);
            ResultSet rSet = pStmt.executeQuery();
            if (rSet.next()) {
                String name = rSet.getString("name");
                int contact = rSet.getInt("contact");
                String email_id = rSet.getString("email_id");
                String password = rSet.getString("password");
                return new Passenger_entites(passengerId, name, contact, email_id, password);
            }
            return null;
        }
    }

    @Override
    public List<Passenger_entites> getAllPassengers() throws Exception {
        String query = Passenger_Dbutils.GET_ALL_PASSENGERS; // Make sure to define this query in Passenger_Dbutils
        try (Connection con = getConnection(); Statement stmt = con.createStatement(); ResultSet rSet = stmt.executeQuery(query)) {
            List<Passenger_entites> passengers = new ArrayList<>();
            while (rSet.next()) {
                int id = rSet.getInt("id");
                String name = rSet.getString("name");
                int contact = rSet.getInt("contact");
                String email_id = rSet.getString("email_id");
                String password = rSet.getString("password");
                passengers.add(new Passenger_entites(id, name, contact, email_id, password));
            }
            return passengers;
        }
    }
}
