<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品管理ログイン画面</title>

</head>
<body>
<h1>商品在庫管理システムの作成</h1><br>
<h3>ここでは、商品在庫の一覧表示、商品登録、在庫管理を行うことができます。</h3><br>


	<form action="StockManager" method="POST">
		ユーザーID:<input type="text" name="user"><br>
		パスワード:<input type="text" name="pass"><br>
		
		
		
	<%System.out.println("送信ボタンの直前");%>
	<input type="submit" name="btnSubmit" value="ログインへ"><br>
	<%--推移元により処理を分岐させるためのhidden--%>
	<input type="hidden" name="from" value="from-index">
	</form>

	<a href="" >ユーザー新規登録</a><br>

<%System.out.println("indexの14");%>

</body>
</html>