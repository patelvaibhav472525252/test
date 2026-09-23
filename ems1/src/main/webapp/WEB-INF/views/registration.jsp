<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Register</title>
</head>
<body>

<h2>Register Here</h2>

    <form action="/save" method="post">
        <pre>
            Name<input type="text" name="name">
            Email<input type="text" name="email">
            Mobile<input type="text" name="mobile">
            <input type="submit" value="save"/>
        </pre>

    </form>
${msg}

</body>
</html>