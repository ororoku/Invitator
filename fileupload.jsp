<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>FileUpload</title>
<style type="text/css">
fieldset {
  border: 0px;
}
</style>
</head>
<body>
  <form action="/Invitator/fileupload" enctype="multipart/form-data"
    method="POST">
    <fieldset>
      <label for="filename"> ファイル： </label> <input type="file"
        name="filename" size="30" id="filename" />
    </fieldset>
    <input type="submit" value="アップロード" />
  </form>
  <c:if test="${requestScope.filename != null}">
    <h1>アップロード結果</h1>
    <ul>
      <c:choose>
        <c:when test="${requestScope.existed!=null}">
          <li>ファイル名：既にuploadされています。</li>
        </c:when>
        <c:when test="${requestScope.hashexist!=null}">
          <li>ファイル名：同じ内容のfileがあるようです。</li>
        </c:when>
        <c:otherwise>
          <li>ファイル名：${requestScope.filename}</li>
        </c:otherwise>
      </c:choose>
      <li>コメント：${requestScope.comment}</li>
    </ul>
  </c:if>
</body>
</html>