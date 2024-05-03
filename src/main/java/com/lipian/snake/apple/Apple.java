package com.lipian.snake.apple;

import com.lipian.snake.body.Node;
import lombok.Getter;

import java.awt.*;
import java.util.Random;

@Getter
public class Apple {
    private int x, y;

    public Apple() {
        move();
    }

    public void move() {
        Random random = new Random();
        x = random.nextInt(0, 20);
        y = random.nextInt(0, 14);
    }

    public void paint(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(x * Node.SIZE, y * Node.SIZE, Node.SIZE, Node.SIZE);
    }
}
