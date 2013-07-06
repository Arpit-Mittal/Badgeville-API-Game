<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Badgeville online Game</title>
</head>

<body background="http://files.all-free-download.com/downloadfiles/wallpapers/1920_1200_widescreen/super_mario_galaxy_4_wallpaper_super_mario_games_wallpaper_1920_1200_widescreen_3159.jpg">
<b style="color:white; font-style:italic; font-weight:bold; font-family:Arial;font-size:30px;">Player information corresponding to a particular Team</b>
<br/>
<br/>
	<form:form method="post" action="winner.html"
		modelAttribute="multiplePlayer">
		<table WIDTH="100%"   border="2" style="width:180px;height:60px;">
			<tr>
				<th><b style="color:white;font-weight:bold; font-family:arial;font-size:25px;">Player Number</b></th>
				<th><b style="color:white;font-weight:bold; font-family:arial;font-size:25px;">Domain</b></th>
				<th><b style="color:white;font-weight:bold; font-family:arial;font-size:25px;">email</b></th>
				<th><b style="color:white;font-weight:bold; font-family:arial;font-size:25px;">display_name</b></th>
			</tr>
			<c:forEach items="${multiplePlayer.playerInfo}"
				var="playerUserInformation" varStatus="status">
				<tr>
					<td bgcolor="white" align="center">${status.count}</td>
					<td><input name="playerInfo[${status.index}].domain"
						id="domain" value="${playerUserInformation.domain}" /></td>
					<td><input name="playerInfo[${status.index}].email" id="email"
						value="${playerUserInformation.email}" /></td>
					<td><input name="playerInfo[${status.index}].display_name"
						id="display_name" value="${playerUserInformation.display_name}" /></td>
				</tr>
			</c:forEach>

		</table>
		<br />



		<input style="color:black;font-weight:bold; font-family:arial;font-size:25px;" type="button" value="Winner-Tournament"
			onclick="location.href='/HelloWorldSpring/forms/winner.html'" />


		<input style="color:black;font-weight:bold; font-family:arial;font-size:25px;" type="button" value="Player Change"
			onclick="javascript:history.back()" />
		<h3><b style="color:white; font-style:italic; font-weight:bold; font-family:Arial;font-size:30px;">A Pretend Forum</b></h3>
		<br/>
		<br/>

		<p><b style="color:white; font-style:italic; font-weight:bold; font-family:Arial;font-size:30px;">The following buttons are placeholders for actions in a real
			forum. However, they allow us to demonstrate the basics of
			integrating with Badgeville.</b></p>
		<br/>
		<br/>

		<input style="color:black;font-weight:bold; font-family:arial;font-size:25px;" type="button" value="Start a discussion"
			onclick="Badgeville.credit('Start a discussion')" />
		<input style="color:black;font-weight:bold; font-family:arial;font-size:25px;" type="button" value="Comment"
			onclick="Badgeville.credit({verb:'comment', forum:'sports'})" />
		<input  style="color:black;font-weight:bold; font-family:arial;font-size:25px;" type="button" value="Reply"
			onclick="Badgeville.credit('Reply')" />

		<div class="bv_showcase"></div>
		<div class="bv_activities"></div>


		<script>
			window.BadgevilleAsynchInit = function() {

				// Identify yourself to Badgeville by providing your public Berlin API key and
				// site URL
				Badgeville.extend(Badgeville.Settings, {
					key : '05f9e6f874832f97908553f2c9efa243',
					domain : document.getElementById('domain').value
				});

				// Register the player. This tells Badgeville who should get credit for 
				// behaviors, and whose information to display in the widgets.
				Badgeville
						.setPlayer({
							email : document.getElementById('email').value,
							display_name : document
									.getElementById('display_name').value
						});
				Badgeville.ready(function() {
					Badgeville.Gears.reward(Badgeville.p().last_reward)
							.appendTo(document.body);
				});

			};

			(function() {
				var s = document.createElement('script');
				s.async = true;
				s.src = 'http://sandbox.badgeville.com/v4/badgeville-current.js';
				document.body.appendChild(s);
			}());
		</script>

	</form:form>
</body>
</html>