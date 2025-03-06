import javax.swing.*;
import java.awt.event.*;

public class UI extends Game{
    JFrame frame;
    JTextField fullnessField;
    //variables to update Game
    public boolean feedFood = false;
    public boolean feedTreat = false;
    public boolean save = false;

    public void openUI(Pet vPet){
        // Default Window Nonsense
        frame = new JFrame("Tamagotchi Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

        JPanel panel = new JPanel();

        JButton feedButton = new JButton("Feed");
        fullnessField = new JTextField("Fullness: " + vPet.getFullness());
        fullnessField.setEditable(false);
        ActionListener a1 = new ActionListener() {
            public void actionPerformed(ActionEvent ae){
                feedFood = true;
            }
        };
        feedButton.addActionListener(a1);

        JButton saveButton = new JButton("Save");
        ActionListener a2 = new ActionListener() {
            public void actionPerformed(ActionEvent ae){
                save = true;
            }
        };
        saveButton.addActionListener(a2);

        panel.add(feedButton);
        panel.add(fullnessField);
        panel.add(saveButton);
        frame.add(panel);

        frame.setVisible(true);
    }
    public void update(Pet vPet){
        //Update the UI
        fullnessField.setText("Fullness: " + vPet.getFullness());
    }
}