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
     * Alien's fullness drain rate
     */
    public double fullnessDrain()
    {
        return 0.2;
    }

    /**
     * Alien's happiness drain rate
     */
    public double happinessDrain()
    {
        return 0.1;
    }

    /**
     * Alien's energy drain rate
     */
    public double energyDrain()
    {
        return 0.03;
    }

    /**
     * Take alien for a walk.
     */
    public void walk()
    {
        super.walk();
        super.walk();
    }

    /**
     * Play with alien.
     */
    public void play()
    {
        super.play();
        super.play();
    }

    /**
     * Alien attends training.
     */
    public void train()
    {
        super.train();
        super.train();
    }

    /**
     * Alien goes to the doctor.
     */
    public void toDoctor()
    {
        super.toDoctor();
        super.toDoctor();
    }
}
