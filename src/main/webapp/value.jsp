<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Data</title>
</head>
<body>
    <jsp:useBean id="valueBean" class="beans.ValueBean" />
    <jsp:setProperty name="valueBean" property="value" />

    <form method="POST">
        <label for="value">Value: </label>
        <input id="value" name="value" value="<jsp:getProperty name='valueBean' property='value'/>"/>
        <button type="submit">Submit</button>
    </form>

    <p>Current Value: <jsp:getProperty name="valueBean" property="value" /></p>
</body>
</html>
