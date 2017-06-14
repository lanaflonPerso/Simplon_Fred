<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <div class="container">
    <div class="row">

      <h3>Résultat de la recherche</h3>
      <div class="table-responsive table-hover table-bordered table-striped">
        <table class="table">
          <thead>
            <tr>
              <th>Propriétaire</th>
              <th>Appartement</th>
              <th>Adresse</th>
              <th>Sélection</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td>DUPONT Alain</td>
              <td>F3 proche métro</td>
              <td>2, allée Retour</td>
              <td class="selectElm"><input type="radio" name="selection" id="c1"></td>
            </tr>
            <tr>
              <td>MARCHAND Gérard</td>
              <td>Duplex F4</td>
              <td>16, rue des artichauts</td>
              <td class="selectElm"><input type="radio" name="selection" id="c2"></td>
            </tr>
            <tr>
              <td>MICHEL Henry</td>
              <td>T4 neuf</td>
              <td>46, bld de la République</td>
              <td class="selectElm"><input type="radio" name="selection" id="c3"></td>
            </tr>
            <tr>
              <td>MERLE Louis</td>
              <td>Studio aménagé</td>
              <td>33, square route</td>
              <td class="selectElm"><input type="radio" name="selection" id="c4"></td>
            </tr>
            <tr>
              <td>HERNANDEZ Juan</td>
              <td>F2 avec terrasse</td>
              <td>12, impasse de la liberté</td>
              <td class="selectElm"><input type="radio" name="selection" id="c5"></td>
            </tr>
          </tbody>
        </table>
      </div>

      <div class="margeBouton" style="height:50px;width:100%"></div>
      <div class="form-group">
        <div class="text-center">
          <button type="submit" class="btn btn-primary">Réserver</button>
        </div>
      </div>

    </div>
  </div>
