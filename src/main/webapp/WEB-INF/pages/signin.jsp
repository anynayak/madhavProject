 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!doctype html>
<html>
<head>
<link href="style.css" rel="stylesheet">
<meta charset="utf-8">
<title>signin</title>
</head>

<body>
<div id="main">
<div class="style" align="center"> <img src="images/hotel-management-system-dryice.jpg" width="1281" height="227"></div>

<table width="1263" border="5" align="center">
  <tr>
    <th width="202" height="42" align="center" valign="middle" scope="col"><a href="index.html">HOME</a></th>
    <th width="203" align="center" valign="middle" scope="col"><a href="facilities.html">HOTEL FACILITIES</a></th>
    <th width="202" align="center" valign="middle" bgcolor="#FFFFFF" scope="col"><a href="gallery.html">GALLERY</a></th>
    <th width="204" align="center" valign="middle" scope="col"><a href="reservation.html">RESERVATION</a></th>
    <th width="203" align="center" valign="middle" scope="col"><a href="cancellation.html">CANCELLATION</a></th>
    <th width="201" align="center" valign="middle" scope="col"><a href="contect.html">CONTECT</a></th>
  </tr>
</table>
<p>&nbsp;</p> <p style="color: red;"><c:out value="${message}"></c:out></p>
<form name="form1" method="post" action="user/login.do">
<p>Username :
  <label for="username"></label>
  <input name="username" type="text" id="username"  placeholder="username"size="20" maxlength="20">
</p>
<p>Password :
  <label for="password"></label>
  <input name="password" type="password" id="password" placeholder="password"size="20" maxlength="20">
</p>
  <p>Forgot Password <a href="signup.do">Sign Up</a></p>
  <p>
  <input type="submit" name="signin" id="signin" value="Sign in">
  </p>
</form>
<p>&nbsp;</p>
</div>
</body>
</html>
