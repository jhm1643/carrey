<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="resources/css/noticeList.css">
<script type="text/javascript" src="resources/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="resources/js/noticeList.js"></script>
</head>
<body>
	<div class="title">공지사항</div>
	<div class="contents">
		<div class="divTable greenTable">
			<div class="divTableHeading">
				<div class="divTableRow">
					<div class="divTableHead"><input type="checkbox"></div>
					<div class="divTableHead">NO</div>
					<div class="divTableHead">제목</div>
					<div class="divTableHead">등록일자</div>
					<div class="divTableHead"></div>
				</div>
			</div>
			<c:forEach var="v" items="${noticeList}" varStatus="status">
			<div class="divTableBody">
				<div class="divTableRow">
					<div class="divTableCell"><input type="checkbox"></div>
					<div class="divTableCell">${status.index+1}</div>
					<div class="divTableCell">${v.notice_title}</div>
					<div class="divTableCell">${v.mod_date}</div>
					<div class="divTableCell"><input type="button" value="전송"></div>
				</div>
			</div>
			</c:forEach>
		</div>
		<div class="greenTable outerTableFooter">
			<div class="tableFootStyle">
				<div class="links">
					<a href="#">&laquo;</a>
					<a class="active" href="#">1</a>
					<a href="#">2</a>
					<a href="#">3</a>
					<a href="#">4</a>
					<a href="#">&raquo;</a>
				</div>
			</div>
		</div>
	</div>
	
	
</body>
</html>