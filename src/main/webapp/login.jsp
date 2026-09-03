<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login - My Construction</title>
</head>

<body>

    <h1>My Construction</h1>

    <h2>Iniciar sesion</h2>
	<%
	    String error = (String) request.getAttribute("error");

	    if (error != null) {
	%>

	    <p><%= error %></p>

	<%
	    }
	%>

    <form action="login" method="post">

        <label>Usuario:</label>
        <br>
        <input type="text" name="usuario" required>

        <br><br>

        <label>Clave:</label>
        <br>
        <input type="password" name="password" required>

        <br><br>

        <button type="submit">
            Ingresar
        </button>

    </form>

</body>
</html>