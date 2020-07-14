<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="sms.ItemDataBeans"
    %>
<%
	HttpSession se = request.getSession();
	ItemDataBeans willUpdateData = (ItemDataBeans)se.getAttribute("SearchedbyIdData");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>在庫変更画面</title>
</head>
<body>

	<h1>在庫変更画面</h1><br>

	<form action="UpdateConfirm" method="POST">

		商品ID：<%=willUpdateData.getItem_id() %><br>
		<input type="hidden" name="item_id" value="<%=willUpdateData.getItem_id()%>">
		商品名：<input type="text" name="name" value="<%=willUpdateData.getName() %>"><br>
		在庫数：<input type="text" name="stock" value="<%=willUpdateData.getStock() %>"><br><br><br>


	<%System.out.println("update.jspの12");%>
	<input type="submit" name="btnSubmit" value="変更確認へ">
	</form>

</body>
</html>