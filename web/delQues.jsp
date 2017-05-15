
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Delete Question</title>
    </head>
    <%
        //ArrayList<String> que = (ArrayList<String>) session.getAttribute("que");
        //int max = (int) session.getAttribute("size");
    %>
    <body>
        <script type="text/javascript">
         
        </script>
        <p id="demo">cgn</p>

<script>
// Set the date we're counting down to
  var countDownDate = new Date(new Date().getHours()+ 1000).getTime();

// Update the count down every 1 second
var x = setInterval(function() {
 
  // Get todays date and time
  var now = new Date().getTime();
 
  // Find the distance between now an the count down date
   var distance = countDownDate - now;

  // Time calculations for days, hours, minutes and seconds
  var days = Math.floor(distance /  (1000 * 60 * 60 * 24));
  var hours = Math.floor((distance % (1000 *  60 * 60 * 24)) / (1000 * 60 * 60));
  var minutes = Math.floor((distance  % (1000 * 60 * 60)) / (1000 * 60));
  var seconds = Math.floor((distance  % (1000 * 60)) / 1000);

  // Display the result in the element with id="demo"
  document.getElementById("demo").innerHTML = days + "d " +  hours + "h "
  + minutes + "m " + seconds + "s ";

  // If the count down is finished, write some text 
  if (distance < 0) {
     clearInterval(x);
    document.getElementById("demo").innerHTML  = "EXPIRED";
  }
}, 1000);
 </script>
    </body>
</html>
