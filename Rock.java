public class Rock extends Pet
{
    /**
     * a subclass of Pet. The pet rock only has happiness.
     */

    public Rock(int happiness)
    {
        super(10,10,happiness,10,10);
    }

    public Rock()
    {
        super();
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