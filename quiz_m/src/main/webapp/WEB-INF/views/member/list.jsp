<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<center>
	<c:choose>
		<c:when test="${empty members }">
			등록된 회원이 없습니다.
		</c:when>
		<c:otherwise>
			<table width="800" border="1">
				<tr height="50">
					<th>아이디</th>
					<th>이메일</th>
					<th>성별</th>
				</tr>
				<c:forEach var="member" items="${members }">
				<tr height="50">
					<th>${member.id }</th>
					<th>${member.email }</th>
					<th>${member.gender }</th>
				</tr>
				</c:forEach>
			</table>
		</c:otherwise>
	</c:choose>
</center>