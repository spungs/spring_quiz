<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<style type="text/css">
<!--

a:link{color:black;font-family:sans-serif;text-decoration:none;}
a:visited{color:black;font-family:sans-serif;text-decoration:none;}
a:hover{color:#cc3300; font-weight:bold; }
a:active{color:#ff00cc; text-decoration:underline; }
-->
</style>

<table width=850>
	<tr><td align="center" colspan=5><h1>CARE Lab</h1></td></tr>
	<tr align="right">
		<td width=600></td>
		<td><a href="index?formpath=home">홈</a></td>
		<c:if test="${empty sessionScope.id }">
			<td><a href="index?formpath=login">로그인</a></td>
		</c:if>
		<c:if test="${not empty sessionScope.id }">
			<td><a href="logout">로그아웃</a></td>
		</c:if>
		<td><a href="index?formpath=member">회원가입</a></td>
		<td><a href="index?formpath=board">게시판</a></td>
	</tr>
	<tr><td align="center" colspan=5><hr/></td></tr>
</table>

