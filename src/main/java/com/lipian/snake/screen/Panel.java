package com.lipian.snake.screen;

import com.lipian.snake.apple.Apple;
import com.lipian.snake.key_adapter.SnakeKeyAdapter;
import com.lipian.snake.body.Node;
import com.lipian.snake.body.Snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Panel extends JPanel implements ActionListener {
    private static final int DELAY = 150;
    private final Snake snake;
    private final Apple apple;
    private boolean isRunning;

    public Panel() {
        isRunning = true;
        setBackground(Color.darkGray);
        setFocusable(true);
        snake = new Snake(new Node(4, 12));
        addKeyListener(new SnakeKeyAdapter(snake));
        apple = new Apple();
        start();
    }

    private void checkCollision() {
        Node newNode = snake.move();
        boolean isAppleEaten = snake.checkPosition(apple.getX(), apple.getY());
        if (isAppleEaten) {
            apple.move();
            snake.addNode(newNode);
        }
    }

    private void isCollision() {
        if (snake.isCollision()) isRunning = false;
    }

    private void start() {
        Timer timer = new Timer(DELAY, this);
        timer.start();
    }

    private void paintGrid(Graphics g) {
        g.setColor(new Color(50, 50, 50));
        for (int x = 0; x < Frame.WIDTH; x += Node.SIZE)
            for (int y = 0; y < Frame.HEIGHT; y += Node.SIZE) {
                g.drawLine(x, 0, x, Frame.HEIGHT);
                g.drawLine(0, y, Frame.WIDTH, y);
            }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        apple.paint(g);
        snake.paint(g);
        paintGrid(g);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (isRunning) {
            checkCollision();
            isCollision();
        }
        repaint();
    }
}
