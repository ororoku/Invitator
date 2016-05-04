<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored ="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
<body>
<h1><c:out value="${errorMessage}"/></h1>
<c:remove var="errorMessage" scope="session"/>

<form action="/Invitator/LoginServlet" method="post">

<fieldset>
<legend>ID</legend>
<input type="text" name="userId" value="" required>
IDを入力してください
</fieldset>

<fieldset>
<legend>パスワード</legend>
<input type="text" name="password" value="" required>
パスワードを入力してください
</fieldset>

<input type="submit" value="ログイン">

</form>
</body>
</html>