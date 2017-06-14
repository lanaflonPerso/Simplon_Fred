<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>RESUTAT DE RECHERCHE</title>
<link href="bootstrap.css" rel="stylesheet">


</head>
<body>







	<div class="container-fluid">
		<div class="row">
			<div class="col-md-6 col-md-offset-3">
				<img src="image\cle.png"
					alt="maison" width="100%" height="400px" class="img-rounded">
			</div>

			<div class="row">
				<div class="col-md-6 col-md-offset-3">
					<div class="alert alert-success" role="alert">
						<h1>VOICI LES RESULTATS DE VOTRE RECHERCHE</h1>
					</div>
				</div>
			</div>
		</div>


<div class="row">
				<div class="col-md-6 col-md-offset-3">
					<table class="table table-bordered">
						
						
						<tr>
							<th>ID logement</th>
							<th>description</th>
							<th>rue</th>
							<th>ville</th>
							<th>dispo du</th>
							<th>au</th>

						</tr>
							<tr>
								<td>${logement.id}</td>
								<td>${logement.description}</td>
								<td>${logement.adresse.rue}</td>
								<td>${logement.adresse.ville}</td>
								<td>${logement.disponibilité.dateDu}</td>
								<td>${logement.disponibilité.dateAu}</td>

							</tr>
						
					</table>

				</div>
			</div>




<%-- les résultats de votre recherche sont: <br>
id : ${logement.id} <br>
description: ${logement.description} <br>
Addresse :  rue ${logement.adresse.rue} ville ${logement.adresse.ville} <br>
Disponibilite: du ${logement.disponibilité.dateDu}, au ${logement.disponibilité.dateAu}<br>
 --%>

<a type="button" class="btn btn-primary btn-lg btn-block" href="formulairer.html">Faire une autre recherche</a>
</div>
</body>
</html>
