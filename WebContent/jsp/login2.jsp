<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Login form and sign up</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,600'
	rel='stylesheet' type='text/css'>
<link href="style.css" rel="stylesheet" type="text/css" media="all" />
</head>
<body>
	<!----------start member-login----------->
	<div class="member-login">
		<!----------star form----------->
		<form class="login" action="#" method="post">

			<div class="formtitle">Member Login</div>
			<div class="input">
				<input type="text" placeholder="User Name" required />
				<!-- 						<span><img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ-1vXmeeKPP0lP007Ih2YNIl2VZyF-Kx2GZq0EeWIdO7SqEqkYIQ"/> </span> -->
			</div>
			<div class="input">
				<input type="password" placeholder="Password" required />
				<!-- 						<span><img src="https://www.google.com/search?q=image/close.png&biw=1280&bih=666&tbm=isch&tbo=u&source=univ&sa=X&ei=IxHiVPLKMYWbyQSkp4K4DQ&ved=0CCwQ7Ak&dpr=1#imgdii=_&imgrc=C0isjOUur5XsfM%253A%3B2GC1VwThG7lzbM%3Bhttp%253A%252F%252Ffiles.softicons.com%252Fdownload%252Fsystem-icons%252Fginux-icons-by-kyo-tux%252Fpng%252F64%252FClose.png%3Bhttp%253A%252F%252Fdict.space.4goo.net%252Fdict%253Fq%253Dclose%3B64%3B64"/></span> -->
			</div>
			<div class="buttons">
				<a href="#">Forgot password?</a> <input class="bluebutton"
					type="submit" value="Login" />
				<div class="clear"></div>
			</div>

		</form>
		<!----------end form----------->
	</div>
</body>
</html>
