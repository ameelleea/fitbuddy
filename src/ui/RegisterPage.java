package ui;
import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class RegisterPage extends BaseFrame{
    RoundedPanel panel;
    JPanel header;
    JPanel form;
    JLabel title;
    RoundedButton confirm;
    int formLabelsX;
    int textfieldX;
    int formElW, formElH;
    
    RoundedTextfield name;
    RoundedTextfield surname;
    RoundedTextfield email;
    RoundedTextfield userH;
    RoundedTextfield userW;
    JLabel namLabel;    
    JLabel surnameLabel;
    JLabel emailLabel;     
    JLabel gender;     
    JLabel userHLabel;
    JLabel userWLabel;    
    JRadioButton female;
    JRadioButton male;
    ButtonGroup genderButtons = new ButtonGroup();

    boolean regCompleted = false;

    String nome = "Regpage";

    MainPage listener;

    private static final String PROPERTIES_FILE = "app.properties";

    public RegisterPage(){
        int gap = 20;
        int horGap = 50;
        formElW = 200;
        formElH = 25;
        formLabelsX = horGap;
        textfieldX = formElW + horGap;

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

        //FORM
        name = new RoundedTextfield();
        surname = new RoundedTextfield();
        email = new RoundedTextfield();
        userH = new RoundedTextfield();
        userW = new RoundedTextfield();

        namLabel = new JLabel("Nome");
        surnameLabel = new JLabel("Cognome");
        emailLabel = new JLabel("Email");
        gender = new JLabel("Sesso");
        userHLabel = new JLabel("Altezza");
        userWLabel = new JLabel("Peso");

        female = new JRadioButton("F");
        male = new JRadioButton("M");
        genderButtons = new ButtonGroup();
        
        //IMPOSTAZIONE COLORE E FONT ETICHETTE
        namLabel.setFont(paragFont.deriveFont(Font.PLAIN, 25));
        namLabel.setForeground(this.bgColor);
        surnameLabel.setFont(paragFont.deriveFont(Font.PLAIN, 25));
        surnameLabel.setForeground(this.bgColor);
        emailLabel.setFont(paragFont.deriveFont(Font.PLAIN, 25));
        emailLabel.setForeground(this.bgColor);
        gender.setFont(paragFont.deriveFont(Font.PLAIN, 25));
        gender.setForeground(this.bgColor);
        userHLabel.setFont(paragFont.deriveFont(Font.PLAIN, 25));
        userHLabel.setForeground(this.bgColor);
        userWLabel.setFont(paragFont.deriveFont(Font.PLAIN, 25));
        userWLabel.setForeground(this.bgColor);

        //IMPOSTAZIONE FONT TEXTFIELDS
        //name.setFont(paragFont.deriveFont(Font.PLAIN, 20));
        //surname.setFont(paragFont.deriveFont(Font.PLAIN, 20));
        //email.setFont(paragFont.deriveFont(Font.PLAIN, 20));
        //userH.setFont(paragFont.deriveFont(Font.PLAIN, 20));
        //userW.setFont(paragFont.deriveFont(Font.PLAIN, 20));
        name.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        surname.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        email.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        userH.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        userW.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);

        //IMPOSTAZIONE POSIZIONI ELEMENTI
        namLabel.setBounds(formLabelsX, gap, formElW, formElH);
        name.setBounds(textfieldX, gap, formElW, formElH); 
        surnameLabel.setBounds(formLabelsX, formElH+(2*gap), formElW, formElH);
        surname.setBounds(textfieldX, formElH+(2*gap), formElW, formElH);
        emailLabel.setBounds(formLabelsX, (2*formElH)+(3*gap), formElW, formElH);
        email.setBounds(textfieldX, (2*formElH)+(3*gap), formElW, formElH);
        gender.setBounds(formLabelsX, (3*formElH)+(4*gap), formElW, formElH);
        female.setBounds(textfieldX, (3*formElH)+(4*gap), 50, formElH);
        male.setBounds(textfieldX+50, (3*formElH)+(4*gap), 50, formElH);
        userHLabel.setBounds(formLabelsX, (4*formElH)+(5*gap), formElW, formElH);
        userH.setBounds(textfieldX, (4*formElH)+(5*gap), formElW/2, formElH);
        userWLabel.setBounds(formLabelsX, (5*formElH)+(6*gap), formElW, formElH);
        userW.setBounds(textfieldX, (5*formElH)+(6*gap), formElW/2, formElH);
        
        //COLORE GRUPPO DI RADIOBUTTONS
        female.setBackground(this.paneColor);
        male.setBackground(this.paneColor);
        female.setForeground(this.textColor);
        male.setForeground(this.textColor);
        female.setFont(paragFont.deriveFont(Font.PLAIN, 25));
        male.setFont(paragFont.deriveFont(Font.PLAIN, 25));
        
        //AGGIUNTA RADIOBUTTONS AL GRUPPO
        genderButtons.add(female);
        genderButtons.add(male);       

        //CREAZIONE SUBPANEL E AGGIUNTA ELEMENTI
        JPanel somePanel = new JPanel();
        somePanel.setBackground(this.paneColor);
        somePanel.setLayout(null);
        somePanel.setPreferredSize(new Dimension(500, 400));
        somePanel.add(namLabel);
        somePanel.add(name); 
        somePanel.add(surnameLabel);
        somePanel.add(surname);
        somePanel.add(emailLabel);
        somePanel.add(email);
        somePanel.add(userHLabel);
        somePanel.add(userH);
        somePanel.add(userWLabel);
        somePanel.add(userW);
        somePanel.add(female);
        somePanel.add(male);
        somePanel.add(gender);

        //TITOLO FORM
        JLabel register = new JLabel();
        register.setText("Registrati");
        register.setForeground(this.detaiColor);
        register.setFont(customFont.deriveFont(Font.PLAIN, 35));
        register.setPreferredSize(new Dimension(500, 50));
        register.setHorizontalAlignment(JLabel.CENTER);

        //BOTTONE CONFERMA
        confirm = new RoundedButton("Invia");
        confirm.setFont(customFont.deriveFont(Font.PLAIN, 20));
        confirm.setForeground(this.textColor);
        confirm.setBackground(this.detaiColor);
        confirm.addActionListener(this);

        RoundedPanel buttonPanel = new RoundedPanel(50, 50);
        buttonPanel.setBackground(this.paneColor);
        buttonPanel.setPreferredSize(new Dimension(500, 45));
        buttonPanel.add(confirm);

        //SFONDO FORM
        panel = new RoundedPanel(50, 50);
        panel.setBackground(this.paneColor);
        panel.setLayout(new BorderLayout());
        panel.setBounds(xSize/2-250, (ySize-30)/2-225, 500, 400);
        panel.add(register, BorderLayout.NORTH);
        panel.add(buttonPanel, BorderLayout.SOUTH);
        panel.add(somePanel, BorderLayout.WEST);
        
        //CONTENITORE FORM
        form = new JPanel();
        form.setBackground(this.bgColor);
        form.setLayout(null);
        form.add(panel);

        this.contentPane.add(form, BorderLayout.CENTER);
        this.contentPane.add(header, BorderLayout.NORTH);

        this.setVisible(false);
    }

    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if(e.getSource() == confirm){

            if(checkFormFillout()){
                saveState();
                this.setVisible(false);
                this.listener.setVisible(true);
            }
            else{
                System.out.println("Form non riempito");
            } 
        }
        if(e.getActionCommand() == "Register"){
            this.setVisible(true);
            System.out.println(e.getActionCommand());
        }
    }

    private void saveState() {
        try (OutputStream output = new FileOutputStream(PROPERTIES_FILE)) {
            Properties properties = new Properties();
            properties.setProperty("nome", name.getText());
            properties.setProperty("cognome", surname.getText());
            properties.setProperty("email", email.getText());
            properties.setProperty("sesso", String.valueOf(female.isSelected()));
            properties.setProperty("altezza", userH.getText());
            properties.setProperty("peso", userW.getText());
            properties.store(output, "Application State");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean checkFormFillout(){
        boolean isFilled = false;

        boolean hasname = (name.getText() != null);
        boolean hassurname = (surname.getText() != null);
        boolean hasemail = (email.getText() != null);
        boolean hasuserH = (userH.getText() != null);
        boolean hasuserW = (userW.getText() != null);
        boolean hasgender = (female.isSelected() == true || male.isSelected() == true);

        isFilled = hasname && hassurname && hasemail && hasuserH && hasuserW && hasgender;
         
        return isFilled;
    }
}
