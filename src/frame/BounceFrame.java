package frame;

import ball.Ball;
import ball.ThreadsBalls;

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
                try {
                    startGame();
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
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

    private void startGame() throws InterruptedException {
        Ball ball = new Ball();
        sheet.add(ball);

        Runnable r = new ThreadsBalls(ball, sheet);
        Thread t = new Thread(r);
        t.start();
    }
}
