<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <link rel="stylesheet" href="css/style.css">
    <script src="js/monfichier.js"></script>
	<title>Test</title>
</head>
<body>

	<%@ include file="entete.jsp" %>

<%-- 	<p>Bonjour à tous !</p>
	<p>
		<% 	
			String donnee = (String) request.getAttribute("monMessage");
			out.println(donnee);
		%>
	</p>
 --%>
 <div class="container">
  <form>
    <div class="form-group row">
      <label for="inputNom" class="col-sm-2 col-form-label">Nom</label>
      <div class="col-sm-10">
        <!-- <input type="text" class="form-control" id="nom" placeholder="Nom"> -->
        <input type="text" class="form-control" id="nom">
      </div>
    </div>
    <div class="form-group row">
      <label for="inputPrenom" class="col-sm-2 col-form-label">Prénom</label>
      <div class="col-sm-10">
        <!-- <input type="text" class="form-control" id="prenom" placeholder="Prénom"> -->
        <input type="text" class="form-control" id="prenom">
      </div>
    </div>
    <div class="form-group row">
      <label for="inputTelephone" class="col-sm-2 col-form-label">Téléphone</label>
      <div class="col-sm-10">
        <!-- <input type="text" class="form-control" id="telephone" placeholder="Téléphone"> -->
        <input type="text" class="form-control" id="telephone">
      </div>
    </div>
    <div class="form-group row">
      <label for="inputEmail" class="col-sm-2 col-form-label">Email</label>
      <div class="col-sm-10">
        <!-- <input type="text" class="form-control" id="email" placeholder="Email"> -->
        <input type="text" class="form-control" id="email">
      </div>
    </div>
    
    <div class="form-group row">
      <div class="offset-sm-2 col-sm-10">
        <button type="submit" class="btn btn-primary">Sign in</button>
      </div>
    </div>
  </form>
</div>

 
</body>
</html>