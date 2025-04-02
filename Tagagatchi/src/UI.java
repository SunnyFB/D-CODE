package Tagagatchi.src;
import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.event.*;
import com.formdev.flatlaf.*;

public class UI extends Game{
    JFrame frame;
    JTextArea fullnessField;
    JTextArea healthField;
    JTextArea weightField;

    //variables to update Game
    public boolean feedFood = false;
    public boolean feedTreat = false;
    public boolean save = false, paused = false;

    public void openGameUI(Pet vPet){
        FlatLightLaf.setup();
        // Default Window Nonsense
        frame = new JFrame("Tamagotchi Test");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel buttonPanel = new JPanel();
        JPanel statPanel = new JPanel();
        JPanel messagePanel = new JPanel();
        JPanel imagePanel = new JPanel();


        //button panel
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.PAGE_AXIS));

        JButton feedButton = new JButton("Feed");
        ActionListener a1 = new ActionListener() {
            public void actionPerformed(ActionEvent ae){
                if (!paused)
                    feedFood = true;
            }
        };
        feedButton.addActionListener(a1);

        JButton saveButton = new JButton("Save");
        ActionListener a2 = new ActionListener() {
            public void actionPerformed(ActionEvent ae){
                if (!paused)
                    save = true;
            }
        };
        saveButton.addActionListener(a2);

        JButton pauseButton = new JButton("Pause");
        ActionListener a3 = new ActionListener() {
            public void actionPerformed(ActionEvent ae){
                paused = !paused;
            }
        };
        pauseButton.addActionListener(a3);

        buttonPanel.add(feedButton);
        buttonPanel.add(saveButton);
        buttonPanel.add(pauseButton);

        // Stats/field panel
        statPanel.setLayout(new BoxLayout(statPanel, BoxLayout.PAGE_AXIS));

        fullnessField = new JTextArea("Fullness: " + vPet.getFullness());
        fullnessField.setEditable(false);

        healthField = new JTextArea("Health: " + vPet.getFullness());
        healthField.setEditable(false);

        weightField = new JTextArea("Weight: " + vPet.getFullness());
        weightField.setEditable(false);

        statPanel.add(fullnessField);
        statPanel.add(healthField);
        statPanel.add(weightField);

        //Message frame

        //Image frame

        //Add to JFrame
        frame.add(buttonPanel, BorderLayout.WEST);
        frame.add(statPanel, BorderLayout.EAST);
        frame.add(imagePanel, BorderLayout.CENTER);
        frame.add(messagePanel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }
    public void update(Pet vPet){
        //Update the UI
        fullnessField.setText("Fullness: " + vPet.getFullness());
        healthField.setText("Health: " + vPet.getHealth());
        weightField.setText("Weight: " + vPet.getWeight());
    }
}