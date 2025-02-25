public class Dog extends Pet
{
    /**
     * Dog is a subclass of Pet. 
     * Dogs need more attention, and have a lower max happiness.
     */
    
    public Dog(double hunger,double weight, double happiness,double energy,double health)
    {
        super(hunger,weight,happiness,energy,health);
    }

    public Dog()
    {
        super();
    }


    public void walk()
    {
    }

    public void play()
    {
    }

    public void train()
    {
    }
}
