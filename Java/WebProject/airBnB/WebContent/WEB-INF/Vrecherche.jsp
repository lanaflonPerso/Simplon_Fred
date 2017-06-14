<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="head.jsp" %>
 	<title>AirBnb - Recherche</title>
</head>
<body>
<%@ include file="entete.jsp" %>

  <div class="container">
    <div class="row">
      <div class="col-lg-6 col-md-8 col-sm-12">
        <form class="form-horizontal" method="post">
	      <h3 class="text-right">Rechercher un logement</h3>
          <div class="form-group">
            <label class="control-label col-lg-4 hidden-xs hidden-sm" for="vil">Ville</label>
            <div class="col-lg-8">
              <input type="text" class="form-control" name="vil" id="vil" placeholder="Ville recherchée">
            </div>
          </div>
          <div class="form-group">
            <label class="control-label col-lg-4 hidden-xs hidden-sm" for="deb">Date de début</label>
            <div class="col-lg-8">
              <div class='input-group date' id='datetimepicker1'>
                <input type='text' class="form-control" placeholder="Date de début de location" name="deb" id="deb" />
                <span class="input-group-addon">
                  <span class="glyphicon glyphicon-calendar">
                  </span>
                </span>
              </div>
            </div>
          </div>
          <div class="form-group">
            <label class="control-label col-lg-4 hidden-xs hidden-sm" for="fin">Date de fin</label>
            <div class="col-lg-8">
              <div class='input-group date' id='datetimepicker2'>
                <input type='text' class="form-control" placeholder="Date de fin de location" name="fin" id="fin" />
                <span class="input-group-addon">
                  <span class="glyphicon glyphicon-calendar">
                  </span>
                </span>
              </div>
            </div>
          </div>
          <div class="margeBouton"></div>
          <div class="form-group">
            <div class="text-center">
              <button type="submit" class="btn btn-primary">Rechercher</button>
            </div>
          </div>
        </form>
      </div>
    </div>
  </div>

<%@ include file="foot.jsp" %>
