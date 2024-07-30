package frame;

import ball.Ball;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class SheetBall extends JPanel {

    private ArrayList<Ball> balls = new ArrayList<Ball>();

    public void add(Ball b) {
        balls.add(b);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        for (Ball b: balls) {
            g2d.fill(b.getShape());
        }
    }
}
