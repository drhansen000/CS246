package prove02;

import java.awt.*;
import java.util.Random;

/**
 * Wolves move in a direction, unless they spot an animal, in which case they go in the direction of the animal.
 * If they eat an animal they become full and can spawn baby cubs. They are the gray squares.
 * @author  Daniel Hansen
 * @since   2018-01-22
 * @see Creature
 */

public class Wolf extends Creature implements Movable, Aggressor, Aware, Spawner
{
    //properties
    Random  _rand = new Random();
    int     _currentDirection;
    boolean _full;

    //default constructor
    public Wolf()
    {
        _health   = 1;
        _full = false;
        _currentDirection = _rand.nextInt(4);
    }

    //Aggressor interface method, if it attacks an animal it becomes full
    @Override
    public void attack(Creature target)
    {
        if (target instanceof Animal)
        {
            target.takeDamage(5);
            _full = true;
        }
        else
        {
            _full = false;
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
        return Color.gray;
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
        switch (_currentDirection)
        {
            case 0:
                _location.x++;
                break;
            case 1:
                _location.x--;
                break;
            case 2:
                _location.y++;
                break;
            case 3:
                _location.y--;
                break;
            default:
                break;
        }
    }

    //Aware interface method, first checks for animals in its current direction, then it looks for them clockwise,
    //starting from the top.
    @Override
    public void senseNeighbors(Creature above, Creature below, Creature left, Creature right)
    {
        if (_currentDirection == 0)
        {
            if (right instanceof Animal && right != null)
            {
                _currentDirection = 0;
            }
            else if (above instanceof Animal && above != null)
            {
                _currentDirection = 2;
            }
            else if (below instanceof Animal && below != null)
            {
                _currentDirection = 3;
            }
            else if (left instanceof Animal && left != null)
            {
                _currentDirection = 1;
            }
        }
        else if (_currentDirection == 1)
        {
            if (left instanceof Animal && left != null)
            {
                _currentDirection = 1;
            }
            else if (above instanceof Animal && above != null)
            {
                _currentDirection = 2;
            }
            else if (right instanceof Animal && right != null)
            {
                _currentDirection = 0;
            }
            else if (below instanceof Animal && below != null)
            {
                _currentDirection = 3;
            }
        }
        else if (_currentDirection == 2)
        {
            if (above instanceof Animal && above != null)
            {
                _currentDirection = 2;
            }
            else if (right instanceof Animal && right != null)
            {
                _currentDirection = 0;
            }
            else if (below instanceof Animal && below != null)
            {
                _currentDirection = 3;
            }
            else if (left instanceof Animal && left != null)
            {
                _currentDirection = 1;
            }
        }
        else if (_currentDirection == 3)
        {
            if (below instanceof Animal && below != null)
            {
                _currentDirection = 3;
            }
            else if (above instanceof Animal && above != null)
            {
                _currentDirection = 2;
            }
            else if (right instanceof Animal && right != null)
            {
                _currentDirection = 0;
            }
            else if (left instanceof Animal && left != null)
            {
                _currentDirection = 1;
            }
        }
    }

    //Spawner interface method
    @Override
    public Creature spawnNewCreature()
    {
        if (_full == true)
        {
            Wolf cub = new Wolf();
            _full = false;
            return cub;
        }
        else
        {
            return null;
        }
    }
}
