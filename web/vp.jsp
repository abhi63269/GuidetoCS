<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="css/VP.css">
	<link href="https://fonts.googleapis.com/css?family=Josefin+Sans" rel="stylesheet">
	<link rel="stylesheet" href="fonts/font-awesome/css/font-awesome.min.css">
	<title>View Profile</title>
</head>
<body>
	<div class="navbar">
	<h2> Sidebar Menu </h2>
	<nav>
		<a href="Dash.html">Home</a>
		<a href="#insidetasks" onclick="show()">Courses</a>
		<a href="Profile2.html">Account Settings</a>
		<a href="CoursesP.html">Couses Enrolled in</a>
		<a href="#">Discussion Forum</a>
		<a href=""><div>Progress Bar<div id="myProgress"><div id="myBar"></div></div></div></a>
	</nav>
		
	</div>

	

	
		<div class="text">
		<a href="SLogin.html"><h3><i class="fa fa-sign-out" aria-hidden="true"></i>  Sign Out</h3></a>
			<div class="Span">
			<a href="#" class="menu-toggle">
				<span></span>
				<span></span>
				<span></span>
			</a>
			</div>
			<input type="text" name="Search" class="Cen" placeholder="Search" id="new">
		</div>
	<div class="parent">
		<div class="image">
			<img src="image.jsp?imgid='<%=session.getAttribute("viewMail")%>'" width="200" height="200">
		</div>
		<h1><%=session.getAttribute("viewName")%></h1>
		<h1><%=session.getAttribute("viewDept")%></h1>
			<a href="#" class="toggle"><div class="CI">
				Courses Enrolled in &#9947;
			</div></a>
			<div class="navbar1">
                            <nav id="task">
					<!--<ul>Home</ul>
					<ul>Home</ul>
					<ul>Home</ul>
					<ul>Home</ul>-->
				</nav>
					
			</div>
	</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			var menu = "close";
			$('.menu-toggle').click(function(){
				if(menu == "close"){
					$('.navbar').css('-webkit-transform', 'translate(0,0)');
					$('.text').css('-webkit-transform', 'translate(18%,0)');
					menu = "open";
				}
				else{
					$('.navbar').css('-webkit-transform', 'translate(-100%,0)');
					$('.text').css('-webkit-transform', 'translate(0,0)');
					menu = "close";	
				}
			});
		});
	</script>
	<script type="text/javascript">
		$(document).ready(function(){
			var menu1 = "close";
			$('.toggle').click(function(){
				if(menu1 == "close"){
					$('.navbar1').css('-webkit-transform', 'translate(0,0)');
					$('.navbar1').css('display', 'block');
					menu1 = "open";
				}
				else{
					$('.navbar1').css('-webkit-transform', 'translate(0,-100%)');
					$('.navbar1').css('display', 'none');
					menu1 = "close";	
				}
			});
		});
	</script>
        <script>
            var i;
            <%
                ArrayList<String> viewCourseInfo=new ArrayList<String>();
                int noOfEnroll=Integer.parseInt((String)session.getAttribute("noOfUserEnroll"));
                viewCourseInfo=(ArrayList<String>)session.getAttribute("viewCourseInfo");
                for(int i=0;i<noOfEnroll;i++)
                {
            %>
            var noOfUserEnroll="<%=session.getAttribute("noOfUserEnroll")%>";
            
           
                var CourseName="<%=viewCourseInfo.get(i)%>";
                var div=document.createElement("ul");
                document.getElementById("task").appendChild(div);
                div.innerHTML='<ul>'+CourseName+'</ul';
            <%
                }
            %>
        </script>
</body>
</html>