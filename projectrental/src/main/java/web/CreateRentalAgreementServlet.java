package web;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.RentalAgreementDAO;
import model.RentalAgreement;

/**
 * Servlet implementation class CreateRentalAgreementServlet
 */
@WebServlet("/CreateRentalAgreementServlet")
public class CreateRentalAgreementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateRentalAgreementServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String rentalStart = request.getParameter("rentalStart");
        String rentalEnd = request.getParameter("rentalEnd");
        BigDecimal totalCost = new BigDecimal(request.getParameter("totalCost"));
        String status = request.getParameter("status");
        int carID = Integer.parseInt(request.getParameter("carID"));
        int customerID = Integer.parseInt(request.getParameter("customerID"));
        int operatorID = Integer.parseInt(request.getParameter("operatorID"));
        
        RentalAgreement newRentalAgreement = new RentalAgreement();
        newRentalAgreement.setRentalStart(rentalStart);
        newRentalAgreement.setRentalEnd(rentalEnd);
        newRentalAgreement.setTotalCost(totalCost);
        newRentalAgreement.setStatus(status);
        newRentalAgreement.setCarID(carID);
        newRentalAgreement.setCustomerID(customerID);
        newRentalAgreement.setOperatorID(operatorID);
        
        RentalAgreementDAO rentalAgreementDAO = new RentalAgreementDAO();
        rentalAgreementDAO.addRentalAgreement(newRentalAgreement);

        response.sendRedirect("ReservationListServlet");
    }

}
