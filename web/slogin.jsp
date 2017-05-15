<!DOCTYPE html>
<html>
<head>
	<title>LogIn</title>
	<link href="https://fonts.googleapis.com/css?family=Abel" rel="stylesheet">
	<style type="text/css">
		.bd{
			background-color: black;
			padding: 20px;
		}
		.divs{
			margin: 100px;
			width: 80%;
			height: 450px;
			background-size: cover;
			background-image: url(Images/SLog.jpg);
			margin-top: 50px;
			padding-bottom: 120px;
			padding-right: 20px;
		}
		.divi{
			background-color: #f1c40f;
			margin-left: 600px;			
			margin-right: 100px; 	
			padding-left: 80px;
			padding-bottom: 50px;
			padding-top: 50px;
			width: 33.3%;
			align-content: center; 
			border-radius: 10px;
			box-shadow: 5px 5px 20px black;
		}
		.Usr2{
			background-image: url(Images/Emailnew.png);
			background-size: 30px 30px;
			background-position: left;
			padding-left: 50px;
			background-repeat:no-repeat;
			background-position: 2px 3px;
		}
		.Usr3{
			background-image: url(Images/Passnew.png);
			background-size: 30px 30px;
			background-position: left;
			padding-left: 50px;
			background-repeat:no-repeat;
			background-position: 2px 3px;
		}
		.bt{
        align: center;
        margin: 0px;
        display: inline-block;
        margin-left: 150px;
        height: 35px;
        width:100px;
        background-color: #2c3e50;
        background-size: cover;
        border: none;
        box-shadow: 2px 2px 20px #000000;
        color: white;
        border-radius: 5px;
      }
      .bt:hover{
        opacity: .7;
       }
		input{
	     	border-radius: 5px;
	     	height: 40px;
	     	width: 200px;
	     	margin: 0px;
	     	margin-bottom: 50px;

	     }
	     .Img{
	     	align: right;
	     }
	</style>
</head>
<body class="bd">
<img src="Images/Cap.png" align="right" style=" margin-top: 0px; ">
<div class="divs">
<img src="Images/GTC.png">
	<div class="divi">
		<h1 style="font-family: 'Abel', sans-serif; margin-left: 50px; ">LOGIN HERE</h1>
		<form action="LoginHttpServlet" method="post">
			<input class="Usr2" type="email" name="umail" placeholder="Enter your EMail" autocomplete="on">
			<input class="Usr3" type="password" name="upass" placeholder="Enter Password">
			 <input type="submit" class="bt" value="LOG-IN &raquo;">
		</form>
	</div>
</div>
</body>
</html>