<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:if test="${empty sessionScope.id }">
	<script>
		location.href = 'index?formpath=login';
	</script>
</c:if>

<script>
	function update() {
		var id = document.getElementById('id').value
		location
	}
</script>
<center>
	<c:choose>
		<c:when test="${empty members }">
			등록된 회원이 없습니다.
		</c:when>
		<c:otherwise>
			<table width="450">
				<thead>
					<tr>
						<td style="width: 120px; height: 20px;" align="center">아이디</td>
						<td style="width: 280px; height: 20px;" align="center">이메일</td>
						<td style="width: 50px; height: 20px;" align="center">성별</td>
					</tr>
				</thead>
				<tr>
					<td style="width: 120px; height:20px;" align="center"><hr/></td>
					<td style="width: 280px; height:20px;" align="center"><hr/></td>
					<td style="width: 50px; height:20px;" align="center"><hr/></td>
				</tr>
				<c:forEach var="member" items="${members }">
					<tr>
						<td style="width: 120px; height:40px;" align="center"><a href="userInfoProc?id=${member.id}">${member.id }</a></td>
						<td style="width: 120px; height:40px;" align="center">${member.email }</td>
						<td style="width: 120px; height:40px;" align="center">${member.gender }</td>
					</tr>
				</c:forEach>
			</table>
			이전 1 2 3 4 다음
			<table>
			<tr>
			<td>
				<select>
					<option>아이디</option>
					<option>이메일</option>
				</select>
				<input type="text" name="search">
				<input type="button" name="searchBtn" value="검색" style="width: 80px;">
			</td>
			</tr>
			</table>
		</c:otherwise>
	</c:choose>
</center>