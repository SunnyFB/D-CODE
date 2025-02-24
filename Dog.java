public class Dog extends Pet
{
    /**
     * Dog is a subclass of Pet. 
     * Dogs need more attention, and its happiness will run out faster.
     */
    
    private final int maxHappiness = 6;

    public Dog(double hunger,int weight, int happiness,int energy,int health)
    {
        super(hunger,weight,happiness,energy,health);
    }

    public Dog()
    {
        super();
    }

    public void boundValues()
    {
        super.boundValues();
        if (super.getHappiness() > maxHappiness)
        {
            super.setHappiness(maxHappiness);
        }
    }

    public void walk()
    {
        super.walk();
        boundValues();
    }

    public void play()
    {
        super.play();
        boundValues();
    }

    public void train()
    {
        super.train();
        boundValues();
    }
}
