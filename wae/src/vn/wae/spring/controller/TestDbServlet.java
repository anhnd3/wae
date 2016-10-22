package vn.wae.spring.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestDbServlet
 */
@WebServlet("/test-db-servlet")
public class TestDbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String user = "wae";
		String password = "123qwe!@#";
		
		String jdbcUrl = "jdbc:mysql://localhost:3306/wae?useSSL=false";
		String driver = "com.mysql.jdbc.Driver";
		try{
			PrintWriter writer = response.getWriter();
			writer.println("Connecting to database: " + jdbcUrl);
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(jdbcUrl, user, password);
			writer.println("SUCCESS!");
			conn.close();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
}
