package web;


import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CarDAO;
import dao.EmployeeDAO;
import model.Employee;

@WebServlet("/EditEmployeeServlet")
public class EditEmployeeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int employeeID = Integer.parseInt(request.getParameter("ID"));

        EmployeeDAO employeeDAO = new EmployeeDAO();
        Employee em1 = employeeDAO.getEmployeeID(employeeID);
        
	    request.setAttribute("employee", em1); // Set car object as an attribute
	    request.getRequestDispatcher("edit_employee.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        doGet(request, response);
    	
        int employeeID = Integer.parseInt(request.getParameter("ID"));
        String ename = request.getParameter("ename");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String roles = request.getParameter("roles");
        BigDecimal salary = new BigDecimal(request.getParameter("salary"));

                
        EmployeeDAO employeeDAO = new EmployeeDAO();

	    try {
	    	employeeDAO.updateEmployeeDetails(employeeID, ename, address, phone, email, roles, salary);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
        // Redirect back to the employee list after updating
        response.sendRedirect("EmployeeListServlet");
        
        
    }
}
