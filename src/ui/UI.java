package ui;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTextField;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;

import java.awt.Dimension;

import java.awt.Font;

import java.awt.event.*;

public class UI extends JFrame implements ActionListener{

    JButton button;
    JMenuBar menuBar;
    JMenu mainMenu, profileMenu, settingsMenu;
    ImageIcon menuIcon = new ImageIcon("img/menu-burger.png");
    ImageIcon profIcon = new ImageIcon("img/user.png");
    ImageIcon sIcon = new ImageIcon("img/settings.png");
    JTextField nameField;
    JTextField lastNameField;

    UI(){
        //MENUBAR
        menuBar = new JMenuBar();
        menuBar.setBackground(Color.GRAY);
        menuBar.setSize(500, 50);
        menuBar.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        

        //MENU
        mainMenu = new JMenu();
        mainMenu.setIcon(menuIcon);
        menuBar.add(mainMenu);

        profileMenu = new JMenu();
        profileMenu.setIcon(profIcon);
        menuBar.add(profileMenu);

        settingsMenu = new JMenu();
        settingsMenu.setIcon(sIcon);
        menuBar.add(settingsMenu);

        //TEXTFIELDS
        nameField = new JTextField("Name");
        nameField.setFont(new Font("Comic Sans", Font.PLAIN, 18));
        lastNameField = new JTextField("Last Name");
        lastNameField.setSize(new Dimension(100, 10));

        //BUTTON
        button = new JButton("Confirm");
        button.addActionListener(this);
        button.setPreferredSize(new Dimension(100, 50));
        button.setBackground(Color.DARK_GRAY);
        button.setBorder(BorderFactory.createEmptyBorder());

        //PANEL
        JPanel panel = new JPanel();
        panel.setBackground(Color.LIGHT_GRAY);
        panel.setLayout(new BorderLayout(0, 30));
        panel.add(nameField);
        panel.add(lastNameField);
        panel.add(button, BorderLayout.SOUTH);

        //cframe.add(menuBar);
        this.setJMenuBar(menuBar);
        
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if(e.getSource() == button){
            System.out.println(nameField.getText());
            System.out.println(button.getBorder());
        }
    }

}

