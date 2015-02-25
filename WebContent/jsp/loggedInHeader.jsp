<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>ToughPlay</title>
 
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
</head>
<body>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <a class="navbar-brand" href="#">ToughPlay Sporting Goods</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li class="active"><a href="#">Home</a></li>
        <li class="dropdown">
          <a class="dropdown-toggle" data-toggle="dropdown" href="#">Baseball <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="#">Gloves</a></li>
            <li><a href="#">Bats</a></li>
            <li><a href="#">Helmets</a></li>
          </ul>
        </li>
		<li class="dropdown">
          <a class="dropdown-toggle" data-toggle="dropdown" href="#">Football <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="#">Footballs</a></li>
            <li><a href="#">Pads</a></li>
            <li><a href="#">Helmets</a></li>
          </ul>
        </li>
		<li class="dropdown">
          <a class="dropdown-toggle" data-toggle="dropdown" href="#">Basketball<span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="#">Basketballs</a></li>
            <li><a href="#">Apparel</a></li>
            <li><a href="#">Shoes</a></li>
          </ul>
        </li>
		<li class="dropdown">
          <a class="dropdown-toggle" data-toggle="dropdown" href="#">Golf<span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="#">Clubs</a></li>
            <li><a href="#">Apparel</a></li>
            <li><a href="#">Shoes</a></li>
          </ul>
        </li>
		<li class="dropdown">
          <a class="dropdown-toggle" data-toggle="dropdown" href="#">Tennis<span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="#">Racquets</a></li>
            <li><a href="#">Apparel</a></li>
            <li><a href="#">Shoes</a></li>
          </ul>
        </li>
		<li class="dropdown">
          <a class="dropdown-toggle" data-toggle="dropdown" href="#">Cricket<span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="#">Apparel</a></li>
            <li><a href="#">Pads</a></li>
            <li><a href="#">Bats</a></li>
          </ul>
        </li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="#" ><span class="glyphicon glyphicon-user"></span>Manage Account</a></li>
        <li><a href="#"><span class="glyphicon glyphicon-shopping-cart"></span>MyItems</a></li>
        <li><a href="/ShoppingCart/ActionServlet?action=logoutaccount"><span class="glyphicon glyphicon-off"></span>Logout</a></li>       
      </ul>
    </div>
  </div>
</nav>

</body>
</html>