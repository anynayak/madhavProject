
package com.hotel.helper.contoller;

import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hotel.common.servlet.JDBCTemplate;
public class Availability {
	public JDBCTemplate jdbcTemplate=new JDBCTemplate();
	
	public String search(HttpServletRequest req, HttpServletResponse resp) {	
		
	String check_in_date=req.getParameter("checkInDate");
	String check_out_date=req.getParameter("check_out_date");

	
System.out.println(check_in_date);
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
	String checkIn=null;
	String checkOut=null;
	try {
		 checkIn = formatter.format(formatter.parse(check_in_date));
		 checkOut = formatter.format(formatter.parse(check_out_date));

	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   String category=req.getParameter("category");
	String type=req.getParameter("type");

	int category1=Integer.parseInt(category);
	
	int type1=Integer.parseInt(type);
	
	String adults=req.getParameter("adults");
	int adults1=Integer.parseInt(adults);
	String children=req.getParameter("children");
	int children1=Integer.parseInt(children);
	String nextPage="reservation.jsp";
	List list=jdbcTemplate.availability(checkIn,category1, type1);
    
	req.setAttribute("hotelList", list);
	System.out.println(list);
   return nextPage;

	}
}