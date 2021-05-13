package com.customertracker.testDBconnection;

import java.io.IOException;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestDBConnection
 */
@WebServlet("/TestDBConnection")
public class TestDBConnection extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// setup connection variables
		var user = "springstudent";
		var pass = "springstudent";

		var jdbcUrl = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false&serverTimezone=UTC";
		var driver = "com.mysql.cj.jdbc.Driver";

		// get connection to database
		try {
			var out = response.getWriter();

			out.println("Connecting to database: " + jdbcUrl);

			Class.forName(driver);

			var myConn = DriverManager.getConnection(jdbcUrl, user, pass);
			out.println("SUCCESS!!!");

			myConn.close();

		} catch (Exception exc) {
			exc.printStackTrace();
			throw new ServletException(exc);
		}

	}
}