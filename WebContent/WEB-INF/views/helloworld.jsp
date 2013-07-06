<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spring 3.0 MVC Series: Hello World</title>
</head>
<body background="http://files.all-free-download.com/downloadfiles/wallpapers/1920_1200_widescreen/super_mario_galaxy_4_wallpaper_super_mario_games_wallpaper_1920_1200_widescreen_3159.jpg">
<b style="color:white; font-style:italic; font-weight:bold; font-family:Arial;font-size:30px;">Team information.</b>
<br/>
<br/>
<b style="color:white; font-weight:bold; font-family:Arial;font-size:20px;">Please Enter Player Status as False/True and Enter Player Name Playing for Team Below by searching Players Info:-</b>
<br/>
<br/>
<form:form method="post" action="save.html" modelAttribute="teamForm">
	<table WIDTH="100%"   border="2" style="width:180px;height:60px;">
		<tr>
			<th><b style="color:white;font-weight:bold; font-family:arial;font-size:25px;">TeamNumber</b></th>
			<th><b style="color:white;font-weight:bold; font-family:arial;font-size:25px;">TeamName</b></th>
			<th><b style="color:white;font-weight:bold; font-family:arial;font-size:25px;">TeamId</b></th>
			<th><b style="color:white;font-weight:bold; font-family:arial;font-size:25px;">Player</b></th>
			<th><b style="color:white;font-weight:bold; font-family:arial;font-size:25px;">PlayersId</b></th>
			<th><b style="color:white;font-weight:bold; font-family:arial;font-size:25px;">PlayersInfo</b></th>
			<th><b style="color:white;font-weight:bold; font-family:arial;font-size:25px;">Player-status</b></th>
			<th><b style="color:white;font-weight:bold; font-family:arial;font-size:25px;">Enter Player Name Playing for Team</b></th>
		</tr>
		<c:forEach items="${teamForm.teamsInfo}" var="team" varStatus="status">
			<tr>
				<td bgcolor="white" align="center">${status.count}</td>
				<td><input name="teamsInfo[${status.index}].teamName"
					value="${team.teamName}" /></td>
				<td><input  name="teamsInfo[${status.index}].teamId"
					value="${team.teamId}" /></td>
				<td><input  name="teamsInfo[${status.index}].playerNames"
					value="${team.playerNames}" /></td>
				<td><input  name="teamsInfo[${status.index}].playersId"
					value="${team.playersId}" /></td>
				<td><input  name="teamsInfo[${status.index}].playersInfo"
					value="${team.playersInfo}" /></td>
				<td><input  name="teamsInfo[${status.index}].playingFlag"
					value="${team.playingFlag}" /></td>
				<td><input 
					name="teamsInfo[${status.index}].userInputPlayerName"
					value="${team.userInputPlayerName}" /></td>
			</tr>
		</c:forEach>

	</table>
	<br />
	<input style="color:black;font-weight:bold; font-family:arial;font-size:25px;" type="submit" value="Start-Game" />

</form:form>
<br/>
<br/>
<input style="color:black;font-weight:bold; font-family:arial;font-size:25px;" type="button" value="Back" onclick="javascript:history.back()" />
</body>
</html>