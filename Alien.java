public class Alien extends Pet{

    /**
     * Alien is a subclass of Pet. Aliens are harder to take care of than normal pets.
     * They are drastically more affected by activities.
     */
    public Alien(double fullness,double weight, double happiness,double energy,double health,double hygiene)
    {
        super(fullness,weight,happiness,energy,health,hygiene);
    }

    public Alien()
    {
        super();
    }

    /**
     * @return Alien's fullness drain rate
     * @override
     */
    public double fullnessDrain()
    {
        return 0.2;
    }

    /**
     * @return Alien's happiness drain rate
     * @override
     */
    public double happinessDrain()
    {
        return 0.1;
    }

    /**
     * @return Alien's energy drain rate
     * @override
     */
    public double energyDrain()
    {
        return 0.03;
    }

    /**
     * @return Alien's hygiene drain rate
     * @override
     */
    public double hygieneDrain()
    {
        return 0.04;
    }


    /**
     * Take alien for a walk.
     * @override
     */
    public void walk()
    {
        super.walk();
        super.walk();
    }

    /**
     * Play with alien.
     * @override
     */
    public void play()
    {
        super.play();
        super.play();
    }

    /**
     * Alien attends training.
     * @override
     */
    public void train()
    {
        super.train();
        super.train();
    }

    /**
     * Alien goes to the doctor.
     * @override
     */
    public void toDoctor()
    {
        super.toDoctor();
        super.toDoctor();
    }

    /**
     * Alien is given bath
     * @override
     */
    public void giveBath()
    {
        super.giveBath();
        super.giveBath();
    }
}
