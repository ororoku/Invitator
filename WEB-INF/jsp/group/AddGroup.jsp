<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored ="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1><c:out value="${errorMessage}"/></h1>
<c:remove var="errorMessage" scope="session"/>

<form action="/Invitator/AddGroupComplete" method="post">

<fieldset>
<legend>グループ名</legend>
<input type="text" name="groupName" value="" required>
グループ名を入力してください
</fieldset>

<fieldset>
<legend>グループの説明文</legend>
<input type="text" maxlength="50" name="description" value="" required>
このグループに関する説明文を記述してください
</fieldset>


<fieldset>
<legend>グループ写真のアップロード</legend>
<input type="file" name="groupImage">
グループ写真をアップロードしてください
</fieldset>

<input type="submit" value="グループを作成する">

</form>

</body>
</html>