package cz.czechitas.empweb.dao;

import cz.czechitas.empweb.bean.Employee;
import cz.czechitas.empweb.bean.EmployeeList;

public interface userDAO {

	void save(Employee employee);

	EmployeeList load();

}