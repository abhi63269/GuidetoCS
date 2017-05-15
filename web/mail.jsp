<!DOCTYPE html>
<html>
<head>
	<title>Ask a query</title>
	<link rel="stylesheet" type="text/css" href="css/Mailcss.css">
	<link href="https://fonts.googleapis.com/css?family=Josefin+Sans" rel="stylesheet">
</head>
<style>
    #Ip3{
	height: 25px;
	width: 300px;
	padding-left: 20px;
	margin-left: 50px;
}
</style>
<body>
<div class="parent">
<h1>Discussion Panel</h1>
	<div class="inner">
            <form action="SendMailHttpServlet" method="get">
		<table border="0" width:100%;>
			<tr>
				<th><h3>To:</h3></th>
                                <td id="dd"><input autocomplete="off" id="Ip3" placeholder="Choose Mentor" name="mentormailname" list="sel">
                                    
                                </td>
			</tr>
			<tr>
				<th><h3>From:</h3></th>
                                <td><input type="email" name="from" value="<%=session.getAttribute("umail")%>" readonly></td>
			</tr>
                        <tr>
				<th><h3>Gmail Password:</h3></th>
                                <td><input type="password" name="gpassword" placeholder="Enter Gmail Password"</td>
			</tr>
			<tr>
				<th><h3>Subject:</h3></th>
				<td><input type="text" autocomplete="off" name="subject"></td>
			</tr>
			<tr>
				<th><h3>Query:</h3></th>
				<td><textarea type="email" name="uiux"  rows="20" cols="10"></textarea></td>
			</tr>
		</table>
		<input type="submit" name="Send" value="Send">
	</form>
	</div>
</div>
                        <input type="hidden" name="mentormailname" id="mentormailname">
</body>
<script type="text/javascript">
	$('#form').find('.input').keypress(function(e){
    if ( e.which == 13 ) // Enter key = keycode 13
    {
        $(this).next().focus();  //Use whatever selector necessary to focus the 'next' input
        return false;
    }
});
</script>
<script type="text/javascript">
    var dataMentor="<%=session.getAttribute("dataMentor")%>";
                        var dataMentor=dataMentor.substring(1,dataMentor.length-1);
                        var DataMentor=dataMentor.split(',');
                        
	var choices = DataMentor;
    var newDiv = document.createElement('div');
    var selectHTML = "";
    selectHTML='<datalist id="sel">';
    for(i = 0; i < choices.length; i = i + 1) {
        selectHTML += "<option  value='" + choices[i] + "'>" + choices[i] + "</option>";
    }
    selectHTML += "</datalist>";
    newDiv.innerHTML = selectHTML;
    document.getElementById("dd").appendChild(newDiv);
    //var e=document.getElementById("sel");
    //var userName=e.options[e.selectedIndex].value;
    document.getElementById("mentormailname").value=$("sel option:selected").text();
</script>

</html>