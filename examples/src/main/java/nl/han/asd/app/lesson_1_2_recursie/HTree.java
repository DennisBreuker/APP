package nl.han.asd.app.lesson_1_2_recursie;

import java.awt.Graphics;
import javax.swing.JFrame;

public class HTree extends JFrame {
    public final static int WIDTH = 500;
    public final static int HEIGHT = 500;
    public final static double FACTOR = 1.0/Math.sqrt(2);


    public HTree() {
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void drawRecursive(Graphics g, int x, int y, int len, boolean hor, int depth) {
        int x1, y1, x2, y2;

        if (hor) {
            x1 = x - len;
            x2 = x + len;
            y1 = y;
            y2 = y;
        } else {
            y1 = y - len;
            y2 = y + len;
            x1 = x;
            x2 = x;
        }
        g.drawLine(x1 + WIDTH / 2, HEIGHT / 2 - y1, x2 + WIDTH / 2, HEIGHT / 2 - y2);
        if (depth > 0) {
            int newLen = (int) (len * FACTOR);
            drawRecursive(g, x1, y1, newLen, !hor, depth - 1);
            drawRecursive(g, x2, y2, newLen, !hor, depth - 1);
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        drawRecursive(g, 0, 0, Math.min(WIDTH, HEIGHT)/4, true, 10);

    }


    public static void main(String[] args) {
        new HTree().setVisible(true);
    }
}