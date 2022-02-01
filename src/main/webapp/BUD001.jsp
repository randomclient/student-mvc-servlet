<%@ include file="tag.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>(BUD001)Student Search</title>
<%@ include file="link.html"%>
<script type="text/javascript" src="javascript/general.js"></script>
<script type="text/javascript" src="javascript/accordion-menu.js"></script>
<script type="text/javascript">
	window.onload = function() {
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
					<td>User</td>
					<td>: ${ auth.name }</td>
				</tr>
				<tr>
					<td>Current Date</td>
					<td>: <%=new java.util.Date()%></td>
				</tr>
			</table>
		</div>
		<input id="btn_logout" class="button" type="button" value="Logout"
			onclick="location.href='UserLogoutServlet'">
	</div>

	<div id="container">
		<div id="left_menu">
			<!-- menu html code exist the menu function of general.js -->
		</div>
		<div id="main_contents">
			<div id="contents">
				<div class="search_form">
					<h3>Student Search Page</h3>
					<form action="StudentSearchServlet" method="post">
						<table class="tableForm">
							<tr>
								<td class="tblLabel">Student No.</td>
								<td class="tblInputShort"><input type="text"
									 name="id" class="txt" /></td>
								<td class="tblLabel">Student Name</td>
								<td class="tblInputShort"><input type="text"
									 name="name" class="txt" /></td>
								<tr />
								<tr>
									<td class="tblLabel">Class Name</td>
									<td class="tblInputNormal" colspan="3"><input type="text"
										id="companyName" name="className" class="txtlong" /></td>
								</tr>
						</table>
						<br /> <input type="submit" value="Search" class="button" /> <input
							type="button" value="Reset" class="button" /> <br />
						<br />
						<div id="errormsg">
							<label id="message">${ error }</label>
						</div>
					</form>
					<div id="list">
						<form name="listForm">
							<Br />
							<Br /> <br />
							<table class="resultTable">
								<c:if test="${stulist!=null}">
									<tr class="tblHeader">
										<th width="5%">No</th>
										<th width="10%">Student No</th>
										<th width="25%">Student Name</th>
										<th width="40%">Class Name</th>
										<th width="10%">Registered Date</th>
										<th width="10%">Status</th>
									</tr>
									
									<c:forEach items="${ stulist }" var="stu" varStatus="a">
									
									<tr>
										<td> ${ a.count }</td>
										<td> ${ stu.studentNo }</td>
										<td>
										<a href="BUD002-01.jsp?id=${stu.studentNo}&name=${stu.studentName}&cName=${stu.studentClass}&date=${stu.registerDate}&status=${stu.status}">
										${ stu.studentName } 
										</a></td>
										<td>${ stu.studentClass }</td>
										<td>${ stu.registerDate }</td>
										<td>${ stu.status }</td>
									</tr>
									</c:forEach>
								</c:if>
							</table>
							<br />

						</form>
					</div>
				</div>
			</div>
		</div>

	</div>

	<div class="footer">
		<span>Copyright &#169; ACE Inspiration 2016</span>
	</div>
</body>
</html>