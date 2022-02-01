<%@ include file="tag.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>(USR001) User Search</title>
<%@ include file="link.html"%>
<script type="text/javascript" src="javascript/general.js"></script>
<script type="text/javascript" src="javascript/accordion-menu.js"></script>
<script type="text/javascript">
	window.onload = function() {
		menu();
	}

	function resetForm() {
		document.getElementById('message').innerHTML = "Message";
		document.getElementById('list').style.display = "none";
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
					<td>: ${ sessionScope.auth.name }</td>
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
					<h3>User Search</h3>
					<form action="UserSearchServlet" method="post">
						<table class="tableForm">
							<tr>
								<td class="tblLabel"><label>User ID</label></td>
								<td class="tblInputNormal"><input type="text"
									id="txtUserId" class="txt" placeholder="uid-001" name="id" /></td>

								<td class="tblLabel">User Name</td>
								<td class="tblInputNormal"><input type="text"
									id="txtUserName" class="txt" placeholder="admin" name="name" />€€</td>

							</tr>
						</table>
						<br /> <input type="submit" value="Search" class="button" /> <a
							href="USR002.jsp"> <input type="button" value="Add"
							class="button" id="userInsert" />
						</a> <input type="button" value="Reset" onclick="resetForm()"
							class="button" />
					</form>
					<br /> <br />
					<div id="errormsg">
						<label id="message">${ requestScope.error }</label>
						<label id="message">${ msg }</label>
					</div>
				</div>

				<br /> <br /> <br />
				<div id="list">
					<form name="listForm" action="">
						<table class="resultTable">
							<c:if test="${ userlist != null }">
								<tr class="tblHeader">
									<th width="1%">Delete</th>
									<th width="1%">Update</th>
									<th width="12%">User ID</th>
									<th width="24%">User Name</th>

								</tr>
								<c:forEach items="${ userlist }" var="user">
									<tr>
										<td><input type="button" value="Delete" id="delete"
											class="button"
											onclick="location.href='UserDeleteServlet?id=${user.id}'" /></td>
										<td><a href="USR002-01.jsp?id=${user.id}&name=${user.name}&password=${user.password}"> <input type="button"
												value="Update" class="button" id="userUpdate" />
										</a></td>

										<td>${ user.id }</td>
										<td>${ user.name }</td>
									</tr>
								</c:forEach>
							</c:if>
						</table>
					</form>
				</div>

			</div>
		</div>

	</div>
	<div class="footer">
		<span>Copyright &#169; ACE Inspiration 2016</span>
	</div>
	</div>
</body>
</html>