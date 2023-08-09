package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ReservationDAO;
import model.Reservation;

/**
 * Servlet implementation class CreateReservationServlet
 */
@WebServlet("/CreateReservationServlet")
public class CreateReservationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateReservationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Get form data
        int customerID = Integer.parseInt(request.getParameter("customerID"));
        String pickupLocation = request.getParameter("pickupLocation");
        String returnLocation = request.getParameter("returnLocation");
        String pickupDate = request.getParameter("pickupDate");
        String returnDate = request.getParameter("returnDate");
        String carTypePreference = request.getParameter("carTypePreference");
        String additionalRequests = request.getParameter("additionalRequests");

        Reservation reservation = new Reservation();
        reservation.setCustomerID(customerID);
        reservation.setPickupLocation(pickupLocation);
        reservation.setReturnLocation(returnLocation);
        reservation.setPickupDate(pickupDate);
        reservation.setReturnDate(returnDate);
        reservation.setCarTypePreference(carTypePreference);
        reservation.setAdditionalRequests(additionalRequests);

        ReservationDAO reservationDAO = new ReservationDAO();
        reservationDAO.addReservation(reservation);

        response.sendRedirect("ReservationListServlet");
    }

}
