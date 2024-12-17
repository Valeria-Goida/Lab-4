import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Ellipse2D;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame fr=new JFrame("Приближающийся и удаляющийся шар");
        fr.setPreferredSize( new Dimension(500,500));
        final JPanel pan= new JPanel();
        fr.add(pan);
        fr.setVisible(true);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.pack();
        Timer tm = new Timer(50, new ActionListener() {
            int radius = 50;
            int centerX = 250;
            int centerY = 250;
            boolean expanding = true;

            @Override
            public void actionPerformed(ActionEvent arg0) {
                Graphics2D gr = (Graphics2D) pan.getRootPane().getGraphics();
                pan.update(gr);

                if (expanding) {
                    radius++;
                    if (radius >= 100) {
                        expanding = false;
                    }
                } else {
                    radius--;
                    if (radius <= 20) {
                        expanding = true;
                    }
                }

                gr.translate(centerX, centerY);
                gr.draw(new Ellipse2D.Double(-radius, -radius, 2 * radius, 2 * radius));
            }
        });
        tm.start();
    }
}