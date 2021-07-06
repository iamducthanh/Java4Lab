<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/commont/taglib.jsp"%>
<html>
<head>
    <title>Test jpa</title>
</head>
<body style="width: 400px">
<br/>
<form method="post">
    <input class="form-control" name="usernameInsert" placeholder="username" type="text" style="display: inline-block; width: 300px"><br/>
    <input class="form-control" name="passwordInsert" placeholder="password" type="text" style="display: inline-block; width: 300px"><br/>
    <input class="form-control" name="fullnameInsert" placeholder="fullname" type="text" style="display: inline-block; width: 300px"><br/>
    <input class="form-control" name="emailInsert" placeholder="email" type="text" style="display: inline-block; width: 300px"><br/>
    <input class="form-control" name="roleInsert" placeholder="role" type="text" style="display: inline-block; width: 300px"><br/>

    <button class="btn btn-primary" type="submit" formaction="<c:url value="/lab5/add"/>">Thêm user</button>
</form>
<br/>
<hr/>
<br/>
<form method="post">
<input class="form-control" name="idDelete" placeholder="id" type="text" style="display: inline-block; width: 300px">
<button class="btn btn-danger" type="submit" formaction="<c:url value="/lab5/delete"/>">Xóa user</button>
</form>
<br/>
<hr/>
<br/>
<form method="post">
<input class="form-control" name="idUpdate" placeholder="id" type="text" style="display: inline-block; width: 300px"><br/>
<input class="form-control" name="usernameUpdate" placeholder="username" type="text" style="display: inline-block; width: 300px"><br/>
<input class="form-control" name="passwordUpdate" placeholder="password" type="text" style="display: inline-block; width: 300px"><br/>
<input class="form-control" name="fullnameUpdate" placeholder="fullname" type="text" style="display: inline-block; width: 300px"><br/>
<input class="form-control" name="emailUpdate" placeholder="email" type="text" style="display: inline-block; width: 300px"><br/>
<input class="form-control" name="roleUpdate" placeholder="role" type="text" style="display: inline-block; width: 300px"><br/>

<br/>
<button class="btn btn-primary" type="submit" formaction="<c:url value="/lab5/update"/>">update</button>
</form>
<br/>
<hr/>
<br/>
    <form method="post">
<button class="btn btn-primary" formaction="<c:url value="/lab5/find-all"/>">findAll</button>
    </form>
Kết quả: ${outFindAll}
<br/>
<hr/>
<br/>
    <form method="post">
<input class="form-control" name="role" placeholder="role" type="text" style="display: inline-block; width: 300px">
<button class="btn btn-primary" formaction="<c:url value="/lab5/find-by-role"/>">findByRole</button>
    </form>
Kết quả: ${outFindByRole}
<br/>
<hr/>
<br/>
        <form method="post">
<input class="form-control" name="keywork" placeholder="keywork" type="text" style="display: inline-block; width: 300px">
<button class="btn btn-primary" formaction="<c:url value="/lab5/find-by-keyword"/>">findByKeyword</button>
        </form>
Kết quả: ${outFindByKeyword}
<br/>
<hr/>
<br/>
    <form method="post">
<input class="form-control" placeholder="username" name="username" style="display: inline-block; width: 300px"><br/>
<input class="form-control" placeholder="password" name="password" style="display: inline-block; width: 300px">
<button class="btn btn-primary" formaction="<c:url value="/lab5/find-one"/>">findOne</button>
    </form>
Kết quả: ${outFindOne}
<br/>
<hr/>
<br/>
    <form method="post">
<input class="form-control" name="page" placeholder="page" type="text" style="display: inline-block; width: 300px"><br/>
<input class="form-control" name="max" placeholder="max" type="text" style="display: inline-block; width: 300px">
<button class="btn btn-primary" formaction="<c:url value="/lab5/find-page"/>">findByPage</button>
    </form>
Kết quả: ${outFindByPage}
<br/>
<hr/>
<br/>
</body>
</html>
