public class Pet
{
    private double health, weight, happiness, energy,hunger;
    private final double maxHealth = 10.0, minHunger = 0, maxHappiness = 10.0, maxWeight = 10.0, maxEnergy = 10.0;

    public Pet(double hunger,double weight, double happiness,double energy,double health)
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
     * Checks if pet is Hungry. If it is it will call the hungry method.
     */
    public void isHungry()
    {
        if (hunger >= 6)
        {
            hungry(true);
        } else if (hunger >= 4)
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
        isHungry();
    }

    /**
     * returns health
     */
    public double getHealth()
    {
        return health;
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
        return weight;
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
        return happiness;
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
    public double getHunger()
    {
        return hunger;
    }
    /**
     * sets hunger to a new value
     */
    public void setHunger(double newHunger)
    {
        hunger = newHunger;
    }
    
    /**
     * returns energy
     */
    public double getEnergy()
    {
        return energy;
    }
    /**
     * sets energy to a new value
     */
    public void setEnergy(double newEnergy)
    {
        energy = newEnergy;
    }
}