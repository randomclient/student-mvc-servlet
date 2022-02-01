<%@ include file="tag.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>(BUD002)Student Update</title>
<%@ include file="link.html"%>
<script type="text/javascript" src="javascript/general.js"></script>
<script type="text/javascript" src="javascript/accordion-menu.js"></script>
<script type="text/javascript">
	window.onload = function() {
		menu();
	};

	function deleteBudget() {
		var isOk = confirm("Are you sure to delete?");
		if (isOk) {
			window.location.replace("BUD001.html?flag=2");
		}
	}

	function update() {
		var con = confirm("Are you sure to update?");
		if (con) {
			window.location.replace("BUD001.html?flag=2");
		}
	}

	function showMessage() {
		var message = confirm("Are you sure to register?");
		if (message)
			document.getElementById("errormsg").innerHTML = "Registration completed.";
	}

	function addListData(source, destination) {
		var sourceList = document.getElementById(source.id);
		var sourceSelect = sourceList.selectedIndex;

		var len = sourceList.length;

		if (sourceSelect != -1) {
			for (i = 0; i < len; i++) {
				var isExist = false;
				var sourceText = sourceList.options[i].text;
				var destinationList = document.getElementById(destination.id);
				if (sourceList[i].selected) {
					for (var j = 0; j < destinationList.length; j++) {
						if (destinationList.options[j].text == sourceText) {
							isExist = true;
						}
					}
					if (!isExist) {
						destinationList.options[destinationList.length] = new Option(
								sourceText, "0");
					}
				}
			}
		}
	}
	function delListData(source) {
		var sourceList = document.getElementById(source.id);
		for (var index = 0; index < sourceList.length; index++) {
			if (sourceList[index].selected) {
				sourceList.remove(index);
				delListData(source);
			}
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
					<td>User</td>
					<td>: ${ auth.name }</td>
				</tr>
				<tr>
					<td>Current Date</td>
					<td>: <%=new java.util.Date() %></td>
				</tr>
			</table>
		</div>
		<input id="btn_logout" class="button" type="button" value="Logout"
			onclick="location.href='UserLogoutServlet'" />
	</div>

	<div id="container">
		<div id="left_menu">
			<!-- menu html code exist the menu function of general.js -->
		</div>
		<div id="main_contents">
			<div id="contents">
				<div class="search_form">
					<h3>Student Update</h3>
					<label id="errormsg"> ${ error } </label><br />
					<label id="errormsg"> ${ msg } </label><br />
					<br />
					<br />
					<form action="StudentUpdateServlet" method="post">
					<table class="tableForm">
						<tr height="30px">
							<td class="tblSingleLabel">Student No.</td>
							<td class="tblSingleInput">${ param.id }</td>
							<input type="hidden" name="studentNo" value="${ param.id }" />
						</tr>
						<tr>
							<td class="tblSingleLabel">Student Name *</td>
							<td class="tblSingleInput"><input type="text" name="studentName"
								value="${ param.name }" class="txtlong" /></td>
						</tr>

						<tr>
							<td class="tblSingleLabel">Class Name *</td>
							<td class="tblSingleInput"><select id="expenseType"
								class="normal_sel" name="className">
									<option></option>
									<c:forEach items="${ classlist }" var="cl">
									<option <c:if test="${param.cName==cl.className}">selected</c:if>>${ cl.className }</option>
									</c:forEach>
							</select></td>
						</tr>
						<tr>
							<td class="tblSingleLabel">Registered Date *</td>
							<td class="tblSingleInput">
							<input type="datetime-local" name="registerDate" value="${ param.date }" />
							</td>
						</tr>
						<tr>
							<td class="tblSingleLabel">Status *</td>
							<td class="tblSingleInput"><select id="expenseType"
								class="normal_sel" name="status">
									<option></option>
									<option
									<c:if test="${param.status=='Attending' }">selected</c:if>>Attending</option>
									<option <c:if test="${param.status=='Passed' }">selected</c:if>>Passed</option>
									<option <c:if test="${param.status=='Failed' }">selected</c:if>>Failed</option>
							</select></td>
						</tr>
					</table>
					<br />
					<div id="btnGroup">
						<input type="submit" value="Update" class="button"
							 /> <input type="button"
							value="Delete" id="delete" class="button" onclick="location.href='StudentDeleteServlet?id=${param.id}'"
							 /> <input
							type="button" value="Back" class="button"
							onclick="window.location.replace('BUD001.jsp?flag=2')" />
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
