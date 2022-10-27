<%@ page contentType="text/html; charset=UTF-8"%>

<center>
	<div align="center" style="height: 45">
		<font style="color: red; font-weight: bold; font-size: large;">${Msg }</font>
	</div>
	<form action="loginProc" method="post">
		<table>
			<tr>
				<td>아이디</td>
				<td><input type=text name='id' value="${id }" placeholder='ID 입력' /></td>
			</tr>
			<tr>
				<td>패스워드</td>
				<td><input type=password name='pw' placeholder='PW 입력' /></td>
			</tr>
			<tr>
				<td colspan=2 align='center'><input type=submit value='로그인'
					style="width: 86px;" /> <input type=reset value='취소'
					style="width: 86px;" /></td>
			</tr>
		</table>
	</form>
</center>
