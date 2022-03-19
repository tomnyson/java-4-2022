<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
    <title>buổi 2 toán tử</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
     <link rel="stylesheet" href="./css/styles.css">
</head>
<body>

    <form method="post" action="UserController">
        <h4>Login account</h4>
        <input id="so1" type="text" name="username" placeholder="username"/>
        <input id="so2" type="password" name="password"  placeholder="password"/>
        <div class="center">
            <button  type="submit" >Login</button>
            <p id="ketqua">${message}</p>
        </div>

    </form>
</body>
</html>