<%@include file="/commont/taglib.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hình tam giác</title>
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
<form action="lab2/tam-giac" method="post">
    <br/>
    <h3>Thông tin hình tam giác</h3>
    <br/>
    <input name="canha" type="text" value="${canha}" min="0" style="width: 300px" required class="form-control"
           placeholder="Cạnh a">
    <br/>
    <input name="canhb" type="text" value="${canhb}" min="0" style="width: 300px" required class="form-control"
           placeholder="Cạnh b">
    <br/>
    <input name="canhc" type="text" value="${canhc}" min="0" style="width: 300px" required class="form-control"
           placeholder="Cạnh c">
    <br/>
    <button type="submit" formaction="<c:url value="/lab2/tam-giac?action=chu-vi" />" class="btn btn-warning">Chu vi</button>
    <button type="submit" formaction="<c:url value="/lab2/tam-giac?action=dien-tich" />" class="btn btn-warning">Diện tích</button>
</form>
    <h2>${ketQua}</h2>
<script>
    document.getElementById("closeAl").onclick = closeAlert;
    function closeAlert() {
        console.log(document.getElementById("errorLogin"));
        document.getElementById("errorLogin").style.display = 'none';
    }
</script>
</body>
</html>
