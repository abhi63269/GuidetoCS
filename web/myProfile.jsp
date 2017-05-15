<!DOCTYPE html>
<html>
<head>
	<title>Profile</title>
	<link rel="stylesheet" type="text/css" href="css/Profilecss.css">
	<link href="https://fonts.googleapis.com/css?family=Josefin+Sans" rel="stylesheet">
	<style type="text/css">
	*{
		margin: 0px;
	}
	h3{
		color: white;
		margin-bottom: 30px;
	}
	.cont h1{
		color: white;
	}
		.cont{
			padding-top: 250px;
			background-color: blue;
		}
		.cont2{
			padding: 65px;
			background-color: lightblue;
		}
		hr{
			text-align: center;
			padding: 0px;
			border: 2px solid white;
		}
		.cont1{
			border-radius: 100px;
			border:2px solid white;
			width: 200px;
			height: 200px;
			position:absolute;
			left: 43%;
			bottom: 33%;
			background-size: cover;
		}
	</style>
</head>
<body>
    <script>
        var haf="<%=session.getAttribute("umail")%>";
    </script>
		<div class="cont">
			<h1><%=session.getAttribute("uname")%></h1>
			<h3><%=session.getAttribute("ubranch")%></h3>
			<hr>
                        <div class="cont1">
                            <img src="image.jsp?imgid='<%=session.getAttribute("umail")%>'" height="200px" width="200px" style="border-radius:100px">
			</div>
		</div>
	<div class="cont2">
		<h1 class="Edit">Edit details:</h1>
	<div class="container1">
            <form action="UpdateUserAccountHttpServlet" method="post">
		<table class="Table">
			<tr>
				<th>Name:</th>
                                <td><input type="text" readonly name="Name" value="<%=session.getAttribute("uname")%>" required style="width: 200px; height: 25px;"></td>
			</tr>
			
  			<tr>
  				<th>Branch:</th>
  				<td><input type="text" readonly name="Branch" value="<%=session.getAttribute("ubranch")%>" required style="width: 200px; height: 25px;"></td>
  			</tr>
  			<tr>
  				<th>Semester:</th>
  				<td><input type="number" readonly name="Sem"  value="<%=session.getAttribute("usem")%>" min="1" max="8" required style="width: 200px; height: 25px;"></td>
  			</tr>
  			<tr>
  				<th>Gender:</th>
  				<td><input type="text" readonly name="Gender" value="<%=session.getAttribute("ugen")%>" required checked>
  			</tr>
  			<tr>
  				<th>EMail:</th>
  				<td><input type="email"  readonly name="umail" placeholder="Enter your EMail"  value="<%=session.getAttribute("umail")%>" required style="width: 200px; height: 25px;"></td>
  			</tr>
  			<tr>
  				<th>Phone No.:</th>
  				<td><input type="tel" readonly name="Phone" placeholder="Enter your Phone No." value="<%=session.getAttribute("uphone")%>" maxlengtd="10" minlengtd="10"  required style="width: 200px; height: 25px;"></td>
  			</tr>
  			<tr>
  				<th>Old Password:</th>
                                <td><input type="password" readonly  name="Pass" placeholder="Old Password" value="<%=session.getAttribute("upass")%>" maxlength="20" minlength="8"  required style="width: 200px; height: 25px;"></td>
        	</tr>
        	<tr>
  				<th>New Password:</th>
          		<td><input type="password" name="npass" placeholder="New Password" maxlength="20" minlength="8"  required style="width: 200px; height: 25px;"></td>
        	</tr>
        	<tr>
        	  <th>Confirm Password:</th>
        	  <td><input type="password" name="cpass" placeholder="Confirm Password" maxlength="20" minlength="8"  required style="width: 200px; height: 25px;"></td>
  			</tr>
		</table>
		<button class="SCButton" type="submit">Save Changes</button>
	</form>
	</div>
</body>
</html>