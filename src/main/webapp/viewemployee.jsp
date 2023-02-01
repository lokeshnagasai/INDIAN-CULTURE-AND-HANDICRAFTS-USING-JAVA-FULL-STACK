<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=ISO-8859-1" isELIgnored="false"%>


<!DOCTYPE html>
<html>
<head>
<style>
ul 
{
  list-style-type: none;
  margin: 0;
  padding: 0px;
  overflow: hidden;
  background-color: lightblue;
}

li 
{
  float: left;
    border-right: 1px solid blue;
}

li a 
{
  display: block;
  color: black;
 font-size:20px;
  text-align: center;
  padding: 10px 20px;
  text-decoration: none;
}
.active
{
background-color: black;
color: white;
}
li a:hover {
  background-color: orange;
  color: white;
}

.center {
  display: block;
  margin-left: auto;
  margin-right: auto;
  width: 50%;
}
body {
  background-image: url('https://static.vecteezy.com/system/resources/previews/001/984/880/original/abstract-colorful-geometric-overlapping-background-and-texture-free-vector.jpg');
}

</style>

</head>
<ul>
<li><a class="active" href="employeehome.jsp">Back</a></li>
</ul>
<body>

<h1 align=center>Proud to be an Indian</h1>

<br>

<ul>
  <li><a href="employeehome">Home</a></li>
  <li><a class="active" href="viewemp">View Profile</a></li>
  <li><a href="echangepwd">Change Password</a></li>
   <li><a href="employeelogin">Logout</a></li>
   
</ul>

<br>

<h2 style="color:green" align=center>Welcome&nbsp;<c:out value="${euname}"></c:out></h2>

<br>
<div class="container">
  <div class="crop">
 
    <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRODZob7ROpqlx8WXwjueNwTOlC6Qum-yMiyfXiFRXkdhkHgybCpdvM1UpaXCL1ycfO8NI&usqp=CAU" class="center" style="width:150px;height:150px;" >
  </div>

</div>

<table align=center>

<tr><th>ID:</th>&nbsp;<td>${emp.id}</td></tr>
<tr><th>Name:</th>&nbsp;<td>${emp.name}</td></tr>
<tr><th>Gender:</th>&nbsp;<td>${emp.gender}</td></tr>
<tr><th>Date of Birth:</th>&nbsp;<td>${emp.dateofbirth}</td></tr>
<tr><th>intrest:</th>&nbsp;<td>${emp.department}</td></tr>
<tr><th>Face:</th>&nbsp;<td>${emp.designation}</td></tr>
<tr><th>population:</th>&nbsp;<td>${emp.salary}</td></tr>
<tr><th>Location:</th>&nbsp;<td>${emp.location}</td></tr>
<tr><th>Email ID:</th>&nbsp;<td>${emp.emailid}</td></tr>
<tr><th>Contact No:</th>&nbsp;<td>${emp.contactno}</td></tr>



</table>



</body>
</html>

 
