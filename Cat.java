public class Cat extends Pet{
    /**
     * Cat is a subclass of Pet.
     * Cats get hungry faster, tired faster, but don't get unhappy as fast
     */
    public Cat(double fullness,double weight, double happiness,double energy,double health)
    {
        super(fullness,weight,happiness,energy,health);
    }

    public Cat()
    {
        super();
    }

    /**
     * Cat's fullness drain rate
     */
    public double fullnessDrain()
    {
        return 0.2;
    }

    /**
     * Cat's happiness drain rate
     */
    public double happinessDrain()
    {
        return 0.035;
    }

    /**
     * Cat's energy drain rate
     */
    public double energyDrain()
    {
        return 0.02;
    }
    
}
