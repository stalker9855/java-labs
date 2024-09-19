<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <jsp:useBean id="dateBean" class="beans.DateBean" />
    <h1>${dateBean.currentDate}</h1>
</body>
</html>
