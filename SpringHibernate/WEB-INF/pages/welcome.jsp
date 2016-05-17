<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<jsp:include page="/WEB-INF/include/include.jsp"></jsp:include>

<div align="center">
<TABLE WIDTH=60% BORDER=1 BORDERCOLOR="#aabbcc">
	<TR VALIGN=TOP>
		<TD WIDTH=50%>
			<spring:url value="/general/getAvailableRooms" var="fetchUrl"></spring:url>
			<a href="${fetchUrl}"><spring:message code="app.home.checkAvailability"/></a>

		</TD>
		<TD WIDTH=50%>
			<spring:url value="/login" var="fetchUrl"></spring:url>
			<a href="${fetchUrl}"><spring:message code="app.login"/></a>


		</TD>
	</TR>
</TABLE>
</div>
<P STYLE="margin-bottom: 0cm"><BR>
</P>



</body>
</html>