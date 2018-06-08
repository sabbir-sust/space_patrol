/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;
import com.sabbir.spacepatroll.Main;
import java.io.File;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import org.omg.CORBA.BAD_CONTEXT;
/**

/**
 *
 * @author Kazi Sowkot Hossain
 */


public class Mainpage  {
    
    //@Override
    public static void st() {
        Stage primaryStage=new Stage();
        StackPane root = new StackPane();
        VBox V=new VBox(30);
//        final FileChooser fc=new FileChooser();
//        File file=fc.getInitialDirectory();
        ImageView im=new ImageView();
        Image img=new Image("file:ss.jpg");
        im.setImage(img);
        BackgroundSize BS=new BackgroundSize(1370, 700, true, true, true, false);
        BackgroundImage BI=new BackgroundImage(img, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BS);
        Background B=new Background(BI);
        //ImageView im=new ImageView();
        //Image img =new Image("file:stho.jpg");
//        im.setImage(img);
        im.setFitHeight(700);
        im.setFitWidth(1370);
//        root.getChildren().add(im);
        
        //Scene scene = new Scene(root, 1370,700 );
        
       Button b1=new Button("       About      ");
       Button b2=new Button("  	  New Game 	   ");
       Button b3=new Button("     Continue     ");
       Button b4=new Button("       Help       ");
       Button b5=new Button("       Exit       ");
      // b5.addActionListener(e -> System.exit(0));
      //b5.setOnAction(e ->closePrograme());
      //b5.setOnAction(actionEvent -> Platform.exit());
       V.getChildren().addAll(b1,b2,b3,b4,b5);
       b1.setStyle("-fx-font:  30 arial; -fx-base:#FFF5EE;-fx-background-radius:150; -fx-text-fill:   #FF7F50");
       b2.setStyle("-fx-font:30 arial; -fx-base:#F0F8FF;-fx-background-radius:150; -fx-text-fill:   #FF7F50");
       b3.setStyle("-fx-font:30 arial; -fx-base:#F5F5F5;-fx-background-radius:150; -fx-text-fill:  #FF7F50");
       b4.setStyle("-fx-font:30 arial; -fx-base: #FFFAFA;-fx-background-radius:150; -fx-text-fill:   #FF7F50");
       b5.setStyle("-fx-font:30 arial; -fx-base:  #FFFFFF;-fx-background-radius:150; -fx-text-fill:   #FF7F50");
       
//        btn.setText("Say 'Hello World'");
        b2.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
               Main a =new Main();
               Main.mai();
            }
        });

//        StackPane root = new StackPane();
//        root.getChildren().add(btn);
//        
       Scene scene = new Scene(root, 1370, 700);
       root.getChildren().addAll(im,V);
       V.setAlignment(Pos.CENTER);
       
//        
//        primaryStage.setTitle("Hello World!");
    
        primaryStage.setScene(scene);
       primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
//    public static void main(String[] args) {
//        launch(args);
//    }
    
}
