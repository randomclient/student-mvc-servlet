<%@ include file="tag.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>(BUD002)Student Register</title>
<%@ include file="link.html" %>
<script type="text/javascript" src="javascript/general.js" ></script>
<script type="text/javascript" src="javascript/accordion-menu.js" ></script>
<script type="text/javascript">
    window.onload=function()
    {
        menu();
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
                    <td>Current Date</td><td>:  <%=new java.util.Date() %></td>
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
                <div class="search_form">
                    <h3>Student Register</h3>
                    <label id="errormsg" >${ error } </label>
                    <label id="errormsg" >${ msg } </label>
                    <br/><br/><br/>
                    <form action="StudentRegisterServlet" method="post">
                    <table class="tableForm">
                        <tr>
                            <td class="tblSingleLabel">Student No *</td>
                            <td class="tblSingleInput">
                                <input type="text" name="studentNo" class="txtlong" />
                            </td>
                        </tr>
                        <tr>
                            <td class="tblSingleLabel">Student Name *</td>
                            <td class="tblSingleInput">
                            <input type="text" name="studentName" class="txtlong" />
                        </tr>
                        <tr>
                            <td class="tblSingleLabel">Class Name *</td>
                            <td class="tblSingleInput">  
                                <select id="expenseType" class="normal_sel" name="className">
                                    <option></option>
                                    <c:forEach items="${ list }" var="c">
                                    <option value="${ c.className }">${ c.className }</option>
                                    </c:forEach>
                                </select>  
                            </td>                  
                        </tr>
                        <tr>
                            <td class="tblSingleLabel">Registered Date	 *</td>
                            <td class="tblSingleInput">  
                                <input type="datetime-local" name="registerDate" />
                            </td>                  
                        </tr>
                        <tr>
                            <td class="tblSingleLabel">Status *</td>
                            <td class="tblSingleInput">
                                <select id="expenseType" class="normal_sel" name="status">
                                    <option></option>
                                    <option>Attending</option>
                                    <option>Passed</option>
                                    <option>Failed</option>
                                </select>
                            </td>
                        </tr>
                        
                        
                    </table>
		              <br/>
                    <div id="btnGroup">
                    <input type="submit" value="Register" class="button"/>
                    </div>
                    </form>
                </div> 
            </div>
        </div>   
     </div>

    <div class="footer"> 
            <span>Copyright &#169; ACE Inspiration 2016</span>        
    </div>
</body>
</html>