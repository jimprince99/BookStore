<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<div class="container">
    <div class="links">
        <h1><a href="list"> Book Store</a></h1>
        <h1><a href="new"> Add new book</a></h1>
    </div>

    <form name="book_form" action="insert" method="post">
    <caption><h2>New book form</h2></caption>
        <p><label>Title:</label>
            <input type="text" name="title"></p>
        <p><label>Title:</label>
            <input type="text" name="author"></p>        
        <p><label>Title:</label>
            <input type="text" name="price"></p> 
        <input type="submit" name="Submit">
    </form>

</body>
</html>