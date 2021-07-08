<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/commont/taglib.jsp"%>

<h4 style="margin-top: 30px">Danh sách người dùng</h4>
<button class="btn btn-primary" onclick="onAddForm();">Thêm người dùng</button><br/><br/>
<div class="table-responsive">
    <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
        <thead>
        <tr>
            <th>Username</th>
            <th>Password</th>
            <th>Full name</th>
            <th>Email</th>
            <th>Role</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="userItem" items="${listUser}">
            <tr>
                <td>${userItem.username}</td>
                <td>${userItem.password}</td>
                <td>${userItem.fullname}</td>
                <td>${userItem.email}</td>
                <td>${userItem.role}</td>
                <td>
                    <c:url var="edit" value="/lab5/quan-li-user">
                        <c:param name="action" value="edit"/>
                        <c:param name="id" value="${userItem.id}"/>
                    </c:url>
                    <a href="${edit}" class="btn btn-primary" >Edit</a>
                    <c:url var="remove" value="/lab5/quan-li-user">
                        <c:param name="action" value="remove"/>
                        <c:param name="id" value="${userItem.id}"/>
                    </c:url>
                    <a class="btn btn-danger" style="display:none;" id="${userItem.id}" href="${remove}">Remove</a>
                    <div class="btn btn-danger" onclick="showComfirmAlert(${userItem.id});">Remove</div>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div id="comfirm" class="swal2-container swal2-center swal2-backdrop-show" style="display: none; overflow-y: auto; text-align: center;">
        <div aria-labelledby="swal2-title" aria-describedby="swal2-html-container"
             class="swal2-popup swal2-modal swal2-icon-warning swal2-show" tabindex="-1" role="dialog"
             aria-live="assertive" aria-modal="true" style="display: grid;">
            <div class="swal2-icon swal2-warning swal2-icon-show" style="display: flex;">
                <div class="swal2-icon-content">!</div>
            </div>
            <h2 class="swal2-title" id="swal2-title" style="display: block;">Bạn có chắc?</h2>
            <div class="swal2-html-container" id="swal2-html-container" style="display: block;">Bạn có chắc muốn xóa người dùng này!</div>
            <div class="swal2-actions">
                <a href="" id="btnDongY"
                        class="swal2-confirm swal2-styled swal2-default-outline btn-primary" aria-label=""
                        style="display: inline-block; background-color: rgb(48, 133, 214);">Đồng ý</a>
                <button type="button" class="swal2-cancel swal2-styled swal2-default-outline" aria-label=""
                        style="display: inline-block; background-color: rgb(221, 51, 51);" onclick="closeConfirmAlert();">Hủy bỏ</button>
            </div>
        </div>
    </div>
</div>
<script>
    function closeConfirmAlert(){
        document.getElementById("comfirm").style.display = 'none';
    }
    function showComfirmAlert(id){
        console.log(document.getElementById(id).href);
        document.getElementById("btnDongY").href = document.getElementById(id).href
        document.getElementById("comfirm").style.display = 'unset';
    }
    function onAddForm(){
        document.getElementById("formThemUser").style.display = 'unset';
    }
</script>