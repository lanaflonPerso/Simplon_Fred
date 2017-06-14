package com.simplon.defi2;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Separator;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Defi2 extends Application {
	
	public static void main(String[] args) { 
        launch(args); 
    } 
	
	

	 @Override 
	    public void start(Stage primaryStage) {  
	        ToolBar toolBar = new ToolBar(); 
	        BorderPane root = new BorderPane(); 
	        root.setTop(toolBar); 
	        Scene scene = new Scene(root, 300, 250); 
	        primaryStage.setTitle("Some Buttons..."); 
	        primaryStage.setScene(scene); 
	         
	        Bouton btn1 = new Bouton("AddText");
	        Bouton btn2 = new Bouton("FullScreen");
	        Bouton btn3 = new Bouton("fermer");
	        
	        
	        
	        btn1.setOnAction(new EventHandler<ActionEvent>() { 
	  		  
	    	    @Override 
	    	    public void handle(ActionEvent actionEvent) { 
	    	    	Text text = new Text(25, 125, "Voila du texte");
	    	    	root.getChildren().add(text);
	    	    } 
	    	});
	        
	        btn2.setOnAction(new EventHandler<ActionEvent>() { 
		  		  
	    	    @Override 
	    	    public void handle(ActionEvent actionEvent) { 
	    	    	primaryStage.setFullScreen(true);
	    	    	
	    	    } 
	    	});
	        btn3.setOnAction(new EventHandler<ActionEvent>() { 
		  		  
	    	    @Override 
	    	    public void handle(ActionEvent actionEvent) { 
	    	    	primaryStage.close();
	    	    } 
	    	});
	        
	        
	        toolBar.getItems().setAll(btn1,new Separator(),btn2,new Separator(),btn3);
	        primaryStage.show();
	        
	      
	    } 
	  
	  
	    
	    
	}

