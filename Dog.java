public class Dog extends Pet
{
    /**
     * Dog is a subclass of Pet. 
     * Dogs need more attention, and get less happiness from certain things.
     */
    public Dog(double fullness,double weight, double happiness,double energy,double health)
    {
        super(fullness,weight,happiness,energy,health);
    }

    public Dog()
    {
        super();
    }

    /**
     * Dog's version of walk.
     * Dogs gain less happiness from walk.
     */
    public void walk()
    {
        super.setHappiness(super.getHappiness() - 0.5);
        super.walk();
    }

    /**
     * Dog's version of play.
     * Dogs gain less happiness from play.
     */
    public void play()
    {
        super.setHappiness(super.getHappiness() - 1);
        super.play();
    }

    /**
     * Dog's version of train.
     * Dog's gain less happiness from train.
     */
    public void train()
    {
        super.setHappiness(super.getHappiness() - 0.5);
        super.train();

    }

    /**
     * Dog's version of going to the doctor.
     * Dogs get slightly more upset from going to the doctor.
     */
    public void toDoctor()
    {
        super.setHappiness(super.getHappiness() - 0.5);
        super.toDoctor();
    }
}
