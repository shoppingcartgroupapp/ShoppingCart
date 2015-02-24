<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
  <title>ToughPlay</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>



</head>
<body>

	<style type="text/css">

      /* Sticky footer styles
      -------------------------------------------------- */

      html,
      body {
        height: 100%;
        /* The html and body elements cannot have any padding or margin. */
      }

      /* Wrapper for page content to push down footer */
      #wrap {
        min-height: 100%;
        height: auto !important;
        height: 100%;
        /* Negative indent footer by it's height */
        margin: 0 auto -60px;
      }

      /* Set the fixed height of the footer here */
      #push,
      #footer {
        height: 60px;
      }
      #footer {
        background-color: #f5f5f5;
      }

      /* Lastly, apply responsive CSS fixes as necessary */
      @media (max-width: 767px) {
        #footer {
          margin-left: -20px;
          margin-right: -20px;
          padding-left: 20px;
          padding-right: 20px;
        }
      }



      /* Custom page CSS
      -------------------------------------------------- */
      /* Not required for template or sticky footer method. */

      .container {
        width: auto;
        max-width: 680px;
      }
      .container .credit {
        margin: 20px 0;
      }

    </style>
    
    	<c:choose>
    		<c:when test='${requestScope["login"] == "success"}'>
    			<div id="header">
    			<c:import url="jsp/loggedInHeader.jsp"></c:import>
    			</div>
    		</c:when>
    		<c:otherwise>
    			<div id="header">
    			<c:import url="jsp/header.jsp"></c:import>
    			</div>
    		</c:otherwise>
    	</c:choose>
	
		
		
		----- Insert Body Here -----
		
		<br> ${requestScope["login"]}
		
		<c:if test='${requestScope["login"] == "success"}'>
		<p style="color: #00DD00;">Login successful!</p>
		</c:if>
		
		
		<c:if test='${requestScope["login"] == "passwordFailure"}'>
		<p style="color: #FF0000;">Password mismatch with the given email address.</p>
		</c:if>
		
		<c:if test='${requestScope["login"] == "emailFailure"}'>
		<p style="color: #FF0000;">This email does not exist in our ${requestScope["accountType"]} database.</p>
		</c:if>
		
		
		

		<div id="wrap">
			<div id="push"></div>
    	</div>
		<div id="footer">
		
			<c:import url="jsp/footer.jsp"></c:import>
		
		</div>
	

</body>

</body>
</html>