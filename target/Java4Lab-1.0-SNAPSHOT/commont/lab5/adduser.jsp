<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/commont/taglib.jsp"%>

<div id="formThemUser" class="swal2-container swal2-center swal2-backdrop-show" style="overflow-y: auto;
<c:if test="${user.username == null}">
        display: none
</c:if>
<c:if test="${user.username != null}">
        display: unset;
</c:if>
">
        <div class="contentDk">
            <div class="containerDangKi">
                <div class="headerDK">
                    <h2>Thông tin nhân viên</h2>
                </div>
                <form method="post" class="formDangKi" id="form">
                    <div class="controlDK">
                        <lable>Tên đăng nhập:</lable>
                        <input
                        <c:if test="${trungName != null}" >
                                style="border: 1px solid red"
                        </c:if>

                                type="text" placeholder="Tên đăng nhập" value="${user.username}" name="usernameBai3" required>
                        <i class="fas fa-check-circle"></i>
                        <i class="fas fa-exclamation-circle"
                                <c:if test="${trungName != null}" >
                                    style="display: unset"
                                </c:if>
                        ></i>
                        <smail class="errorDki">Không được để trống tên đăng nhập!</smail>
                        <p style="color: red; display: none" class="errorDkiName">Tên đăng nhập phải tối thiểu 5 kí tự và không được có kí tự đặc biệt!</p>
                        <p
                                <c:if test="${trungName != null}" >
                                    style="border: 1px solid red; color: red; display: unset"
                                </c:if>
                                <c:if test="${trungName == null}" >
                                    style="border: 1px solid red; color: red; display: none"
                                </c:if>
                                class="errorDkiName">Tên đăng nhập này đã tồn tại!</p>
                    </div>

                    <div class="controlDK">
                        <lable>Mật khẩu</lable>
                        <input type="password" placeholder="Mật khẩu" value="${user.password}" name="passwordBai3" required>
                        <i class="fas fa-check-circle"></i>
                        <i class="fas fa-exclamation-circle"></i>
                        <smail class="errorDki">Không được để trống mật khẩu!</smail>
                    </div>

                    <div class="controlDK">
                        <lable>Tên đầy đủ:</lable>
                        <input type="text" placeholder="Tên đầy đủ" value="${user.fullname}" name="fullnameBai3" required>
                        <i class="fas fa-check-circle"></i>
                        <i class="fas fa-exclamation-circle"></i>
                        <smail class="errorDki">Không được để trống tên đầy đủ!</smail>
                    </div>

                    <div class="controlDK">
                        <lable>Email:</lable>
                        <input type="text" placeholder="Email" value="${user.email}" name="emailBai3" required>
                        <i class="fas fa-check-circle"></i>
                        <i class="fas fa-exclamation-circle"></i>
                        <smail class="errorDki">Email không đúng định dạng!</smail>
                    </div>

                    <div class="controlDK1">
                        <lable>Vai trò:</lable>
                        <c:if test="${user.role == 1}">
                            <input type="radio" name="roleBai3" value="0"> User
                            <input type="radio" name="roleBai3" checked value="1"> Admin
                        </c:if>
                        <c:if test="${user.role != 1}">
                            <input type="radio" name="roleBai3" checked value="0"> User
                            <input type="radio" name="roleBai3" value="1"> Admin
                        </c:if>
                    </div>

                    <div class="btn btn-warning" id="submitAddUser" style="display: inline-block">Create</div>
                    <button id="adduser" style="display: none" type="submit"
                            formaction="<c:url value="/lab5/quan-li-user/add"/>" class="btn btn-warning">Create
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