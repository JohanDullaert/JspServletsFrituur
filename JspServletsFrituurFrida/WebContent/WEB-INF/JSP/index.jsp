<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<!doctype html>
<html lang='nl'>
<head>
<title>Frituur Frida</title>
<link rel='shortcut icon' href='images/favicon.ico' type='image/x-icon' />
<meta name='viewport' content='width=device-width,initial-scale=1'>
<link rel='stylesheet' href='styles/default.css'>
</head>
<body>
	<h1>Frituur Frida</h1>
	<aside>${adres.straat} ${adres.huisNr}<br />
	${adres.gemeente.postCode} ${adres.gemeente.naam}
	</aside>
	<div>Vandaag zijn we ${openGesloten}.</div>
	<img src='images/${openGesloten}.png' alt='${openGesloten}'
		class='fullwidth'>		
	<a href="<c:url value="/sauzen"/>">Onze sauzen</a>
	<a href="<c:url value="/ingredienten"/>">Zoeken op ingredienten</a>
	<a href="<c:url value="/meisjesjongens"/>">kleurtjes</a>
	<div>Onze helpdesk heeft een 'rechtstreeks' telefoonnummer! : ${initParam.telefoonnummerHelpdesk}</div>
	<footer>Helpdesk via omweg: ${telefoonnummerHelpdesk}</footer>
</body>
</html>