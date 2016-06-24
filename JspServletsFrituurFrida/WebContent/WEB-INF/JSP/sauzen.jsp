<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<!doctype html>
<html lang='nl'>
<head>
<title>Frituur Frida's sauzen</title>
<link rel='shortcut icon' href='images/favicon.ico' type='image/x-icon' />
<meta name='viewport' content='width=device-width,initial-scale=1'>
<link rel='stylesheet' href='styles/default.css'>
</head>
<body>
	<h1>Frituur Frida's sauzen</h1>
	<c:if test="${not empty fouten}">
		<c:forEach var="fout" items="${fouten}">
		${fout.value}
		</c:forEach>
	</c:if>
	<c:if test="${not empty sauzen}">
		<form method="POST">
			<ul>
				<c:forEach var="saus" items="${sauzen}">
					<li><label><input type="checkbox"
							name="teVerwijderenSauzen" value="${saus.nummer}" />${saus.naam}</label><img
						src="images/${saus.naam}.png" alt="${saus.naam}">
					<c:forEach var="ingredient" items="${saus.ingredienten}"
							varStatus="status">${status.first ? ": " : ", "}${ingredient}${status.last ? "." : ""}</c:forEach>
					</li>
				</c:forEach>
			</ul>
			<input type="submit" value="verwijderen" />
		</form>
	</c:if>	
	<footer>
		<a href="<c:url value="/index.htm"/>">get back</a>
	</footer>
</body>
</html>