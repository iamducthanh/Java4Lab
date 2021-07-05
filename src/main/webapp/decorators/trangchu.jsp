<%@include file="/commont/taglib.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><dec:title default="Lab java 4"></dec:title></title>
    <link href="<c:url value="/template/css/scrollbar.css"/>" rel="stylesheet" />
    <link href="<c:url value="/template/styles.css"/>" rel="stylesheet" />
    <link href="<c:url value="/template/sweetalert2.min.css"/>" rel="stylesheet" />
    <link href="https://cdn.datatables.net/1.10.20/css/dataTables.bootstrap4.min.css" rel="stylesheet" crossorigin="anonymous" />
    <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/js/all.min.js" crossorigin="anonymous"></script>
    <link href="<c:url value="/template/styleMe.css"/>" rel="stylesheet" />
    <link href="<c:url value="/template/css/listItem.css"/>" rel="stylesheet" />
</head>
<body class="sb-nav-fixed">
    <%@include file="/commont/header.jsp"%>
    <div id="layoutSidenav">
        <%@include file="/commont/menu.jsp"%>
        <div id="layoutSidenav_content">
            <main>
                <div class="container-fluid">
                    <dec:body></dec:body>
                </div>
            </main>
            <%@include file="/commont/footer.jsp"%>
        </div>
    </div>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
    <script src="<c:url value="/template/scripts.js"/>"></script>
    <script src="<c:url value="/template/js/validateDangKi.js" />"></script>
    <script src="<c:url value="/template/sweetalert2.all.min.js" />"></script>

</body>
</html>
