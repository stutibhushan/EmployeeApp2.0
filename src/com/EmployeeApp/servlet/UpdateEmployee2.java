package com.EmployeeApp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.EmployeeApp.dao.DepartmentDAO;
import com.EmployeeApp.dao.EmployeeDAO;
import com.EmployeeApp.model.Employee;
import com.EmployeeApp.model.EmployeeUpdatePOJO;
import com.google.gson.Gson;


@WebServlet("/UpdateEmployee2")
public class UpdateEmployee2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd");   
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("in update employee 2");
		response.setContentType("application/json");
		System.out.println("employee json --------->>>>>>"+request.getHeader("employeeJson"));
		String employeeJsonInString= request.getHeader("employeeJson");
		Gson gson= new Gson();
		EmployeeUpdatePOJO  employee2 = gson.fromJson(employeeJsonInString, EmployeeUpdatePOJO.class);
		System.out.println("employee pojo --------->>>>>>"+employee2);
		
		try{
			
		PrintWriter out= response.getWriter();
		
		Employee employee=new Employee(employee2.getName(),employee2.getDescription(),employee2.getAddress(),employee2.getCity(),employee2.getState(),employee2.getCountry(),employee2.getSalary(), formatter.parse(employee2.getStartDate()), formatter.parse(employee2.getEndDate()));
		ArrayList<Integer> departmentList= employee2.getDepartmentList();
		int type=employee2.getType();
		int id=employee2.getId();
		 EmployeeDAO employeeDAO=new EmployeeDAO();
		 int status=employeeDAO.updateEmployee(employee, id, type);
	       System.out.println("6");
	      // int id=employeeDAO.getCurrentEmployeeId(name);
	       
	       DepartmentDAO departmentDAO = new DepartmentDAO();
	       System.out.println("9");
	       departmentDAO.updateEmployeeDepartmentDetail(departmentList,id);
	       System.out.println("10");
	       
	       
	       //response.setContentType("application/json");
	       
	       
	      if(status!=0)
	      {
	        out.println("{");
	        out.println("\"success\": \"true\",");
	       // out.println("\"employeeId\":"+id+",");
	        out.println("\"message\": \"Employee Updated Succesfully\"");
	        out.println("}");
	      }
	      else
	      {
	    	  out.println("{");
		        out.println("\"success\": \"false\",");
		        out.println("\"message\": \"Unable to update..\"");
		        out.println("}");
	      
	    	  
	       }
	       
		 
		}
		
		catch(Exception e)
		{
			
		}
	}

}
