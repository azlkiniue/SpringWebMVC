<%@page import="java.util.ArrayList"%>
<%@page import="com.program.models.FoodModel"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JDBC: Food Edition</title>
    <link rel="stylesheet" type="text/css" href="/SpringWebMVC/assets/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="<c:url value="/assets/css/bootstrap-rating.css"/>">
    <script src="<c:url value="/assets/js/jquery-3.2.1.min.js"/>"></script>
    <script src="<c:url value="/assets/js/bootstrap.min.js"/>"></script>
    <script src="<c:url value="/assets/js/bootstrap-rating.min.js"/>"></script>
</head>
<style>
/*    .thumbnail {
  position: relative;
  width: 256px;
  height: 256px;
  overflow: hidden;
}
.thumbnail img {
  position: relative;
  left: 50%;
  top: 50%;
  -webkit-transform: translate(-50%,-50%);
      -ms-transform: translate(-50%,-50%);
          transform: translate(-50%,-50%);
}*/
    .thumbnail{
        min-height: 500px;
        max-height: 500px;
    }
    .thumbnail>img{
        width: 256px;
        height: 256px;
        overflow: hidden;
        background-size: cover;
        background-position: center center;
    }
</style>
<body>
  <div class="container">
    <div class="jumbotron">
      <h1 class="text-center">Your Own Food Almanac</h1>
    </div>
    <c:set var="food" value="${foodModel}"/>
    <%
        ArrayList<FoodModel> dataList = (ArrayList<FoodModel>) pageContext.getAttribute("food");
        String a = "/SpringWebMVC/";//(String) pageContext.getAttribute("file");
        int i = 1;
            if (dataList != null) {
                out.println("<div class='row match-my-cols'>");
                for (FoodModel model : dataList) {
                    if(model.getId()%4==0) out.println("<div class='row match-my-cols'>");
                    if(model.getId()-1==0) out.println("<div class='col-sm-12 col-md-3'>"+
                                    "<div class='thumbnail'>"+
                                        "<img class='image-responsive' src='/SpringWebMVC/file/default.png' style='width: 100%'>"+
                                        "<div class='caption'><br><br>"+
                                            "<a class='btn btn-primary btn-lg' href='/SpringWebMVC/formAdd'>"+
                                                "<span class='glyphicon glyphicon-plus-sign'></span> Tambah Data"+
                                            "</a>"+
                                        "</div>"+
                                    "</div>"+
                                "</div>");
                    out.println("<div class='col-sm-12 col-md-3'>"+
                                    "<div class='thumbnail'>"+
                                        "<img src='" + a + model.getGambar() + "' onclick='location.href=\"http://localhost:8080"+ a +"formUpload?id="+model.getId()+"\"' >"+
                                        "<div class='caption'>"+
                                            "<h3>"+ model.getNama() +"</h3>"+
                                            "<input class='rating' data-readonly='' value='"+ model.getRating() +"' type='hidden'>"+
                                            "<p style='margin-top: 10px'>"+ model.getDeskripsi() +"</p>"+
                                            "<div class='btn-group text-center'>"+
                                                "<a class='btn btn-info' href='http://localhost:8080/SpringWebMVC/formUpdate?id=" + model.getId() + "'>" +
                                                    "<span class='glyphicon glyphicon-edit'></span> Edit" +
                                                "</a>" +
                                                "<button type='button' class='btn btn-danger' data-toggle='modal' data-target='#myModal" + model.getId() + "'>" +
                                                    "Hapus <span class='glyphicon glyphicon-trash'></span>" +
                                                "</button>" +
                                            "</div>"+
                                        "</div>"+
                                    "</div>"+
                                "</div>");
                    if((model.getId()+1)%4==0) out.println("</div>");
                    i=model.getId();
                }
                if(i%4!=0) out.println("</div>");

                for (FoodModel model : dataList) {
                    out.println("<div id='myModal"+model.getId()+"' class='modal fade' role='dialog'>" +
                                "<div class='modal-dialog'>" +
                                    "<div class='modal-content'>" +
                                        "<div class='modal-header'>" +
                                            "<button type='button' class='close' data-dismiss='modal'>&times;</button>"+
                                            "<h4 class='modal-title'>Konfirmasi</h4>"+
                                        "</div>"+
                                        "<div class='modal-body'>"+
                                            "<p>Apakah anda yakin ingin menghapus?</p>"+
                                        "</div>"+
                                        "<div class='modal-footer'>"+
                                            "<a class='btn btn-danger' href='deleteItem?id=" + model.getId() + "'>" +
                                                "Ya" +
                                            "</a>" +
                                            "<button type='button' class='btn btn-info' data-dismiss='modal'>Tidak</button>"+
                                        "</div>"+
                                    "</div>"+
                                "</div>"+
                            "</div>");
                }
            }
            else out.println("<script> alert('Data Kosong!'); </script>");
    %>
    <br>
  </div>
</body>
</html>
