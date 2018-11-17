package cz.czechitas.empweb.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cz.czechitas.empweb.dao.FileDAO;
import cz.czechitas.empweb.dao.userDAO;

public class DeactiveController {
	private userDAO fileDao= new FileDAO ();
	public void handle (HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("emplist",fileDao.load());
		System.out.println("DeactiveController");
	}
}
