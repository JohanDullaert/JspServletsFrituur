<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<!doctype html>
<html lang='nl'>
<head>
<title>Frituur Frida's kleurtjes</title>
<link rel='shortcut icon' href='images/favicon.ico' type='image/x-icon' />
<meta name='viewport' content='width=device-width,initial-scale=1'>
<link rel='stylesheet' href='styles/default.css'>
</head>
<body class='${cookie.geslacht.value}'>
	<h1>Frituur Frida: kleurtjes</h1>	
	<form method='post'>
		<input type='submit' name='geslacht' value='meisjes'/>
		<input type='submit' name='geslacht' value='jongens'/>
	</form>	
</body>
</html>