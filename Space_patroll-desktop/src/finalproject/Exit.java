/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Kazi Sowkot Hossain
 */
public class Exit  {
    
   
    //@Override
public void start(Stage mainStage) throws Exception {

    Scene scene = new Scene(new Region());
    mainStage.setWidth(640);
    mainStage.setHeight(480);
    mainStage.setScene(scene);

    //this makes all stages close and the app exit when the main stage is closed
//    mainStage.setOnCloseRequest(e -> Platform.exit());

    //add real stuff to the scene...
    //open secondary stages... etc...
}

    /**
     * @param args the command line arguments
     */
//    public static void main(String[] args) {
//        launch(args);
//    }
//    
}
