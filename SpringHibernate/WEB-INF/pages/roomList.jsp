<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<jsp:include page="/WEB-INF/include/include.jsp"></jsp:include>

<c:if test="${user != null}">
<div align="right"><table><tr><td>   <spring:url value="/secure/logout" var="fetchUrl"></spring:url>
			<a href="${fetchUrl}">Logout</a>                                                                                                    </td></tr>
<tr><td><p><br/></p></td></tr>
<tr><td><p><br/></p></td></tr>
</table></div> 
</c:if>

<% System.out.println(request.getAttribute("rooms")); %>
<div align="center">
<TABLE WIDTH=40% BORDER=1 BORDERCOLOR="#aabbcc">
<c:if test='${status =="A"}'>
<caption>Available Rooms</caption>
</c:if>
<c:if test='${status =="O"}'>
<caption>Occupied Rooms</caption>
</c:if>
<tr>
<th>Room Number</th>
<th>Room Type</th>
</tr>


<c:if test="${not empty rooms}">
        <c:forEach var="o" items="${rooms}">
            <tr>
            	<spring:url value="/secure/allocateRoom" var="allocateUrl">
            	<spring:param name="roomNumber" value="${o.roomNumber}"></spring:param>
            	</spring:url>
            	<spring:url value="/secure/deAllocateRoom" var="deAllocateUrl">
            	<spring:param name="roomNumber" value="${o.roomNumber}"></spring:param>
            	</spring:url>

                <td>${o.roomNumber} <c:choose>
			      <c:when test="${o.roomStatus == 'A'}">
                	<a href="${allocateUrl}">Allocate</a>
			      </c:when>
			
			      <c:otherwise>
			      	<a href="${deAllocateUrl}">Deallocate</a>
			      </c:otherwise>
				</c:choose></td>

                <td>${o.roomType.typeName}
                </td>
               
            </tr>
        </c:forEach>
</c:if>
<tr><td colspan="2" align="center"><spring:url value="/back" var="fetchUrl"></spring:url>
			<a href="${fetchUrl}">Back</a>  </td></tr>
</TABLE>
</div>
<P STYLE="margin-bottom: 0cm"><BR>
</P>



</body>
</html>