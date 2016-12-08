/**
 *
 */
package com.skht777.pronama.state;

/**
 * @author skht777
 */
public enum StateType {

    NORMAL(3000,
            new Frame(0, "/sd_eye1.png"),
            new Frame(100, "/sd_eye2.png"),
            new Frame(200, "/sd_eye1.png"),
            new Frame(300, "/sd_eye0.png"),
            new Frame(3000, "/sd_eye0.png")),
    DRAG(Integer.MAX_VALUE,
            new Frame(1, "/sd04.png")),
    SPEECH(3000,
            new Frame(0, "/sd_mouth1.png"),
            new Frame(200, "/sd_mouth2.png"),
            new Frame(400, "/sd_mouth1.png"),
            new Frame(600, "/sd_mouth0.png"));

    private State state;

    StateType(int rate, Frame... frames) {
        state = new State(rate, frames);
    }

    public State getState() {
        return state;
    }

}
