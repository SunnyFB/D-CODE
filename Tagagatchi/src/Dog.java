package Tagagatchi.src;
/**
 * Dog is a subclass of Pet.
 * Dogs need more attention, and their happiness runs out faster.
 */
public class Dog extends Pet
{
    /**
     * construcor for dog
     * @param fullness measures hunger of the dog
     * @param weight measures weight of the dog
     * @param happiness measures the happiness of the dog
     * @param energy measures the energy of the dog
     * @param health measures the health of the dog
     * @param hygiene measures the cleaness of the dog
     */
    public Dog(double fullness,double weight, double happiness,double energy,double health,double hygiene)
    {
        super(fullness,weight,happiness,energy,health,hygiene);
    }

    /**
     * no parameter constructor of dog
     */
    public Dog()
    {
        super();
    }

    /**
     * @return Dog's happiness drain rate
     */
    @Override
    public double happinessDrain()
    {
        return 0.1;
    }
}
