<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Forum Tutorial</title>
</head>
<body background="gameBackGround.jpg">
<br />
<input type="button" value="Back" onclick="javascript:history.back()" />


	<h3>A Pretend Forum</h3>

	<p>The following buttons are placeholders for actions in a real
		forum. However, they allow us to demonstrate the basics of integrating
		with Badgeville.</p>

	<input type="button" value="Start a discussion"
		onclick="Badgeville.credit('Start a discussion')" />
	<input type="button" value="Comment"
		onclick="Badgeville.credit({verb:'comment', forum:'sports'})" />
	<input type="button" value="Reply" onclick="Badgeville.credit('Reply')" />

	<div class="bv_showcase"></div>
	<div class="bv_activities"></div>


	<script>
		window.BadgevilleAsynchInit = function() {

			// Identify yourself to Badgeville by providing your public Berlin API key and
			// site URL
			Badgeville.extend(Badgeville.Settings, {
				key : '05f9e6f874832f97908553f2c9efa243',
				domain : 'demo.v2.badgeville.com'
			});

			// Register the player. This tells Badgeville who should get credit for 
			// behaviors, and whose information to display in the widgets.
			Badgeville.setPlayer({
				email : 'ian@badgeville.com',
				display_name : 'ian'
			});
			Badgeville.ready(function() {
				Badgeville.Gears.reward(Badgeville.p().last_reward).appendTo(
						document.body);
			});

		};

		(function() {
			var s = document.createElement('script');
			s.async = true;
			s.src = 'http://sandbox.badgeville.com/v4/badgeville-current.js';
			document.body.appendChild(s);
		}());
	</script>

</body>
</html>