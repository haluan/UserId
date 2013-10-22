package com.haluan.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.haluan.bean.UserBean;
import com.haluan.dao.UserDao;

/**
 * Servlet implementation class USerController
 */
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String INSERT = "/user.jsp";
	private static String EDIT = "/edit.jsp";
	private static String USERS = "/listUser.jsp";
	private UserDao dao;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserController() {
        super();
        // TODO Auto-generated constructor stub
        dao = new UserDao();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String redirect="";
		String uid = request.getParameter("userId");
		String action = request.getParameter("action");
		if(!((uid)==null) && "insert".equals(action)){
			int id = Integer.parseInt(uid);
			UserBean user = new UserBean();
			 user.setId(id);
			 user.setfName(request.getParameter("fName"));
			 user.setlName(request.getParameter("lName"));
			 dao.addUser(user);
			 redirect=USERS;
			 request.setAttribute("users", dao.getAllUsers());
			 
		}else if("delete".equals(action)){
			String userId = request.getParameter("userId");
			int uId = Integer.parseInt(userId);
			dao.removeUser(uId);
			redirect=USERS;
			request.setAttribute("users", dao.getAllUsers());
			
		}else if("editform".equals(action)){
			redirect=EDIT;
		}else if("edit".equals(action)){
			String userId=request.getParameter("userId");
			int uId=Integer.parseInt(userId);
			UserBean user = new UserBean();
			user.setId(uId);
			user.setfName(request.getParameter("fName"));
			user.setlName(request.getParameter("lName"));
			dao.editUser(user);
			request.setAttribute("users", user);
			redirect=USERS;
		}else if ("listUser".equals(action)){
			redirect=USERS;
			request.setAttribute("users", dao.getAllUsers());
		}else{
			redirect=INSERT;
		}
		RequestDispatcher rd = request.getRequestDispatcher(redirect);
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String redirect="";
		String uid = request.getParameter("userId");
		String action = request.getParameter("action");
		int id = Integer.parseInt(uid);
		UserBean user = new UserBean();
		 user.setId(id);
		 user.setfName(request.getParameter("fName"));
		 user.setlName(request.getParameter("lName"));
		 dao.addUser(user);
		 redirect=USERS;
		 request.setAttribute("users", dao.getAllUsers());
		 RequestDispatcher rd = request.getRequestDispatcher(redirect);
			rd.forward(request, response);
	}

}
