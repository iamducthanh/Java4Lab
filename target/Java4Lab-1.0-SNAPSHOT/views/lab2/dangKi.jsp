<%@include file="/commont/taglib.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Đăng kí</title>
    <link href="<c:url value="/template/styleMe.css"/>" rel="stylesheet" />
</head>
<body>
<c:if test="${username!=null}">
    <%@include file="/commont/successAlter.jsp"%>
    <h3>Thông tin đăng kí</h3>
    <br/>
    <label class="col-sm-6 control-label no-padding-right">Tên đăng nhập: ${username}</label>
    <label class="col-sm-6 control-label no-padding-right">Mật khẩu: ${password}</label>
    <label class="col-sm-6 control-label no-padding-right">Giới tính: ${gioiTinh}</label>
    <label class="col-sm-6 control-label no-padding-right">Hôn nhân: ${honNhan}</label>
    <label class="col-sm-6 control-label no-padding-right">Quốc tịch: ${quocTich}</label>
    <label class="col-sm-6 control-label no-padding-right">Sở thích: ${soThich}</label>
    <label class="col-sm-6 control-label no-padding-right">Ghi chú: ${ghiChu}</label>

</c:if>
<c:if test="${username==null}">
    <div class="contentDk">
        <div class="containerDangKi">
            <div class="headerDK">
                <h2>Đăng kí</h2>
            </div>
            <form method="POST" class="formDangKi" id="form">
                <div class="controlDK">
                    <lable>Tên đăng nhập: </lable>
                    <input type="text" placeholder="Tên đăng nhập" name="username" required>
                    <i class="fas fa-check-circle"></i>
                    <i class="fas fa-exclamation-circle"></i>
                    <smail class="errorDki">Không được để trống tên đăng nhập!</smail>
                </div>
                <div class="controlDK">
                    <lable>Mật khẩu:</lable>
                    <input type="text" placeholder="Mật khẩu" name="password" required>
                    <i class="fas fa-check-circle"></i>
                    <i class="fas fa-exclamation-circle"></i>
                    <smail class="errorDki">Không được để trống mật khẩu!</smail>
                </div>

                <div class="controlDK1">
                    <lable>Giới tính: </lable>
                    <input type="radio" name="gioiTinh" checked value="Nam"> Nam
                    <input type="radio" name="gioiTinh" value="Nữ"> Nữ
                </div>
                <div class="controlDK1">
                    <lable>Tình trạng hôn nhân: </lable>
                    <input name="honNhan" type="checkbox" > Đã kết hôn
                </div>


                <div class="controlDK1">
                    <lable>Quốc tịch: </lable>
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
                    <lable>Ghi chú: &ensp;</lable><br/>
                    <textarea name="note" cols="30" rows="5"></textarea>
                </div>

                <div class="btn btn-warning" id="submitDK">Đăng kí</div>
                <button id="dangkisubmit" style="display: none" type="submit" formaction="<c:url value="/lab2/dang-ki"/>" class="btn btn-warning">Đăng kí</button>
            </form>
        </div>
    </div>
</c:if>

</body>
</html>
