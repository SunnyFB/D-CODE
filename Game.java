
import java.io.File;
import javax.swing.JFrame;

public class Game {
    JFrame frame;

    public Game()
    {
        frame = new JFrame("Game Title");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
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
        
        frame.setVisible(true);
    }
}
