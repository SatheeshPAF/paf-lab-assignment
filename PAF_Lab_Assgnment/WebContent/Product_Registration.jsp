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
	<div class="container">
		<h2>Product Registration</h2>
		<form action="">
			<input id="hidMode" name="hidMode" type="hidden" value="save">
			<input id="hidID" name="hidID" type="hidden" value="0">
			<div class="form-group">
				<label for="text">Product Code : </label> <input type="text"
					class="form-control" id="productCode" name="productCode"
					placeholder="Enter Product Code">
			</div>
			<div class="form-group">
				<label for="text">Product Name : </label> <input type="text"
					class="form-control" id="productName" name="productName"
					placeholder="Enter Product Name">
			</div>
			<div class="form-group">
				<label for="text">Description : </label>
				<textarea class="form-control" id="description" name="description"
					placeholder="Product Description"></textarea>
			</div>
			<button type="submit" class="btn btn-default">Add New
				Product</button>
		</form>
	</div>
	<br />
</body>
</html>