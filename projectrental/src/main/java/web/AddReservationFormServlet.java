package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.RentalAgreementDAO;
import model.RentalAgreement;

import dao.CustomerDAO;
import model.Customer;

/**
 * Servlet implementation class AddReservationFormServlet
 */
@WebServlet("/AddReservationFormServlet")
public class AddReservationFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddReservationFormServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve the available rental agreements from the database
        RentalAgreementDAO rentalAgreementDAO = new RentalAgreementDAO();
        List<RentalAgreement> availableRentalAgreements = rentalAgreementDAO.getAllrentalAgreements1();
        
        CustomerDAO customerDAO = new CustomerDAO();
        List<Customer> customers = customerDAO.selectAllUsers();


        // Set the available rental agreements as a request attribute
        request.setAttribute("availableRentalAgreements", availableRentalAgreements);
//        request.setAttribute("customers", customers);

        // Forward the request to the add_reservation_form.jsp
        RequestDispatcher dispatcher = request.getRequestDispatcher("add_reservation_form.jsp");
        dispatcher.forward(request, response);
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
