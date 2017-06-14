package com.simplon.defi5;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class RectanglePerso extends Rectangle {

	public RectanglePerso(double x, double y, double width, double height,Color c1,Color c2,double sw) {
		super(x, y, width, height);
		this.setFill(c1);
		this.setStroke(c2);
		this.setStrokeWidth(sw);
	}
	


}
