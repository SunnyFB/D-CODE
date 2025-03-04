import javax.swing.*;
import java.awt.event.*;

public class UI extends Game{
    JFrame frame;
    JTextField hungerField;
    public void openUI(Pet vPet){
        // Default Window Nonsense
        frame = new JFrame("Tamagotchi Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

        JPanel panel = new JPanel();

        JButton feedButton = new JButton("Feed");
        hungerField = new JTextField("Hunger: " + vPet.getFullness());
        hungerField.setEditable(false);
        ActionListener a1 = new ActionListener() {
            public void actionPerformed(ActionEvent ae){
                feed();
            }
        };
        feedButton.addActionListener(a1);

        JButton save = new JButton("Save");
        ActionListener a2 = new ActionListener() {
            public void actionPerformed(ActionEvent ae){
                save();
            }
        };
        save.addActionListener(a2);

        panel.add(feedButton);
        panel.add(hungerField);
        panel.add(save);
        frame.add(panel);

        frame.setVisible(true);
    }
    public void update(Pet vPet){
        //Update the UI
        hungerField.setText("Hunger: " + vPet.getFullness());
        System.out.println("Hungerless"+vPet.getFullness());
    }
}