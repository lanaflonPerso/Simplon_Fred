package fr.laposte.defifx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Separator;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
//import javafx.scene.shape.Circle;
//import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Base extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		
        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 800, 600, Color.LIGHTBLUE);
        primaryStage.setScene(scene);

        
        
        final Button button1 = new Button("Bouton 1"); 
        final Button button2 = new Button("Bouton 2"); 
        final Button button3 = new Button("Bouton 3"); 
        final ToolBar toolBar = new ToolBar(); 
       
        
        
        toolBar.getItems().setAll(button1, button2, button3);
        
// 		, new Separator(), checkBox, new Separator(), radioButton); 
//        toolBar.getItems().addAll(new Separator(), createMenuButton()); 
//        toolBar.getItems().addAll(new Separator(), createSplitMenuButton()); 
//        final BorderPane root = new BorderPane(); 
        root.setTop(toolBar); 
//        final Scene scene = new Scene(root, 300, 250); 
        primaryStage.setTitle("Ma barre d'outils"); 
        primaryStage.setScene(scene); 
        primaryStage.show(); 
    } 
  
    private MenuButton createMenuButton() { 
        final MenuItem imageItem = new MenuItem("Image..."); 
        final MenuItem pdfItem = new MenuItem("PDF..."); 
        final Menu exportMenu = new Menu("Export"); 
        exportMenu.getItems().setAll(imageItem, pdfItem); 
        final MenuItem propertiesItem = new MenuItem("Propriétés..."); 
        final MenuButton menuButton = new MenuButton(); 
        menuButton.getItems().setAll(exportMenu, new SeparatorMenuItem(), propertiesItem); 
        return menuButton; 
    } 
  
    private SplitMenuButton createSplitMenuButton() { 
        final MenuItem imageItem = new MenuItem("Image..."); 
        final MenuItem pdfItem = new MenuItem("PDF..."); 
        final Menu exportMenu = new Menu("Export"); 
        exportMenu.getItems().setAll(imageItem, pdfItem); 
        final MenuItem propertiesItem = new MenuItem("Propriétés..."); 
        final SplitMenuButton splitMenuButton = new SplitMenuButton(); 
        splitMenuButton.getItems().setAll(exportMenu, new SeparatorMenuItem(), propertiesItem); 
        return splitMenuButton; 
        
        
        
       
//       DEFI 1
/*
		Circle cercle = new Circle();
		cercle.setCenterX(300);
		cercle.setCenterY(200);
		cercle.setRadius(90);
		cercle.setFill(Color.RED);
		cercle.setStroke(Color.BLUE);
		cercle.setStrokeWidth(4);
		
		Rectangle rectangle = new Rectangle();
		rectangle.setX(100);
		rectangle.setY(100);
		rectangle.setWidth(200);
		rectangle.setHeight(150);
		rectangle.setStroke(Color.BLACK);
		rectangle.setStrokeWidth(8);
		rectangle.setFill(Color.YELLOW);

		root.getChildren().add(cercle);
		root.getChildren().add(rectangle);
*/
		
//		DEFI 2
/*
		creerRectangle rectangle1 = new creerRectangle(100,200,200,150,5,Color.CADETBLUE,Color.DARKVIOLET);
		creerRectangle rectangle2 = new creerRectangle(200,300,200,150,5,Color.CHOCOLATE,Color.BURLYWOOD);
		creerRectangle rectangle3 = new creerRectangle(300,400,200,150,5,Color.BROWN,Color.RED);
		creerCercle cercle1 = new creerCercle(300,200,90,5,Color.YELLOW,Color.GREEN);
		creerCercle cercle2 = new creerCercle(400,300,90,5,Color.RED,Color.GREEN);
		creerCercle cercle3 = new creerCercle(500,400,90,5,Color.BLUE,Color.GREEN);

		root.getChildren().add(cercle1.getCercle());
		root.getChildren().add(rectangle1.getRectangle());
		root.getChildren().add(cercle2.getCercle());
		root.getChildren().add(rectangle2.getRectangle());
		root.getChildren().add(cercle3.getCercle());
		root.getChildren().add(rectangle3.getRectangle());
*/	
        
//		DEFI 3
     
		
		
//        primaryStage.show();
	}

	public static void main(String[] args) {
	       Application.launch(Base.class, args);

	}

}
