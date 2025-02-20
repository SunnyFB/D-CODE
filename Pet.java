public class Pet {
    private int weight, happiness, energy, health;
    private double hunger;
    private final int maxHunger, maxWeight, maxHappiness, maxEnergy, maxHealth;

    public Pet(double hunger, int weight, int happiness, int energy, int health)
    {
        this.hunger = hunger;
        this.weight = weight;
        this.happiness = happiness;
        this.energy = energy;
        this.health = health;
        maxHunger = 100;
        maxWeight = 100;
        maxHappiness = 100;
        maxEnergy = 100;
        maxHealth = 100;
    }

    public Pet()
    {
        maxHunger = 100;
        maxWeight = 100;
        maxHappiness = 100;
        maxEnergy = 100;
        maxHealth = 100;
    }

    public void boundValues()
    {
        if (happiness > maxHappiness) 
            happiness = maxHappiness;

        if (hunger > maxHunger)
            hunger = maxHunger;

        if (weight > maxWeight)
            weight = maxWeight;

        if (energy > maxEnergy)
            energy = maxEnergy;

        if (health > maxHealth)
            health = maxHealth;
    }

    public int getHealth()
    {
        return health;
    }

    public int getWeight()
    {
        return weight;
    }

    public int getHappiness()
    {
        return happiness;
    }

    public int getEnergy()
    {
        return energy;
    }

    public double getHunger()
    {
        return hunger;
    }
}
