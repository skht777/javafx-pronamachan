/**
 *
 */
package com.skht777.pronama;


import com.skht777.pronama.state.State;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Window;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author skht777
 */
public class MascotController implements Initializable {

    @FXML
    private ImageView view;
    private double mouseX;
    private double mouseY;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        State.setTarget(view);
    }

    @FXML
    private void dragged(MouseEvent e) {
        Window window = view.getScene().getWindow();
        window.setX(window.getX() + e.getScreenX() - mouseX);
        window.setY(window.getY() + e.getScreenY() - mouseY);
        mousePos(e);
    }

    @FXML
    private void pressed(MouseEvent e) {
        mousePos(e);
    }

    private void mousePos(MouseEvent e) {
        mouseX = e.getScreenX();
        mouseY = e.getScreenY();
    }

}
