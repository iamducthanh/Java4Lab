<%@ taglib prefix="dec" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<%@include file="/commont/taglib.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><dec:title default="Đăng nhập"/></title>

    <link href="<c:url value="/template/login/all.min.css" />" rel="stylesheet" type="text/css">
    <link
            href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
            rel="stylesheet">
    <link href="<c:url value="/template/login/sb-admin-2.css" />" rel="stylesheet">
    <link href="<c:url value="/template/login/login.css" />" rel="stylesheet">
    <link href="https://cdn.datatables.net/1.10.20/css/dataTables.bootstrap4.min.css" rel="stylesheet"
          crossorigin="anonymous"/>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/js/all.min.js"
            crossorigin="anonymous"></script>
    <link href="<c:url value="/template/styleMe.css"/>" rel="stylesheet"/>
</head>
<body id="loginBack">
<div class="loader" style="display: none">
    <span class="fas fa-spinner xoay icon" style="color: #00aeff"></span>
</div>
<dec:body/>
<script src="<c:url value="/template/sweetalert2.all.min.js" />"></script>
<script src="<c:url value="/template/scripts.js"/>"></script>
<script src="<c:url value="/template/js/myscript.js"/>"></script>
</body>
</html>
