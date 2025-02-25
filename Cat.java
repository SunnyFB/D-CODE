public class Cat extends Pet{
    /**
     * Cat is a subclass of Pet.
     * Cats get hungry more often.
     */
    public Cat(double hunger,double weight, double happiness,double energy,double health)
    {
        super(hunger,weight,happiness,energy,health);
    }

    public Cat()
    {
        super();
    }

    /**
     * Cat's version of isHungry().
     * Cats are concidered Hungry sooner than normal pets.
     */
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

    /**
     * Cat's version of walk.
     * Stats change the same, but calls the cat version of isHungry()
     */
    public void walk()
    {
        super.setWeight(super.getWeight() - 1);
        super.setEnergy(super.getEnergy() - 1);
        super.setHappiness(super.getHappiness() + 1);
        super.setHealth(super.getHealth() + 1);
        super.setHunger(super.getHunger() + 1);
        super.boundValues();
        isHungry();
    }

    /**
     * Cat's version of play.
     * Stats change the same, but calls the cat version of isHungry()
     */
    public void play()
    {
        super.setWeight(super.getWeight() - 2);
        super.setEnergy(super.getEnergy() - 2);
        super.setHappiness(super.getHappiness() + 2);
        super.setHealth(super.getHealth() + 2);
        super.setHunger(super.getHunger() + 2);
        super.boundValues();
        isHungry();
    }

    /***
     * Cat's version of attending training.
     * Stats change the same, but calls the cat version of isHungry.
     */
    public void train()
    {
        super.setHappiness(super.getHappiness() + 1);
        super.setEnergy(super.getEnergy() + 1);
        super.setHunger(super.getHunger() + 1);
        super.boundValues();
        isHungry();
    }



}
