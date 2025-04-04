package Tagagatchi.src;
/**
 * Cat is a subclass of Pet.
 * Cats get hungry faster, tired faster, but don't get unhappy or dirty as fast.
 */
public class Cat extends Pet{
    /**
     * Constructor for cat
     * @param fullness measures hunger of the cat
     * @param weight measures weight of the cat
     * @param happiness measures happiness of the cat
     * @param energy measures energy of the cat
     * @param health measures health of the cat
     * @param hygiene measures hygiene of the cat
     */
    public Cat(double fullness,double weight, double happiness,double energy,double health, double hygiene)
    {
        super(fullness,weight,happiness,energy,health,hygiene);
        petType = "cat";
    }

    /**
     * no parameter constructor of cat
     */
    public Cat()
    {
        super();
    }

    /**
     * @return Cat's fullness drain rate
     */
    @Override
    public double fullnessDrain()
    {
        return 0.2;
    }

    /**
     * @return Cat's happiness drain rate
     */
    @Override
    public double happinessDrain()
    {
        return 0.035;
    }

    /**
     * @return Cat's energy drain rate
     */
    @Override
    public double energyDrain()
    {
        return 0.02;
    }

    /**
     * @return returns the drain rate for hygiene
     */
    @Override
    public double hygieneDrain()
    {
        return 0.0001;
    }
    
}
