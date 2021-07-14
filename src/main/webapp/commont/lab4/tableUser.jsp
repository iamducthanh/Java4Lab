<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/commont/taglib.jsp"%>

<h4 style="margin-top: 30px">Danh sách người dùng</h4>
<div class="card shadow mb-4" style="width: 100%;">
    <div class="card-header py-3">
        <h6 class="m-0 font-weight-bold text-primary">Danh sách người dùng</h6>
    </div>
    <div class="card-body">
<div class="table-responsive">
    <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
        <thead>
        <tr>
            <th>Tên đăng nhập</th>
            <th>Mật khẩu</th>
            <th>Nhớ người dùng</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="userItem" items="${listUser}">
            <tr>
                <td>${userItem.username}</td>
                <td>${userItem.password}</td>
                <td>${userItem.remember}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
    </div>
</div>