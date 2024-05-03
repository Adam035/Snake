package com.lipian.snake;

import com.lipian.snake.screen.Frame;
import com.lipian.snake.screen.Panel;

public class Main {
    public static void main(String[] args) {
        Frame frame = new Frame();
        frame.add(new Panel());
        frame.setVisible(true);
    }
}
