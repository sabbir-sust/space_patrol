/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

import javafx.util.Duration;

import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
/**
 *
 * @author Kazi Sowkot Hossain
 */
public class FinalProject extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        
        StackPane root = new StackPane();
        ImageView im=new ImageView();
        Image img =new Image("file:Gif1.gif");
        im.setImage(img);
        im.setFitHeight(700);
        im.setFitWidth(1370);
        root.getChildren().add(im);
        
        Scene scene = new Scene(root, 1370,700 );
        
        //primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
       // Mainpage.st();
        
        PauseTransition delay =new PauseTransition(Duration.seconds(14));
        PauseTransition delay1 =new PauseTransition(Duration.seconds(13));
        delay.setOnFinished(event -> primaryStage.close());
        delay1.setOnFinished(event -> Mainpage.st());
        delay.play();
        delay1.play();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
