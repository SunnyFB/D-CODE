public class Cat extends Pet{
    /**
     * Cat is a subclass of Pet.
     * Cats get hungry faster, tired faster, but don't get unhappy or dirty as fast
     */
    public Cat(double fullness,double weight, double happiness,double energy,double health, double hygiene)
    {
        super(fullness,weight,happiness,energy,health,hygiene);
    }

    public Cat()
    {
        super();
    }

    /**
     * @return Cat's fullness drain rate
     * @override
     */
    public double fullnessDrain()
    {
        return 0.2;
    }

    /**
     * @return Cat's happiness drain rate
     * @override
     */
    public double happinessDrain()
    {
        return 0.035;
    }

    /**
     * @return Cat's energy drain rate
     * @override
     */
    public double energyDrain()
    {
        return 0.02;
    }

    /**
     * @return returns the drain rate for hygiene
     * @override
     */
    public double hygieneDrain()
    {
        return 0.0001;
    }
    
}
