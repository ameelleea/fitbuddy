package ui;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.RoundRectangle2D;
import java.awt.FontMetrics;
import javax.swing.JTextField;

public class RoundedTextfield extends JTextField {
    private static final int ARC_WIDTH = 10; // Adjust the arc width to control the roundness of the corners
    private static final int ARC_HEIGHT = 10; // Adjust the arc height to control the roundness of the corners

    public RoundedTextfield() {
        this.setBorder(new RoundedBorder(10, new Color(0xffb4a2)));
        setOpaque(false); // Make the text field transparent
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();

        // Draw the rounded rectangle as the background
        g2d.setColor(getBackground());
        g2d.fill(new RoundRectangle2D.Double(0, 0, getWidth() - 1, getHeight() - 1, ARC_WIDTH, ARC_HEIGHT));

        g2d.setColor(getForeground());
        g2d.setFont(getFont());
        FontMetrics metrics = g2d.getFontMetrics();
        //int x = (getWidth() - metrics.stringWidth(getText())) / 2;
        int y = ((getHeight() - metrics.getHeight()) / 2) + metrics.getAscent();
        g2d.drawString(getText(), 3, y);

        g2d.dispose();
    }
}
