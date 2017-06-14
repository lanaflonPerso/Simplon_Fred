package com.simplon.defi1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Defi1 extends Application {


	public static void main(String[] args) {
		Application.launch(Defi1.class, args);
	}

	@Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 800, 600, Color.LIGHTSEAGREEN);
        primaryStage.setScene(scene);

        primaryStage.show();
        
       
        
        CerclePerso soleil = new CerclePerso(100,70,50,Color.YELLOW,Color.ORANGE,10);
        CerclePerso knob = new CerclePerso(250,370,2,Color.YELLOW,Color.ORANGE,0);
        
        
        RectanglePerso sol = new RectanglePerso(0, 400, 800, 200,Color.GREEN,Color.DARKGREEN,5);
        RectanglePerso house = new RectanglePerso(200, 280, 120, 120,Color.RED,Color.DARKRED,5);
        RectanglePerso door = new RectanglePerso(240, 340, 40, 60,Color.BROWN,Color.DARKRED,2);
        RectanglePerso window = new RectanglePerso(210, 290, 40, 40,Color.YELLOW,Color.DARKRED,2);
        RectanglePerso bar = new RectanglePerso(228, 290, 5, 40,Color.BROWN,Color.DARKRED,0);
        RectanglePerso bar2 = new RectanglePerso(210, 308, 40, 5,Color.BROWN,Color.DARKRED,0);
       
       
        
        
        
        root.getChildren().add(soleil);//on ajoute le cercle au groupe root
        root.getChildren().add(sol);
        root.getChildren().add(house);
        root.getChildren().add(door);
        root.getChildren().add(window);
        root.getChildren().add(bar);
        root.getChildren().add(bar2);
        root.getChildren().add(knob);
        primaryStage.show();
    }
	
}
