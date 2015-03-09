package com.hotel.helper.contoller;

import java.sql.ResultSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hotel.common.servlet.JDBCTemplate;

public class User {
	
	public JDBCTemplate jdbcTemplate=new JDBCTemplate();

	public String veriftUser(HttpServletRequest req, HttpServletResponse resp) {
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		
		String nextPage="index.html";
		boolean flag=jdbcTemplate.verfiyUser(username, password);
        if(!flag){
        	nextPage="signin.jsp";
        	req.setAttribute("message", "invalid username or paasword");
        }
        
       return nextPage;
    		   
	}
	
	public String registerUser(HttpServletRequest req, HttpServletResponse resp) {
		String firstname=req.getParameter("firstname");
		String lastname=req.getParameter("lastname");
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		String confirmpassword=req.getParameter("confirmpassword");
		String streetaddress=req.getParameter("streetaddress");
		String city=req.getParameter("city");
		String zipcode=req.getParameter("zipcode");
		int zipcode1=Integer.parseInt(zipcode);
		String mobile=req.getParameter("mobile");
		int mobile1=Integer.parseInt(mobile);
		String username=req.getParameter("username");
				
				
		String state=req.getParameter("state");
		String aggrement=req.getParameter("aggrement");
		
		
		
		String nextPage="index.html";
		boolean flag=jdbcTemplate.registerUser( firstname,  lastname, email, password,
				  streetaddress, city, state, zipcode1, mobile1,username);
        
        System.out.println(flag);
       return nextPage;
    		   
	}
	

}
