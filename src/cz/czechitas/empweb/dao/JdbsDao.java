package cz.czechitas.empweb.dao;

import javax.sql.DataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import cz.czechitas.empweb.bean.Employee;
import cz.czechitas.empweb.bean.EmployeeList;

public class JdbsDao implements userDAO {
	private static final String LOAD = "select * from user"; // LOAD je jméno, final static final je konstanta a píše se
	private static final String INSERT = "INSERT INTO USER (u_firtsname,u_lastname) VALUE (?,?)";															// velkým písmenem

	@Override
	public void save(Employee employee) {
		DataSource ds = getDataSource ();
		try (Connection con = ds.getConnection(); PreparedStatement stmt = con.prepareStatement(INSERT))
		{ 
			stmt.setString(1, employee.getName());
			stmt.setString(2, employee.getSurname());
			stmt.executeUpdate();
			con.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// TODO Auto-generated method stub

	}

	@Override
	public EmployeeList load() {
		EmployeeList ret = new EmployeeList();
		ArrayList<Employee> list = new ArrayList<>();
		DataSource ds = getDataSource();
		try (Connection con = ds.getConnection(); PreparedStatement stmt = con.prepareStatement(LOAD)) {
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Employee emp = new Employee();
				emp.setStatus(rs.getBoolean("u_status"));
				emp.setName(rs.getString("u_firtsname"));
				emp.setSurname(rs.getString("u_lastname"));
				emp.setId(rs.getInt("u_id"));
				list.add(emp);

			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		ret.setList(list);
		return ret;
	}

	private DataSource getDataSource() {
		try {
			Context ctx = new InitialContext();
			return (DataSource) ctx.lookup("java:/comp/env/jdbc/EmployeeDB");
		} catch (NamingException e) {
			e.printStackTrace();
		}
		return null;
	}

}
