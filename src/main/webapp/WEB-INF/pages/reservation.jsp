 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <link href="${pageContext.request.contextPath}css/style.css" rel="stylesheet" type="text/css" > 
 
<!doctype html>
<html>
<head>
<link href="${pageContext.request.contextPath}/style.css" rel="stylesheet" type="text/css" > 
<link href="<c:url value="/style.css" />" rel="stylesheet">
<link href="SpryAssets/SpryValidationTextField.css" rel="stylesheet" type="text/css">
<link href="SpryAssets/SpryValidationSelect.css" rel="stylesheet" type="text/css">
<meta charset="utf-8">
<title>Reservation</title>
<script src="SpryAssets/SpryValidationTextField.js" type="text/javascript"></script>
<script src="SpryAssets/SpryValidationSelect.js" type="text/javascript"></script>
</head>

<body>
<div id="main" >
  <div align="right"><a href="signin.do">Sign in</a>/<a href="signup.do">Sign up</a></div>
  <div class="style" align="center"> 
  <img src="images/hotel-management-system-dryice.jpg" width="1281" height="227"></div>

<table width="1263" border="5" align="center">
  <tr>
    <th width="202" height="42" align="center" valign="middle" scope="col"><a href="index.html">HOME</a></th>
    <th width="203" scope="col"><a href="facilities.html">HOTEL FACILITIES</a></th>
    <th width="202" align="center" valign="middle" scope="col"><a href="gallery.html">GALLERY</a></th>
    <th width="204" scope="col"><a href="reservation.html">RESERVATION</a></th>
    <th width="203" scope="col"><a href="cancellation.html">CANCELLATION</a></th>
    <th width="201" scope="col"><a href="contect.html">CONTECT</a></th>
  </tr>
</table>
<h3>When would you like to stay at Hotel White House?</h3>
<p>&nbsp;</p>
<form name="form1" method="post" action="user/availability.do">

<p>Check-in Date: 
  <label for="check_in_date"></label>
  <span id="sprytextfield1">
    <input name="checkInDate" type="text" id="check_in_date" size="20" maxlength="10">
    <span class="textfieldRequiredMsg">A value is required.</span><span class="textfieldInvalidFormatMsg">Invalid format.</span></span></p>
<h4>Check-out Date: 
  <label for="check_out_date"></label>
  <span id="sprytextfield2">
  <input name="check_out_date" type="text" id="check_out_date" size="20" maxlength="10">
  <span class="textfieldRequiredMsg">A value is required.</span><span class="textfieldInvalidFormatMsg">Invalid format.</span></span></h4>
<select name="category">
<option value="1">double</option>
<option value="0">single</option>
</select>
<select name="type">
<option value="0">NON AC</option>
<option value="1">AC</option>
</select>
<p>Adults : 
  <label for="adults"></label>
  <input name="adults" type="number" id="adults" size="10" maxlength="10">
</p>
<p>&nbsp;</p>
<p>Children : 
  <label for="children"></label>
  <input name="children" type="number" id="children" size="10" maxlength="10">
</p>
<p>&nbsp;</p>


  <label for="check_availability"></label>
  <input type="submit" name="check_availability" id="check_availability" value="Check availability">
</form>

 <c:forEach items="${hotelList }" var="hotel" > 
<tr> 
<td><c:out value="${hotel.roomId}"></c:out></td> 
 

</tr>
</c:forEach>
<p>&nbsp;</p>
:
<p>&nbsp;</p>
<p>
  <script>
function myFunction() {
    var x = document.getElementById("myDate").value;
    document.getElementById("demo").innerHTML = x;
}
  </script>
</p>
</div>
<div></div>
<script type="text/javascript">
var sprytextfield1 = new Spry.Widget.ValidationTextField("sprytextfield1", "date", {format:"dd/mm/yy", validateOn:["blur"], hint:"dd/mm/yy"});
var sprytextfield2 = new Spry.Widget.ValidationTextField("sprytextfield2", "date", {format:"dd/mm/yy", hint:"dd/mm/yy"});
var spryselect1 = new Spry.Widget.ValidationSelect("spryselect1");
</script>
</body>
</html>
