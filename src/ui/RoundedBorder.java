package ui;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.RoundRectangle2D;

import javax.swing.border.AbstractBorder;

public class RoundedBorder extends AbstractBorder {
    private int arcWidth;
    private int arcHeight;
    private Color borderColor;

    public RoundedBorder(int arcWidth, Color borderColor) {
        this.arcWidth = arcWidth;
        this.arcHeight = arcWidth; // Use the same value for height to make a circular arc
        this.borderColor = borderColor;
    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        Graphics2D g2d = (Graphics2D) g.create();

        g2d.setColor(borderColor);
        g2d.setStroke(new BasicStroke(3));
        // Draw a rounded rectangle border
        g2d.draw(new RoundRectangle2D.Double(x, y, width - 1, height - 1, arcWidth, arcHeight));

        g2d.dispose();
    }
}
