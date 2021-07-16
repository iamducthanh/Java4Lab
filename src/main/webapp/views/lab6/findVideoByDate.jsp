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
    <title>Tìm video theo ngày thích</title>
</head>
<body>
<br/>
<%@include file="/commont/errorAlert.jsp"%>
<form class="user" method="post" style="width: 40%">
    <div class="input-group mb-3">
        <span class="input-group-text" id="basic-addon1">From Date</span>
        <input type="date" name="fromDate" value="${fromDate}" class="form-control" placeholder="From date" aria-label="Username" aria-describedby="basic-addon1">
    </div>
    <div class="input-group mb-3">
        <span class="input-group-text" id="basic-addon2">To Date</span>
        <input type="date" name="toDate" value="${toDate}" class="form-control" placeholder="To date" aria-label="Username" aria-describedby="basic-addon1">
    </div>
    <button style="width: 120px" type="submit" formaction="<c:url value="/lab6/find-Video-By-Date"/>" class="btn btn-primary btn-user btn-block">
        Tìm kiếm
    </button>
    <hr>
</form>
<div class="card shadow mb-4" style="width: 100%;">
    <div class="card-header py-3">
        <h6 class="m-0 font-weight-bold text-primary">Danh sách video tìm thấy</h6>
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
</body>
</html>
