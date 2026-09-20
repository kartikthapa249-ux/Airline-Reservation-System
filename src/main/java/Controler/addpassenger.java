package Controler;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.Passenger_daoimpl;
import Entitites.Passenger_entites;

@WebServlet("/Addpassenger")
public class addpassenger extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        int contact = Integer.parseInt(request.getParameter("contact"));
        String email_id = request.getParameter("email_id");
        String password = request.getParameter("password");

        Passenger_entites passenger = new Passenger_entites(name, contact, email_id, password);
        Passenger_daoimpl dao = new Passenger_daoimpl();
        String message;
        try {
            dao.addPassenger(passenger);
            message = "Passenger added successfully";
        } catch (Exception e) {
            message = "Failed to add passenger: " + e.getMessage();
        }
        response.sendRedirect("index.jsp?message=" + message);
    }
}
