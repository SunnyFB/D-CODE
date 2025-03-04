public class Rock extends Pet
{
    /**
     * Rock is a subclass of Pet. The pet rock only has happiness.
     */
    public Rock(double happiness)
    {
        super(10,10,happiness,10,10);
    }

    public Rock()
    {
        super();
    }

    /**
     * Rock's happiness drain rate
     */
    public double happinessDrain()
    {
        return 0.05;
    }

    /**
     * Rock's fullness drain rate
     */
    public double fullnessDrain()
    {
        return 0;
    }

    /**
     * Rock's energy drain rate
     */
    public double energyDrain()
    {
        return 0;
    }

    /**
     * Rock's version of walk
     */
    public void walk()
    {
        super.setHappiness(super.getHappiness() + 1);
        super.boundValues();
    }

    /**
     * rock's version of play
     */
    public void play()
    {
        super.setHappiness(super.getHappiness() + 2);
        super.boundValues();
    }

    /**
     * rock's version of taking to doctor
     */
    public void toDoctor()
    {
        super.setHappiness(super.getHappiness() - 1);
        super.boundValues();
    }

    /**
     * rock's version on training
     */
    public void train()
    {
        super.setHappiness(super.getHappiness()+1);
        super.boundValues();
    }

}