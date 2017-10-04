package Register;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.sql.DriverManager;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




public class Signup extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			String name  = request.getParameter("t1");
			String address = request.getParameter("t2");
			try{  
				Class.forName("com.mysql.jdbc.Driver");  
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/abc","root","@*Alps20071995*@");    
				PreparedStatement stmt=con.prepareStatement("insert into information value(?,?)"); 
				stmt.setString(1, name);
				stmt.setString(2, address);
				stmt.executeUpdate();
				out.println("Registered");
			}catch(Exception e) {
				System.out.println(e);
			}
			
}

}
