<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<style>
.error {
	color: #ff0000;
}
 
.errorblock {
	color: #000;
	background-color: #ffEEEE;
	border: 3px solid #ff0000;
	padding: 8px;
	margin: 16px;
}
</style>
</head>
 


<div align="center">
<TABLE WIDTH=20% BORDER=0 BORDERCOLOR="#aabbcc">
	<TR VALIGN=TOP>
		<TH colspan="2">
			User Login
		</TH>
	</TR>
	<TR VALIGN=TOP>
		<TD colspan="2">
		</TD>
	</TR>
	</TABLE>

	<form:form method="POST" commandName="user" action="authUser">
		<table>
			<tr>
				<td>Customer Name :</td>
				<td><form:input path="name" /></td>
				<td><form:errors path="name" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Customer Age :</td>
				<td><form:input path="age" /></td>
				<td><form:errors path="age" cssClass="error" /></td>
			</tr>
			<tr>
				<td colspan="3"><input type="submit" /></td>
			</tr>
		</table>
	</form:form>




</div>
<P STYLE="margin-bottom: 0cm"><BR>
</P>



</body>
</html>