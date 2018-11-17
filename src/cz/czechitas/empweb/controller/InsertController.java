package cz.czechitas.empweb.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cz.czechitas.empweb.bean.Employee;
import cz.czechitas.empweb.bean.EmployeeList;
import cz.czechitas.empweb.dao.FileDAO;
import cz.czechitas.empweb.dao.JdbsDao;
import cz.czechitas.empweb.dao.userDAO;

public class InsertController {
	private userDAO fileDao= new JdbsDao ();
public void handle (HttpServletRequest request, HttpServletResponse response) {
	String name = request.getParameter("name"); String surname = request.getParameter("surname");
	Employee employee = new Employee ();
	employee.setSurname(surname);
	employee.setName(name);
	employee.setId(1);
	employee.setStatus(true);
	
	fileDao.save(employee);


	request.setAttribute("emplist",fileDao.load());
	
	
	
	System.out.println("InsertController" + name + surname);
}

}
