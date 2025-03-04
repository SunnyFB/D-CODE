
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Game extends Main{

    File saveFile;
    Pet virtualPet;
    Scanner scanner;
    UI ui;
    Scanner scanner;
    UI ui;

    private final String saveName = "petgamedata.txt";

    public Game()
    {
    }

    public void start(){
        ui = new UI();
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
        
                        System.out.println("Save file loaded!");
                        System.out.println(virtualPet.getHunger());
                        System.out.println(virtualPet.getWeight());
                        System.out.println(virtualPet.getHappiness());
                        System.out.println(virtualPet.getEnergy());
                        System.out.println(virtualPet.getHealth());
        
                        ui.openUI(virtualPet);
                        gameLoop();
        
                        reader.close();
                    }
        
                } catch (Exception e) {
                    e.printStackTrace();
                }
    }

    public void save()
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


    Timer timer = new Timer();
    int begin = 0;
    int timeInterval = 1000;

    timer.scheduleAtFixedRate(new TimerTask() {
        @Override
        public void run() {
            updateGame();
        }
    }, begin, timeInterval);



    private void gameLoop() {
        final double gameHertz = 0.5;
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
        virtualPet.setHunger(virtualPet.getHunger() + .1);
        ui.update(virtualPet);
    }

    public void feed(){
        virtualPet.feed(false);
    }

    public void feed(){
        virtualPet.feed(false);
    }
}
