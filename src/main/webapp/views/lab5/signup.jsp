<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/commont/taglib.jsp"%>

<html>
<head>
    <title>Đăng kí</title>
</head>
<body class="bg-gradient-primary">
<div class="container">
    <%@include file="/commont/errorAlert.jsp"%>
    <div class="card o-hidden border-0 shadow-lg my-5">
        <div class="card-body p-0">
            <div class="row">
                <div class="col-lg-5 d-none d-lg-block bg-register-image"></div>
                <div class="col-lg-7">
                    <div class="p-5">
                        <div class="text-center">
                            <h1 class="h4 text-gray-900 mb-4">Tạo tài khoản!</h1>
                        </div>
                        <form class="user" method="post">
                            <div class="form-group row">
                                <div class="col-sm-6 mb-3 mb-sm-0">
                                    <input type="text" class="form-control form-control-user" value="${username}" name="username" id="exampleFirstName"
                                           placeholder="Tên đăng nhập">
                                </div>
                                <div class="col-sm-6">
                                    <input type="text" class="form-control form-control-user" value="${fullname}" name="fullname" id="exampleLastName"
                                           placeholder="Tên đầy đủ">
                                </div>
                            </div>
                            <div class="form-group">
                                <input type="text" class="form-control form-control-user" value="${email}" name="email" id="exampleInputEmail"
                                       placeholder="Địa chỉ email">
                            </div>
                            <div class="form-group row">
                                <div class="col-sm-6 mb-3 mb-sm-0">
                                    <input type="password" class="form-control form-control-user"
                                           id="exampleInputPassword" placeholder="Mật khẩu" value="${password}" name="password">
                                </div>
                                <div class="col-sm-6">
                                    <input type="password" class="form-control form-control-user"
                                           id="exampleRepeatPassword" placeholder="Nhập lại mật khẩu" value="${comfirmPassword}" name="comfirmPassword">
                                </div>
                            </div>
                            <button type="submit" formaction="<c:url value="/sign-up" />" class="btn btn-primary btn-user btn-block onloader">
                                Tạo tài khoản
                            </button>
                            <hr>
                        </form>
                        <div class="text-center">
                            <a class="small onloader" href="<c:url value="/forgot-password"/>">Quên mật khẩu?</a>
                        </div>
                        <div class="text-center">
                            <a class="small onloader" href="<c:url value="/sign-in"/>">Bạn đã có tài khoản? Đăng nhập!</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
