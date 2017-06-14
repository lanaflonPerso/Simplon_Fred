package com.simplon.defi5;

import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

public class CerclePerso extends Circle {

	/**
	 * @param centerX
	 * @param centerY
	 * @param radius
	 * @param fill
	 */
	public CerclePerso(double centerX, double centerY, double radius, Paint fill,Color cc,double stroke) {
		super(centerX, centerY, radius, fill);
		//réglage de la couleur de la bordure et de son épaisseur
		this.setStroke(cc);
        this.setStrokeWidth(stroke);
	}

	

}