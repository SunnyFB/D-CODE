package Tagagatchi.src;
/**
 * Rock is a subclass of Pet. The pet rock only has happiness.
 */
public class Rock extends Pet
{
    
    /**
     * Constructor for Rock
     * @param happiness measures the happiness of the pet rock
     */
    public Rock(double happiness)
    {
        super(10,10,happiness,10,10,10);
    }

    /**
     * no parameter constructor of Rock
     */
    public Rock()
    {
        super();
    }

    /**
         * @return Rock's happiness drain rate
         */
        @Override
        public double happinessDrain()
        {
            return 0.05;
        }

    /**
         * @return Rock's fullness drain rate
         */
        @Override
        public double fullnessDrain()
        {
            return 0;
        }

    /**
     * @return Rock's energy drain rate
     */
    @Override
    public double energyDrain()
    {
        return 0;
    }

    /**
     * @return Rock's energy drain rate
     */
    @Override
    public double hygieneDrain()
    {
        return 0;
    }


    /**
     * Rock's version of walk
     */
    @Override
    public void walk()
    {
        super.setHappiness(super.getHappiness() + 1);
        super.boundValues();
    }

    /**
     * Rock's version of play
     */
    @Override
    public void play()
    {
        super.setHappiness(super.getHappiness() + 2);
        super.boundValues();
    }

    /**
     * Rock's version of taking to doctor
     */
    @Override
    public void toDoctor()
    {
        super.setHappiness(super.getHappiness() - 1);
        super.boundValues();
    }

    /**
     * rock's version on training
     */
    @Override
    public void train()
    {
        super.setHappiness(super.getHappiness()+1);
        super.boundValues();
    }

}