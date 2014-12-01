package physics.engine;

public class Rectangle extends Movable
{
    private double height;
    private double width;
    
    public Rectangle(double x, double y, double height, double width)
    {
        super(x, y, "rectangle");
        this.height = height;
        this.width = width;
    }
    
    public Rectangle(Rectangle clone)
    {
        super(clone.getX(), clone.getY(), clone.getRenderType());
        this.height = clone.getHeight();
        this.height = clone.getWidth();
    }
    
    public double getHeight()
    {
        return this.height;
    }

    public void setHeight(int height)
    {
        this.height = height;
    }

    public double getWidth()
    {
        return this.width;
    }

    public void setWidth(int width)
    {
        this.width = width;
    }
}
