
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class Game extends Main{

    File saveFile;
    Pet virtualPet;
    Scanner scanner;
    UI ui = new UI();

    private final String saveName = "petgamedata.txt";

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
                        Integer.parseInt(vars[1]), 
                        Integer.parseInt(vars[2]), 
                        Integer.parseInt(vars[3]), 
                        Integer.parseInt(vars[4]));

                System.out.println("Save file loaded!");
                System.out.println(virtualPet.getHunger());
                System.out.println(virtualPet.getWeight());
                System.out.println(virtualPet.getHappiness());
                System.out.println(virtualPet.getEnergy());
                System.out.println(virtualPet.getHealth());

                ui.openUI(virtualPet.getHunger());

                reader.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        save();
        // Game loop down here

    }

    public void save()
    {
        try {
            double hunger = virtualPet.getHunger();
            int weight = virtualPet.getWeight();
            int happiness = virtualPet.getHappiness();
            int energy = virtualPet.getEnergy();
            int health = virtualPet.getHealth();

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
            writer.write("\n" + Integer.toString(weight));
            writer.write("\n" + Integer.toString(happiness));
            writer.write("\n" + Integer.toString(energy));
            writer.write("\n" + Integer.toString(health));
            writer.flush();
            writer.close();
            System.out.println("File Successfully Saved!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void feed(){}

    
}
