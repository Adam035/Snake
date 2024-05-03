package com.lipian.snake.key_adapter;

import com.lipian.snake.direction.Direction;
import com.lipian.snake.body.Snake;
import lombok.AllArgsConstructor;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

@AllArgsConstructor
public class SnakeKeyAdapter extends KeyAdapter {
    private Snake snake;

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W -> snake.setDirection(Direction.UP);
            case KeyEvent.VK_D -> snake.setDirection(Direction.RIGHT);
            case KeyEvent.VK_S -> snake.setDirection(Direction.DOWN);
            case KeyEvent.VK_A -> snake.setDirection(Direction.LEFT);
        }
    }

}
