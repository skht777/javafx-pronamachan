/**
 *
 */
package com.skht777.pronama.state;

import javafx.scene.image.Image;
import javafx.util.Duration;

import java.util.HashMap;
import java.util.Map;

/**
 * @author skht777
 */
public class Frame {

    private static Map<String, Image> image;
    private int time;
    private String imageName;

    static {
        image = new HashMap<>();
    }

    Frame(int time, String imageName) {
        this.time = time;
        this.imageName = imageName;
        image.putIfAbsent(imageName, new Image(imageName));
    }

    public Duration getDuration() {
        return Duration.millis(time);
    }

    public Image getImage() {
        return image.get(imageName);
    }

}
