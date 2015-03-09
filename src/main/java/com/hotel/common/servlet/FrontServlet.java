package com.hotel.common.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hotel.helper.contoller.Availability;
import com.hotel.helper.contoller.User;

public class FrontServlet extends HttpServlet {

	private User user;
	private Availability availability;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		user = new User();
		availability = new Availability();

		System.out.println("coming");
	}

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String url = request.getRequestURI();
		String root = "WEB-INF/pages/";
		String page = "index.html";
		if (url.endsWith("signin.do")) {
			page = "signin.jsp";
			page = root + page;
		} else if (url.endsWith("login.do")) {
			page = user.veriftUser(request, response);
			page = "/" + root + page;
		} else if (url.endsWith("signup.do")) {
			page = "signup.jsp";
			page = root + page;
		} else if (url.endsWith("register.do")) {
			page = user.registerUser(request, response);
			page = "/" + root + page;
		} else if (url.endsWith("reservation.do")) {
			page = "reservation.jsp";
			page = root + page;
		}
		else if (url.endsWith("availability.do")) {
			 page =availability.search(request, response);
			page = "/" + root + page;
		}
		System.out.println(url);
		request.getRequestDispatcher(page).forward(request, response);

	};

	@Override
	public void destroy() {
		super.destroy();
		user = null;
	}

}