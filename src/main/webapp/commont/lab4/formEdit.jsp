<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/commont/taglib.jsp"%>

<h4>User edition</h4>
<form class="user" method="post" style="width: 40%">
    <div class="form-group">
        <input type="text" class="form-control form-control-user"
               id="exampleInputEmail" aria-describedby="emailHelp"
               placeholder="Tên đăng nhập" name="username" value="${username}"
        >
    </div>
    <div class="form-group">
        <input type="password" class="form-control form-control-user"
               id="exampleInputPassword" placeholder="Mật khẩu" name="password" value="${password}">
    </div>
    <div class="form-group">
        <div class="custom-control custom-checkbox small">
            <input type="checkbox"
            <c:if test="${remember == true}">
                    checked
            </c:if>
                   name="remember" class="custom-control-input" id="customCheck">
            <label class="custom-control-label" for="customCheck">Remember
                Me</label>
        </div>
    </div>
    <input type="hidden" value="login" name="action">
    <button type="submit" formaction="<c:url value="/lab4/user-management"/>" class="btn btn-primary btn-user btn-block">
        Create
    </button>
    <hr>
</form>