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

    public Panel() {
        setBackground(Color.darkGray);
        setFocusable(true);
        snake = new Snake(new Node(4, 12));
        addKeyListener(new SnakeKeyAdapter(snake));
        apple = new Apple();
        start();
    }

    private boolean checkCollision() {
        return snake.checkCollision(apple.getX(), apple.getY());
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
        Node newNode = snake.move();
        if (checkCollision()) {
            apple.move();
            snake.addNode(newNode);
        }
        repaint();
    }
}
