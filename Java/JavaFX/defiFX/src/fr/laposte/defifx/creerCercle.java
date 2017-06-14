package fr.laposte.defifx;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class creerCercle {
	double origineX, origineY, rayon, largeurBord;
	Color couleur, couleurBord;

	public creerCercle(double origineX, double origineY, double rayon, double largeurBord, Color couleur,
			Color couleurBord) {
		super();
		this.origineX = origineX;
		this.origineY = origineY;
		this.rayon = rayon;
		this.couleur = couleur;
		this.largeurBord = largeurBord;
		this.couleurBord = couleurBord;
	}

	public Circle getCercle() {
		Circle cercle = new Circle();
		cercle.setCenterX(origineX);
		cercle.setCenterY(origineY);
		cercle.setRadius(rayon);
		cercle.setFill(couleur);
		cercle.setStroke(couleurBord);
		cercle.setStrokeWidth(largeurBord);
		return cercle;

	}


}
