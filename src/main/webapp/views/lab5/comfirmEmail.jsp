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
    <title>Xác nhận email</title>
</head>
<body class="bg-gradient-primary">
<div class="container">
    <%@include file="/commont/errorAlert.jsp"%>
    <div class="row justify-content-center">
        <div class="col-xl-10 col-lg-12 col-md-9">
            <div class="card o-hidden border-0 shadow-lg my-5">
                <div class="card-body p-0">
                    <div class="row">
                        <div class="col-lg-6 d-none d-lg-block bg-password-image"></div>
                        <div class="col-lg-6">
                            <div class="p-5">
                                <div class="text-center">
                                    <h1 class="h4 text-gray-900 mb-2">Xác thực email?</h1>
                                    <p class="mb-4">Vui lòng nhập mã xác thực gồm 6 chữ số đã được gửi vào email ${email}!</p>
                                </div>
                                <form class="user" method="post">
                                    <div class="form-group">
                                        <input type="text" class="form-control form-control-user"
                                               id="exampleInputEmail" aria-describedby="emailHelp"
                                               placeholder="Mã xác thực" name="maxacthuc">
                                    </div>
                                    <button type="submit" formaction="<c:url value="/comfirm-email"/> " class="btn btn-primary btn-user btn-block onloader">
                                        Hoàn thành
                                    </button>
                                </form>
                                <hr>
                                <div class="text-center">
                                    <a class="small onloader" href="<c:url value="/sign-up"/>">Quay lại</a>
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
