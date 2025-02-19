
import java.io.File;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Game {
    JFrame frame;

    public Game()
    {
        // Default Window Nonsense
        frame = new JFrame("Game Title");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

        // Handle Save Data
        try {
            File save = new File("petgamedata.txt");

            if (save.createNewFile()) {
                System.out.println("New save file was created!");
            } else {
                System.out.println("Save file loaded!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JPanel panel = new JPanel();

        frame.setVisible(true);
    }
}
