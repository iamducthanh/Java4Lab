<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/commont/taglib.jsp"%>
<html>
<head>
    <title>Upload file</title>
</head>
<body>
<h3>Upload</h3>
<br/>
<c:if test="${img==null}">
    <form method="post" enctype="multipart/form-data">
        <h4 style="display: inline-block">Hình ảnh: </h4> <input required name="photo_file" type="file" accept=".jpg, .png"> <br/><br/>
        <h4 style="display: inline-block">Tài liệu: </h4> <input required type="file" name="doc_file" accept=".xlsx, .docx, .pdf">
        <br/><br>
        <button formaction="<c:url value="/lab3/upload-file" />" class="btn btn-primary" type="submit">Upload</button>
    </form>
</c:if>
<c:if test="${img!=null}">
    <h4>1. Hình: ${img.name}</h4>
    <img src="<c:url value="/images/${img.name}"/>" height="100">

    <h4>1. Tài liệu: ${doc.name}</h4>
    <a href="<c:url value="/images/${doc.name}"/>">Tải về</a>
</c:if>
</body>
</html>
