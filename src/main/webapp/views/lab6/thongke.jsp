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
    <title>Thống kê lượt thích video</title>
</head>
<body>
<br/>
<div class="card shadow mb-4" style="width: 100%;">
    <div class="card-header py-3">
        <h6 class="m-0 font-weight-bold text-primary">Thống kê lượt thích video</h6>
    </div>
    <div class="card-body">
        <div class="table-responsive">
            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                <thead>
                <tr>
                    <th>Title</th>
                    <th>Số like</th>
                    <th>Like sớm nhất</th>
                    <th>Like muộn nhất</th>
                </tr>
                </thead>
                <tfoot>
                <tr>
                    <th>Title</th>
                    <th>Số like</th>
                    <th>Like sớm nhất</th>
                    <th>Like muộn nhất</th>
                </tr>
                </tfoot>
                <tbody>
                <c:forEach var="reportItem" items="${listReport}">
                    <tr>
                        <td>${reportItem.group}</td>
                        <td>${reportItem.like}</td>
                        <td>${reportItem.newest}</td>
                        <td>${reportItem.oldest}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>
