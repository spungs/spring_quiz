<%@ page contentType="text/html; charset=UTF-8"%>

<script>
	var req
	function isExistId() { // 아이디 중복체크하는 함수
		req = new XMLHttpRequest();
		req.onreadystatechange = changeText
		req.open('post', 'isExistId')
		var reqData = document.getElementById('id').value
		req.send(reqData)
	}

	function changeText() {
		if (req.readyState == 4 && req.status == 200) {
			var isExistIdMsg = document.getElementById('isExistIdMsg')
			isExistIdMsg.innerHTML = req.responseText
		}
	}
	
	function sendAuth(){
		req = new XMLHttpRequest();
		req.onreadystatechange = Msg
		req.open('post', 'sendAuth')
		var reqData = document.getElementById('email').value
		req.send(reqData)
	}
	
	function checkAuth(){		// 인증번호를 확인하는 함수
		req = new XMLHttpRequest();
		req.onreadystatechange = Msg
		req.open('post', 'checkAuth')
		var reqData = document.getElementById('authNum').value
		req.send(reqData)
	}
	
	function Msg(){
		if (req.readyState == 4 && req.status == 200) {
			var Msg = document.getElementById('Msg')
			Msg.innerHTML = req.responseText
		}
	}
</script>

<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
	function daumPost() {
	    new daum.Postcode({
	        oncomplete: function(data) {
	            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.
				// 예제를 참고하여 다양한 활용법을 확인해 보세요.
	            
	            //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
	            if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
	                addr = data.roadAddress;
	            } else { // 사용자가 지번 주소를 선택했을 경우(J)
	                addr = data.jibunAddress;
	            }
	            // 우편번호와 주소 정보를 해당 필드에 넣는다.
	            document.getElementById('zipcode').value = data.zonecode;
	            document.getElementById("addr1").value = addr;
	            // 커서를 상세주소 필드로 이동한다.
	            document.getElementById("addr2").focus();
	        }
	    }).open();
	}
</script>
<center>
	<div align="center" style="height: 45">
		<font id="Msg" style="color: red; font-weight: bold; font-size: large;">${Msg }</font>
	</div>
	<form action="memberProc" method="post">
		<table border="1">
			<tr>
				<td align='right' height=40>아이디</td>
				<td><input type="text"t name='id' id="id" value="${member.id}" placeholder='id 입력' /></td>
				<td colspan="2"><input type="button" value="중복 확인"
					onclick="isExistId()"><font id="isExistIdMsg" color="red"
					style="margin-left: 5"></font></td>
			</tr>
			<tr>
				<td align='right' height=40>패스워드</td>
				<td><input type="password" name='pw' value="${member.pw}" placeholder='pw 입력' /></td>
				<td align='right'>패스워드 확인</td>
				<td><input type="password" name='pwOk' value="${member.pwOk}" placeholder='pw 입력' /></td>
			</tr>
			<tr>
				<td align='right' height=40>E-Mail</td>
				<td><input type=text name='email' id="email" value="${member.email}" placeholder='E-Mail 입력' /></td>
				<td colspan="2"><input type="button" value="인증번호 전송"
					onclick="sendAuth()"></td>
			</tr>
			<tr>
				<td align='right'>인증번호</td>
				<td><input type=text name='authNum' id="authNum" value="${member.authNum}" placeholder='인증번호 입력' /></td>
				<td colspan="2"><input type="button" value="인증번호 확인" onclick="checkAuth()"></td>
			</tr>
			<tr>
				<td align='right'>우편번호</td>
				<td><input type=text name='zipcode' id="zipcode" value="${post.zipcode}" readonly="readonly" /></td>
				<td colspan="2"><input type="button" value="우편번호 검색" onclick="daumPost()"></td>
			</tr>
			<tr>
				<td align='right'>주소</td>
				<td colspan="3"><input type=text name='addr1' id="addr1" value="${post.addr1}"
					readonly="readonly" style="width: 475px;" /></td>
			</tr>
			<tr>
				<td align='right'>상세주소</td>
				<td colspan="3"><input type=text name='addr2' id="addr2" value="${post.addr2}"
					style="width: 475px;" /></td>
			</tr>
			<tr>
				<td align='right' width=120>성 별</td>
				<td colspan="3">
				<input type=radio name='gender' value='n' checked="checked" />선택 안함 
				<input type=radio name='gender'	value='m' />남자 
				<input type=radio name='gender' value='w' />여자
				</td>
			</tr>

			<tr>
				<td align='center' height=40 colspan=4><input type="submit"
					value='회원 가입' style="width: 120px;" /> <input
					type=reset value='취소' style="width: 120px;" /></td>
			</tr>
		</table>
	</form>
</center>