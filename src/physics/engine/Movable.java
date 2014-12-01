package physics.engine;

public abstract class Movable extends Renderable
{
    private double xSpeed = 0;
    private double ySpeed = 0;
    
    public Movable(double x, double y, String renderType)
    {
        super(x, y, renderType);
    }

    public void move()
    {
        double x = this.getX();
        double y = this.getY();
        double newX = x + this.xSpeed;
        double newY = y + this.ySpeed;
        this.setX(newX);
        this.setY(newY);
    }
    
    public void setXSpeed(double newXSpeed)
    {
        this.xSpeed = newXSpeed;
    }
    
    public void setYSpeed(double newYSpeed)
    {
        this.ySpeed = newYSpeed;
    }
    
    public double getXSpeed()
    {
        return this.xSpeed;
    }
    
    public double getYSpeed()
    {
        return this.ySpeed;
    }

    @Override
    public String toString()
    {
        return super.toString() +"\nMovable{" + "xSpeed=" + xSpeed + ", ySpeed=" + ySpeed + '}';
    }
}