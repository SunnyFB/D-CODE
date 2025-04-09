package Tagagatchi.src;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;


public class Game extends Main{

    String petType = "blob";
    File saveFile;
    Pet virtualPet;
    UI ui;
    boolean isDead = false;
    int timer = 0;

    private final String saveName = "petgamedata.txt";

    public Game()
    {
    }

    /**
     * Starts game. 
     * If there is an exsisting save file, Game uses that, but if not, it creates a new one.
     */
    @SuppressWarnings({"CallToPrintStackTrace", "UseSpecificCatch"})
    public void start(){
        ui = new UI();
        // Handle Save Data
        try {
            saveFile = new File(saveName);

            // New Save File
            if (saveFile.createNewFile()) {
                ui.openStartUI();
                Timer Timer = new Timer();
                int Begin = 0;
                int TimeInterval = 50;
                
                Timer.scheduleAtFixedRate(new TimerTask() {
                    @Override
                    public void run() {
                        if(ui.petType != ""){
                            try{
                                BufferedWriter writer = new BufferedWriter(new FileWriter(saveName));
                                writer.write("5");//fullness
                                writer.write("\n5"); //weight
                                writer.write("\n10"); //happiness
                                writer.write("\n10"); //Energy
                                writer.write("\n10"); //HEealth
                                writer.write("\n0"); //Hygene
                                writer.write("\n0"); //Timer
                                writer.write("\n" + ui.petType); //Pet type
                        
                                virtualPet = switch (ui.petType) {
                                    case "cat" -> new Cat();
                                    case "dog" -> new Dog();
                                    case "alien" -> new Alien();
                                    default -> new Pet();
                                };
                        
                                writer.flush();
                                writer.close();
                        
                                System.out.println("New save file was created!");
                        
                                // Loaded Save File
                                Timer.cancel();
                                start();
                            }catch (IOException e){
                                e.printStackTrace();
                            }
                        }
                            
                    }
                }, Begin, TimeInterval);

            } else {
                        
                String[] vars = new String[8];
                BufferedReader reader = new BufferedReader(new FileReader(saveFile));
                String line;
                int i = 0;
                while ((line = reader.readLine()) != null)
                {
                    vars[i] = line;
                    System.out.println(vars[i]);
                    i++;
                }

                petType = vars[7]; //gets pet type from the file
        
                virtualPet = switch (petType) {
                    case "cat" -> new Cat(Double.parseDouble(vars[0]),
                            Double.parseDouble(vars[1]),
                            Double.parseDouble(vars[2]),
                            Double.parseDouble(vars[3]),
                            Double.parseDouble(vars[4]),
                            Double.parseDouble(vars[5]));
                    case "dog" -> new Dog(Double.parseDouble(vars[0]),
                            Double.parseDouble(vars[1]),
                            Double.parseDouble(vars[2]),
                            Double.parseDouble(vars[3]),
                            Double.parseDouble(vars[4]),
                            Double.parseDouble(vars[5]));
                    case "alien" -> new Alien(Double.parseDouble(vars[0]),
                            Double.parseDouble(vars[1]),
                            Double.parseDouble(vars[2]),
                            Double.parseDouble(vars[3]),
                            Double.parseDouble(vars[4]),
                            Double.parseDouble(vars[5]));
                    default -> new Pet(Double.parseDouble(vars[0]),
                            Double.parseDouble(vars[1]),
                            Double.parseDouble(vars[2]),
                            Double.parseDouble(vars[3]),
                            Double.parseDouble(vars[4]),
                            Double.parseDouble(vars[5]));
                };

                timer = Integer.parseInt(vars[6]);
        
                System.out.println("Save file loaded!");
        
//                ui.openStartUI();
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
    @SuppressWarnings("CallToPrintStackTrace")
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
             * HYGIENE
             * TIMER
             */
            writer.write(Double.toString(fullness));
            writer.write("\n" + Double.toString(weight));
            writer.write("\n" + Double.toString(happiness));
            writer.write("\n" + Double.toString(energy));
            writer.write("\n" + Double.toString(health));
            writer.write("\n" + Double.toString(hygiene));
            writer.write("\n" + Integer.toString(timer));
            writer.write("\n" + petType);
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
                if(!ui.paused)
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

        if (ui.play) virtualPet.play();
        ui.play = false;

        if (ui.walk) virtualPet.walk();
        ui.walk = false;

        if (ui.doctor) virtualPet.toDoctor();
        ui.doctor = false;

        if (ui.trick) virtualPet.train();
        ui.trick = false;

        if (ui.bath) virtualPet.giveBath();
        ui.bath = false;

        if (ui.nap) virtualPet.sleep();
        ui.nap = false;

        ui.update(virtualPet);
    }

    /**
     * updates every second
     */
    public void updateGame(){
        if (!isDead)
        {
            virtualPet.setFullness(virtualPet.getFullness() - virtualPet.fullnessDrain());
            virtualPet.setHappiness(virtualPet.getHappiness()- virtualPet.happinessDrain());
            virtualPet.setEnergy(virtualPet.getEnergy()-virtualPet.energyDrain());
            virtualPet.setHygiene(virtualPet.getHygiene()-virtualPet.hygieneDrain());
            timer++;
    
            //Is it dead yet
            if (virtualPet.isDead()){
                isDead = true;
                System.out.println("I IS DED");
            }

            virtualPet.isHungry();
            virtualPet.healthyPet();
        }
    }
}