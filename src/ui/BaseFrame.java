package ui;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;

public class BaseFrame extends JFrame implements ActionListener{

    int xSize, ySize;
    Color bgColor = new Color(0xf8f1eb);
    Color textColor = new Color(0x6d6875);
    Color paneColor = new Color(0xb5838d);
    Color detaiColor = new Color(0xffb4a2);
    Container contentPane;

    Font customFont, paragFont;

    BaseFrame(){
        xSize = 1920/2;
        ySize = 1080/2;
        contentPane = this.getContentPane();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(xSize, ySize);
        this.setTitle("FitBuddy");
        this.setLayout(new BorderLayout());
        contentPane.setBackground(bgColor);
        this.setResizable(false);
        //this.pack();

        this.centerWindow(this);

        try {
            // Load the custom font from a .ttf file
            File fontFile = new File("Maharlika-Regular.ttf");
            customFont = Font.createFont(Font.TRUETYPE_FONT, fontFile);
            File fontFile2 = new File("Montserrat-Light.ttf");
            paragFont = Font.createFont(Font.TRUETYPE_FONT, fontFile2);

            // Register the font with the graphics environment
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(customFont);
            ge.registerFont(paragFont);
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

    }

    private void centerWindow(Window window) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screenSize.width - window.getWidth()) / 2;
        int y = (screenSize.height - window.getHeight()) / 2;
        window.setLocation(x, y);
    }
}


