<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/commont/taglib.jsp"%>

<div id="formThemUser" class="swal2-container swal2-center swal2-backdrop-show" style="overflow-y: auto; display: none">
        <div class="contentDk">
            <div class="containerDangKi">
                <div class="headerDK">
                    <h2>Thông tin nhân viên</h2>
                </div>
                <form method="POST" class="formDangKi" id="form" enctype="multipart/form-data">
                    <div class="controlDK">
                        <lable>Tên đăng nhập:</lable>
                        <input type="text" placeholder="Tên đăng nhập" name="username" required>
                        <i class="fas fa-check-circle"></i>
                        <i class="fas fa-exclamation-circle"></i>
                        <smail class="errorDki">Không được để trống tên đăng nhập!</smail>
                    </div>

                    <div class="controlDK">
                        <lable>Mật khẩu</lable>
                        <input type="password" placeholder="Mật khẩu" name="password" required>
                        <i class="fas fa-check-circle"></i>
                        <i class="fas fa-exclamation-circle"></i>
                        <smail class="errorDki">Không được để trống mật khẩu!</smail>
                    </div>

                    <div class="controlDK">
                        <lable>Tên đầy đủ:</lable>
                        <input type="text" placeholder="Tên đầy đủ" name="fullname" required>
                        <i class="fas fa-check-circle"></i>
                        <i class="fas fa-exclamation-circle"></i>
                        <smail class="errorDki">Không được để trống tên đầy đủ!</smail>
                    </div>

                    <div class="controlDK">
                        <lable>Email:</lable>
                        <input type="text" placeholder="Email" name="email" required>
                        <i class="fas fa-check-circle"></i>
                        <i class="fas fa-exclamation-circle"></i>
                        <smail class="errorDki">Không được để trống email!</smail>
                    </div>

                    <div class="controlDK1">
                        <lable>Vai trò:</lable>
                        <input type="radio" name="role" checked value="admin"> Admin
                        <input type="radio" name="role" value="user"> User
                    </div>

                    <div class="btn btn-warning" id="submitAddUser" style="display: inline-block">Create</div>
                    <button id="s" style="display: none" type="submit"
                            formaction="<c:url value="/lab3/dang-ki"/>" class="btn btn-warning">Create
                    </button>
                    <div class="btn btn-danger" onclick="closeForm()">Cancel</div>
                </form>
            </div>
    </div>
</div>
<script>
    function closeForm(){
        document.getElementById("formThemUser").style.display = 'none';
    }
</script>