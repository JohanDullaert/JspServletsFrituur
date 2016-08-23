<%@page contentType='text/html' pageEncoding='UTF-8'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<!doctype html>
<html lang='nl'>
<head>
<title>Frituur Frida's frietspel</title>
<link rel='shortcut icon' href='images/favicon.ico' type='image/x-icon' />
<meta name='viewport' content='width=device-width,initial-scale=1'>
<link rel='stylesheet' href='styles/default.css'>
</head>
<body>
<h1>Frituur Frida: ons frietspel!</h1>

	<form action="post">
	<c:forEach var='friet' items='${deuren}' varStatus='status'>	
		<button type='submit' name='volgnummer' value='${status.count}'>
			<img alt='${friet}' src='<c:url value='images/${friet}.png'/>'/>
		</button>
	</c:forEach>
	</form>
</body>
</html>