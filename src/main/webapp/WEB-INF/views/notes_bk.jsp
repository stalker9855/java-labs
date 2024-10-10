<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Notes</title>
</head>
<body>

<h1>Notes</h1>

<form action="${noteController.createNote}" method="post">
    <h2>Create a New Note</h2>
    
    <label for="title">Title: </label>
    <input type="text" id="title" name="title" required />

    <label for="description">Description: </label>
    <input type="text" id="description" name="description" required />

    <button type="submit">Create Note</button>
</form>

<h2>List of Notes</h2>

<table border="1">
    <thead>
        <tr>
            <th>Title</th>
            <th>Description</th>
            <th>Created At</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="note" items="${notes}">
            <tr>
                <td>${note.title}</td>
                <td>${note.description}</td>
                <td>${note.createdAt}</td>
            </tr>
        </c:forEach>
    </tbody>
</table>

</body>
</html>
