<%-- 
    Document   : formAdd
    Created on : May 30, 2017, 12:35:41 PM
    Author     : Diknas 113
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Add Item</title>
    <link rel="stylesheet" type="text/css" href="assets/css/bootstrap.min.css">
    <script src="assets/js/jquery-3.2.1.min.js"></script>
    <script src="assets/js/bootstrap.min.js"></script>
</head>
<body class="panel panel-primary container">
  <h1 class="panel-heading">Form Insert Data</h1>
  <a class="btn btn-default" href="http://localhost:8080/SpringWebMVC/"><span class='glyphicon glyphicon-hand-left'></span> Kembali</a>
  <form class="panel-body" name="addItem" method="post" action="formAdd">
      <label>Nama Makanan:</label><br><input class="form-control" name="nama" type="text"><br>
      <label>Deskripsi:</label><br><input class="form-control" name="deskripsi" type="text"><br>
      <label>Rating:</label><br><input class="form-control" name="rating" type="number"><br><br>
      <button class="btn btn-primary" type="submit"><span class="glyphicon glyphicon-plus-sign"></span> Tambah</button>
  </form>
</body>
</html>

