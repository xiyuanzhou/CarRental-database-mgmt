package web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CarDAO;
import model.Cars;

/**
 * Servlet implementation class AddCarServlet
 */
@WebServlet("/AddCarServlet")
public class AddCarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("add_car_form.jsp");
        dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve form data
        String make = request.getParameter("make");
        String model = request.getParameter("model");
        int years = Integer.parseInt(request.getParameter("years"));
        String color = request.getParameter("color");
        int numberOfDoors = Integer.parseInt(request.getParameter("numberOfDoors"));
        String transmissionType = request.getParameter("transmissionType");
        String fuelType = request.getParameter("fuelType");
        String gpsCheck = request.getParameter("gpsCheck");

        // Create a new Car object with the retrieved data
        Cars newCar = new Cars();
        newCar.setMake(make);
        newCar.setModel(model);
        newCar.setYears(years);
        newCar.setColor(color);
        newCar.setNumberOfDoors(numberOfDoors);
        newCar.setTransmissionType(transmissionType);
        newCar.setFuelType(fuelType);
        newCar.setGpsCheck(gpsCheck);

        // Add the new car to the database using your CarDAO
        CarDAO carDAO = new CarDAO();
        carDAO.addCar(newCar);

        // Redirect back to the car list page
        response.sendRedirect("CarServlet");
	}

}
