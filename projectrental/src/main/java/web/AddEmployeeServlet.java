package web;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmployeeDAO;
import model.Employee;

/**
 * Servlet implementation class AddEmployeeServlet
 */
@WebServlet("/AddEmployeeServlet")
public class AddEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddEmployeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ename = request.getParameter("ename");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String roles = request.getParameter("roles");
        BigDecimal salary = new BigDecimal(request.getParameter("salary"));

        Employee newEmployee = new Employee();
        newEmployee.setEname(ename);
        newEmployee.setAddress(address);
        newEmployee.setPhone(phone);
        newEmployee.setEmail(email);
        newEmployee.setRoles(roles);
        newEmployee.setSalary(salary);

        EmployeeDAO employeeDAO = new EmployeeDAO();
        employeeDAO.addEmployee(newEmployee);

        response.sendRedirect("EmployeeListServlet");
    }

}
