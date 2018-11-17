package cz.czechitas.empweb.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cz.czechitas.empweb.dao.FileDAO;
import cz.czechitas.empweb.dao.JdbsDao;
import cz.czechitas.empweb.dao.userDAO;

public class ViewController {
	private userDAO fileDao= new JdbsDao ();
	
	public void handle (HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("emplist",fileDao.load());
}
}
