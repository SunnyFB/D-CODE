public class Alien extends Pet{

    /**
     * Alien is a subclass of Pet.
     * Aliens are weird, and its stats will change differently when it does an activity.
     */
    public Alien(double hunger,double weight, double happiness,double energy,double health)
    {
        super(hunger,weight,happiness,energy,health);
    }

    public Alien()
    {
        super();
    }
}
