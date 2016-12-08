/**
 *
 */
package com.skht777.pronama;


import com.skht777.pronama.state.State;
import com.skht777.pronama.state.StateType;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseDragEvent;
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
    private boolean drag;

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

    @FXML
    private void changeState(MouseEvent e) {
        Object o = e.getEventType();
        if (o == MouseDragEvent.DRAG_DETECTED) {
            State.setState(StateType.DRAG);
            drag = true;
        } else if (o == MouseEvent.MOUSE_RELEASED) {
            if (drag) State.setState(StateType.NORMAL);
            else if (e.getClickCount() > 1) State.setState(StateType.NORMAL, StateType.SPEECH);
            drag = false;
        }
    }

    private void mousePos(MouseEvent e) {
        mouseX = e.getScreenX();
        mouseY = e.getScreenY();
    }

}
