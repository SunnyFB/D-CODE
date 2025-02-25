import javax.swing.*;
import java.awt.event.*;

public class UI extends Main{
    JFrame frame;
    public void openUI(double hungerValue){
        // Default Window Nonsense
        frame = new JFrame("Tamagotchi Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

        JPanel panel = new JPanel();

        JButton feed = new JButton("Feed");
        JTextField hungerField = new JTextField("Hunger: " + hungerValue);
        hungerField.setEditable(false);
        ActionListener a1 = new ActionListener() {
            public void actionPerformed(ActionEvent ae)
            {
                //feed
            }
        };
        feed.addActionListener(a1);

        JButton save = new JButton("Save");
        ActionListener a2 = new ActionListener() {
            public void actionPerformed(ActionEvent ae)
            {
                game.save();
            }
        };
        save.addActionListener(a2);

        panel.add(feed);
        panel.add(hungerField);
        panel.add(save);
        frame.add(panel);

        frame.setVisible(true);
    }
}