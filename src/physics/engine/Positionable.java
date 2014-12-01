package physics.engine;

public abstract class Positionable
{
    private double x;
    private double y;
    private double direction;
    private double speed;
    
    // First constructor : only coordinates, no movement.
    public Positionable(double x, double y)
    {
        this.x = x;
        this.y = y;
        this.direction = 0;
        this.speed = 0;
    }
    
    // Second constructor : enter coordinates, direction and speed
    public Positionable(double x, double y, double direction, double speed)
    {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.speed = speed;
    }
    
    public void setPosition(double newX, double newY)
    {
        this.x = newX;
        this.y = newY;
    }
    
    public double getX()
    {
        return x;
    }

    public void setX(double x)
    {
        this.x = x;
    }

    public double getY()
    {
        return y;
    }

    public void setY(double y)
    {
        this.y = y;
    }

    @Override
    public String toString()
    {
        return super.toString() +"\nPositionable{" + "x=" + x + ", y=" + y + ", direction=" + direction + ", speed=" + speed + '}';
    }
}
