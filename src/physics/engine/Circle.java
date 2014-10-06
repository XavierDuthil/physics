package physics.engine;

public class Circle extends Point
{
    int diameter;
    
    public Circle(int x, int y, int diameter)
    {
        super(x, y);
        this.diameter = diameter;
    }
    
    public int getDiameter()
    {
        return diameter;
    }

    public void setHeight(int diameter)
    {
        this.diameter = diameter;
    }
}
