package ball;

import java.awt.*;

public class ThreadsBalls implements Runnable {

    private Ball ball;
    private Component component;

    public ThreadsBalls(Ball ball, Component component) {
        this.ball = ball;
        this.component = component;
    }

    public void run() {
        for (int i = 0; i < 3000; i++) {
            ball.moveBall(component.getBounds());
            component.paint(component.getGraphics());

            try {
                Thread.sleep(8);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
