package cz.czechitas.empweb.dao;

import java.util.ArrayList;

import cz.czechitas.empweb.bean.Employee;
import cz.czechitas.empweb.bean.EmployeeList;

public class FileDAO implements userDAO {
	static EmployeeList employeeList = new EmployeeList ();
/* (non-Javadoc)
 * @see cz.czechitas.empweb.dao.userDAO#save(cz.czechitas.empweb.bean.Employee)
 */
@Override
public void save (Employee employee) {
	if(employeeList.getList() == null) {
			employeeList.setList(new ArrayList<Employee>());
				
			
	}
employeeList.getList().add(employee); 
	

	ArrayList<Employee> list = new ArrayList <Employee> ();
	list.add(employee);
	employeeList.setList(list);
}
/* (non-Javadoc)
 * @see cz.czechitas.empweb.dao.userDAO#load()
 */
@Override
public EmployeeList load () {
	return employeeList;
}
}
