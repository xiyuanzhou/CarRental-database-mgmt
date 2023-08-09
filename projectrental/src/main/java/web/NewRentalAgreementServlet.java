package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CarDAO;
import dao.CustomerDAO;
import dao.EmployeeDAO;
import model.Cars;
import model.Customer;
import model.Employee;

/**
 * Servlet implementation class NewRentalAgreementServlet
 */
@WebServlet("/NewRentalAgreementServlet")
public class NewRentalAgreementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewRentalAgreementServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        CarDAO carDAO = new CarDAO();
        List<Cars> availableCars = carDAO.selectAllCars();

        CustomerDAO customerDAO = new CustomerDAO();
        List<Customer> allCustomers = customerDAO.selectAllUsers();

        EmployeeDAO employeeDAO = new EmployeeDAO();
        List<Employee> allOperators = employeeDAO.getAllEmployees();

        request.setAttribute("availableCars", availableCars);
        request.setAttribute("allCustomers", allCustomers);
        request.setAttribute("allOperators", allOperators);

        request.getRequestDispatcher("NewRentalAgreement.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
