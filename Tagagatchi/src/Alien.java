package Tagagatchi.src;
/**
 * Alien is a subclass of Pet. Aliens are harder to take care of than normal pets.
 * They are drastically more affected by activities.
 */
public class Alien extends Pet{
    /**
     * Constructor for alien
     * @param fullness measures hunger of alien
     * @param weight measures weight of alien
     * @param happiness measures happiness of alien
     * @param energy measures energy of alien
     * @param health measures health of alien
     * @param hygiene measures hygiene of alien
     */
    public Alien(double fullness,double weight, double happiness,double energy,double health,double hygiene)
    {
        super(fullness,weight,happiness,energy,health,hygiene);
    }

    /**
     * no parameter constructor of Alien
     */
    public Alien()
    {
        super();
    }

    /**
     * @return Alien's fullness drain rate
     */
    @Override
    public double fullnessDrain()
    {
        return 0.2;
    }

    /**
     * @return Alien's happiness drain rate
     */
    @Override
    public double happinessDrain()
    {
        return 0.1;
    }

    /**
     * @return Alien's energy drain rate
     */
    @Override
    public double energyDrain()
    {
        return 0.03;
    }

    /**
     * @return Alien's hygiene drain rate
     */
    @Override
    public double hygieneDrain()
    {
        return 0.04;
    }


    /**
     * Take alien for a walk.
     */
    @Override
    public void walk()
    {
        super.walk();
        super.walk();
    }

    /**
     * Play with alien.
     */
    @Override
    public void play()
    {
        super.play();
        super.play();
    }

    /**
     * Alien attends training.
     */
    @Override
    public void train()
    {
        super.train();
        super.train();
    }

    /**
     * Alien goes to the doctor.
     */
    @Override
    public void toDoctor()
    {
        super.toDoctor();
        super.toDoctor();
    }

    /**
     * Alien is given bath
     */
    @Override
    public void giveBath()
    {
        super.giveBath();
        super.giveBath();
    }
}
