<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>     
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>訂單首頁</title>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/purecss@3.0.0/build/pure-min.css" >
	<link rel="stylesheet" href="/JavaWeb-1/css/button.css">

	</head>
		<body style="padding:20px">
			<form class="pure-form" method="post" action="/JavaWeb-1/order">
				<fieldset>
					<legend>
						訂單 
					</legend>
					品名：
					<select name="item">
						<option value="牛肉麵">牛肉麵</option>
						<option value="陽春麵">陽春麵</option>
						<option value="番茄麵">番茄麵</option>
						<option value="黑白切">黑白切</option>
					</select>
					<p/>
					<button type="submit" class="button-success pure-button">送出訂單</button>
				</fieldset>
			</form>
			<form class="pure-form" method="get" action="/JavaWeb-1/order">
				<button type="submit" class="button-secondary pure-button">查看歷史訂單</button>
			</form>
			<!-- <a href="/JavaWebOrder/order">查詢歷史訂單</a> 一樣ㄉ -->
		</body>
</html>