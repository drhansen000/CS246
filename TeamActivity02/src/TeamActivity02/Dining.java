package TeamActivity02;

public class Dining implements Expense
{
    //properties
    private Destination dest;
    private int nights;

    //non-default constructor
    Dining(Destination dest, int nights)
    {
        this.dest = dest;
        this.nights = nights;
    }

    //override the method in Expense
    @Override
    public double getCost()
    {
        if (dest == Destination.Mexico)
        {
            return nights * 10;
        }
        else if (dest == Destination.Europe)
        {
            return nights * 20;
        }
        else
        {
            return nights * 30;
        }
    }
}
