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
<form class="user" method="post">
    <div class="btn-group" role="group" aria-label="Basic checkbox toggle button group">
        <input onchange="submitC()"
        <c:if test="${checkBox1 != null}">checked</c:if>
               type="checkbox" name="month" value="1" class="btn-check" id="btncheck1" autocomplete="off">
        <label class="btn btn-outline-primary" for="btncheck1">Tháng 1</label>

        <input onchange="submitC()"
               <c:if test="${checkBox2 != null}">checked</c:if>
               type="checkbox" name="month" value="2" class="btn-check" id="btncheck2" autocomplete="off">
        <label class="btn btn-outline-primary" for="btncheck2">Tháng 2</label>

        <input onchange="submitC()"
               <c:if test="${checkBox3 != null}">checked</c:if>
               type="checkbox" name="month" value="3" class="btn-check" id="btncheck3" autocomplete="off">
        <label class="btn btn-outline-primary" for="btncheck3">Tháng 3</label>

        <input onchange="submitC()"
               <c:if test="${checkBox4 != null}">checked</c:if>
               type="checkbox" name="month" value="4" class="btn-check" id="btncheck4" autocomplete="off">
        <label class="btn btn-outline-primary" for="btncheck4">Tháng 4</label>

        <input onchange="submitC()"
               <c:if test="${checkBox5 != null}">checked</c:if>
               type="checkbox" name="month" value="5" class="btn-check" id="btncheck5" autocomplete="off">
        <label class="btn btn-outline-primary" for="btncheck5">Tháng 5</label>

        <input onchange="submitC()"
               <c:if test="${checkBox6 != null}">checked</c:if>
               type="checkbox" name="month" value="6" class="btn-check" id="btncheck6" autocomplete="off">
        <label class="btn btn-outline-primary" for="btncheck6">Tháng 6</label>

        <input onchange="submitC()"
               <c:if test="${checkBox7 != null}">checked</c:if>
               type="checkbox" name="month" value="7" class="btn-check" id="btncheck7" autocomplete="off">
        <label class="btn btn-outline-primary" for="btncheck7">Tháng 7</label>

        <input onchange="submitC()"
               <c:if test="${checkBox8 != null}">checked</c:if>
               type="checkbox" name="month" value="8" class="btn-check" id="btncheck8" autocomplete="off">
        <label class="btn btn-outline-primary" for="btncheck8">Tháng 8</label>

        <input onchange="submitC()"
               <c:if test="${checkBox9 != null}">checked</c:if>
               type="checkbox" name="month" value="9" class="btn-check" id="btncheck9" autocomplete="off">
        <label class="btn btn-outline-primary" for="btncheck9">Tháng 9</label>

        <input onchange="submitC()"
               <c:if test="${checkBox10 != null}">checked</c:if>
               type="checkbox" name="month" value="10" class="btn-check" id="btncheck10" autocomplete="off">
        <label class="btn btn-outline-primary" for="btncheck10">Tháng 10</label>

        <input onchange="submitC()"
               <c:if test="${checkBox11 != null}">checked</c:if>
               type="checkbox" name="month" value="11" class="btn-check" id="btncheck11" autocomplete="off">
        <label class="btn btn-outline-primary" for="btncheck11">Tháng 11</label>

        <input onchange="submitC()"
               <c:if test="${checkBox12 != null}">checked</c:if>
               type="checkbox" name="month" value="12" class="btn-check" id="btncheck12" autocomplete="off">
        <label class="btn btn-outline-primary" for="btncheck12">Tháng 12</label>
    </div>
    <button formaction="<c:url value="/lab6/find-Video-By-Month"/> " type="submit" id="submitMonthLab6" style="display: none"></button>
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
<script>
    function submitC(){
        document.getElementById("submitMonthLab6").click();
    }
</script>
</body>
</html>
