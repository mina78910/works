<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="sms.ItemDataBeans"
    import="java.util.List"
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品在庫管理ページ</title>
</head>
<body>
	<h1>商品登録はこちら</h1>
	<br>登録したい商品名と在庫数を入力してください
	<br>
	<form action="StockManager">
	<br>商品名：<input type="text" name="name">
	<br>
	<br>在庫数：<input type="text" name="stock">
	<br>
	<br><input type="submit" name="btnSubmit" value="登録">
	<%--推移元により処理を分岐させるためのhidden--%>
	<input type="hidden" name="from" value="from-stockmanager">
	</form>
			<% HttpSession hs = request.getSession();

			//ヒットしたレコードの集合体を呼び出す
		    List<ItemDataBeans> list = (List<ItemDataBeans>)session.getAttribute("resultData"); %>

	        <h1>商品在庫一覧</h1>
	        <table border=1>
	          <tr>
	             <th>商品ID</th>
	             <th>商品名</th>
	             <th>在庫</th>
	          </tr>

			<%-- ヒットしたレコードの集合体のリストをループで回して、出力--%>
			<% for(ItemDataBeans idb :list){%>
	           <tr>
	             <%--　<td><a href="ResultDetail?id=<%= dto.getUserID()%>"><%= dto.getName()%></a></td>　--%>
	             <td><%= idb.getItem_id()%></td>
	             <td><a href="Update?id=<%= idb.getItem_id()%>"><%= idb.getName()%></a></td>
	             <td><%= idb.getStock()%></td>
	           </tr>
			<%}%>
	        </table>



	<form action="Update" method="POST">
	<%System.out.println("stockmanager.jspの11");%>
	<input type="submit" name="btnSubmit" value="在庫変更画面へ">
	</form>
</body>
</html>