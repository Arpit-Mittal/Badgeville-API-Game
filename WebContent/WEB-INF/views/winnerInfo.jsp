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
<body  background="http://files.all-free-download.com/downloadfiles/wallpapers/1920_1200_widescreen/super_mario_galaxy_4_wallpaper_super_mario_games_wallpaper_1920_1200_widescreen_3159.jpg">
<b style="color:white; font-style:italic; font-weight:bold; font-family:Arial;font-size:30px;">Winner of the Tournament</b>
<br/>
<br/>
<form:form method="post" action="save.html"
	modelAttribute="winnerPlayInfo">
	<table  WIDTH="100%"   border="2" style="width:180px;height:60px;">
		<tr>
			<th><b style="color:white;font-weight:bold; font-family:arial;font-size:25px;">TeamNumber</b></th>
			<th><b style="color:white;font-weight:bold; font-family:arial;font-size:25px;">winnerPlayerNames</b></th>
			<th><b style="color:white;font-weight:bold; font-family:arial;font-size:25px;">TeamId</b></th>
			<th><b style="color:white;font-weight:bold; font-family:arial;font-size:25px;">playerPoints</b></th>
			<th><b style="color:white;font-weight:bold; font-family:arial;font-size:25px;">teamName</b></th>
			<th><b style="color:white;font-weight:bold; font-family:arial;font-size:25px;">totalTeamPoints</b></th>
			<th><b style="color:white;font-weight:bold; font-family:arial;font-size:25px;">winnerStatus</b></th>
		</tr>

		<c:forEach items="${winnerPlayInfo.winnerPlayerInfo}"
			var="winnerPlayer" varStatus="status">
			<tr>
				<td bgcolor="white" align="center">${status.count}</td>
				<td bgcolor="white"><input name="winnerPlayerInfo[${status.index}].playerName"
					value="${winnerPlayer.playerName}" /></td>
				<td bgcolor="white"><input name="winnerPlayerInfo[${status.index}].teamId"
					value="${winnerPlayer.teamId}" /></td>
				<td bgcolor="white"><input
					name="winnerPlayerInfo[${status.index}].playerPoints"
					value="${winnerPlayer.playerPoints}" /></td>
				<td bgcolor="white"><input name="winnerPlayerInfo[${status.index}].teamName"
					value="${winnerPlayer.teamName}" /></td>
				<td bgcolor="white"><input
					name="winnerPlayerInfo[${status.index}].totalTeamPoints"
					value="${winnerPlayer.totalTeamPoints}" /></td>
				<td bgcolor="white"><input
					name="winnerPlayerInfo[${status.index}].winnerStatus"
					value="${winnerPlayer.winnerStatus}" /></td>
			</tr>
		</c:forEach>

	</table>
	<br />


</form:form>
<input style="color:black;font-weight:bold; font-family:arial;font-size:25px;" type="button" value="Team-Info" onclick="location.href='/HelloWorldSpring/forms/helloworld.html'" />
</body>
</html>