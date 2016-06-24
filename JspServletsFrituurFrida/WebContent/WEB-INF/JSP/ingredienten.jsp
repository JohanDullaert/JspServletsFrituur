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
	<h1>Frituur Frida: Ingredienten!</h1>
	<form>
		<label><input type="text" name="ingredient" value="${param.ingredient}" /> zoeken op 1 ingredient</label>
		<div>Zoek sausen die mintens 1 van volgende ingredienten hebben:
		<ul>
			<c:forEach var="ingredient" items="${ingredienten}">
				<li><label><input type="checkbox" name="ingredienten"
						value="${ingredient}" /> ${ingredient} </label></li>
			</c:forEach>
		</ul>
		</div>
		<div>Zoek sausen die alle van volgende ingredienten hebben:
		<ul>
			<c:forEach var="ingredient" items="${ingredienten}">
				<li><label><input type="checkbox" name="ingredientenAlle"
						value="${ingredient}" /> ${ingredient} </label></li>
			</c:forEach>
		</ul>
		</div>
		<input type="submit" value="zoek op"></input>
	</form>
	<c:if test="${sauzenEnkelIngredient != null}">
		Sauzen gezocht op 1 ingredient: ${param.ingredient}
		<c:choose>
			<c:when test="${empty sauzenEnkelIngredient}">
			Geen sauzen met dit ingredient.
		</c:when>
			<c:otherwise>
				<ul>
					<c:forEach var="saus" items="${sauzenEnkelIngredient}">
						<li><img src="images/${saus.naam}.png" alt="${saus.naam}">${saus.naam}<c:forEach
								var="ingredient" items="${saus.ingredienten}" varStatus="status">${status.first ? ": " : ", "}${ingredient}${status.last ? "." : ""}</c:forEach>
						</li>
					</c:forEach>
				</ul>
			</c:otherwise>
		</c:choose>
	</c:if>
	<c:if test="${sauzenMeerdereIngredienten != null}">
		Sauzen gezocht op meerdere ingedienten: 
		<c:forEach var="ingr" items="${paramValues.ingredienten}" varStatus="status">
			<c:if test="${not status.first}">& </c:if>${ingr} 
		</c:forEach>
		<c:choose>
			<c:when test="${empty sauzenMeerdereIngredienten}">
			Geen sauzen met deze ingredienten.
		</c:when>
			<c:otherwise>
				<ul>
					<c:forEach var="saus" items="${sauzenMeerdereIngredienten}">
						<li><img src="images/${saus.naam}.png" alt="${saus.naam}">${saus.naam}<c:forEach
								var="ingredient" items="${saus.ingredienten}" varStatus="status">${status.first ? ": " : ", "}${ingredient}${status.last ? "." : ""}</c:forEach>
						</li>
					</c:forEach>
				</ul>
			</c:otherwise>
		</c:choose>
	</c:if><c:if test="${sauzenAlleIngredienten != null}">
		Sauzen gezocht op alle ingedienten: 
		<c:forEach var="ingr" items="${paramValues.ingredientenAlle}" varStatus="status">
			<c:if test="${not status.first}">& </c:if>${ingr} 
		</c:forEach>
		<c:choose>
			<c:when test="${empty sauzenAlleIngredienten}">
			Geen sauzen met deze ingredienten.
		</c:when>
			<c:otherwise>
				<ul>
					<c:forEach var="saus" items="${sauzenAlleIngredienten}">
						<li><img src="images/${saus.naam}.png" alt="${saus.naam}">${saus.naam}<c:forEach
								var="ingredient" items="${saus.ingredienten}" varStatus="status">${status.first ? ": " : ", "}${ingredient}${status.last ? "." : ""}</c:forEach>
						</li>
					</c:forEach>
				</ul>
			</c:otherwise>
		</c:choose>
	</c:if>
	<footer>
		<a href="<c:url value="/index.htm"/>">get back</a>
	</footer>
</body>
</html>