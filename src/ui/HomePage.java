package ui;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;

import java.awt.Image;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class HomePage extends BaseFrame{

    JLabel title;
    JPanel titlePane;
    JPanel buttonPane;
    RoundedButton loginButton, registerButton;
    ImageIcon logo;
    boolean hasClickedLogin = false;
    boolean hasClickedRegister = false;
    RegisterPage logListener, regListener;

    public HomePage(){ 
    
        Image image = new ImageIcon("img/logo.png").getImage();  
        Image newimg = image.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        logo = new ImageIcon(newimg);

        title = new JLabel();
        title.setIcon(logo);
        title.setText("FitBuddy");
        title.setFont(this.customFont.deriveFont(Font.PLAIN, 75));
        title.setForeground(this.paneColor);
        title.setHorizontalTextPosition((JLabel.RIGHT));
        title.setIconTextGap(-100);
        title.setPreferredSize(new Dimension(xSize, (ySize/2)));
        title.setVerticalAlignment(JLabel.CENTER);
        title.setHorizontalAlignment(JLabel.CENTER);

        //BUTTONS
        loginButton = new RoundedButton("Login");
        loginButton.setBounds((xSize/2)-50, 30, 100, 50);
        registerButton = new RoundedButton("Register");
        registerButton.setBounds((xSize/2)-50, 100, 100, 50);
        loginButton.setFocusable(false);
        registerButton.setFocusable(false);
        loginButton.setBackground(this.paneColor);
        registerButton.setBackground(this.paneColor);
        loginButton.setForeground(this.bgColor);
        registerButton.setForeground(this.bgColor);
        loginButton.addActionListener(this);
        registerButton.addActionListener(this);
        loginButton.setFont(this.customFont.deriveFont(Font.PLAIN, 20));
        registerButton.setFont(this.customFont.deriveFont(Font.PLAIN, 20));

        //TITLE PANEL
        titlePane = new JPanel();
        titlePane.setLayout(new BorderLayout());
        titlePane.setBackground(this.bgColor);
        titlePane.setPreferredSize(new Dimension(xSize, (ySize/2)+50));
        titlePane.add(title, BorderLayout.SOUTH);

        //BUTTONS PANEL
        buttonPane = new JPanel();
        buttonPane.setBackground(this.bgColor);
        buttonPane.setLayout(null);
        buttonPane.setPreferredSize(new Dimension(xSize, (ySize/2)-50));
        buttonPane.add(loginButton);
        buttonPane.add(registerButton);

        this.add(titlePane, BorderLayout.CENTER);
        this.add(buttonPane, BorderLayout.SOUTH);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if(e.getSource() == loginButton || e.getSource() == registerButton){
            this.setVisible(false);
            System.out.println(e.getActionCommand());
            regListener.setVisible(true);
        }
    }
}
