<%@ include file="tag.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>(USR002)User Update</title>
<%@ include file="link.html" %>
<script type="text/javascript" src="javascript/general.js" ></script>
<script type="text/javascript" src="javascript/accordion-menu.js" ></script>
<script type="text/javascript">
    window.onload=function()
    {
        menu();     

    }
	
	function update()
    {
        var con = confirm("Are you sure to register?");
        if(con)
        {
            window.close();
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
                    <td>Current Date</td><td>:  YYYY/MM/DD hh:mm:ss</td>
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
				<h3>User Update</h3>
				<label id="errormsg" > ${ error } </label>
				<label id="errormsg" > ${ msg } </label>
				
				<br/><br/><br/>

				<form name="registerForm" action="UserUpdateServlet" method="post">
					<table class="tableForm">
						<tr>
							<td class="tblSingleLabel"> User ID *</td>
							<td class="tblSingleInput">${ param.id }</td>
							<input type="hidden" name="id" value="${ param.id }" />
						</tr>
						<tr>
							<td class="tblSingleLabel">User Name</td>
							<td class="tblSingleInput"><input type="text" class="txtlong_popup" id="txtUserName" name="name" value="${ param.name }"/></td>              
						</tr>
	 
						<tr>
							<td class="tblSingleLabel">Password *</td>
							<td class="tblSingleInput"><input type="password" class="txtlong_popup" id="txtUserName" name="password" value="${ param.password }"/></td>              
						</tr>
						<tr>
							<td class="tblSingleLabel">Confirm Password *</td>
							<td class="tblSingleInput"><input type="password" class="txtlong_popup" id="txtUserName" name="confirm"/></td>              
						</tr>
					</table>
					<br/>
								
					<input type="submit" value="Update" class="button"/>
					<input type="button" value="Back" class="button" onclick="window.location.replace('USR001.html')"/>
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