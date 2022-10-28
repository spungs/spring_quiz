<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<body>
<div align="center">
<table style="width:800px;">
<tr>
	<td style="height:100px;"><%@ include file="common/top.jsp" %></td>
</tr>
<tr>
	<c:choose>
		<c:when test="${param.formpath == null or param.formpath == 'home'}">
			<td style="height:400px;"><%@ include file="home.jsp" %></td>
		</c:when>
		<c:when test="${param.formpath == 'login'}">
			<td style="height:400px;"><%@ include file="member/loginForm.jsp" %></td>
		</c:when>
		<c:when test="${param.formpath == 'member'}">
			<td style="height:400px;"><%@ include file="member/memberForm.jsp" %></td>
		</c:when>
		<c:when test="${param.formpath == 'board'}">
			<td style="height:400px;"><%@ include file="board/boardForm.jsp" %></td>
		</c:when>
		<c:when test="${param.formpath == 'memberList'}">
			<td style="height:400px;"><%@ include file="member/memberListForm.jsp" %></td>
		</c:when>
	</c:choose>
</tr>
<tr>
	<td style="height:50px;"><%@ include file="common/footer.jsp" %></td>
</tr>
</table>
</div>
</body>
</html>