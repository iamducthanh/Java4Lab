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
                    <a class="btn btn-danger" href="${remove}">Remove</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<script>
    function onAddForm(){
        document.getElementById("formThemUser").style.display = 'unset';
    }
</script>