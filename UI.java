import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class UI{
    JFrame frame;
    public void openUI(double hunger){
        // Default Window Nonsense
        frame = new JFrame("Game Title");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

        JPanel panel = new JPanel();

        JButton feed = new JButton("Feed");
        //virtualPet.getHunger()
        JTextField hungerField = new JTextField("Hunger: " + hunger);
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
                save();
            }
        };
        save.addActionListener(a2);

        panel.add(feed);
        panel.add(hunger);
        panel.add(save);
        frame.add(panel);

        frame.setVisible(true);
    }
}