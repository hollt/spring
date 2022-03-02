<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center"></div>
		<div><h1>게시글 상세</h1></div>
		<c:if test="${empty notice.noticeId }">
			<h1>선택한 게시글이 존재하지 않습니다</h1>
		</c:if>
		<c:if test="${not empty notice.noticeId }">
			<div>
				<table border="1">
					<tr>
						<th width="100">작성자</th>
						<td align="center" width="150">${notice.noticeWriter }</td>
						<th width="100">작성일자</th>
						<td align="center" width="150">${notice.noticeDate }</td>
					</tr>
					<tr>
						<th>제목</th>
						<td colspan="3">${notice.noticeTitle }</td>	
					</tr>
					<tr>
						<th>내용</th>
						<td colspan="3">
						 	<textarea rows="10" cols="80">${notice.noticeSubject }</textarea>
						</td>
					</tr>	
				</table>
			</div>
		</c:if><br>
		<div>
			<button type="button" onclick="location.href='noticeList.do'">목록가기</button>
		</div>
</body>
</html>