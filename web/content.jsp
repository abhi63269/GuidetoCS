<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
	<title>Course</title>
	<link rel="stylesheet" type="text/css" href="css/Content.css">
	<link href="https://fonts.googleapis.com/css?family=Josefin+Sans" rel="stylesheet">
	<link rel="stylesheet" href="animate.css-master/animate.min.css">
        <style>
            #vbk{
	margin: 5vw;
	margin-bottom: 0vw;
	background-color: #2980b9;
	padding-left: 1vw;
	padding-right: 1vw;
	padding-top: 0.5vw;
	padding-bottom: 0.5vw;
	cursor: pointer;
        }
        #video h1{
	color:white;
	font-family: 'Josefin Sans', sans-serif;
}
#myProgress {
  width: 80%;
  background-color: #ddd;
  margin-left: 1.5vw; 
}

#myBar {
  width: 50%;
  height: 15px;
}

        </style>
</head>
<body>
	<div class="navbar">
	<h2> Sidebar Menu </h2>
	<nav>
		<a href="dashboard.jsp">Home</a>
		<a href="#insidetasks" onclick="show()">Courses</a>
		<a href="myProfile.jsp">Account Settings</a>
		<a href="mail.jsp">Discussion Forum</a>
                <a href=""><div>Progress Bar<div id="myProgress"><div id="myBar"></div></div></div></a>
                <a href="logout.jsp"><h3><i class="fa fa-sign-out" aria-hidden="true"></i>Sign Out</h3></a>
	</nav>
		
	</div>

	
		<div class="text">
			<div class="Span">
			<a href="#" class="menu-toggle">
				<span></span>
				<span></span>
				<span></span>
			</a>
			</div>

		</div>
		<div class="parent" id="parent">
			<h1><%=session.getAttribute("courseName")%></h1>
			<div class="desc">
				<p><%=session.getAttribute("courseDesc")%></p>
			</div>
				<div class="col1">
				<h1 style="float:left; margin-top: 2vw; margin-left: 5vw; color: #2980b9; ">Go to Videos</h1>
				<div class="animated bounceInDown">
					<a href="#video"><div class="col1inside" onclick="vid()">
						
					</div>
					</a>
				</div> 
				</div>
				<div class="col1">
				<h1 style="float:left; margin-top: 3vw; margin-left: 5vw; color: #2980b9; ">Refer Books</h1>
				<div class="animated bounceInUp">
					<a href="#book"><div class="col2inside" onclick="book()">
						<h1>E-Books</h1>
					</div>
					</a>
				</div>
				</div>
				<div class="col1">
                                        <form action="QuizServlet" method="GET">
					<input type="submit" name="quizbutton" id="qb" value="Proceed for Quiz &#8883;">
                                        </form>       
				</div>
		</div>
		<div id="video">
			<input type="button" name="bk" value="&laquo; Back" id="vbk" onclick="vbk()">
		</div>
		<div id="book">
			<input type="button" name="bk" value="&laquo; Back" id="vbk" onclick="vbk()">
		</div>
</body>
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
		function vid(){
			document.getElementById("parent").style.display="none";
			document.getElementById("video").style.display="block";
			document.getElementById("book").style.display="none";
		}
		function book(){
			document.getElementById("parent").style.display="none";
			document.getElementById("video").style.display="none";
			document.getElementById("book").style.display="block";
		}
                function vbk(){
			document.getElementById("parent").style.display="block";
			document.getElementById("video").style.display="none";
			document.getElementById("book").style.display="none";
		}
	</script>
	<script type="text/javascript">
            <%
                ArrayList<String>videoLink=(ArrayList<String>)session.getAttribute("videoLink");
                ArrayList<String>videoName=(ArrayList<String>)session.getAttribute("videoName");
                 System.out.println("chala bccc"+videoLink.get(0));
                 System.out.println("chala bccc"+videoName.get(0));
               String noOfvideos=(String)session.getAttribute("noOfvideos");
               int noOfVideos=Integer.parseInt(noOfvideos);
               System.out.println("chala bccc"+noOfVideos);
               for(int i=0;i<noOfVideos;i++)
               {
            %>
                var videoName="<%=videoName.get(i)%>";
                var videoLink="<%=videoLink.get(i)%>";
		 var div = document.createElement("div")
                 document.getElementById("video").appendChild(div);
                 div.innerHTML = '<div style="width:45%; height:45%; margin:1.4vw; text-align:center; float:left; background-color:cornflowerblue;"><h1 style="float:left;">'+videoName+'</h1><iframe width="560" height="315" src="'+videoLink+'" frameborder="0" allowfullscreen></iframe></div>';

                 <%
                     System.out.println("chala bccc2222");
               
                     }
                 %>
	</script>
	<script type="text/javascript">
            <%
                ArrayList<String>booksLink=(ArrayList<String>)session.getAttribute("booksLink");
                ArrayList<String>booksName=(ArrayList<String>)session.getAttribute("booksName");
               String noOfbooks=(String)session.getAttribute("noOfbooks");
               int noOBbooks=Integer.parseInt(noOfbooks);
               for(int j=0;j<noOBbooks;j++)
               {
            %>
                var booksName="<%=booksName.get(j)%>";
                var booksLink="<%=booksLink.get(j)%>";
		var div = document.createElement("div")
                div.innerHTML = '<a href='+booksLink+'><div class="a"><img src="Images/Book.jpg" style="height:150px; width:150px; margin:10px;"><h1>'+booksName+'</h1></div></a>';
                document.getElementById("book").appendChild(div);
                
                <%
                      }
                  %>
	</script>
</html>