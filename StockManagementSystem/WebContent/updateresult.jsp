<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="sms.ItemDataBeans"%>
<%
HttpSession se = request.getSession();
//updateConfirmのbeansを流用
ItemDataBeans willUpdateToDB = (ItemDataBeans)se.getAttribute("updatedData");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>変更完了画面</title>
</head>
<body>
<h1>在庫の登録が完了しました</h1>

	商品ID：<%=willUpdateToDB.getItem_id() %><br>
	商品名：<%=willUpdateToDB.getName() %><br>
	在庫数：<%=willUpdateToDB.getStock() %><br>

	<a href="index.jsp" >トップへ戻る</a><br>


</body>
</html>