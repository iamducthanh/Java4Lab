<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/commont/taglib.jsp" %>
<html>
<head>
    <title>Đăng kí</title>
</head>
<body>
<c:if test="${staff.username!=null}">
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
                        style="display: inline-block;">OK
                </button>
            </div>
        </div>
    </div>
    <h3>Thông tin đăng kí</h3>
    <br/>
    <label class="col-sm-6 control-label no-padding-right">Tên đăng nhập: ${staff.getUsername()}</label>
    <label class="col-sm-6 control-label no-padding-right">Ngày sinh: ${staff.password}</label>
    <label class="col-sm-6 control-label no-padding-right">Giới tính: ${staff.gioiTinh}</label>
    <label class="col-sm-6 control-label no-padding-right">
        Hôn nhân: <c:if test="${staff.honNhan == 'on'}">Đã kết hôn</c:if>
        <c:if test="${staff.honNhan != 'on'}">Chưa kết hôn</c:if>
    </label>
    <label class="col-sm-6 control-label no-padding-right">Quốc tịch: ${staff.quocTich}</label>
    <label class="col-sm-6 control-label no-padding-right">
        Sở thích: <c:forEach var="soThichItem" items="${staff.soThich}">
        ${soThichItem} <p style="display: inline-block">, </p>
    </c:forEach></label>
    <label class="col-sm-6 control-label no-padding-right">Ghi chú: ${staff.note}</label>

    <script>
        document.getElementById("closeAl").onclick = closeAlert;

        function closeAlert() {
            console.log(document.getElementById("errorLogin"));
            document.getElementById("errorLogin").style.display = 'none';
        }

        setTimeout(closeAlert, 2000);
    </script>
</c:if>
<c:if test="${staff.username==null}">
    <div class="contentDk">
        <div class="containerDangKi">
            <div class="headerDK">
                <h2>Thông tin nhân viên</h2>
            </div>
            <form method="POST" class="formDangKi" id="form">
                <div class="controlDK">
                    <lable>Tên đăng nhập:</lable>
                    <input type="text" placeholder="Tên đăng nhập" name="username" required>
                    <i class="fas fa-check-circle"></i>
                    <i class="fas fa-exclamation-circle"></i>
                    <smail class="errorDki">Không được để trống tên đăng nhập!</smail>
                    <p style="color: red; display: none" class="errorDkiName">Tên đăng nhập phải tối thiểu 5 kí tự và không được có kí tự đặc biệt!</p>
                </div>
                <div class="controlDK">
                    <lable>Ngày sinh:</lable>
                    <input type="date" id="date" placeholder="Ngày sinh" name="password" required>
                    <i class="fas fa-check-circle"></i>
                    <i class="fas fa-exclamation-circle"></i>
                    <smail class="errorDki">Không được để trống ngày sinh!</smail>
                    <p class="errorNgaySinh" style="display: none; color: red">Ngày sinh phải trên 18 tuổi!</p>
                </div>

                <div class="controlDK1">
                    <lable>Giới tính:</lable>
                    <input type="radio" name="gioiTinh" checked value="Nam"> Nam
                    <input type="radio" name="gioiTinh" value="Nữ"> Nữ
                </div>
                <div class="controlDK1">
                    <lable>Tình trạng hôn nhân:</lable>
                    <input name="honNhan" type="checkbox"> Đã kết hôn
                </div>


                <div class="controlDK1">
                    <lable>Quốc tịch:</lable>
                    <select name="quocTich" id="quocTich">
                        <option value="Việt Nam">Việt Nam</option>
                        <option value="Việt Nam">Vẫn là Việt Nam</option>
                    </select>
                </div>

                <div class="controlDK1">
                    <lable>Sở thích: &ensp;</lable>
                    <input name="soThich" type="checkbox" value="Đọc sách"> Đọc sách
                    <input name="soThich" type="checkbox" value="Du lịch"> Du lịch
                    <input name="soThich" type="checkbox" value="Âm nhạc"> Âm nhạc
                    <input name="soThich" type="checkbox" value="Khác"> Khác <br/>
                    <smail id="errorSoThich">Bạn phải chọn sở thích!</smail>
                </div>

                <div class="controlDK1">
                    <lable>Ghi chú: &ensp;</lable>
                    <br/>
                    <textarea name="note" cols="30" rows="5"></textarea>
                </div>

                <div class="btn btn-warning" id="subMitBean">Đăng kí</div>
                <button id="dangKiSubBean" style="display: none" type="submit"
                        formaction="<c:url value="/lab3/beanutils"/>" class="btn btn-warning">Đăng kí
                </button>
            </form>
        </div>
    </div>
</c:if>

<script src="<c:url value="/template/js/validateSubmitBean.js" />"></script>
</body>
</html>
