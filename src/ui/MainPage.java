package ui;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainPage extends BaseFrame {

    JLabel title;
    JPanel header;
    
    public MainPage(){

        //TITOLO PAGINA
        title = new JLabel();
        title.setText("FitBuddy");
        title.setFont(this.customFont.deriveFont(Font.PLAIN, 30));
        title.setForeground(this.paneColor);
        title.setBounds(0, 0, xSize, 40);

        //INTESTAZIONE
        header = new JPanel();
        header.setPreferredSize(new Dimension(xSize, 30));
        header.setBackground(this.bgColor);
        header.setLayout(null);
        header.add(title);

        this.contentPane.add(header, BorderLayout.NORTH);

        this.setVisible(false);
    }
}
