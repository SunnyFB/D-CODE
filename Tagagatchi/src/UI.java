package Tagagatchi.src;
import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.*;
import com.formdev.flatlaf.*;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class UI extends Game{
    JFrame frame;
    JTextField fullnessField;
    JTextField healthField;
    JTextField weightField;
    JTextField hygieneField;
    JTextField energyField;
    JTextField happinessField;
    JProgressBar fullnessBar;
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
        frame = new JFrame("Tamagotchi Test");
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
                blobImageFile = ImageIO.read(this.getClass().getResource("sprites/" + petType + "/happy.png"));
            }
            
            Image big = blobImageFile.getSubimage(33, 15, 35, 35);
            big = big.getScaledInstance(200, 200, Image.SCALE_DEFAULT);
            blobImage = new JLabel(new ImageIcon(big));
        }catch (IOException e){
            e.printStackTrace();
        }
        blobImage.setBounds(200,0,200,200);
        frame.add(blobImage);






        //Fullness
        fullnessField = new JTextField("Fullness: " + vPet.getFullness());
        fullnessField.setEditable(false);
        fullnessBar = new JProgressBar(0, 100);
        fullnessBar.setValue((int) (vPet.getFullness() * 10));

        healthField = new JTextField("Health: " + vPet.getFullness());
        healthField.setEditable(false);

        weightField = new JTextField("Health: " + vPet.getFullness());
        weightField.setEditable(false);

        hygieneField = new JTextField("Hygiene: " + vPet.getHygiene());
        hygieneField.setEditable(false);

        energyField = new JTextField("Energy: " + vPet.getEnergy());
        energyField.setEditable(false);

        happinessField = new JTextField("Happiness: " + vPet.getHappiness());
        happinessField.setEditable(false);




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


        panel.add(fullnessBar);
        
        panel.setPreferredSize(new Dimension(600,220));
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }

    public void update(Pet vPet){
        //Update the UI
        fullnessField.setText("Fullness: " + vPet.getFullness());
        healthField.setText("Health: " + vPet.getHealth());
        weightField.setText("Weight: " + vPet.getWeight());
        happinessField.setText("Happiness: " + vPet.getHappiness());
        hygieneField.setText("Hygiene: " + vPet.getHygiene());
        energyField.setText("Energy: " + vPet.getEnergy());
        fullnessBar.setValue((int) (vPet.getFullness() * 10));
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