package com.lipian.snake.body;

import com.lipian.snake.direction.Direction;
import com.lipian.snake.screen.Frame;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;

@Getter
public class Snake {
    @Setter
    private Direction direction;
    private final Node head;
    private Node tail;

    public Snake(Node head) {
        direction = Direction.RIGHT;
        this.head = head;
        tail = head;
        for (int i = 0; i < 4; i++)
            addNode(new Node(tail.getX() - 1, tail.getY()));
    }

    public void addNode(Node node) {
        tail.setNext(node);
        tail = tail.getNext();
    }

    public Node move() {
        Node newNode = head.move(head.getX() + direction.getX(),
                head.getY() + direction.getY());
        Node current = head.getNext();
        while (current != null) {
            newNode = current.move(newNode.getX(), newNode.getY());
            current = current.getNext();
        }
        return newNode;
    }

    public boolean checkPosition(int x, int y) {
        return head.checkPosition(x, y);
    }

    public boolean isCollision() {
        Node current = head.getNext();
        boolean taken = false;
        while (current != null) {
            taken = current.checkPosition(head.getX(), head.getY());
            if (taken) break;
            current = current.getNext();
        }
        return taken || isOutOfBounds();
    }

    private boolean isOutOfBounds() {
        System.out.println(head.getX());
        return head.getX() < 0 || head.getX() >= Frame.WIDTH / Node.SIZE
                || head.getY() < 0 || head.getY() >= Frame.HEIGHT / Node.SIZE;
    }

    public void paint(Graphics g) {
        Node current = head;
        while (current != null) {
            current.paint(g);
            current = current.getNext();
        }
    }
}
