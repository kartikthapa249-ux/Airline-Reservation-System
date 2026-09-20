<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Passenger</title>
</head>
<body>
    <h2>Add Passenger</h2>
    <form action="Addpassenger.jsp" method="post">
        <table>
            <tr>
                <td>Name:</td>
                <td><input type="text" name="name" required /></td>
            </tr>
            <tr>
                <td>Contact:</td>
                <td><input type="text" name="contact" required /></td>
            </tr>
            <tr>
                <td>Email ID:</td>
                <td><input type="email" name="email_id" required /></td>
            </tr>
            <tr>
                <td>Password:</td>
                <td><input type="password" name="password" required /></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="Add Passenger" /></td>
            </tr>
        </table>
    </form>
</body>
</html>
