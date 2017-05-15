<%@page import="model.DataQuiz"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>Quiz</title>
        <script type="text/javascript" src="http://code.jquery.com/jquery.min.js"></script>
	<style type="text/css">
		.container{
			width: 100%;
			height: 400px;
		}

		.inner{
			margin: auto;
			margin-top: 200px;
			
			height: 100%;
			width: 50%;
		}
		input{
			background-color: transparent;
			margin-left: 10%;
			border: none;
			margin-top: 10%;
		}
		input[type="radio"]{
			margin-top: 20px;
		}
		#next{
			width: 50px;
			height: 25px;
			border:2px solid black;
			float: right;
			margin-right: 20px;
		}
		#prev{
			width: 50px;
			height: 25px;
			border:2px solid black;
			float: left;
		}
                #submit{
                    border:2px solid black;
                    background-color: cornflowerblue;
                    margin-top: 6vw;
                    margin-left: 45vw;
                    width: 6vw;
                    height: 3vw;
                    color: white;
                }
	</style>
</head>
<body>
    <% 
        ArrayList<DataQuiz> list = (ArrayList<DataQuiz>) session.getAttribute("list");
        int k = (Integer) session.getAttribute("index");
        ArrayList<String> ans = (ArrayList<String>) session.getAttribute("ans");
    %>
    <div class="container">
        <div class="inner">
            
            <form action="OnNextPress" method="Post">
            <strong>Question </strong><%=(k+1)%><h3 id="q1"><%=list.get(k).Question()%></h3>
            <input type="radio" name="rad" id="i1" value="A"><label id="l1"><%=list.get(k).opt1()%></label><br>
            <input type="radio" name="rad" id="i2" value="B"><label id="l2"><%=list.get(k).opt2()%></label><br>
            <input type="radio" name="rad" id="i3" value="C"><label id="l3"><%=list.get(k).opt3()%></label><br>
            <input type="radio" name="rad" id="i4" value="D"><label id="l4"><%=list.get(k).opt4()%></label><br>
            
                <input type="submit" name="next" value="Next" id="next">
            </form>
            <form action="OnPrevPress" method="Post">
                <input type="submit" name="prev" value="Prev" id="prev">
            </form>
            <form action="Checker" method="Post">
            <input type="submit" value="Submit" id="submit"> 
            </form>
        </div>
    <script type="text/javascript">
      
        var x = '<%=ans.get(k)%>';
        switch (x)
              {
                  case 'A':
                  {
                      document.getElementById("i1").checked = true;
                      break;
                  }
                  case 'B':
                  {
                      document.getElementById("i2").checked  = true;
                      break;
                  }
                  case 'C':
                  {
                      document.getElementById("i3").checked  = true;
                      break;
                  }
                  case 'D':
                  {
                      document.getElementById("i4").checked  = true;
                      break;
                  }
                  default:
                  break;
                 }
              
    </script>
            
        <script type="text/javascript">
        $(document).ready(function(){
        $("input[type='submit']").click(function(){
        	var radioValue = $("input[name='rad']:checked").val();
                if(radioValue)
                {    
                window.location.replace("quiz.jsp?radioValue=" + radioValue);
                //window.location.href="quiz.jsp?radioValue=" + radioValue;
            }
        });
        
    });
</script>
        <% String rad = request.getParameter("radioValue");
        if(rad!=null)
        {
            //System.out.println("Value=" + rad);
            session.setAttribute("rad", rad);
            //session.setAttribute("ans", ans);
        }
        %>
        
        
        
    </div>
</body>
</html>