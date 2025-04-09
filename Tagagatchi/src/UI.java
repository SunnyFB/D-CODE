package Tagagatchi.src;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.GroupLayout.Alignment;

import java.awt.Dimension;
import java.awt.event.*;
import com.formdev.flatlaf.*;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class UI extends Game{
    JFrame frame;
    JProgressBar fullnessField;
    JProgressBar healthField;
    JProgressBar weightField;
    JProgressBar hygieneField;
    JProgressBar energyField;
    JProgressBar happinessField;
    JLabel blobImage;

    //variables to update Game
    public boolean feedFood = false;
    public boolean feedTreat = false;
    public boolean play = false, walk = false, doctor = false, trick = false, bath = false, nap = false, train = false, treat;
    public boolean save = false, paused = false;

    public String petType;

    public void openGameUI(Pet vPet){
        FlatLightLaf.setup();
        // Default Window Nonsense
        frame = new JFrame("Blobagatchi");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        petType = vPet.getPetType();

        //Make main panel
        JPanel panel = new JPanel(null);

        //BUTTONS

        JButton feedButton = new JButton("Feed Food"); //button to feed pet
        feedButton.setBounds(0,0,100,20);
        ActionListener feedButtonAL = new ActionListener() {
            public void actionPerformed(ActionEvent ae){
                if (!paused)
                    feedFood = true;
            }
        };
        feedButton.addActionListener(feedButtonAL);
        panel.add(feedButton);
        
        JButton treatButton = new JButton("Feed Treat"); //button to feed pet
        treatButton.setBounds(100,0,100,20);
        ActionListener treatButtonAL = new ActionListener() {
            public void actionPerformed(ActionEvent ae){
                if (!paused)
                    feedFood = true;
            }
        };
        treatButton.addActionListener(treatButtonAL);
        panel.add(treatButton);

        JButton saveButton = new JButton();
        saveButton.setBounds(280,200,20,20);

        //Set button image
        try {
            BufferedImage unscaled = ImageIO.read(this.getClass().getResource("sprites/icons/save.png"));
            Image img = unscaled.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
            ImageIcon icon = new ImageIcon(img);
            saveButton.setIcon(icon);
        } catch (IOException e) {
            e.printStackTrace();
        }
        ActionListener a2 = new ActionListener() {
            public void actionPerformed(ActionEvent ae){
                if (!paused)
                    save = true;
            }
        };
        saveButton.addActionListener(a2);
        panel.add(saveButton);

        JButton pauseButton = new JButton();
        pauseButton.setBounds(300,200,20,20);
        //Set button initially
        try{
            BufferedImage unscaled = ImageIO.read(this.getClass().getResource("sprites/icons/pause.png"));
            Image img = unscaled.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
            ImageIcon icon = new ImageIcon(img);
            pauseButton.setIcon(icon);
        }catch (IOException e){
            e.printStackTrace();
        }
        ActionListener pauseButtonAL = new ActionListener() {
            public void actionPerformed(ActionEvent ae){
                BufferedImage unscaled;
                Image img;
                ImageIcon icon;
                paused = !paused;
                    try {
                        if (paused)
                        {
                            unscaled = ImageIO.read(this.getClass().getResource("sprites/icons/start.png"));
                            img = unscaled.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
                            icon = new ImageIcon(img);
                        } else {
                            unscaled = ImageIO.read(this.getClass().getResource("sprites/icons/pause.png"));
                            img = unscaled.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
                            icon = new ImageIcon(img);
                        }
                        pauseButton.setIcon(icon);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
            }
        };
        pauseButton.addActionListener(pauseButtonAL);
        panel.add(pauseButton);

        JButton doctorButton = new JButton("Take to Doctor");
        ActionListener doctorButtonAL = new ActionListener(){
            public void actionPerformed(ActionEvent ae) {
                if (!paused)
                    doctor = true;
            }
        };
        doctorButton.addActionListener(doctorButtonAL);

        JButton trainButton = new JButton("Teach a Trick");
        ActionListener trainButtonAL = new ActionListener(){
            public void actionPerformed(ActionEvent ae) {
                if (!paused)
                    train = true;
            }
        };
        trainButton.addActionListener(trainButtonAL);

        JButton bathButton = new JButton("Bath Time");
        ActionListener bathButtonAL = new ActionListener(){
            public void actionPerformed(ActionEvent ae) {
                if (!paused)
                    train = true;
            }
        };
        bathButton.addActionListener(bathButtonAL);

        JButton napButton = new JButton("Nap Time");
        ActionListener napButtonAL = new ActionListener(){
            public void actionPerformed(ActionEvent ae) {
                if (!paused)
                    train = true;
            }
        };
        napButton.addActionListener(napButtonAL);



        JButton walkButton = new JButton("Walk");
        ActionListener walkButtonAL = new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                if (!paused)
                    walk = true;
            }
        };
        walkButton.addActionListener(walkButtonAL);

        //BLOB IMAGE
        try{
            BufferedImage blobImageFile;
            if (vPet.isDead()){
                blobImageFile = ImageIO.read(this.getClass().getResource("sprites/dead.png"));
            }else{
                blobImageFile = ImageIO.read(this.getClass().getResource("sprites/" + vPet.getPetType() + "/happy.png"));
            }
            
            Image big = blobImageFile.getSubimage(33, 15, 35, 35);
            big = big.getScaledInstance(200, 200, Image.SCALE_DEFAULT);
            blobImage = new JLabel(new ImageIcon(big));
        }catch (IOException e){
            e.printStackTrace();
        }
        blobImage.setBounds(200,0,200,200);
        frame.add(blobImage);






        //Bars to show things
        JTextArea healthText = new JTextArea("Health");
        healthText.setBounds(0,160,200,20);
        healthText.setEditable(false);
        healthField = new JProgressBar(0, 100);
        healthField.setValue((int) (vPet.getHealth() * 10));
        healthField.setBounds(0,180,200,20);
        frame.add(healthText);
        frame.add(healthField);

        JTextArea fullnessText = new JTextArea("Fullness");
        fullnessText.setBounds(400,40,200,20);
        fullnessText.setEditable(false);
        fullnessField = new JProgressBar(0, 100);
        fullnessField.setValue((int) (vPet.getFullness() * 10));
        fullnessField.setBounds(400,60,200,20);
        frame.add(fullnessText);
        frame.add(fullnessField);

        JTextArea energyText = new JTextArea("Energy");
        energyText.setBounds(400,80,200,20);
        energyText.setEditable(false);
        energyField = new JProgressBar(0, 100);
        energyField.setValue((int) (vPet.getEnergy() * 10));
        energyField.setBounds(400,100,200,20);
        frame.add(energyText);
        frame.add(energyField);

        JTextArea happinessText = new JTextArea("Happiness");
        happinessText.setBounds(400,120,200,20);
        happinessText.setEditable(false);
        happinessField = new JProgressBar(0, 100);
        happinessField.setValue((int) (vPet.getHappiness() * 10));
        happinessField.setBounds(400,140,200,20);
        frame.add(happinessText);
        frame.add(happinessField);

        JTextArea hygieneText = new JTextArea("Hygiene");
        hygieneText.setBounds(400,160,200,20);
        hygieneText.setEditable(false);
        hygieneField = new JProgressBar(0, 100);
        hygieneField.setValue((int) (vPet.getHygiene() * 10));
        hygieneField.setBounds(400,180,200,20);
        frame.add(hygieneText);
        frame.add(hygieneField);

        JTextArea weightText = new JTextArea("Weight");
        weightText.setBounds(0, 120, 200, 20);
        weightText.setEditable(false);
        weightField = new JProgressBar(0, 100);
        weightField.setValue((int) (vPet.getWeight() * 10));
        weightField.setBounds(0, 140, 200, 20);
        frame.add(weightText);
        frame.add(weightField);





        panel.add(walkButton);
        panel.add(doctorButton);
        panel.add(trainButton);
        panel.add(bathButton);
        panel.add(napButton);

        //pet attributes
        panel.add(fullnessField);
        panel.add(healthField);
        panel.add(weightField);
        panel.add(hygieneField);
        panel.add(energyField);
        panel.add(happinessField);

        //save and pause button
        
        panel.setPreferredSize(new Dimension(600,220));
        frame.add(panel);
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);
    }

    public void openStartUI()
    {
        FlatLightLaf.setup();
        frame = new JFrame("Blobagatchi");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel startPanel = new JPanel(null);
        startPanel.setPreferredSize(new Dimension(600,200));

        JLabel welcomeMessage = new JLabel("Welcome to Blobagatchi! Choose your new pet below!");
        welcomeMessage.setBounds(0, 100, 600, 20);
        welcomeMessage.setHorizontalAlignment(SwingConstants.CENTER);
        startPanel.add(welcomeMessage);

        JButton blob = new JButton("Blob");
        ActionListener blobAL = new ActionListener() {
            public void actionPerformed(ActionEvent ae)
            {
                petType = "blob";
            }
        };
        blob.addActionListener(blobAL);
        blob.setBounds(100, 120, 100, 20);
        startPanel.add(blob);

        JButton alien = new JButton("Alien");
        ActionListener alienAL = new ActionListener() {
            public void actionPerformed(ActionEvent ae)
            {
                petType = "alien";
            }
        };
        alien.addActionListener(alienAL);
        alien.setBounds(200, 120, 100, 20);
        startPanel.add(alien);

        JButton cat = new JButton("Cat");
        ActionListener catAL = new ActionListener() {
            public void actionPerformed(ActionEvent ae)
            {
                petType = "cat";
            }
        };
        cat.addActionListener(catAL);
        cat.setBounds(300, 120, 100, 20);
        startPanel.add(cat);

        JButton dog = new JButton("Dog");
        ActionListener dogAL = new ActionListener() {
            public void actionPerformed(ActionEvent ae)
            {
                petType = "dog";
            }
        };
        dog.addActionListener(dogAL);
        dog.setBounds(400, 120, 100, 20);
        startPanel.add(dog);

        //Blobagatchi logo
        //BLOB IMAGE
        try{
            BufferedImage blobImageFile;
            blobImageFile = ImageIO.read(this.getClass().getResource("sprites/title.png"));
            Image big = blobImageFile.getSubimage(00,100,20,10);
            big = big.getScaledInstance(200, 100, Image.SCALE_DEFAULT);
            blobImage = new JLabel(new ImageIcon(big));
        }catch (IOException e){
            e.printStackTrace();
        }
        blobImage.setBounds(200,0,200,100);
        startPanel.add(blobImage);
       
       
        // while(petType.equals(" ")); TODO

        frame.add(startPanel);
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);
    }

    public void update(Pet vPet){
        //Update the UI
        fullnessField.setValue((int) (vPet.getFullness()*10));
        healthField.setValue((int) (vPet.getHealth() * 10));
        weightField.setValue((int) (vPet.getWeight() * 10));
        happinessField.setValue((int) (vPet.getHappiness() * 10));
        hygieneField.setValue((int) (vPet.getHygiene() * 10));
        energyField.setValue((int) (vPet.getEnergy() * 10 ));
         if (vPet.isDead()){
            try{
                Image blobImageFile = ImageIO.read(this.getClass().getResource("sprites/dead.png"));
                blobImageFile = blobImageFile.getScaledInstance(200, 200, Image.SCALE_DEFAULT);
                blobImage.setIcon(new ImageIcon(blobImageFile));
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }

    public String getPetType()
    {
        return petType;
    }
}