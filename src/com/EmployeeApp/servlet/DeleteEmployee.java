package com.EmployeeApp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.EmployeeApp.dao.EmployeeDAO;

/**
 * Servlet implementation class DeleteEmployee
 */
@WebServlet("/DeleteEmployee")
public class DeleteEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
        private int employeeId;
        private int status=0;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try(PrintWriter out= response.getWriter())
		{
			employeeId= Integer.parseInt(request.getParameter("employeeId"));
			
			EmployeeDAO dao= new EmployeeDAO();
			
			status= dao.deleteEmployee(employeeId);
			
			 if(status!=0)
		      {
		        out.println("{");
		        out.println("\"success\": \"true\",");
		        //out.println("\"employeeId\":"+id+",");
		        out.println("\"message\": \"Employee Deleted Successfully\"");
		        out.println("}");
		      }
		      else
		      {
		    	  out.println("{");
			        out.println("\"success\": \"false\",");
			        out.println("\"message\": \"Unable to delete..\"");
			        out.println("}");
		      
		    	  
		       }
		       
		       
		}
		
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}

}
