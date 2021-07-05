<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/commont/taglib.jsp"%>
<html>
<head>
    <title>Đăng nhập</title>
</head>
<body class="bg-gradient-primary">
<div class="container">
    <div class="row justify-content-center">
        <%@include file="/commont/errorAlert.jsp"%>
        <div class="col-xl-10 col-lg-12 col-md-9">
            <div class="card o-hidden border-0 shadow-lg my-5">
                <div class="card-body p-0">
                    <div class="row">
                        <div class="col-lg-6 d-none d-lg-block bg-login-image"></div>
                        <div class="col-lg-6">
                            <div class="p-5">
                                <div class="text-center">
                                    <h1 class="h4 text-gray-900 mb-4">Welcome Back!</h1>
                                </div>
                                <form class="user" method="post" action="dang-nhap">
                                    <div class="form-group">
                                        <input type="text" class="form-control form-control-user"
                                               id="exampleInputEmail" aria-describedby="emailHelp"
                                               placeholder="Tên đăng nhập" name="username" value=${username}>
                                    </div>
                                    <div class="form-group">
                                        <input type="password" class="form-control form-control-user"
                                               id="exampleInputPassword" placeholder="Mật khẩu" name="password" value=${password}>
                                    </div>
                                    <div class="form-group">
                                        <div class="custom-control custom-checkbox small">
                                            <c:if test="${remember == 'on'}">
                                                <input type="checkbox" name="remember" checked class="custom-control-input" id="customCheck">
                                            </c:if>
                                            <c:if test="${remember != 'on'}">
                                                <input type="checkbox" name="remember" class="custom-control-input" id="customCheck">
                                            </c:if>
                                            <label class="custom-control-label" for="customCheck">Remember
                                                Me</label>
                                        </div>
                                    </div>
                                    <input type="hidden" value="login" name="action">
                                    <button type="submit" class="btn btn-primary btn-user btn-block">
                                        Login
                                    </button>
                                    <hr>
                                </form>
                                <div class="text-center">
                                    <a class="small" href="forgot-password.html">Forgot Password?</a>
                                </div>
                                <div class="text-center">
                                    <a class="small" href="register.html">Create an Account!</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
