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
    <title>Tìm người dùng yêu thích video</title>
</head>
<body>
<br/>
<%@include file="/commont/errorAlert.jsp"%>
<form class="user" method="post" style="width: 40%">
    <div class="form-group">
        <input type="text" class="form-control form-control-user"
               id="exampleInputEmail" aria-describedby="emailHelp"
               placeholder="Tìm theo id của video" name="videoid" value=${videoid}>
    </div>
    <button style="width: 120px" type="submit" formaction="<c:url value="/lab6/find-user-by-video"/>" class="btn btn-primary btn-user btn-block">
        Tìm kiếm
    </button>
    <hr>
</form>
<div class="card shadow mb-4" style="width: 100%;">
    <div class="card-header py-3">
        <h6 class="m-0 font-weight-bold text-primary">Danh sách người dùng tìm thấy</h6>
    </div>
    <div class="card-body">
        <div class="table-responsive">
            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                <thead>
                <tr>
                    <th>Username</th>
                    <th>Fullname</th>
                    <th>Email</th>
                    <th>Role</th>
                </tr>
                </thead>
                <tfoot>
                <tr>
                    <th>Username</th>
                    <th>Fullname</th>
                    <th>Email</th>
                    <th>Role</th>
                </tr>
                </tfoot>
                <tbody>
                <c:forEach var="userItem" items="${listUser}">
                    <tr>
                        <td>${userItem.username}</td>
                        <td>${userItem.fullname}</td>
                        <td>${userItem.email}</td>
                        <td>${userItem.role}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>
