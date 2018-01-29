package TeamActivity02;

public class Cruise implements Expense
{
    //property
    private Destination destination;

    Cruise(Destination dest)
    {
        destination = dest;
    }

    //override the method in Expense
    @Override
    public double getCost()
    {
        if (destination == Destination.Mexico)
        {
            return 1000;
        }
        else if (destination == Destination.Europe)
        {
            return 2000;
        }
        else
        {
            return 3000;
        }
    }
}