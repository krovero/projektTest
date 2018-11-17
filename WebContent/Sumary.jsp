<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="cz.czechitas.empweb.bean.*"
	import="java.util.ArrayList"%>
<meta charset="UTF-8">
<!DOCTYPE html>
<html>
<head>
<style>
#zamestnanci {
	font-family: "calibri";
	border-collapse: collapse;
	width: 100%;
}

#zamestnanci td, #zamestnanci th {
	border: 1px solid #ddd;
	padding: 8px;
}

#zamestnanci tr:nth-child(even) {
	background-color: lightgreen;
}

#zamestnanci tr:hover {
	background-color: #4caf50;
}

#zamestnanci th {
	padding-top: 12px;
	padding-bottom: 12px;
	text-align: center;
	background-color: #4caf50;
	color: white;
}
</style>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>domácí úkol_tabulka</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<h1>zaměstnanci</h1>
	

	<form action="Action" method="post">
		<a class="pravo" href="NewEmp.jsp"><img src="adduser.jpg"
			alt="přidej uživatele"></a>

		<table id=zamestnanci>
			<tr>
				<th>AKCE</th>
				<th>ID</th>
				<th>AKTIVNÍ</th>
				<th>JMÉNO</th>
				<th>PŘIJMENÍ</th>
			</tr>
			<%
		EmployeeList promnena = (EmployeeList) request.getAttribute("emplist");
	if (promnena != null){
		ArrayList<Employee> promnenaList = promnena.getList();
		for (Employee zamestnanec : promnenaList) {
	%>
			<tr>
				<td><input type="checkbox" name="akce1" value="jmeno1"></td>
				<td><%=zamestnanec.getId()%></td>
				<td><%=zamestnanec.getStatus()%></td>
				<td><%=zamestnanec.getName()%></td>
				<td><%=zamestnanec.getSurname()%></td>
			</tr>
			<%
				} }
			%>

		</table>

		<button class="button" name="action" value="active">AKTIVOVAT</button>
		<button class="button" name="action" value="deactive">DEAKTIVOVAT</button>
	</form>