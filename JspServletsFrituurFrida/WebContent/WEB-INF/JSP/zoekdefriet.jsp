<%@page contentType='text/html' pageEncoding='UTF-8'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<!doctype html>
<html lang='nl'>
<head>
<title>Frituur Frida: zoek de friet</title>
<link rel='shortcut icon' href='images/favicon.ico' type='image/x-icon' />
<meta name='viewport' content='width=device-width,initial-scale=1'>
<link rel='stylesheet' href='styles/default.css'>
</head>
<body>
	<h1>Frituur Frida: ons frietspel!</h1>
	<form method="post" id ="frietform" name="frietform">
		<c:forEach var="deur" items="${deuren}" varStatus="status">
			<button type="submit" name="volgnummerknop" 
			<%-- value="${status.index}" wordt nu doorgegeven aan javascript functie--%> 
			onclick="buttonClick(${status.index})" ${deur == "deuropen" ? "disabled": ""}>
				<img alt="${deur}" src='<c:url value="images/${deur}.png"/>' />
			</button>
		</c:forEach>
		<input type="hidden" name="volgnummer" id="volgnummer" />
		<input type="submit" name="nieuwspel" id="nieuwspel" value="nieuw spel"/>		
	</form>	
	<script>
	//There is a caveat while using JavaScript to submit form ( form.submit() ),
	//it doesn't include name of submit button as request parameter. 
	//If you are checking for name of submit button on server side your code will fail
	// Traditionally name of submit button is included in HTTP request only if form 
	//is submitted by clicking submit button otherwise no. Fortunately there is 
	//a workaround to this problem, You can call document.form_name.submit_name.click() 
	//to simulate click on submit button.
// 		document.getElementById('frietform').onsubmit = function() {
// 		// elke knop die ik hier disable komt niet door tot in me'n servlet (null, gvd)
// 			document.getElementById('nieuwspel').disabled = true;	
// 			var deurknoppen = document.getElementsByName('volgnummer');		
// 			// de 'Java style foreach' werkt hier niet goed (9 elementen ipv 7???)
// 			// dus lopen met hulp variabele i
// 			for (var i = 0; i < deurknoppen.length; i++) {				
// 				deurknoppen[i].disabled = true;
// 			}
// 		}
		// staat enabled, maar werkt niet
// 		function activateButtons() {
// 			document.getElementById('nieuwspel').disabled = false;
// 		}
		// deurknoppen disabelen, werkt niet (zie ook boven 'Java style foreach' opm):
// 			var deurknoppen = document.getElementsByName('volgnummer');		
// 			for (var deurknop in deurknoppen) {
// 				deurknop.disabled = true;
// 			}	

// bovenstaande lijdt tot (en dat hidden field andere aanpak zou aparte id's voor elke volgnummerknop zijn ...):
		document.getElementById('nieuwspel').onclick = function() {		
			//document.getElementById('nieuwspel').disabled = true;	// dan is m'n knop null gvd
			var deurknoppen = document.getElementsByName('volgnummerknop');				
			for (var i = 0; i < deurknoppen.length; i++) {				
				deurknoppen[i].disabled = true;
			}
			//document.getElementById('nieuwspel').disabled = false;
			document.frietform.nieuwspel.click();
		}
		function buttonClick(volgnummer) {			
			document.getElementById('nieuwspel').disabled = true;	
			var deurknoppen = document.getElementsByName('volgnummerknop');				
			for (var i = 0; i < deurknoppen.length; i++) {				
				if (i != volgnummer) {// idem ... anders is m'n knop null
					deurknoppen[i].disabled = true;
				}
			}
			document.getElementById('volgnummer').value = volgnummer;
			// zal de eerste volgnummerknop geven maar ik reken nu op het hidden field dus who cares
			// document.getElementsByName('volgnummerknop')[0].click();
			deurknoppen[volgnummer].click();
		}

	</script>
</body>
</html>