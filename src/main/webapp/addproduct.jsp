<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page contentType="text/html; charset=ISO-8859-1" isELIgnored="false"%>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Spring Boot Project</title>
    <style>
        .navbar{
            background-color: lightblue;
            border-radius: 30px;
            
        }
        .navbar ul{
            overflow: auto;
        }
        .navbar li{
            float:left;
            list-style: none; 
            margin: 13px 20px;
            
        }
        .navbar li a{
            padding: 3px 3px;
            text-decoration: none;
            color: white;
        }
        .navbar li a:hover{
            color: red
        }
        .search{
            float: right;
            color: white;
            padding: 12px 75px;
        }
        .navbar input{
            border: 2px solid black;
            border-radius: 14px;
            padding: 3px 17px;
            width: 129px;
        }
        .button {
  background-color: lightblue;
  border: none;
  color: white;
  padding: 15px 32px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  margin: 4px 2px;
  cursor: pointer;
}
input[type=text],input[type=password],input[type=number],input[type=email],
select,input[type=date],input[type=file],textarea
{
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
}

label 
{
  padding: 12px 12px 12px 0;
  display: inline-block;
  font-weight: bold;
}
body {
  background-image: url('https://static.vecteezy.com/system/resources/previews/001/984/880/original/abstract-colorful-geometric-overlapping-background-and-texture-free-vector.jpg');
}

    </style>
</head>

<body>

<h2 align="center">Upload About my local product</h2>

    <header>
        <nav class="navbar">
            <ul>
                <li><a href="employeehome.jsp">Home</a></li>
                <li><a href="addproduct">Add Product</a></li>
                <li><a href="viewallprods">View All Products</a></li>
            </ul>
        </nav>
    </header>
    
<br><br>

<h3 align=center><u>Add  about my Product</u></h3>

<br>

<form action="insertproduct" method="post" enctype="multipart/form-data">

<table align=center>

<tr>
<td><label>Region</label></td>
<td>
<select name="category" required="required">
<option value="-1">---Select---</option>
<option value="N_India">North India</option>
<option value="S_India">South India</option>
<option value="7sisters">7 sisters</option>
</select>
</td>
</tr>

<tr><td></td></tr>

<tr>
<td><label>Name of the product</label></td>
<td><input type="text" name="name" required="required"/></td>
</tr>

<tr><td></td></tr>

<tr>
<td><label>Description of the product</label></td>
<td>
<textarea name="description"></textarea>
</td>
</tr>

<tr><td></td></tr>

<tr>
<td><label>Cost of the product</label></td>
<td><input type="number" name="cost" required="required"/></td>
</tr>

<tr><td></td></tr>

<tr>
<td><label>url of website</label></td>
<td><input type="text" name="productlink" required="required"/></td>
</tr>


<tr><td></td></tr>

<tr>
<td><label>Image of the product</label></td>
<td><input type="file" name="productimage" required="required"/></td>
</tr>

<tr><td></td></tr>
<tr><td></td></tr>

<tr align=center>
<td colspan=2><input type="submit" value="Add" class="button"></td>
</tr>

</table>

</form>
    
    
</body>

</html>
