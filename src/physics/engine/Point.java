package physics.engine;

public class Point
{
    private double x;
    private double y;
    private double direction;
    private double speed;
    
    // First constructor : only coordinates, no movement.
    public Point(int x, int y)
    {
        this.x = x;
        this.y = y;
        this.direction = 0;
        this.speed = 0;
    }
    
    // Second constructor : enter coordinates, direction and speed
    public Point(int x, int y, double direction, double speed)
    {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.speed = speed;
    }
    
    public void setPosition(int newX, int newY)
    {
        this.x = newX;
        this.y = newY;
    }
    
    public void move(int toRight, int toBottom)
    {
       this.x += toRight;
       this.y += toBottom;
    }
    
    public double getX()
    {
        return x;
    }

    public void setX(int x)
    {
        this.x = x;
    }

    public double getY()
    {
        return y;
    }

    public void setY(int y)
    {
        this.y = y;
    }
}
