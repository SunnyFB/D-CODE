public class Pet
{
    private int health, weight, happiness, energy;
    private double hunger;
    private final int maxHealth = 100, minHunger = 0, maxHappiness = 100, maxWeight = 100, maxEnergy = 100;

    public Pet(double hunger,int weight, int happiness,int energy,int health)
    {
       this.health = health;
       this.weight = weight;
       this.happiness = happiness;
       this.hunger = hunger;
       this.energy = energy;
    }

    public Pet()
    {
        health = maxHealth;
        weight = maxWeight;
        happiness = maxHappiness;
        hunger = 0;
        energy = maxEnergy;
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
        if (happiness > maxHappiness)
        {
            happiness = maxHappiness;
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
        if (hunger < minHunger)
        {
            hunger = minHunger;
        }
    }

    /**
     * Checks if pet is Hungry. If it is it will call the hungry method
     */
    public void isHungry()
    {
        if (hunger >= 75)
        {
            hungry(true);
        } else if (hunger >= 50)
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
        hunger++;
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
        hunger += 2;
        boundValues();
        isHungry();
    }

    /**
     * feeds pet
     */
    public void feed(Boolean isTreat)
    {
        if (isTreat)
        {
            weight += 2;
            hunger -= 0.5;

        } else
        {
            weight++;
            health++;
            energy++;
            hunger--;
        }
        boundValues();
        isHungry();
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
        hunger++;
        boundValues();
    }

    /**
     * returns health
     */
    public int getHealth()
    {
        return health;
    }
    /**
     * sets health to a new value
     */
    public void setHealth(int newHealth)
    {
        health = newHealth;
    }
    
    /**
     * gets weight
     */
    public int getWeight()
    {
        return weight;
    }
    /**
     * sets weight to a new value
     */
    public void setWeight(int newWeight)
    {
        weight = newWeight;
    }
    
    /**
     * returns happiness
     */
    public int getHappiness()
    {
        return happiness;
    }
    /**
     * sets happiness to a new value
     */
    public void setHappiness(int newHappiness)
    {
        happiness = newHappiness;
    }

    /**
     * returns hunger
     */
    public double getHunger()
    {
        return hunger;
    }
    /**
     * sets hunger to a new value
     */
    public void setHunger(int newHunger)
    {
        hunger = newHunger;
    }
    
    /**
     * returns energy
     */
    public int getEnergy()
    {
        return energy;
    }
    /**
     * sets energy to a new value
     */
    public void setEnergy(int newEnergy)
    {
        energy = newEnergy;
    }
}