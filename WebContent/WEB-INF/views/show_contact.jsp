<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Spring 3 MVC Multipe Row Submit - viralpatel.net</title>
</head>
<body background="gameBackGround.jpg">
	<h2>Show Contacts</h2>
	<table width="50%">
		<tr>
			<th>TeamNumber</th>
			<th>TeamName</th>
			<th>TeamId</th>
			<th>PlayerNames</th>
			<th>PlayersId</th>
			<th>PlayersInfo</th>
			<th>Team-status(false/true)</th>
			<th>Enter Player Name Playing for Team</th>
		</tr>
		<c:forEach items="${teamForm.teamsInfo}" var="team" varStatus="status">
			<tr>
				<td align="center">${status.count}</td>
				<td><input name="teamsInfo[${status.index}].teamName"
					value="${team.teamName}" /></td>
				<td><input name="teamsInfo[${status.index}].teamId"
					value="${team.teamId}" /></td>
				<td><input name="teamsInfo[${status.index}].playerNames"
					value="${team.playerNames}" /></td>
				<td><input name="teamsInfo[${status.index}].playersId"
					value="${team.playersId}" /></td>
				<td><input name="teamsInfo[${status.index}].playersInfo"
					value="${team.playersInfo}" /></td>
				<td><input name="teamsInfo[${status.index}].playingFlag"
					value="${team.playingFlag}" /></td>
				<td><input
					name="teamsInfo[${status.index}].userInputPlayerName"
					value="${team.userInputPlayerName}" /></td>
			</tr>
		</c:forEach>
	</table>
	<br />
	<input type="button" value="Back" onclick="javascript:history.back()" />
</body>
</html>