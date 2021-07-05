<%@include file="/commont/taglib.jsp"%>>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:if test="${username!=null}">
    <div id="errorLogin" class="swal2-container swal2-center swal2-backdrop-show" style="overflow-y: auto;">
        <div aria-labelledby="swal2-title" aria-describedby="swal2-content"
             class="swal2-popup swal2-modal swal2-icon-success swal2-show" tabindex="-1" role="dialog"
             aria-live="assertive" aria-modal="true" style="display: flex;">
            <div class="swal2-header">
                <div class="swal2-icon swal2-success swal2-icon-show" style="display: flex;">
                    <div class="swal2-success-circular-line-left" style="background-color: rgb(255, 255, 255);">
                    </div>
                    <span class="swal2-success-line-tip"></span> <span class="swal2-success-line-long"></span>
                    <div class="swal2-success-ring"></div>
                    <div class="swal2-success-fix" style="background-color: rgb(255, 255, 255);"></div>
                    <div class="swal2-success-circular-line-right" style="background-color: rgb(255, 255, 255);"></div>
                </div>
                <h2 class="swal2-title" id="swal2-title" style="display: flex;">Đăng kí thành công!</h2>
            </div>
            <div class="swal2-actions">
                <button type="button" id="closeAl" class="swal2-confirm swal2-styled" aria-label=""
                        style="display: inline-block;">OK</button>
            </div>
        </div>
    </div>
    <h3>Thông tin đăng kí 1</h3>
    <br/>
    <label class="col-sm-6 control-label no-padding-right">Tên đăng nhập: ${username}</label>
    <label class="col-sm-6 control-label no-padding-right">Mật khẩu: ${password}</label>
    <label class="col-sm-6 control-label no-padding-right">Giới tính: ${gioiTinh}</label>
    <label class="col-sm-6 control-label no-padding-right">Hôn nhân: ${honNhan}</label>
    <label class="col-sm-6 control-label no-padding-right">Quốc tịch: ${quocTich}</label>
    <label class="col-sm-6 control-label no-padding-right">Ghi chú: ${ghiChu}</label>

    <script>
        document.getElementById("closeAl").onclick = closeAlert;
        function closeAlert() {
            console.log(document.getElementById("errorLogin"));
            document.getElementById("errorLogin").style.display = 'none';
        }
        setTimeout(closeAlert, 2000);
    </script>
</c:if>
<c:if test="${username==null}">
    <form method="post">
        <br/>
        <h3>Đăng kí</h3>
        <label class="col-sm-3 control-label no-padding-right">Tên đăng nhập:</label>
        <div class="col-sm-5">
            <input name="username" type="text" value="" required class="form-control"
                   placeholder="Tên đăng nhập">
            <br/>
        </div>

        <label class="col-sm-3 control-label no-padding-right">Mật khẩu</label>
        <div class="col-sm-5">
            <input name="password" type="password" value="" required class="form-control"
                   placeholder="Mật khẩu">
            <br/>
        </div>

        <label class="col-sm-2 control-label no-padding-right">Giới tính:</label>
        <input name="gioiTinh" type="radio" checked value="Nam"> Nam&ensp;
        <input name="gioiTinh" type="radio" value="Nữ"> Nữ
        <br/>

        <label class="col-sm-2 control-label no-padding-right">Hôn nhân:</label>
        <input name="honNhan" type="checkbox" value="true"> Đã có gia đình
        <br/>

        <label class="col-sm-3 control-label no-padding-right">Quốc tịch:</label>
        <div class="col-sm-5">
            <select class="form-control" id="quocTich" name="quocTich">
                <option value="Việt Nam">Việt Nam</option>
                <option value="Việt Nam">Vẫn là Việt Nam</option>

            </select>
        </div>
        <br/>

        <label class="col-sm-3 control-label no-padding-right">Ghi chú:</label>
        <div class="col-sm-9">
        <textarea rows="" cols="" id="content" name="note" style="width: 700px;height: 175px; padding: 0">
        </textarea>
        </div>
        <br/>
        <button type="submit" formaction="<c:url value="/lab2/signup"/>" class="btn btn-warning">Đăng kí</button>
    </form>
</c:if>
</body>
</html>
