package com.simplon.defi3;

import com.simplon.defi1.RectanglePerso;
import com.simplon.defi2.Bouton;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Separator;
import javafx.scene.control.ToolBar;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Defi3 extends Application {

	public static void main(String[] args) { 
		launch(args); 
	} 

	double x = 50;
	double y = 50;

	@Override 
	public void start(Stage primaryStage) {  
		ToolBar toolBar = new ToolBar(); 
		BorderPane root = new BorderPane(); 
		root.setTop(toolBar); 
		Scene scene = new Scene(root, 300, 400); 
		primaryStage.setTitle("Déplacer un carré"); 
		primaryStage.setScene(scene); 

		Bouton btn1 = new Bouton("Carré");
		Bouton btn2 = new Bouton("left");
		Bouton btn3 = new Bouton("right");
		Bouton btn4 = new Bouton("up");
		Bouton btn5 = new Bouton("down");
		Bouton btn6 = new Bouton("X");
		

		
		Rectangle carre = new RectanglePerso(x, y, 20, 20,Color.GREEN,Color.DARKGREEN,5);
		

		btn1.setOnAction(new EventHandler<ActionEvent>() { 

			@Override 
			public void handle(ActionEvent actionEvent) { 
				
				root.getChildren().add(carre);
			} 
		});

		btn2.setOnMouseClicked(new EventHandler<MouseEvent>() { 

			@Override 
			public void handle(MouseEvent mEvent) { 
				if(x>5){
				x = x - 5 ;

		        carre.setX(x);
				}
			} 
		});
		btn3.setOnMouseClicked(new EventHandler<MouseEvent>() { 

			@Override 
			public void handle(MouseEvent mEvent) { 
				if(x<=270){
				x = x + 5 ;

		        carre.setX(x);
				}
			} 
		});
		btn4.setOnAction(new EventHandler<ActionEvent>() { 

			@Override 
			public void handle(ActionEvent actionEvent) { 
				if(y>40){	
			y = y - 5 ;

		        carre.setY(y);
				}
		       
			} 
		});
		
		btn5.setOnAction(new EventHandler<ActionEvent>() { 

			@Override 
			public void handle(ActionEvent actionEvent) { 
				if(y<=370){
			y = y + 5 ;

		        carre.setY(y);
				}
		       
			} 
		});
		
		btn6.setOnAction(new EventHandler<ActionEvent>() { 

			@Override 
			public void handle(ActionEvent actionEvent) { 
				primaryStage.close();
			} 
		});


		toolBar.getItems().setAll(btn1,new Separator(),btn2,btn3,btn4,btn5,new Separator(),btn6);
		primaryStage.show();


	} 




}