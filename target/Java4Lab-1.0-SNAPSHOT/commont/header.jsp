<%@include file="/commont/taglib.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
    <a class="navbar-brand onloader" href="<c:url value="/lab"/>">Java 4</a>
    <button class="btn btn-link btn-sm order-1 order-lg-0" id="sidebarToggle" href="#"><i class="fas fa-bars"></i></button>
    <!-- Navbar-->
    <ul class="navbar-nav ml-auto ml-md-0">
        <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" id="userDropdown" href="#" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                <i class="fas fa-user fa-fw"></i>
                <c:if test="${empty USER}">
                    Nguyễn Đức Thành - PH12794
                </c:if>
                <c:if test="${not empty USER}">
                    ${USER.username}
                </c:if>
            </a>
            <div class="dropdown-menu dropdown-menu-right" aria-labelledby="userDropdown">
                <c:if test="${empty USER}">
                    <a class="dropdown-item onloader" href="<c:url value="/sign-in"/>">Đăng nhập</a>
                </c:if>

                <c:if test="${not empty USER}" >
                    <a class="dropdown-item" href="#">Profile</a>
                    <div class="dropdown-divider"></div>
                    <a id="logout" class="dropdown-item onloader" style="display: none" href="<c:url value="/logout"/> ">Logout</a>
                    <div class="dropdown-item" onclick="showComfirmAlert()">Đăng xuất</div>
                </c:if>
            </div>
        </li>
    </ul>
</nav>

<div id="comfirm" class="swal2-container swal2-center swal2-backdrop-show" style="display: none; overflow-y: auto; text-align: center;">
    <div aria-labelledby="swal2-title" aria-describedby="swal2-html-container"
         class="swal2-popup swal2-modal swal2-icon-warning swal2-show" tabindex="-1" role="dialog"
         aria-live="assertive" aria-modal="true" style="display: grid;">
        <div class="swal2-icon swal2-warning swal2-icon-show" style="display: flex;">
            <div class="swal2-icon-content">!</div>
        </div>
        <h2 class="swal2-title" id="swal2-title" style="display: block;">Bạn có chắc?</h2>
        <div class="swal2-html-container" id="swal2-html-container" style="display: block;">Bạn có chắc muốn đăng xuất!</div>
        <div class="swal2-actions">
            <div href="" onclick="logout();"
               class="swal2-confirm swal2-styled swal2-default-outline btn-primary" aria-label=""
               style="display: inline-block; background-color: rgb(48, 133, 214);">Đồng ý</div>
            <button type="button" class="swal2-cancel swal2-styled swal2-default-outline" aria-label=""
                    style="display: inline-block; background-color: rgb(221, 51, 51);" onclick="closeConfirmAlert();">Hủy bỏ</button>
        </div>
    </div>
</div>

<script>
    function logout(){
        document.getElementById("logout").click();
    }
    function showComfirmAlert(){
        document.getElementById("comfirm").style.display = 'unset';
    }
</script>