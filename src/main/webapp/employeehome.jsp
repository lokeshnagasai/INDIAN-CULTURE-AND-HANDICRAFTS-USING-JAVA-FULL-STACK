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
body {
  background-image: url('https://static.vecteezy.com/system/resources/previews/001/984/880/original/abstract-colorful-geometric-overlapping-background-and-texture-free-vector.jpg');
}
</style>
 <script type="text/javascript">
        var IdealTimeOut = 15; //10 seconds
        var idleSecondsTimer = null;
        var idleSecondsCounter = 0;
        document.onclick = function () { idleSecondsCounter = 0; };
        document.onmousemove = function () { idleSecondsCounter = 0; };
        document.onkeypress = function () { idleSecondsCounter = 0; };
        idleSecondsTimer = window.setInterval(CheckIdleTime, 1000);
 
        function CheckIdleTime() {
            idleSecondsCounter++;
            var oPanel = document.getElementById("timeOut");
            if (oPanel) {
                oPanel.innerHTML = (IdealTimeOut - idleSecondsCounter);
            }
            if (idleSecondsCounter >= IdealTimeOut) {
                window.clearInterval(idleSecondsTimer);
                alert("Your Session has expired. Please login again.");
                window.location = "index.jsp";
            }
        }
    </script>
</head>
<body>


<h1 align=center>INDIAN  CULTURE </h1>

<br>

<ul>
  <li><a class="active" href="employeehome">Home</a></li>
  <li><a href="Aboutem.jsp">About</a></li>
  <li><a href="images.jsp">Images</a></li>
  <li><a href="listoffestivals.jsp">4 Faces Of India</a></li>
    <li><a href="opinion.jsp">Handicrafts</a></li>
   <li><a href="addproduct.jsp">My Local Products</a></li>
  <li><a href="viewemp">View Profile</a></li>
  <li  ><a  href="echangepwd">Change Password</a></li>
  <li><a href="employeelogin">Logout</a></li>
</ul>

<br>
<h3 align=center style="font-size:2vw">Welcome&nbsp;<c:out value="${euname}"></c:out></h3>
<img src="https://previews.123rf.com/images/andyvi/andyvi1610/andyvi161000103/64111514-welcome-to-india-india-s-traditional-symbols-icons-attractions-vector-illustration-.jpg" alt="img3" style="width:100%">


</body>
</html>

 
