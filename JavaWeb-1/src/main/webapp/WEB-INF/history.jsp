<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>     
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>訂單歷史紀錄</title>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/purecss@3.0.0/build/pure-min.css" >
	<link rel="stylesheet" href="/JavaWeb-1/css/button.css">

	</head>
		<body style="padding:20px">
			
				<fieldset>
					<legend>
						訂單歷史紀錄
					</legend>
					<table class="pure-table pure-table-bordered">
					<thead>
						<tr>
							<th>Index</th><th>Item</th><th>Delete</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach varStatus="row" var="dto" items="${orderDTOs}">
							<tr>
								<td>${row.count}</td>
								<td>${dto.message}</td>
								<td><a href ="/JavaWeb-1/order/delete?index=${row.index}" class="button-error pure-button">X</a></td>
								
							</tr>
						</c:forEach>
					</tbody>
					<tfoot>
						<tr style="background-color: #DDDDDD">
						<td></td>
						<td style="text-align: right;">總金額：${totalPrice}</td>
						<td colspan="2"></td>
						</tr>
					</tfoot>
					</table>
					<p/>
					<a href="/JavaWeb-1/index.jsp" class="pure-button pure-button-primary">回首頁</a>
				</fieldset>
		</body>
</html>