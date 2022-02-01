<%@ include file="tag.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>(BUD003)Class Register</title>
<%@ include file="link.html" %>
<script type="text/javascript" src="javascript/general.js" ></script>
<script type="text/javascript" src="javascript/accordion-menu.js" ></script>
<script type="text/javascript">
    window.onload=function()
    {
        menu();     

    }
	
	function insert()
    {
        var con = confirm("Are you sure to register?");
        if(con)
        {
            document.getElementById('errormsg').innerHTML = "Successfully Saved!";
        }
        
    }

</script>
</head>
<body class="main_body">
 
    <div id="header">
        <div id="title">
            <a href="M00001.html">Student Registration Assignment</a>
        </div>
          <div id="menuLoginTime">
            <table>
                <tr>
                    <td>User</td><td>: ${ auth.name }</td>
                </tr>
                <tr>
                    <td>Current Date</td><td>:  <%=new java.util.Date() %>> </td>
                </tr>
            </table>
        </div>
        <input id="btn_logout" class="button" type="button" value="Logout" onclick="location.href='UserLogoutServlet'">    
    </div>

    <div id="container"> 
        <div id="left_menu">
                <!-- menu html code exist the menu function of general.js -->
        </div>
        <div id="main_contents"> 
			<div id="contents">
				<h3>Class Register</h3>
				<label id="errormsg" > ${ error } </label>
				<label id="errormsg" > ${ msg } </label>
				
				<br/><br/><br/>

				<form name="registerForm" action="ClassRegisterServlet" method="post">
					<table class="tableForm">
						<tr>
							<td class="tblSingleLabel"> Class ID *</td>
							<td class="tblSingleInput"><input type="text" id="txtUserId" class="txt_popup" name="classId"></td>
						</tr>
						<tr>
							<td class="tblSingleLabel">Class Name *</td>
							<td class="tblSingleInput"><input type="text" class="txtlong_popup" id="txtUserName" name="className"/></td>              
						</tr>
	 
					</table>
					<br/>
								
					<input type="submit" value="Register" class="button"/>
				</form>

				<br/><br/><br/>
			</div>
        </div>
            
    </div>

    <div class="footer"> 
            <span>Copyright &#169; ACE Inspiration 2016</span>        
    </div>
</body>
</html>