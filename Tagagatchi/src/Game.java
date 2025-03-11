package Tagagatchi.src;

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
    boolean isDead = false;

    private final String saveName = "petgamedata.txt";

    public Game()
    {
    }

    /**
     * Starts game. 
     * If there is an exsisting save file, Game uses that, but if not, it creates a new one.
     */
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
                start();
            } else {
                        
                String[] vars = new String[6];
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
                    Double.parseDouble(vars[4]), 
                    Double.parseDouble(vars[4]));
        
                System.out.println("Save file loaded!");
        
                ui.openGameUI(virtualPet);
                gameLoop();
        
                reader.close();
            }
        
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Saves pet attributes to a text file
     */
    public void save()
    {
        try {
            double fullness = virtualPet.getFullness();
            double weight = virtualPet.getWeight();
            double happiness = virtualPet.getHappiness();
            double energy = virtualPet.getEnergy();
            double health = virtualPet.getHealth();
            double hygiene = virtualPet.getHygiene();

            BufferedWriter writer = new BufferedWriter(new FileWriter(saveFile));
            /*
             * Order in which data should be saved, 
             * and used in pet constructor
             * fullness
             * WEIGHT
             * HAPPINESS
             * ENERGY
             * HEALTH
             * hygiene
             */
            writer.write(Double.toString(fullness));
            writer.write("\n" + Double.toString(weight));
            writer.write("\n" + Double.toString(happiness));
            writer.write("\n" + Double.toString(energy));
            writer.write("\n" + Double.toString(health));
            writer.write("\n" + Double.toString(hygiene));
            writer.flush();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    private void gameLoop() {
        //Game timer
        Timer gameTimer = new Timer();
        int gameBegin = 0;
        int gameTimeInterval = 1000;
        
        gameTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                updateGame();
            }
        }, gameBegin, gameTimeInterval);
        
        //UI timer
        Timer uiTimer = new Timer();
        int uiBegin = 0;
        int uiTimeInterval = 10;
        
        uiTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                updateFromUi();
            }
        }, uiBegin, uiTimeInterval);
    }

    /**
     * Updating from UI.
     * Runs every 10 ms.
     */
    private void updateFromUi()
    {
        
        //Saving
        if (ui.save) save();
        ui.save = false;
        
        //Feeding
        if (ui.feedFood) virtualPet.feed(false);
        ui.feedFood = false;

        if (ui.feedTreat) virtualPet.feed(false);
        ui.feedTreat = false;

        ui.update(virtualPet);
    }

    /**
     * updates every second
     */
    public void updateGame(){
        if (!isDead)
        {
            virtualPet.setFullness(virtualPet.getFullness() - virtualPet.fullnessDrain());
            //virtualPet.setHappiness(virtualPet.getHappiness()- virtualPet.happinessDrain());
            //virtualPet.setEnergy(virtualPet.getEnergy()-virtualPet.energyDrain());
            //virtualPet.setHygiene(virtualPet.getHygiene()-virtualPet.hygieneDrain());
    
            //It is out of food
            
            if (virtualPet.getFullness() > 5){
                virtualPet.setWeight(virtualPet.getWeight()+.1);
            }
            
            if (virtualPet.isHungry() == 0){
                System.out.println("Not hungry");
            }else if (virtualPet.isHungry() == 1){
                System.out.println("Feed soon");
            }else if (virtualPet.isHungry() == 2){
                System.out.println("Feed Now!");
                System.out.println(virtualPet.getHealth());
            }
    
            //Is it dead yet
            if (virtualPet.isDead()){
                isDead = true;
                System.out.println("I IS DED");
            }
        }
    }
}