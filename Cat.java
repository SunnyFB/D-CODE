public class Cat extends Pet{
    /**
     * Cat is a subclass of Pet.
     * Cats get hungry more often.
     */
    public Cat(double hunger,int weight, int happiness,int energy,int health)
    {
        super(hunger,weight,happiness,energy,health);
    }

    public Cat()
    {
        super();
    }

    public void isHungry()
    {
        if (super.getHunger() >= 5)
        {
            super.hungry(true);
        } else if (super.getHunger() >= 3)
        {
            super.hungry(false);
        }
    }

}
