/**
 *
 */
package com.skht777.pronama;

import com.skht777.pronama.state.State;
import com.skht777.pronama.state.StateType;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

/**
 * @author skht777
 */
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
        primaryStage.setOnShown(e -> {
            State.setState(StateType.NORMAL);
            primaryStage.centerOnScreen();
        });
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("mascot.fxml")));
        scene.setFill(null);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
