<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<style type="text/css">
<!--
a:link {color: black;font-family:sans-serif;text-decoration: none;}
a:visited {color: black;font-family: sans-serif;text-decoration: none;}
a:hover {color: #cc3300;font-weight: bold;}
a:active {color: #ff00cc;text-decoration: underline;}
-->
</style>

<table width=900>
	<tr>
		<td align="center" colspan=6><h1>CARE Lab</h1></td>
	</tr>
	<tr align="right">
		<td width=550></td>
		<td><a href="index?formpath=home">홈</a></td>
		<c:choose>
			<c:when test="${empty sessionScope.id }">
				<td><a href="${root }index?formpath=login">로그인</a></td>
			</c:when>
			<c:otherwise>
				<td><a href="logout">로그아웃</a></td>
			</c:otherwise>
		</c:choose>
				<td><a href="index?formpath=memberList">회원목록</a></td>
		<td><a href="index?formpath=member">회원가입</a></td>
		<td><a href="index?formpath=board">게시판</a></td>
	</tr>
	<tr>
		<td align="center" colspan=6><hr /></td>
	</tr>
</table>

