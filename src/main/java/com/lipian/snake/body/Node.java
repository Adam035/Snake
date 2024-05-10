package com.lipian.snake.body;

import com.lipian.snake.direction.Direction;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;

@Setter
@Getter
public class Node {
    public static final int SIZE = 40;
    private Direction direction;
    private Node next;
    private int x, y;

    public Node(int x, int y) {
        direction = Direction.RIGHT;
        this.x = x;
        this.y = y;
    }

    protected Node move(int newX, int newY) {
        int oldX = x, oldY = y;
        x = newX;
        y = newY;
        return new Node(oldX, oldY);
    }

    public boolean checkPosition(int x, int y) {
        if (this.x == x && this.y == y) return true;
        else if (next != null) next.checkPosition(x, y);
        return false;
    }

    protected void paint(Graphics g) {
        g.setColor(Color.GREEN);
        g.fillRect(x * SIZE, y * SIZE, SIZE, SIZE);
    }

    @Override
    public String toString() {
        return String.format("%d, %d", x, y);
    }
}
