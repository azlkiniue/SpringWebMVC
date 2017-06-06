<%@page import="com.program.models.FoodModel"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Item</title>
    <link rel="stylesheet" type="text/css" href="assets/css/bootstrap.min.css">
    <script src="assets/js/jquery-3.2.1.min.js"></script>
    <script src="assets/js/bootstrap.min.js"></script>
</head>
<body class="panel panel-info container">
  <h1 class="panel-heading">Form Edit Data</h1>
  <a class="btn btn-default" href="http://localhost:8080/SpringWebMVC/"><span class='glyphicon glyphicon-hand-left'></span> Kembali</a>
  <c:set var="food" value="${foodModel}"/>  
  <%
        FoodModel model = new FoodModel();
        model = (FoodModel) pageContext.getAttribute("food");
  %>
    <form class="panel-body" name="formUpdate" method="post" action="formUpdate">
      <input name="id" value="<%= model.getId() %>" hidden>
      <label>Nama Makanan:</label><br><input class="form-control" name="nama" type="text" value="<%= model.getNama() %>"><br>
      <label>Deskripsi:</label><br><input class="form-control" name="deskripsi" type="text" value="<%= model.getDeskripsi() %>"><br>
      <label>Rating:</label><br><input class="form-control" name="rating" type="number" value="<%= model.getRating() %>"><br>
<!--      <label>Gambar Makanan:</label><br>
            <p>Pilih gambar untuk di-upload: (Maks. 1 MB)</p><input type="file" id="myfiles" name="gambar" accept="image/*"><br>
                <script type="text/javascript">
                  $('#myfiles').bind('change', function() {
                    if(this.files[0].size/1024/1024 >= 1) alert('File terlalu besar, Maks. 1 MB');
                  });
                </script><br>-->
      <button class="btn btn-primary" type="submit"><span class="glyphicon glyphicon-floppy-disk"></span> Simpan</button>
    </form>
</body>
</html>
