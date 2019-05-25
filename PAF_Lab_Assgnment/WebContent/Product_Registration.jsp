<%@page import="C.ProductController"%>
<%@page import="java.util.Date"%>
<%@page import="M.ProductModel"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*"%>
<%
	ProductModel proMo = ProductModel.getInstance();
	ProductController proCo = ProductController.getInstance();
	proMo.setProductCode(request.getParameter("productCode"));
	proMo.setProductName(request.getParameter("productName"));
	proMo.setDescription(request.getParameter("description"));
	proMo.setStatus(1);
	proMo.setDateTime(new Date().toString());
	String productGrid = "";
	String crudFeedback = "";

	if (request.getParameter("hidMode") != null && request.getParameter("hidMode").equalsIgnoreCase("save")) {
		crudFeedback = proCo.saveNewProduct();
	}
	productGrid = proCo.getProductDetails();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!--head code meta tag-->
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- css files -->
<link href="css/bootstrap.min.css" rel="stylesheet">

<!-- javascript files -->
<script src="js/jquery-3.4.1.min.js" type="text/javascript"></script>
<script src="js/popper.min.js" type="text/javascript"></script>

<title>Product Registration</title>
</head>
<body>
	<form id="formItems" action="item.jsp" method="post">
		<input id="hidMode" name="hidMode" type="hidden" value="save">
		<input id="hidID" name="hidID" type="hidden" value="0"> Item
		Name: <input id="txtItemName" name="txtItemName" type="text">
		<br /> Item Description <input id="txtItemDesc" name="txtItemDesc"
			type="text"> <br /> <input id="btnSave" name="btnSave"
			type="button" value="Save"> <br />
		<div id="divStsMsgItem">
			<%
				out.println(rudFeedback);
			%>
		</div>
		<%
			out.println(itemGrid);
		%>
	</form>
	<br />
</body>
</html>