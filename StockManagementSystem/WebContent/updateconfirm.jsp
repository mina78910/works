<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="sms.ItemDataBeans"
%>
<%
HttpSession se = request.getSession();
ItemDataBeans willUpdateToDB = (ItemDataBeans)se.getAttribute("updatedData");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>在庫を登録します、よろしいですか？</h1>

	商品ID：<%=willUpdateToDB.getItem_id() %><br>
	商品名：<%=willUpdateToDB.getName() %><br>
	在庫数：<%=willUpdateToDB.getStock() %><br>

	<form action="UpdateResult" method="POST">
	<%System.out.println("updateconfirmの11");%>
	<input type="submit" name="btnSubmit" value="確認画面へ">
	</form>
</body>
</html>