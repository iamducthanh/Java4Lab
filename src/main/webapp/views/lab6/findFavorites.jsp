<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 7/12/2021
  Time: 5:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@include file="/commont/taglib.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tìm video yêu thích theo người dùng</title>
</head>
<body>
<br/>
<%@include file="/commont/errorAlert.jsp"%>
<form class="user" method="post" style="width: 40%">
    <div class="form-group">
        <input type="text" class="form-control form-control-user"
               id="exampleInputEmail" aria-describedby="emailHelp"
               placeholder="Tên người dùng" name="username" value=${username}>
    </div>
    <button style="width: 120px" type="submit" formaction="<c:url value="/lab6/find-favorites-by-username"/>" class="btn btn-primary btn-user btn-block">
        Tìm kiếm
    </button>
    <hr>
</form>
<div class="card shadow mb-4" style="width: 100%;">
    <div class="card-header py-3">
        <h6 class="m-0 font-weight-bold text-primary">Danh sách nhưng video yêu thích theo người sử dụng</h6>
    </div>
    <div class="card-body">
        <div class="table-responsive">
            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Title</th>
                    <th>Poster</th>
                    <th>Description</th>
                    <th>Active</th>
                    <th>Views</th>
                </tr>
                </thead>
                <tfoot>
                <tr>
                    <th>ID</th>
                    <th>Title</th>
                    <th>Poster</th>
                    <th>Description</th>
                    <th>Active</th>
                    <th>Views</th>
                </tr>
                </tfoot>
                <tbody>
                <c:forEach var="videoItem" items="${listVideo}">
                    <tr>
                        <td>${videoItem.id}</td>
                        <td>${videoItem.title}</td>
                        <td>${videoItem.poster}</td>
                        <td>${videoItem.description}</td>
                        <td>${videoItem.active}</td>
                        <td>${videoItem.views}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
<%--<c:if test="${not empty listVideo}">--%>
<%--    --%>
<%--</c:if>--%>
</body>
</html>
