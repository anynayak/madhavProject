<!doctype html>
<html>
<head>
<link href="style.css" rel="stylesheet">
<meta charset="utf-8">
<title>signup</title>
</head>

<body>
<div id="main">
<div class="style" align="center"><img src="images/hotel-management-system-dryice.jpg" width="1281" height="227"></div>

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
<form name="form1" method="post" action="user/register.do">
<p>First Name :
  <label for="firstname"></label>
  <input name="firstname" type="text" id="firstname" placeholder="firstname"size="20"required tabindex="1" maxlength="20">
</p>
<p>Last Name : 
  <label for="lastname"></label>
  <input name="lastname" type="text" id="lastname" placeholder="lastname"size="20"required tabindex="2" maxlength="20">
</p>
<p>Email : 
  <label for="email"></label>
  <input name="email" id="email"placeholder="example@domain.com" required type="email" required tabindex="4" size="30" maxlength="30">
</p>
<p>User Name :
  <label for="username"></label>
  <input name="username" type="text" id="username" placeholder="username"size="20"required tabindex="4" maxlength="20" >
</p>
<p>Create a password : 
  <label for="password"></label>
  <input name="password" type="password" id="password" placeholder="password"size="30" maxlength="30"required tabindex="4" >
</p>
<p>Confirm your password : 
  <label for="confirmpassword"></label>
  <input name="confirmpassword" type="password" id="confirmpassword"placeholder="confirmpassword" size="30"required tabindex="5" maxlength="30" >
</p>
<p>Street Address : 
  <label for="streetaddress"></label>
  <input name="streetaddress" type="text" id="streetaddress" placeholder="streetaddress"required tabindex="6" size="50">
</p>
<p>City : 
  <label for="city"></label>
  <input name="city" type="text" id="city" size="20" placeholder="city"maxlength="20"required tabindex="7" >
</p>
<p>State : 
  <label for="state"></label>
  <input name="state" type="text" id="state" size="20"placeholder="state" maxlength="20"required tabindex="8" >
</p>
<p>Zip Code : 
  <label for="zipcode"></label>
  <input type="text" name="zipcode"placeholder="zipcode" id="zipcode" required tabindex="9">
</p>
<p>Mobile : 
  <label for="mobile"></label>
  <input name="mobile" type="text" id="mobile"placeholder="mobile" size="20" required tabindex="10"maxlength="20" >
</p>

  <p>
    <input type="checkbox" name="aggrement" id="aggrement"required tabindex="11">
    <label for="aggrement"></label> 
    I have read and aggre to HMS's User Aggrement
</p>
  <p>
    <input  class="buttom" type="submit" name="createaccount" id="createaccount" value="Create Account"required tabindex="12">
  </p>
</form>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
</div>
</body>
</html>
