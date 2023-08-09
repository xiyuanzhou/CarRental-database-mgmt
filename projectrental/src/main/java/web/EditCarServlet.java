package web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CarDAO;
import model.Cars;

/**
 * Servlet implementation class EditCarServlet
 */
@WebServlet("/EditCarServlet")
public class EditCarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditCarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	    int carID = Integer.parseInt(request.getParameter("carID"));
	    
	    // Retrieve car details from the database using carID
	    CarDAO carDAO = new CarDAO();
	    Cars car = carDAO.getCarID(carID);
	    
	    request.setAttribute("car", car); // Set car object as an attribute
	    request.getRequestDispatcher("edit_car.jsp").forward(request, response);
	    
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
	    int carID = Integer.parseInt(request.getParameter("carID"));
	    
	    String updatedMake = request.getParameter("make");
	    String updatedModel = request.getParameter("model");
	    int updatedYears = Integer.parseInt(request.getParameter("years"));
	    String updatedColor = request.getParameter("color");
	    int updatedNumofdoor = Integer.parseInt(request.getParameter("numberOfDoors"));
	    String updatedtransmissionType = request.getParameter("transmissionType");
	    String updatedfuelType = request.getParameter("fuelType");
	    String updatedgpsCheck = request.getParameter("gpsCheck");
	    
	    // Update car details in the database using carID and updated attributes
	    CarDAO carDAO = new CarDAO();
	    try {
			carDAO.updateCarDetails(carID, updatedMake, updatedModel, updatedYears, updatedColor, updatedNumofdoor, updatedtransmissionType, updatedfuelType, updatedgpsCheck);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    response.sendRedirect("CarServlet");
		
	}

}
