package TeamActivity02;

public class Lodging implements Expense
{
    //properties
    private Destination dest;
    private int nights;

    //non-default constructor
    Lodging(Destination dest, int nights)
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
            return nights * 100;
        }
        else if (dest == Destination.Europe)
        {
            return (nights * 200) + ((nights * 200) * .1);
        }
        else
        {
            return (nights * 300) + ((nights * 300) * .3);
        }
    }
}
