<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
	<title>Dashboard</title>
	<link rel="stylesheet" type="text/css" href="css/CustomDash.css">
	<link href="https://fonts.googleapis.com/css?family=Josefin+Sans" rel="stylesheet">
	<link rel="stylesheet" href="fonts/font-awesome/css/font-awesome.min.css">
        <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
        <link rel="stylesheet" href="/resources/demos/style.css">
        <script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.10.4/jquery-ui.js"></script>

<link rel="stylesheet" 
  href="//code.jquery.com/ui/1.10.4/themes/smoothness/jquery-ui.css">
<!-- User defied css -->
<link rel="stylesheet" href="style.css">
</head>
 <%
            Double result = (Double) session.getAttribute("result");
            double res;
            if(result==null)
            {
                res = 0;
            }
            else
            {
                res = result.doubleValue();
            }
  %>
<style type="text/css">
	.LOB{
	width: 100%;
	background-color: black;
	height: 55px;
	margin-bottom: 100px;
}

.search-container{
    margin-top: 0px;
    display:inline;
}

.ui-widget{
    margin-top: 0px;
    display:inline;
}

.search{
	margin-left: 500px;
	height: 30px;
	width: 200px;
	margin-left: 500px;
	border-radius: 5px;
	background-image: url(Images/Search.png);
	background-size: 20px 20px;
	background-position: left;
	padding-left: 30px;
	background-repeat:no-repeat;
	background-position: 2px 3px;
	color: black;
	display: inline;
}



.Course{
	border: 2px solid gray;
	width: 20%;
	height: 300px;
	margin-left: 135px;
	margin-top: 45px;
	border-radius: 10px; 
	text-align  : center;
	vertical-align: middle;
	box-shadow: 2px 3px 20px;
	font-family: 'Josefin Sans', sans-serif;
	float: left;
	font-size: 12px;
}

.Course:hover
{
	border:2px solid black;
}

.Circle{
	margin-top: 50px;
	margin: 0 auto;
	margin-top: 50px;
	border-radius: 100px;
	width: 100px;
	height: 100px;
	display: table;
	border: 2px solid black;
	background-image: url(Images/DS.gif);
	background-size: cover;
}

.EButton1
{
	background-color: #2ecc71;
	border: 1px solid darkgreen;
        width:100px;
	height: 40px;
	margin-left: 10px;
	margin-right: 10px;
	margin-top: 25px;
	font-size: 25px;
	color: white;
	border-radius: 2px;
	cursor: pointer;
	font-family: 'Source Sans Pro', sans-serif;
}

.EButton1:hover
{
	background-color: #27ae60;
}

.Line1
{
	margin-left: 65px;
	width: 80%;
}

.Heading
{
	margin-left: 65px;
	color: #2c3e50;
	font-family: 'Josefin Sans', sans-serif;
}

.text h3{
  display: inline-block;
  vertical-align: middle;
  margin: 1.1vw;
  color: rgba(255, 255, 255, 0.5);
  float: right;
}
#myProgress {
  width: 80%;
  background-color: #ddd;
  margin-left: 1.5vw;
}

#myBar {
  height: 15px;
  background-color: cornflowerblue;
}
</style>
<body>

	<div class="navbar">
	<h2> Sidebar Menu </h2>
	<nav>
		<a href="dashboard.jsp">Home</a>
		<a href="#insidetasks" onclick="show()">Courses</a>
		<a href="myProfile.jsp">Account Settings</a>
		<a href="mail.jsp" onclick="return confirm_alert(this);">Discussion Forum</a>
                <a href=""><div>Progress Bar<div id="myProgress"><div id="myBar"></div></div></div></a>
               <a href="logout.jsp"><h3><i class="fa fa-sign-out" aria-hidden="true"></i>Sign Out</h3></a>
	</nav>
		
	</div>

	
		<div class="text">
                    <a href="logout.jsp"><h3><i class="fa fa-sign-out" aria-hidden="true"></i>Sign Out</h3></a>
			<div class="Span">
			<a href="#" class="menu-toggle">
				<span></span>
				<span></span>
				<span></span>
			</a>
			</div>
                   
			<div class="search-container">
        <div class="ui-widget">
            <input type="text" id="search" name="search" class="search" placeholder="Search" onkeypress="handle(event)"/>
                
        </div>
</div>
                   
		</div>
    <script type="text/javascript">
        
	$(document).ready(function() {
     $(function() {
         $("#search").autocomplete({     
             
             source : function(request, response) {
               $.ajax({
                    url : "Controller",
                    type : "GET",
                    data : {
                           term : request.term
                    },
                    dataType : "json",
                    success : function(data) {
                          response(data);
                    }
             });
          }
      });
   });
});
</script>
<script>
    function handle(e){
        if(e.keyCode === 13){
            e.preventDefault(); // Ensure it is only this code that rusn
            var sear=document.getElementById("search").value;
            var url = "ViewProfileHttpServlet?sear="+sear;
            window.location.href =url;
        }
}
</script>

                
		<h3 class="Name">Welcome <%=session.getAttribute("uname")%> !</h3>
                
		<hr class="Line">
		<div class="container" id="container">
		<div class="Candiv"  style="float:left; background-color: white; border-radius: 10px; padding: 10px;" id="chart">
		<canvas id="myChart" width="400" height="150">
		</canvas>
		</div>
		<div style=" width:25%; height:100%; background-color: #ecf0f1; float:right;" id="rem">
			<div class="Aq">
				<div class="Nested">
                                    <form action="mail.jsp">
					<i class="fa fa-question-circle" aria-hidden="true" style=" margin-right: 5px;float:left;"></i>
					<h4 style="margin-bottom:10px; color:#16191F;">Discuss with us</h4>
					<h5 style="margin-bottom:10px; color:#34495e; font-weight:bold;">Clear your doubts and get the expert advice for every query and get the best experience.</h5>
                                        <input type="submit" name="askq" class="Askq" value="Go" onclick="return confirm_alert(this);"  style="width:5vw;">
                                    </form>
				</div>
				<div class="Nested">
					<i class="fa fa-share-square" aria-hidden="true" style=" margin-right: 5px;float:left;"></i>
					<h4 style="margin-bottom:10px; color:#16191F;">Refer a friend</h4>
					<h5 style="margin-bottom:10px; color:#34495e; font-weight:bold;">Tell your friends to join with us and we will help them too. Let them take the advantage of  this free and worthy service.</h5>
                                        <form name="myform" method="get" onsubmit="loadDoc()">
                                        <input type="text" name="usermail" placeholder="Mail of your friend" class="Query"><input type="submit" name="askq" class="Askq" value="Go">
                                        </form>
                                </div>
			</div>
		</div>
	</div>
	<div id="insidetasks" style="display:none;">
			
		</div>
     
  <!--<script src="https://code.jquery.com/jquery-1.12.4.js"/>-->
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"/>

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
        

	<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.5.0/Chart.min.js"></script>
		<script type="text/javascript">
                  
                        var coursenamee="<%=session.getAttribute("coursename")%>";
                        var coursenamee=coursenamee.substring(1,coursenamee.length-1);
                        var CourseName=coursenamee.split(',');
                        
                        //window.alert(coursenamee);
                        
                        var getCourseCount="<%=session.getAttribute("getCourseCount")%>";
                        var getCourseCount=getCourseCount.substring(1,getCourseCount.length-1);
                        var getCourseCoun=getCourseCount.split(',');
                        for(var i=0;i<CourseName.length;i++)
                        {
                            CourseName[i]='"'+CourseName[i]+'"';
                        }
                                                 
                         //window.alert(getCourseCoun);
		var canvas=document.getElementById('myChart');
		var data = {
    labels: CourseName,
    datasets: [
        {
            label: "My First dataset",
            backgroundColor: [
                'rgba(255, 99, 132, 0.2)',
                'rgba(54, 162, 235, 0.2)',
                'rgba(255, 206, 86, 0.2)',
                'rgba(75, 192, 192, 0.2)',
                'rgba(153, 102, 255, 0.2)',
                'rgba(255, 159, 64, 0.2)'
            ],
            borderColor: [
                'rgba(255,99,132,1)',
                'rgba(54, 162, 235, 1)',
                'rgba(255, 206, 86, 1)',
                'rgba(75, 192, 192, 1)',
                'rgba(153, 102, 255, 1)',
                'rgba(255, 159, 64, 1)'
            ],
            borderWidth: 1,
            data: getCourseCoun,
        }
    ]
};
var myLineChart = Chart.Bar(canvas,{
			data: data
		});

	</script>
        <script>
            $(document).ready(function(){
               $(".ui-autocomplete").fadeOut("slow"); 
            });
            
        </script>
	<script type="text/javascript">
        var status;
        var f=false;
            <%
          
           String numOfCourses= (String)session.getAttribute("numOfCourses");
         int NoOfRows= Integer.parseInt(numOfCourses);
        ArrayList<String> courseid= (ArrayList<String>)session.getAttribute("courseid");
        ArrayList<String> coursename=(ArrayList<String>)session.getAttribute("coursename");
        ArrayList<String> enrolledCourseID=(ArrayList<String>)session.getAttribute("enrolledCourseID");
         String  numOfCoursesEnroll= (String)session.getAttribute("numOfCoursesEnroll");
        int NoOfRows1= Integer.parseInt(numOfCoursesEnroll);
         System.out.println("JSPcourseid"+courseid);
        System.out.println("JSPcoursename"+coursename);
    System.out.println("JSPenrolledCourseID"+enrolledCourseID);
   
        for(int i=0;i<NoOfRows;i++)
        {
            
        
        %> 
        
        
        var div = document.createElement("div");
            var courseID="<%=courseid.get(i)%>";
            var courseName="<%=coursename.get(i)%>";
            div.id=courseID;
            var display="Enroll";
            <%
                for(int j=0;j<NoOfRows1;j++)
                {
                    %>
            var courseEnrollID="<%=enrolledCourseID.get(j)%>";
            if(courseEnrollID===courseID)
            {
                display="Go";
               f=true;
              
            }   
            <%
                }
            %>
              div.innerHTML = '<div class="Course"><div class="Circle"></div><h1 style="margin-top:20px;">'+courseName+'</h1><input type="submit" name="'+display+'"  class="EButton1" value="'+display+'&raquo"></div>';
               
                    document.getElementById("insidetasks").appendChild(div);
        
        <%
            }
           
            
        %>
            $("#insidetasks").on("click","div",function() {
                 Id = $(this).attr('id');
             
                 var proid=Id;
            var url = "CourseDisplayHttpServlet?proid="+proid;
            window.location.href =url;
                });
               
	</script>
	<script type="text/javascript">
		function show(){
			document.getElementById("insidetasks").style.display = "block";
			document.getElementById("container").style.display = "none";
			document.getElementById("rem").style.display = "none";
			$('.navbar').css('-webkit-transform', 'translate(-100%,0)');
					$('.text').css('-webkit-transform', 'translate(0,0)');
					menu = "close";
		}
	</script>
        <script type="text/javascript">
           <%System.out.println("dash board ="+res);%>
           document.getElementById("myBar").style.width=<%=res%>+"%";
           </script>
</body>
<script>
    
function loadDoc() {
    var email=document.forms["myform"]["usermail"].value;
  var xhttp = new XMLHttpRequest();
  xhttp.onreadystatechange = function() {
    if (this.readyState == 4 && this.status == 200) {
      alert("mail sent");
    }
  };
  xhttp.open("GET", "QueryHttpServlet?usermail="+email, true);
  xhttp.send();
}
</script>
<script>
    function confirm_alert(node) {
    return confirm("In order to send mail copy this link - https://www.google.com/settings/security/lesssecureapps and allow less secure access.");
}
</script>
</html>