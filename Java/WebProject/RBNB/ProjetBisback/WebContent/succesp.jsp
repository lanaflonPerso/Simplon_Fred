<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Succès d'ajout</title>
<link href="bootstrap.css" rel="stylesheet"> 
<body>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-6 col-md-offset-3">
				<img src="image\success.jpg"
					alt="maison" width="100%" height="400px" class="img-rounded">
			</div>

			<div class="row">
				<div class="col-md-6 col-md-offset-3">
					<div class="alert alert-success" role="alert">
						<h1>VOUS AVEZ BIEN ETE AJOUTE !</h1>
					</div>
				</div>
			</div>
		</div>


<div class="row">
				<div class="col-md-6 col-md-offset-3">
					<table class="table table-bordered">
						<caption><h2>Notez votre id</h2></caption>
						<tr>
							<th>ID</th>
							<th>Nom</th>
							<th>Prenom</th>

						</tr>
						
							<tr>
								<td class="success">${proprietaire.id}</td>
								<td>${proprietaire.nom}</td>
								<td>${proprietaire.prenom}</td>


							</tr>
						
					</table>

				</div>
			</div>
		<div class="row">
			<div class="col-md-6 col-md-offset-5">
			
			<a type="button" class="btn btn-primary btn-lg btn-block" href="formulairep.html">Ajouter un propriétaire</a>
<a type="button" class="btn btn-default btn-lg btn-block"  href="formulairel.html">Ajouter un autre logement </aS>
			

</div>
</div>

</div>

</body>
</html>