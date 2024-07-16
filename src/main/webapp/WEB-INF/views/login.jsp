<!DOCTYPE html>
<html lang="en">
<meta charset="UTF-8">
<title>jsp file</title>

<body>

<form action = "/login.do" method = "post">
<div>Name <input type="text" name ="getName"/></div>
<div>Password <input type="password" name ="password"/></div>
<input type = "submit" value = "login">
<p><font color = "red">${autError}</font></p>
</form>

</body>
</html>