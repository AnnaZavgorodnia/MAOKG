import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.GeneralPath;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

@SuppressWarnings("serial")
public class Guitar extends JPanel implements ActionListener{

    private static int maxWidth;
    private static int maxHeight;

    Timer timer;

    private double scale = 1;
    private double delta = 0.01;

    public Guitar(){
        timer = new Timer(10, this);
        timer.start();
    }

    public void paint(Graphics g){
        super.paint(g);

        Graphics2D g2d = (Graphics2D) g;
        RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        rh.put(RenderingHints.KEY_RENDERING,
                RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setRenderingHints(rh);

        g2d.setBackground(new Color(255,215,0));
        g2d.clearRect(0, 0, maxWidth, maxHeight);

        double points1[][] = {{ 40, 30 }, { 220, 150 }, { 40, 270 }, { 90, 150 }};
        double points2[][] = {{ 420, 100 }, { 340, 150 }, { 420, 200 }, { 380, 150 }};
        double starPoints[][] = {
                { -100, -15 }, { -25, -25 }, { 0, -90 }, { 25, -25 },
                { 100, -15 }, { 50, 25 }, { 60, 100 }, { 0, 50 },
                { -60, 100 }, { -50, 25 }, { -100, -15 }
        };

        g2d.setColor(new Color(0,0,255));
        GeneralPath pol = drawForm(points1);
        g2d.fill(pol);
        pol = drawForm(points2);
        g2d.fill(pol);

        g2d.setColor(new Color(255,0,0));
        g2d.fillOval(100, 115, 72, 72);

        g2d.setColor(new Color(0,0,0));
        g2d.drawLine(125, 135, 370, 135);
        g2d.drawLine(125, 140, 370, 140);
        g2d.drawLine(125, 145, 370, 145);
        g2d.drawLine(125, 150, 370, 150);
        g2d.drawLine(125, 155, 370, 155);
        g2d.drawLine(125, 160, 370, 160);
        g2d.drawLine(125, 165, 370, 165);

        BasicStroke bs1 = new BasicStroke(16, BasicStroke.CAP_ROUND,
                BasicStroke.JOIN_ROUND);
        g2d.setStroke(bs1);
        g2d.setColor(new Color(237,102,99));
        g2d.drawRect( 180,280, 400, 250);


        g2d.translate(maxWidth/2 + 20, maxHeight/2 + 110);

        GeneralPath star = drawForm(starPoints);
        star.closePath();

        g2d.scale(scale, scale);

        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,
                (float)scale));

        GradientPaint gp = new GradientPaint(1, 25,
                new Color(236,160,182), 20, 4, new Color(173,98,170), true);
        g2d.setPaint(gp);

        g2d.fill(star);
    }

    public void actionPerformed(ActionEvent e) {
        if ( scale < 0.2 ) {
            delta = -delta;
        } else if (scale > 0.99) {
            delta = -delta;
        }

        scale += delta;

        repaint();
    }

    private GeneralPath drawForm(double[][] points){
        GeneralPath form = new GeneralPath();
        form.moveTo(points[0][0], points[0][1]);
        for (int k = 1; k < points.length; k++){
            form.lineTo(points[k][0], points[k][1]);
        }
        form.closePath();
        return form;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Hello java 2d");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 600);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.add(new Guitar());
        frame.setVisible(true);

        Dimension size = frame.getSize();

        Insets insets = frame.getInsets();
        maxWidth = size.width - insets.left - insets.right - 1;
        maxHeight = size.height - insets.top - insets.bottom - 1;
    }
}
