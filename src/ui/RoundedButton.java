package ui;
import javax.swing.*;
import java.awt.*;
import java.awt.FontMetrics;
import java.awt.geom.RoundRectangle2D;

class RoundedButton extends JButton {
    private static final int ARC_WIDTH = 20; // Adjust the arc width to control the roundness of the button corners
    private static final int ARC_HEIGHT = 20; // Adjust the arc height to control the roundness of the button corners

    public RoundedButton(String text) {
        super(text);
        setContentAreaFilled(false); // Make the button transparent
        setFocusPainted(false); // Remove the focus border
        this.setBorderPainted(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();

        // Draw the rounded rectangle as the background
        g2d.setColor(getBackground());
        g2d.fill(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), ARC_WIDTH, ARC_HEIGHT));

        // Draw the button text
        g2d.setColor(getForeground());
        g2d.setFont(getFont());
        FontMetrics metrics = g2d.getFontMetrics();
        int x = (getWidth() - metrics.stringWidth(getText())) / 2;
        int y = ((getHeight() - metrics.getHeight()) / 2) + metrics.getAscent();
        g2d.drawString(getText(), x, y);

        g2d.dispose();
    }
}
