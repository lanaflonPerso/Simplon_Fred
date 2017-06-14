<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="head.jsp" %>
 	<title>AirBnb - Propriétaire</title>
</head>
<body>
<%@ include file="entete.jsp" %>

  <div class="container">
    <div class="row">
	  <div class="col-lg-6 col-md-8 col-sm-12">
        <form class="form-horizontal" action="creerProprio" method="post">
	      <h3 class="text-right">S'inscrire/S'identifier</h3>
          <div class="form-group">
            <label class="control-label col-lg-4 hidden-xs hidden-sm" for="nom">Nom</label>
            <div class="col-lg-8">
              <input type="text" class="form-control" id="nom" name="nom" placeholder="Votre nom">
            </div>
          </div>
          <div class="form-group">
            <label class="control-label col-lg-4 hidden-xs hidden-sm" for="pre">Prénom</label>
            <div class="col-lg-8">
              <input type="text" class="form-control" id="pre" name="pre" placeholder="Votre prénom">
            </div>
          </div>
          <div class="form-group">
            <label class="control-label col-lg-4 hidden-xs hidden-sm" for="tel">Téléphone</label>
            <div class="col-lg-8">
              <input type="text" class="form-control" id="tel" name="tel" placeholder="Votre n° de téléphone">
            </div>
          </div>
          <div class="form-group">
            <label class="control-label col-lg-4 hidden-xs hidden-sm" for="mel">eMail</label>
            <div class="col-lg-8">
              <input type="text" class="form-control" id="mel" name="mel" placeholder="Votre adresse mail">
            </div>
          </div>
          <div class="margeBouton"></div>
          <div class="form-group">
            <div class="text-center">
              <button type="submit" class="btn btn-primary">Login</button>
            </div>
          </div>
        </form>
      </div>
    </div>
  </div>

  <%@ include file="foot.jsp" %>
