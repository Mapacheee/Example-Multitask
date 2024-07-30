package ball;

import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class Ball {

    private double x = 0, y = 0, dx = 1, dy = 1;
    private final static byte TAMX = 15, TAMY = 15;

    public void moveBall(Rectangle2D limits) {
        x += dx;
        y += dy;

        if (x < limits.getMinX()) {
            x = limits.getMinX();
            dx = -dx;
        }

        if (x + TAMX >= limits.getMaxX()) {
            x = limits.getMaxX() - TAMX;
            dx = -dx;
        }

        if (y < limits.getMinY()) {
            y = limits.getMinY();
            dy = -dy;
        }

        if (y + TAMY >= limits.getMaxY()) {
            y = limits.getMaxY() - TAMY;
            dy = -dy;
        }

    }

    public Ellipse2D getShape() {

        return new Ellipse2D.Double(x, y, TAMX, TAMY);

    }
}
