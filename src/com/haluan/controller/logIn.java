package com.haluan.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.haluan.bean.UserBean;
import com.haluan.dbconnection.ConnectionProvider;

/**
 * Servlet implementation class logIn
 */
public class logIn extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection conn;
	
	HttpSession session = null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public logIn() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		if("logout".equals(action)){
			session.invalidate();
			response.sendRedirect("index.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		session=request.getSession(true);
		String firstName=request.getParameter("firstName");
		String lastName= request.getParameter("lastName");
		try {
        String sql = "SELECT * FROM users";
        Connection conn=ConnectionProvider.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            if(rs.getString("firstName").equals(firstName)&&rs.getString("lastName").equals(lastName)){
            	session.setAttribute("firstName", firstName);
            	session.setAttribute("lastName", lastName);
            	response.sendRedirect("listUser.jsp");
            }
            else{
            	response.sendRedirect("");
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
		
	}

}
