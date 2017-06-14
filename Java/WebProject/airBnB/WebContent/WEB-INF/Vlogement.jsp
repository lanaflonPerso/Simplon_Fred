<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="head.jsp" %>
 	<title>AirBnb - Logement</title>
</head>
<body>
<%@ include file="entete.jsp" %>

  <div class="container">
    <div class="row">    
      <div class="col-lg-6 col-md-8 col-sm-12">
        <form class="form-horizontal" method="post">
	      <h3 class="text-right">Ajouter un logement</h3>
          <div class="form-group">
            <label class="control-label col-lg-4 hidden-xs hidden-sm" for="rue">Rue</label>
            <div class="col-lg-8">
              <input type="text" class="form-control" id="rue" name="rue" placeholder="Votre adresse">
            </div>
          </div>
          <div class="form-group">
            <label class="control-label col-lg-4 hidden-xs hidden-sm" for="cpl">Code postal</label>
            <div class="col-lg-8">
              <input type="text" class="form-control" id="cpl" name="cpl" placeholder="Votre code postal">
            </div>
          </div>
          <div class="form-group">
            <label class="control-label col-lg-4 hidden-xs hidden-sm" for="vil">Ville</label>
            <div class="col-lg-8">
              <input type="text" class="form-control" id="vil" name="vil" placeholder="Votre ville">
            </div>
          </div>
          <div class="form-group">
            <label class="control-label col-lg-4 hidden-xs hidden-sm" for="typ">Type de logement</label>
            <div class="col-lg-8">
              <select class="form-control" name="typ">
              	<option value=""></option>
              	<option value="Appartement">Appartement</option>
              	<option value="Maison">Maison</option>
              	<option value="Loft">Loft</option>
              </select>
            </div>
          </div>
          <div class="form-group">
            <label class="control-label col-lg-4 hidden-xs hidden-sm" for="des">Description</label>
            <div class="col-lg-8">
              <textarea class="form-control" rows="5" id="des" name="des" placeholder="Votre description"></textarea>
            </div>
          </div>
          <div class="margeBouton"></div>
          <div class="form-group">
            <div class="text-center">
              <button type="submit" class="btn btn-primary">Enregistrer</button>
            </div>
          </div>
        </form>
      </div>
    </div>
  </div>

<%@ include file="foot.jsp" %>
