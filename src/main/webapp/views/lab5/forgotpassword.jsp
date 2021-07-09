<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 7/7/2021
  Time: 8:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/commont/taglib.jsp"%>

<html>
<head>
    <title>Quên mật khẩu</title>
</head>
<body class="bg-gradient-primary">
<div class="container">
    <%@include file="/commont/errorAlert.jsp"%>
    <%@include file="/commont/successAlert3.jsp"%>
    <div class="row justify-content-center">
        <div class="col-xl-10 col-lg-12 col-md-9">
            <div class="card o-hidden border-0 shadow-lg my-5">
                <div class="card-body p-0">
                    <div class="row">
                        <div class="col-lg-6 d-none d-lg-block bg-password-image"></div>
                        <div class="col-lg-6">
                            <div class="p-5">
                                <div class="text-center">
                                    <h1 class="h4 text-gray-900 mb-2">Quên mật khẩu?</h1>
                                    <p class="mb-4">Nhập địa chỉ email mà bạn dùng để đăng kí tài khoản của mình, chúng tôi sẽ gửi cho bạn một mã xác nhận giúp bạn lấy lại mật khẩu!</p>
                                </div>
                                <form class="user" method="post">
                                    <div class="form-group">
                                        <input type="text" class="form-control form-control-user"
                                               id="exampleInputEmail" aria-describedby="emailHelp"
                                               value="${emailFalse}" name="emailforgot" placeholder="Địa chỉ email">
                                    </div>
                                    <button type="submit" formaction="<c:url value="/forgot-password" />" class="btn btn-primary btn-user btn-block onloader">
                                        Reset Password
                                    </button>
                                </form>
                                <hr>
                                <div class="text-center">
                                    <a class="small onloader" href="<c:url value="/sign-up"/>">Create an Account!</a>
                                </div>
                                <div class="text-center">
                                    <a class="small onloader" href="<c:url value="/sign-in"/>">Already have an account? Login!</a>
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
