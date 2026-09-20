package Controler;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.Passenger_daoimpl;
import Entitites.Passenger_entites;

@WebServlet("/ListPassengerServlet")
public class passengerlistservlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Passenger_daoimpl dao = new Passenger_daoimpl();
        List<Passenger_entites> passengers = null;
        try {
            passengers = dao.getAllPassengers();
        } catch (Exception e) {
            request.setAttribute("errorMessage", "Failed to retrieve passengers: " + e.getMessage());
        }
        request.setAttribute("passengers", passengers);
        request.getRequestDispatcher("listPassengers.jsp").forward(request, response);
    }
}
