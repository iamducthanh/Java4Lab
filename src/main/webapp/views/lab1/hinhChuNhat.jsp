<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 6/30/2021
  Time: 9:31 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/commont/taglib.jsp"%>
<html>
<head>
    <title>Hình chữ nhật</title>
</head>
<body>

<div id="errorLogin" class="swal2-container swal2-center swal2-backdrop-show" style="overflow-y: auto; display: ${display}">
    <div aria-labelledby="swal2-title" aria-describedby="swal2-content"
         class="swal2-popup swal2-modal swal2-icon-error swal2-show" tabindex="-1" role="dialog"
         aria-live="assertive" aria-modal="true" style="display: flex;">
        <div class="swal2-header">
            <div class="swal2-icon swal2-error swal2-icon-show" style="display: flex;"><span class="swal2-x-mark">
                            <span class="swal2-x-mark-line-left"></span>
                            <span class="swal2-x-mark-line-right"></span>
                        </span>
            </div>
            <h2 class="swal2-title" id="swal2-title" style="display: flex;">${messenge}</h2>
        </div>

        <div class="swal2-actions">
            <div class="swal2-loader"></div>
            <button type="button" class="swal2-confirm swal2-styled" id="closeAl" aria-label=""
                    style="display: inline-block;">OK
            </button>
        </div>
    </div>
</div>
<c:if test="${dienTich != null}">
    <br/>
    <h3>Kết quả</h3>
    <br/>
    <h4>Diện tích: ${dienTich}</h4>
    <br/>
    <h4>Chu vi: ${chuVi}</h4>
</c:if>
<c:if test="${dienTich == null}">
    <form action="lab1" method="post">
        <br/>
        <h3>Thông tin hình chữ nhật</h3>
        <br/>
        <input name="chieuDai" min="0" style="width: 300px" required class="form-control" placeholder="Chiều dài">
        <br/>
        <input name="chieuRong" min="0" style="width: 300px" required class="form-control" placeholder="Chiều rộng">
        <br/>
        <input type="hidden" value="hinhchunhat" name="lab">
        <button type="submit" class="btn btn-warning">Tính</button>
    </form>
</c:if>

<script>
    document.getElementById("closeAl").onclick = closeAlert;
    function closeAlert() {
        console.log(document.getElementById("errorLogin"));
        document.getElementById("errorLogin").style.display = 'none';
    }

</script>
</body>
</html>
