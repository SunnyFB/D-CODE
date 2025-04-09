package Tagagatchi.src;
import java.text.DecimalFormat;

public class Pet
{
    private double health, weight, happiness, energy,fullness, hygiene;
    private final double maxHealth = 10.0, maxFullness = 10.0, maxHappiness = 10.0, maxWeight = 10.0, maxEnergy = 10.0, maxHygiene = 10.0;
    protected String petType = "blob";

    /**
     * Constructor for Pet
     * @param fullness measures hunger of the pet
     * @param weight measures weight of the pet
     * @param happiness measures happiness of the pet
     * @param energy measures energy of the pet
     * @param health measures health of the pet
     * @param hygiene measures hygiene of the pet
     */
    public Pet(double fullness,double weight, double happiness,double energy,double health, double hygiene)
    {
       this.health = health;
       this.weight = weight;
       this.happiness = happiness;
       this.fullness = fullness;
       this.energy = energy;
       this.hygiene = hygiene;
    }

    /**
     * No parameter constructor for Pet. Used for start of game.
     */
    public Pet()
    {
        health = maxHealth;
        weight = maxWeight;
        happiness = maxHappiness;
        fullness = maxFullness;
        energy = maxEnergy;
        hygiene = maxHygiene;
    }

    /**
     * Determines the emotion of the pet
     * @return a string to represent the emotional state of the pet
     */
    public String emotion()
    {
        if (fullness <= 4)
        {
            return "hungry";
        } else if (energy < 5)
        {
            return "tired";
        }
        else if (happiness < 6 && happiness > 3)
        {
            return "meh";
        } else if (happiness <= 3 && happiness > 1)
        {
            return "sad";
        } else if (happiness <= 1)
        {
            return "big_sad";
        } else 
        {
            return "happy";
        }
    }

    /**
     * @return the drain rate for fullness
     */
    public double fullnessDrain()
    {
        return 0.1;
    }

    /**
     * @return the drain rate for happiness
     */
    public double happinessDrain()
    {
        return 0.05;
    }

    /**
     * @return the drain rate for energy
     */
    public double energyDrain()
    {
        return 0.01;
    }
    
    /**
     * @return the drain rate for hygiene
     */
    public double hygieneDrain()
    {
        return 0.02;
    }

    /**
     * checks if pet is dead
     * @return true if dead or false if alive
     */
    public boolean isDead()
    {
        return (health <= 0)||(weight <= 0);
    }

    /**
     * checks that all stats are not greater than their max and lower than 0
     */
    public void boundValues()
    {
        //checks if stats are above max
        if (hygiene > maxHygiene)
        {
            hygiene = maxHygiene;
        }
        if (happiness > maxHappiness)
        {
            happiness = maxHappiness;
        }
        if (fullness > maxFullness)
        {
            fullness = maxFullness;
            weight += .5; //pet gets fatter if it gets fed too much
        }
        if (weight > maxWeight)
        {
            weight = maxWeight;
            health -= .5; //pet gets unhealthy if it is overweight
        }
        if (health > maxHealth)
        {
            health = maxHealth;
        }
        if (energy > maxEnergy)
        {
            energy = maxEnergy;
        }
        
        //checks if stats are negative
        if (hygiene < 0) 
        {
            hygiene = 0;
            health -=.5; //pet gets unhealthy if it is too dirty
        }
        if (happiness < 0) 
        {
            happiness = 0;
        }
        if (fullness < 0) 
        {
            fullness = 0;
        }
        if (weight < 0) 
        {
            weight = 0;
        }
        if (health < 0) 
        {
            health = 0;
        }
        if (energy < 0) 
        {
            energy = 0;
        }
    }

    /**
     * Checks if pet is Hungry. If it is it will call the hungry method.
     */
    public void isHungry()
    {
        if (fullness <= 3)
        {
            hungry(true);
        } else if (fullness <= 5)
        {
            hungry(false);
        }
    }

    /**
     * Pet takes a nap
     */
    public void sleep()
    {
        energy += 2;
        health++;
        boundValues();
    }

    /**
     * take pet for walk
     */
    public void walk()
    {
        weight--;
        happiness++;
        health++;
        energy--;
        fullness--;
        hygiene--;
        boundValues();
        isHungry();
    }

    /**
     * play with pet
     */
    public void play()
    {
        weight -= 2;
        happiness += 2;
        health += 2;
        energy -= 2;
        fullness -= 2;
        hygiene -=2;
        boundValues();
        isHungry();
    }

    /**
     * feeds pet
     */
    public void feed(Boolean isTreat)
    {
        if (isTreat) //feeds pet a treat
        {
            weight += 2;
            fullness += 0.5;

        } else //feeds pet a meal
        {
            weight++;
            health++;
            energy++;
            fullness++;
            hygiene -= .5;
        }
        boundValues();
    }

    /**
     * Pet is Hungry when hunger gets too high
     * @param isVeryHungry true when pet is very hungry false if pet is not
     */
    public void hungry(boolean isVeryHungry)
    {
        if (isVeryHungry)
        {
            weight -= .2;
            happiness -= .2;
            health -= .1;
            energy -= .1;
        } else {
            weight -= .1;
            happiness -= .1;
        }
    }

    /**
     * Take pet to doctor
     */
    public void toDoctor()
    {
        happiness--;
        health += 2;
        boundValues();
    }

    /**
     * pet attends training
     */
    public void train()
    {
        happiness++;
        energy--;
        fullness--;
        hygiene--;
        boundValues();
        isHungry();
    }

    /**
     * give pet a bath
    */
    public void giveBath()
    {
        hygiene++;
        energy += .5;
        boundValues();
    }


    /**
     * rounds health than returns it
     * @return health rounded to 1 decimal point
     */
    public double getHealth()
    {
        return decimalRound(health);
    }
    /**
     * sets health to a new value
     * @param newHealth the new value of health
     */
    public void setHealth(double newHealth)
    {
        health = newHealth;
        boundValues();
    }
    
    /**
     * rounds weight than returns it
     * @return weight rounded to 1 decimal point
     */
    public double getWeight()
    {
        return decimalRound(weight);
    }
    /**
     * sets weight to a new value
     * @param newWeight the new value of weight
     */
    public void setWeight(double newWeight)
    {
        weight = newWeight;
        boundValues();
    }
    
    /**
     * rounds happiness than returns it
     * @return happiness rounded to 1 decimal point
     */
    public double getHappiness()
    {
        return decimalRound(happiness);
    }
    /**
     * sets happiness to a new value
     * @param newHappiness the new value of happiness
     */
    public void setHappiness(double newHappiness)
    {
        happiness = newHappiness;
        boundValues();
    }

    /**
     * rounds fullness than returns it
     * @return fullness rounded to 1 decimal point
     */
    public double getFullness()
    {
        return decimalRound(fullness);
    }
    /**
     * sets hunger to a new value
     * @param newFullness the new value of fullness
     */
    public void setFullness(double newFullness)
    {
        fullness = newFullness;
        boundValues();
    }
    
    /**
     * rounds energy than returns it
     * @return energy rounded to 1 decimal point
     */
    public double getEnergy()
    {
        return decimalRound(energy);
    }
    /**
     * sets energy to a new value
     * @param newEnergy new value of energy
     */
    public void setEnergy(double newEnergy)
    {
        energy = newEnergy;
        boundValues();
    }

    /**
     * rounds hygiene than returns it
     * @return hygiene rounded to 1 decimal point
     */
    public double getHygiene()
    {
        return decimalRound(hygiene);
    }
    /**
     * Sets hygiene to a new value
     * @param newHygiene new value of hygiene
     */
    public void setHygiene(double newHygiene)
    {
        hygiene = newHygiene;
        boundValues();
    }


    /*
     * Returns the petType as a string
     */
    public String getPetType()
    {
        return petType;
    }
    /**
     * returns a rounded decimal and used by the attribute get methods.
     * @param num the number to be rounded to 1 decimal point
     */
    private double decimalRound(double num)
    {
        DecimalFormat df = new DecimalFormat("#.##");
        return Double.parseDouble(df.format(num));
    }
}