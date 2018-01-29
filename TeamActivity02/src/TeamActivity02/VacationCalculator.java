package TeamActivity02;

import java.util.ArrayList;
import java.util.List;

public class VacationCalculator
{

    public static void main(String[] args)
    {
        VacationCalculator vc = new VacationCalculator();

        // Calculate some vacation costs...
        float mexicoCost = vc.calculateVacationCost(Destination.Mexico, 5);
        float europeCost = vc.calculateVacationCost(Destination.Europe, 5);
        float japanCost  = vc.calculateVacationCost(Destination.Japan, 5);

        // Print the cost...
        System.out.print("Total cost for Mexico is: $");
        System.out.format("%.2f%n", mexicoCost); //%.2f is 2-d float, %n is endl.
        System.out.print("Total cost for Europe is: $");
        System.out.format("%.2f%n", europeCost); //%.2f is 2-d float, %n is endl.
        System.out.print("Total cost for Japan is: $");
        System.out.format("%.2f%n", japanCost); //%.2f is 2-d float, %n is endl.

    }

    /**
     * Calculates the total cost for vacationing at a given location for
     * a specific number of nights.
     *
     * @param  dest the destination of the vacation
     * @return      the total cost of the vacation
     */
    public float calculateVacationCost(Destination dest, int nights)
    {
        ArrayList<Expense> expenseList = new ArrayList<Expense>();
        Cruise  cruise  = new Cruise(dest);
        Lodging lodging = new Lodging(dest, nights);
        Dining  dining  = new Dining(dest, nights);
        expenseList.add(cruise);
        expenseList.add(dining);
        expenseList.add(lodging);
        return tallyExpenses(expenseList);
    }

    /**
     * An internal method used by VacationCalculator to loop through
     * a List of items that implement the Expense interface and
     * determine their cost
     *
     * @param  expenseList A list of items that implement the Expense interface
     * @return          the total cost calculated by the items
     */
    float tallyExpenses(List<Expense> expenseList)
    {
        float total = 0;

        for (Expense expense : expenseList)
        {
            total += expense.getCost();
        }

        return total;
    }
}
