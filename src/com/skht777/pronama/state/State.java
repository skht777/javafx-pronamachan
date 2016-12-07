/**
 *
 */
package com.skht777.pronama.state;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.image.ImageView;
import javafx.stage.Window;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author skht777
 */
public class State {

    private static ImageView target;
    private static StateType current;
    private StateType type;
    private Timeline time;
    private double width, height;

    public static void setTarget(ImageView target) {
        State.target = target;
    }

    public static void launch(StateType type) {
        if (!Optional.ofNullable(current).isPresent()) setState(type);
    }

    public static State getState() {
        return current.getState();
    }

    private static void setState(StateType type) {
        Optional.ofNullable(current).map(StateType::getState).ifPresent(s -> s.time.stop());
        current = type;
        current.getState().setTarget();
    }

    State(StateType type, int rate, Frame... frames) {
        this.type = type;
        width = frames[0].getImage().getWidth();
        height = frames[0].getImage().getHeight();
        List<KeyFrame> keys = Arrays.stream(frames)
                .map(frame -> new KeyFrame(frame.getDuration(), e -> nextFrame(frame)))
                .collect(Collectors.toList());
        time = new Timeline(rate);
        time.setCycleCount(Timeline.INDEFINITE);
        time.getKeyFrames().addAll(keys);
    }

    private void setTarget() {
        time.play();
        Window window = target.getScene().getWindow();
        window.setWidth(width);
        window.setHeight(height);
    }

    private void nextFrame(Frame frame) {
        target.setImage(frame.getImage());
    }

}
