<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<jsp:include page="/WEB-INF/include/include.jsp" />
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
			<spring:message code="app.loginPage.title"/>
		</TH>
	</TR>
	<TR VALIGN=TOP>
		<TD colspan="2">
		</TD>
	</TR>
	</TABLE>

	<form:form method="POST"  commandName="user" action="authUser">
<form:errors path="*" cssClass="errorblock" element="div" />

		<table>
			<tr>
				<td><spring:message code="app.username"/></td>
				<td><form:input path="username" /></td>
				<td><form:errors path="username" cssClass="error" element="div"/></td>
			</tr>
			<tr>
				<td><spring:message code="app.password"/></td>
				<td><form:password path="password" /></td>
				<td><form:errors path="password" cssClass="error" element="div" /></td>
			</tr>
			<tr>
				<td colspan="3"><input type="submit" value="submit"/></td>
			</tr>
		</table>
	</form:form>





</div>
<P STYLE="margin-bottom: 0cm"><BR>
</P>



</body>
</html>