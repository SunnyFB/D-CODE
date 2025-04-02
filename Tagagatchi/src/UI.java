package Tagagatchi.src;
import javax.swing.*;
import java.awt.event.*;
import com.formdev.flatlaf.*;

public class UI extends Game{
    JFrame frame;
    JTextField fullnessField;
    JTextField healthField;
    JTextField weightField;
    JTextField hygieneField;
    JTextField energyField;
    JTextField happinessField;

    //variables to update Game
    public boolean feedFood = false;
    public boolean feedTreat = false;
    public boolean play = false, walk = false, doctor = false, trick = false, bath = false, nap = false;
    public boolean save = false, paused = false;

    public String petType;

    public void openGameUI(Pet vPet){
        FlatLightLaf.setup();
        // Default Window Nonsense
        frame = new JFrame("Tamagotchi Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

        JPanel panel = new JPanel();

        JButton doctorButton = new JButton("Take to Doctor");
        JButton trainButton = new JButton("Teach a Trick");
        JButton bathButton = new JButton("Bath Time");
        JButton napButton = new JButton("Nap Time");



        fullnessField = new JTextField("Fullness: " + vPet.getFullness());
        fullnessField.setEditable(false);

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

        JButton feedButton = new JButton("Feed"); //button to feed pet
        ActionListener a1 = new ActionListener() {
            public void actionPerformed(ActionEvent ae){
                if (!paused)
                    feedFood = true;
            }
        };
        feedButton.addActionListener(a1);

        JButton playButton = new JButton("Play"); //button to play with pet
        ActionListener a4 = new ActionListener(){
            public void actionPerformed(ActionEvent ae) {
                if (!paused)
                    play = true;
            }
        };
        playButton.addActionListener(a4);

        JButton walkButton = new JButton("Walk");
        ActionListener a5 = new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                if (!paused)
                    walk = true;
            }
        };
        walkButton.addActionListener(a5);

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

        //activity buttons
        panel.add(feedButton);
        panel.add(playButton);
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
        frame.add(panel);

        frame.setVisible(true);
    }

    public void update(Pet vPet){
        //Update the UI
        fullnessField.setText("Fullness: " + vPet.getFullness());
        healthField.setText("Health: " + vPet.getHealth());
        weightField.setText("Weight: " + vPet.getWeight());
        happinessField.setText("Happiness: " + vPet.getHappiness());
        hygieneField.setText("Hygiene: " + vPet.getHygiene());
        energyField.setText("Engery: " + vPet.getEnergy());
    }

    public String getPetType()
    {
        return petType;
    }
}