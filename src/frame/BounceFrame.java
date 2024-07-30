package frame;

import ball.Ball;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BounceFrame extends JFrame {

    private SheetBall sheet;

    public BounceFrame() {
        setTitle("¡Rebotes!");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(600,300,400,350);

        sheet = new SheetBall();
        add(sheet, BorderLayout.CENTER);

        JPanel buttonsSheet = new JPanel();

        setButton(buttonsSheet, "¡Añadir pelota!", new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                startGame();
            }
        });

        setButton(buttonsSheet, "Salir", new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        add(buttonsSheet, BorderLayout.SOUTH);
    }

    private void setButton(Container c, String title, ActionListener listener) {
        JButton button = new JButton(title);
        c.add(button);
        button.addActionListener(listener);
    }

    private void startGame() {
        Ball ball = new Ball();
        sheet.add(ball);

        for (int i = 0; i < 30000; i++) {
            ball.moveBall(sheet.getBounds());
            sheet.paint(sheet.getGraphics());
        }
    }
}
