<%@ page contentType="text/html; charset=UTF-8"%>

<script>
	var req
	function IsExistId() { // 아이디 중복체크하는 함수
		req = new XMLHttpRequest();
		req.onreadystatechange = changeText
		req.open('post', 'IsExistId')
		var reqData = document.getElementById('id').value
		req.send(reqData)
	}

	function changeText() {
		if (req.readyState == 4 && req.status == 200) {
			var IsExistIdMsg = document.getElementById('IsExistIdMsg')
			IsExistIdMsg.innerHTML = req.responseText
		}
	}
	
</script>
<center>
	<div align="center" style="height: 45">
		<font style="color: red; font-weight: bold; font-size: large;">${Msg }</font>
	</div>
	<form action="member" method="post">
		<table border="1">
			<tr>
				<td align='right' height=40>아이디</td>
				<td><input type=text name='id' id="id" value="${id}" placeholder='id 입력' /></td>
				<td colspan="2"><input type="button" value="중복 확인"
					onclick="IsExistId()"><font id="IsExistIdMsg" color="red"
					style="margin-left: 5"></font></td>
			</tr>
			<tr>
				<td align='right' height=40>패스워드</td>
				<td><input type=text name='pw' value="${pw}" placeholder='pw 입력' /></td>
				<td align='right'>패스워드 확인</td>
				<td><input type=text name='pwOk' value="${pwOk}" placeholder='pw 입력' /></td>
			</tr>
			<tr>
				<td align='right' height=40>E-Mail</td>
				<td><input type=text name='email' value="${email}" placeholder='E-Mail 입력' /></td>
				<td colspan="2"><input type="button" value="인증번호 전송"
					onclick="sendAuth()"></td>
			</tr>
			<tr>
				<td align='right'>인증번호</td>
				<td><input type=text name='authNum' placeholder='인증번호 입력' /></td>
				<td colspan="2"><input type="button" value="인증번호 확인"></td>
			</tr>
			<tr>
				<td align='right'>우편번호</td>
				<td><input type=text name='zipcode' readonly="readonly" /></td>
				<td colspan="2"><input type="button" value="우편번호 검색"></td>
			</tr>
			<tr>
				<td align='right'>주소</td>
				<td colspan="3"><input type=text name='addr1'
					readonly="readonly" style="width: 475px;" /></td>
			</tr>
			<tr>
				<td align='right'>상세주소</td>
				<td colspan="3"><input type=text name='addr2'
					style="width: 475px;" /></td>
			</tr>
			<tr>
				<td align='right' width=120>성 별</td>
				<td colspan="3"><input type=radio name='gender' value='n'
					checked="checked" />선택 안함 <input type=radio name='gender'
					value='m' />남자 <input type=radio name='gender' value='w' />여자</td>
			</tr>

			<tr>
				<td align='center' height=40 colspan=4><input type="submit"
					value='회원 가입' style="width: 120px;" /> <input
					type=reset value='취소' style="width: 120px;" /></td>
			</tr>
		</table>
	</form>
</center>