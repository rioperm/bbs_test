<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript">
$(function() {
    $('.bbsWriteFormBtn').click(function() {
    	var form = $('#bbsWriteForm');
    	var titleCheck = $('#title').val();
    	var contentCheck = $('#content').val();
    	if(titleCheck==""||titleCheck==null){
    		alert("제목은 빈값을 넣을 수 없습니다.");
    		 $('#title').focus();
    	}else if(contentCheck==""||contentCheck==null){
    		alert("내용을 입력 해 주세요.");
    		$('#content').focus();
    	}else{
       		form.submit();
        	}
    	});
});
</script>
<h1>
	글쓰기
</h1>
	<form id="bbsWriteForm" action="/test/bbsWriteOk.do" method="post">
		<table>
			<tr>
				<td>제목</td>
				<td><input name="title" id="title" placeholder="제목 입력" size="30"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><input name="content" id="content" placeholder="내용 입력" size="30"></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="button" class="bbsWriteFormBtn" value="확인">
					<input type="reset" value="초기화">
					<input type="button" value="뒤로가기" Onclick="javascript:history.go(-1);">
				</td>
			</tr>
		</table>
		<input type="hidden" value="${viewPage}" name="viewPage" id="viewPage"/>
	</form>
