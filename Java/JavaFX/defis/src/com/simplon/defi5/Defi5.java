package com.simplon.defi5;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Defi5 extends Application {
	
	double carX = 0;//position initiale voiture
	
	

	public static void main(String[] args) {
		Application.launch(Defi5.class, args);
	}

	@Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 800, 600);
        primaryStage.setScene(scene);
        
        
        
       
        //DECOR
        RectanglePerso ciel = new RectanglePerso(0, 0, 800, 400,Color.LIGHTSEAGREEN,Color.DARKGREEN,0);
        CerclePerso soleil = new CerclePerso(100,70,50,Color.YELLOW,Color.ORANGE,10);
        RectanglePerso sol = new RectanglePerso(0, 400, 800, 200,Color.GREEN,Color.DARKGREEN,5);
        //MAISON
        CerclePerso knob = new CerclePerso(100,370,2,Color.YELLOW,Color.ORANGE,0);
        RectanglePerso house = new RectanglePerso(50, 280, 120, 120,Color.RED,Color.DARKRED,5);
        RectanglePerso door = new RectanglePerso(90, 340, 40, 60,Color.BROWN,Color.DARKRED,2);
        RectanglePerso window = new RectanglePerso(60, 290, 40, 40,Color.YELLOW,Color.DARKRED,2);
        RectanglePerso bar = new RectanglePerso(78, 290, 5, 40,Color.BROWN,Color.DARKRED,0);
        RectanglePerso bar2 = new RectanglePerso(60, 308, 40, 5,Color.BROWN,Color.DARKRED,0);
        RectanglePerso garage = new RectanglePerso(170, 330, 120, 70,Color.YELLOW,Color.DARKRED,5);
       
        
        //VOITURE
        Voiture voiture = new Voiture(carX);
        		//éléments de la voiture
        	RectanglePerso carrosserie = new RectanglePerso(350, 370, 70, 20,Color.GAINSBORO,Color.DARKRED,0);
        	RectanglePerso toit = new RectanglePerso(370, 360, 40, 15,Color.TRANSPARENT,Color.GAINSBORO,4);
        	RectanglePerso montant = new RectanglePerso(390, 360, 5, 15,Color.GAINSBORO,Color.DARKRED,0);
        	CerclePerso roueAv = new CerclePerso(365,390,6,Color.TRANSPARENT,Color.BLACK,5);
        	CerclePerso roueAr = new CerclePerso(405,390,6,Color.TRANSPARENT,Color.BLACK,5);
        	RectanglePerso phareAv = new RectanglePerso(352, 372, 4, 8,Color.BISQUE,Color.LIGHTYELLOW,1);
        	RectanglePerso phareAr = new RectanglePerso(415, 375, 5, 8,Color.PALEVIOLETRED,Color.DARKRED,1);
        //BOUTONS
        Group BTN = new Group();
			Bouton btn1 = new Bouton("left",40,550);
			Bouton btn2 = new Bouton("right",120,550);
			
			
			btn1.setOnAction(new EventHandler<ActionEvent>() { 
		  		  
	    	    @Override 
	    	    public void handle(ActionEvent actionEvent) { 
					if(carX>=-160){
	    	    		carX-=20;
	    	    		voiture.setScaleX(1);//met la voiture dans le sens de la marche
	    	    	voiture.setLayoutX(carX);	
	    	    	}
	    	    } 
	    	});
			
			btn2.setOnAction(new EventHandler<ActionEvent>() { 
		  		  
	    	    @Override 
	    	    public void handle(ActionEvent actionEvent) { 
					if(carX<380){
	    	    		carX+=20;
	    	    		voiture.setScaleX(-1);
	    	    	voiture.setLayoutX(carX);	
	    	    	}
	    	    } 
	    	});
			
        
       
        BTN.getChildren().setAll(btn1,btn2);       
		voiture.getChildren().setAll(carrosserie,toit,roueAv,roueAr,montant,phareAv,phareAr);
        
		root.getChildren().add(ciel);
        root.getChildren().add(soleil);
        root.getChildren().add(sol);
        root.getChildren().add(house);
        root.getChildren().add(door);
        root.getChildren().add(window);
        root.getChildren().add(bar);
        root.getChildren().add(bar2);
        root.getChildren().add(knob);
        root.getChildren().add(voiture);
        root.getChildren().add(garage);
        
        
        root.getChildren().add(BTN);
        
        
        
        primaryStage.show();
    }
	
}
