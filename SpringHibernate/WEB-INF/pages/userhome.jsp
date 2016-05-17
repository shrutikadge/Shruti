<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="/WEB-INF/include/include.jsp"></jsp:include>


<div align="right"><table><tr><td> <spring:url value="/secure/logout" var="fetchUrl"></spring:url>
			<a href="${fetchUrl}">Logout</a>                                                        </td></tr>
<tr><td><p><br/></p></td></tr>
<tr><td><p><br/></p></td></tr>
</table></div> 


<div align="center">Welcome to user home
<p />User : <c:out value="${user.username}"/>
<p />Select a menu to continue
<p />
<ul>
	<li><spring:url value="/general/getAvailableRooms" var="fetchUrl"></spring:url>
			<a href="${fetchUrl}">Check Room Availability</a>     </li>
	<li>  <spring:url value="/general/getAvailableRooms" var="fetchUrl"></spring:url>
			<a href="${fetchUrl}">Allocate Room</a>       </li>
	<li>    <spring:url value="/secure/getOccupiedRooms" var="fetchUrl"></spring:url>
			<a href="${fetchUrl}">Deallocate Room</a>     </li>
	
</ul>
</div>
<P STYLE="margin-bottom: 0cm"><BR>
</P>



</body>
</html>