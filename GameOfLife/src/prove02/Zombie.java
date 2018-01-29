package prove02;

import java.awt.*;

/**
 * Zombies move from left to right and attack all creatures that are not plants. To see how they affect humans, go
 * to human source code. They are the blue squares.
 * @author  Daniel Hansen
 * @since   2018-01-22
 * @see Creature
 */

public class Zombie extends Creature implements Movable, Aggressor
{

    //Default constructor
    public Zombie()
    {
        _health = 10;
    }

    //Aggressor interface method
    @Override
    public void attack(Creature target)
    {
        if (target instanceof Animal || target instanceof Wolf)
        {
            target.takeDamage(10);
            return;
        }
    }

    //Creature class, abstract methods
    @Override
    Shape getShape()
    {
        return Shape.Square;
    }

    @Override
    Color getColor()
    {
        return Color.blue;
    }

    @Override
    Boolean isAlive()
    {
        return _health > 0;
    }

    //Movable interface method
    @Override
    public void move()
    {
        _location.x++;
    }
}
