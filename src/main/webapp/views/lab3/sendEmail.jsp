<%@include file="/commont/taglib.jsp"%>>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Gửi email</title>
</head>
<body>
<div class="contentDk">
    <div class="containerDangKi">
        <div class="headerDK">
            <h2>Gửi email</h2>
        </div>
        <form method="POST" class="formDangKi" id="form" enctype="multipart/form-data">
            <div class="controlDK">
                <lable>Người nhận:</lable>
                <input type="text" placeholder="Người nhận" name="to" required>
            </div>
            <div class="controlDK">
                <lable>Đính kèm:</lable>
                <input type="file" id="file" onchange="setLink();" name="tepDinhKem" value="">
                <input type="text" style="display: none" value="" name="fileDinhKem" id="tepDinhKem">
            </div>
            <div class="controlDK">
                <lable>Tiêu đề</lable>
                <input type="text" placeholder="Tiêu đề" name="tieuDe">
            </div>
            <div class="controlDK1">
                <lable>Nội dung: &ensp;</lable>
                <br/>
                <textarea name="noiDung" cols="30" rows="5"></textarea>
            </div>

            <button type="submit" id="btnSubmit" onclick="loading();"
                    formaction="<c:url value="/lab3/send-email"/>" class="btn btn-warning">Gửi
            </button>
            <button id="btnLoading" class="btn btn-warning" type="button" style="display:none;" disabled>
                <span class="spinner-border spinner-border-sm" role="status" aria-hidden="true"></span>
                Đang gửi
            </button>
        </form>
    </div>
</div>
<script>
    function loading(){
        document.getElementById("btnSubmit").style.display = 'none';
        document.getElementById("btnLoading").style.display = 'unset';
    }
    function setLink(){
       var link =  document.getElementsByName('tepDinhKem')[0].files[0].name;
       document.getElementById("tepDinhKem").value = link;
    }
</script>
</body>
</html>
