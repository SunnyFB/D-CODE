public class Alien extends Pet{

    /**
     * Alien is a subclass of Pet. Aliens are harder to take care of than normal pets.
     * They are drastically more affected by activities.
     */
    public Alien(double hunger,double weight, double happiness,double energy,double health)
    {
        super(hunger,weight,happiness,energy,health);
    }

    public Alien()
    {
        super();
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
