package org.openjfx.mycriptofx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CriptoFX extends Application {
    public static void main(String[]args){
        launch(CriptoFX.class,args);
    }
    @Override
    public void start(Stage stage){
        MyPaneGr myPaneGr = new MyPaneGr();
        Scene scene = new Scene(myPaneGr.border);
        stage.setScene(scene);
        stage.setTitle("Criptograph");
        stage.show();
    }
}