/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package javafxtransitionanimation;

import javafx.animation.PathTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.CubicCurveTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author JavierCastilloM
 */
public class JavaFXTransitionAnimation extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        

        Circle circle = new Circle(50, Color.TRANSPARENT);
        circle.setStroke(Color.BLACK);
        
        Rectangle rectangle = new Rectangle(20,40,Color.YELLOW);
        
        Pane pane = new Pane();
        
        Path path = new Path(); 
        
        path.getElements().add (new MoveTo (0f, 50f));
        path.getElements().add (new CubicCurveTo (40f, 10f, 390f, 240f, 1904, 50f));
                
        PathTransition pathTransition = new PathTransition(); 
        
        pathTransition.setDuration(Duration.millis(4000)); 
        
        pathTransition.setNode(rectangle);
        
        pathTransition.setPath(circle);  
        
        pathTransition.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        
        pathTransition.setCycleCount(99999);
        
    
        
        pathTransition.setAutoReverse(false); 

        
        
        Scene scene = new Scene(pane, 300, 200);
        
        circle.setCenterX(pane.getWidth()/2);
        circle.setCenterY(pane.getHeight()/2);        
        pane.getChildren().addAll(circle,rectangle);

        pathTransition.play();
        pane.setOnMousePressed(event -> {
            pathTransition.pause();
        });
        
        pane.setOnMouseReleased(event -> {
            pathTransition.play();
        });
        
        
        
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
