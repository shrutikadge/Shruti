<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<jsp:include page="/WEB-INF/include/include.jsp"></jsp:include>




<div align="right"><table><tr><td>    <spring:url value="/secure/logout" var="fetchUrl"></spring:url>
			<a href="${fetchUrl}">Logout</a>                                                                                           </td></tr>
<tr><td><p><br/></p></td></tr>
<tr><td><p><br/></p></td></tr>
</table></div> 


<div align="center">
<TABLE WIDTH=40% BORDER=1 BORDERCOLOR="#aabbcc">
<tr><td>Room has been allocated</td></tr>
<tr><td> <spring:url value="/secure/home" var="fetchUrl"></spring:url>
			<a href="${fetchUrl}">Home</a>                                         </td></tr>
</TABLE>