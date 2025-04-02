package Tagagatchi.src;
import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.event.*;
import com.formdev.flatlaf.*;
import java.awt.Image;
import java.awt.image.BufferedImage;
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
        frame.setSize(600, 220);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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
        
        JButton treatButton = new JButton("Feed Treat"); //button to feed pet
        treatButton.setBounds(100,0,100,20);
        ActionListener treatButtonAL = new ActionListener() {
            public void actionPerformed(ActionEvent ae){
                if (!paused)
                    feedFood = true;
            }
        };
        treatButton.addActionListener(treatButtonAL);

        JButton saveButton = new JButton("Save");
        saveButton.setBounds(200,200,180,20);
        ActionListener a2 = new ActionListener() {
            public void actionPerformed(ActionEvent ae){
                if (!paused)
                    save = true;
            }
        };
        saveButton.addActionListener(a2);

        JButton pauseButton = new JButton();
        pauseButton.setBounds(180,0,20,20);
        ActionListener pauseButtonAL = new ActionListener() {
            public void actionPerformed(ActionEvent ae){
                BufferedImage unscaled;
                Image img;
                ImageIcon icon = new ImageIcon(this.getClass().getResource("pause.png"));
                paused = !paused;
                    try {
                        if (paused)
                        {
                            unscaled = ImageIO.read(this.getClass().getResource("start.png"));
                            img = unscaled.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
                            icon = new ImageIcon(img);
                        } else {
                            unscaled = ImageIO.read(this.getClass().getResource("pause.png"));
                            img = unscaled.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
                            icon = new ImageIcon(img);
                        }
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                pauseButton.setIcon(icon);
            }
        };
        pauseButton.addActionListener(pauseButtonAL);

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




        //activity buttons
        panel.add(feedButton);
        panel.add(treatButton);
        panel.add(walkButton);

        //pet attributes
        panel.add(fullnessField);
        panel.add(healthField);
        panel.add(weightField);
        panel.add(hygieneField);
        panel.add(energyField);
        panel.add(happinessField);

        //save and pause button
        panel.add(saveButton);
        panel.add(pauseButton);
        panel.add(fullnessBar);
        
        frame.add(panel);
        frame.setVisible(true);
    }

    public void update(Pet vPet){
        //Update the UI
        fullnessField.setText("Fullness: " + vPet.getFullness());
        healthField.setText("Health: " + vPet.getHealth());
        weightField.setText("Weight: " + vPet.getWeight());
    }

    public String getPetType()
    {
        return petType;
    }
}