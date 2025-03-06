import java.text.DecimalFormat;

public class Pet
{
    private double health, weight, happiness, energy,fullness, hygiene;
    private final double maxHealth = 10.0, maxFullness = 10.0, maxHappiness = 10.0, maxWeight = 10.0, maxEnergy = 10.0, maxHygiene = 10.0;

    public Pet(double fullness,double weight, double happiness,double energy,double health, double hygiene)
    {
       this.health = health;
       this.weight = weight;
       this.happiness = happiness;
       this.fullness = fullness;
       this.energy = energy;
       this.hygiene = hygiene;
    }

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
     * returns the drain rate for fullness
     */
    public double fullnessDrain()
    {
        return 0.1;
    }

    /**
     * returns the drain rate for happiness
     */
    public double happinessDrain()
    {
        return 0.05;
    }

    /**
     * returns the drain rate for energy
     */
    public double energyDrain()
    {
        return 0.01;
    }
    
    /**
     * returns the drain rate for hygiene
     */
    public double hygieneDrain()
    {
        return 0.02;
    }

    /**
     * checks if pet is dead
     */
    public boolean isDead()
    {
        if ((health == 0)||(weight == 0))
        {
            return true;
        } else {
            return false;
        }
    }

    /**
     * checks that all stats are not greater than their max
     */
    public void boundValues()
    {
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
            weight++; //pet gets fatter if it gets fed too much
        }
        if (weight > maxWeight)
        {
            weight = maxWeight;
        }
        if (health > maxHealth)
        {
            health = maxHealth;
        }
        if (energy > maxEnergy)
        {
            energy = maxEnergy;
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
        }
        boundValues();
    }

    /**
     * Pet is Hungry when hunger gets too high
     */
    public void hungry(Boolean isVeryHungry)
    {
        if (isVeryHungry)
        {
            weight -= 2;
            happiness -= 2;
            health--;
            energy--;
        } else {
            weight--;
            happiness--;
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
     * returns health
     */
    public double getHealth()
    {
        return decimalRound(health);
    }
    /**
     * sets health to a new value
     */
    public void setHealth(double newHealth)
    {
        health = newHealth;
    }
    
    /**
     * gets weight
     */
    public double getWeight()
    {
        return decimalRound(weight);
    }
    /**
     * sets weight to a new value
     */
    public void setWeight(double newWeight)
    {
        weight = newWeight;
    }
    
    /**
     * returns happiness
     */
    public double getHappiness()
    {
        return decimalRound(happiness);
    }
    /**
     * sets happiness to a new value
     */
    public void setHappiness(double newHappiness)
    {
        happiness = newHappiness;
    }

    /**
     * returns hunger
     */
    public double getFullness()
    {
        return decimalRound(fullness);
    }
    /**
     * sets hunger to a new value
     */
    public void setFullness(double newFullness)
    {
        fullness = newFullness;
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
        energy = newHygiene;
    }

    /**
     * returns a rounded decimal.
     * used by the attribute get methods.
     */
    private double decimalRound(double num)
    {
        DecimalFormat df = new DecimalFormat("#.#");
        return Double.parseDouble(df.format(num));
    }
}