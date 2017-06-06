<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Item</title>
    <link rel="stylesheet" type="text/css" href="assets/css/bootstrap.min.css">
    <script src="assets/js/jquery-3.2.1.min.js"></script>
    <script src="assets/js/bootstrap.min.js"></script>
</head>
<body class="panel panel-info container">
  <h1 class="panel-heading">Edit Gambar Makanan</h1>
  <a class="btn btn-default" href="http://localhost:8080/SpringWebMVC/"><span class='glyphicon glyphicon-hand-left'></span> Kembali</a>
  <%
        int id = Integer.parseInt(request.getParameter("id"));
  %>
    <form class="panel-body" name="updateItem" method="post" enctype="multipart/form-data" action="formUpload">
      <input name="id" value="<%= id %>" hidden>
            <label>Gambar Makanan:</label><br>
            <p>Pilih gambar untuk di-upload: (Maks. 1 MB)</p><input type="file" id="myfiles" name="file" accept="image/*"><br>
                <script type="text/javascript">
                  $('#myfiles').bind('change', function() {
                    if(this.files[0].size/1024/1024 >= 1) alert('File terlalu besar, Maks. 1 MB');
//                    var name = $('#myfiles').val();
//                    window.history.pushState(null, '', "http://localhost:8080/SpringWebMVC/formUpload.jsp?id=<%= id %>&filename="+name);
                  });
                </script><br>
      <button class="btn btn-primary" type="submit"><span class="glyphicon glyphicon-floppy-disk"></span> Simpan</button>
    </form>
</body>
</html>
