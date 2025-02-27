
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class Game extends Main{

    File saveFile;
    Pet virtualPet;
    UI ui = new UI();

    private final String saveName = "petgamedata.txt";

    private boolean feeding = false;
    
    public Game()
    {
        // Handle Save Data
        try {
            saveFile = new File(saveName);

            // New Save File
            if (saveFile.createNewFile()) {

                BufferedWriter writer = new BufferedWriter(new FileWriter(saveName));
                writer.write("0");
                writer.write("\n100");
                writer.write("\n100");
                writer.write("\n100");
                writer.write("\n100");

                virtualPet = new Pet();

                writer.flush();
                writer.close();

                System.out.println("New save file was created!");

            // Loaded Save File
            } else {
                
                String[] vars = new String[5];
                BufferedReader reader = new BufferedReader(new FileReader(saveFile));
                String line;
                int i = 0;
                while ((line = reader.readLine()) != null)
                {
                    vars[i] = line;
                    System.out.println(vars[i]);
                    i++;
                }

                virtualPet = new Pet(Double.parseDouble(vars[0]), 
                    Double.parseDouble(vars[1]), 
                    Double.parseDouble(vars[2]), 
                    Double.parseDouble(vars[3]), 
                    Double.parseDouble(vars[4]));

                reader.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        save();

        runGameLoop();
        // Game loop down here

    }

    public void runGameLoop() {
        Thread loop = new Thread(new Runnable() {
            @Override
            public void run() {
                gameLoop();
            }
        });
        loop.start();
    }

    private void save()
    {
        try {
            double hunger = virtualPet.getFullness();
            double weight = virtualPet.getWeight();
            double happiness = virtualPet.getHappiness();
            double energy = virtualPet.getEnergy();
            double health = virtualPet.getHealth();

            BufferedWriter writer = new BufferedWriter(new FileWriter(saveFile));
            /*
             * Order in which data should be saved, 
             * and used in pet constructor
             * HUNGER
             * WEIGHT
             * HAPPINESS
             * ENERGY
             * HEALTH
             */
            writer.write(Double.toString(hunger));
            writer.write("\n" + Double.toString(weight));
            writer.write("\n" + Double.toString(happiness));
            writer.write("\n" + Double.toString(energy));
            writer.write("\n" + Double.toString(health));
            writer.flush();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void gameLoop() {
        final double gameHertz = 2.0;
        final double timeBetweenUpdates = 1000000000 / gameHertz;
        double lastUpdate = System.nanoTime();

        while (true) { 
            double now = System.nanoTime();
            if(now - lastUpdate > timeBetweenUpdates)
            {
                lastUpdate = now;
                updateGame();
            }
        }
    }

    private void updateGame()
    {
        if (feeding)
        {
            virtualPet.feed(false);
        }
        virtualPet.setFullness(virtualPet.getFullness() + .1);
        feeding = false;
        hunger.setText("Hunger: " + virtualPet.getFullness());
    }
    
}
