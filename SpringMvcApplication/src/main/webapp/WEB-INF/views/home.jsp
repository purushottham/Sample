<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Contact Manager Home</title>
</head>
<body>
	<div align="center">
		<h1>Shifts Information</h1>
		<table border="1">
			<th>NO</th>
			<th>Date</th>
			<th>Shift1</th>
			<th>Shift2</th>
			<c:forEach var="schedule" items="${schedules}" varStatus="status">
				<tr>
					<td>${status.index + 1}</td>
					<td>${schedule.date}</td>
					<c:forEach var="engineerInfo" items="${schedule.engineersInfo}"
						varStatus="status">
						<td>${engineerInfo.name}</td>
					</c:forEach>
				</tr>
			</c:forEach>
		</table>
		<a href="getEngineers">Refresh</a>
	</div>
</body>
</html>
