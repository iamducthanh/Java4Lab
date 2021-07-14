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
    <title>Tìm video được yêu thích theo từ khóa</title>
</head>
<body>
<br/>
<%@include file="/commont/errorAlert.jsp"%>
<div style="border: 1px solid blue; padding: 15px; border-radius: 8px; width: 300px">
<div class="form-check">
    <input class="form-check-input" type="radio" name="flexRadioDefault"
    <c:if test="${type == 'favorite'}">
            checked
    </c:if>
           id="flexRadioDefault1" onclick="favorite()">
    <label class="form-check-label" for="flexRadioDefault1" >
        Favorite
    </label>
</div>
<div class="form-check">
    <input class="form-check-input" type="radio" name="flexRadioDefault"
    <c:if test="${type == 'notfavorite'}">
           checked
    </c:if>
           id="flexRadioDefault2" onclick="notFavorite()">
    <label class="form-check-label" for="flexRadioDefault2">
        Not Favorite
    </label>
</div>
</div>
<br/>
<div class="card shadow mb-4" style="width: 100%;">
    <div class="card-header py-3">
        <h6 class="m-0 font-weight-bold text-primary">
            <c:if test="${type == 'favorite'}">
                Danh sách video được yêu thích
            </c:if>
            <c:if test="${type == 'notfavorite'}">
                Danh sách video không được yêu thích
            </c:if>
            <c:if test="${type == null}">
                Danh sách video
            </c:if>
        </h6>
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
<script>
    function favorite(){
        window.location = "?type=favorite"
    }
    function notFavorite(){
        window.location = "?type=not-favorite";
    }
</script>
</body>
</html>
