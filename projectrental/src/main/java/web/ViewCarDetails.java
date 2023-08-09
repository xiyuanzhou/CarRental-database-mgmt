package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CarDAO;
import dao.CustomerDAO;
import dao.EmployeeDAO;
import dao.MaintenanceRecordDAO;
import dao.RentalAgreementDAO;
import model.Cars;
import model.Customer;
import model.Employee;
import model.MaintenanceRecord;
import model.RentalAgreement;

/**
 * Servlet implementation class ViewCarDetails
 */
@WebServlet("/ViewCarDetails")
public class ViewCarDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewCarDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int carID = Integer.parseInt(request.getParameter("carID"));

        // TODO: Retrieve the car details using your CarDAO
        CarDAO carDAO = new CarDAO(); // Instantiate your CarDAO class
        Cars car = carDAO.getCarID(carID);

        // TODO: Retrieve rental agreements and maintenance records related to the car
        RentalAgreementDAO rentalAgreementDAO = new RentalAgreementDAO(); // Instantiate your RentalAgreementDAO class
        List<RentalAgreement> rentalAgreements = rentalAgreementDAO.getRentalAgreementsByCarID(carID);
        
        for (RentalAgreement rentalAgreement : rentalAgreements) {
            CustomerDAO customerDAO = new CustomerDAO(); // Instantiate your CustomerDAO class
            Customer customer = customerDAO.getCustomerByID(rentalAgreement.getCustomerID());
            rentalAgreement.setCustomer(customer);

            EmployeeDAO employeeDAO = new EmployeeDAO(); // Instantiate your EmployeeDAO class
            Employee employee = employeeDAO.getEmployeeByID(rentalAgreement.getOperatorID());
            rentalAgreement.setEmployee(employee);
        }

        MaintenanceRecordDAO maintenanceRecordDAO = new MaintenanceRecordDAO(); // Instantiate your MaintenanceRecordDAO class
        List<MaintenanceRecord> maintenanceRecords = maintenanceRecordDAO.getMaintenanceRecordsByCarID(carID);

        if (car != null) {
            request.setAttribute("car", car);
            request.setAttribute("rentalAgreements", rentalAgreements);
            request.setAttribute("maintenanceRecords", maintenanceRecords);
            
            RequestDispatcher dispatcher = request.getRequestDispatcher("view_details.jsp");
            dispatcher.forward(request, response);
        } else {
            // Handle car not found
            response.sendRedirect("CarListServlet");
        }

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
