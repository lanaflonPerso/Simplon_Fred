package fr.laposte.defifx;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class creerRectangle {
	double origineX, origineY, largeur, hauteur, largeurBord;
	Color couleur, couleurBord;
	
	public creerRectangle(double origineX, double origineY, double largeur, double hauteur, double largeurBord,
			Color couleur, Color couleurBord) {
		super();
		this.origineX = origineX;
		this.origineY = origineY;
		this.largeur = largeur;
		this.hauteur = hauteur;
		this.largeurBord = largeurBord;
		this.couleur = couleur;
		this.couleurBord = couleurBord;
	}
	
	public Rectangle getRectangle() {
		Rectangle rectangle = new Rectangle();
		rectangle.setX(origineX);
		rectangle.setY(origineY);
		rectangle.setWidth(largeur);
		rectangle.setHeight(hauteur);
		rectangle.setStroke(couleur);
		rectangle.setStrokeWidth(largeurBord);
		rectangle.setFill(couleurBord);
		return rectangle;
		
	}

}
