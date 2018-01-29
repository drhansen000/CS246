package prove02;

import java.awt.*;
import java.util.Random;

/**
 * Humans move in a direction, unless they spot an animal, in which case they go in the direction of the animal.
 * If they eat an animal they become full and can spawn babies. They can also kill wolves but take some damage.
 * Lastly, if they encounter a zombie, they are bitten and become a zombie. They are the orange circles.
 * @author  Daniel Hansen
 * @since   2018-01-22
 * @see Creature
 */

public class Human extends Creature implements Spawner, Movable, Morphable, Aggressor, Aware
{
    Random _rand = new Random();
    int _currentDirection;
    boolean _full;
    boolean _bitten;

    public Human()
    {
        _health = 5;
        _currentDirection = _rand.nextInt(4);
        _bitten = false;
        _full = false;
    }

    //The human can kill both animals and wolves, though he takes one damage from fighting the wolf
    //if he gets attacked by a Zombie, then he becomes one!
    @Override
    public void attack(Creature target)
    {
        if (target instanceof Wolf)
        {
            target.takeDamage(5);
            this.takeDamage(1);
        }
        if (target instanceof Animal)
        {
            target.takeDamage(5);
            _full = true;
        }
        if (target instanceof Zombie)
        {
            takeDamage(5);
            _bitten = true;
        }
        else
        {
            _bitten = false;
        }
    }

    @Override
    Shape getShape()
    {
        return Shape.Circle;
    }

    @Override
    Color getColor()
    {
        return Color.orange;
    }

    @Override
    Boolean isAlive()
    {
        return _health > 0;
    }

    @Override
    public Creature changeType()
    {
        if (_bitten == true)
        {
            Zombie convert = new Zombie();
            return convert;
        }

        else
        {
            return null;
        }
    }

    @Override
    public void move()
    {
        switch (_currentDirection)
        {
            case 0:
                _location.x++;
                break;
            case 1:
                _location.x--;
                break;
            case 2:
                _location.y--;
                break;
            case 3:
                _location.y++;
                break;
            default:
                break;
        }
    }

    @Override
    public Creature spawnNewCreature()
    {
        if (_full == true)
        {
            Human baby = new Human();
            _full = false;
            return baby;
        }
        else
        {
            return null;
        }
    }

    @Override
    public void senseNeighbors(Creature above, Creature below, Creature left, Creature right)
    {
        if (_currentDirection == 0)
        {
            if (right instanceof Animal)
            {
                _currentDirection = 0;
            }
            else if (above instanceof Animal)
            {
                _currentDirection = 2;
            }
            else if (below instanceof Animal)
            {
                _currentDirection = 3;
            }
            else if (left instanceof Animal)
            {
                _currentDirection = 1;
            }
        }
        else if (_currentDirection == 1)
        {
            if (left instanceof Animal)
            {
                _currentDirection = 1;
            }
            else if (above instanceof Animal)
            {
                _currentDirection = 2;
            }
            else if (right instanceof Animal)
            {
                _currentDirection = 0;
            }
            else if (below instanceof Animal)
            {
                _currentDirection = 3;
            }
        }
        else if (_currentDirection == 2)
        {
            if (above instanceof Animal)
            {
                _currentDirection = 2;
            }
            else if (right instanceof Animal)
            {
                _currentDirection = 0;
            }
            else if (below instanceof Animal)
            {
                _currentDirection = 3;
            }
            else if (left instanceof Animal)
            {
                _currentDirection = 1;
            }
        }
        else if (_currentDirection == 3)
        {
            if (below instanceof Animal)
            {
                _currentDirection = 3;
            }
            else if (above instanceof Animal)
            {
                _currentDirection = 2;
            }
            else if (right instanceof Animal)
            {
                _currentDirection = 0;
            }
            else if (left instanceof Animal)
            {
                _currentDirection = 1;
            }
        }
    }
}
