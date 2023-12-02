package org.advent.day2;

public class Bag extends Grab {
    public Bag(int red, int green, int blue)
    {
        super(red, green, blue);
    }

    public Bag()
    {
        super(0, 0, 0);
    }

    public void SetCountByColour(Colour colour,int count)
    {
        cubes.put(colour,count);
    }


    public boolean CheckGrab(Grab grab)
    {
        for (Colour colour : Colour.values()) {
            if(this.GetCountByColour(colour) < grab.GetCountByColour(colour))
            {
                return false;
            }
        }
        return true;
    }

    int PowerOfCubes()
    {
        int power=1;
        for (Colour colour: Colour.values()) {
            power *= GetCountByColour(colour);

        }
        return power;
    }
}
