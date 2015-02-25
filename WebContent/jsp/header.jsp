<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>ToughPlay</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
</head>

<body>
<!-- Comment -->
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
        <li class="active"><a href="/ShoppingCart">Home</a></li>
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
         <li><a href="/ShoppingCart/jsp/signUpPage.jsp" ><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
        <li><a href="#loginModal" data-toggle="modal" data-target="#loginModal"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
      </ul>
    </div>
  </div>
</nav>

<!-- Modal for Login-->
  <div class="modal fade" id="loginModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
          <h4 class="modal-title">Sign In</h4>
        </div>
        <div class="modal-body">
		<form class="form-horizontal" method="post" action="/ShoppingCart/ActionServlet">
			<input type="hidden" name="action" value="verifyaccount" />
			<div class="form-group">
			<label for="signinemail">&nbsp;&nbsp;Email</label><input type="email" name="email" class="form-control" id="signinemail"/>
			</div>
			<div class="form-group">
			<label for="signinpassword">&nbsp;&nbsp;Password</label><input type="password" name="password" class="form-control" id="signinpassword"/>
			</div>
			<div class="form-group">
			<label for="signinaccount">&nbsp;&nbsp;Account type:&nbsp;&nbsp;</label><input type="radio" name="accountType" id="signinaccount" value="customer" />&nbsp;Customer
			<input type="radio" name="accountType" id="signinaccount" value="supplier" />&nbsp;Supplier
			</div>
          
        <div class="modal-footer"><!-- footer area with buttons for a continued dialog -->
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
          <input type="submit" value="Submit" class="btn btn-primary" />
          </div>
          </form>
        </div>
      </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
  </div><!-- /.modal -->
</body>
</html>
