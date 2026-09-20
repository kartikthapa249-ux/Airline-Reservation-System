<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ page import="Entitites.Passenger_entites" %>
<%@ page import="Dao.Passenger_daoimpl" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Passenger List</title>
</head>
<body>
    <h2>Passenger List</h2>
    <%
        Passenger_daoimpl dao = new Passenger_daoimpl();
        List<Passenger_entites> passengers = null;
        try {
            passengers = dao.getAllPassengers();
        } catch (Exception e) {
            out.println("Failed to retrieve passengers: " + e.getMessage());
        }
    %>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Contact</th>
            <th>Email ID</th>
            <th>Password</th>
        </tr>
        <%
            if (passengers != null) {
                for (Passenger_entites passenger : passengers) {
        %>
                    <tr>
                        <td><%= passenger.getId() %></td>
                        <td><%= passenger.getName() %></td>
                        <td><%= passenger.getContact() %></td>
                        <td><%= passenger.getEmail_id() %></td>
                        <td><%= passenger.getPassword() %></td>
                    </tr>
        <%
                }
            }
        %>
    </table>
</body>
</html>
