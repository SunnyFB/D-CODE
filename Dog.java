public class Dog extends Pet
{
    /**
     * Dog is a subclass of Pet. 
     * Dogs need more attention, and lose happiness faster.
     */
    public Dog(double fullness,double weight, double happiness,double energy,double health,double hygiene)
    {
        super(fullness,weight,happiness,energy,health,hygiene);
    }

    public Dog()
    {
        super();
    }

    public double HappinessDrain()
    {
        return 0.1;
    }
}
