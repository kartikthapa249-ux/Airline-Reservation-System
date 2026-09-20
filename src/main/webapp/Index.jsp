<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
</head>
<body>
    <h1>Passenger Management System</h1>
    <%
        String message = request.getParameter("message");
    %>
    <table style="font-size: 20px">
        <tr>
            <td>Step 1: <a href="createSchema.jsp">Create Schema</a></td>
            <td><%= message != null && message.contains("Schema") ? message : "" %></td>
        </tr>
        <tr>
            <td>Step 2: <a href="createTable.jsp">Create Table</a></td>
            <td><%= message != null && message.contains("Table") ? message : "" %></td>
        </tr>
        <tr>
            <td>Step 3: <a href="Addpassenger.jsp">Add Passenger</a></td>
            <td><%= message != null && message.contains("Passenger") ? message : "" %></td>
        </tr>
        <tr>
            <td>Step 4: <a href="passengerlist.jsp">View Passenger List</a></td>
            <td></td>
        </tr>
    </table>
</body>
</html>
