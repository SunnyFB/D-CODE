package Tagagatchi.src;
import javax.swing.*;
import java.awt.event.*;
import com.formdev.flatlaf.*;

public class UI extends Game{
    JFrame frame;
    JTextField fullnessField;
    JTextField healthField;
    JTextField weightField;
    JProgressBar fullnessBar;

    //variables to update Game
    public boolean feedFood = false;
    public boolean feedTreat = false;
    public boolean save = false, paused = false;

    public String petType;

    public void openGameUI(Pet vPet){
        FlatLightLaf.setup();
        // Default Window Nonsense
        frame = new JFrame("Tamagotchi Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

        JPanel panel = new JPanel();

        JButton feedButton = new JButton("Feed");


        fullnessField = new JTextField("Fullness: " + vPet.getFullness());
        fullnessField.setEditable(false);
        fullnessBar = new JProgressBar(0, 100);
        fullnessBar.setValue((int) (vPet.getFullness() * 10));

        healthField = new JTextField("Health: " + vPet.getFullness());
        healthField.setEditable(false);

        weightField = new JTextField("Health: " + vPet.getFullness());
        weightField.setEditable(false);

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
                if (paused)
                    pauseButton.setText("Unpause");
                if (!paused)
                    pauseButton.setText("Pause");
            }
        };
        pauseButton.addActionListener(a3);

        panel.add(feedButton);
        panel.add(fullnessField);
        panel.add(healthField);
        panel.add(weightField);
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
        fullnessBar.setValue((int) (vPet.getFullness() * 10));
    }

    public String getPetType()
    {
        return petType;
    }
}